
# Angular

## Contenido módulo 1

1. [Introducción a Angular](#introduccin-a-angular)\
1.1. [Angular CLI vs AngularJS](#angular-cli-vs-angularjs)\
1.2. [¿Qué es Angular?](#qu-es-angular)\
1.3. [Instalación y preparación de nuestro entorno de desarrollo](#instalacin-y-preparacin-de-nuestro-entorno-de-desarrollo)\
1.4. [Generalidades de un proyecto en angular](#generalidades-de-un-proyecto-en-angular)\
1.5. [Angular Material](#angular-material)

## Introducción a Angular

### Angular CLI vs AngularJS

Muchas personas desconocen que hay 2 diferentes tipos en los que podemos trabajar con angular, **AngularJS** y **Angular CLI**.

#### AngularJS

En palabras muy simples, AngularJS es la versión 1.x de Angular y tiene un comportamiento muy similar a react, dónde simplemente importamos
una librería y estamos listos para continuar. AngularJS fue desarrollado en 2009, 6 años antes del release del conocido ES6, haciendo un
gigante cambio en cómo se podría construir un sitio de gran tamaño. Desde mediados de 2018, entró en un periodo de LTS, ésto quiere decir
que no habrá muchas actualizaciones en la librería pero si habrá soporte para bugs y actualizaciones de seguridad. Está agendado que la
versión LTS termine el 31 de diciembre de 2021.

#### Angular CLI

A partir de la versión 2 de Angular y hasta la actual (al día de hoy la versión 10) se considera aparte de la versión 1, dado que ya no se
comporta como librería, ya se comporta como un framework robusto y escalable. Provee una interfaz en la línea de comandos capaz de generar
templates de código, minificar, testear y construir proyectos de tamaño mediano y grande. Algo que destaca mucho de Angular es que **no
utiliza JavaScript, utiliza TypeScript** para el desarrollo de sus componentes y secciones, lo cual nos permite tener un control más grande
de nuestro código, menores errores, pero una curva de aprendizaje más pronunciada.

**Para efectos de este tutorial, usaremos Angular CLI en su versión activa que es Angular 10.x.x**

### ¿Qué es Angular?

Angular es un framework para diseño de aplicaciones y plataforma de desarrollo para crear sofisticadas SPAs (Single Page Applications), una
SPA es una aplicación web que **interactúa con el browser de forma dinámica**, ésto quiere decir que trabaja sobre un mismo "archivo" y
constantemente re-escribe información, ya sea desde el cliente o desde un servidor.

Angular tiene muy buen performance, a pesar de ser un framework robusto y pesado, hace uso de web workers, utilizando algunos hilos para
ejecutar código JS más eficientemente. Además, tiene **integración directa con programación reactiva**, usando completamente RxJS.
Permite el uso de diferentes técnicas para un gran desempeño y organización de código, entre sus posibilidades se encuentran:
- Componentes
- Pipes
- Directivas
- Módulos
- Servicios

Delegando a cada uno de ellos una responsabilidad única e implementando completamente los conceptos de programación orientada a objetos.
A diferencia de su competidor primario ReactJS, Angular utiliza un tipo de comunicación que se llama "*two-way data binding*", ésto es que
nuestro html está directamente enlazado con nuestro código JS, si cambia uno, el cambio se ve reflejado en el otro, ésto es extremadamente
útil para formularios.

Ejemplo del código de un componente:
  
```typescript
@Component({
  selector: 'app-course-list',
  template: `
    <div class="course-list">
      <h1>Course List for {{}}</h1>
      <ul>
        <li>Bootstrap</li>
        <li>ReactJS</li>
        <li>Angular</li>
      </ul>
    </div>
  `,
  styleUrls: ['./app.component.scss']
})
export class CourseListComponent {
  @Input() name: string;
}
```
Uso del componente:
```html
<app-course-list name="myCourses"></app-course-list>
```
### Instalación y preparación de nuestro entorno de desarrollo

Como se mencionó anteriormente, trabajaremos con Angular CLI. Previamente necesitamos instalar NodeJS para poder hacer uso de su gestor de
paquetes npm.

#### Instalación de npm en MacOS y Windows

Simplemente ingresamos al [sitio oficial de node](https://nodejs.org/) y bajamos el instalador para nuestro sistema operativo, posterior a
la instalación, abrimos un cmd/powershell o una terminal y ejecutamos los comandos `node -v` y `npm -v`. Para efectos de este curso, se
usará la versión 12.x.x de node.

```console
> node -v
v12.18.3
> npm -v
6.14.8
```

#### Instalación de npm en Linux

Para instalar node desde alguna distro basada en debian hay que agregar el setup para la versión que queremos utilizar.

```console
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash –
sudo apt-get install nodejs
node -v
npm -v
```

Una vez instalado node, procedemos a agregar angular a nuestro npm global, esto nos permitirá usar el CLI para crear proyectos y generar
las secciones que necesitemos **si estamos trabajando en windows no es necesario usar sudo**.

```console
sudo npm install -g @angular/cli
ng version
```

Para generar un nuevo proyecto utilizaremos el comando `ng new` además del nombre del proyecto, por ejemplo `ng new modulo01`.
Una vez que ejecutamos el comando, nos pide ingresar algunas configuraciones previas a nuestro proyecto.

- Angular routing. La primera configuración nos pregunta si queremos añadir el módulo para rutas o paths para navegar en nuestra página,
este módulo tendrá su propia sección en este curso.
- Stylesheet format. La siguiente sección nos pregunta cómo queremos utilizar (por default) las hojas de estilo por componente, podemos
seleccionar css o algún pre-procesador de css, tal como sass es importante saber que **cada componente está encapsulado por default,
si hacemos un cambio en el estilo de un componente, estos cambios solo se verán reflejados en ese componente**.

Posteriormente, el CLI procede a instalar las dependencias de nuestro proyecto.
Nota: Las dependencias se instalan en una carpeta llamada node_modules, es **de gran importancia** añadir esta carpeta a un .gitignore,
esta carpeta contiene todas las dependencias que usemos de npm, sin embargo, ocupa mucho espacio en disco y se comprime una vez que vayamos
a subir los archivos a producción. Cuando clonamos un proyecto que usa npm, es necesario instalar las dependencias que requiere para
funcionar, para ello, nos colocamos en la carpeta raíz del proyecto y ejecutamos `npm install`.

### Generalidades de un proyecto en Angular

En esta sección haremos un detallado recorrido entre cada uno de los archivos y carpetas de un proyecto nuevo de angular y platicaremos
acerca de su propósito.

#### .browserslistrc

Originalmente [browserslist](https://github.com/browserslist/browserslist) es un archivo de configuración que busca apuntar a versiones
(recientes) de browsers o navegadores. Angular tiene integración directa a este proyecto y sirve decidir cómo compilar nuestro proyecto,
hay algunas sentencias de css como flexbox o las lambdas de JavaScript no son compatibles con Internet Explorer u Opera,
Angular reconoce lo que contenga el archivo .browserslistrc al momento de construir el proyecto.

#### .editorconfig

[Editorconfig](https://editorconfig.org/) es una forma de implementar reglas de estilo de código, como identación, codificación de
caracteres, etc. Y sirve para que múltiples IDEs y editores reconozcan estas reglas y se configuren a ellas de forma automática.

#### .gitignore

Git ignore es un archivo específico para repositorios basados en git, le podemos indicar que ignore los cambios en los archivos y carpetas
indicados en él. Por default Angular coloca carpetas de npm, los de build, configuraciones de IDEs populares como VSCode o WebStorm.

#### angular.json

En este extenso archivo se encuentran todas las configuraciones de Angular, el nombre del proyecto, en caso de añadir sub-proyectos, dónde
crearlos, el tipo de estilo que se usan para componentes nuevos, en dónde se encuentran los archivos fuente de nuestro proyecto, el prefix
que llevarán nuestros componentes y directivas (default app) y configuraciones de construcción. Angular tiene una configuración denominada
 `"fileReplacements"` que permite sustituir un archivo por otro, esto permite tener diferentes ambientes, imaginemos que tenemos un proyecto
 que tiene un ambiente de producción y un ambiente de pruebas, la API es diferente y tal vez algunos tipos datos que retorna, también.

#### karma.conf.js

Angular tiene integración directa con KarmaJS que es un proyecto perfectamente preparado para realizar pruebas unitarias. Karma también
utiliza Jasmine que nos ayuda a crear un entorno con un DOM "falso" para realizar pruebas lo más rápido posible.

#### package.json

Es el documento base de cualquier proyecto con dependencias de node (npm), aquí tenemos la información de nuestro proyecto, el nombre, etc.
La sección `scripts` nos permite ejecutar algún script mediante `npm run <comando>`, podemos agregar nuestros propios scripts en esta
sección, la sección `dependencies` y `devDependencies` se encuentran los paquetes npm que son requeridos para el desarrollo de nuestro
proyecto, por default Angular instala los necesarios para que Angular funcione. Se puede ver aquí la integración con RxJS y typescript. La
diferencia entre dependencies y devDependencies es que unas son necesarias durante la ejecución del proyecto, las dev son necesarias
únicamente durante el desarrollo, normalmente la documentación de un paquete recomienda su uso.

#### package-lock.json

Cada vez que agregamos un paquete a nuestro proyecto o ejecutamos `npm install`, sea crea este archivo a forma de log, diciendo que versión
de paquete se instaló y si este paquete requiere la instalación de otros paquetes debido a que depende de ellos.

#### README.md

Un markdown indicando comandos básicos con Angular CLI y la referencia a la documentación de ellos.

#### tsconfig.x.json

Existen 4 diferentes tsconfig dentro de un proyecto generado con Angular 10, `tsconfig.json` sería el que tomaría por default la compilación
de typescript, este archivo contiene indicaciones de cómo queremos transformar nuestros archivos `.ts` a `.js`, dentro de `angular.json` se
puede hacer referencia al archivo que queremos usar.

#### tslint.json

Este archivo es un "linter" para TypeScript, un linter es un archivo que define reglas para el análisis de código, forzando a un editor o
IDE a mostrar un warning o un error, pidiéndole al desarrollador a cambiar la sintaxis.

#### e2e/

En esta carpeta se generan archivos base para hacer testing de tipo end-to-end, esto permite probar la aplicación de principio a fin,
haciendo un escenario real con la interacción de un usuario.

#### node_modules/

En esta carpeta se almacenan todos los paquetes que se instalan desde el `package.json`, permitiendo su uso.

#### src/

En esta carpeta pasaremos el 95% de nuestro tiempo, contiene los archivos base de nuestro proyecto.
- `src/favicon.ico` el ícono de nuestra SPA.
- `src/index.html` el archivo base de nuestra SPA.
- `src/main.ts` es el archivo destinado a iniciar nuestra aplicación, habilita el modo producción en caso que se lo indiquemos y carga el
módulo principal de nuestra app.
- `src/polyfills.ts` en este archivo tiene como propósito añadir funciones necesarias para que nuestra aplicación funcione en browsers de
versiones anteriores, a veces no basta con el browserslist y es necesario añadir scripts determinadas para el correcto funcionamiento en
navegadores anteriores.
- `src/styles.*` aquí se encuentran nuestras definiciones de estilos globales sin encapsulamiento.
- `src/test.ts` es el archivo `main.ts` pero destinado a inicializar el ambiente para pruebas unitarias usado en KarmaJS.

### Angular Material

Material Design es un sistema de diseño creado por Google enfocado en componentes mobile-first o diseño para móviles, teniendo en él
componentes como botones, banners, barras de navegación, etc. Existe una librería llamada [Angular Material](https://material.angular.io/)
que trae el enfoque de Material Design a componentes de Angular, permitiendo el uso de diversas herramientas y utilidades para el desarrollo
de nuestra aplicación.

Para hacer uso de Angular Material en nuestra aplicación, debemos colocarnos en la carpeta raíz de nuestro proyecto y ejecutar
`ng add @angular/material`, como se indica en la [guía para empezar con Angular Material](https://material.angular.io/guide/getting-started),
una vez que ejecutemos ese comando nos pide un tema predeterminado (colores) para iniciar con nuestros componentes.

Dentro del desarrollo de este tutorial, utilizaremos algunos componentes de Angular Material, para el uso de ellos podemos entrar a la
documentación oficial y seleccionar el componente que deseemos usar, por ejemplo, si queremos utilizar un datepicker (selector de fecha)
entramos a su [documentación](https://material.angular.io/components/datepicker/overview), seleccionamos la tab "API" y ahí vemos que es
necesario importar un "módulo" (entraremos más a fondo qué es un módulo en la sección 05):

```typescript
// app.module.ts
// ...
import { MatDatepickerModule } from '@angular/material/datepicker';
// ...

@NgModule({
  // ...
  imports: [
    // ...
    MatDatepickerModule
  ],
  // ...
})
export class AppModule { }
```

De la forma anterior estamos agregando a nuestra aplicación únicamente el módulo de datepicker, activando lo necesario para usar el
componente pre-hecho en nuestra aplicación. Un ejemplo de un datepicker básico podría ser:

```angular2html
<!-- app.component.html -->
<mat-form-field appearance="fill">
  <mat-label>Choose a date</mat-label>
  <input matInput [matDatepicker]="picker">
  <mat-datepicker-toggle matSuffix [for]="picker"></mat-datepicker-toggle>
  <mat-datepicker #picker></mat-datepicker>
</mat-form-field>
```

Agregamos una etiqueta que indica un campo para formulario, llamada `mat-form-field`, dentro de ella agregamos un `mat-label` que funciona
similar a un `placeholder` de un `input` en html. El input sirve para poder procesar el valor ingresado en el datepicker que veremos
posteriormente. `mat-datepicker-toggle` agrega un botón dentro de nuestro input que permite abrir y cerrar el selector de fecha.
`mat-datepicker` es el componente que crea una vista de calendario, permitiéndonos seleccionar una fecha específica y navegar entre meses
y años de forma visualmente atractiva.

El resultado del código anterior:

![DatePicker](../imagenes/modulo01/datepicker.png) 

##### Fin de módulo
