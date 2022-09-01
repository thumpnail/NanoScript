public class Interpreter {
    public static class Context {
        public static NanoType lastReturn, lastValue;
        public static Dictionary<string, int> jumpMap;
        public static class Scope {
            static int cScope = 0;
            private static List<Dictionary<string, NanoType>> scope = new List<Dictionary<string, NanoType>>() { new() };
            public static Dictionary<string, int> lableLookup = new Dictionary<string, int>();
            
            public static NanoType GetValue(string name) {
                if (ValueExist(name)) return ScopeLookup(name);
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
            
            public static void CloneValue(string name) { 
                throw new NotImplementedException(); 
            }

            public static void CreateLable(string lable, int ip) {
                if (!Context.Scope.lableLookup.ContainsKey(lable)) {
                    Context.Scope.lableLookup.Add(lable, ip);
                } else throw new("Lable Allready Exist");
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
            
            public static void CreateGlobal(string name, NanoType value) {
                if (ValueExist(name)) return;
                scope[0].Add(name, value);
            }

            public static void SetValue() { }

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
                    }
                }
                throw new Exception("The value you are looking for does not exist...");
            }

            public static object ResolveRef(string name) {
                var value = ScopeLookup(name);
                return value.GetValue();
            }
            
            public static object? ResolveFnc(string name, object[] @params) {
                return null;
            }
            
            public static Tuple<List<TokenType>, List<string>> ResolveParameterMap(string[] @params, TokenType[] paraTokens) {
                //RefferenceMap
                var list = new List<Tuple<TokenType, string>>();
                for (int i = 0; i < @params.Length; i++) {
                    list.Add(new(paraTokens[i], @params[i]));
                }

                //remove " and func name
                list.RemoveAll(x => x.Item2.Equals("\""));
                list.RemoveAll(x => x.Item2.Equals("\'"));

                //remove all seperate parts and insert Path from PathResolver
                var path = BuiltIn.PathResolver(@params);
                var path_tk = list[0].Item1;
                for (int i = 0; i < path.Item2; i++) {
                    list.RemoveAt(0);
                }

                //Editables
                var tokenList = new List<TokenType>();
                var paraList = new List<string>();

                foreach (var item in list) {
                    tokenList.Add(item.Item1);
                    paraList.Add(item.Item2);
                }
                //resolve refference
                for (int i = 0; i < paraList.Count; i++) {
                    if (tokenList[i].Equals(TokenType.k_refference)) {
                        paraList[i] = Context.Scope.ResolveRef(paraList[i]).ToString() is null ? "null" : Context.Scope.ResolveRef(paraList[i]).ToString();
                        tokenList[i] = Context.GuessType(paraList[i]);
                    }
                }
                return new(tokenList, paraList);
            }

            public static void printScope() {
#if DEBUG || TEST
                BetterConsoleTables. Table t = new("Id","Idx", "Name", "Type", "Value", "Dump");
                t.Config = BetterConsoleTables.TableConfiguration.Unicode();
                int idx = 0;
                for (int i = 0; i < scope.Count; i++) {
                    foreach (var item2 in scope[i]) {
                        t.AddRow(idx++, i, item2.Key, item2.Value.GetType() + ":" + item2.Value.type, item2.Value.ToString(), Helper.DUMP(item2));
                    }
                }
                Console.WriteLine(t.ToString());
#endif
            }
        }
        
        public static NanoType CreateValue(Tuple<List<TokenType>, List<string>> list, bool isArr, bool isCalc, bool isEditable = true, bool isStatic = false) {
            NanoType value;
            if (isStatic) {
                return new NanoValue(true, TokenType.t_bool, isEditable);
            }
            if (isArr && !isCalc) {
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
            } else if (isCalc && isArr) {
                //TODO solve Calculation
                value = Context.Evaluate(list);
            } else {
                value = new NanoValue(list.Item2[0], list.Item1[0], isEditable);
            }
            return value;
        }
        
        public static TokenType GuessType(object value) {
            if (value is int) {
                return TokenType.t_int;
            } else if (value is float) {
                return TokenType.t_float;
            } else if (value is bool) {
                return TokenType.t_bool;
            } else if (value is char) {
                return TokenType.t_char;
            } else if (value is string) {
                return TokenType.t_string;
            } else if (value is NanoValue) {
                return GuessType(((NanoValue)value).GetValue());
            } else if (value is NanoArray) {
                return TokenType.t_array;
            } else if (value is null) {
                return TokenType.t_nil;
            } else {
                return TokenType.Unkown;
            }
        }

        public static NanoValue Evaluate(Tuple<List<TokenType>, List<string>> list) {
            int i = 0, pass = 0;
            List<string> raw = list.Item2;
            while (raw.Count > 1) {
                if (i+1 == raw.Count) { i = 0; pass++; }
                if (raw[i + 1] == "(" && pass == 0) {

                } else if (raw[i + 1] == ")" && pass == 0) {
                    
                } else if (raw[i + 1] == "*" && pass == 1) {
                    try {
                        raw[i] = (int.Parse(raw[i]) * int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) * float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "/" && pass == 1) {
                    try {
                        raw[i] = (int.Parse(raw[i]) / int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.',',')) / float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "+" && pass == 2) {
                    try {
                        raw[i] = (int.Parse(raw[i]) + int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) + float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "-" && pass == 2) {
                    try {
                        raw[i] = (int.Parse(raw[i]) - int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) - float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                }
                i++;
            }
            return new NanoValue((object)raw[0], GuessType((object)raw[0]));
        }
    }
    private Dictionary<TokenType, Action<TokenType[], string[]>> executeMap = new Dictionary<TokenType, Action<TokenType[], string[]>> {
        [TokenType.k_iff] = (TokenType[] paraTokens, string[] @params) => { 
            //Recursive
        },
        [TokenType.k_nif] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_elf] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_els] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_whl] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_jmp] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
            if (Context.Scope.lableLookup.ContainsKey(@params[0])) {
                Console.WriteLine("Jumping");
                //set jump
                IP = Context.Scope.lableLookup[@params[0]];
            } else {
                Console.WriteLine("Searching");
                //is in lable search
                isSearchMode = true;
                JP = OP-1;//safe current op
            }
        },
        [TokenType.k_for] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_ext] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive

            //Scoop Up Scope
        },
        [TokenType.k_ret] = (TokenType[] paraTokens, string[] @params) => {
            //REM if 1 parameter, use lastReturn, if > 1 use parameter
            //var list = Context.Scope.ResolveParameterMap(@params, paraTokens);

            //Console.WriteLine(Helper.DUMP(list));

            //Scoop Up Scope
        },
        [TokenType.k_get] = (TokenType[] paraTokens, string[] @params) => {
            
        },
        [TokenType.k_set] = (TokenType[] paraTokens, string[] @params) => {
            
        },
        [TokenType.k_err] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_fnc] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_tbl] = (TokenType[] paraTokens, string[] @params) => {
            
        },
        [TokenType.k_pck] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_let] = (TokenType[] paraTokens, string[] @params) => {
            var letname = @params[0];
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            bool isArr = list.Item2.Count > 2;
            bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));

            var value = Context.CreateValue(list, isArr, isCalc, false);

            Context.Scope.CreateValue(letname, value);
        },
        [TokenType.k_var] = (TokenType[] paraTokens, string[] @params) => {
            var letname = @params[0];
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            bool isArr = list.Item2.Count > 2;
            bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));

            var value = Context.CreateValue(list, isArr, isCalc);

            Context.Scope.CreateValue(letname, value);
        },
        [TokenType.f_cll] = (TokenType[] paraTokens, string[] @params) => {
            //TODO If not BuiltIn -> Look in scope
            //TODO Transmited array are not correct
            var path = BuiltIn.PathResolver(@params);
            var funcname = path.Item1;

            for (int i = 0; i < path.Item2; i++) {
                paraTokens[i] = TokenType.k_identifier;
            }

            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);

            //Array converts to String "0" // Resolved: object returns "0" // for fix need to find the correct type in Helper.DUMP()
            BuiltIn.builtInFunctions[funcname](list.Item2.ToArray());
        },
        [TokenType.f_crt] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_cpy] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_inc] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_cnv] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.f_def] = (TokenType[] paraTokens, string[] @params) => {
            var letname = @params[0];
            bool isStatic = @params.Length == 0;
            if (!isStatic) {
                var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
                bool isArr = list.Item2.Count > 2;
                bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));

                var value = Context.CreateValue(list, isArr, isCalc, false, isStatic);

                Context.Scope.CreateGlobal(letname, value);
            } else Context.Scope.CreateGlobal(letname, new NanoValue(true, TokenType.t_bool));
        },
        [TokenType.o_colon] = (TokenType[] paraTokens, string[] @params) => {
            Context.Scope.CreateLable(@params[0], IP);
        },
        [TokenType.o_tilde] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.EOL] = (TokenType[] paraTokens, string[] @params) => { },//?
        [TokenType.EOF] = (TokenType[] paraTokens, string[] @params) => { },//?
    };

    private static int IP = 0,JP = 0,OP = 0;
    private static bool isSearchMode = false, isLableFound = false;
    public int Execute(List<Tuple<TokenType, string>> tokens) {
        List<TokenType> tokenSequence;
        List<string> parameterSequence;
        TokenType opCode;
        for (IP = 0; IP < tokens.Count; IP++) {
            tokenSequence = new List<TokenType>();
            parameterSequence = new List<string>();

            OP = IP;
            opCode = tokens[IP++].Item1;
            
            while (IP < tokens.Count && tokens[IP].Item1 != TokenType.EOL) {
                tokenSequence.Add(tokens[IP].Item1);
                parameterSequence.Add(tokens[IP++].Item2);
            }

            if (opCode == TokenType.k_fnc && isSearchMode) {
                //TODO create function
            }

            if (opCode == TokenType.o_colon && isSearchMode) {
                isSearchMode = false;
                executeMap[opCode](tokenSequence.ToArray(), parameterSequence.ToArray());
                IP = JP;
                continue;
            }

            if (!isSearchMode) {
                executeMap[opCode](tokenSequence.ToArray(), parameterSequence.ToArray());
            }
        }
        Console.Write("\n");
        return 0x00000000;
    }
}