# Procedimiento de integración de código en GitHub como colaborador.
## 1. Procedimiento de integración
### 1.1 Introducción
El objetivo del presente documento es definir un procedimiento sugerido para realizar el control de integración y revisión de código en GitHub, en
especial para equipos de trabajo. El documento explica la forma en la que se debe trabajar en un proyecto como colaborador y las operaciones a realizar como crear y manejar branches, edición de cambios, pull requests, operaciones merge, etc.
### 1.2 Colaboradores y contribuyentes.
* En GitHub existen 2 formas en las que un usuario puede contribuir o ayudar al desarrollo de un proyecto:
#### 1.2.1 Colaboradores.
* Generalmente son parte del equipo de desarrollo y por lo tanto están directamente involucrados en el proyecto.  Por ejemplo, el equipo de desarrollo de una empresa generalmente tiene acceso a los repositorios privados contratados por la empresa.
* Los colaboradores se configuran en la sección `Settings -> Collaborators` de cada repositorio.
* Una vez configurado, el colaborador tiene permisos para hacer cambios en el repositorio: commit, push, etc.
#### 1.2.2 Contribuyentes.
* Son usuarios que no necesariamente pertenecen a un grupo de desarrollo, pero tienen interés  en contribuir.
* En este caso, el usuario no se registra como colaborador, por lo que no tendrá acceso directo para realizar cambios a un repositorio. 
* En este esquema,  cualquier usuario podrá obtener  *copias* de *solo lectura* del repositorio,  hacer cambios a su copia  y proponerlos para ser integrados en el repositorio original.  
* Al proceso de crear una copia local de un repositorio se le conoce como  *Fork*.
* Los dueños del repositorio podrán revisar los cambios sugeridos o propuestos por el usuario, iniciar un proceso de revisión y aprobación de cambios,  para finalmente,  integrar los cambios al repositorio.
* Este esquema permite establecer un proceso seguro y ágil  en especial para usuarios remotos  que participan en el desarrollo de un proyecto:  *Be social ...*

### 1.3 Colaborando un proyecto. 
* Como parte de un equipo, una de tus tareas es agregar o eliminar miembros a tu repositorio de trabajo para que los demás integrantes puedan colaborar.  Una vez anexados como colaboradores, ellos serán capaces de realizar push , merge o alguna  otra operación al proyecto.

