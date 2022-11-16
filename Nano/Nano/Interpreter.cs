public partial class Interpreter {
    
    private static Dictionary<TokenType, Action<TokenType[], string[]>> executeMap = new Dictionary<TokenType, Action<TokenType[], string[]>> {
        [TokenType.k_iff] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
            _isIf = true;
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            Hlp.DbgLog(msg: Hlp.DUMP(list), from: "iff");
            bool.TryParse(Context.Evaluate(list).GetValue().ToString(), out bool evalout);
            if (evalout || list.Item1.Count == 1 && list.Item1[0] == TokenType.t_bool && (list.Item2[0] == "True" || list.Item2[0] == "1")) {
                //Context.Scope.CreateScope();
                Hlp.DbgLog(from: "iff", msg: "Entering iff");
            } else {
                _isIfOvertake = true;
                Hlp.DbgLog(from:"iff", msg:"overtaking iff");
            }
            Context.Scope.CreateScope();
        },
        [TokenType.k_elf] = (TokenType[] paraTokens, string[] @params) => {
            if (!_isIf) {
                return;
            }
            _isIfOvertake = false;
            Context.Scope.ClearScope();
            Context.Scope.CreateScope();
            //Recursive
            var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
            if (list.Item1.Count == 1 && list.Item1[0] == TokenType.t_bool && (list.Item2[0] == "True" || list.Item2[0] != "0" || list.Item2[0] != "nil")) {
                Context.Scope.CreateScope();
                Hlp.DbgLog(msg: Hlp.DUMP(list), from: "elf");
            } else {
                _isIfOvertake = true;
            }
        },
        [TokenType.k_els] = (TokenType[] paraTokens, string[] @params) => {
            if (!_isIf) {
                return;
            }
            _isIfOvertake = false;
            //TODO ignore parameter
            Context.Scope.ClearScope();
            Context.Scope.CreateScope();
            //Recursive
            if (!_isIf) {
                return;
            }
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
                _isLableSearchMode = true;
                execStack.Peek.JP = execStack.Peek.OP;//safe current op
            }
        },
        [TokenType.k_for] = (TokenType[] paraTokens, string[] @params) => {
            //Recursive
        },
        [TokenType.k_ext] = (TokenType[] paraTokens, string[] @params) => {
            if ((_isIf) && (!_isIfOvertake)) {
                Context.Scope.ClearScope();
            }
            if (_isFor && !_isForOvertake) {
                Context.Scope.ClearScope();
            }
            if (_isWhile && !_isWhileOvertake) {
                Context.Scope.ClearScope();
            }

            _isIf = false; 
            _isIfOvertake = false;
        },
        [TokenType.k_ret] = (TokenType[] paraTokens, string[] @params) => {
            if (paraTokens.Length != 0 && @params.Length != 0) {
                var list = Context.Scope.ResolveParameterMap(@params, paraTokens);
                Context.lastReturn.Push(list.Item2.Count >= 1
                    ? Context.Evaluate(list, true)
                    : NanoType.CreateNanoType(list.Item2[0] as object));
            }
            Context.Scope.printScope();
            Context.Scope.ClearScope();
        },
        [TokenType.k_get] = (TokenType[] paraTokens, string[] @params) => {
            //TODO: mby for return
        },
        [TokenType.k_set] = (TokenType[] paraTokens, string[] @params) => {
            Hlp.DbgLog("Interpreter.executeMap.k_set", $"LastReturn:{Hlp.DUMP(Context.lastReturn)}||Params:{Hlp.DUMP(@params)}", ConsoleColor.Magenta);
            if (@params.Length == 1) {
                Context.Scope.CreateValue(@params[0], Context.lastReturn.Pop());
            } else if (@params.Length > 1) {
                var letname = @params[0];

                var tmparr = @params.ToList();
                tmparr.RemoveAt(0);
                @params = tmparr.ToArray();

                var tmparr2 = paraTokens.ToList();
                tmparr2.RemoveAt(0);
                paraTokens = tmparr2.ToArray();

                var list = Context.Scope.ResolveParameterMap(@params, paraTokens);

                bool isArr = list.Item2.Count > 2;
                bool isCalc = isArr && (Lexer.StringContains(list.Item2[1], "+-*/()".ToArray()) || Lexer.StringContains(list.Item2[0], "+-*/()".ToArray()));
                bool isLogic = isArr && (Lexer.StringContains(list.Item2[1], new[] { "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }) || Lexer.StringContains(list.Item2[0], new[] { "AND", "OR", "GRT", "LES", "EQL", "LEQ", "GEQ" }));

                var value = Context.CreateValue(list, isArr, isCalc, isLogic, true);
                Context.Scope.SetValue(letname, value);
            }
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

            var value = Context.CreateValue(list, isArr, isCalc, isLogic, true);

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

            if (list.Item1[0] == TokenType.k_identifier) {
                list.Item1.RemoveAt(0);
                list.Item2.RemoveAt(0);
            }

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
        [TokenType.EOL] = (TokenType[] paraTokens, string[] @params) => { }, //?
        [TokenType.EOF] = (TokenType[] paraTokens, string[] @params) => { }, //?
    };

    //private static int IP = 0, JP = 0, OP = 0, LC = 0;//IP: Instruction Pointer, JP: Jump Pointer, OP: OpCode(Operation) Pointer, FP: Call Pointer(mby FP for Function Pointer)
    private static bool _isLableSearchMode = false;
    private static bool _isIf = false, _isIfOvertake = false;
    private static bool _isFor = false, _isForOvertake = false;
    private static bool _isWhile = false, _isWhileOvertake = false;


    public int Execute() {
        //Console.WriteLine(Hlp.DUMP(Context.functions));
        //get functions
        //Console.WriteLine(Hlp.DUMP(Context.Scope.functionLookup));

        int result = Execute(Context.tokens);
        Console.Write("\n");
        return result;
    }
    static EStack<ExecCache> execStack = new();
    public static int Execute(List<Tuple<TokenType, string>> tokens) {
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

            if (opCode == TokenType.o_colon && _isLableSearchMode) {
                _isLableSearchMode = false;
                executeMap[opCode](tokenSequence.ToArray(), parameterSequence.ToArray());
                execStack.Peek.IP = execStack.Peek.JP;
                continue;
            }

            if (_isIf) {
                if (opCode == TokenType.k_ext) {
                    _isIfOvertake = false; // TODO: Why
                }
                if (_isIfOvertake) {
                    continue;
                }
            }

            if ((!_isLableSearchMode)) {
                Hlp.DbgLog(from: "Execute", msg: $"{opCode}:{Hlp.DUMP(parameterSequence)}", ConsoleColor.Cyan);
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
        private int lc = 0; //lable counter
        private int ip = 0; //istruction pointer
        private int jp = 0; //jumpPointer
        private int op = 0; //operation pointer
        private int fp = 0; //for pointer //inactive
        private int wp = 0; //while pointer

        public ExecCache() {
            IP = 0; 
            JP = 0; 
            OP = 0; 
            LC = 0;
            FP = 0;
            WP = 0;
        }

        public int IP { get => ip; set => ip = value; }
        public int JP { get => jp; set => jp = value; }
        public int OP { get => op; set => op = value; }
        public int LC { get => lc; set => lc = value; }
        public int FP { get => fp; set => fp = value; }
        public int WP { get => wp; set => wp = value; }
    }
}
