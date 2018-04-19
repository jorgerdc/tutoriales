test# Java 8
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
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTU4NjYzODIwMSwtMTEzNDM5NDk2MCw5OT
I3NjExMTUsLTE0MTcxNTQzMzldfQ==
-->