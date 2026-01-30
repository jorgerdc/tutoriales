# 1) Instalar y configurar ambiente de desarrollo Java

## A) Instalar JDK

Para obtener el archivo de instalación, se ingresa a la [página de descarga del JDK (*Java Development Kit*) de Java](https://www.oracle.com/latam/java/technologies/downloads/).
Dependiendo el sistema operativo, se elige la opción necesaria. Para ambientes GNU/Linux de 64 bits, es *x64 Compressed Archive*, el cual es un archivo comprimido *.tar.gz*.
El archivo puede almacenarse en cualquier carpeta donde el usuario cuente con todos los permisos, por ejemplo `/tmp/`.

<img src=img/eje-01-01.png style="display: block; margin: auto">

Con la descarga completada, abrir una terminal en la ubicación del archivo y ejecutar el siguiente comando:

`tar xvf jdk-<versión>.tar.gz && rm jdk-<versión>.tar.gz`

Al finalizar la ejecución, se crea la carpeta *jdk-\<versión>*.  De nuevo, en la terminal se ejecuta la siguiente instrucción para mover el directorio del JDK a su ubicación final.

`sudo mv jdk-<versión>/ /opt/`

## B) Configurar variables de entorno

Hasta este punto, Java está instalado en el equipo, pero aún es necesario configurar dos variables de entorno: `PATH` y `JAVA_HOME`. La primera requiere ser actualizada para usar los binarios de Java, mientras que la segunda apunta a la instalación misma del JDK donde también se encuentra la JVM (*Java Virtual Machine*).
Para esto se crea el siguiente archivo:

`sudo nano /etc/profile.d/00-java-env.sh`

Y dentro de este, se agrega este código:

```sh
export JAVA_HOME=/opt/jdk-<versión>/
export PATH=$JAVA_HOME/bin:$PATH
```

Con esto quedan configuradas las 2 variables de entorno necesarias para poder utilizar Java. 

## C) Comprobación de la instalación

Finalmente, a modo de comprobación, ejecutar los siguientes comandos. El número de versión para ambas salidas deben coincidir.

![](img/eje-01-02.png|600)

# 2) Interactuar con "JShell"

JShell es una herramienta interactiva o intérprete REPL (*Read-Eval-Print Loop*) que permite ejecutar fragmentos de código al instante, como métodos sencillos.
Para utilizar este programa de línea de comandos, es necesario haber realizado la configuración de las variables de entorno previamente revisadas.
Si todo es correcto, se abre una terminal y se ejecuta `jshell`. Luego de unos segundos aparece un nuevo prompt: `jshell>`. Está listo para interactuar.

![](img/eje-01-03.png|600)

# 3) Crear y ejecutar una aplicación simple

Para este curso, la ubicación de las carpetas y estructuras de trabajo son de libre elección para el usuario.
Desde la redacción se opta por la ruta `~/CursoJava/` donde habrá una carpeta para cada módulo y dentro de cada una de estas se almacenarán las demás carpetas, archivos y códigos de ejercicios relativos a todo este material.
De esta manera, cuando en los documentos se haga mención a la carpeta base, se refiere a `~/CursoJava/` y cuando se trate de la carpeta raíz para un ejercicio en concreto se entiende que se ubica dentro de la carpeta del módulo o ejercicio correspondiente.
## A) Crear una clase con la estructura de paquete indicada
Para este ejemplo, se crea la estructura de carpetas `~/edu/unam/cursos/java/intro` y dentro de esta última se crea el archivo *Aplicacion.java* con el siguiente contenido, donde se aprecia el método `main`

```java
package edu.unam.cursos.java.intro;

public class Aplicacion{
	public static void main(){
		System.out.print("¡Hola mundo!");
	}
}
```

## B) Compilar y ejecutar la aplicación

Desde una terminal, fuera de la carpeta `~/edu/`, se ejecutan los siguientes comandos. El primero llama al compilador de Java y el segundo ejecuta el archivo `.class`.

![](img/eje-01-05.png|600)

En la línea final, se aprecia la correcta ejecución de nuestra función "Aplicacion".

 # 4) Ejecutar una aplicación, desde línea de comandos, que haga uso de varias clases

## A) Definir una clase principal que implemente el método `main()`

Conforme a la siguiente estructura, se crea el archivo *AplicacionPrincipal.java*

<img src=img/eje-01-13.png style="display: block; margin: auto;">
```java
package edu.unam.cursos.java.intro;

public class AplicacionPrincipal{
	public static void main(){
		System.out.println("~/edu/unam/cursos/java/intro: Esta es la CLASE PRINCIPAL");
	}
}
```

## B) Crear otra clase en el mismo paquete que la clase anterior

<img src=img/eje-01-14.png style="display: block; margin: auto;">
```java
package edu.unam.cursos.java.intro;

public class AplicacionPrincipal{
	public static void main(){
		System.out.println("~/edu/unam/cursos/java/intro: Esta es la CLASE PRINCIPAL");
	}
}
```


## C) Crear una clase más, en un paquete diferente

En otra de las carpetas de la estructura previa, se crea un nuevo archivo.

<img src=img/eje-01-15.png style="display: block; margin: auto">

```java
package edu.unam.cursos.java;

public class ClaseOtroPaquete{
	public static void main(){
		System.out.println("~/edu/unam/cursos/java: Tercer clase, pero de otro paquete");
	}
}
```


## D) Crear una clase que no tenga paquetes definidos

Este archivo, en realidad, consiste en una clase completamente independiente de las anteriores; que esté ubicada en otra ruta

```java
package edu.unam.cursos.java;

public class ClaseSolitaria{
	public static void main(){
		System.out.println("CursoJava/M-1/codigos: Cuarta clase. Independiente y empoderada");
	}
}
```

# 5) Instalar y configurar el IDE "Intellij IDEA"

## A) Descargar e instalar IDE
Entrar a la [página de la descarga](https://www.jetbrains.com/idea/download/?section=linux) y seleccionar el archivo conforme al sistema operativo. Guardar la descarga en una ubicación donde el usuario cuente con todos los permisos, por ejemplo, `/tmp/`.

![](img/eje-01-06.png|600)

Una vez concluida la descarga, abrir una terminal y posicionarse en la ubicación del archivo comprimido. Ejecutar los siguientes comandos:

```shell
> tar xvf idea-<versión>.tar.gz && rm idea-<versión>.tar.gz
> sudo mv idea-<versión>/ /opt/
```

Una vez que la carpeta *idea-UI-\<versión>* esté lista en su nueva ubicación, el programa está instalado y listo para usarse. No obstante, su uso deberá hacerse siempre desde una terminal y ejecutando el comando `idea &` manteniendo la terminal abierta.
Opcionalmente, para solventar esta situación, se puede crear un atajo de escritorio, con lo cual se podrá ver y usar el IDE desde el menú principal de programas, como cualquier otro instalado en el equipo. Esta solución es replicable en cualquier escritorio KDE y GNOME (Mate, Cinnamon y Unity).
Para ello, se ejecuta el siguiente comando para crear un archivo.

`nano ~/.local/share/applications/intellij-idea.desktop`

Insertar el siguiente contenido; recordando que en el campo `<versión>` se debe sustituir por la secuencia de números respectiva a la versión que se haya obtenido previamente.

```bash
[Desktop Entry]
Version=1.0
Type=Application
Name=IntelliJ IDEA
Exec=/opt/idea-IU-<versión>/bin/idea
Icon=/opt/idea-IU-<versión>/bin/idea.png
Comment=IntelliJ IDEA
Categories=Development;IDE;
Terminal=false
```

Guardar el archivo y salir. Enseguida, ejecutar la siguiente instrucción para actualizar los programas de escritorio disponibles para el usuario.

`update-desktop-database ~/.local/share/applications/`

Con esto listo, se puede ver programa instalado y listo para usarse desde el menú principal del sistema.

## B) Configurar un nuevo proyecto en IntelliJ

Al ejecutar el programa por primera vez, solicitará que se acepte la licencia y el acuerdo de privacidad. Dar clic en el botón de **Aceptar**
Una vez que la ventana anterior se cierra, aparece la siguiente, en donde se selecciona la opción **New Project**.

<img src=img/eje-01-08.png style="display: block; margin: auto;">

Esto abre una nueva ventana con varios necesarios para configurar un nuevo proyecto. El primer campo es para el nombre del método principal, en este caso `main`. En el segundo, se describe la estructura de paquetes solicitada en forma de carpetas.
Para fines de este ejercicio, cerciorarse de que la opción **Add sample code** esté marcada y dar clic en **Create**

<img src=img/eje-01-09.png style="display: block; margin: auto;">

Luego de unos segundos, aparece la siguiente vista, donde se aprecia la ubicación de este nuevo proyecto, así como el método `void main`.

<img src=img/eje-01-10.png style="display: block; margin: auto;">

En este nuevo entorno, hay varias características y elementos novedosos y desconocidos, mismos que se revisarán a su debido tiempo. 


## C) Ejecutar la aplicación

Para concluir con esta práctica y aprovechando el código (de ejemplo) que se generó al momento de configurar el proyecto, se eliminan todas las líneas, excepto la número 3, la 6 y la 13; se da clic en el círculo rojo de la línea 11 para quitarlo.
Con esta estructura restante se reescribe la cadena de texto a mostrar en pantalla: "¡Hola, Mundo!" y, finalmente, se ejecuta, ya sea dando clic en el icono del triángulo verde (*Play*) o mediante la combinación de teclas sugeridas **Shift** + **F10**

<img src=img/eje-01-11.png style="display: block; margin: auto;">

Después de unos segundos, un panel con una consola de sólo lectura se abre en la parte inferior de la venta y muestra la ejecución del código:

<img src=img/eje-01-12.png style="display: block; margin: auto;">
