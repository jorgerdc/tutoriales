# Spring Boot
## 1. Introducción.
* Spring boot es un  framework  que facilita el desarrollo de aplicaciones basadas en Spring  de forma rápida y fácil. 
* Uno de los objetivos principales es evitar la configuración y programación que repetidamente se realiza al desarrollar una aplicación.
* Los conceptos clave que utiliza spring boot para lograr estos objetivos son:
	* Spring boot starters
	* Spring boot auto configuration
	* Spring boot actuator
		* Permite conocer aspectos de la aplicación en producción: configuración de beans, mapeo de URLs, parámetros de configuración, métricas de desempeño y buena salud.
	* Easy-to-use embedded servlet container support.
### 1.1 Beneficios  Spring boot
* Configura todos los componentes de la aplicación de forma automática.
* Ofrece flexibilidad para modificar defaults.
* Entre otras opciones, las aplicaciones en  Spring boot pueden ser iniciadas empleando simplemente el comando ```java -jar```.
### 1.2 Administración simple de dependencias.
* Spring boot hace uso de dependencias del tipo ```spring-boot-stater-*```.
* Los starters configuran e incluyen ciertas dependencias que comúnmente se emplean para diferentes tipos de aplicaciones.
* El "*" se sustituye por el tipo de aplicación que se desea desarrollar.
##### Ejemplos:
* ```spring-boot-starter-webflux```
* ```spring-boot-starter-data-jpa```
*  ```spring-boot-starter-web```
	* Adicional a las dependencias, el starter también configura algunos Beans que comúnmente son configurados en una app web: ```DispatcherServlet```,  ```ResourceHandler```, etc. 
	* Estos Beans son configurados con valores por default comúnmente empleados. 
* ```spring-boot-starter-data-mongodb```
* Etc. La  lista completa  se encuentra [aquí](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-starter)
### 1.3 Starters y Auto Configuración
* Ambos conceptos pueden ser incorporados conjuntamente o por separado.
* Es posible administrar dependencias sin el uso de starters, pero conservar la capacidad de autoconfiguración.

