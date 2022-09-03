public static class Hlp {
    public static string DUMP(object obj) {
        //return System.Text.Json.JsonSerializer.Serialize(obj, obj.GetType(), new System.Text.Json.JsonSerializerOptions() { });
        if (obj is int) return Newtonsoft.Json.JsonConvert.SerializeObject((int)obj);
        if (obj is float) return Newtonsoft.Json.JsonConvert.SerializeObject((float)obj);
        if (obj is bool) return Newtonsoft.Json.JsonConvert.SerializeObject((bool)obj);
        if (obj is string) return Newtonsoft.Json.JsonConvert.SerializeObject((string)obj);
        if (obj is NanoValue) return Newtonsoft.Json.JsonConvert.SerializeObject(((NanoValue)obj).GetValue());
        if (obj is NanoArray) return Newtonsoft.Json.JsonConvert.SerializeObject(((NanoArray)obj).GetValue());
        if (obj is NanoTable) return Newtonsoft.Json.JsonConvert.SerializeObject(((NanoTable)obj).GetValue());
        return Newtonsoft.Json.JsonConvert.SerializeObject(obj);
    }
    public static void DbgLog(object msg) {
#if DEBUG
        DbgLog("System", msg, ConsoleColor.Yellow);
#endif
    }
    public static void DbgLog(object msg, ConsoleColor color) {
#if DEBUG
        DbgLog("System", msg, color);
#endif
    }
    public static void DbgLog(string from, object msg) {
#if DEBUG
        DbgLog(from, msg, ConsoleColor.Yellow);
#endif
    }
    public static void DbgLog(string from, object msg, ConsoleColor color) {
#if DEBUG
        ConsoleColor @default = Console.ForegroundColor;
        Console.ForegroundColor = color;
        Console.WriteLine($"[{from}||{DateTime.Now.ToString("fff")}]>>> {msg}");
        Console.ForegroundColor = @default;
#endif
    }
}
public struct EStack<T> {
    private List<T> values;
    public int Count { get => values.Count; }

    public EStack() {
        values = new();
    }

    public void Push(T t) {
        values.Add(t);
    }
    public T Pop() {
        T value = values[values.Count - 1];
        values.RemoveAt(values.Count - 1);
        return value;
    }
    public T Peek { get => values[Count - 1]; set => values[Count - 1] = value; }
    public List<T> getValues { get => values; }
}