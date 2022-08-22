public interface NanoType {
    public int id { get; set; }
    public TokenType type { get; set; }
    public bool isEditable { get; }

    object? GetValue();
    void SetValue(object value);
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
        if (isEditable) this.Value = value;
        else throw new Exception("NanoValue is not Editable");
    }
    public override string? ToString() {
        return Value is null ? "null" : Value.ToString();
    }

    //public static NanoValue operator +(NanoValue val1, NanoValue val2) {
    //    new NanoValue(val1.Value + val2.valu)
    //}
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

    public object GetValue() { 
        //TODO Return object Array
        return 0;
    }
    public void SetValue() { }

    public void SetValue(object value) {
        throw new NotImplementedException();
    }
    public override string? ToString() {
        string final = "[";
        foreach (var item in Value) {
            final += item.ToString() + ",";
        }
        final += "]";
        return final;
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