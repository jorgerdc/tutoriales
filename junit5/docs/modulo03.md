# JUnit 5
## 3. Condicionando ejecución de pruebas.
* El código de este módulo se encuentra en Github correspondiente al paquete `com.jorgerdc.tutoriales.junit5.modulo03`
### 3.1 Assumptions.
  * Permiten ejecutar una prueba únicamente si se satisface una condición.
  * Las condiciones se verifican empleando los métodos de la clase `Assumptions`
	 * `assumeTrue`
	* `assumeFalse`
	* `assumingThat` 
##### Ejemplo:
```java
/**
 * Real case: If the test is not running on a Quality server, it won't execute.
 */
@Test
void executeOnQualityServer() {
  assumeTrue("QA".equals(System.getProperty("server.type")), "Checking QA server");
  log.debug(
    "this line and the next won't be executed since the previous condition is false");
  fail("This line won`t execute");
}

/**
 * Using <code>assumeTrue</code> but now with a
 * {@link java.util.function.BooleanSupplier}
 */
@Test
void executeOnDevServer() {

  log.debug("before checking assumption for Dev server");
  assumeTrue(() -> {
    log.debug("Checking if we are running on Dev server");
    // some logic here
    return false;
  });
  fail("This line won't be executed, so the test will succeed.");
}

/**
 * Real case: Execute this test if the execution environment is a Continuous Integration
 * Server using <code>assumingThat</code>. The code that is conditioned for execution is
 * now encapsulated in a Executable object (lambda expression).
 */
@Test
void executeOnCIServer() {
  log.debug("before checking assumption for CI server");
  assumingThat("CI".equals(System.getProperty("server.type")), () -> {
    fail("This line won't execute, so the test will succeed.");
  });
  log.debug("after assumingThat");
}

/**
 * Using a {@link BooleanSupplier} and a {@link Executable}. In this case
 * the code inside the executable object will be executed because the condition is true.
 */
@Test
void executeOnRealServer() {
  log.debug("This test will execute");
  assumingThat(() -> true, () -> {
    log.debug("This Executable will execute since the condition is true");
  });
}
  ```
  * En las primeras 3 pruebas,  la condición de la assumption (suposición) no se cumple. Por lo tanto el código que sigue no se ejecuta.  
  * Notar que `assumingThat` acepta un `Executable`.   Si la condición no se cumple, la expresión lambda no será ejecutada.
  * Notar el uso de un `BooleanSupplier` empleado para verificar la condición. Util cuando se  tiene que ejecutar cierta lógica para verificar la condición. Dicho código puede ser reutilizable empleando referencias a métodos.
 ### 3.2 Ejecución condicional de pruebas
 * Adicional al uso de Assumptions, existe una serie de anotaciones que permite habilitar o deshabilitar la ejecución de una clase o de un método de prueba. Estas anotaciones se encuentran en el paquete `org.junit.jupiter.api.condition`
	 * `@DisabledIf`
	 * `@DisabledIfEnvironmentVariable` 
	 * `@DisabledIfSystemProperty` 
	 * `@DisabledOnJre` 
	 * `@DisabledOnOs` 
	 * `@EnabledIf` 
	 * `@EnabledIfEnvironmentVariable` 
	 * `@EnabledIfSystemProperty` 
	 * `@EnabledOnJre` 
	 * `@EnabledOnOs` 
##### Ejemplo @DisabledIf:
```java
@DisabledIf(value = {
  //@formatter:off
  "var d = new Date();",
  "var day = d.getDay()",
  "day == 0 || day ==6"
  //@formatter:on
}, engine = "nashorn", reason = "This test is disabled on weekend: Sunday(day =0),"
  + " saturday(day =6). Current day: {result} ")
