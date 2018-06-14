# Scala
## 1. Introducción.
### Lenguaje escalable
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

### Adaptabilidad del lenguaje.
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
* Esta adaptabilidad también aplica a otras construcciones, por ejemplo, a estructuras de control.
* ***Akka*** es un API de Scala que ilustra esta extensibilidad. Se trata de un API basada en el concepto de  *actor* para implementar programación concurrente. 
* Aplicaciones basadas en la arquitectura  "*message passing*"  representan una alternativa al modelo de hilos de ejecución  como el de Java.  
* La técnica empleada es a través del uso del concepto de *actor* (modelo de actores) .
* Algunos leguajes usan este concepto, p.e.  Erlang.
* Un actor es una abstracción aplicada al concepto de concurrencia que pueden ser implementada  como una siguiente capa sobre el modelo Multi

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1NTk4Njg5OTQsLTE5NTEyNDMxMDAsNj
kzNjYyMDQyLC02NTQ0MzYwNTAsMTA4MzgyNjkyOCw1ODg0NDUx
NzAsOTY0NDQ4NTY1LC0yNTAzMzMzOTksLTQ5OTIyOTkzLC0xMz
g1MzQ0MTA0LC04NTA1ODE5NzhdfQ==
-->