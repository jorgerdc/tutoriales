/*
 * script: tema04/CheckAccumulator.scala
 * Definición de una clase y su companion class
 */
class ChecksumAccumulator {
	private var sum  = 0
	def add(b: Byte): Unit = sum += b
	def checksum(): Int = ~(sum & 0xFF) + 1
}


import scala.collection.mutable
object ChecksumAccumulator {

	private val cache = mutable.Map.empty[String,Int]

	def calculate(text: String): Int ={
		if(cache.contains(text)){
			cache(text)
		}else {
			val acc = new ChecksumAccumulator
			for(c <-text){
				acc.add(c.toByte)
			}
			val checksum = acc.checksum()
			cache += (text -> checksum)
			checksum
		}

	}
}