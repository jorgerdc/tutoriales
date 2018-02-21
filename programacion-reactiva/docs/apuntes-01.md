# Programación Reactiva
## 1. Conceptos básicos
###  ¿Qué es la programación reactiva?
* Modelo de computación que puede ser alterado por cierto tipo de eventos los cuales pueden ser procesados o ignorados.
* Es una técnica de programación  en la que las tareas a realizar se ejecutan de manera asíncrona. Esta ejecución está regida o dirigida con respecto a la ocurrencia de eventos  (event-driven).  
* Este esquema de procesamiento asíncrono se emplea principalmente para manejar grandes cantidades de flujos de información de forma continua. *"Sistemas reactivos reaccionan a los datos a través de la ejecución de código asociado a diversos eventos"*
	* En programación reactiva se hace uso de flujo de datos, se monitorean y el programa reacciona o hace algo cuando llega un dato.
* Algunas tecnologías de uso:
	* message-passing framework
	* Ejecución asíncrona  de tareas basado en el concepto de event-driven tasks.
* Beneficios
	* Escalabilidad horizontal:  Manejo de grandes cantidades de eventos.
	* Implementación de componentes con un bajo acoplamiento, fallas pueden ser aisladas fácilmente. 

#### Patrón de diseño Observer
La programación reactiva está basada en este patrón:
* Cuando el estado de un objeto cambia, dicho evento es notificado a otros objetos, y se realiza alguna acción. 
* Una aplicación puede hacer *polling*, es decir, puede preguntar continuamente si ha ocurrido algún cambio (evento).
* En programación reactiva, en lugar de hacer polling,  se hace *pushing*, es decir, cuando ocurre  un evento, se realiza una notificación asíncrona a todos los interesados (observers)  y cada observador realizará ciertas acciones: *Software que reacciona a estímulos.*
* En términos de programación los  *observers*  están representados por funciones que se ejecutan cuando ocurre un evento.

#### Características de una App Reactiva (Reactive Manifiesto)
* Responsiva . 
	* La comunicación entre el cliente y la aplicación debe ser continua.
	* El cliente siempre estará ocupado con la aplicación, no existen tiempos de espera: *Dame algo en lugar de nada.* 
	* Por ejemplo, en una búsqueda, el sistema envía los primeros 10 resultados, el usuario los revisa mientras que la aplicación continua la búsqueda de los siguientes 10. 
* Elastic (escalable).
	* El sistema es capaz de mantener sus tiempos de respuesta a pesar de existir un incremento  considerable  en el  número de peticiones concurrentes.  
* Resilient (tolerante a fallas). 
	* La aplicación es capaz de auto recuperarse cuando  ocurre una falla. 
	* Por ejemplo, si un servicio de negocio falla, debería existir otro que atienda a la petición sin que el cliente se percate de ello.
* Message-driven.  
	* Arquitectura que permite hacer a una aplicación escalable, tolerante a fallas, y reactiva, emplead para comunicar sistemas distribuidos.

Las características anteriores representan una nueva forma de desarrollar aplicaciones distribuidas:  *Sistemas distribuidos bien hechos*.

* Como se mencionó anteriormente,  una app reactiva maneja flujos de datos. Si la cantidad de datos a procesar es enorme, el *consumidor* le notifica al *productor (cliente)*  de esta condición,  el productor disminuirá la cantidad de datos o mensajes.  Es decir, existe un esquema de auto adaptación.   
* Esta idea se documenta en el protocolo llamado *asynchronous and nonblocking back-pressure protocol* .
* La concurrencia en programación reactiva se logra a través de un modelo llamado *concurrencia basada en tareas*: El hilo de ejecución se libera cuando ya no puede avanzar más, por ejemplo, no espera por respuestas  de operaciones I/O. Una vez que se obtiene respuesta, se le notifica al productor.
## 2. RxJava
* RxJava es el set de herramientas y librerías para escribir código reactivo en  Java.
* Algunos usos:
	* Procesamiento de flujo de datos provenientes de la red
	* Aplicaciones gráficas: JavaFx
* Datos son generados por un *publisher*
* Datos son recibidos por un *consumer* 
### Principales clases  
* ``Observable`` No soporta protocolo back-presure
* ``Flowable`` Soporta el protocolo back-presure (reactive stream protocol). Adecuado para streams con gran cantidad de datos, por ejemplo, conexiones TCP. 
* ``Single``
* ``Maybe``
* ``Completable``
   #### Observable
