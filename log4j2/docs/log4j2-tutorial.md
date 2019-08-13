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
## Configuración
### Ecosistema
* Existen diversas herramientas para la administración de proyectos, con tipos de instalación tradicional como: Maven, Gradle, Ivy, etc.
* Para esta versión se tienen diversas `appenders` para poder configurar la bitácora de una manera más clara y consciza, a continucación se listan algunos:
	1.  CouchDB
	2. MongoDB
	3. Cassandra
	4. IO Streams
	5. Scala API
* En la siguiente liga se encuentrar la configuración tradicional y appenders mencionados en el punto anterior: https://logging.apache.org/log4j/2.x/maven-artifacts.html
### Archivo de configuración o implementación
* Existen diversos formatos para realizar la configuración de Log4J :
	1. Json
	2. Yaml
	3. Xml
	4. Archivo de propiedades "fileName.properties".
	* Para configurar cada una de las implementaciones visitar la liga correspondiente.
		1. `Json` https://logging.apache.org/log4j/2.x/manual/configuration.html#JSON
		2. `Yaml`https://logging.apache.org/log4j/2.x/manual/configuration.html#YAML
		3. `Xml` https://logging.apache.org/log4j/2.x/manual/configuration.html#XML
				 
* Log4J2 cuenta con una configuración por default que es aplicada en caso de no encontrar archivos de configuración.
* Log4J2 define la clase `ConfigurationFactory` encargada de detectar la presencia de archivos de configuración con base a las siguientes reglas:
	1. Se intenta ubicar el archivo especificado por una JVM system property:  `log4j.configurationFile`
	2. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2-test.properties` in the classpath.
	3. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2-test.yaml` o `log4j2-test.yml` in the classpath.
	4. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2-test.json` o `log4j2-test.jsn` in the classpath.
	5. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2-test.xml` in the classpath. 
	6. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2.properties` in the classpath.
	7. En caso de no existir el archivo especificado en el punto anterior, la clase `ConfigurationFactory` buscará `log4j2.yaml` o `log4j2.yml` in the classpath.
	8. En caso de no existir el archivo especificado en el punto anterior, la clase  `ConfigurationFactory` buscará `log4j2.json` o `log4j2.jsn`.
	9. En caso de no existir el archivo especificado en el punto anterior, la clase, `ConfigurationFactory` buscará `log4j2.xml`.
	10. Sí no encuentra ningún archivo de configuración, se cargará el default y la salida de la traza de errores será en la consola 
### Configurando Log4J2 a través de un archivo properties.
* Agregar archivo log4j2.properties en la ruta: `/src/main/resources` 
```bash
#Nivel de eventos Log4j internos que deben registrarse en la consola. 
#Se recomienda poner debug para mostrar el comportamiento de un aplicativo ya que manda a consola registro de 
lo que sucede incluso antes de encontrar el archivo "properties", util para encontrar errores de inicialización.
#Posibles valores: "trace", "debug", "info", "warn", "error" and "fatal"
status=debug

#File name. "Optional"
name = PropertiesConfig
 
 #Path log file
 property.filename = logs/logExample
 
 #Type appender, this can be console, file, rolling, etc.
appenders = console, file
 
 ##		File configuration section
 #FileAppender to initialize configuration
appender.file.type = File
appender.file.name = LOGFILE
appender.file.fileName=${filename}/log4j2
appender.file.layout.type=PatternLayout

# Specify the pattern of the logs
appender.file.layout.pattern=[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n

#Configuration to writte in file
loggers=file
logger.file.name=log4j2.HelloWorldLog4j2
logger.file.level = info
logger.file.appenderRefs = file
logger.file.appenderRef.file.ref = LOGFILE


##		Console configuration section
# ConsoleAppender to initialize configurations
appender.console.type = Console
appender.console.name = STDOUT
appender.console.layout.type = PatternLayout

# Specify the pattern of the logs
appender.console.layout.pattern = %d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
 
 #Configuration appender type, in this case show logs in console
rootLogger.appenderRefs = stdout
rootLogger.appenderRef.stdout.ref = STDOUT
 
 #Level of events that belong to a class
rootLogger.level = info
#In addition it can configure in code, the equivalent values of level are:
#		OFF  		   0
#		FATAL 	 100
#		ERROR  200
#		WARN   300
#		INFO     400
#		DEBUG  500
#		TRACE   600
#		ALL  Integer.MAX_VALUE 
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
### 2 LogManager
* Es una clase java con características especiales para log4j2.
* Esta clase es usada por el usuario de la aplicación para crear las instancias de logger.
* Gestiona la configuración de logging framework, este se encarga de leer la configuración inicial que se tendra en las bitácoras de la aplicación.
* Define la configuración que es aplicada por default.
* Se puede especificar el nivel de logeo `info, debug, fatal, etc`.
* Se carga durante el inicio de la aplicación, no es posible modificarla posteriormente.
* La configurarción se puede realizar mediante una clase java.
#
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
Fin de modulo


