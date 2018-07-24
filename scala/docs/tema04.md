## 4. Clases y Objetos
### 4.1 Clases, atributos y métodos.
* Definición de una clase en Scala:
```scala
class ChecksumAccumulator {
	//definición de la clase
}
```
* Los atributos pueden ser definidos con ```var``` o con ```val```
* Generando instancias:
```scala
val acc  = new ChecksumAccumulator
``` 
* A diferencia con Java, en Scala los atributos por  default son ```public```. Si se desea hacerlos privados, se debe indicar de forma explícita.
```scala
class ChecksumAccumulator {
	private var sum  = 0
}
```
* Agregando métodos
```scala
class ChecksumAccumulator {
	private var sum  = 0
	
	def add(b: Byte): Unit ={
		sum+=b
	}
	
	def checksum(): Int = {
		return ~(sum & 0xFF) + 1
	}
}
```
* Un punto importante en Scala es que los parámetros de un método son  *vals* no *vars*. Esto significa que no se pueden reasignar.
* El código anterior puede escribirse en un estilo más conciso:
	* Remover la cláusula ```return```.  La última expresión calculada es la que se regresa.
	* Se pueden remover las llaves {} del método cuando se tiene una sola línea. 
	* El tipo de dato del valor de retorno se puede omitir, Scala lo infiere.
```scala
class ChecksumAccumulator {
	private var sum  = 0
	def add(b: Byte) = sum += b
	def checksum() = ~(sum & 0xFF) + 1
}
``` 
* La desventaja de quitar el tipo de dato de retorno es que  se tiene que analizar el cuerpo del método para determinarlo. 
* Se recomienda conservar los tipos de retorno :
```scala
class ChecksumAccumulator {
	private var sum  = 0
	def add(b: Byte): Unit = sum += b
	def checksum(): Int = ~(sum & 0xFF) + 1
}
``` 
* Métodos que regresan el tipo ```Unit``` (void)  como en el caso del método ```add```  son métodos que provocan un efecto secundario.  En este caso,  actualiza el valor del atributo ```sum``` . A este tipo de métodos en Scala se les conoce como ***procedimientos***.
* Para el caso del ";", este es opcional excepto en los casos don de existe más de una sentencia en la misma línea. 
* En el siguiente ejemplo ";"  es necesario:
```scala
val saludo = "Hola"; println(saludo)
```
### 4.2 Objetos Singletón
* En Scala las clases no pueden tener  atributos estáticos. 
* En su lugar Scala define *Objetos estáticos*.
* Para crear un objeto singleton se emplea la palabra ```object``` en lugar de la palabra ```class``` al momento de realizar la definición del objeto.
* Un objeto singleton puede tener el mismo nombre que una clase.
* En este caso al objeto singleton se le llama ***companion object*** 
* A la definición del *companion object* se le conoce como ***companion class***.
* Tanto la clase como su *companion class* deben estar definidas en el mismo archivo.
* Los atributos privados de ambas clases pueden ser accedidos entre ellas.
```scala
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
```
* En este ejemplo,  se ha creado un objeto singleton para obtener el checksum de una cadena.
* Notar que se hace uso de un ```Map``` que actúa como caché para evitar el cálculo del checksum en caso de haberse calculado previamente.
	* Aquí se pudo haber empleado un ```scala.collection.WeakHashMap``` . Cuando la memoria se está acabando , el garbage collector puede reciclar  los objetos contenidos en ella para recuperar memoria.   Esto no representa problema alguno ya que se trata de un cache.   El efecto secundario sería que los checksum se tendrían que volver a calcular.
