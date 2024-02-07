[translated]
module main


[export:'prgm']
const (
	op_init = 1
	op_db = 2
	op_db_str = 3
	op_db_fnc = 4
	op_main = 5
	op_add = 6
	op_sub = 7
	op_set = 8
	op_call_par = 9
	op_call = 10
	prgm = [
		u32(op_init), 
			64, 
			64, 
		op_db, 
			op_db_str, 
				0, 7, `S`, `c`, `h`, `n`, `e`, `e`, `\0`, 
				1, 12, `H`, `e`, `l`, `l`, `o`, ` `, `W`, `o`, `r`, `l`, `d`, `\0`,
		op_db_fnc, 
			1, 2, 
		op_main, 
		op_add, 12, 23, 
		op_set, 0, 
		op_add, 0, 12, 23, 
			op_call_par, 12, 
			op_call_par, 2147483648, 
			op_call_par, 2147483649, 
		op_call, 1, 
		op_set, 1, 
			op_call_par, 12, 
			op_call_par, 2147483648, 
			op_call_par, 2147483649, 
		op_call, 2, 
		op_set, 2]!
)

struct Chunk { 
	pub mut:
	count int
	capacity int
	code &u32
}
fn (mut chunk Chunk) init_chunk()  {
	chunk.count = 0
	chunk.capacity = 0
	chunk.code = (voidptr(0))
}

fn (mut chunk Chunk) write_chunk(value u32)  {
}

struct NVM { 
	pub mut:
	name i8
	chunk Chunk
}
fn main()  {
	print(c'Hello NVM')
	vm := NVM(0)
	vm.chunk.code = prgm
	return 
}

fn nvm_execute(vm &NVM) int {
	C.printf(c'%d', vm.chunk.code)
	return 0
}

