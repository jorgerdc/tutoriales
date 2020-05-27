
# Git 
## 1. Pasos iniciales con Git
### 1.1 Setup Inicial.
* Esta actividad se realiza una sola vez, típicamente posterior a la instalación de Git.
* Se emplea el comando `git config` el cual permite configurar los valores de variables empleadas para el correcto funcionamiento de Git.
* Existen 3 niveles de configuración.  La selección del nivel adecuado depende de cada developer y el uso de máquinas de desarrollo compartidas entre varias personas.  
* La siguiente lista va de menor a mayor precedencia. 
1. Archivo `/etc/gitconfig` Las configuraciones aplican a todos los usuarios.
* Para provocar que Git configure esta archivo se emplea: `git config --system`
2. Archivo `~/.gitconfig`o de forma equivanente en  `~/.config/git/config`
* En este caso las configuraciones aplican a un usuario en particular
* Para  provocar que Git escriba en este archivo se emplea: `git config --global` 
3. Archivo `config` dentro del directorio  `.git/config` el cual se ubica en el directorio raíz de un repositorio.  
* Las configuraciones de este archivo aplican solo al repositorio correspondiente.
* Para  provocar que Git escriba en este archivo se emplea: `git config --local` 
* Este último comando es la opción por default.
* Para mostrar las configuraciones de un usuario sin importar de cual de los 3 archivos provienen se emplea: 
```bash
git config --list --show-origin
# mostrando las variables omitiendo el archivo de donde provienen
git config --list
```
#### 1.1.1 Principales configuraciones.
* Los siguientes ejemplos muestran las principales variables o configuraciones que se establecen con el comando `git config`

```bash
git config --global user.name "xx"
git config --global user.email myemail@mail.com
#configura el editor de texto que será usado por git. En este ejemplo se ha seleccionado nano
git config --global core.editor nano
```
### 1.2 Configurar SSH keys.
* Seguir esta [guía](https://help.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh) 

### 1.3 Configurar SSL  para evitar la captura de usuario y password.
 * Una vez que se ha realizado la configuración de SSH,  del lado del cliente es necesario realizar las siguientes configuraciones para evitar que git solicite usuario y contraseña cada vez que se desee realizar un `push`
 * Todos los repos en GitHub permiten trabajar con el protocolo  `https` entre otras cosas para evitar problemas con firewalls y proxies.
 * Otra ventaja es que es muy sencillo de configurar, pero tiene una desventaja:
	* Se deben propoporcionar credenciales de autenticación cada vez que se requiera hacer un `push` o un `pull`. Para solucionar lo anterior existen 2 estrategias:
* Actualizar el URL origin remote para que se utilice SSH en lugar del uso de HTTPS (la más recomendada).
```bash 
git remote set-url origin git@github.com:<username>/<nombre_repo.git>
```
 * Uso de https y salvar credenciales de forma local de forma permanente.
 ```bash
git config --global credential.helper store
```
* Uso de https y salvar pero únicamente para la sesión actual
```bash
git config --global credential.helper cache
```
* Uso de https y establecer un timeout
```bash
git config --global credential.helper 'cache --timeout=600'
```
