/*
 * script: while-imperativo.scala
 * Imprimineodo argumentos con while
 */
var i = 0
while(i < args.length){
	if(i!=0){
		print(" ")
	}
	print(args(i))
	i = i +1
}
println()