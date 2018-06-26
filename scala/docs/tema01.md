# Scala
## 1. Introducción.
### 1.1 Lenguaje escalable
* Diseñado como un lenguaje que permite adaptarse , evolucionar y crecer con base a las necesidades de un usuario.
* Se ejecuta sobre el estándar de la plataforma Java
* Interactua con todas las librerías Java.
* Representa una mezcla de conceptos de la programación orientada a objetos y de la programación funcional a través de un lenguaje estáticamente tipado.
* Esta combinación permite definir nuevos patrones de programación,  abstracción de componentes. Es un lenguaje altamente **maleable** .
##### Ejemplo:
``` scala
var capitales = Map("Mexico" -> "CDMX","Japón" ->"Tokio")
capital += ("Chile"->"Santiago")
println(capitales("Mexico")) 
```
* En Scala los maps no son parte de la sintaxis del lenguaje.  Maps son *library abstractions*  que se pueden extender y adaptar
* En este ejemplo, se obtiene una implementación default de un ``` map```  la cual se puede modificar con facilidad, p.e. es posible sobrescribir cualquier método del  map.
* Esta funcionalidad permite adaptar y escalar el lenguaje a las necesidades del usuario en lugar de *aumentar* la sintaxis e instrucciones del lenguaje (hacer crecer un lenguaje). 
* Scala está basado en *módulos de librerías* que se pueden extender y adaptar con facilidad con base a necesidades específicas.

### 1.2 Adaptabilidad del lenguaje.
* Para que un lenguaje se considere como *completo*, de tal forma que pueda satisfacer las necesidades de todos sus programadores, el lenguaje deberá ofrecer una API, módulos, y sintaxis muy diversa y extensa: "*Lenguaje perfectamente completo*".
* En Scala, en lugar de extender el lenguaje con todo lo anterior,  ha sido diseñado para que  los programadores lo extiendan y  lo adapten a sus necesidades.
* Proporcionar un lenguaje que ofrezca una infinidad de funcionalidades implide una adecuada escalabilidad.
* En el caso de Scala, programadores definen *librerías* de fácil uso que permiten extender y adaptar el lenguaje de tal forma que al ser empleadas pareciera que el lenguaje ofrece todas  esas funcionalidades de forma nativa.
##### Ejemplo:
```Scala
def factorial(x: BigInt): BigInt =
	if(x==0) 1 else x * factorial(x-1)
```
* Dentro de la librería estándar que ofrece Scala, se encuentra ```BigInt``` que extiende a tipos de datos numéricos con la finalidad de manejar grandes cantidades.
#### 1.2.1 Un ejemplo de adaptabilidad: Akka.
* Esta adaptabilidad también aplica a otras construcciones, por ejemplo, a estructuras de control.
* ***Akka*** es un API de Scala que ilustra esta extensibilidad. Se trata de un API basada en el concepto de  *actor* para implementar programación concurrente. 
* Aplicaciones basadas en la arquitectura  "*message passing*"  representan una alternativa al modelo de hilos de ejecución  como el de Java.  
* La técnica empleada es a través del uso del concepto de *actor* (modelo de actores) .
* Algunos leguajes usan este concepto, p.e.  Erlang.
* Un actor es una abstracción aplicada al concepto de concurrencia que pueden ser implementada  como una siguiente capa sobre el modelo Multi-hilos de Java.
* En el modelo de actores, estos se comunican enviándose mensajes entre ellos empleando 2 operaciones básicas: ```send``` y ```receive```.  El signo de admiración se emplea para implementar la operación send.
##### Ejemplo:
```Scala
myActor ! mensaje
```
* En el ejemplo el actor ```myActor```envía un mensaje a un actor de forma asíncrona. 
* Al ser asíncrono, cada actor define un *buzón de mensajes* que permite *encolar* y procesar mensajes.
```Scala
def receive = {
	case mensaje1 => //código para manejar el mensaje1
	case mensaje2 => //código para manejar el mensaje2
}
```
##### Ejemplo:
```Scala
class checksumActor extends Actor {
	var suma = 0
	def receive ={
		case Data(byte) => sum += byte
		case GetChecksum(requested) =>
			val checksum=~(sum & 0xFF) + 1
			requester ! checksum
	}
}
```
* En este ejemplo, el autor recibe 2 tipos de mensajes: el primero  es para aumentar el valor de la variable ```suma```y el segundo es una solicitud para calcular el checksum de la variable. el cual es enviado al actor. Notar el uso del operador "!"
* Lo importante de esta sección es que ni el operador "!" , ni  el bloque ```receive```son funcionalidades o elementos sintácticos de Scala!
* Ambos elementos son métodos definidos en la librería  *Akka* y son totalmente independientes de Scala.
* Sin embargo, en el código, pareciera que son parte del lenguaje, en especial el operador "!".
### 1.3 ¿Qué es lo que hace a Scala  escalable ?
* En buena parte  se debe a a la combinación entre  la programación funcional y la programación orientada a objetos. 
#### 1.3.1 Scala es Orientado a objetos.
* Se dice que Scala es orientado a objetos de forma pura: 
	* Cada  valor en Scala es un objeto (no primitivos)
	* Cada operación en Scala es una llamada a un método.
