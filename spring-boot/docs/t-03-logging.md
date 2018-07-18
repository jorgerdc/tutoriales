# Spring boot
## 3. Logging
* Internamente Spring hace uso de ```commons-logging``` , pero soporta las siguientes alternativas:
	* Java Util logging
	* Log4J2
	* Logback
* Spring boot hace uso de la clase ```LoggingSystem```encargada de configurar  logging con base a las librerías encontradas en el classpath.
* Por default  **Logback** es activado haciendo uso de starters.
* Por default los mensajes se  mandan a consola con nivel INFO, WARN, ERROR.
* Para habilitar debug, trace se puede emplear ```--debug o --trace```a línea de comandos.
* Adicionalmente se puede emplear el property ```debug=true o trace=true```. 
* Habilitar debug  con estas opciones NO habilita debug para la aplicación.
* Para configurar niveles  y los paquetes  asociados se emplean los siguientes properties:
##### Ejemplo:
```properties
logging.level.root=WARN 
logging.level.org.springframework.web=DEBUG 
logging.level.org.hibernate=ERROR
logging.level.com.mycompany=DEBUG
#enviar mensajes a un archivo
logging.path=/var/logs/mylog.log
# O de forma alternativa empleando un path definido en logging.path:
logging.file= mylog.log
```
* Estas propiedades evitan crear un archivo de configuración particular a cada implementación, por ejemplo: ```log4j.properties``` o  ```logback.xml```
* Si se desea tener un mayor control, se pueden agregar estos archivos al classpath,  spring boot los cargará automáticamente.
 
### 3.1 Habilitar Log4J 2
* Si se desea emplear Log4J 2 en lugar de Logback, se requiere excluir ```spring-boot-starter-logging``` y agregar ```org.springframework.boot:spring-boot-starter-log4j2```:
```groovy
configurations {
	all {
		exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
	}
}
dependencies {
	compile("org.springframework.boot:spring-boot-starter-log4j2")
}
```
