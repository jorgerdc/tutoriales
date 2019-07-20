## Configuración Eclipse Workspace.
### 1.1 Objetivo
En este documento se presenta la configuración de la herramienta de desarrollo Eclipse que se debe aplicar por parte de cada programador con la finalidad de homologar y automatizar en cierto grado la aplicación de los lineamientos y mejores prácticas de programación en Java.
### 1.2 Creación de un perfil de desarrollo.
* Dentro de las distintas opciones que ofrece Eclipse en cuanto a formateo de código, se encuentra el concepto de “Perfil”.   
* Un perfil asocia a un conjunto de configuraciones y preferencias de formato de código fuente, el cual puede ser aplicado a uno o más proyectos dentro de un mismo espacio de trabajo.
* Antes de iniciar con las configuraciones descritas en esta sección, es conveniente crear un nuevo perfil a partir del cual se realizarán dichas configuraciones. 
* Este perfil será el empleado por todos los proyectos definidos en Eclipse. Para crear un nuevo perfil, seguir las siguientes instrucciones:
	* Dentro de eclipse seleccionar la opción `Window->Preferences` , seleccionar `Java->Code Style->Formatter` 
•	Hacer clic en New, configurar un nuevo perfil llamado desarrollo como se muestra a continuación:
![e01](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e01.png?raw=true)
* Seleccionar Ok.
*  Este perfil será empleado para aplicar las configuraciones descritas a continuación que tengan relación con el formato del código fuente.
#### 1.2.1 Configuración general de editores.
* Seleccionar `General->Editors->Text Editors` Configurar como se muestra a continuación.
![e02](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e02.png?raw=true)
* Para mostrar el número de líneas, adicionalmente se puede configurar dando clic derecho en el margen izquierdo del editor, seleccionar `show line numbers`.
#### 1.2.2 Formato de código
* Dentro de eclipse seleccionar la opción Window-> Preferences del menu
* Seleccionar `Java->Code Style->Formatter ->Botón Edit`
* Aplicar las configuraciones siguientes.
##### 1.2.2.1 Indentación
* Seleccionar la pestaña “Indentation”, configurar como se muestra a continuación:
![e03](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e03.png?raw=true)
##### 1.2.2.1 Longitud de línea
* Seleccionar la pestaña “Line wrapping” configurar como se muestra a continuación:
![e04](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e04.png?raw=true)
* En las opciones de la parte inferior, configurar como se muestra a continuación:
Assignments:
![e05](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e05.png?raw=true)
##### 1.2.2.2 Formato de comentarios.
* Seleccionar la pestaña “Comments”, configurar como se muestra a continuación:
![e06](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e06.png?raw=true)
![e07](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e07.png?raw=true)
![e08](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e08.png?raw=true)
##### 1.2.2.3 Deshabilitar formato automático de código.
* En algunos casos muy particulares se desea deshabilitar el formato automático de código ya que ciertas lineas pudieran requerir de algún formato muy particular para poder ser claro y entendible. 
* Bajo estas condiciones, es posible indicarle a Eclipse que no realice el formato de código original. 
* Esto se logra agregando las siguientes lineas (comentarios) al inicio y al final de código que no se desea formatear:
```java
//@formatter:off
. . .
//@formatter:on
```
* Esta funcionalidad debe ser habilitada. Las siguientes imágenes muestran la forma en la que se activa esa funcionalidad.
• Dentro del menú `Java -> Formatter` seleccionar la opción “Edit” como se muestra en la siguiente figura:
![e09](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e09.png?raw=true)
* Activar la opción Enable Off/on Tags en el Menú Off/On Tags:
![e10](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e10.png?raw=true)
### 1.3 Comentarios  y documentación de código.
La documentación del código fuente deberá realizarse en inglés. Seguir los siguientes pasos para realizar la configuración.
* Seleccionar la opción `Window-> Preferences` del menú
* Seleccionar `Java -> Code Styles –> Code templates`
* Aplicar las configuraciones siguientes.
#### 1.3.1 Comentarios por default.
* Al final de la ventana seleccionar la siguiente opción:
![e11](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e11.png?raw=true)
#### 1.3.2 Encabezado de la clase.
* Seleccionar `Comments->Files`, presionar “Edit”. Capturar el siguiente texto:
```java
/**
 * ${file_name}
 * Creation Date: ${date}, ${time}
 *
 * Copyright (C) The Project *${project_name}* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
*/
```
* Seleccionar `Comments->Types`, presionar “Edit”. Capturar el siguiente texto:
```java 
/**
 * TODO [Add class documentation]
 * ${tags}
 */
```
* Seleccionar `Comments->Fields`, presionar “Edit”. Capturar el siguiente texto:
```java 
/**
 * TODO [Add attribute documentation]
 */
```
* Seleccionar `Comments->Constructors`, presionar “Edit”. Capturar el siguiente texto:
```java 
/**
 * TODO [Add constructor documentation]
 * ${tags}
 */
```
* Seleccionar `Comments->Methods`, presionar “Edit”. Capturar el siguiente texto:
```java 
/**
 * TODO [Add method documentation]
 * ${tags}
 */
```
* *Importante*: Todos los métodos y constructores deben tener este encabezado. Si el código es demasiado simple y no requiere de alguna documentación
adicional, se puede omitir la descripción, pero el encabezado se debe conservar.
* Seleccionar Comments->Overriding methods, presionar “Edit”. Capturar el siguiente texto:
```java
/* See the original documentation of the method declaration.
 * ${see_to_overridden}
 */
```
*Importante*: Todos los métodos que implementen a los métodos de una interfaz, clase abstracta o que sobrescriban un método, deberán tener este
encabezado. Si se desea agregar documentación adicional, el encabezado se modifica de la siguiente manera:
```java
/**
 * See the original documentatio of the method declaration.
 * <Add here additional documentation>
 * ${see_to_overridden}
 */
```
* Observar que se agrega un “*” 
#### 1.3.3 Configuración del diccionario.
Con la finalidad de reducir faltas de ortografía en los comentarios en inglés, habilitar y configurar el diccionario como se muestra a continuación.
* Seleccionar la opción `Window-> Preferences` del menú
* Seleccionar General -> `Editors –> Text editors ->Spelling`
![e12](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e12.png?raw=true)
#### 1.3.4 Configuración de detección de comentarios incompletos o faltantes.
* Seleccionar `Window-> Preferences` del menu
* Seleccionar `Java->Compiler->Javadoc` , aplicar la configuración que se muestra a continuación.
![e13](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e13.png?raw=true)
*Tip:* Para agilizar la documentación de elementos, basta con situarse en el elemento que se desea documentar, presionar Alt + Shift + J para agregar un bloque de comentarios.
### 1.4 Aspectos generales del estilo de programación
* Seleccionar `Window-> Preferences` del menu
* Seleccionar `Java->Compiler->Errors/Warnings ->Code Style` , aplicar la configuración que se muestra a continuación:
![e14](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e14.png?raw=true)
* Seleccionar la opción *Potential Programming Problems*, configurar como se muestra a continuación.
![e15](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e15.png?raw=true)
* Seleccionar la opción *Unnecessary Code*, configurar como se muestra a continuación.
![e16](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e16.png?raw=true)
* Seleccionar la opción *Null Analysis*, configurar como se muestra a continuación
![e17](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e17.png?raw=true)
### 1.5 Acciones al salvar un archivo
Las siguientes acciones serán ejecutadas al salvar un archivo Java: o Formateo automático de la clase:
* Organización de imports  
* Adición de llaves para sentencias if/do/while/for que hayan sido omitidas (sentencias con una sola instrucción).

