
# Gradle
## 1. [Introducción](https://docs.gradle.org/current/userguide/what_is_gradle.html#gradle_overview)
* Gradle es una herramienta open-source para automatizar la construcción de cualquier tipo de software **(compilar código fuente en código binario, empaquetar código binario y ejecutar pruebas automatizadas).**

## Caracteristicas
### 1.1 Alto desempeño
* Evita tareas innecesarias, ejecutando solo las necesarias al detectar las entradas o salidas que han cambiado.
* Se puede hacer uso de memoria en cache para permitir la reutilización de resultados de tareas de ejecuciones anteriores o incluso desde una máquina diferente (con una memoria caché de compilación compartida).
### 1.2 Fundación JVM
* Gradle se ejecuta sobre la JVM por lo cual se puede tener instalado el ***JDK*** y hacer uso de la misma.
* Para usuarios Java es una ventaja ya que puede hacer uso de las API en la lógica de compilación tales como los tipos de tareas y complementos personalizados. 
* Por su arquitectura facilita la ejecución de Gradle en diferentes plataformas.
* No se limita a proyectos con JVM.
* Viene incluido el soporte para proyectos nativos.
### 1.3 Convenciones
* Gradle toma las cierta arquitectura de Maven y crea tipos comunes de proyectos, como:
	* Proyectos Java: Fácil de construir mediante la implementación de convenciones 
* Aplicar los plugins correspondientes  para poder fácilmente crear pequeños scripts para varios proyectos.
* Permite sobre escribir y crear tareas propias
* Se pueden crear personalización  de tareas propias basadas en convenciones
### 1.4 Extensibilidad
*  Se puede fácilmente extender para proveer tipos de tareas propias o incluso construir un modelo.(Puede observar ejemplo de esto en la el soporte de Android)
* Permite crear nuevos conceptos de construcción como los tipos de compilación.
### 1.5 Soporte de IDE
* Varios IDEs permiten la integración para construir proyectos Gradle tales como:
	* Android Studio
	* IntelliJ IDEA
	* Eclipse
	* NetBeans. 
	* Spring Tools Suite
* Provee soporte para generar soluciones de archivos requeridos para cargar un proyecto en Visual Studio.
### 1.6 Visión
* ***Build scans:*** Provee extensa información acerca de como construir para identificar problemas.
* Tiene la peculiaridad de ayudar a identificar problemas de rendimiento en una construcción.
* Se pueden compartir ***build scan*** con otros (es útil cuando se necesita preguntar acerca de como reparar un error con la construcción)
## 2. [Cinco cosas que debes concer de Gradle](https://docs.gradle.org/current/userguide/what_is_gradle.html#five_things)
* Gradle es una herramienta fexible y poderosa
* Al conocer los principios del core de Gradle se puede tener buenos resultados
### 2.1 Gradle es una herramienta de propósito general
* Permite ***construir*** cualquier tipo de ***Software***
* Cuenta con una restricción notable con la administración o gestión de dependencias ya que actualmente soporta repositorios de Maven e Ivy
* Facilita la construcción de componentes comunes para los diversos tipos de proyectos (como librerías  Java).
* Se pueden crear y publicar plugins personalizados para encapsular convenciones propias y construir funcionalidades.
### 2.2 El modelo del Core esta basado en tareas.
* Gradle modela sus compilaciones como "DAG" ***Directed Acyclic Graphs (Gráficos Acíclicos Dirigidos)*** de tareas o unidades de trabajo. (Es un mecanismo que configura un conjunto de tareas y las conecta, esto en base a sus dependencias para crear el modelo ***DAG***)
* Una vez construido el modelo ***DAG*** se determinan las tareas y el orden de procedencia para ejecutarlas
* El siguiente diagrama tiene dos ejemplos de gráfico de tareas, uno abstracto y otro concreto con las dependencias entre las tareas representadas como flechas


SPACE FOR IMAGES

