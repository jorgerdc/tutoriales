## 4. Streams
### Definición
* Un Stream permite manipular colecciones de datos en forma declarativa, similar a lenguajes como SQL: Se índica lo que se quiere realizar, pero se omite el  *como*
* Estas operaciones pueden ser procesadas de forma paralela de forma  *transparente*  (no requiere realizar programación adicional).
* El uso de streams permite crear código
	* Declarativo
	* Flexible
	* Paralelizable.
### Método stream
* Todas las colecciones a partir de Java 8 incorporan un nuevo método llamado ```stream``` que regresa una referencia a la interface ```java.util.stream.Stream``` 
* Este objeto representa el punto de partida para comenzar a trabajar con Streams.
* Existen otros objetos a partir de los cuales se puede generar un Stream, no solo a través de colecciones.  Por ejemplo, se puede obtener una secuencia de valores a partir de la definición de un rango ``` [Xmin,Xmax]
### Conceptos básicos
#### Secuencia de elementos
* Tanto una colección como un Stream está fuertemente relacionados con una secuencia o conjuntos de elementos pero con distintos enfoques:
	* En una colección el enfoque es su almacenamiento y acceso empleando diversas estructuras de datos: listas, pilas, colas, etc.
	* En un Stream, el enfoque  son las operaciones y cálculos que se pueden aplicar a la secuencia de elementos: ordenamiento, filtrado, mapeo, etc.
#### Origen o fuente
* Streams consumen los elementos de una fuente, por ejemplo, colecciones, arreglos o recursos I/O.+
#### Operaciones
* Operaciones a realizar sobre los elementos del stream: ```filter, map , reduce, find, mach, sort, ``` etc.  Realizadas  de forma secuencial o en paalelo.
#### Pipelining 
* La mayoría de las operaciones regresan un Stream como resultado, lo que permite realizar encadenamiento de operaciones. Permite realizar optimizaciones como *laziness* y *short-circuiting*
* 
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTk2MjIyMzc4NSwxNzgxNjAzNDUsLTEwOT
EyMzcxNjksMjE3MzA0MzAzXX0=
-->