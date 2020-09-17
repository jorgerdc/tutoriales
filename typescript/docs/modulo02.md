# TypeScript

## Módulo 2: TypeScript con React

ReactJS es una librería de JS para construir interfaces de usuario, se puede incluir directamente como librería a nuestra aplicación y
ejecutar el código de ReactJS con la ayuda de babel. Sin embargo, se puede crear una aplicación a forma de framework como una single-page
application (SPA) con ayuda de un comando de npm llamado `npx`, este comando ejecuta un "atajo" de un comando en `npm`, siempre npx se
instala junto con npm.

Con el siguiente comando se crea una aplicacion SPA de react `npx create-react-app mi-aplicacion`, sin embargo, este comando tiene una
variante para generar una aplicación SPA de react, pero basado en TypeScript: `npx create-react-app my-app --template typescript`.

Se agrega un ejemplo del [tutorial](https://reactjs.org/tutorial/tutorial.html) que recomenda ReactJS, pero con
una variante en [su solución en TS](../ejemplos/modulo02).

Este comando genera un `package.json`, un `package-lock.json`, un `tsconfig.json` y un `node_modules`, como vimos en el módulo 01, instala
las dependencias que requiere react para trabajar, además de unos cuantos scripts para empezar a  trabajar.

Dentro de la carpeta `public` tendremos los archivos básicos para que el html único de una SPA funcione. Dentro de la carpeta `src`
tendremos los archivos de todo nuestro proyecto, aquí podemos generar nuestros componentes. Es importante mencionar que React utiliza un
service worker para trabajar, un service worker es una especie de script que se ejecuta en el fondo de la aplicación, de forma separada que
una página web, abriendo la puerta a interacciones que no requieren del DOM o de la interacción de usuario, se puede utilizar para push
notifications, por ejemplo.

##### Fin de módulo
