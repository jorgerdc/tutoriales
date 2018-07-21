/*
 * script: tema04/ChecksumApp.scala
 * Definición de una pequeña App en Scala
 */
 import ChecksumAccumulator.calculate
 object ChecksumApp {

 	def main(args: Array[String]) = {
 		for(arg <- args){
 			println(arg +" : "+ calculate(arg))
 		}
 	}
 }