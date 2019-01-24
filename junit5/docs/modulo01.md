# JUnit 5
## 1. Introducción
* El código de este módulo se encuentra en github correspondiente al paquete `com.jorgerdc.tutoriales.junit5.modulo01`
### 1.1 Iniciando con JUnit 5
* Representa una nueva generación de una de las herramientas más populares para hacer pruebas unitarias en Java: JUnit.
* JUnit 5 es el resultado del proyecto JUnit lambda principalmente.
* A partir de esta versión, JUnit 5 se integra por 3 módulos:
	* JUnit Platform
	* JUnit Jupiter
	* JUnit Vintage
#### 1.1.1 JUnit Platform
* Representa el componente base para ejecutar frameworks para testing que se ejecutan sobre la JVM.
* Define un API representada por la clase ```TestEngine```para desarrollar frameworks de Testing.
* Proporciona herramientas para ejecutar pruebas a línea de comandos, construcción de plugins para Gradle, Maven.
#### 1.1.2 JUnit Jupiter 
* Representa una combinación de un nuevo modelo  y us extensiones para JUnit 5.
* Proporciona una implementación de ```TestEngine```para poder ejecutar pruebas basadas en el proyecto Jupiter.
#### 1.1.3 JUnit Vintage
* Proporciona implementaciones de ```TestEngine``` para versiones anteriores de JUnit:  JUnit 3 y JUnit 4.
#### 1.1.4 Dependencias (Jars) 
* La siguiente imagen muestra  todas las posibles dependencias de JUnit5 (tomada del sitio oficial).
![Dependencias](https://junit.org/junit5/docs/current/user-guide/images/component-diagram.svg)
* Principales artefactos JUnit platform:
	* ```junit-platform-commons```
	* ```junit-platform-console```
	* ```junit-platform-console-standalone```
	* ```junit-platform-engine```
	* ```junit-platform-launcher```
	* ```junit-platform-runner```
	* ```junit-platform-suite-api```
	* ```junit-platform-surefire-provider```
* Principales artefactos JUnit Jupiter
	* **```junit-jupiter-api```** Empleada para escribir Tests
	* **```junit-jupiter-engine```** Implementación de ```junit-platform-engine```
	* ```junit-jupiter-params```
	* ```junit-jupiter-migrationsupport```
##### Ejemplo:
Archivo ```build.gradle```
```groovy
group = 'com.jorgerdc.tutoriales.junit5'
apply plugin: 'java'

dependencies {
  //test API used to write JUnit tests.
  testCompile 'org.junit.jupiter:junit-jupiter-api:5.3.2'
  //junit-jupiter-engine is the implementation of junit-platform-engine
  testRuntime 'org.junit.jupiter:junit-jupiter-engine:5.3.2'
}
repositories {
  jcenter()
  mavenCentral()
}
```
* Notar que se emplean los 2 jars de Jupiter. El primero contiene el API empleada para escribir la prueba unitaria y el segundo la implementación de un ```TestEngine```.  Los test engines se definen en el jar de JUnit platform ```junit-platform-engine```.
* Clase Java:
```java
package com.jorgerdc.tutoriales.junit5.modulo01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * MessageService Test case for JUnit 5
 */
public class MessageServiceTest {

  /**
   * Test methods are annotate with @Test<br>
   * Methods don't have to be <code>public</code><br>
   * Methods must not return a value.
   */
  @Test
  void checkHelloWorldMessage() {
    MessageService service = new MessageService();
    Assertions.assertEquals("Hello World!", service.helloWorld(), "Invalid message");
  }
}
```
* El código es muy similar a una prueba unitaria de JUnit 4.  Las diferencias son los paquetes donde se encuentran las clases y  la clase donde ahora se encuentran los métodos ```assert*```: ```Assertions```.
### 1.2 Principales anotaciones.
* La siguiente lista muestra las principales anotaciones empleadas para escribir pruebas unitarias con JUnit 5. En los siguientes módulos se explica su  significado y uso.
	* ```@Test```
	* ```@ParameterizedTest```
	* ```@RepeatedTest```
	* ```@TestFactory```
	* ```@TestInstance```
	* ```@TestTemplate```
	* ```@DisplayName```
	* ```@BeforeEach```
	* ```@AfterEach```
	* ```@BeforeAll```
	* ```@AfterAll```
	* ```@Nested```
	* ```@Tag```
	* ```@Disabled```
	* ```@ExtendWith```
* Todas las anotaciones se encuentran en el paquete `org.junit.jupiter.api`dentro de la dependencia `junit-jupiter-api`
* Todos los métodos anotados con `@Test`, `@TestTemplate`, `@RepeatedTest`, `@BeforeAll`, `@AfterAll`, `@BeforeEach`, o `@AfterEach` no deben regresar valor alguno.
#### 1.2.1 Meta Anotaciones y Anotaciones compuestas.
* En JUnit 5 las anotaciones pueden ser empleadas como "Meta-Anotaciones".
* Lo anterior significa que es posible crear anotaciones personalizadas  que pueden "Heredar" el comportamiento de una anotación de JUnit.
* Esta característica es útil en especial para evitar repetir una configuración  basada en anotaciones en varias  clases.
* Por ejemplo,  suponer que en la mayoría de las clases  se emplea  la siguiente configuración: `@Tag("security")`
	* `@Tag`se emplea para asignar "etiquetas" a una prueba con la finalidad de clasificaras y filtrarlas empleando dichas etiquetas como criterio de selección. Por ejemplo, tests de seguridad, etc.
	* Para evitar escribir `@Tag("security")` en todas las clases, se puede crear una nueva anotación  de tal forma que en la clase solo sea necesario escribir `@TestSecurity`.  
##### Ejemplo:
* Definición de la anotación:
```java
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Tag("security")
public @interface TestSecurity {
  // no code
}
```
* Uso de la anotación`@TestSecurity` en la prueba:
```java
@TestSecurity
public class MessageServiceMetaTest {

  /**
   * Test methods are annotate with @Test<br>
   * Methods don't have to be <code>public</code><br>
   * Methods must not return a value.
   */
  @Test
  void checkHelloWorldMessage() {
    MessageService service = new MessageService();
    Assertions.assertEquals("Hello World!", service.helloWorld(), "Invalid message");
  }
}
```
##### Fin de módulo.
