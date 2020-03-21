# ReactJS
## 1. Introducción
* El código  fuente de los ejemplos de este módulo se encuentran en la carpeta  `ejemplos/modulo01`
### 1.1 ¿Qué es ReactJS?
* ReactJS es una librería JavaScript flexible, declarativa empleada para construir interfaces de usuario. 
* Permite la construcción de sitios complejos formados por un conjunto de piezas pequeñas reutilizables llamadas *componentes* .
* ReactJS ofrece diversos tipos de componentes uno de ellos es `React.Component`
* La finalidad del uso de componentes es para comunicarle a ReactJS lo que se desea mostrar en pantalla.
* Cuando el contenido cambia, ReactJS actualizará de forma eficiente el componente correspondiente para actualizar la vista.
##### Ejemplo:
```javascript
class CourseList extends React.Component {
  render() {
    return (
      <div className="course-list">
        <h1>Course List for {this.props.name}</h1>
        <ul>
          <li>Bootstrap</li>
          <li>ReactJS</li>
          <li>Angular</li>
        </ul>
      </div>
    );
  }
}
```
* Uso del componente:
```javascript
<CourseList name="myCourses" />
```
* Al código anterior se le conoce como *React Component class*  o *React Component Type*.
* El componente puede acceder a una lista de parámetros llamados encapsulados en el objeto `props`.  Observar que el property `name`se especifica en el tag `<CourseList>`, el nombre del tag corresponde con el nombre del componente.
* Notar que el componente regresa el código a mostrar a través del método `render`.  A este código se le conoce como *description*.
* Se suele emplear una sintaxis llamada *JSX* que permite escribir estas instrucciones de forma más sencilla.
* En realidad, el método `render` regresa elementos `React`:
```javascript
return React.createElement('div', {className: 'course-list'},
  React.createElement('h1', /* ... h1 children ... */),
  React.createElement('ul', /* ... ul children ... */)
);
``` 
* Todos estos elementos pueden ser consultados en el API de ReactJS  [aquí](https://reactjs.org/docs/react-api.html). 
* Generalmente no se hace uso de esta API de forma directa. En su lugar se emplea JSX
* Cada elemento `React` está formado por un objeto Javascript que puede ser almacenado en alguna variable.
### 1.2 JSX:  JavaScript extension
* Es una extensión de Javascript  permite escribir expresiones que  le indican a ReactJS lo que debe ser mostrado en pantalla.
* JSX produce elementos `React`
##### Ejemplo:
```jsx
const element = <h1>Hello, world!</h1>;
```
* La filosofía de JSX se basa en las siguientes ideas:
	* La lógica requerida para realizar el *render* de componentes está ligada con otro tipo de lógica:  manejo de eventos en los componentes, cambio de estado de los datos con el tiempo,  preparar los datos para ser desplegado. 
	* En lugar de separar las tecnologías en diferentes archivos, por ejemplo, separar  el código html de la lógica requerida,  React une todos estos elementos en *componentes*. 
	* Los componentes tienen como característica un *bajo acoplamiento* con respecto a otros.
##### Ejemplo:
```jsx
function formatName(user) {
  return user.firstName + ' ' + user.lastName;
}
const user = {
  firstName: 'Harper',
  lastName: 'Perez'
};
const myElement = (
  <h1>
    Hello, {formatName(user)}!
  </h1>
);
ReactDOM.render(
  myElement,
  document.getElementById('root')
);
```
* En el ejemplo,  el elemento React llamado `myElement` invoca a una función JavaScript. El elemento puede contener cualquier código JavaScript válido  delimitado por llaves `{}` .
* JSX se compila empleando **Babel** que produce código JavaScript.  Esto permite que las expresiones JSX puedan emplearse como valores de retorno de una función, el ciclos for, etc.
##### Ejemplo:
```jsx
function getGreeting(user) {
  if (user) {
    return <h1>Hello, {formatName(user)}!</h1>;
  }
  return <h1>Hello, Stranger.</h1>;
}
```
* JSX produce objetos.  En realidad, se emplea el método `React.createElement`
```jsx
const element = (
  <h1 className="greeting">
    Hello, world!
  </h1>
);
```
Es equivalente a:
```jsx
const element = React.createElement(
  'h1',
  {className: 'greeting'},
  'Hello, world!'
);
```
* Estos objetos son llamados *React elements* y pueden ser vistos como descripciones de lo que se desea ver en pantalla.
* React lee estos objetos y los usa para construir el DOM y mantenerlos actualizados.
### 1.3 Hola Mundo con React.
* React ha sido diseñado para ser incorporado a un sitio web de forma gradual.
* React puede ser empleado para agregar desde un simple componente a una página web existente, y hasta para crear aplicaciones basadas totalmente en React  grandes y complejas.
* React se puede emplear tan poco o tanto como se necesite.
#### 1.3.1 Ejemplo 1 - Hola Mundo con React sin JSX
##### Paso 1. 
* Agregar un  elemento contenedor a una página HTML donde  se desea  mostrar contenido con React.
* Importante: debe tener un `id` único.
```html
<div id="root"></div>
``` 
##### Paso 2.
* Agregar  los scripts de React  al final del documento html, justo antes de `</body>`:
```html
<!-- Nota: Para producción reemplazar "development.js" por "production.min.js". -->
<script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
```
##### Paso 3.
* Crear un componente React.   En este ejemplo no se hace uso de JSX, se emplea el API de forma directa empleando un archivo `holaMundo.js`
```javascript
const element = React.createElement(
  'h1', {className: 'saludo'},
  'Hola Mundo!'
);
ReactDOM.render(
  element,
  document.getElementById('root')
);
```
##### Paso 4.  Cargar en archivo js.
* Agregar la siguiente línea a la página html  para realizar la carga del script:
```html
<!-- carga el script con el componente --->
<script src="holaMundo.js"></script>
```
* Código completo `holaMundo.html`
```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Hola Mundo con React</title>
  </head>
  <body>
    <h2>Iniciando con React</h2>
    <!-- El componente de React será mostrado aquí. Generalmente este
         tag se queda vacío. -->
    <div id="root"></div>
    <!-- Cargar React. -->
    <!-- Nota: Para producción reemplazar "development.js" por "production.min.js". -->
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
   
    <!-- carga el script con el componente --->
    <script src="holaMundo.js"></script>
  </body>
</html>
```
#### 1.3.2 Ejemplo 2 - Hola Mundo con React y JSX
* Como se mencionó anteriormente,  JSX requiere ser compilado para generar código JS. 
* Existe un [compilador Babel]([https://babeljs.io/en/repl](https://babeljs.io/en/repl)) en línea que puede ser empleado para transformar JSX en en código JS.
* Otra técnica es  compilar o transformar JSX al vuelo. La página HTML puede contener código JSX.   
* Esta técnica es útil para desarrollo pero no para producción. El código JSX se debe  transformar  para producción.
* El código JSX debe incluirse dentro del siguiente elemento:
```html
<script type="text/babel"> ... </script>
```
##### Ejemplo: holaMundoJSX.html
```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Hola Mundo con React y JSX</title>
  </head>
  <body>
    <h2>Iniciando con React</h2>
    <!-- El componente de React será mostrado aquí. Generalmente este
         tag se queda vacío. -->
    <div id="root"></div>

    <!-- Cargar React. -->
    <!-- Nota: Para producción reemplazar "development.js" por "production.min.js". -->
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
   
    <!-- compilador de JSX, no usar en producción --->
    <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>
    <!-- codigo JSX --->
    <script type="text/babel">    
      const element = (
        <h1 className="greeting">
          Hola mundo con JSX!
        </h1>
      );
      ReactDOM.render(element,
        document.getElementById('root')
      );
    </script>
  </body>
</html>
```
#### 1.3.3 Agregando soporte de JSX a un proyecto.
* Finalmente, el proceso de compilación e integración de JSX se puede integrar a un proyecto React para realizar el proceso de compilación y construcción de la aplicación. 
* El proceso es sencillo, similar al uso de un *pre-procesador css* .
* El único requisito es contar con `node.js`instalado en la pc de desarrollo.
* Las siguientes instrucciones se emplean para realizar el proceso de compilación  (esto se revisará a detalle más adelante).
```bash
npm init -y
npm install babel-cli@6 babel-preset-react-app@3
npx babel --watch src --out-dir . --presets react-app/prod 
```
* Las instrucciones anteriores configurarán un *watcher*  encargado de monitorear la carpeta `src`del proyecto React. 
* Al agregar o modificar un archivo js  con JSX,  el *watcher* realizará el proceso de compilación de manera automática. 
#### 1.4 ToolChains
* Finalmente, React ofrece diversas herramientas de construcción  que permiten organizar, ordenar y desarrollar aplicaciones React de forma eficiente y con base a buenas prácticas ( parte de estas herramientas se revisarán más adelante).
	* [Create React App](https://reactjs.org/docs/create-a-new-react-app.html#create-react-app).
	* [Next.js](https://reactjs.org/docs/create-a-new-react-app.html#nextjs).
	* [Gatsby](https://reactjs.org/docs/create-a-new-react-app.html#gatsby).
	* [Otras herramientas con mayor flexibilidad](https://reactjs.org/docs/create-a-new-react-app.html#more-flexible-toolchains).
##### Fin de módulo



