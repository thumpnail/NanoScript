#include <stdio.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

#define printl(str) printf("%s\n", str)

#define OP_INIT 0x00
#define OP_DB 0x01
#define OP_DB_STR 0x02
#define OP_DB_FNC 0x03
#define OP_MAIN 0x04

#define OP_ADD 0x20
#define OP_SUB 0x21

#define OP_SET 0x30
#define OP_CALL_PAR 0x03
#define OP_CALL 0x04

uint32_t prgm[] = {
        OP_INIT,
            64, // Mem Size for storing varibles
            64, // Parameter Stack Size
        OP_DB,
            OP_DB_STR,
                0x0000, 7, 'S', 'c', 'h', 'n', 'e', 'e', '\0', //DB_STR_0000
                0x0001, 12, 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '\0', //DB_STR_0001
            OP_DB_FNC,
                0x0001,                //DB_FNC_func
                0x0002,                //DB_FNC_func2
        OP_MAIN,                    //:main
            OP_ADD, 12, 23,             // tmp = 12 + 23
            OP_SET, 0x0000,             // var0 = tmp
            OP_ADD, 0x0000, 12, 23,     // var0 = 12 + 23
                OP_CALL_PAR, 12,            // par0 = 12
                OP_CALL_PAR, 0x80000000,    // par1 = DB_STR_0000
                OP_CALL_PAR, 0x80000001,    // par2 = DB_STR_0001
            OP_CALL, 0x0001,            // func1()
            OP_SET, 0x0001,             // var1 = ret0
                OP_CALL_PAR, 12,            // par0 = 12
                OP_CALL_PAR, 0x80000000,    // par1 = DB_STR_0000
                OP_CALL_PAR, 0x80000001,    // par2 = DB_STR_0001
            OP_CALL, 0x0002,            // func2()
            OP_SET, 0x0002,             // var2 = ret0
};

int nvm_execute(uint32_t*);

int main() {
    printl("Hello NVM\n");
    nvm_execute(prgm);
    return 0;
}

int nvm_execute(uint32_t * code) {
    printf("%d", code[0]);
    return 0;
}