public static class Helper {
    public static string DUMP(object obj) {
        //return System.Text.Json.JsonSerializer.Serialize(obj, obj.GetType(), new System.Text.Json.JsonSerializerOptions() { });
        return Newtonsoft.Json.JsonConvert.SerializeObject(obj);
    }
}