#### 1.3.1 Configura tu equipo de trabajo.
* Las personas a agregar como colaboradores recibirán un correo avisando que fueron agregados al repositorio como colaboradores.
![add-collaborator](https://user-images.githubusercontent.com/42518428/216199457-e0cf01ac-2374-4783-91ef-359e607cad44.PNG)

#### 1.3.2 Clona el repositorio a colaborar.
* Al ser colaborador, se debe de clonar el proyecto en la página  del correspondiente  repositorio a través del siguiente comando en la terminal. 
 ```bash
git clone  <url_repo_a_colaborar>
```
![clone-project](https://user-images.githubusercontent.com/42518428/216199920-e1559c3c-6e90-438d-8aa4-8f9db36219d6.PNG)
* **NOTA: ¡No se debe de realizar fork!.** Realizar un fork generará una copia del proyecto a tus repositorios. Sin embargo eso no es lo que se desea, se busca que se trabaje en el mismo repositorio con tu equipo de trabajo.
*Al trabajar en el proyecto con otras personas es importante que **la rama main/master  siempre deba de estar disponible a deploy**.  Para ello se emplea el uso de ramas y unir los cambios en la rama main cuando esten completos. 

### 1.4 Convenciones para crear un branch

* Para cada tarea asignada se deberá crear un nuevo branch.
* No se deberá trabajar directamente sobre el branch ```master o main```. La convención para nombrar a cada branch es:
```dev-<nombre>-<descripción>```
* ```<nombre>``` corresponde al nombre de la persona que desarrolla o responsable del branch.
* ```<descripción>``` corresponde a un nombre o pequeña descripción del branch que haga referencia a la tarea que se está desarrollando.
##### Ejemplo:
El siguiente branch será desarrollado por el usuario ```jorge``` y se refiere a una tarea asignada en la que se actualizará el archivo ```README``` del proyecto  ```dev-jorge-update-readme```
* El siguiente paso es crear un nuevo branch y cambiarse a él. 
* En Git el comando `git branch` sirve para mostrar el branch en el que se está trabajando (marcado con un asterisco). En este caso es el branch “master o main”.
* Para crear un nuevo branch ejecutar:
```bash 
git branch <nombre_branch>
```
* Para cambiarse al branch, ejecutar:
```bash
git checkout <nombre_branch>
``` 
* O en su Forma corta, crear y cambiarse a un branch:
```bash 
git checkout -b <nombre_branch>
```
* Ejecutar nuevamente `git branch` para comprobar que se ha hecho switch al nuevo branch:
```bash
git branch
* dev-jorge-update-readme
master o main
```
* Observar el asterisco `*` empleado como indicador del branch en el que se está trabajando.
* Posterior a estos pasos, ya se puede comenzar a trabajar normalmente con la tarea asignada.
### 1.5 Trabajando con el branch.
#### 1.5.1  Realizando cambios en el branch.
* Durante el desarrollo de la tarea en el branch  es posible ejecutar la secuencia clásica de comandos para agregar archivos y hacer commit al branch creado.
```bash
#muestra el status de los cambios realizados en el branch
git status
# Agregar un nuevo archivo o un nuevo cambio al sistema de control de versiones:
git add <archivo>
# O en su defecto, agrega todos los archivos y cambios.
git add -A
#Hacer commit de los cambios al branch. Es obligatorio proporcionar
#una descripción que sea clara y corresponda con el cambio realizado.
git commit -m "descripción clara, breve y concisa del cambio".
``` 
### 1.5.2 Sincronización con el repositorio original.
Durante el transcurso del desarrollo de la actividad pudiera requerirse realizar una actualización del repositorio original en el *branch* creado anteriormente o en su rama principal clonada a nivel local. Esto puede ocurrir con base al siguiente escenario:
* Suponer que algún integrante del equipo actualiza el repositorio original (actualiza el branch principal `master o main`).
* Realizar las siguientes acciones:
```bash
git remote -v
```
* Se obtendrá una salida similar a la siguiente:
```bash 
origin https://github.com/jorgerdc/Spoon-Knife.git (fetch)
origin https://github.com/jorgerdc/Spoon-Knife.git (push)
```
* Observar la ruta de las 2 líneas anteriores, las cuales apuntan al repositorio remoto a colaborar. Notar que la ruta contiene el nombre del usuario. A este repositorio se le conoce como “origin”.
* Cambiarse al branch master o main  a nivel local: 
```bash
git checkout <master/main>
```
* Actualizar los cambios del repositorio original (upstream) 
```bash 
git pull origin <master/main>
```
* Hasta este momento, los cambios se han actualizado en el branch principal en la copia generada al clonar el proyecto.

#### 1.5.3 Sincronización del repositorio principal con el branch de trabajo.
* Suponer que también se desea actualizar dichos cambios en el branch creado anteriormente, por ejemplo, en `dev-jorge-update-readme`. Para realizar la actualización, ejecutar las siguientes instrucciones:
* Actualizar los cambios al branch de trabajo `dev-jorge-update-readme`
* Cambiarse nuevamente al branch de trabajo: git checkout `dev-jorge-update-readme`
```bash
git checkout dev-jorge-update-readme
```
* Ejecutar la siguiente instrucción para realizar la actualización en el branch. En Git Existen 2 técnicas: `rebase` y `merge`. Se empleará rebase. 
```bash
git rebase <master/main>
```
Esta última instrucción permite actualizar o sincronizar los cambios del repositorio original actualizados en la rama principal a nivel local en el branch de trabajo.

### 1.6 Pull Request y Merge
Una vez que la tarea se haya concluido y que las pruebas se hayan creado y ejecutado de forma exitosa, se deberá solicitar un *Pull Request* (PR) para que los cambios del branch sean integrados al repositorio original posterior a su revisión y aprobación por los integrantes del equipo de desarrollo.
#### 1.6.1 Unificar commits antes De generar Pull Request
* Durante el proceso de desarrollo de una tarea asociada a un branch, es posible realizar varias operaciones  `commit`  e inclusive operaciones  `push`  hacia la rama de la tarea en específico.
* Una vez que la tarea está lista para ser revisada, se deberá solicitar un "Pull Request" como se mencionó anteriormente.
* Al existir varias operaciones  `commit`, el Pull Request incluirá la lista de todos los commits realizados por el programador.
* Los revisores tendrán que revisar cada uno de estos commits lo cual puede ser tedioso o inclusive confuso. Lo ideal sería tener un solo commit ya que se trata de la primera revisión.
* Git permite realizar una  _unificación_  de esta lista de commits de tal forma que el revisor verá uno solo y por lo tanto facilitará su revisión.
* Lo anterior permite establecer la siguientes reglas:
	1. Todos los programadores deberán unificar sus commits antes de crear un Pull Request.
	2. Una vez que se ha creado el PR, ya NO se deberá realizar unificación. Es decir, la unificación de commits solo de debe realizar una vez , justo antes de hacer el primer  `push`  hacia el repo previo a la creación del PR.
El comando para realizar la unificación de commits es:
```bash
 git rebase -i HEAD~X
 ```
* El valor  `X` en el comando anterior debe ser sustituido por el número de commits que se van a unificar.
* Para determinar este valor, ejecutar el comando  `git log`. El siguiente fragmento muestra una salida de este comando ( se omiten algunas líneas no relevantes por simplicidad):
```
commit 303814664385dcbb36f34b3190ed3a1f600f5759 (HEAD -> dev-jorge-bootstrap-start)
Author: jorgerdc <jorgerdc@gmail.com>
Date:   Sat Mar 23 23:00:34 2019 -0600
    add docs and examples of module 4
    
commit c1091158c1b4bef0906365592d7c0702d6bd6786
Author: jorgerdc <jorgerdc@gmail.com>
Date:   Sat Mar 16 15:54:16 2019 -0600
    adding examples of module 4
    
commit 48d0831bd33e8b126df4cafff835b9e6c34dc7fb
Author: jorgerdc <jorgerdc@gmail.com>
Date:   Wed Feb 27 19:45:40 2019 -0600
    Adding Navbar examples

commit c3f69790c190a8e029eab3ccc9a06b4e09bb3467
Author: jorgerdc <jorgerdc@gmail.com>
Date:   Fri Feb 8 19:45:39 2019 -0600
    adding bootstrap tutorial - first version
```
* Observar en la salida anterior una lista de varios commits. Cada uno de ellos cuenta con un identificador (hash) y entre otras cosas, su mensaje o descripción.
* La lista de commits puede ser muy grande dependiendo de la historia de cambios del proyecto.
* De esta historia se deberán identificar los commits que se desean unificar, iniciando en orden cronológico: de arriba hacia abajo. En esta muestra, se ha identificado que los últimos 4 commits pertenecen al branch en el que se está trabajando y son los que se desean unificar.
* Para identificar fácilmente esta lista, leer el mensaje o descripción del commit. Tip: Para salir del comando `git log` presionar `q`.
* Una vez determinado el valor de  `X`  ejecutar el comando con el valor correspondiente. Para este ejemplo será el 4.
```
git rebase -i HEAD~4
```
* Al ejecutar el comando anterior, aparecerá un *wizard* a nivel consola en el cual se deberán aplicar las configuraciones que se describen a continuación. Nota: el *wizard* será mostrado en el editor de texto configurado para GIT. Si se desea modificar o actualizar la configuración hacer clic  [aquí](https://help.github.com/en/articles/associating-text-editors-with-git).
##### Ejemplo:
```bash
pick c3f6979 adding bootstrap tuturial - first version
s 48d0831 Adding Navbar examples
s c109115 adding examples of module 4
s 3038146 add docs and examples of module 4

# Rebase 06465fc..3038146 onto 06465fc (4 commands)
#
# Commands:
# p, pick = use commit
# r, reword = use commit, but edit the commit message
# e, edit = use commit, but stop for amending
# s, squash = use commit, but meld into previous commit
# f, fixup = like "squash", but discard this commit's log message
# x, exec = run command (the rest of the line) using shell
```
* Observar que se ha sustituido el comando  `pick`  por el comando  `s`  (`squash`) a partir del segundo commit.
* Guardar los cambios y salir del editor. Los comandos/opciones para realizar estas acciones dependerá del editor configurado.
* En caso de cancelar la ejecución del comando `git rebase` se deberán comentar las 4 líneas que contiene a cada uno de los commits. Con esta acción Git no detectará acción a ejecutar y por lo tanto cancelará la ejecución del comando y no mostraría la segunda parte del *wizard*.
* Observar que al salir del editor, automáticamente se presentará un nuevo *wizard* para configurar los mensajes o descripción del commit unificado.
##### Ejemplo :
```
# This is a combination of 4 commits.
# This is the 1st commit message:
adding bootstrap tuturial - first version

# This is the commit message #2:
Adding Navbar examples

# This is the commit message #3:
adding examples of module 4

# This is the commit message #4:
add docs and examples of module 4

# Please enter the commit message for your changes. Lines starting
```
* Se recomienda dejar un solo mensaje en lugar de tener un comentario por cada commit.
* Este mensaje debe ser claro, y debe describir los cambios que se hicieron en los commits que se están unificando.
Ejemplo :
```
# This is a combination of 4 commits.
# This is the 1st commit message:

Adding bootstrap tuturial - first version

# Please enter the commit message for your changes. Lines starting
```
* Guardar los cambios y salir de editor para que el comando sea ejecutado.
* Aparecerá una salida similar a la siguiente con la que se da por concluida la unificación de commits.
```
create mode 100644 bootstrap/ejemplos/modulo05/raven-back3-original.jpg
create mode 100644 bootstrap/ejemplos/modulo05/raven.png
Successfully rebased and updated refs/heads/dev-jorge-bootstrap-start.
```
* Finalmente, para asegurar que el primer PR contenga únicamente el commit unificado, se recomienda eliminar el branch de GitHub y realizar un nuevo push:
```
git push origin <nombre-branch>
```
#### 1.6.2 Creación de Pull Requests en GitHub
* Antes de solicitar el pull request, hacer push para subir todos los cambios al branch remoto empleando la instrucción mencionada anteriormente : `git push origin <nombre-branch>`.
* Para crear un pull request se hará uso de GitHub.
* La siguiente imagen muestra la pantalla para crear un pull request (desde la página principal del repo que se colabora).
![pull.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull.png)
* Hacer clic en el botón “New Pull Request”.  Se deberá realizar la siguiente configuración en la que se indica que los cambios del branch se integrarán a master o main del repositorio principal (upstream). En este ejemplo, se va a integrar el branch `dev-jorge-update-readme` al branch `master o main`.
* Posteriormente, hacer clic en  "Create pull Request".
![pull2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull2.png)
* En la siguiente pantalla se muestra el formulario para crear el Pull Request.
* Notar que del lado derecho se configura la lista de revisores que deberán participar en la revisión. Es muy ***importante*** configurar esta sección.
*  Al finalizar la captura, hacer clic nuevamente en “Create Pull Request”.

![pull3.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull3.png)

#### 1.6.3  Revisión de código en GitHub

* Posterior a la creación del Pull Request, los revisores recibirán un correo para que puedan comenzar a validar los cambios.
* La siguiente figura muestra la pantalla para revisión de código:
![pull4.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull4.png)
* Al hacer clic sobre el código se pueden agregar comentarios para que el responsable del branch los corrija.
* En la siguiente imagen se muestra  un ejemplo. 
* Si el archivo es nuevo, solo se muestra el lado derecho.
* Si el archivo ha sufrido cambios, los  cambios que se eliminan aparecen en rojo del lado izquierdo, y los nuevos cambios en verde del lado derecho. 
* En caso de no aparecer este estilo de revisión,  configurarla en la opción `Diff Settings -> Split` que aparece al inicio de la página web (lado derecho).
* Al pasar el mouse al lado derecho de la numeración, aparece un botón `+` en azul que permite agregar algún comentario o sugerencia. 
*  Una vez que se ha redactado el comentario, hacer clic en la opción `Start a review`.
* Agregar tantos comentarios como sean necesarios.  A partir del segundo comentario, el botón cambia  a `Add review comment`.
![pull5.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull5.png)
* Al terminar de revisar el código y haber capturado los comentarios que sean necesarios,  hacer clic en la opción `Review changes` que aparece en la esquina superior derecha de la pantalla.  Notar que aparece el número de  comentarios que se capturaron.
![pull6.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull6.png)
* Al hacer clic en el botón anterior, aparecerá una forma de captura similar a la siguiente imagen:
![pull7.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull7.png)
* Es importante capturar en el area de texto un resumen de la revisión indicando las acciones que se deben realizar.
* Generalmente se le solicita al contribuyente realizar cambios, por lo que se debe seleccionar la opción `Request Changes`. En caso de no haber más observaciones, el revisor puede seleccionar la opción `Approve`. 
* Finalmente hacer clic en `Submit Review`.
* En este momento el contribuyente recibirá un correo en el que podrá consultar el resultado de la revisión y realizar los cambios solicitados.  
* Esta dinámica puede repetirse las veces que sean necesarias hasta que los revisores hayan aprobado  el Pull Request.  En algunos casos, los dueños de los repositorios configuran algunas medidas de seguridad de tal forma que sea obligatoria la aprobación  cierta cantidad de revisores para que el Pull Request sea considerado como *Aprobado*. 
* Posterior a la aprobación, el dueño del repositorio original hará la integración del branch al repositorio original (upstream).  Con esta acción se da por concluido el ciclo de vida del branch.
