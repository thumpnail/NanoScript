module main

const(
	op_init = 0x00
 	op_db = 0x01
 	op_db_str = 0x02
 	op_db_fnc = 0x03
	op_db_end = 0x0f
 	op_main = 0x10

 	op_add = 0x20
 	op_sub = 0x21

 	op_set = 0x30
 	op_call_par = 0x03
 	op_call = 0x04
)

fn main() {
	prgm := [
		u32(op_init),
			64, // Mem Size for storing varibles
			64, // Parameter Stack Size
		op_db,
			op_db_str,
				0x0000, 7, u32(`S`), u32(`c`), u32(`h`), u32(`n`), u32(`e`), u32(`e`), u32(`\0`), //DB_STR_0000
				0x0001, 12,u32(`H`), u32(`e`), u32(`l`), u32(`l`), u32(`o`), u32(` `), u32(`W`), u32(`o`), u32(`r`), u32(`l`), u32(`d`), u32(`\0`), //DB_STR_0001
			op_db_fnc,
				0x0001, 				//DB_FNC_func
				0x0002,					//DB_FNC_func2
		op_db_end,
		op_main,					//main
			op_add, 12, 23,				// tmp = 12 + 23
			op_set, 0x0000,				// var0 = tmp
			op_add, 0x0000, 12, 23,		// var0 = 12 + 23
			op_call_par, 12,			// par0 = 12
			op_call_par, 0x80000000,	// par1 = DB_STR_0000
			op_call_par, 0x80000001,	// par2 = DB_STR_0001
			op_call, 0x0001,			// func1()
			op_set, 0x0001,				// var1 = ret0
			op_call_par, 12,			// par0 = 12
			op_call_par, 0x80000000,	// par1 = DB_STR_0000
			op_call_par, 0x80000001,	// par2 = DB_STR_0001
			op_call, 0x0002,			// func2()
			op_set, 0x0002,				// var2 = ret0
	]
	print(prgm)
}