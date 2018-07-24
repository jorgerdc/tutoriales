## 5. Tipos Básicos y operaciones
### 5.1 . Tipos básicos.
* Similares a los tipos de Dato en Java:
	* ```Byte```
	* ```Short```
	* ```Int```
	* ```Long```
	* ```Char```
	* ```String```
	* ```Float```
	* ```Double```
	* ```Boolean```
* En Scala a los tipos de datos ```Byte```, ```Short```, ```Int```, ```Long``` y ```Char``` se les conoce como *Integral types*.
* ```Boolen```y ```Double``` se les conoce como *numeric types*. 
### 5.2 Literales.
* Su significado es el mismo que en Java.  Todos los tipos de datos listados anteriormente pueden ser escritos como literales: escribir su valor directamente en código.
* Scala no soporta  literales en formato octal, por lo que  una literal en Scala no puede iniciar en ```0```.  El siguiente ejemplo  no compilaría:
```scala
val x = 044
```
* Formato hexadecimal si es soportado:
```scala
scala> val hex = 0x5
hex: Int = 5

scala> val hex2 = 0xF
hex2: Int = 15
```
* Observar que el intérprete siempre se imprime el valor en formato decimal.
#### 5.2.1 Uso de 3 comillas """
* Este operador es util para evitar escapar caracteres especiales que pueden aparecer en cadenas. La cadena puede contener saltos de línea, etc.
##### Ejemplo:
* Generar una literal con los siguientes caracteres: ```\"'```
```scala
//sin el uso de las 3 comillas (estilo Java)
scala> val str = "\\\"\'"
str: String = \"'
//empleado 3 comillas
scala> val str2 = """\"'"""
str2: String = \"'
```
##### Ejemplo:
```scala
print("""Este es un
|Mensaje muy
|muy "largo" con multi linea """)
//la salida es:
Este es un
Mensaje muy
muy "largo" con multi linea
```
* Notar el uso de ```|```  para evitar espacios después de cada linea.
### 5.3 String Interpolation
* Permite incrustar expresiones dentro de una cadena y ser evaluadas.
##### Ejemplo:
```scala
scala> val saludo = "hola"
saludo: String = hola

scala> println(s"$saludo Mundo")
hola Mundo
```
* La cadena a procesar debe iniciar con la letra ```s```.
* Observar el uso de ```$``` para identificar a la variable ```saludo```
* Para hacer uso de expresiones formadas por varios elementos, se emplean ```{}```
##### Ejemplo:
```scala
scala> println(s"La suma de 2 + 3 es ${ 2 + 3 }")
La suma de 2 + 3 es 5
```
* En Scala existen otras 2 cadenas para realizar interpolación: ```raw``` y ```f```.
* ```raw``` no reconoce caracteres especiales como ```\n, \t```, etc.
```scala
scala> println(raw"Aqui existen ${2+2} antidiagonales \\\\")
Aqui existen 4 antidiagonales \\\\

scala> println(s"Aqui existen ${1+1} antidiagonales \\\\")
Aqui existen 2 antidiagonales \\
```
* ```f```se emplea para dar formato a cadenas, similar a los formatos definidos en ```java.util.Formatter```
##### Ejemplo:
```scala
scala> println(f"El valor aproximado de Pi es ${math.Pi}%.5f")
El valor aproximado de Pi es 3.14159
```
* Es posible definir cadenas personalizadas para interpolar.

