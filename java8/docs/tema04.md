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
*  
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEzNzY5NTA4NDUsMjE3MzA0MzAzXX0=
-->