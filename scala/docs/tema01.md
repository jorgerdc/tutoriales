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
* Para que un lenguaje se considere como *completo*, de tal forma que pueda satisfacer las necesidades de
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQyODc1ODk5OCw1ODg0NDUxNzAsOTY0ND
Q4NTY1LC0yNTAzMzMzOTksLTQ5OTIyOTkzLC0xMzg1MzQ0MTA0
LC04NTA1ODE5NzhdfQ==
-->