##### Ejemplo:
```scala
1 + 2
```
* En el ejemplo anterior se invoca al métod "+" que existe en la clase ```Int```
* En Scala se pueden emplear operadores para definir métodos!
* Scala hace uso del concepto de *Trait*
* Un *Trait*  es similar a una interface en Java pero con funcionalidades adicionales:
	* Objetos pueden ser construidos por composición:  formado por atributos de una clase y por atributos de varios *Traits*.
	* Lo anterior pareciera herencia múltiple. Un *Trait* puede agregar funcionalidad a una super clase o clase base sin ser especificada !. (Se revisará más adelante).
	* Esta característica permite evitar el típico problema de *efecto diamante* que se provoca al tener herencia múltiple el cual se explica  brevemente a continuación.
##### Efecto diamante:
![Efecto diamante, tomada de Wikipedia](https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Diamond_inheritance.svg/220px-Diamond_inheritance.svg.png)
* Suponer que la clase A define un método ```m1``` que es sobrescrito o implementado tanto por la clase B como por la clase C.
* Suponer 	que la clase D no sobrescribe al método ```m1```. Debido a que D extiende de ambas clases (herencia múltiple),  ocurre una ambigüedad: 
	* ¿ Qué método empleará la clase D?  La implementación de la clase B,   o la implementación de la clase C ¿?
* A esta ambigüedad se le conoce como el efecto diamánte.
#### 1.3.2 Scala es Funcional
La programación funcional está dirigida por 2 principales conceptos:
* Concepto 1:  Funciones son tratadas como *First-class values* :  capacidad de pasar una función como argumento, ser enviadas como valor de retorno de una función, ser almacenadas en estructuras de datos como cualquier otro dato, o  referenciarlas a través de una variable.
	- Estas características permiten aumentar la expresividad, legibilidad y consistencia de un programa.
	- Otra característica es la propiedad de escalabilidad que adquiere el código.
##### Ejemplo:
```scala
val xs = 1 to 3
val it = xs.iterator
eventually { it.next() shouldBe 3}
```
El método ```eventually``` recibe  a una función como parámetro representada por la aserción indicada entre { } la cual no cuenta con un nombre. 

* Concepto 2:  Debe existir un mapeo entre valores de entrada y valores de salida de una función. Es decir,  una función no debe modificar los valores de las variables o parámetros de entrada. E.g.  Cadenas inmutables en Java.
	* Inmutabilidad representa una piedra angular en programación funcional.
	* Scala define múltiples tipos de datos inmutables: listas, mapas, sets, etc.
	* Otra forma de ver este concepto es que una función no debe provocar efectos secundarios: *Referencialmente transparente* . La función trabaja únicamente con los valores de entrada y regresa un valor. No afecta la semántica del programa.