* Observable es un objeto que obtiene  datos de manera constante de una fuente determinada.
* Desacopla a la fuente de datos con el consumidor.
* Al obtener los datos, notifica de inmediato a los consumidores interesados.
* Consumidores son notificados varias veces conforme los datos llegan.
##### Ejemplo 1:
* Configuración gradle:
```groovy 
apply plugin: 'java'

repositories {
    mavenCentral()
    jcenter()
}  
sourceCompatibility = 1.8
targetCompatibility = 1.8 

tasks.withType(JavaCompile) {
	options.encoding = 'ISO-8859-1'
}

dependencies {
	testCompile 'junit:junit:4.12'	 	    
    compile 'org.slf4j:slf4j-api:1.7.25'
    runtime 'org.slf4j:slf4j-log4j12:1.7.25'
	compile 'io.reactivex.rxjava2:rxjava:2.1.9'	    
}

```

* Clase `Libro` (POJO) 
```Java
public class Libro {
    private String nombre;
    private String clave;
    public Libro(String nombre, String clave) {
        super();
        this.nombre = nombre;
        this.clave = clave;
    }
    // getters and setters
}
```
* Clase `LibroDAO` (Mock Object) simula la fuente de datos.
```java
public class LibroDAO {
    private static final Libro[] libros = new Libro[] { 
	    new Libro("La Biblia", "001"),
        new Libro("Citas del Presidente Mao Tse-Tung", "002"), 
        new Libro("Harry Potter", "003"),
        new Libro("El Señor de los Anillos", "004"), 
        new Libro("El Alquimista", "005"),
        new Libro("El Código da Vinci", "006"), 
        new Libro("Crepúsculo", "007"),
        new Libro("Lo que el viento se llevó ", "008") };
        
    public Libro[] getAll() {
        return libros;
    }
}
```
* Clase `LibroService` Obtiene objetos `Observable<Libro>`

```Java
public class LibroService {
    private LibroDAO libroDAO = new LibroDAO();
    public Observable<Libro> getAll() {
        return Observable.fromArray(libroDAO.getAll());
    }
}
```
#### Observer
* Objeto que desea ser notificado cuando el estado de los objetos en los que está interesado ha cambiado.
* En el ejemplo anterior, este objeto desea ser notificado cuando lleguen datos como resultado del proceso de búsqueda de libros.
* Para que el *Observer* sea notificado, este se debe ***suscribir*** con el con el objeto **Observable**.

La interfaz `Observer` define 3 métodos (callbacks) que permiten hacer una acción cuando este es noficado:
* `onNext`
* `onError`
* `onComplete`

```java
public class LibroClient {
    private LibroService libroService = new LibroService();
    private void buscaLibros() {
        libroService.getAll().subscribe(System.out::println);
    }
    public static void main(String[] args) {
        new LibroClient().buscaLibros();
    }
}
```
La salida del programa es:
```
Libro [nombre=La Biblia, clave=001]
Libro [nombre=Citas del Presidente Mao Tse-Tung, clave=002]
Libro [nombre=Harry Potter, clave=003]
Libro [nombre=El Señor de los Anillos, clave=004]
Libro [nombre=El Alquimista, clave=005]
Libro [nombre=El Código da Vinci, clave=006]
Libro [nombre=Crepúsculo, clave=007]
Libro [nombre=Lo que el viento se llevó , clave=008]
```
### Comparación Observer y Observable
* Observable representa la fuente del stream de datos (Sender)
* Observer escucha  por datos emitidos (Receiver)
* Observer se subscribe (escucha) al Observable.
* Observer actua ante la ocurrencia de un evento: secuencia de datos emitida por el Observable.
* Varios Observers pueden subscribirse al mismo Observable.
### Arquitectura Observable
1. Definir un Observer con el código a ejecutar para cada valor emitido por el Observable.
2. Llamar un método que regrese un objeto ```Observable```
3. Suscribir al ```Observer``` empleando el objeto anterior tipo ```Observable```.
4. Indicarle al ```Observable``` que tiene un nuevo subscriptor esperando valores  una vez que estén disponibles.
5. El método ```subscribe```  conecta o asocia  aun ```Observer``` con un ```Observable```. El subscriptor no requiere bloquear el hilo de ejecución, los valores llegarán al ```Observer``` (llegarán al código especificado) cuando estén listos.


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTUzODIwMDA4XX0=
-->