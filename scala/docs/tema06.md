## 6. Objetos Funcionales
* Recordando las ventajas de objetos inmutables:
	* Más  fáciles de manejar y razonar ya que no cuentan con estado que cambia con el tiempo.
	* Instancias inmutables pueden pasarse como parámetros múltiples veces sin preocuparse de posibles cambios aplicados a dichas instancias.
	* No hay forma en la que 2 hilos concurrentes afecten o corrompan el estado del objeto inmutable ya que ninguno de los hilos podrá modificar su estado.
	* El uso de objetos inmutables como llaves en un HashTable facilita su uso ya que su estado nunca cambia.
* La principal desventaja  de  un objeto inmutable es:
	* Suponer la existencia de un objeto con un nivel de agregaciones alto ( high object graph).  En este caso se requiere crear *copias* del objeto  para preservar su propiedad de inmutabilidad que pueden resultar ***costosas*** en cuanto a desempeño. 
	* Para resolver este problema se ofrecen  versiones inmutables  y mutables de un mismo objeto.    El ejemplo clásico es  la clase ```java.lang.String```y ```java.lang.StringBuilder```
### 6.1 . Caso de estudio, definición de clases
* Construcción de  una clase llamada ```Rational```  empleada para representar números racionales de la forma ```numerador/denominador```
* Los objetos de la clase  deberán ser Inmutables. 
* En Scala la forma más simple de definir la clase es:
```Scala
class Rational(n: Int , d: Int)
```
* En este ejemplo, la clase recibe 2 parámetros llamados ***class parameters*** .
* Empleando estos parámetros, el compilador creará un ***primary constructor***   empleado los 2 parámetros. 
* Cualquier código que se agregue al cuerpo de la clase  que no corresponda a la definición de un método o de algún atributo, será agregado al *constructor primario* 
##### Ejemplo:
```scala
class Rational(n: Int, d: Int) {
	println(s"Creando instancia, $n/$d")
}
```
* Creando instancias de la clase:
```scala
scala> new Rational(1,2)
Creando instancia, 1/2
res1: Rational = Rational@6b357eb6
```
### 6.2 Reimplementando el método toString
* En el resultado anterior se observa la cadena ``` Rational@6b357eb6``` que  proviene de ejecutar el método ```toString```de  ```java.lang.Object```
* En Scala la  sintaxis para sobrescribir un método es la siguiente:
```scala
class Rational(n: Int , d: Int){
	override def toString = s"$n/$d"
}
```
* Observar ahora la salida:
```scala
scala> new Rational(3,4)
res2: Rational = 3/4
```
### 6.3 Validando precondiciones.
* Para  crear instancias de objeto inmutables, los valores   que se pasan  como argumento en el constructor primario  deben ser validados.
* Para el caso de la clase ```Rational```el denominador no debería ser cero.
* La validación se puede realizar empleando el método ```require```
```scala
class Rational(n: Int , d: Int){
	require(d != 0)
	override def toString = s"$n/$d"
}
```
* El método ```Predef.require```  lanzará ```IllegalArgumentException``` si la condición no se satisface.
```bash
new Rational(3,0)
java.lang.IllegalArgumentException: requirement failed
at scala.Predef$.require(Predef.scala:264)
... 29 elided
```
### 6.4 Agregando atributos.
* Anteriormente se revisó la forma corta para crear la clase ```Rational```en la que no fue necesario declarar los atributos ```n```y ```d```.
* Suponer que se desea agregar el método ```add```,  el siguiente código ***no*** compilará:
```scala
/*
 * script: tema06/RationalInvalida.scala
 * Este ejemplo no compila. Las expresiones r.d y r.n son inválidas.
 * n y d se pueden emplear dentro del cuerpo de la clase, pero no se  
 * crean atributos, por lo tanto no se puede acceder a los  valores
 * de n y d empleando al objeto r.
 */
 class Rational(n: Int, d: Int) {

 	require(d!=0)
 	override def toString = s"$n/$d"
 	
 	def add(r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(n*r.d + r.n*d , d*r.d)
 	}
 }
```
* El error producido es:
 ```bash
scalac RationalInvalida.scala 
RationalInvalida.scala:18: error: value d is not a member of Rational
 		new Rational(n*r.d + r.n*d , d*r.d)
                                 ^
RationalInvalida.scala:18: error: value n is not a member of Rational
 		new Rational(n*r.d + r.n*d , d*r.d)
                                       ^
RationalInvalida.scala:18: error: value d is not a member of Rational
 		new Rational(n*r.d + r.n*d , d*r.d)
                                       ^
```
* Tal cual como se describe en el comentario del código anterior, n y d se pueden emplear dentro del cuerpo de la clase, pero no se  crean atributos, por lo tanto no se puede acceder a los  valores de n y d empleando al objeto r.
* Para solucionar lo anterior, se  deben agregar atributos que puedan ser accedidos de forma externa al cuerpo de la clase:
```scala
/*
 * script: tema06/RationalValida.scala
 * Se agregan atributos para corregir el problema
 * del ejemplo anterior
 */
 class Rational(n: Int, d: Int) {
 	require(d!=0)
 	val numerator: Int = n 
 	val denominator: Int = d

 	override def toString = s"$numerator/$denominator"
 	
 	def add(r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(numerator*r.denominator + r.numerator*denominator ,
 			denominator*r.denominator)
 	}
 }
 ```
