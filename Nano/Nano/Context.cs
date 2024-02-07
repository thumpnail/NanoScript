public partial class Interpreter {
    public class Context {
        public static Stack<NanoType> lastReturn = new(), lastValue = new();

        public static List<Tuple<TokenType, string>> tokens = new();
        public static Dictionary<string, List<Tuple<TokenType, string>>> functions = new();

        public class Scope {
            public static int cScope = 0;
            private static List<Dictionary<string, NanoType>> scope = new() { new() { ["TRE"] = NanoValue.boolTrue, ["FLE"] = NanoValue.boolFalse } };
            public static Dictionary<string, int> lableLookup = new();//Lable + Position
            public static Dictionary<string, string[]> functionLookup = new(); //Contains info about functions
                                                                               //TODO: Find Something better then <int>
                                                                               //Is used to 
            public static Stack<int> CallStack = new();//from where the current function is called

            public static NanoType GetValue(string name) {
                if (ValueExist(name)) return ScopeLookup(name);
                throw new Exception("The value you are looking for does not exist...");
            }

            public static void SetValue(string name, NanoType nanoValue) {
                if (!scope[cScope].ContainsKey(name))
                    throw new Exception("The value you are looking for does not exist...");

                int scopeIndex = -1;
                for (int i = scope.Count - 1; i >= 0; i--) {
                    scopeIndex = i;
                    if (scope[i].ContainsKey(name)) {
                        break;
                    }
                }

                scope[scopeIndex][name] = nanoValue;
            }

            public static void CreateValue(string name, NanoType nanoValue) {
                Hlp.DbgLog(from: "Scope.CreateValue", msg: $"Name: {name} | Value: {Hlp.DUMP(nanoValue)}", color: ConsoleColor.Green);
                
                if (!scope[cScope].ContainsKey(name))
                    scope[cScope].Add(name, nanoValue);
                else
                    SetValue(name, nanoValue);
                printScope();
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
                foreach (var item in @params) {
                    if (item is int || item is float || item is string) values.Add(NanoType.CreateNanoType(item));
                    //else if (item is NanoArray) Console.WriteLine(Hlp.DUMP(item));
                    //else if (item is NanoTable) Console.WriteLine(Hlp.DUMP(item));
                }
                return values.ToArray();
            }

            public static void CreateScope() {
                Hlp.DbgLog("Interpreter.Context.Scope.CreateScope", "Creating Scope", ConsoleColor.Green);
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
                Hlp.DbgLog(from: "Scope.ResolveParameterMap", msg: $"@params: {Hlp.DUMP(@params)} paraTokens: {Hlp.DUMP(paraTokens)}");
                //RefferenceMap
                var list = new List<Tuple<TokenType, string>>();
                for (int i = 0; i < @params.Length; i++) {
                    list.Add(new(paraTokens[i], @params[i]));
                }

                //remove all seperate parts and insert Path from PathResolver
                var path = BuiltIn.PathResolver(@params);
                var path_tk = list[0].Item1;
                if (list.Count > 1) {
                    for (int i = 0; i < path.Item2; i++) {
                        list.RemoveAt(0);
                    }
                    list.Insert(0,new(path_tk, path.Item1));
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
                Hlp.DbgLog(from: "\tScope.ResolveParameterMap", msg: $"@params: {Hlp.DUMP(paraList)} paraTokens: {Hlp.DUMP(tokenList)}");
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
                Hlp.DbgLog(msg: Hlp.DUMP(functionLookup), ConsoleColor.Red);
                Hlp.DbgLog(msg: $"LastReturn: {Hlp.DUMP(lastReturn)}||LastValue: {Hlp.DUMP(lastValue)}", ConsoleColor.Red);
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
            if (isStatic) { //def
                return new NanoValue(true, TokenType.t_bool, false);
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
                value = Context.Evaluate(list, isEditable);
            } else if (!isCalc && isArr && isLogic) {
                value = Context.Evaluate(list, isEditable);
            } else {
                value = new NanoValue(list.Item2[0], list.Item1[0], isEditable);
            }
            return value;
        }
        public static TokenType GuessType(object value) {
            if (int.TryParse(value.ToString(), out _)) {
                return TokenType.t_int;
            } else if (float.TryParse(value.ToString(), out _)) {
                return TokenType.t_float;
            } else if (bool.TryParse(value.ToString(), out _) || value == "True" || value == "False") {
                return TokenType.t_bool;
            } else if (char.TryParse(value.ToString(), out _)) {
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
        //FIXME: convert into a stack based expression evaluator
        public static NanoValue Evaluate(Tuple<List<TokenType>, List<string>> list, bool isEditable = false) {
            Hlp.DbgLog(from: "Context.Evaluate", msg: $"in: {Hlp.DUMP(list)}", ConsoleColor.Blue);
            //TODO Add String Workaround
            int i = 0, pass = 0;
            List<string> raw = list.Item2;
            while (raw.Count > 1) {
                if (pass > 6) {
                    break;
                }
                if (i + 1 == raw.Count) { i = 0; pass++; }
                if (raw[i + 1] == "(" && pass == 0) {

                } else if (raw[i + 1] == ")" && pass == 0) {

                } else if (raw[i + 1] == "*" && pass == 1) {
                    try {
                        raw[i] = (int.Parse(raw[i]) * int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) * float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "/" && pass == 1) {
                    try {
                        raw[i] = (int.Parse(raw[i]) / int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) / float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "+" && pass == 2) {
                    try {
                        raw[i] = (int.Parse(raw[i]) + int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) + float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "-" && pass == 2) {
                    try {
                        raw[i] = (int.Parse(raw[i]) - int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
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
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) > float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "LES" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) < int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) < float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "EQL" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) == int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) == float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "LEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) <= int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) <= float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "GEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) >= int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) >= float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                } else if (raw[i + 1] == "NEQ" && pass == 3) {
                    try {
                        raw[i] = (int.Parse(raw[i]) != int.Parse(raw[i + 2])).ToString();
                    } catch (FormatException) {
                        raw[i] = (float.Parse(raw[i].Replace('.', ',')) != float.Parse(raw[i + 2].Replace('.', ','))).ToString();
                    }
                    raw.RemoveAt(i + 2);
                    raw.RemoveAt(i + 1);
                    i = 0;
                }
                i++;
            }
            Hlp.DbgLog(from: "Context.Evaluate", msg: $"out: {(object)raw[0]} as {GuessType((object)raw[0])}", ConsoleColor.Blue);
            return new NanoValue((object)raw[0], GuessType((object)raw[0]), isEditable);
        }
    }
}
