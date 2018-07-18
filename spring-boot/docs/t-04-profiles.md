# Spring Boot
## 4. Profiles.
* Permite separar algunas configuraciones y componentes de la aplicación para ser empleados en diferentes ambientes, por ejemplo: testing, desarrollo, integración continua, producción.
* El property ```spring.profiles.active``` se  emplea para establecer los profiles que se deben activar:
```properties
spring.profiles.active=dev,h2
```
* De forma programática se puede emplear ```
SpringApplication.setAdditionalProfiles(...) ``` antes de ejecutar la aplicaciòn. 
* También se puede emplear la interface ```ConfigurableEnvironment```
* Clases marcadas con ```@Component``` y sus variantes  así como ```@Configuration``` pueden ser anotadas con ```@Profile("profileName")``` para habilitar o deshabilitar su carga en el application context.
* El nombre del profile que se pasa como parámetro a la anotación debe estar activo para que el  bean se incorpore al applicationContext.
##### Ejemplo 1
* Suponer la siguiente configuración  de un ```DataSource```, uno para producción y otro para desarrollo.
```java
@Configuration
public class AppConfig { 

	@Bean
	@Profile("DEV") 
	public DataSource devDataSource() {
        ... 
	}

	@Bean
	@Profile("PROD") 
	public DataSource prodDataSource() {
        ... 
	} 
}
```
##### Ejemplo 2:
* Suponer  que se desea el siguiente comportamiento:
	* En producción se debe activar los niveles de logging  a partir del nivel WARN,   los mensajes se deben escribir adicionalmente a un archivo.
	* En desarrollo el nivel debe ser DEBUG, solo se requiere enviar los mensajes a consola.
* Para lograr lo anterior, basta con agregar 2 configuraciones  en archivos properties empleando la siguiente convención: ```application-{profile-name}.properties```, es decir:
* Contenido de ```application-dev.properties```:
```properties
logging.level.root=DEBUG
```
* Contenido de ```application-prod.properties```:
```properties
logging.path=/var/logs/
logging.file=BookWorm.log
logging.level.root=WARN
```
### 4.1 Empleando @Conditional.
* Representa un mecanismo que permite contar con una mayor flexibilidad para decidir los profiles que se deben activar.   Por ejemplo,  alguna(s) de las siguientes condiciones pudieran ser verificadas para decidir la activación de un profile:
	* La existencia de un clase en el classpath.
	* La existencia de un determinado bean en el applicationContext.
	* La existencia de un archivo en una ubicación en particular.
	* La existencia o verificación de un valor de un property.
	* La existencia o valor de un System property, etc.
* Para hacer uso de esta anotación se requiere crear una clase que implemente a la interface  ```Condition```.
#####  Ejemplo:
```java
public class MySQLDatabaseTypeCondition implements Condition { 

	@Override  
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
		String enabledDBType = System.getProperty("dbType");
		return (enabledDBType != null && enabledDBType.equalsIgnoreCase("MYSQL")); 
	} 
}
```
* En el código anterior se verifica el valor del property ```dbType```. SI su valor es ```MYSQL``` el método ```matches```regresa ```true``` .  Este resultado permitirá habilitar un profile empleando ```@Conditional```
```java
@Bean
@Conditional(MySQLDatabaseTypeCondition.class)
public UserDAO jdbcUserDAO(){
	return new JdbcUserDAO();
}
```
* Para validar si un bean se encuentra registrado se puede emplear  algo similar al siguiente código:
```java 
@Override
public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
	UserDAO userDAO = conditionContext.getBeanFactory().getBean(UserDAO.class);
	return (userDAO == null);
}
```
* Las siguientes anotaciones pueden emplearse para validar algunas de estas condiciones:
```java 
@ConditionalOnBean
@ConditionalOnMissingBean 
@ConditionalOnClass
@ConditionalOnMissingClass
@ConditionalOnProperty
@ConditionalOnResource
@ConditionalOnWebApplication
```