* Creando instancias se obtiene:
```bash
scala> val r1 = new Rational(1,2)
r1: Rational = 1/2

scala> val r2 = new Rational(2,3)
r2: Rational = 2/3

scala> r1 add r2
res0: Rational = 7/6
```
### 6.5 Uso de this.
* Similar al uso de ```this``` en  Java.
* El siguiente ejemplo agrega 2 nuevos métodos a la clase ```Rational```que hacen uso de ```this```:  
	* Método ```lessThan```verifica si un objeto actual es menor que el objeto recibido como argumento.
	* Método ```max``` regresa el objeto mayor  comparando el objeto actual y el que se proporciona como argumento.
```scala
/*
 * script: tema06/RationalAndThis.scala
 * Se agregan los métodos lessThan y max
 */
 class Rational(n: Int, d: Int) {
 	require(d!=0)
 	val numerator: Int = n 
 	val denominator: Int	 = d

 	override def toString = s"$numerator/$denominator"
 	
 	def add(r: Rational ): Rational = {
 		new Rational(numerator*r.denominator + r.numerator*denominator 		, denominator*r.denominator)
 	}

 	def lessThan(otherRational: Rational) = 
 		this.numerator* otherRational.denominator < this.denominator * otherRational.numerator

 	def max(otherRational: Rational) = 
 		if(lessThan(otherRational)) otherRational else this  
}
```
### 6.6 Constructores auxiliares
* Se les llama constructores auxiliares a todos aquellos constructores adicionales que pudiera tener una clase con respecto al constructor *primario*.
* Los constructores auxiliares en Scala  comienzan con ```def this(...)```
* Una regla importante en Scala es que los constructores auxiliares ***deben*** invocar a un constructor primario  en la primer línea de código, o en su defecto, debe invocar a otro  constructor auxiliar *previamente definido*, el cual a su vez invocará al constructor *primario* 
* En el siguiente ejemplo se agregan 2 constructores auxiliares a la clase ```Rational```
	* Constructor auxiliar 1: Recibe solo el numerador, el cual será equivalente al número racional ```5/1```
	* Constructor auxiliar 2:  No recibe parámetros, será equivalente a construir el número racional ```1/1```
* Esta restricción  no es necesaria en Java.  En Scala se requiere para poder ofrecer la flexibilidad y consistencia que ofrece para realizar el manejo de constructores.
##### Ejemplo:
```scala
def this(n: Int) = this(n,1)
def this() = this(1)
```
* Observar que en el segundo constructor invoca al primero, el cual recibe un solo parámetro y debe estar definido antes que el segundo constructor.  El código completo se encuentra en ```tema06/RationalConstructors.scala```
### 6.7 Atributos y métodos privados.
* Para ilustrar el uso de ```private``` se realizará el siguiente cambio a la clase ```Rational```:
	* Si el número racional cuenta con un *máximo común divisor (mcd)* el número deberá simplificarse para evitar  números grandes.
	* La validación se realiza en el constructor primario.
```scala

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
 	val denominator: Int = d / maxDivisor

 	def this(n: Int) = this(n,1)
	def this() = this(1)
 	override def toString = s"$numerator/$denominator"
 	//otros métodos
 	
 	/**
	 * Este método determina el máximo común divisor del número 
	 * racional empleando
	 * recursión.
 	 */
 	private def mcd(a: Int, b: Int): Int =
 		if(b == 0) a 
 		else mcd(b, a%b) 
}
```
* Observar que se agrega un atributo privado ```maxDivisor``` que obtiene el mcd  invocando al método privado ```mcd```
* Ambos elementos pueden accederse dentro de la clase pero no fuera de ella (Similar a Java).
### Definición de operadores
* En ejemplos anteriores se agregó el método ```add``` que realiza la suma de 2 números racionales.
* En Scala sería mas adecuado agregar un método llamado ```+```que permita realizar la suma de forma más natural:
```scala
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
 	
 	/**
	 * Observar el uso del operador + como nombre del método
	 */
 	def + (r: Rational ): Rational = {
 		// 1/5 + 2/3 = (1*3 + 2*5)/(5*3)
 		new Rational(numerator*r.denominator + r.numerator*denominator,
 			denominator*r.denominator)
 	}
 	
	/**
	 * Observar el uso del operador * como nombre del método
	 */
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
```
* Con el cambio anterior,  invocar la suma o multiplicación de números racionales se realiza de forma muy natural:
```bash
scala> val r1 = new Rational(5,2)
r1: Rational = 5/2

scala> val r2 = new Rational(1,4)
r2: Rational = 1/4

scala> r1 + r2
res0: Rational = 11/4

scala> r1.+(r2)
res1: Rational = 11/4
```
* Observar la sintaxis equivalente para invocar al método que realiza la suma: ```r1.+(r2)```
