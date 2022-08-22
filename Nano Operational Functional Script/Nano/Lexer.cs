public class Lexer {
    public static char[] symbols = {
        ':', '"', '\'', '[', ']', '<','>', '?', '!', '+', '-', '*', '/', '.', ',', '#'
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
        bool isComment = false, isString = false, isChar = false;
        List<string> words = new();
        string word = "";

        foreach (var line in scriptLines) {
            word = "";
            foreach (var c in line) {
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

                if (ArrayContains(c, "1234567890".ToArray())) {
                    //number(float,int)
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
            if (words[words.Count-1] != "EOL") {
                words.Add("EOL");
            }
        }
        words.Add("EOF");
#if DEBUG
        foreach (var item in words) {
            Console.Write(item);

            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write(" | ");
            Console.ForegroundColor = ConsoleColor.Gray;            
        }
        Console.WriteLine();
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
        ["err"] = TokenType.k_err,
        ["fnc"] = TokenType.k_fnc,
        ["tbl"] = TokenType.k_tbl,
        ["pck"] = TokenType.k_pck,
        ["let"] = TokenType.k_let,
        ["var"] = TokenType.k_var,
        ["cst"] = TokenType.k_cst,
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
    public static List<Tuple<TokenType, string>> LexIt(List<string> words) {
        List<Tuple<TokenType, string>> final = new();
        Stack<string> stack = new();
        stack.Push("ROOT");
        bool insideStr = false, insideChar = false, insideComment = false;
        for (int i = 0; i < words.Count; i++) {
            TokenType token = TokenType.Unkown;
            string str = words[i];

            if (StringContains(words[i], "-1234567890".ToArray())) {
                token = TokenType.t_int;
            } else if (StringContains(words[i], "-1234567890.".ToArray())) {
                token = TokenType.t_float;
                if (!StringContains(words[i], "-1234567890".ToArray()))
                    token = TokenType.o_dot;
            } else {
                switch (words[i]) {
                    case "EOL": token = TokenType.EOL; break;
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
                    case "ret": token = TokenType.k_ret; break;
                    case "set": token = TokenType.k_set; break;
                    case "err": token = TokenType.k_err; break;
                    case "fnc": token = TokenType.k_fnc; break;
                    case "tbl": token = TokenType.k_tbl; break;
                    case "pck": token = TokenType.k_pck; break;
                    case "let": token = TokenType.k_let; break;
                    case "cst": token = TokenType.k_cst; break;
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
                        break;
                    case "\"":
                        token = TokenType.t_string;
                        insideStr = !insideStr;
                        break;
                    case "[":
                        token = TokenType.s_bracketOpen;
                        if (words[i - 1] == "=") {
                            stack.Push("inArray");
                            token = TokenType.t_array;
                        } else {
                            stack.Push("inBrackets");
                        }
                        break;
                    case "]":
                        token = TokenType.s_bracketClose;
                        stack.Pop();
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
                            if (words[i - 1] == "let") {
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

            final.Add(new(token, str));
            str = "";
        }
        //commentfix
        insideComment = false;
        List<Tuple<TokenType, string>> remlist = new();
        foreach (var item in final) {
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
        foreach (var item in remlist) {
            final.Remove(item);
        }
        return final;
    }
    public static List<Tuple<TokenType, string>>? LexItV2(List<string> words) {
        return null;
    }
    private static bool StringContains(string src, char[] arr) {
        int check = 0;
        foreach (var c in arr) {
            if (src.Contains(c)) {
                check++;
            }
        }
        return check == src.Length;
    }
    

}
