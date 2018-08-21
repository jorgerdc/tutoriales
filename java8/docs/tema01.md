# Java 8
## 1. Introducción
### 1.1 Principales características de Java 8
* Java 8  lanzada en Marzo del 2014 representa  a la versión con la mayor cantidad de cambios a fondo que se haya tenido desde el lanzamiento del JDK 1.0 en 1996.
* Uno de los principales objetivos de estos cambios es la posibilidad de escribir código más simple y conciso, evitando código repetitivo, verboso.
#####  Ejemplo:
* Suponer que se tiene  la siguiente clase que define a un objeto ```Apple```Escribir un programa que realice el ordenamiento de 


 * Lambdas
 *  Streams
 * Programación funcional
 * Pasar código como parámetro a un método.
### 1.2 Parametrización del comportamiento.
- Suponer 2 métodos con código similar.
- Solo algunas líneas son diferentes.
- En Java 8 es posible pasar como argumento el código que es diferente y dejar uno solo con el código común:  *Parametrización del comportamiento*
- Antes de Java 8 esto se realizaba con *Clases anónimas*.
-  Esta capacidad de pasar código permite establecer un nuevo estilo de programación: *Programación funcional*.
- Al código que se pasa como argumento se le llama *función*.
 ### 1.3 Stream processing 
 * Stream: Secuencia de elementos (datos) que son leídos por programas de forma secuencial.
 * El resultado del procesamiento de estos elementos puede ser escrito a otro Stream: *Output Stream*  
 #####  Ejemplo:
```bash
cat archivo1 archivo2 | tr “[A-Z]” “[a z]” | sort | tail -3
```
* El comando ```cat``` crea el stream de datos concatenando el contenido de ambos archivos.
* El comando ```tr```  realiza la transformación de mayúsculas a minúsculas
* El comando ``sort`` realiza el ordenamiento de los registros, recibe un Stream de entrada y produce otro.
* El comando ```tail```obtiene las últimas 3 líneas del Stream de salida.
* Los comandos ```cat``` , ```sort``` y ```tail``` pueden ser ejecutados de forma paralela, es decir, ```sort``` se puede ejecutar antes que ```tr``` o ```cat``` terminen.



<!--stackedit_data:
eyJoaXN0b3J5IjpbNDUwODU2NTgyLC0xNDU0OTIzMjAxLDE4NT
MwMzY3NDEsLTY3NzEyMzI2NF19
-->