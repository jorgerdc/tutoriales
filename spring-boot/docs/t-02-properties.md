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
### 2.4 Inyección de properties.
* Existen 2 mecanismos principales para obtener valores de properties:
	* ```@Value("property name")```   Inyecta el valor de un property
	* ```@ConfigurationProperties("prefix")```   Permite inicializar los atributos de un POJO  empleando los valores de los properties.
* Este POJO puede ser incluido en el application context. Para ello se debe registrar empleando ```@EnableConfigurationProperties```:
```java
@Configuration @EnableConfigurationProperties(POJO.class) 
public class MyConfiguration {  
}
```
* En nombre del bean que se registra en el application context es ```<prefix>-<fqn>``` ,  donde ```fqn``` es el nombre completo de la clase  (POJO).  Prefix corresponde con el prefijo incluido en ```@ConfigurationProperties```
* Adicionalmente se puede emplear lo siguiente para evitar el uso de esta última anotación de forma directa:
```java
@Component 
@ConfigurationProperties(prefix="myprefix") 
public class MyPOJOProperties {
 // ... see the preceding example 
}
```
* El POJO se puede validar para verificar que la inyección de propiedades sea la esperada empleando ```@Validated```.
* Para validar, se emplean las anotaciones de JSR-303, por ejemplo ```@NotNull```, etc.
##### Ejemplo:
* El código completo esta [aquí](https://github.com/jorgerdc/tutoriales/tree/master/spring-boot/parent-spring-boot/properties-spring-boot)
1. Observar en el siguiente ejemplo las ubicaciones donde se encuentra ```application.properties```
![enter image description here](https://lh3.googleusercontent.com/oH-HWjL4gY728fzHtvFyBNOZXyxeaPsL3IHYsmBU4odhzpmwA8rPFhYDhs4zj5oeUqr4Nw22is7X "project")
2. Observar el contenido del archivo ```config/application.properties``` el cual representa el nivel más alto de precedencia. 
```properties
#this property exists in all property files
app.message=I'm  at  config  directory  level  1

#project properties
app.project.name=Awesome project
app.project.projectId=100
app.project.url=http://www.project.com
app.project.active=true
app.project.owner.name=Super man

#this property exists only in this file
app.level1=level 1
```
3. Las properties ```app.project.*```se emplean para ser inyectadas en el siguiente Bean:
```java
@Component
@ConfigurationProperties(prefix = "app.project")
public class Project {
	private String name;
	private Long projectId;
	private URL url;
	private boolean active;
	private Person owner;
	// getters, setters
}
```
* Notar el prefijo empleado ```app.project```  y los nombres de los atributos los chales hacen match con los nombres de  los properties. 
* Observar el uso de POJOS anidados: ```app.project.owner.name```
4. Observar el código de la prueba unitaria:
```java
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class PropertyTest {

	private static final Logger log = LoggerFactory.getLogger(PropertyTest.class);

	@Resource
	private Project project;

	@Value("${app.message}")
	private String appMessageLevel1;

	@Value("${app.level1}")
	private String appLevel1;

	@Value("${app.level2}")
	private String appLevel2;

	@Value("${app.level3}")
	private String appLevel3;

	@Value("${app.level4}")
	private String appLevel4;

	@Test
	public void checkProperties() throws MalformedURLException {
		Project expected;
		Person owner;
		log.debug("Checking project values: {}",  project);
		expected = new Project();
		expected.setActive(true);
		expected.setName("Awesome project");
		owner = new Person();
		owner.setName("Super man");
		expected.setOwner(owner);
		expected.setProjectId(100L);
		expected.setUrl(new URL("http://www.project.com"));
		assertEquals(expected.toString(), project.toString());
	}
	
	@Test
	public void checkPropertyOverride() {
		assertEquals("I'm at config directory level 1",  appMessageLevel1);
	}

	@Test
	public void checkPropertiesInOtherFiles() {
		assertEquals("level 1", appLevel1);
		assertEquals("level 2", appLevel2);
		assertEquals("level 3", appLevel3);
		assertEquals("level 4", appLevel4);
	}
}
```
* Observar el uso de ```@Value```para acceder a los valores de los properties ubicados en los 4 archivos ```application.properties```
* Observar que se inyecta el bean ```Project``` con sus atributos inicializados.
* La prueba verifica que la inyección de todos los valores sean los esperados.

