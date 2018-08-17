/*
 * script: tema06/RationalInvalida.scala
 * Este ejemplo no compila.
 * Las expresiones r.d y r.n son inválidas.
 * n y d se pueden emplear dentro del cuerpo
 * de la clase, pero no se crean atributos, por
 * lo tanto no se puede acceder a los  valores
 * de n y d empleando al objeto r
 * objeto donde el método add f
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	override def toString = s"$n/$d"
 	
 	def add(r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(n*r.d + r.n*d , d*r.d)
 	}
 }