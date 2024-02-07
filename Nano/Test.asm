#test comment

#definitions are either a script wide config or helpers for multiple file include
def default_type_num i8
def test_inc

iff test_inc
	cll print "included"
ext

#based on opcodes which are 3 chars long
#jump point lable for ease of use
jmp main
:main
inc builtin #includes the whole file(builtin.no/.co)
set bltin #all included file contents are in var bltin
cll bltin.add 12 34
set arr2[2]

#jump to line
jmp main
:main
#let
let a 2
let arr 12 23 53 63 17 #array
let arr2 ? [] 12 34 54
arr2 12 #adds 12
arr2 12 34 #adds 12 and 34
let val
val arr2[] #pops arr2 last value
arr2 [3] 12 #adds 12 at 4th position
let arr2d arr arr2 #2d array
let arr3d ? [][][] #array define
let cusbool TRE
let name "name"
let char ? chr 'a'
cst someconst 13 #const

#advanced typing
let anothervar ? dbl 1.2

#destruct
~a
~b
~c

#print is an internal function and can be used like an op code
print "hello world"

#function with return
fnc printName name
	print name
ret name

fnc printNum num
	print num
ret

fnc multipleReturn a b
ret a b

cll multipleReturn 2 3
set x y

#ifnc elseifnc else
iff ab EQL TRE
    #do
elf b EQL FLS
    #do
els
    #do
ext

whl TRU
  #blablabla
ext

for i 0 LES 100 1

ext

let arr5 12 34 45 56 78
for item arr5
  #do something with item
ext

#there are no templates just bundled data(struct)
sct bundled_data:
	let x 3
	let y 5
	let z 6
	sct inlinesct:
		let w
	ext
ext

#pck = package
pck user:
	let name
	let age
	fnc ctr:
		let i 0
		for i < 10:
			cll 0x0001
			cll B01101000
			#call non builtin function
			cll printName "some shitty name " . i #concat strings
		ext
		ret 5
ext

#outside of pck with :: bc . is used for calls
fnc user::ctw
#someshittylogic
ret

crt pos bundled_data #creates a new sct without values
cpy bundled_data pos

#write return to b
cll user.ctr
set b
let alpha
let bravo "somefilecontent"
get bravo > "test.txt" #writes to file / add lines
get bravo >> "text.txt" #rewrite whole file
set alpha < "test.txt" #reads file 1 line
set alpha << "test.txt" #reads whole file
set alpha <14 "test.txt" #reads 14 bytes
cnv alpha ? str #converts alpha to string
set alpha <<3 "test.txt" #reads 3 lines(until \n)
let cfg << "cfg.ini" \ "config.cfg"
let importsct << "obj.json" \ "obj.xml" #checks if file exists

err 404 "no connection" #program exit with error
err 120 "no thing"
ext 0 #program exit with code 0

#window files for UI
let window << "form.win"

#3d grphics

#Value mapping

sct SomeSruct #Can be Json / no functions
  let a
  let b
  let c
ext
cpy SomeSruct TestStruct
TestStruct 12 34 45
#TestStruct.a = 12, .b = 34, .c = 45

#Networking??
snd TestStruct 127.0.0.1 55

#test set
fnc getdata
let data 12 + 34
ret data

cll getdata #call getdata function
let data #create variable "data" and put return from last called function in it

let VARIABLE "ein name" #create VARIABLE with "ein name"
VARIABLE . " und ein weiterer " . data #attach string and data

let VARIABLE "zwei name" #would recreate VARIABLE
