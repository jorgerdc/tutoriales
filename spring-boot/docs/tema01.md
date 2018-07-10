# Spring Boot
## 1. Introducción.
### 1.1 Beneficios  Spring boot
* Configura todos los componentes de la aplicación de forma automática.
* Ofrece flexibilidad para modificar defaults.
* Entre otras opciones, las aplicaciones en  Spring boot pueden ser iniciadas empleando simplemente el comando ```java -jar```.
### 1.2 Administración simple de dependencias.
* Spring boot hace uso de dependencias del tipo ```spring-boot-stater-*```.
* Los starters configuran e incluyen ciertas dependencias que comúnmente se emplean para diferentes tipos de aplicaciones.
##### Ejemplo:
* ```spring-boot-starter-web```
	* Adicional a las dependencias, el starter también configura algunos Beans que comúnmente son configurados en una app web: ```DispatcherServlet```,  ```ResourceHandler```, etc. 
	* Estos Beans son configurados con valores por default comúnmente empleados. 
* ```spring-boot-starter-jpa```
* Etc.
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
public class Main {

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
	* ```spring-boot-starter-test```
* El punto central de inicio de la aplicación se especifica en el método ```main```de la clase.  
* Se autoconfigura también un servidor tomcat para desplegar la aplicación en dicho contenedor.
* Para ejecutar la aplicación ejecutar en una terminal la siguiente instrucción:
```bash 
./gradlew bootRun
``` 
* Observar que se hace uso de wrapper de Gradle como buena práctica de portabilidad. 
*  Finalmente Abrir la aplicación en [http://localhost:8080/](http://localhost:8080/) 
