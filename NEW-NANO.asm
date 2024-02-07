main:										#
	add 12 23								#
	set abc									#
	add abc 12 23
	call func 12 "Schnee" "Hello World"		#
	set out1								#
	call func2 12 "Schnee" "Hello World"	#
	set out2								#
	if out1 == out2:						#
		while:								#
		end									#
	end										#
ret											#
#parameter from global
func:										#
	assert _p.len 3							#
	struct RES:								#
		let value1 _p[0]					#
		let value2 _p[1]					#
		let value3 _p[3]					#
	end										#
ret RES										#
#Parameter from function head
func2 _v1 _v2 _v3:							#
	tab RES									#
		let value1 _v1						#
		let value2 _v2						#
		let value3 _v3						#
	end										#
ret RES										#
arraytest:									#
	let arr 1								#
	add arr 6								#
	# arr = 7
	let arr2 1 2							#
	add arr 3								#
	# arr = [1,2,3]
ret											#