Para realizar esta configuración realizar los siguientes pasos:
* Seleccionar la opción Window-> Preferences del menu  
* Seleccionar `Java->Editor ->Save Actions`
* Aplicar la configuración que se muestra a continuación, hacer clic en  `Configure`
 ![e18](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e18.png?raw=true)
 ### 1.6 Configuración del juego de caracteres
* Seleccionar la opción `Window-> Preferences` del menu
* Seleccionar `General -> Workspace`, configurar el juego de caracteres como se muestra a continuación.
![e19](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e19.png?raw=true)
### 1.7 Configuración de templates.
 El uso de templates permite insertar ciertas líneas de código comunmente empleadas durante el desarrollo de un producto. La configuración de este workspace incluye los siguientes templates personalizados:
* `template-debug.xml`
* `template-logdef.xml`

Ambos archivos hacen referencia a instrucciones comúnmente empleadas para realizar el manejo de mensajes de log.  
* El primer archivo permite insertar la siguiente liínea de código que contiene la definición de un atributo de tipo `Logger` empleada para el manejo de mensajes a bitácora:    
```java 
private static final Logger log = LoggerFactory.getLogger(CareerPlanServiceImpl.class)
```
* Por convención a la variable se le deberá aslgnar el nombre log. 
* Para activar la inserción de esta línea bastará con escribir logdef en el editor de código Java.
* El segundo archivo permite insertar las siguientes lìneas de código al escribir en el editor debug
```java
log.debug("");
```
* Se emplea SLF4J para realizar la construcción de estas 2 instrucciones.
* Para realizar la configuración de estos 2 archivos, seleccionar la opciòn Import como se muestra en la siguiente figura. Los archivos se encuentran en la carpeta templates ubicada el mismo directorio donde se encuentra este documento.
![e20](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e20.png?raw=true)
### 1.8 Recomendaciones generales.
Antes de enviar una revisión de código o de realizar un commit, se deberá revisar lo siguiente:
* El código modificado debe estar probado, agregar pruebas en caso de ser necesario. El código no debe contener “Warnings”. 
* Se deberán eliminar antes de hacer commit.
### 1.9 Plugins instalados.
* Object Aid
Empleado para realizar diagramas UML: http://www.objectaid.com/  
Seguir las instrucciones que aparecen en la siguiente página para realizar su instalación: http://www.objectaid.com/installation
* Gradle plugin
Seguir las siguientes instrucciones para instalar el plugin de Gradle, empleado para realizar la integración de Gradle .
	* Seleccionar del menú Help-> Eclipse Marketplace
	* En el campo de búsqueda escribir ‘gradle’, presionar ‘go’.
	* Instalar el plugin que aparece en la siguiente figura: Buildship Gradle Integration X.x
![e21](https://github.com/jorgerdc/tutoriales/blob/master/lineamientos-desarrollo/eclipse/img/e21.png?raw=true)
* Reiniciar la IDE para que los cambios tomen efecto.

Este documento estará en mejora continua conforme se detecten durante el proceso de desarrollo.
##### Fin
