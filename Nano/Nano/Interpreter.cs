public class Interpreter {
    public class Context {
        public static NanoType lastReturn, lastValue;

        public static List<Tuple<TokenType, string>> tokens = new();
        public static Dictionary<string, List<Tuple<TokenType, string>>> functions = new();

        public class Scope {
            static int cScope = 0;
            private static List<Dictionary<string, NanoType>> scope = new() { new() };
            public static Dictionary<string, int> lableLookup = new();//Lable + Position
            public static Dictionary<string, string[]> functionLookup = new(); //Contains info about functions
            public static Stack<int> CallStack = new();//from where the current function is called

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

            public static void CreateFunction(string name, string[] parameterNames) {
                Hlp.DbgLog("Interpreter.Context.Scope.CreateFunction", $"Creating {name} with {Hlp.DUMP(parameterNames)}", ConsoleColor.Green);
                //TODO Add functions form functions Dictionary
            }

            public static void ClearScope() {
                Hlp.DbgLog("Interpreter.Context.Scope.ClearScope", "Clearing Scope", ConsoleColor.Red);
                if (scope.Count == 1) return;
                scope.RemoveAt(scope.Count - 1);
                cScope--;
            }

            public static void CallFunction(string name, object[] @params) {
                NanoType[] values = ResolveParameterValues(@params);

                Hlp.DbgLog("Interpreter.Context.Scope.CallFunction", $"Parameter:{Hlp.DUMP(@params)}");
                int funcPos = 0;
                if (BuiltIn.builtInFunctions.ContainsKey(name)) {
                    Hlp.DbgLog("Interpreter.Context.Scope.CallFunction", "Calling BuiltIn");

                    BuiltIn.builtInFunctions[name](values);

                } else if (functionLookup.ContainsKey(name)) {
                    if (functionLookup[name].Length != @params.Length) throw new("parameter count doesnt fit");
                    Hlp.DbgLog("Interpreter.Context.Scope.CallFunction", $"Calling User Defined: {name}");

                    CreateScope();
                    for (int i = 0; i < @params.Length; i++) {
                        CreateValue(functionLookup[name][i], values[i]);
                    }
                    Execute(functions[name]);
                } else {
                    throw new("function you try to call does not exist");
                }
            }

            private static NanoType[] ResolveParameterValues(object[] @params) {
                List<NanoType> values = new List<NanoType>();
                //TODO make Parameter Array and Table
                foreach (var item in @params) {
                    if (item is int || item is float || item is string) values.Add(NanoType.CreateNanoType(item));
                    //else if (item is NanoArray) Console.WriteLine(Hlp.DUMP(item));
                    //else if (item is NanoTable) Console.WriteLine(Hlp.DUMP(item));
                }
                return values.ToArray();
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
                for (int i = scope.Count - 1; i >= 0; i--) {
                    if (scope[i].ContainsKey(valueName)) {
                        return true;
                    }
                }
                return false;
            }

            public static NanoType ScopeLookup(string name) {
                for (int i = scope.Count - 1; i >= 0; i--) {
                    if (scope[i].ContainsKey(name)) {
                        return scope[i][name];
                    }
                }
                Context.Scope.printScope();
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

                //remove all seperate parts and insert Path from PathResolver
                var path = BuiltIn.PathResolver(@params);
                var path_tk = list[0].Item1;
                if (list.Count > 1)
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
                BetterConsoleTables.Table t = new("Id", "Idx", "Name", "Type", "Value", "Dump");
                t.Config = BetterConsoleTables.TableConfiguration.Unicode();
                int idx = 0;
                for (int i = 0; i < scope.Count; i++) {
                    foreach (var item2 in scope[i]) {
                        t.AddRow(idx++, i, item2.Key, item2.Value.GetType() + ":" + item2.Value.type, item2.Value.ToString(), Hlp.DUMP(item2));
                    }
                }
                Console.WriteLine(t.ToString());
                Hlp.DbgLog(msg:Hlp.DUMP(functionLookup), ConsoleColor.Red);
                Hlp.DbgLog(msg:$"LastReturn: {lastReturn}||LastValue: {lastValue}", ConsoleColor.Red);
#endif
            }
        }

        public static int SearchFuntion(string name) {
            for (int i = 0; i < tokens.Capacity; i++) {
                if (tokens[i].Item2 == name) {
                    return i - 1;
                }
            }
            return -1;
        }

        public static NanoType CreateValue(Tuple<List<TokenType>, List<string>> list, bool isArr, bool isCalc, bool isLogic, bool isEditable = true, bool isStatic = false) {
            NanoType value;
            if (isStatic) {
                return new NanoValue(true, TokenType.t_bool, isEditable);
            }
            if (isArr && !isCalc && !isLogic) {
                //TODO Implement Array
                List<NanoValue> nanoValues = new List<NanoValue>();
                for (int i = 0; i < list.Item2.Count; i++) {
                    switch (list.Item1[i]) {
                        case TokenType.unkown:
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
            } else if (isCalc && isArr && !isLogic) {
                value = Context.Evaluate(list);
            } else if (!isCalc && isArr && isLogic) {
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
                return TokenType.unkown;
            }
        }
        //Blackmagic shit and i still have no clue what the fuck is going on
        public static NanoValue Evaluate(Tuple<List<TokenType>, List<string>> list) {
            //TODO Add String Workaround
            int i = 0, pass = 0;
            List<string> raw = list.Item2;
            while (raw.Count > 1) {
                if (i + 1 == raw.Count) { i = 0; pass++; }
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
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) / float.Parse(raw[i + 2].Replace('.', ','))).ToString();
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
                } else if (raw[i + 1] == "AND" && pass == 4) {
                    raw[i] = (bool.Parse(raw[i]) && bool.Parse(raw[i + 2])).ToString();

                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "OR" && pass == 4) {
                    raw[i] = (bool.Parse(raw[i]) || bool.Parse(raw[i + 2])).ToString();

                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "GRT" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) > int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) > float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "LES" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) < int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) < float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "EQL" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) == int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) == float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "LEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) <= int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) <= float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "GEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) >= int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) >= float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "NEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) != int.Parse(raw[i + 2])).ToString();
                    } catch (InvalidCastException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) != float.Parse(raw[i + 2].Replace('.', ','))).ToString();
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
    private static Dictionary<TokenType, Action<TokenType[], string[]>> executeMap = new Dictionary<TokenType, Action<TokenType[], string[]>> {
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
                //set jump
                execStack.getValues[execStack.Count-1].IP = Context.Scope.lableLookup[@params[0]];
            } else {
                //is in lable search
                isLableSearchMode = true;
                execStack.Peek.JP = execStack.Peek.OP;//safe current op
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
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            Context.lastReturn = list.Item2.Count >= 1 ? Context.Evaluate(list) : NanoType.CreateNanoType(list.Item2[0] as object);
            Context.Scope.printScope();
            Context.Scope.ClearScope();
        },
        [TokenType.k_get] = (TokenType[] paraTokens, string[] @params) => {

        },
        [TokenType.k_set] = (TokenType[] paraTokens, string[] @params) => {
            Hlp.DbgLog("Interpreter.executeMap.k_set", $"LastReturn:{Context.lastReturn}||Params:{Hlp.DUMP(@params)}", ConsoleColor.Magenta);
            Context.Scope.CreateValue(@params[0], Context.lastReturn);
            //TODO more options
        },
        [TokenType.k_err] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_fnc] = (TokenType[] paraTokens, string[] @params) => {
            var path = BuiltIn.PathResolver(@params);
            var funcname = path.Item1;
             
        },
        [TokenType.k_tbl] = (TokenType[] paraTokens, string[] @params) => {

        },
        [TokenType.k_pck] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.k_let] = (TokenType[] paraTokens, string[] @params) => {

            var letname = @params[0];
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            bool isArr = list.Item2.Count > 2;
            bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));
            bool isLogic = isArr && (Lexer.StringContains(list.Item2[1], new[] { "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }) || Lexer.StringContains(list.Item2[0], new[] { "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }));

            var value = Context.CreateValue(list, isArr, isCalc, isLogic, false);

            Context.Scope.CreateValue(letname, value);
        },
        [TokenType.k_var] = (TokenType[] paraTokens, string[] @params) => {
            var letname = @params[0];
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            bool isArr = list.Item2.Count > 2;
            bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));
            bool isLogic = isArr && (Lexer.StringContains(list.Item2[1], new []{ "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }) || Lexer.StringContains(list.Item2[0], new []{ "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }));

            var value = Context.CreateValue(list, isArr, isCalc, isLogic);

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
            Context.Scope.CallFunction(funcname, list.Item2.ToArray());
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
            Context.Scope.CreateLable(@params[0], execStack.Peek.IP);
        },
        [TokenType.o_tilde] = (TokenType[] paraTokens, string[] @params) => { },
        [TokenType.EOL] = (TokenType[] paraTokens, string[] @params) => { },//?
        [TokenType.EOF] = (TokenType[] paraTokens, string[] @params) => { },//?
    };

    //private static int IP = 0, JP = 0, OP = 0, LC = 0;//IP: Instruction Pointer, JP: Jump Pointer, OP: OpCode(Operation) Pointer, FP: Call Pointer(mby FP for Function Pointer)
    private static bool isLableSearchMode = false;

    public int Execute() {
        //Console.WriteLine(Hlp.DUMP(Context.functions));
        //get functions
        //Console.WriteLine(Hlp.DUMP(Context.Scope.functionLookup));

        int result = Execute(Context.tokens);
        Console.Write("\n");
        return result;
    }
    static EStack<ExecCache> execStack = new();
    private static int Execute(List<Tuple<TokenType, string>> tokens) {
        List<TokenType> tokenSequence;
        List<string> parameterSequence;
        TokenType opCode;
        execStack.Push(new());
        execStack.Peek.LC = 0;
        for (execStack.Peek.IP = 0; execStack.Peek.IP < tokens.Count; execStack.Peek.IP++) {
            tokenSequence = new List<TokenType>();
            parameterSequence = new List<string>();

            execStack.Peek.OP = execStack.Peek.IP;
            opCode = tokens[execStack.Peek.IP++].Item1;

            while (execStack.Peek.IP < tokens.Count && tokens[execStack.Peek.IP].Item1 != TokenType.EOL) {
                tokenSequence.Add(tokens[execStack.Peek.IP].Item1);
                parameterSequence.Add(tokens[execStack.Peek.IP++].Item2);
            }
            execStack.Peek.LC++;
            Hlp.DbgLog(from: "Execute", msg: $"{opCode}:{Hlp.DUMP(parameterSequence)}", ConsoleColor.Cyan);

            if (opCode == TokenType.o_colon && isLableSearchMode) {
                isLableSearchMode = false;
                executeMap[opCode](tokenSequence.ToArray(), parameterSequence.ToArray());
                execStack.Peek.IP = execStack.Peek.JP;
                continue;
            }

            if ((!isLableSearchMode)) {
                executeMap[opCode](tokenSequence.ToArray(), parameterSequence.ToArray());
            }
        }
        //Hlp.DbgLog(msg: Hlp.DUMP(execStack.Peek));
        execStack.Pop();
        return 0x00000000;
    }
    public Interpreter SetTokens(Dictionary<string, List<Tuple<TokenType, string>>> tokens) {
        Context.tokens = tokens["Main"];
        foreach (var item in tokens) {
            if (item.Key != "Main") {
                Context.functions.Add(item.Key, item.Value);
                List<string> parameter = new();
                foreach (var pair in item.Value) {
                    if (pair.Item1 == TokenType.k_refference || pair.Item1 == TokenType.k_identifier) 
                        parameter.Add(pair.Item2);
                    if (pair.Item1 == TokenType.EOL) break;
                }
                Context.Scope.functionLookup.Add(item.Key, parameter.GetRange(1, parameter.Count-1).ToArray());
            }
        }
        return this;
    }
    public class ExecCache {
        private int lc = 0;
        private int ip = 0;
        private int jp = 0;
        private int op = 0;

        public ExecCache() {
            IP = 0; 
            JP = 0; 
            OP = 0; 
            LC = 0;
        }

        public int IP { get => ip; set => ip = value; }
        public int JP { get => jp; set => jp = value; }
        public int OP { get => op; set => op = value; }
        public int LC { get => lc; set => lc = value; }
    }
}