@Test
void disabledOnWeekend() {
  LocalDate localDate;
  DayOfWeek today;
  localDate = LocalDate.now();
  today = localDate.getDayOfWeek();
  assertTrue(today != DayOfWeek.SATURDAY && today != DayOfWeek.SUNDAY,
    "This tests should not be executed on weekend");
  log.debug("Executing  this test on {}", today);
}
  ```
  * En general, la prueba se deshabilita en fines de semana (sábado y domingo). Para implementar este comportamiento se emplea `@DisabledIf`
  * Esta anotación acepta 3 parámetros: 
	  * `value:`  Arreglo de cadenas que contiene el código de un script  que se ejecuta para determinar un valor booleano . Si el valor es `true`la prueba se deshabilita. Si el valor es `false`la prueba de habilita y se ejecuta.  Notar que el código es "JavasScript".  La última línea del script se toma como valor de retorno.
	  * `engine:` Script engine empleada para parsear y ejecutar el código del script. Por default se emplea *Oracle nashorn* Este engine permite ejecutar código JS desde Java, e inclusive permite la interoperabilidad entre los 2 lenguajes. Para mayores detalles  hacer clic [aquí](https://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html)
	* `reason:`Cadena empleada para describir la razón por la cual la prueba se habilita o se deshabilita. Notar el uso de `{result}`  para acceder al resultado de la ejecución del script.
##### Otro ejemplo de @DisabledIf
```java
@DisabledIf(value = "Math.random()<0.5")
@Test
void disabledRandomly() {
  log.debug("This test execute randomly ");
}
  ```
* En este ejemplo se emplea Java en lugar de Javascript.
* La prueba se deshabilita si el número generado de forma aleatoria es   menor a 0.5

##### Ejemplo @DisabledIfEnvironmentVariable
```java
/**
 * Ejemplo 2: Uso de @DisabledIfEnvironmentVariable.
 */
@DisabledIfEnvironmentVariable(named = "USER", matches = ".*jorge.*")
@Test
void disableIfUserJorge() {
  String user;
  user = System.getProperty("user.name");
  assertNotEquals("jorge", user,
    () -> "This test should not be executed by user " + user);
  log.debug("This test is executed by user {}  User jorge is prohibited.");
}
  ``` 
  * En este ejemplo,  si el usuario del sistema operativo es *jorge*, o contiene la palabra *jorge*,  la prueba se deshabilita.
  * La notación acepta 2 parámetros:
	  * `named:`El nombre de la variable de entorno cuyo valor se va a obtener. En este ejemplo se emplea la variable `$USER`
	  * `matches:`Expresión regular empleada para verificar si el valor de la variable cumple con ella. Si el valor cumple con la expresión, la prueba se deshabilita. De lo contrario, se ejecuta.
##### Ejemplo @DisabledIfSystemProperty
```java
/**
 * Example 4: This test should be disabled if the Operating System is Mac.
 */
@DisabledIfSystemProperty(named = "os.name", matches = ".*Mac.*")
@Test
void disabledIfMac() {
  String os;
  os = System.getProperty("os.name");
  log.debug("Current operating system: {}", os);
  assertNotNull(os);
  assertFalse(os.contains("Mac"), "This test should not be executed on Mac");
}
```
* En este ejemplo se verifica  el valor de un *System Property* para decidir si la prueba se deshabilita o no.
* Acepta los mismo parámetros que `@DisabledIfEnvironmentVariable`
##### Ejemplo @DisabledOnJRE
```java
/**
 * Example 5: Don`t execute this test for specific JRE Version.
 * {@link JRE} Enum is used as parameter of @DisabledOnJRE
 */
@DisabledOnJre(JRE.JAVA_9)
@Test
void disabledForJRE9() {
  log.debug("This test will be disabled if Java 9 is used");
}
```
* Notar el uso del Enum `JRE` Sus posibles valores son `JAVA_8`, `JAVA_9`, `JAVA_10`, `JAVA_11`, `OTHER`.
* Es posible especificar un arreglo de valores.
##### Ejemplo @DisableOnOs
```java
/**
  * Example 6: Don`t Execute this test for specific JRE Version
  */
  @DisabledOnOs(OS.SOLARIS)
  @Test
  void disableOnSomeOs() {
    log.debug("This test will be disabled if Solaris is used");
  }
  ```
*  Nota el uso del Enum `OS`. Posibles valores son: `AIX`, `LINUX`, `MAC`, `SOLARIS`, `WINDOWS`, `OTHER`.
##### Otro ejemplo con DisableOnOs
* En el siguiente ejemplo se emplea una anotación  personalizada llamada `@ProhibitedOs`que  contiene una lista de sistemas operativos prohibidos.
* Con esta definición  el método de prueba no tiene que rescribir esta lista.
* Otra ventaja es que si esta lista llega a cambiar, solo se tendría que modificar la definición de la anotación dejando intactas a todos los métodos de prueba que hagan uso de ella.
```java
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@DisabledOnOs({ OS.WINDOWS, OS.AIX, OS.SOLARIS })
public @interface ProhibitedOs {
  // no code
}
```
* El método del prueba será:
```java
/**
 * Example 7: Using a custom Annotation (Meta annotated). 
 */
 @Test
 @ProhibitedOs
 void disabledOnSeveralOs() {
   log.debug("This test will be disabled if Solaris, Win or AIX is used");
 }
  ```
  * Finalmente, existe la correspondiente version `@Enable***`  que verifican si la prueba se ejecuta o no con base a los mismos criterios vistos anteriormente.
  ##### Fin de módulo.
