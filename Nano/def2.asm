#language defenition

#variables
let <varname> <value> #variable
let <varname> <value> <...> #array

let <varname> ? <typename> <value> #variable
let <varname> ? <typename> <value> <...>

cst <varname> <value> # const
cst <varname> <value> <...> # const array

# calc operations

<varname> <varname/value> <+_-_*_/> <varname/value>

# definition
def <defname>
def <defname> <value/type/...>

#jump
jmp <jumppointname/(linenumber)>
:<jumppointname>

#Op Codes           |-> Parameter
cll <function_name> <varname/value> <varname/value> <...>
cll <pckname>.<function_name> <varname/value> <varname/value> <...>

crt <varname> <varname>
crt <varname> <varname> <parameter>

cpy <varname> <varname>

err <errcode>
err <errcode> <message>

#get index arr
#set var
get <number|string> <arrname|tablename>

#get last return
set <varname>
#is set needed
set <varname> <varname/value/...>
set <varname> < <filename>
set <varname> < <number> <filename>
set <varname> > <filename>
set <varname> << <filename>
set <varname> << <number> <filename>
set <varname> >> <filename>
set <varname> << <configfilename_ini_cfg_json_xml>

#set is not needed
<varname> <varname/value/...>
<varname> < <filename>
<varname> <<number> <filename>
<varname> > <filename>
<varname> << <filename>
<varname> <<<number> <filename>
<varname> >> <filename>
<varname> << <configfilename_ini_cfg_json_xml>

#send??
#snd <ipadress> <port> <varname>

#include
inc <nanoscriptfile/nanoscriptfilepath>
inc <nanoscriptfile/nanoscriptfilepath> <varname>

#array
let arr2d arr arr2 #2d array

#destruct
~<varname>

#function
fnc <function_name> <parametername> <...>
	<expressions/statements/opcodes>
ret (<returnvalue> <...>)

#fnc returnX2
#ret 1 2
#set a b

#if elseif else
iff <value/varname> <logical> <value/varname> | <logical> <value/varname> <...>
elf <value/varname> <logical> <value/varname> | <logical> <value/varname> <...>
els
ext

whl <logical>
ext

for <varname> <value> <logical> <value> <value>
ext
for <varname> <varname>
ext

#struct
tbl <structname>
  <expressions/statements>
ext
tbl <structname> <parametername> <...>
  <expressions/statements>
ext

#pck = package
pck <pckname>
	<expressions/statements/opcodes/functions>
ext

fnc <pckname>::<function_name>
ret

#3d grphics // ?