* Cuando no se siguen estos 2 conceptos, se  tiene un estilo de programación *imperativo* .
### 1.4 Características principales de Scala 
#### 1.4.1 Compatibilidad
* Ofrece interoperbilidad con Java.  Scala reutiliza buena parte del API de Java
* Mejora el API de Java. P.e.  los métodos ```toInt```  aplicados a cadenas: ```str.toInt``` en lugar de ```Integer.parseInt(str)```
* A pesar de que el método ```toInt```no existe en la clase ```String```es posible aplicarlo a cadenas. 
	* Para lograr interoperabilidad,  Scala utiliza el concepto de *conversiones implicitas*.  
	* Cuando el método ```toInt```no es encontrado en la clase ```String```, se realiza una conversión  ```String -> StringOps```. Esta última clase (de Scala) contiene al método ```toInt```, por tanto se hace una transformación y se invoca al método. 	 
#### 1.4.2 Conciso
* Programas en escala tienden a ser más cortos que en Java lo cual  lleva a código conciso, menos propenso a errores, mejor entendible.
##### Ejemplo en Java
```java
class MyClass {
	private int indice;
	private  String nombre;
	public MyClass(int index, String nombre){
		this.index = index;
		this.nombre = nombre;
	}
}
```
##### Equivalente en Scala:
```Scala
class MyClass(index: Int, name String)
```
* La única diferencia entre los 2 ejemplos, es que los atributos de la clase en Scala serán creados como ```final```.
* Scala define librerías que permiten la eliminación de código repetitivo y comportamiento común.
#### 1.4.3 De alto nivel.
* Scala ayuda a manejar la complejidad de un programa incrementando el nivel de abstracción en las interfaces que forman parte de un diseño.
##### Ejemplo
* Programa  en Java que verifica si una cadena contiene un carater en mayúsculas  (antes de Java 8)
```java
boolean hasMayusculas = false;
for(int i =0;i<cadena.length();i++){
	if(Character.isUpperCase(cadena.charAt(i))){
		hasMayusculas = true;
		break;
	}
}
```
* En Java 8:
```java
boolean hasMayusculas = cadena.chars().anyMatch(
	(int c) -> Character.isUpperCase((char) c)
);
```
* En Scala:
```scala
val hasMayusculas = cadena.exists(_.isUpper)
```
* En Scala a los caracteres de la cadena se les pueden aplicar predicados.
* En este caso, la  expresión ```_.isUpper```es una *función literal* que representa un predicado.
* Esta función toma como parámetro a un caracter representado por "_" guión bajo.
#### 1.4.4 Estáticamente tipado.
* Scala define un sistema avanzado de tipado de variables.
	* Permite parametrizar  tipos  de datos con *genéricos*.
	* Permite combinar  tipos empleando *intersecciones*.
	* Permite ocultar detalles de los tipos de datos empleando *tipos abstractos*.
* Estos 3 conceptos se revisarán más adelante. 
* Beneficios de ser estáticamente tipado:
	* Facilidad para validar propiedades de cada tipo de datos: rango de valores (dominio), atributos de acceso, ordenar  argumentos por su tipo de dato al invocar a un a funciónm
<!--stackedit_data:
eyJoaXN0b3J5IjpbMjEyMDQ4Mzk0MywxNzYzNDA2NjE2LDE1Nj
AxNzI3NzMsLTE4NDI5NzY2NjMsLTE3NzkwOTU1MDQsLTIwNzk4
Mjg0MzEsLTIyMDU4MSwtMjg2NTE0ODQzLDQ5NDAyMzE4MSw1ND
E2NTY1NDgsNjM2NzYwNzkwLDE5ODc4NDkzOTIsNDMyMDYxODUy
LC0xMjMyOTY3NjIzLDEwODk2MDE5OCwtMzk3MzY2OTg1LDE5OT
A2NDE4NywtMTI4NDc3MTcyMSwxMzQ3MjgyODUzLC04MzA2MzM1
MTVdfQ==
-->