using BetterConsoleTables;

public class Program {
    public static void Main(string[] args) {
#if DEBUG
        StreamReader sr = new StreamReader(@".\simpletest.nano");
#elif RELEASE
        StreamReader sr = new StreamReader(args[0].ToString());
#endif
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        List<Tuple<TokenType, string>> tokens = Lexer.LexIt(words);

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
        Interpreter interpreter = new();
        interpreter.Execute(tokens);
        Interpreter.Context.Scope.printScope();
    }
}