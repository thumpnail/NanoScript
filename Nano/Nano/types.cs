public interface NanoType {
    public int id { get; set; }
    public TokenType type { get; set; }
    public bool isEditable { get; }

    object? GetValue();
    object? GetValue(string index);
    void SetValue(object value);
    void SetValue(string index, object value);
    string ToString();
}
public struct NanoValue : NanoType {
    public int id { get; set; }
    public TokenType type { get; set; }
    public bool isEditable { get; private set; }

    object? Value { get; set; }

    public NanoValue(object? Value, TokenType Type, bool isEditable = false) {
        this.id = IDManager.GetId();
        this.type = Type;
        this.Value = Value;
        this.isEditable = isEditable;
        this.Value = FixType(Value);
    }

    public object? GetValue() {
        if (Value is int) {
            return (int)Value;
        } else if (Value is float) {
            return (float)Value;
        } else if (Value is char) {
            return (char)Value;
        } else if (Value is string) {
            return (string)Value;
        } else if (Value is null) {
            return null;
        } else if (Value is bool) {
            return (bool)Value;
        } else {
            return Value;
        }
    }
    public void SetValue(object value) {
        if (isEditable) this.Value = FixType(value);
        else throw new Exception("NanoValue is not Editable");
    }
    public override string? ToString() {
        return Value is null ? "null" : Value.ToString();
    }

    //Returns an Object in the Correct Type
    private object FixType(object value) {
        int i;
        float f;
        bool b;
        if (int.TryParse(value.ToString().Replace('.', ','), out i)) {
            type = TokenType.t_int;
            return i;
        } else if (float.TryParse(value.ToString().Replace('.', ','), out f)) {
            type = TokenType.t_float;
            return f;
        } else if (bool.TryParse(value.ToString().Replace('.', ','), out b)) {
            type = TokenType.t_bool;
            return b;
        }
        return value;
    }

    public object? GetValue(string index) {
        throw new("Go fuck yourself, THAT IS NOT INDEXABLE");
    }

    public void SetValue(string index, object value) {
        throw new("Go fuck yourself, THAT IS NOT INDEXABLE");
    }
}

public struct NanoArray : NanoType {
    public int id { get; set; }
    public TokenType type { get; set; }
    public bool isEditable { get; private set; }

    int count { get => Value.Count; }
    List<NanoValue> Value;

    public NanoArray(NanoValue[] arr, bool isEditable = false) {
        this.id = IDManager.GetId();
        this.Value = arr.ToList();
        this.type = TokenType.t_array;
        this.isEditable = isEditable;
    }

    public object? GetValue() {
        //TODO Return object Array
        List<object> final = new();
        foreach (var item in Value) {
            final.Add(item.GetValue());
        }
        return final.ToArray();
    }
    public void SetValue() { }

    public void SetValue(object value) {
        Value.Add(new(value, Interpreter.Context.GuessType(value), true));
    }

    public override string? ToString() {
        string final = "[";
        foreach (var item in Value) {
            final += item.ToString() + ",";
        }
        final += "]";
        return final;
    }

    public object? GetValue(string index) {
        int idx;
        if (int.TryParse(index, out idx)) {
            return Value[idx];
        } else throw new("Out of bounds you stupid fuck");
    }

    public void SetValue(string index, object value) {
        int idx;
        if (int.TryParse(index, out idx)) {
            Value.Insert(idx, new NanoValue(value, Interpreter.Context.GuessType(value), true));
        } else throw new("how about you give me a Number next time");
    }
}

public struct NanoTable : NanoType {
    public int id { get; set; }
    public TokenType type { get; set; }

    public bool isEditable { get; private set; }

    Dictionary<string, NanoType> Value;

    public NanoTable(Dictionary<int,string> indexes, NanoType[] values, bool isEditable = true) {
        this.isEditable = isEditable;
        type = TokenType.k_tbl;
        id = IDManager.GetId();
        Value = new Dictionary<string, NanoType>();
        if (indexes.Count == values.Count())
            for (int i = 0; i < values.Length; i++) {
                Value.Add(indexes[i], values[i]);
            }
        else throw new("Shit Aint Working");
    }

    private object FixType(object value) {
        throw new NotImplementedException();
    }

    public object? GetValue() {
        throw new NotImplementedException();
    }

    public void SetValue(object value) {
        if (isEditable) this.Value.Add(Value.Count.ToString(), new NanoValue(value, Interpreter.Context.GuessType(value), true));
        else throw new Exception("NanoValue is not Editable");
    }

    public object? GetValue(string index) {
        if (Value.ContainsKey(index)) {
            return Value[index];
        }
        throw new("Check your fax m8");
    }

    public void SetValue(string index, object value) {
        if (!Value.ContainsKey(index)) {
            Value[index].SetValue(value);
        } else {
            Value.Add(index, new NanoValue(value, Interpreter.Context.GuessType(value), true));
        }
        throw new("Check your fax m8");
    }

    public override string? ToString() {
        string final = "{";
        foreach (var item in Value) {
            final += item.ToString();
        }
        return final+"}";
    }
}

class IDManager {
    public static int currentId = 0;
    private static List<int> regestry = new List<int>();
    public static int GetId() {
        regestry.Add(currentId);
        return currentId++;
    }
    public static void RemoveId(int id) {

    }
}

struct TNano {
    private object? value;//Int,Float,Bool,String,NanoValue,NanoArray,NanoTable
    public TokenType internalType { get; private set; }

    public TNano() { this.value = new Object();internalType = TokenType.Unkown; }
    public TNano(string val) { this.value = val; internalType = TokenType.t_string; }
    public TNano(int val) { this.value = val; internalType = TokenType.t_int; }
    public TNano(float val) { this.value = val; internalType = TokenType.t_float; }
    public TNano(bool val) { this.value = val; internalType = TokenType.t_bool; }

    public int asInt() { return (int)value; }
    public float asFloat() { return (float)value; }
    public bool asBool() { return (bool)value; }

    public void setIntValue(int value) { }
    public void setFloatValue(float value) { }
    public void setBoolValue(bool value) { }
}