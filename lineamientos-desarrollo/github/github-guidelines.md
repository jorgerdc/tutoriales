# Procedimiento de integración de código en GitHub.
## 1. Procedimiento de integración
### 1.1 Introducción
El objetivo del presente documento es documentar un procedimiento sugerido para realizar el control de integración y revisión de código en GitHub, en
especial para equipos de trabajo. El documento explica la forma en la que se deberán crear forks, branches, edición de cambios, pull requests y merge.
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
### 1.3 Forks.
* Formalizando la idea anterior,  un  fork representa una copia de un repositorio que se crea en la cuenta del usuario que desea contribuir.
* Esta será  la técnica empleada para  contribuir en los proyectos de ese repositorio.
#### 1.3.1 Crear un Fork.
El primer paso para contribuir al desarrollo de un proyecto es la creación de un fork. . Para crear una copia del repositorio realizar los siguientes pasos:
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
* A partir de este momento se hará uso de Git el cual deberá ser instalado en el equipo de desarrollo.  Para mayores detalles, consultar los siguientes sitios:
	* [Instalación de Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
	* [Configuración con SSL](https://help.github.com/articles/connecting-to-github-with-ssh/).  Este paso es opcional, útil para autenticarse con GitHub sin tener que especificar usuario y password cada vez.
* Una vez instalado, abrir una terminal en la máquina local, ejecutar:
``` bash
git clone <repo_url> 
```
Para el ejemplo:
```bash
git clone https://github.com/jorgerdc/Spoon-Knife.git 
```
Al terminar, cambiarse a la carpeta generada. En ella se encontrará la copia del repositorio.
### 1.4 Sincronización con el repositorio original.
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
### 1.5 Convenciones para crear un branch

* Para cada tarea asignada se deberá crear un nuevo branch.
* No se deberá trabajar directamente sobre el branch ```master```. La convención para nombrar a cada branch es:
```dev-<nombre>-<descripción>```
* ```<nombre>``` corresponde al nombre de la persona que desarrolla o responsable del branch.
* ```<descripción>``` corresponde a un nombre o pequeña descripción del branch que haga refefencia a la tarea que se está desarrollando.
##### Ejemplo:
El siguiente branch será desarrollado por el usuario ```jorge``` y se refiere a una tarea asignada en la que se actualizará el archivo ```README``` del proyecto  ```dev-jorge-update-readme```
* El siguiente paso es crear un nuevo branch y cambiarse a él. 
* En Git el comando `git branch` sirve para mostrar el branch en el que se está trabajando (marcado con un asterisco). En este caso es el branch “master”.
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
master
```
* Observar el asterisco `*` empleado como indicador del branch en el que se está trabajando.
* Posterior a estos pasos, ya se puede comenzar a trabajar normalmente con la tarea asignada.
### 1.6 Trabajando con el branch.
#### 1.6.1  Realizando cambios en el branch.
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
#### 1.6.2 Sincronización del repositorio upstream con el branch de trabajo.
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
### 1.7 Actualización de cambios en el fork
* Como se comentó anteriormente, durante el proceso de desarrollo de la actividad en el branch creado, es posible realizar `git add`y`git commit`, pero hace falta uno más:  `git push`.
* Este comando permite subir los cambios del branch hacia el fork. Es decir, subir los cambios a la copia del repositorio del contribuyente en GitHub.  El repositorio  origina (upstream) sigue intacto.
* En estricto sentido, no es necesario actualizar los cambios en el fork mientras que la tarea esté en proceso. La ventaja de hacerlo frecuentemente es que los cambios se encontrarán respaldados en GitHub. 
* Para realizar `push` al fork se deberá ejecutar la siguiente instrucción:
```bash
git push origin <nombre-branch>
```
* El comando anterior configurará el nuevo branch en el fork en GitHub.
* Para comprobar lo anterior, en GitHub aparecerá un mensaje similar al siguiente en la página principal del repositorio (fork):
![branch.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/branch.png)
* Notar que en el menú “branches” aparece un número que indica los branches que se han creado. Al hacer clic, se muestra una imagen similar a la siguiente. En ella se puede confirmar la creación del nuevo branch.
![branch2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/branch2.png)
* Una vez que la tarea ha sido concluida, y sea momento de integrar los cambios al repositorio original, se deberán realizar las siguientes acciones:
	* Asegurarse que todos los cambios hayan sido actualizados en el Fork.
	* Crear un “pull request”.
### 1.8 Pull Request y Merge
Una vez que la tarea se haya concluido y que las pruebas se hayan creado y ejecutado de forma exitosa, se deberá solicitar un “pull request” para que los cambios del branch sean integrados al repositorio original posterior a su revisión y aprobación por los integrantes del equipo de desarrollo.
* Antes de solicitar el pull request, hacer push para subir todos los cambios al branch remoto empleando la instrucción mencionada anteriormente.
* Para crear un pull request se hará uso de GitHub.
* La siguiente imagen muestra la pantalla para crear un pull request (desde la página principal del repo upstream).
![pull.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull.png)
* Hacer clic en el botón “New Pull Request”.  Se deberá realizar la siguiente configuración en la que se indica que los cambios del branch se integrarán a master del repositorio principal (upstream). En este ejemplo, se va a integrar el branch `dev-jorge-update-readme` al branch `master`.
* Posteriormente, hacer clic en  "Create pull Request".
![pull2.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull2.png)
* En la siguiente pantalla se muestra el formulario para crear el Pull Request.
* Notar que del lado derecho se configura la lista de revisores que deberán participar en la revisión. Es muy ***importante*** configurar esta sección.
*  Al finalizar la captura, hacer clic nuevamente en “Create Pull Request”.
![pull3.png](https://raw.githubusercontent.com/jorgerdc/tutoriales/master/lineamientos-desarrollo/img/pull3.png)
* Posterior a esto, los revisores recibirán un correo para que puedan comenzar a validar los cambios.
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
