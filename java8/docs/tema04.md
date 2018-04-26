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
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEwOTEyMzcxNjksMjE3MzA0MzAzXX0=
-->