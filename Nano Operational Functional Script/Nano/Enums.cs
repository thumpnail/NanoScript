﻿public enum TokenType {
    Unkown,

    k_identifier, k_refference,

    t_int,
    t_float,
    t_string,
    t_char,
    t_charArray,
    t_array,
    t_nil,
    t_bool,

    s_bracketOpen,
    s_bracketClose,

    k_iff,
    k_nif,
    k_elf,
    k_els,
    k_whl,
    k_jmp,
    k_for,

    k_ext,
    k_ret,
    k_set,
    k_err,

    k_fnc,
    k_tbl,
    k_pck,

    k_let,
    k_var,
    k_cst,


    f_cll,
    f_crt,
    f_cpy,
    f_inc,
    f_cnv,
    f_def,

    l_AND,
    l_OR,
    l_GRT,
    l_LES,
    l_EQL,
    l_LEQ,
    l_GEQ,

    b_FAL,
    b_TRU,

    o_dot,
    o_comma,

    o_tilde,
    o_colon,
    o_questionmark,
    o_plus,
    o_doubleplus,
    o_minus,
    o_doubleminus,
    o_multiply,
    o_divide,
    o_doublePlus,
    o_doubleMinus,
    o_doubleColon,
    o_doubleRight,
    o_right,
    o_left,
    o_doubleLeft,
    o_comment,
    EOF = -1,
    EOL = 72,
}