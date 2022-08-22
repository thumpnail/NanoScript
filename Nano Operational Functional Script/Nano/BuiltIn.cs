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
    public static readonly Dictionary<string, Action<object[]>> builtInFunctions = new Dictionary<string, Action<object[]>> {
        ["math.add"] = (object[] @params) => {
            NanoType value;
            if (@params[0] is int) {
                int ret = int.Parse(@params[0].ToString());
                for (int i = 1; i < @params.Length; i++) {
                    ret += int.Parse(@params[i].ToString());
                }
                
            }
        },
        ["math.sub"] = (object[] @params) => {
            object ret = @params[0];
            for (int i = 0; i < @params.Length; i++) {

            }
        },
        ["internal.print"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.Write(item);
            }
        },
        ["internal.println"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.WriteLine(item);
            }
        },
    };
    public static Dictionary<string, object> builtInValues = new Dictionary<string, object> {
        ["pi"] = 0
    };
}