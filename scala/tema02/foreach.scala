/*
 * script: foreach.scala
 * Imprimineodo argumentos estilo funcional
 */

println("foreach")
args.foreach(arg => print(" " + arg))
println()

println("foreach con tipos de datos")
args.foreach((arg: String) => print(" " + arg))
println()

println("partially applied function")
args.foreach(println)
println()