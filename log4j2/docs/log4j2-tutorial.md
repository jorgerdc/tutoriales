# Log4J 2
## 1 Características
### 1.1 Introducción
* Log4j2 compatible y seguro ya que usa las mismas funcionalidades de slf4j.
* Log4j2 más extenso que slf4j.
* Log4j2 escalable porque puede soportar otras implementaciones. 
* Log4j2 incluye integración mediante el módulo o puente "log4j-to-slf4j" para cambiar a slf4j cuando se requiera.
* No permite multiples implementaciones.
* Algunas de las funcionalidades de Log4j2:
	* Message API
	* Java 8 lambda support
	* Mixing {}-style
	*  CloseableThreadContext 
	* Log4j2's ThreadContext
	* SLF4J does not support the FATAL log level.
	* Log4j2 has support for custom log levels.
	* The Log4j2 API accepts any Object, not just Strings
	* The above you get for free just by using the Log4j2 API directly. 
	* SLF4J Markers'
## 2 Configuración de Log4j2
### 2.1 Archivo de configuración o implementación
* Existen 4 diversos tipo de configuración o implementación, tales como:
	 1. Json
	 2. Yaml
	 3. Xml
	 4. Archivo de propiedades. "fileName.properties".
	* Para configurar cada una de las implementaciones visitar la liga correspondiente.
		1. `Json` https://logging.apache.org/log4j/2.x/manual/configuration.html#JSON
		2. `Yaml`https://logging.apache.org/log4j/2.x/manual/configuration.html#YAML
		3. `Xml` https://logging.apache.org/log4j/2.x/manual/configuration.html#XML
				 
* Log4J2 cuenta con una configuración por default si no encuentra archivo a cargar.
* Log4j2 tiene una clase llamada: `ConfigurationFactory` la cual se encarga de la configuración de las diversas implementaciones.
* `ConfigurationFactory` contiene lógica para encontrar la implementación a cargar, el orden de busqueda es el siguiente :
	1. Primero buscará el archivo especificado en la propiedad: "log4j.configurationFile".
	2. Si no existe el archivo `log4j.configurationFile` la clase `ConfigurationFactory` buscará `log4j2-test.properties`.
	3. Si no existe el archivo anterior la clase `ConfigurationFactory` buscará `log4j2-test.yaml` o `log4j2-test.yml`.
	4. Si no existe el archivo anterior la clase `ConfigurationFactory` buscará `log4j2-test.json` o `log4j2-test.jsn`.
	5. Si no existe el archivo anterior la clase `ConfigurationFactory` buscará `log4j2-test.xml` 
	6. Sí el archivo de prueba anterior no existe `ConfigurationFactory` buscará `log4j2.properties`
	7. Sí el archivo de propiedades anterior no existe `ConfigurationFactory` buscará `log4j2.yaml` o `log4j2.yml`.
	8. Sí el archivo anterior no existe  `ConfigurationFactory` buscará `log4j2.json` o `log4j2.jsn`.
	9. Sí el archivo anterior no existe, `ConfigurationFactory` buscará `log4j2.xml`.
	10. Sí no encuentra ningún archivo de configuración, se cargará el default y la salida de la traza de errores será en la consola 
### 2.1.1 Configurando log4j2 con archivo de propiedades
A continuación se muestra la configuración clásica estandar de un aplicativo, si se desea cualquier otra implementación, retomar la sección 2.1.
* Agregar archivo log42.properties en la ruta: `/src/main/resources` 

Datos de archivo de propiedades
```bash
status = error
name = PropertiesConfig
 
filters = threshold
 
filter.threshold.type = ThresholdFilter
filter.threshold.level = debug
 
appenders = console
 
appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout
appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
 
rootLogger.level = debug
rootLogger.appenderRefs = stdout
rootLogger.appenderRef.stdout.ref = STDOUT
```
* Agregar la configuración correspondiente "anexar dependencia", para este caso de prueba usaremos la herramienta gradle.

Agregar dependencia log42:
```
dependencies {
	compile group:  'org.apache.logging.log4j', name:  'log4j-api', version:  '2.6.1'
    compile group: 'org.apache.logging.log4j', name: 'log4j-core', version: '2.6.1'
}
```
#
### 2.2 Descripción LogManager
* Es una clase java con características especiales para log4j2.
* Esta clase es usada por el cliente de la aplicación para solicitar las instancias de logger.
* Gestiona la configuración de logging framework, este se encarga de leer la configuración inicial que se tendra en las bitácoras de la aplicación.
* Contiene configuración default, sí no se especifica alguna en particular.
* Se puede especificar el nivel de logeo `info, debug, fatal, etc`.
* Se carga durante el inicio del aplicativo pero no se puede modificar subsecuentemente cargado.
* La configurarción se puede realizar mediante una clase java.
#
### 2.3 Comprobación de configuración
* Ejecutar la siguiente clase para confirmar que la configuración anterior sea correcta.
```bash
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelloWorld {

  private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class.getName());

  public static void main(String[] args) {
    LOGGER.debug("Debug Message Logged !!!");
    LOGGER.info("Info Message Logged !!!");
    LOGGER.error("Error Message Logged !!!", new NullPointerException("NullError"));
  }
}
```
* Se debe mostrar una salida en consola, como la siguiente.
```bash
2019-05-18 18:39:56 DEBUG HelloWorld:21 - Debug Message Logged !!!
2019-05-18 18:39:56 INFO  HelloWorld:22 - Info Message Logged !!!
2019-05-18 18:39:56 ERROR HelloWorld:23 - Error Message Logged !!!
java.lang.NullPointerException: NullError
	at log4j2.HelloWorld.main(HelloWorld.java:23) [main/:?]
```