### 5.4 Operadores son métodos !
* En Scala los operadores no cuentan con una sintaxis en particular. Cualquier método puede ser un operador. 
* La forma en la que se usa un método determina si este actúa como tal o como operador.
#### 5.4.1  Notación *infix* para operadores.
* Al emplear esta notación el  método actúa como operador.
##### Ejemplo:
```scala
scala> val saludo ="Hola, ¿como estas?"
saludo: String = Hola, ¿como estas?

scala> val index = saludo indexOf 'a'
index: Int = 3
```
* En esta notación el nombre del método se ubica entre el objeto y el parámetro o parámetros que recibe.
* Observar en el ejemplo anterior, el  método ```indexOf```se escribe después del objeto y antes de los parámetros que  recibe.
* Si el método recibe más de un argumento se emplean paréntesis.
##### Ejemplo:
```scala
scala> val index = saludo indexOf('a',4)
index: Int = 15
```
* Una de las versiones del método  ```indexOf```  recibe un segundo parámetro que indica la posición en la que inicia la búsqueda.
#### 5.4.2 Notación *prefix* y *postfix* 
* Scala soporta también notación  *prefix*  y * postfix*
* Para ambas notaciones, el operador toma a un solo operando, por lo que se considera  un operador unario. 
* En notación prefix, el operando está a la derecha del operador: ```-7```
* En Scala  ```-7```  en realidad se traduce a una llamada de un método que recibe como parámetro al número 7, pero en notación prefija.
* El nombre del método inicia con ```unary_```seguido del caracter que representa al operando.  En este caso al signo negativo, es decir:  ```(7).unary_-```
##### Ejemplo;
```scala
scala> val x = -2
x: Int = -2

scala> // el compilador lo traduce a lo siguiente:
scala> (2).unary_-
res1: Int = -2
```
* Los únicos operadores que se pueden emplear en notación prefija son ```+,-,!,~```

* En notación postfix, el nombre del método se escribe al final:
##### Ejemplo:
```scala
scala> import scala.language.postfixOps
import scala.language.postfixOps

scala> val x = 7 toLong
x: Long = 7
```
* Empleando la notación punto se tendría lo siguiente:
```scala
scala> val x = 7.toLong
x: Long = 7
```
* Notar que en notación postfix el método  no recibe argumentos y por lo tanto los paréntesis se omiten.
#### 5.4.3 Invocando métodos sin parentesis.
* En general, en Scala se pueden invocar métodos sin el uso de paréntesis. 
* Existe una convención en Scala para dejar o quitar paréntesis: 
	* Se dejan cuando el  método provoca o produce efectos secundarios o colaterales.  Por ejemplo ```println()```tiene efecto colateral ya que imprime na cadena a la consola.
	* Se omiten cuando el método no tiene efectos colaterales:
```scala
scala> val str = "hola".toUpperCase
str: String = HOLA
```
* O en su forma postfja:
```scala
scala> val str = "hola" toUpperCase
str: String = HOLA
```
### 5.8 Igualdad en Objetos.
* En Scala para comparar objetos se emplea ```==``` el cual se comporta de la misma manera que el método ```equals```en Java.
* El operador contrario es ```!=```
##### Ejemplo:
```scala
scala> 1==1.0
res0: Boolean = true

scala> List(1,2,3) == List(1,2,3)
res1: Boolean = true

scala> null == List(1,2)
res2: Boolean = false

scala> "a"+"b" == "ab"
res3: Boolean = true
```
* Para verificar igualdad por referencia en Scala existen los operadores ```eq``` y su contrario ```ne```.
### 5.9 Rich Wrapper classes
* Similares a las clases Wrapper de los tipos primitivos en Java cuyo principal propósito es ofrecer un mayor número de métodos de utilería aplicables a los tipos de datos básicos:
* ```Byte:  	  scala.runtime.RichByte```
* ```Short:    scala.runtime.RichShort```
*  ```Int:  	  scala.runtime.RichInt```
*  ```Long:    scala.runtime.RichLong```
*  ```Char:    scala.runtime.RichChar```
*  ```Float:   scala.runtime.RichFloat```
*  ```Double:  scala.runtime.RichDouble```
*  ```Boolean: scala.runtime.RichBoolean```
*  ```String:  scala.collection.immutable.StringOps```
* La lista de métodos de estas clases está [aquí](https://www.scala-lang.org/api/current/scala/runtime/index.html)