##### Ejemplo Hola Mundo con Spring boot
* ```build.gradle```
```groovy
buildscript {
	repositories {
		jcenter()
		maven { url 'https://repo.spring.io/snapshot' }
		maven { url 'https://repo.spring.io/milestone' }
	}
	dependencies {
		classpath 'org.springframework.boot:spring-boot-gradle-plugin:2.1.0.BUILD-SNAPSHOT'
	}
}
apply plugin: 'java'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

jar {
	baseName = 'hola-mundo-sboot'
	version = '0.0.1-SNAPSHOT'
}
repositories {
	jcenter()
	maven { url "https://repo.spring.io/snapshot" }
	maven { url "https://repo.spring.io/milestone" }
}
dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	testCompile("org.springframework.boot:spring-boot-starter-test")
}
``` 
* Uno de los puntos más relevantes del script anterior es la declaración del plugin de Gradle para Spring boot:
```groovy
apply plugin: 'io.spring.dependency-management'
```
* La documentación se encuentra en la siguiente URL. (Cambiar la versión en caso de ser necesario).
[https://docs.spring.io/spring-boot/docs/2.1.0.BUILD-SNAPSHOT/gradle-plugin/reference/html/](https://docs.spring.io/spring-boot/docs/2.1.0.BUILD-SNAPSHOT/gradle-plugin/reference/html/)
* Observar que las dependencias no tienen número de versión.  
* El uso de este plugin permite incorporar el archivo bom (bill of materials)  ```spring-boot-dependencies``` que define las versiones por default a emplear.
	* El archivo ```bom.xml``` proviene del concepto de Bill of materials introducido por Maven para facilitar la administración de versiones de las dependencias de una App. 
* Clase principal de la aplicación:
```java
@RestController
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
```
* La anotación ```@EnableAutoConfiguration```  es la encargada de configurar la aplicación con base a las dependencias agregadas al classpath. 
* En este ejemplo se agregaron los siguientes starters:
	* ```spring-boot-starter-web```
		* Al existir estas dependencias,   se realizará la configuración para levantar una aplicación web.
		* Algunas de las dependencias que se agregan con este starter son: ```spring-webmvc, jackson-json, validation-api, tomcat```, etc.
	* ```spring-boot-starter-test```
		* Empleada para dar soporte y configuración automática a pruebas unitarias y de integración entre otras.
* El punto central de inicio de la aplicación se especifica en el método ```main```de la clase.  
* Se autoconfigura también un servidor tomcat para desplegar la aplicación en dicho contenedor. 
* Por default se emplea tomcat.  Si se deseara emplear otro servidor, por ejemplo Jetty,   se excluye ```spring- boot-starter-tomcat``` y se agrega ```spring- boot-starter-jetty```

### 1.4 Ejecución de la aplicación
#### 1.4.1 Ejecución de la aplicación con gradle
* Para ejecutar la aplicación ejecutar en una terminal la siguiente instrucción:
```bash 
./gradlew bootRun
``` 
* Observar que se hace uso de wrapper de Gradle como buena práctica de portabilidad. 
*  Finalmente Abrir la aplicación en [http://localhost:8080/](http://localhost:8080/) 
#### 1.4.2 Ejecución con fat Jars o Uber Jars.
* Fat Jar o Jar ejecutable es un Jar que contiene todo lo necesario para ejecutar la aplicación (aplicación auto contenida). Generalmente son Jars de varios MB de tamaño.
* En este tipo de aplicaciones es común tener Jars anidados. Es decir, Jars dentro de otros.
* Java no soporta Jars anidados. 
* Spring boot ofrece una solución conveniente para realizar el manejo de este tipo de Jars a través de la clase ```org.springframework.boot.loader.jar.JarFile```
* Para generar un Fat Jar  a través de  esta  funcionalidad, basta con ejecutar la siguiente tarea en gradle:
```shell
./gradlew bootJar
```
* Esto es posible gracias a que se emplea el plugin de spring boot configurado anteriormente.
* En Gradle, el archivo se genera en el directorio ```build/libs```
* Para ejecutar la aplicación:
```shell
lap-mac:libs jorge$ java -jar raven-course-spring-boot.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::  (v2.1.0.BUILD-SNAPSHOT)

2018-07-09 20:59:20.100  INFO 1467 --- [           main] com.raven.Main                           : Starting Main on lap-mac.local with PID 1467 (/Volumes/PROYS/Github/individual/raven/raven-course-spring-boot/build/libs/raven-course-spring-boot.jar started by jorge in /Volumes/PROYS/Github/individual/raven/raven-course-spring-boot/build/libs)
```
### 1.5 Estructura recomendada para un proyecto, buenas prácticas.
#### 1.5.1 Clase principal de la aplicación
* La clase principal que contiene al método ```main``` se recomienda  ubicarla en un paquete raíz o hasta un nivel mayor al de las demás clases.
* Lo anterior con la finalidad de hacer una correcta detección de beans.  En caso de no encontrarse en un paquete raíz, se puede emplear el atributo ```basePackages```:
*  ```@ComponentScan(basePackages = "com.mycompany.myproject")```
* Típicamente  la clase se llama ```Application.java```
* La anotación ```@SpringBootApplication```puede emplearse para anotar esta clase en lugar de las siguientes  anotaciones. Es decir, cubre las funcionalidades de las siguientes anotaciones:
	* ```@EnableAutoConfiguration```
	*  ```@ComponentScan ``` habilita ```@Component``` para ubicar beans en el paquete donde esta la clase ```Application```
	* ```@Configuration```
* ```@SpringBootApplication```  realiza automáticamente el escaneo de componentes anotados a partir del paquete donde se encuentra la clase ```Application```.  Por tal razón ```@ComponentScan```se puede omitir.
##### Ejemplo:
```java
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
* En resumen ```@SpringBootApplication``` es una anotación compuesta por las siguientes anotaciones:
```java
@Target(value=TYPE)
 @Retention(value=RUNTIME)
 @Documented
 @Inherited
 @SpringBootConfiguration
 @EnableAutoConfiguration
 @ComponentScan(excludeFilters={@ComponentScan.Filter(type=CUSTOM,classes=TypeExcludeFilter.class),})
```

#### 1.5.2 Incorporando múltiples componentes a la aplicación (beans).
* Spring boot recomienda usar la configuración basada en Java con respecto al uso de XML.
* ```@Configuration```Permite definir los beans necesarios o adicionales.
* Es posible tener varias clases que definen beans.
*   ```@Import```se emplea para  incluir definiciones de beans en múltiples clases.
* ```@ImportResource``` se emplea en caso de usar XML.


