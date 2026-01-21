# 1) INSTALAR Y CONFIGURAR AMBIENTE DE DESARROLLO JAVA

Para obtener el archivo de instalación, se ingresa a la [página de descarga del JDK (*Java Development Kit*) de Java](https://www.oracle.com/latam/java/technologies/downloads/).
Dependiendo el sistema operativo, se elige la opción necesaria. Para ambientes GNU/Linux de 64 bits, es *x64 Compressed Archive*, el cual es un archivo comprimido *.tar.gz*.
La descarga se puede almacenarse en cualquier carpeta donde el usuario cuente con todos los permisos, por ejemplo `/tmp/`.

![[img/ej/md-ej-01-01.png]]

Una vez completada la descarga, en una terminal, se posiciona en la ubicación del archivo comprimido y se ejecuta el siguiente comando:

`tar xvf jdk-<versión>.tar.gz && rm jdk-<versión>.tar.gz`

Al finalizar la ejecución, se crea la carpeta *jdk-\<versión>*.  De nuevo, en la terminal se ejecuta: 

`sudo mv jdk-<versión>/ /opt/`

Hasta este punto Java está instalado en el equipo, pero para poder hacer uso de todo el entorno de desarrollo, primeramente se requieren dos variables de entorno : `PATH` y `JAVA_HOME`. La primera requiere ser actualizada para usar los binarios de Java, mientras que la segunda apunta a la instalación donde también se encuentra la JVM (*Java Virtual Machine*).
_____

Ahora, tanto si se usa BASH o ZSH, existe un archivo de configuración que se deberá modificar para poder hacer uso de esta instalación desde la línea de comando.
Para  editar ese archivo se requieren permisos de súperusuario. En este caso se utiliza ZSH como shell predeterminada: `sudo nano /etc/zshrc`; si se tuviera BASH, el comando sería similar, quedando como: `sudo nano /etc/bashrc`.
Agregar al final del archivo las siguientes líneas:

____

```sh
export JAVA_HOME=/opt/jdk-25.0.1/
export PATH=$JAVA_HOME/bin:$PATH
```

Con esto quedan configuradas las 2 variables de entornos necesarias para poder utilizar Java.

Finalmente, a modo de comprobación, se ejecutan los siguientes comandos. El número de versión para ambas salidas deben coincidir.

![[img/ej/md-ej-01-02.png]]


# 2) INTERACTUAR CON JShell
Para utilizar este programa de línea de comandos, es necesario haber realizado la configuración de las variables de entorno previamente revisadas.
Si todo es correcto, se abre una terminal y se ejecuta `jshell`. Luego de unos segundos aparece un nuevo prompt: `jshell>`. Está listo para interactuar.
Mediante este programa se pueden crear pequeños programas o funciones que permitan una vista rápida del comportamiento de un entorno de ejecución Java. A continuación, se muestran algunos ejemplos:

![[img/ej/md-ej-01-03.png]]

# 3) CREAR Y EJECUTAR UNA APLICACIÓN SIMPLE
Para este pequeño ejemplo, se crea la estructura de carpetas `~/edu/unam/cursos/java/intro` y dentro de esta última se crea el archivo *Aplicacion.java* con el siguiente contenido:

```java
package edu.unam.cursos.java.intro;

public class Aplicacion{
	public static void main(){
		System.out.print("Hola mundo");
	}
}
```

Desde una terminal, fuera de la carpeta `~/edu/`, se ejecutan los siguientes comandos:

![[img/ej/md-ej-01-05.png]]

En la línea final, se aprecia la correcta ejecución de nuestra función "Aplicacion".


# 4) INSTALAR Intellij IDEA

Entrar a la [página de la descarga](https://www.jetbrains.com/idea/download/?section=linux) y seleccionar el archivo conforme al sistema operativo. Guardar la descarga en una ubicación donde el usuario cuente con todos los permisos, por ejemplo, `/tmp/`.

![[img/ej/md-ej-01-06.png]]

Una vez concluida la descarga, abrir una terminal y posicionarse en la ubicación del archivo comprimido. Ejecutar los siguientes comandos:

```shell
> tar xvf idea-<versión>.tar.gz && rm idea-<versión>.tar.gz
> sudo mv idea-<versión>/ /opt/
```

Una vez que la carpeta *idea-UI-\<versión>* esté lista en su nueva ubicación, el programa está instalado y listo para usarse. No obstante, su uso deberá hacerse siempre desde una terminal y ejecutando el comando `idea`.
Para solventar esta situación se crea un atajo de escritorio, con lo cual se podrá ver y usar el IDE desde el menú principal de programas, como cualquier otro instalado en el equipo. Para ello, se ejecuta el siguiente comando para crear un archivo.

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

![[img/ej/md-ej-01-07.png]]

Ejecutar un programa en el IDE instalado.

![[img/ej/md-ej-01-08.png]]