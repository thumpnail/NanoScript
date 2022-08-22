using BetterConsoleTables;
public class Program {
    public static void Main() {
        StreamReader sr = new StreamReader("simpletest.nano");
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        List<Tuple<TokenType, string>> tokens = Lexer.LexIt(words);

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
        Interpreter interpreter = new();
        interpreter.Execute(tokens);
        Interpreter.Context.Scope.printScope();
    }
}