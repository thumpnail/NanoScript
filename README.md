# Info
Currently undergoing heavy rewrite
-> Properly going to write a runtime compiler with scanning on demand

# NanoScript
 Nano Script is a Language Interpreter i am doing for learning purposes.
 It is visualy based on Assambler/Byte Code, so it contains OpCodes but with variable amount of "Parameter".
 My goal ist to create a language which you can mostly write without using any Specials(+,-,*,/,[,],{,},...) so it is easier to write.
 Performance it not a priority of this language at the moment.

 Language Definition is contained in [def.nano](./Nano/def.nano)
 Some fancy imaginary shit is contained in [test.nano](./Nano/Test.nano)
## Currently working Features
 - [x] Variables(var)
 - [x] Constants(let)
 - [x] Arrays
 - [x] Defining things(dk what for)
 - [ ] Lables and jmp(Jump) command (Broke Somehow and dont know why)
 - [x] Calling builtIn functions(cll)
 - [x] Funny Compiler Error Messages
 - [x] Working functions with returns
 - [x] If working (needs testing but seems stable)
 - [ ] Else
 
## Dependencies(for debug only)
 + Newtonsoft.Json
 + BetterConsoleTables

### Footnote
It should be now possible to create a fibonacci calculator(it doesn't)
