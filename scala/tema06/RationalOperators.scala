/*
 * script: tema06/RationalOperators.scala
 * Se agrega un método para sumar empleado como nombre al operador +
 * Se agrega un método para multiplicar empleado como nombre al operador *
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	
 	private val maxDivisor  = mcd(n.abs,d.abs)
 	val numerator: Int = n / maxDivisor 
 	val denominator: Int	 = d / maxDivisor

 	def this(n: Int) = this(n,1)

	def this() = this(1)

 	override def toString = s"$numerator/$denominator"
 	
 	def + (r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(numerator*r.denominator + r.numerator*denominator ,
 			denominator*r.denominator)
 	}

 	def * (r: Rational ): Rational = {
 		new Rational(numerator*r.numerator,denominator*r.denominator)
 	}


 	def lessThan(otherRational: Rational) = 
 		this.numerator* otherRational.denominator < this.denominator * otherRational.numerator

 	def max(otherRational: Rational) = 
 		if(lessThan(otherRational)) otherRational else this  

 	private def mcd(a: Int, b: Int): Int =
 		if(b == 0) a 
 		else mcd(b, a%b) 

}