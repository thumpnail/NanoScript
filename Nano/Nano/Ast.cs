public interface IStatement {
    void Init();
    int Execute();
    void Generate();
}
public struct Statement : IStatement {
    public void Init() {}
    public int Execute() { return 0;}
    public void Generate() {}
}
// iff SomeLogicalExpression
public struct If_Statement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
// elf SomeLogicalExpression
public struct IfElseStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
// els
public struct ElseStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct WhileStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct ForStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct FuncStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct StructStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct PackageStatement : IStatement {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
//==================================================================================
public interface IExpression {
    void Init();
    int Execute();
    void Generate();
}
public struct Logical_Expression : IExpression {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct Arethmetic_Expression : IExpression {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}
public struct Bitwise_Expression : IExpression {
    public void Init() { }

    public int Execute() { return 0; }

    public void Generate() { }
}

/*/
 * Declaration Statement
 *  let a 12
 *  fnc somefunction arg1 arg2
 *      ...
 *  ret
 * Labeled Statement
 *  :Lable
 * Expression Statement
 *  set arg1 arg2
 *  get arg1 arg2
 *  usw...
 * Selection Statement / Logical
 *  iff
 * Iteration Statement
 *  whl
 *  for
 * Compound Statements
 *  not
 * Jump Statements
 *  jmp lable
/*/