* Casi cualquier proceso puede ser modelado como gráfica de tareas, que es una de las razones por las que Gradle es flexible. Esa gráfica de tareas puede ser definidas por plugins así como por sus propios scripts de construcción con tareas vinculadas entre sí a través del [mecanismo de dependencia de tareas.](https://docs.gradle.org/current/userguide/tutorial_using_tasks.html#sec:task_dependencies).
* Las tareas consisten en:
	* Acciones: Piezas de trabajo para hacer algo, como copia de archivos o compilación de los fuentes.
	* Entradas:  Valores, archivos y directorios que usan las ***acciones***
	* Salidas: Archivos y directorios que las ***acciones*** modifican o crean.
* NOTA: Lo anterior es opcional, dependiendo de lo que necesite hacer la tarea. Algunas tareas como las [Estándar  del ciclo de vida](https://docs.gradle.org/current/userguide/base_plugin.html#sec:base_tasks) no necesitan tener acción alguna. Simplemente agregan múltiples tareas juntas como una mecanismo. 
> Se pueden seleccionar cuales son las tareas a ejecutar. Ahorrando tiempo especificando las tareas que se necesitan. Si se quieren ejecutar tareas de pruebas unitarias, se elijen las tareas correspondientes **(comúnmente test)**. Si se necesita empaquetar alguna aplicación, debe construir la tarea correspondiente
* El soporte de Gradle para la [construcción incremental](https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:up_to_date_checks), es robusta y segura.
### 2.3 Gradle tiene varias fases de construcción fijas
* 1. Inicialización
	* Establece el ecosistema para la construcción y determina que proyectos forman parte del mismo.
* 2. Configuración
	* Construye y configura la gráfica de tareas para la construcción y determinar cuales necesitan ejecutarse, así como el orden en que lo hará, esto en función de la tarea que el usuario desea ejecutar.
* 3. Ejecución 
	* Ejecución de tareas seleccionadas al final de la fase configuración.

Estas son las fases para construir el [ ciclo de vida en Gradle](https://docs.gradle.org/current/userguide/build_lifecycle.html#build_lifecycle).
>  Comparación con la terminología de Apache Maven
> * Gradle construye fases sin embargo no son las mismas de Maven
> * Maven usa estas fases para dividir el trabajo de construcción en múltiples etapas, estas cumplen con funcionalidad similar al gráfico de tareas de Gradle, aunque con menos flexibilidad
> * Los conceptos de Maven para la construcción en el ciclo de vida es más o menos similar con el ciclo de Gradle.
* Un buen diseño en la construcción de scripts consiste principalmente en [configuración declarativa en lugar de lógica imperativa](https://docs.gradle.org/current/userguide/authoring_maintainable_build_scripts.html#sec:avoid_imperative_logic_in_scripts)
* La configuración es comprensible  y evaluada durante la fase de configuración.
* Varias construcciones tienen tareas de acción, por ejemplo a través de los bloques ```doLast{}``` y ```doFirst{}```, que se evalúan durante la ejecución, esto es importante porque el código evaluado durante la fase de configuración no puede ver los cambios que ocurren durante la fase de ejecución.
* Otro aspecto fundamental de la fase de configuración es que todo lo involucrado es evaluado siempre que la construcción se ejecuta, es la mejor práctica para [Evitar trabajo innecesario de la fase configuración.](https://docs.gradle.org/current/userguide/authoring_maintainable_build_scripts.html#sec:minimize_logic_executed_configuration_phase)
* [Build scans](https://scans.gradle.com/) puede ayudar a identificar puntos críticos en otras cosas.
## 2.4 Gradle es extensible en mas de un sentido
* No es posible crear un proyecto usando únicamente la lógica que provee Gradle, pocas veces es posible lograrlo.
* La mayoría de las construcciones tiene requerimientos especiales en las que se debe agregar cierta lógica personalizada.
###   Gradle provee mecanismos que permiten extenderlo, tales como:
* [Tipos de tareas personalizadas](https://docs.gradle.org/current/userguide/custom_tasks.html).
	* Cuando se necesita construir trabajo de una tarea existente pero dicha tarea no la pueda hacer.
	* Se puede escribir su propio tipo de tarea.
	* Por lo general es mejor poner el archivo fuente para personalizar la tarea en el directorio ```buildSrc``` o en el paquete del plugin.
	* Después puede usar la tarea personalizada como cualquiera de los que proporciona Gradle.  
* Acción de tareas personalizadas
	* Puede adjuntar lógica de compilación personalizada que se ejecute antes o después una tarea usando los métodos:
		* ```Task.doFirst()``` and ```Task.doLast()``` 
* [Propiedades adicionales](https://docs.gradle.org/current/userguide/writing_build_scripts.html#sec:extra_properties) en proyectos y tareas.
	* Permite agregar sus propias propiedades a un proyecto o tareas  que luego se pueden usar desde sus propias acciones personalizadas o cualquier otra lógica de construcción
	* Las propiedades adicionales pueden ser aplicadas a tareas que no son creadas explicitamente como los creados por los plugins de Gradle.
* Convenciones personalizadas
	*  Las convenciones son poderosas para simplificar la construcción para que los usuarios puedan entenderlas y usarlas fácilmente.
	* Esto se puede ver con las construcciones que utilizan estructuras de proyecto estándar y convenciones de nomenclatura, como las [construcciones de Java](https://docs.gradle.org/current/userguide/building_java_projects.html#building_java_projects).
	* Se pueden crear plugins propios para proveer convenciones. 
* Modelo personalizado
	* Gradle permite agregar nuevos conceptos mas allá de la construcción de tareas, archivos y configuración de dependencias.
	* El modelado apropiado de un proceso de construcción puede mejorar en gran medida la facilidad de uso y la eficiencia de una construcción.
## 2.5 Construcción de scripts para usar un API
* Gradle es fácil para construir scripts y ejecutarlos, sin embargo la implementación tiene cierto detalle: el diseño de scripts y la ejecución solo describen los pasos que se deben realizar para construir el producto o Software, ***Más NO como hacerlo***, para hacerlo se ***necesitan tareas personalizadas y Plugins***
>   Existe una idea común de que el poder y la flexibilidad de Gradle provienen del hecho de que sus scripts de construcción son código. Esto no podría estar más lejos de la verdad. Es el modelo y el API los que proporcionan el poder.
>   Se debe [Evitar usar la lógica imperativa en los scripts.](https://docs.gradle.org/current/userguide/authoring_maintainable_build_scripts.html#sec:avoid_imperative_logic_in_scripts).
* La documentación del API Gradle esta conformada por la [Referencia Groovy DSL ](https://docs.gradle.org/current/dsl/) y la [Documentación java](https://docs.gradle.org/current/javadoc/)
> Gradle se ejecuta sobre la ***JVM*** , se construyen scripts que pueden usarse con el [JAVA API](https://docs.oracle.com/javase/8/docs/api).   Lo mismo sucede para construir scripts Groovy y Kotlin.
