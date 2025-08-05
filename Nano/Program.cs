using System.Diagnostics;
using BetterConsoleTables;

public class Program {
    static Stopwatch sw = new();
	static bool isDebug = false;
	public static void Main(string[] args) {
#if DEBUG
        StreamReader sr = new StreamReader(@"D:\fried\OneDrive\Dokumente\Code\VisualStudio\Nano Operational Functional Script\Nano\simpletest.nano");
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        Dictionary<string, List<Tuple<TokenType,string>>> tokens = Lexer.LexIt(words);

#elif RELEASE
        if (args.Count() == 0) return;
        if (args.Contains("-d")) {
            isDebug = true;
            sw = Stopwatch.StartNew();
            Console.WriteLine("Stopwatch Started");
        }
        StreamReader sr = new StreamReader(args[0].ToString());
        List<string> scriptLines = new List<string>();
        string line = "";
        while ((line = sr.ReadLine()) is not null) {
            scriptLines.Add(line);
        }
        scriptLines.Add("\n");
        sr.Close();

        List<string> words = Lexer.preprocessor(scriptLines.ToArray());
        Dictionary<string, List<Tuple<TokenType,string>>> tokens = Lexer.LexIt(words);
        
#elif TEST
        string[] testFiles = { "cll.nano", "let.nano"};
        foreach (var item in testFiles) {
            StreamReader sr = new StreamReader(@".\..\..\..\test\" + item);
            List<string> scriptLines = new List<string>();
            string line = "";
            while ((line = sr.ReadLine()) is not null) {
                scriptLines.Add(line);
            }
            scriptLines.Add("\n");
            sr.Close();

            var words = Lexer.preprocessor(scriptLines.ToArray());
            var tokens = Lexer.LexIt(words);

            Interpreter interpreter = new();
            int result = interpreter.SetTokens(tokens).Execute();
            Interpreter.Context.Scope.printScope();
        }
#endif

#if DEBUG
        {
            foreach (var routine in tokens) {
                Table t = new("Idx", "Token", "Value");
                t.Config = TableConfiguration.Unicode();
                int idx = 0;
                foreach (var item in routine.Value) {
                    if (item.Item2.Equals("\n")) {
                        //t.AddRow(idx++, item.Item1, "NEWLINE");
                    } else
                        t.AddRow(idx++, item.Item1, item.Item2);
                }
                Console.WriteLine(t.ToString());
            }
        }
        {
            foreach (var routine in tokens) {
                Console.WriteLine("||////////////////////////");
                Console.WriteLine("||"+routine.Key);
                Console.WriteLine("||////////////////////////");
                Table t = new("Idx", "Line");
                t.Config = TableConfiguration.Unicode();
                int idx = 0;
                string final = "";
                foreach (var word in routine.Value) {
                    final += word.Item2 + " ";
                    if (word.Item2.Equals("EOL")) {
                        t.AddRow(idx++, final);
                        final = "";
                    }
                }
                Console.WriteLine(t.ToString());
            }
        }
#endif
#if RELEASE || DEBUG || TEST
        Interpreter interpreter = new();
        int result = interpreter.SetTokens(tokens).Execute();
        Interpreter.Context.Scope.printScope();
#endif
		if (isDebug) {
			sw.Stop();
			Console.WriteLine($"Stopwatch Stopped with {sw.ElapsedMilliseconds} ms");
		}
    }
}