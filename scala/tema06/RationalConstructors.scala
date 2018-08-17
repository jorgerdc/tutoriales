/*
 * script: tema06/RationalConstructors.scala
 * Se agrega un constructor adicional.
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	
 	val numerator: Int = n 
 	val denominator: Int	 = d

 	def this(n: Int) = this(n,1)

	def this() = this(1)

 	override def toString = s"$numerator/$denominator"
 	
 	def add(r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(numerator*r.denominator + r.numerator*denominator ,
 			denominator*r.denominator)
 	}

 	def lessThan(otherRational: Rational) = 
 		this.numerator* otherRational.denominator < this.denominator * otherRational.numerator

 	def max(otherRational: Rational) = 
 		if(lessThan(otherRational)) otherRational else this  

}