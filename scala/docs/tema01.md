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
* En Scala maps no son parte de la sintaxis del lenguaje.  Maps son *library abstractions*  que se pueden extender y adaptar
* En este ejemplo, se obtiene una implementación default de un ``` map```  la cual se puede modificar con facilidad, es posible sobrescribir cualquier método del  map.
* Esta funcionalidad permite adaptar y escalar el lenguaje a las necesidades del usuario en lugar de aumentar la sintaxis 
<!--stackedit_data:
eyJoaXN0b3J5IjpbODUzNTU5NzAzLDk2NDQ0ODU2NSwtMjUwMz
MzMzk5LC00OTkyMjk5MywtMTM4NTM0NDEwNCwtODUwNTgxOTc4
XX0=
-->