* Notar que se hace uso de una instancia ```val acc = new ChecksumAccumulator``` .   
* Debido a que se usa ```new```  se puede inferir que se está haciendo uso de la clase principal, (no de su companion class).  
* No  es posible usar ```new``` con un singleton object.
* Cada objeto singleton es implementado a través de una instancia de una ***Clase sintética*** . Su nombre es ```<CompanionClassName>$```.  Para este ejemplo, el nombre será ```ChecksumAccumulator$```
* Dicha instancia es representada por una variable de tipo ```static``` similar a Java. 
* El objeto singleton es inicializado la primera vez que se usa.  
* Si se quisiera invocar al singleton object, se  tendrá lo siguiente:
```scala
val checksum = ChecksumAccumulator.calculate("HOLA")
```
* Notar que la sintaxis para invocar a un singleton object es muy similar a la sintaxis en Java para invocar métodos de clase (estáticos).
* Se puede pensar que un  objeto singleton es una especie de 'wrapper' de un atributo estático en Java.  
* En la clase se pueden agregar más atributos como en cualquier otra.
* Dentro del singleton object se emplea un ```Map```para asegurar que solo existe una instancia, misma que actuará como un solo caché.
#### 4.2.1 Objetos Standalone
* Son objetos Singleton que no definen o no cuentan con una *companion class*
* Empleados para múltiples propósitos:
	* métodos de utileria
	* punto de inicio de una aplicación escrita en Scala  (similar al método main de Java).
### 4.3 Aplicaciones en Scala.
* Para ejecutar una aplicación en Scala es necesario hacer uso de un objeto standalone con un método main, acepta un ```Array[String]``` y regresa ```Unit```.
##### Ejemplo:
```scala
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
```
* El ejemplo imprime en valor de  cada elemento del arreglo ```args``` seguido de su checksum.
* Notar la instrucción ```import```,  similar a un ```static import``` en Java que hace referencia al método ```calculate``` del objeto singleton ```ChecksumAccumulator```
* En Scala se puede importar cualquier miembro de  cualquier objeto, no solo de objetos singleton.
* Por default, Scala realiza *imports*  de forma automática de los  siguientes elementos:
	* Paquete ```java.lang```
	* Paquete ```scala```
	* Métodos del objeto singleton llamado ```Predef``` ubicado en el paquete ```scala```.
* El objeto ```Predef```contiene una gran cantidad de métodos de utilería, por ejemplo, al invoca ```println```, en realidad se invoca ```Predef.println```
* Notar que los 2 objetos  ```ChecksumApp```y ```ChecksupAccumulator``` se definen en 2 archivos  que tienen el mismo nombre.
* En Scala esto no es requisito  (en Java si ), sin embargo, se recomienda seguir esta convención por claridad y facilidad para ubicar código.
* Por otro lado, observar que ambos archivos solo contienen definiciones de clases y objetos,  no contienen expresiones, es decir,  ***no son scripts.***
* Para que un archivo sea considerado como  script, este debe terminar en  una expresión.
* Lo anterior hace que dichos archivos no pueden ser ejecutados empleando el interprete ```scala``` .
* Los archivos deben ser compilados empleando el compilador de Scala:
```bash
scalac ChecksumAccumulator.scala ChecksumApp.scala
```
* Observar los archivos generados:
```bash
ls *.class
ChecksumAccumulator$.class  ChecksumAccumulator.class  ChecksumApp$.class  ChecksumApp.class
```
* La primera vez que se ejecuta el compilador se observa un cierto *delay* ya que requiere realizar ciertas operaciones iniciales.
* Para mejorar los tiempos de ejecución, Scala proporciona un *deamon* llamado ```fsc```(fast scala compiler) :
```bash
fsc ChecksumAccumulator.scala ChecksumApp.scala
```
* Este deamon hace uso de un puerto como medio de comunicación para realizar la compilación de archivos.
* Para detener el deamon se  emplea ```fsc -shutdown ```
* Finalmente, al ejecutar la aplicación se obtiene la siguiente salida. 
```bash
scala ChecksumApp Hola Scala
Hola : -132
Scala : -228
```
* Notar que se especifica el nombre del objeto singleton en lugar del nombre del archivo.
#### 4.3.1 Empleando  el Traint App
* Existe un *Trait* llamado ```scala.App``` que puede simplificar la programación del objeto singleton para iniciar  una aplicación  (el concepto de Trait se revisará mas adelante)  de la siguiente forma:  
```scala
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
```
* Observar que ya no existe el método ```main```. Basta con colocar el código directamente en el cuerpo de la clase.
* El atributo ```args```se hereda de  ```App```.
