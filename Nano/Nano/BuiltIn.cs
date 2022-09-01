public class BuiltIn {
    //takes a Parameterlist and returns only the path for builtins
    public static Tuple<string, int> PathResolver(string[] @params) {
        string final = "";
        int step = 0;
        final += @params[step++];
        while (true) {
            if (@params[step] != "." & (step % 2) == 1) {
                break;
            }
            final += @params[step++];
        }
        return new(final, step);
    }
    public static Dictionary<string, Action<object[]>> builtInFunctions = new Dictionary<string, Action<object[]>> {
        ["core.print"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.Write(item.ToString());
            }
        },
        ["core.println"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.WriteLine(item.ToString());
            }
        },
        ["core.dump"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.WriteLine(Helper.DUMP(item));
            }
        },
    };
    public static Dictionary<string, object> builtInValues = new Dictionary<string, object> {
        ["math.pi"] = 0
    };
}