public class BuiltIn {
    public static Dictionary<string, Action<object[]>> builtInFunctions = new Dictionary<string, Action<object[]>> {
        ["print"] = (object[] @params) => {
            foreach (var item in @params) {
                Console.Write(item);
            }
        }
    };
    public static Dictionary<string, object> builtInValues = new Dictionary<string, object> {
        ["pi"] = 0
    };
}