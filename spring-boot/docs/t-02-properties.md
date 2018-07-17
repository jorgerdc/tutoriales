# Spring boot
## 2. Configuración de la aplicación.
* Spring boot permite configurar la aplicación a través de diferentes medios externos:
	* Archivos properties
	* Archivos YAML
	* Variables de entorno del s.o.
	* Argumentos en línea de comandos.
* En la aplicación, los valores de las propiedades se pueden recuperar a través de las siguientes anotaciones:
	* ```@value```
	* ```@ConfigurationProperties```
*  Existe un orden establecido para realizar sobrescritura de propiedades. Por ejemplo,  properties especificadas a linea de comandos sobrescriben  properties en archivos ubicados en el classpath:
```shell
java -jar app.jar --name="Spring"
``` 
### 2.1 Archivos properties
* Por default  se usa el archivo con nombre ```application.properties```. 
* Este nombre se puede modificar empleando el property ```spring.config.name```
* ```SpringApplication``` carga archivos properties de las siguientes ubicaciones:
1. Del directorio ```/config``` con respecto al directorio donde se ejecuta la aplicación
2. Del directorio donde se ejecuta la aplicación
3. Dentro de paquete ```/config``` ubicado en el classpath.
4. Dentro del directorio raíz del classpath.
* La lista anterior esta ordenada por precedencia.  Archivos al principio de la lista sobrescriben a los demás.
* Es posible indicar una ubicación personalizada empleando ```spring.config.location``` . Se emplean los prefijos ```file:```y ```classpath:```
* Estas 2 properties debe ser especificadas a linea  de comandos, como variable de entorno o como System property.
* Variables de entorno emplean ```_``` en lugar del punto: ```SPRING_CONFIG_NAME```
* ```spring.config.location``` reemplaza las ubicaciones por default.
* ```spring.config.additional-location``` se puede emplear  en lugar de ```spring.config.location```  para no reemplazarlas.
##### Ejemplo:
```shell
java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/
override.properties
```
### 2.2  Archivos properties con profiles - Multiples ambientes.
* Adicional al archivo ```application.properties```se puede emplear el formato ```application-{profile}.properties``` el cual será empleado cuando se active algún profile:  test, dev, producción, etc.
* En caso de no existir algún profile activado, se puede emplear el archivo ```application-default.properties```
* Si se emplean profiles en los archivos properties, estos sobrescriben al default ```application.properties```
* Si se emplean los properties para especificar ubicaciones o nombres personalizados, el uso de profiles se deshabilita.
### 2.3 Placeholders en archivos properties:
* Se emplea la siguiente sintaxis.
```properties
app.name=MyApp  
app.description=${app.name} is a Spring Boot application
```
