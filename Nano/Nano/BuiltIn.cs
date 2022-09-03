public class BuiltIn {
    //takes a Parameterlist and returns only the path for builtins
    public static Tuple<string, int> PathResolver(string[] @params) {
        string final = "";
        int step = 0;
        final += @params[step++];
        while (step < @params.Length) {
            if ((@params[step] != "." || @params[step] != "::") && (step % 2) == 1) {
                break;
            }
            final += @params[step++];
        }
        return new(final, step);
    }
    public static Dictionary<string, Action<NanoType[]>> builtInFunctions = new Dictionary<string, Action<NanoType[]>> {
        ["print"] = (NanoType[] @params) => {
            foreach (var item in @params) {
                Console.Write(item.ToString());
            }
        },
        ["println"] = (NanoType[] @params) => {
            foreach (var item in @params) {
                Console.WriteLine(item.ToString());
            }
        },
        ["dump"] = (NanoType[] @params) => {
            foreach (var item in @params) {
                Console.WriteLine(Hlp.DUMP(item));
            }
        },
    };
    public static Dictionary<string, object> builtInValues = new Dictionary<string, object> {
        ["math.pi"] = 0
    };
}