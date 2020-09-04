
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

#### Instalación en MacOS y Windows

Simplemente ingresamos al [sitio oficial de node](https://nodejs.org/) y bajamos el instalador para nuestro sistema operativo

### Generalidades de un proyecto en Angular
### Angular Material
##### Fin de módulo
