public static class Helper {
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
}