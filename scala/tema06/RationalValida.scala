/*
 * script: tema06/RationalValida.scala
 * Se agregan atributos para corregir el problema
 * del ejemplo anterior
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	
 	val numerator: Int = n 
 	val denominator: Int	 = d

 	override def toString = s"$numerator/$denominator"
 	
 	def add(r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(numerator*r.denominator + r.numerator*denominator ,
 			denominator*r.denominator)
 	}
 }