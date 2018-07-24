/*
 * script: tema04/ChecksumTraitApp.scala
 * Definición de una pequeña App en Scala que hace uso del trait App
 */
 import ChecksumAccumulator.calculate
 object ChecksumTraitApp extends App {

	for(arg <- args){
		println(arg +" : "+ calculate(arg))
	} 
}