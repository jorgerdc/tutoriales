# Git 
## A1. Lista de comandos útiles.
##### Comando:
* Hacer checkout de un branch remoto:
	* Se asume que el remote name es `origin`
* Se emplea también para crear un nuevo branch que no existe en GitHub.
```bash
git checkout -b <nombre-branch> origin/<nombre-branch>
```
##### Ejemplo:
```bash
git checkout -b dev-jorge-update-sts-ws origin/dev-jorge-update-sts-ws
```
##### Comando:
* Eliminar un commit realizado localmente sin hacer `push`
```bash
git reset --hard HEAD^
```
* Este documento se irá actualizando conforme se use Git y se tenga más detalle técnico de su uso basado en la práctica.
