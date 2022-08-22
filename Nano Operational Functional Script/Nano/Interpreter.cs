public class Interpreter {
    public static class Context {
        public static NanoType lastReturn;
        public static class Scope {
            static int cScope = 0;
            private static List<Dictionary<string, NanoType>> scope = new List<Dictionary<string, NanoType>>() { new() };
            
            public static NanoType GetValue(string name) {
                if (ValueExist(name))
                    return ScopeLookup(name);
                throw new Exception("The value you are looking for does not exist...");
            }
            
            public static void SetValue(string name, NanoType nanoValue) {
                if (!ValueExist(name))
                    scope[cScope].Add(name, nanoValue);
                else
                    throw new Exception("The value you are looking for does not exist...");
            }
            
            public static void CreateValue(string name, NanoType nanoValue) {
                scope[cScope].Add(name, nanoValue);
            }
            
            public static void ClearScope() {
                if (scope.Count == 1) return;
                scope.RemoveAt(scope.Count-1);
                cScope--;
            }
            
            public static void CreateScope() {
                scope.Add(new());
                cScope++;
            }
            
            public static void CreateGlobal() {

            }
            public static bool ValueExist(string valueName) {
                foreach (var subscope in scope) {
                    if (subscope.ContainsKey(valueName)) {
                        return true;
                    }
                }
                return false;
            }
            
            public static NanoType ScopeLookup(string name) {
                foreach (var item in scope) {
                    if (item.ContainsKey(name)) {
                        return item[name];
                        Console.WriteLine("found");
                    }
                }
                throw new Exception("The value you are looking for does not exist...");
            }

            //TODO find value and return inside type -> cll print name
            //                                                   |----| Get the underlying name
            public static object ResolveRef(string name) {
                //TODO get String
                //TODO get Int
                //TODO get Float
                //TODO usw
                var value = ScopeLookup(name);
                
                return value.GetValue();
            }
            public static object? ResolveFnc(string name, object[] @params) {
                return null;
            }
            //Removes '"' from a provided Tokenlist
            public static Tuple<List<TokenType>, List<string>> ResolveParameterMap(string[] @params, TokenType[] paraTokens) {
                //RefferenceMap
                var list = new List<Tuple<TokenType, string>>();
                for (int i = 0; i < @params.Length; i++) {
                    list.Add(new(paraTokens[i], @params[i]));
                }

                //remove " and func name
                list.RemoveAll(x => x.Item2.Equals("\""));
                list.RemoveAll(x => x.Item2.Equals("\'"));
                list.RemoveAt(0);

                //Editables
                var tokenList = new List<TokenType>();
                var paraList = new List<string>();

                foreach (var item in list) {
                    tokenList.Add(item.Item1);
                    paraList.Add(item.Item2);
                }
                return new(tokenList, paraList);
            }

            public static void printScope() {
                BetterConsoleTables. Table t = new("Idx", "Name", "Type", "Value");
                t.Config = BetterConsoleTables.TableConfiguration.Unicode();
                int idx = 0;
                foreach (var item1 in scope) {
                    foreach (var item2 in item1) {
                        t.AddRow(idx++, item2.Key, item2.Value.GetType(), item2.Value.ToString());
                    }
                }
                Console.WriteLine(t.ToString());
            }
        }
    }
    private Dictionary<TokenType, Action<TokenType[], string[]>> executeMap = new Dictionary<TokenType, Action<TokenType[], string[]>> {
        [TokenType.k_iff] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_nif] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_elf] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_els] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_whl] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_jmp] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_for] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_ext] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_ret] = (TokenType[] paraTokens, string[] @params) => {
            //TODO if 1 parameter, use lastReturn, if > 1 use parameter
        },
        [TokenType.k_set] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_err] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_fnc] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_sct] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_pck] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_let] = (TokenType[] paraTokens, string[] @params) => {
            bool isArr = @params.Length > 2 && !@params[1].Equals("\"");
            var letname = @params[0];

            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            NanoType value;
            if (isArr) {
                //TODO Implement Array
                List<NanoValue> nanoValues = new List<NanoValue>();
                for (int i = 0; i < list.Item2.Count; i++) {
                    switch (list.Item1[i]) {
                        case TokenType.Unkown:
                            break;
                        //case TokenType.k_identifier:
                            //break;
                        case TokenType.k_refference:
                            nanoValues.Add(new NanoValue(Context.Scope.ResolveRef(list.Item2[i]), list.Item1[i]));
                            break;
                        case TokenType.t_int:
                            nanoValues.Add(new NanoValue(int.Parse(list.Item2[i]), list.Item1[i]));
                            break;
                        case TokenType.t_float:
                            nanoValues.Add(new NanoValue(float.Parse(list.Item2[i]), list.Item1[i]));
                            break;
                        case TokenType.t_string:
                            nanoValues.Add(new NanoValue(list.Item2[i].ToString(), list.Item1[i]));
                            break;
                        case TokenType.t_char:
                            nanoValues.Add(new NanoValue(list.Item2[i], list.Item1[i]));
                            break;
                        case TokenType.t_charArray:
                            nanoValues.Add(new NanoValue(list.Item2[i].ToCharArray(), list.Item1[i]));
                            break;
                        case TokenType.t_nil:
                            nanoValues.Add(new NanoValue(null, list.Item1[i]));
                            break;
                        case TokenType.t_bool:
                            nanoValues.Add(new NanoValue(bool.Parse(list.Item2[i]), list.Item1[i]));
                            break;
                        default:
                            throw new Exception("Error while adding a value");
                    }
                }
                value = new NanoArray(nanoValues.ToArray());
            } else {
                value = new NanoValue(list.Item2[0], list.Item1[0]);
            }
            Context.Scope.CreateValue(letname, value);
        },
        [TokenType.k_var] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_cst] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_cll] = (TokenType[] paraTokens, string[] @params) => {
            //TODO: Resolve Refferences
            var funcname = @params[0];

            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);

            for (int i = 0; i < list.Item2.Count; i++) {
                if (list.Item1[i].Equals(TokenType.k_refference)) {
                    list.Item2[i] = Context.Scope.ResolveRef(list.Item2[i]).ToString() is null ? "null" : Context.Scope.ResolveRef(list.Item2[i]).ToString();
                }
            }

            //var varible = Context.Scope.ResolveRef(@params[2]);
            BuiltIn.builtInFunctions[funcname](list.Item2.ToArray());
        },
        [TokenType.f_crt] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_cpy] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_inc] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_cnv] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_def] = (TokenType[] paraTokens, string[] @params) => {
            
        },
        [TokenType.o_colon] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.EOL] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.EOF] = (TokenType[] paraTokens, string[] @params) => { },
    };

    

    public int Execute(List<Tuple<TokenType, string>> tokens) {
        List<TokenType> tokenSequence;
        List<string> parameterSequence;
        TokenType startToken;
        for (int ip = 0; ip < tokens.Count; ip++) {
            tokenSequence = new List<TokenType>();
            parameterSequence = new List<string>();

            startToken = tokens[ip++].Item1;
            if (startToken == TokenType.k_fnc) {
                //todo create function
            }
            if (startToken == TokenType.o_colon) {
                //todo create lable
            }
            while (ip < tokens.Count && tokens[ip].Item1 != TokenType.EOL) {
                tokenSequence.Add(tokens[ip].Item1);
                parameterSequence.Add(tokens[ip++].Item2);
            }
            executeMap[startToken](tokenSequence.ToArray(), parameterSequence.ToArray());
        }
        Console.Write("\n");
        return 0x00000000;
    }
}