# Procedimiento de integración de código en GitHub.
## 1. Procedimiento de integración
### 1.1 Introducción
El objetivo del presente documento es documentar un procedimiento sugerido para realizar el control de integración y revisión de código en GitHub, en
especial para equipos de trabajo. El documento explica la forma en la que se deberán crear forks, branches, edición de cambios, pull requests y merge.
### 1.2 Crear un Fork
El primer paso para contribuir al desarrollo de un proyecto es la creación de un fork. Un Fork es una copia de un repositorio que se almacena localmente.
Esta copia permite experimentar, hacer o proponer cambios al proyecto sin afectar el código principal u original. Para crear una copia del repositorio realizar los siguientes pasos:
* Antes de iniciar, entrar a GitHub, entrar a sesión.
* Suponer que se desea hacer un Fork del siguiente repositorio: [https://github.com/octocat/Spoon-Knife](https://github.com/octocat/Spoon-Knife)
* En la página principal del repositorio hacer clic en “Fork” (esquina superior derecha de la pantalla).
* Al hacer clic, iniciará el proceso de creación del Fork.

![fork.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/fork.png)
* Al terminar, se creará una nueva referencia al repositorio “Spoon-Knife” en la cuenta de Github del usuario que desea contribuir (usuario contribuyente).
* Para comprobar lo anterior, ir a la página principal del usuario contribuyente, hacer clic en *Repositories*. El nuevo repositorio aparecerá en la lista.
![fork2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/fork2.png)
* En la imagen se muestra el repositorio “Spoon-Knife” que representa la copia del original. Hacer clic en el nombre.
* Se mostrará una imagen similar a la siguiente:
![fork3.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/fork3.png)
* Observar en la parte superior izquierda, la ruta relativa de la copia del repositorio *jorgerdc/Spoon-Knife*
* *jorgerdc* corresponde con el usuario contribuyente.
* Observar también la leyenda  *forked from  octocat/Spoon-Knife* que representa el repo original.
* El siguiente paso es guardar la copia del repositorio en la máquina del contribuyente. Para ello, hacer clic en el botón “Clone or Download”.
* Observar que aparece el ícono de “copy” . Hacer clic sobre el para copiar la ruta del repositorio: https://github.com/jorgerdc/Spoon-Knife.git
* Abrir una terminal en la máquina local (se asume que git ha sido instalado), ejecutar:
``` bash
git clone <repo_url> 
```
Para el ejemplo:
```bash
git clone https://github.com/jorgerdc/Spoon-Knife.git 
```
Al terminar, cambiarse a la carpeta generada. En ella se encontrará la copia del repositorio.
### 1.3 Sincronización con el repositorio original.
Con el paso del tiempo, la copia creada puede requerir sincronizarse con la copia original, en especial si se agregan más cambios. Para configurar la sincronización con el repositorio original, realizar las siguientes acciones:
```bash
git remote -v
```
* Se obtendrá una salida similar a la siguiente:
```bash 
origin https://github.com/jorgerdc/Spoon-Knife.git (fetch)
origin https://github.com/jorgerdc/Spoon-Knife.git (push)
```
* Observar la ruta de las 2 líneas anteriores, las cuales apuntan al repositorio remoto del “fork” (copia). Notar que la ruta contiene el nombre del usuario. A este repositorio se le conoce como “origin”.
• Para poder sincronizar la copia con el repositorio de origen, se requiere ejecutar la siguiente instrucción: 
```bash 
git remote add upstream <url_repo_original>
``` 
* Para el ejemplo se tendría:
```bash 
git remote add upstream https://github.com/octocat/Spoon-Knife.git
```
• Al ejecutar nuevamente la instrucción ```git remote -v``` se obtendrá:
```bash
origin https://github.com/jorgerdc/Spoon-Knife.git (fetch) 
origin https://github.com/jorgerdc/Spoon-Knife.git (push) 
upstream https://github.com/octocat/Spoon-Knife.git (fetch) 
upstream https://github.com/octocat/Spoon-Knife.git (push)
```
* Notar que se agrega el URL del repositorio original llamado ```upstream```.
### 1.4 Convenciones para crear un branch

* Para cada tarea asignada se deberá crear un nuevo branch.
* No se deberá trabajar directamente sobre el branch ```master```. La convención para nombrar a cada branch es:
```dev-<nombre>-<descripción>```
* ```<nombre>``` corresponde al nombre de la persona que desarrolla o responsable del branch.
* ```<descripción>``` corresponde a un nombre o pequeña descripción del branch que haga refefencia a la tarea que se está desarrollando.
##### Ejemplo:
El siguiente Branch será desarrollado por el usuario ```jorge``` y se refiere a una tarea asignada en la que se actualizará el archivo ```README``` del proyecto  ```dev-jorge-update-readme```
* En Git el comando ```git branch``` sirve para mostrar el branch en el que se está trabajando (marcado con un asterisco). En este caso es el branch “master”.
* El siguiente paso es crear un nuevo branch y cambiarse a él. Ejecutar: 
```bash 
git branch <nombre_branch>
git checkout <nombre_branch>
```
O en su Forma corta:
```bash 
git checkout -b <nombre_branch>
```
* Ejecutar git branch para comprobar que se ha hecho switch al nuevo branch:
```bash
git branch
* dev-jorge-update-readme
master
```
* Posterior a estos pasos, ya se puede comenzar a trabajar normalmente con la tarea asignada.
### 1.5 Trabajando con el branch.
#### 1.5.1 Sincronización del repositorio upstream con el branch de trabajo.
Durante el transcurso del desarrollo de la actividad pudiera requerirse realizar una actualización del repositorio original en el *fork* y *branch* creados anteriormente. Esto puede ocurrir con base al siguiente escenario:
* Suponer que algún integrante del equipo actualiza el repositorio original (actualiza el branch principal `master`).
* Suponer que se desea actualizar dichos cambios en el branch creado anteriormente, por ejemplo, en `dev-jorge-update-readme`. Para realizar la actualización, ejecutar las siguientes instrucciones:
* Cambiarse al branch master del fork: 
```bash
git checkout master
```
* Actualizar los cambios del repositorio original (upstream) 
```bash 
git pull upstream master
```
* Hasta este momento, los cambios se han actualizado en el branch master del fork.
* El siguiente paso es actualizar los cambios al branch de trabajo `dev-jorge-update-readme`
* Cambiarse nuevamente al branch de trabajo: git checkout `dev-jorge-update-readme`
```bash
git checkout dev-jorge-update-readme
```
* Ejecutar la siguiente instrucción para realizar la actualización en el branch. En Git Existen 2 técnicas: `rebase` y `merge`. Se empleará rebase. 
```bash
git rebase master
```
Esta última instrucción permite actualizar o sincronizar los cambios del repositorio original en el branch de trabajo.
### 1.6 Actualización de cambios en el fork
* Durante el proceso de desarrollo de la actividad en el branch creado, es posible realizar `commit` y `push`.
* Se puede hacer `git push`. En este caso los cambios se subirán a GitHub (en el fork creado), dejando intacto el repositorio original (`upstream`).
* Esto se podrá comprobar en GitHub seleccionando el menú *branches*.
* Para realizar push al fork se deberá ejecutar la siguiente instrucción:
```bash
git push origin <nombre-branch>
```
* El comando anterior configurará el nuevo branch en el fork. En este caso en GitHub.
* Para comprobar lo anterior, en GitHub aparecerá un mensaje similar al siguiente en la página principal del repositorio (fork):
![branch.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/branch.png)
* Notar que en el menú “branches” aparece un número que indica los branches que se han creado. Al hacer clic, se muestra una imagen similar a la siguiente. En ella se puede confirmar la creación del nuevo branch.
![branch2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/branch2.png)
* Una vez que la tarea ha sido concluida, y sea momento de integrar los cambios al repositorio original, se deberá crear un “pull request”.
### 1.7 Pull Request y Merge
Una vez que la tarea se haya concluido y que las pruebas se hayan creado y ejecutado de forma exitosa, se deberá solicitar un “pull request” para que los cambios del branch sean integrados al repositorio original posterior a su revisión y aprobación por los integrantes del equipo de desarrollo.
* Antes de solicitar el pull request, hacer push para subir todos los cambios al branch remoto empleando la instrucción mencionada anteriormente.
* Para crear un pull request se hará uso de GitHub.
* La siguiente imagen muestra la pantalla para crear un pull request (desde la página principal del repo).
![pull.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull.png)
* Al hacer clic en el botón “New Pull Request” se deberá realizar la siguiente configuración en la que se indica que los cambios del branch se integrarán a master del repositorio principal.
![pull2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull2.png)
* En la siguiente pantalla se muestra el formulario para crear el Pull Request.
* Notar que del lado derecho se configura la lista de revisores que deberán participar en la revisión. Es muy ***importante*** configurar esta sección.
*  Al finalizar la captura, presionar “Create Pull Request”.
![pull3.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull3.png)
* Posterior a esto, los revisores recibirán un correo para que puedan comenzar a validar los cambios.
* La siguiente figura muestra la pantalla para revisión de código:
![pull4.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull4.png)
* Al hacer clic sobre el código se pueden agregar comentarios para que el responsable del branch los corrija.
* Una vez que todos los cambios han sido aplicados y todos los involucrados estén de acuerdo, el revisor puede marcar al branch como aprobado.
* Posterior a la aprobación, el dueño del repositorio original hará la integración del branch al repositorio original (upstream).
