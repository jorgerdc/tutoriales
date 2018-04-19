## 3. Expresiones Lambda

### Definición de expresión Lambda
* Representación concisa de una función anónima que puede ser  empleada como parámetro de otras funciones o ser referenciada por una variable.
* No define un nombre.
* Define lista de parámetros, cuerpo de la función, valor de retorno y posibles excepciones que puede lanzar.
* Se emplea la palabra *función* ya  que esta no está asociada a ninguna clase en particular.   
	* Un *método* siempre está asociado a una clase.
* Es concisa por su sintaxis simple. Permiten pasar código de forma simple.
* Permiten implementar el patrón: *Parametrización del comportamiento* 
* Resultado: código  más claro, flexible

##### Ejemplo:

```Java
Comparator<Curso>  comparatorOld,  comparatorLambda;
// antes de Java 8 (uso de clases anónimas)
comparatorOld = new Comparator<Curso>() {
   @Override
   public int compare(Curso o1, Curso o2) {
       return o1.getNombre().compareTo(o2.getNombre());
   }
};
// java 8
comparatorLambda = (Curso o1, Curso o2) -> o1.getNombre().compareTo(o2.getNombre());
```
### Elementos de una Expresión Lambda

* Lista de parámetros
* Flecha:  Separa a la lista de parámetros  del cuerpo de la expresión lambda.
* Cuerpo de la expresión Lambda.

### Estructura de una expresión Lambda.
* Existen 2 estilos de sintaxis:
```Java
// 1.  Una sola expresión el valor de retorno se infiere
(parametros) -> expresión

// 2. Más de una sentencia, requiere llaves. Si se desea regresar un
// valor se requiere el uso de return, en otro caso se considera void.
(parametros) -> {sentencias;}

```
##### Ejemplos: 
```Java  
//1. Regresa un valor entero. La instrucción return no es requerida
(String s) -> s.length()

//2. Acepta 2 parámetros tipo int, no regresa valor (void)
(int x,int y) -> {
	System.out.print(x+y);
}

//3.  No acepta parámetros. Regresa el valor 42 (expresión)
() -> 42

//4. Mismo caso, pero la expresion lambda está formada por statements (requiere {} y el uso de return).
() -> { return 42; }

//5. No acepta parámetros no regresa valor (void), cuerpo vacío
() -> {}
```
### ¿Dónde emplear expresiones Lambda?
* En general se emplean dentro del contexto de una *Interface funcional* .
* Lo anterior significa que una expresión lambda, además de ser asignada a una variable, puede ser pasada como parámetro de un  método  cuyo tipo de dato corresponde al de una Interface, en este caso a una *Interface funcional*.
##### Ejemplo:
``` Java
File myFiles;
String[] filteredFiles;
myFiles = new File("/tmp");
filteredFiles = myFiles
	.list((file, fileName) -> file.canWrite() && 
		fileName.endsWith(".txt"));
}
```
* En este ejemplo,  se realiza un filtrado de archivos. 
* Se obtienen todos aquellos archivos ubicados en  `/tmp` que tengan permisos de escritura y sean archivos de texto.
* El método `list` acepta un objeto `FilenameFilter`.  
* `FilenameFilter` es una interface que define un solo método:
```Java
boolean accept( File dir,String name);
```
* Esta interface es implementada y representada por la expresión lambda del ejemplo. 
* Observar que la estructura de la expresión coincide con la firma del método `accept`:  Recibe 2 parámetros  `(File,String)` y regresa un `boolean` 
* Al existir dicha coincidencia, la expresión lambda puede  *implementar* al método  `accept`y al ser el  único método de la interfaz, la expresión lambda *implementa  funcionalmente a* `FilenameFilter`.
<!--stackedit_data:
eyJoaXN0b3J5IjpbOTU0NjI1MTgxLC0xMzA4MzYxNTQyLC0yMT
QxNzQ3NDQ2LC0xMTM0Mzk0OTYwLDk5Mjc2MTExNSwtMTQxNzE1
NDMzOV19
-->