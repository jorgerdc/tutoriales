/*
 * script: tema06/RationalPrivateElements.scala
 * Se agrega un atributo  y método privado.
 * La idea de esta nueva versión es simplificar un racional  empleando
 * su máximo común divisor mcd.  Por ejemplo, 24/18 será simplificado a 4/3
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	
 	private val maxDivisor  = mcd(n.abs,d.abs)
 	val numerator: Int = n / maxDivisor 
 	val denominator: Int	 = d / maxDivisor

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

 	/**
	 * Este método determina el máximo común divisor del número racional empleando
	 * recursión.
 	*/
 	private def mcd(a: Int, b: Int): Int =
 		if(b == 0) a 
 		else mcd(b, a%b) 

}