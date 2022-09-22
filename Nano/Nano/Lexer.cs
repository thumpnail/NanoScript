public class Lexer {
    public static char[] symbols = {
        ':', '"', '\'', '[', ']', '(', ')', '<','>', '?', '!', '+', '-', '*', '/', '.', ',', '#'
    };
    public static string[] keywords = {
        "iff", "nif", "elf", "els", "whl",
        "jmp", "for", "ext", "ret", "set",
        "err", "fnc", "sct", "pck", "let",
        "var", "cst", ":", "::", "?",
        "i8", "i16", "i32", "i64", "u8",
        "u16", "u32", "u64","flt", "dbl",
        "str", "chr", "~", "cll", "crt",
        "cpy", "inc", "cnv", "def", "AND",
        "OR", "GRT", "LES", "EQL", "LEQ",
        "GEQ", "FAL", "TRU" };
    public static string[] operators = {
        "+", "-", "*", "/", "<<", ">>", "<", ">", "%"
    };

    public static List<string> preprocessor(string[] scriptLines) {
        bool isComment = false, isString = false, isChar = false, isNumber = false;
        List<string> words = new();
        string word = "";

        foreach (var line in scriptLines) {
            word = "";
            for (int i = 0; i < line.Length; i++) {
                
                char c = line[i], next = ' ';
                if (i+1 < line.Length) next = line[i + 1];

                //string and chars
                if (isString || isChar) {
                    if (c != '\"') {
                        word += c;
                        continue;
                    }
                }
                if (c == '#' | isComment) {
                    isComment = true;
                    continue;
                }

                if ((c == '-' && ArrayContains(next, "1234567890.".ToArray()) || ArrayContains(c, "1234567890.".ToArray()))) {
                    word += c;
                    continue;
                }

                if (c == ' ') {
                    //whitespace
                    if (word != "") {
                        words.Add(word);
                        word = "";
                    }
                }

                if (ArrayContains(c, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".ToArray())) {
                    //word
                    word += c;
                }

                if (ArrayContains(c, symbols)) {
                    //other symbols
                    if (c == '\"') {
                        isString = !isString;
                    }
                    if (word != "") {
                        words.Add(word);
                        word = "";
                    }
                    word += c;
                    if (word != "") {
                        words.Add(word);
                        word = "";
                    }
                }

            }
            isComment = false;
            isString = false;
            isChar = false;
            if (word != "") {
                words.Add(word);
            }
            try {
                if (words[words.Count - 1] != "EOL") {
                    words.Add("EOL");
                }
            } catch (Exception) {}
        }
        words.Add("EOF");
#if DEBUG || TEST
        //foreach (var item in words) {
        //    Console.Write(item);

        //    Console.ForegroundColor = ConsoleColor.Green;
        //    Console.Write(" | ");
        //    Console.ForegroundColor = ConsoleColor.Gray;            
        //}
        //Console.WriteLine();
#endif
        return words;
    }
    private static bool ArrayContains(char c, char[] arr) {
        foreach (var item in arr)
            if (item == c) {
                return true;
            }
        return false;
    }
    public static Dictionary<string, TokenType> tokenLookup = new() {
        ["iff"] = TokenType.k_iff,
        ["nif"] = TokenType.k_nif,
        ["elf"] = TokenType.k_elf,
        ["els"] = TokenType.k_els,
        ["whl"] = TokenType.k_whl,
        ["jmp"] = TokenType.k_jmp,
        ["for"] = TokenType.k_for,
        ["ext"] = TokenType.k_ext,
        ["ret"] = TokenType.k_ret,
        ["set"] = TokenType.k_set,
        ["get"] = TokenType.k_get,
        ["err"] = TokenType.k_err,
        ["fnc"] = TokenType.k_fnc,
        ["tbl"] = TokenType.k_tbl,
        ["pck"] = TokenType.k_pck,
        ["let"] = TokenType.k_let,
        ["var"] = TokenType.k_var,
        [":"] = TokenType.o_colon,
        ["::"] = TokenType.o_doubleColon,
        ["?"] = TokenType.o_questionmark,
        ["i32"] = TokenType.t_int,
        ["flt"] = TokenType.t_float,
        ["str"] = TokenType.t_string,
        ["chr"] = TokenType.t_char,
        ["~"] = TokenType.o_tilde,
        ["cll"] = TokenType.f_cll,
        ["crt"] = TokenType.f_crt,
        ["cpy"] = TokenType.f_cpy,
        ["inc"] = TokenType.f_inc,
        ["cnv"] = TokenType.f_cnv,
        ["def"] = TokenType.f_def,
        ["AND"] = TokenType.l_AND,
        ["OR"] = TokenType.l_OR,
        ["GRT"] = TokenType.l_GRT,
        ["LES"] = TokenType.l_LES,
        ["EQL"] = TokenType.l_EQL,
        ["LEQ"] = TokenType.l_LEQ,
        ["GEQ"] = TokenType.l_GEQ,
        ["FAL"] = TokenType.b_FAL,
        ["TRU"] = TokenType.b_TRU
    };

    private static string funcName = "";

    public static Dictionary<string, List<Tuple<TokenType, string>>> LexIt(List<string> words) {
        Dictionary<string,List<Tuple<TokenType, string>>> final = new() { ["Main"] = new(){ }};
        Stack<string> stack = new();
        stack.Push("ROOT");
        bool insideStr = false, insideChar = false, insideComment = false;
        for (int i = 0; i < words.Count; i++) {
            TokenType token = TokenType.unkown;
            string str = words[i];

            //is digit
            if (StringContains(words[i], "-1234567890.".ToArray())) {
                token = TokenType.t_int;
            } else if (StringContains(words[i], "-1234567890.".ToArray())) {
                token = TokenType.t_float;
                if (!StringContains(words[i], "-1234567890".ToArray()))
                    token = TokenType.o_dot;
            } else {
                switch (words[i]) {
                    case "EOL": token = TokenType.EOL;
                        if (stack.Peek() == "fnc.ret") {
                            stack.Pop();
                            stack.Push("fnc.ret.eol");
                        }
                        break;
                    case "EOF": token = TokenType.EOF; break;
                    case "::": token = TokenType.o_doubleColon; break;
                    case "~": token = TokenType.o_tilde; break;

                    case "cll": token = TokenType.f_cll; break;
                    case "crt": token = TokenType.f_crt; break;
                    case "cpy": token = TokenType.f_cpy; break;
                    case "inc": token = TokenType.f_inc; break;
                    case "cnv": token = TokenType.f_cnv; break;
                    case "def": token = TokenType.f_def; break;

                    case "AND": token = TokenType.l_AND; break;
                    case "OR": token = TokenType.l_OR; break;
                    case "GRT": token = TokenType.l_GRT; break;
                    case "LES": token = TokenType.l_LES; break;
                    case "EQL": token = TokenType.l_EQL; break;
                    case "LEQ": token = TokenType.l_LEQ; break;
                    case "GEQ": token = TokenType.l_GEQ; break;
                    case "FAL": token = TokenType.b_FAL; break;
                    case "TRU": token = TokenType.b_TRU; break;

                    case "iff": token = TokenType.k_iff; break;
                    case "nif": token = TokenType.k_nif; break;
                    case "elf": token = TokenType.k_elf; break;
                    case "els": token = TokenType.k_els; break;
                    case "whl": token = TokenType.k_whl; break;
                    case "jmp": token = TokenType.k_jmp; break;
                    case "for": token = TokenType.k_for; break;
                    case "ext": token = TokenType.k_ext; break;
                    case "ret":
                        token = TokenType.k_ret;
                        if (stack.Peek() == "fnc") {
                            final[funcName].Add(new(token, words[i]));
                            stack.Pop();
                            stack.Push("fnc.ret");
                            continue;
                        }
                        break;
                    case "get": token = TokenType.k_get; break;
                    case "set": token = TokenType.k_set; break;
                    case "err": token = TokenType.k_err; break;
                    case "fnc":
                        token = TokenType.k_fnc;
                        stack.Push("fnc");
                        funcName = words[i + 1];
                        if (words[i + 2] == "." || (words[i + 2] == ":" && words[i + 2] == ":")) { funcName += words[i + 2]; funcName += words[i + 3]; funcName += words[i + 4]; }
                        final.Add(funcName, new());
                        break;
                    case "tbl": token = TokenType.k_tbl; break;
                    case "pck": token = TokenType.k_pck; break;
                    case "let": token = TokenType.k_let; break;
                    case "var": token = TokenType.k_var; break;
                    //////////////////////////////////////////
                    case "i32": token = TokenType.t_int; break;
                    case "int": token = TokenType.t_int; break;
                    case "flt": token = TokenType.t_float; break;
                    case "str": token = TokenType.t_string; break;
                    case "chr": token = TokenType.t_char; break;
                    ////////////////////////////
                    case "NIL": token = TokenType.t_nil; break;
                    case "\'":
                        token = TokenType.t_char;
                        if (words[i + 2] != "\'") {
                            token = TokenType.t_charArray;
                        }
                        insideChar = !insideChar;
                        continue;
                    case "\"":
                        words.RemoveAt(i--);
                        token = TokenType.t_string;
                        insideStr = !insideStr;
                        continue;
                    case "(":
                        token = TokenType.s_rBracketOpen;
                        break;
                    case ")":
                        token = TokenType.s_rBracketClose;
                        break;
                    case "[":
                        token = TokenType.s_bracketOpen;
                        break;
                    case "]":
                        token = TokenType.s_bracketClose;
                        break;
                    case "&": token = TokenType.l_AND; break;
                    case "|": token = TokenType.l_OR; break;
                    case "?": token = TokenType.o_questionmark; break;
                    case "<":
                        token = TokenType.o_left;
                        if (words[i + 1] == "<") {
                            token = TokenType.o_doubleLeft;
                            str = "<<";
                            i++;
                        }
                        break;
                    case ">":
                        token = TokenType.o_right;
                        if (words[i + 1] == ">") {
                            token = TokenType.o_doubleRight;
                            str = ">>";
                            i++;
                        }
                        break;

                    case "+":
                        token = TokenType.o_plus;
                        if (words[i + 1] == "+") {
                            token = TokenType.o_doubleplus;
                            str = "++";
                            i++;
                        }
                        break;
                    case "-":
                        token = TokenType.o_minus;
                        if (words[i + 1] == "-") {
                            token = TokenType.o_doubleminus;
                            str = "--";
                            i++;
                        }
                        break;
                    case "*": token = TokenType.o_multiply; break;
                    case "/": token = TokenType.o_divide; break;
                    case ":":
                        token = TokenType.o_colon;
                        if (words[i + 1] == ":") {
                            token = TokenType.o_doubleColon;
                            str = "::";
                            i++;
                        }
                        break;
                    case ".": token = TokenType.o_dot; break;
                    case ",": token = TokenType.o_comma; break;
                    case "#":
                        token = TokenType.o_comment;
                        insideComment = !insideComment;
                        break;
                    default:
                        try {
                            if (words[i - 1] == "let" || words[i - 1] == "var") {
                                token = TokenType.k_identifier;
                            } else {
                                token = TokenType.k_refference;
                            }
                        } catch (Exception) {
                            token = TokenType.k_refference;
                        }
                        if (insideStr) {
                            token = TokenType.t_string;
                        }
                        if (insideChar) {
                            token = TokenType.t_char;
                        }
                        break;
                }
            }
            if (stack.Peek() == "fnc" || stack.Peek() == "fnc.ret" || stack.Peek() == "fnc.ret.eol") {
                final[funcName].Add(new(token, str));
                if(stack.Peek() == "fnc.ret.eol")stack.Pop();
            } else
                final["Main"].Add(new(token, str));
            str = "";
        }
        //commentfix
        insideComment = false;
        List<Tuple<TokenType, string>> remlist = new();
        foreach (var tlist in final) {
            foreach (var item in tlist.Value) {
                if (item.Item2.Contains("\n")) {
                    insideComment = false;
                } else if (item.Item2.Equals("\n")) {
                    remlist.Add(item);
                } else if (item.Item2 == "#") {
                    remlist.Add(item);
                    insideComment = true;
                } else if (insideComment) {
                    remlist.Add(item);
                }
            }
        }
        return final;
    }
    public static List<Tuple<TokenType, string>>? LexItV2(List<string> words) {
        return null;
    }
    public static bool StringContains(string src, char[] arr) {
        int check = 0;
        foreach (var item in src) {
            if (arr.Contains(item)) {
                check++;
            }
        }
        return check == src.Length;
    }
    public static bool StringContains(string src, string[] arr) {
        return arr.Contains(src);
    }
    public static bool StringEquals(string src, char[] arr) {
        int check = 0;
        foreach (var c in arr) {
            if (src.Equals(c)) {
                check++;
            }
        }
        return check == src.Length;
    }
}
