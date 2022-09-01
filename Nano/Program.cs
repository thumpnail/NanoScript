using BetterConsoleTables;

public class Program {
    public static void Main(string[] args) {
#if DEBUG
        StreamReader sr = new StreamReader(@".\..\..\..\simpletest.nano");
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        List<Tuple<TokenType, string>> tokens = Lexer.LexIt(words);

#elif RELEASE
        if (args.Count() == 0) return;
        StreamReader sr = new StreamReader(args[0].ToString());
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        List<Tuple<TokenType, string>> tokens = Lexer.LexIt(words);
#elif TEST
        string[] testFiles = { "cll.nano", "let.nano"};
        List<Tuple<TokenType, string>> tokens = new();
        foreach (var item in testFiles) {
            StreamReader sr = new StreamReader(@".\..\..\..\test\" + item);
            List<string> scriptLines = new List<string>();
            string line = "";
            while ((line = sr.ReadLine()) is not null) {
                scriptLines.Add(line);
            }
            scriptLines.Add("\n");
            sr.Close();

            List<string> words = Lexer.preprocessor(scriptLines.ToArray());
            tokens = Lexer.LexIt(words);

            Interpreter interpreter = new();
            interpreter.Execute(tokens);
            Interpreter.Context.Scope.printScope();
        }
#endif

#if DEBUG
        {
            Table t = new("Idx", "Token", "Value");
            t.Config = TableConfiguration.Unicode();
            int idx = 0;
            foreach (var item in tokens) {
                if (item.Item2.Equals("\n")) {
                    //t.AddRow(idx++, item.Item1, "NEWLINE");
                } else
                    t.AddRow(idx++, item.Item1, item.Item2);
            }
            Console.WriteLine(t.ToString());
        }
#endif
#if RELEASE || DEBUG
        Interpreter interpreter = new();
        interpreter.Execute(tokens);
        Interpreter.Context.Scope.printScope();
#endif
    }
}