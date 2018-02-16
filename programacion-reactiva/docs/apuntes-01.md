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
```Java
public class LibroService {
    private LibroDAO libroDAO = new LibroDAO();
    public Observable<Libro> getAll() {
        return Observable.fromArray(libroDAO.getAll());
    }
}
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbNzQ2NzU5NTYxXX0=
-->