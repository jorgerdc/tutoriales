# 1) INSTALAR Y CONFIGURAR AMBIENTE DE DESARROLLO JAVA

Para obtener el archivo que nos permitirá la instalación, se ingresa a la página de descargas de Java, en donde estará disponible la última versión (en este caso, la 25).
Nos aseguramos de seleccionar la versión deseada y el sistema operativo requerido. Para ambientes GNU/Linux de 64 bits, se descarga la opción "x64 Compressed Archive" que es un archivo comprimido tipo ".tar.gz".
Para facilitar este procedimiento, guarde la descarga en la ruta `/opt

![[Pasted image 20260115211332.png]]

Una vez completada la descarga, abrimos una terminal y nos dirigimos a la ubicación del archivo y se ejecuta el siguiente comando:

`tar xvf jdk-<25_linux-x64_bin>.tar.gz`

Esto creará una nueva carpeta. Ingresar a ella y copiar la ruta. Para el presente caso, se crea la carpeta "jdk-25.0.1" y su ruta queda como: `/opt/jdk-25.0.1/`.

Ahora, tanto si se usa BASH o ZSH, existirá un respectivo archivo de configuración que se deberá modificar para poder hacer uso de esta instalación desde la línea de comando.
Para poder editar ese archivo se requieren permisos de súperusuario. En este caso se utiliza ZSH como shell predeterminada: `sudo nano /etc/zshrc`; si se tuviera BASH, el comando sería similar, quedando como: `sudo nano /etc/bashrc`.
Agregar al final del archivo las siguientes líneas:

```sh
JAVA_HOME=/opt/jdk-25.0.1/
export PATH=$JAVA_HOME/bin:$PATH
```

Con esto quedan configuradas las 2 variables de entornos necesarias para poder utilizar Java. La primera indica la ubicación de la instalación, mientras que la segunda, es una adición a la variable de entorno PATH en donde se agrega la ubicación de los binarios para poder ejecutar Java.

Finalmente, a modo de comprobación de este proceso, se ejecutan los siguientes comandos en donde ambas versiones deben coincidir.

![[Pasted image 20260115213013.png]]


# 2) INTERACTUAR CON JShell

![[Pasted image 20260115213755.png]]

# 3) CREAR Y EJECUTAR UNA APLICACIÓN
Se crea la estructura de carpetas del archivo `~/edu/unam/cursos/java/intro` y dentro de esta última carpeta se crea el archivo "Aplicacion.java" con el siguiente contenido:


![[Pasted image 20260115215657.png]]

Desde una terminal, fuera de la carpeta `~/edu/` se ejecutan los siguientes comandos:

![[Pasted image 20260115215816.png]]


# 4) INSTALAR Intellij IDEA

Entrar a la página de la descarga [[https://www.jetbrains.com/idea/download/?section=linux]]
y seleccionar el archivo conforme al sistema operativo. Guardar la descarga en la ruta `/opt/

![[Pasted image 20260115220315.png]]

Finaliza la descarga, abrir una terminal y moverse a la ubicación de la descarga y ejecutar el siguiente comando:

`tar xvf idea-<2025.3.1.1>.tar.gz`

Una vez que la carpeta "idea-UI-<253.29346.240>" esté lista, ejecutar el siguiente comando:

`nano ~/.local/share/applications/intellij-idea.desktop`

En este nuevo archivo, insertar el siguiente contenido; recordando que dependiendo de la versión, los números en el nombre de la carpeta variarán.
```bash
[Desktop Entry]
Version=1.0
Type=Application
Name=IntelliJ IDEA
Exec=/opt/idea-IU-253.29346.240/bin/idea
Icon=/opt/idea-IU-253.29346.240/bin/idea.png
Comment=IntelliJ IDEA
Categories=Development;IDE;
Terminal=false

```

Guardar el archivo, salir y ejecutar ahora:

`update-desktop-database ~/.local/share/applications/`

Con esto listo, podremos ver el programa instalado, en el menú principal del sistema.

![[Pasted image 20260117205051.png]]

Ejecutar un programa en el IDE instalado

![[Pasted image 20260117211015.png]]

