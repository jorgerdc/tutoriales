# ReactJS
## 2. Render de Elementos  y Componentes y sus atributos.
### 2.1 Elementos en ReactJS
* Un elemento representa lo que se desea ver en pantalla:
```jsx
const myElement = <h1>Hello world!</h1>;
```
* Un componente está formado por varios elementos.
#### 2.1.1 Render  de elementos.
* Root DOM Node:  Elemento raíz dentro de una página web cuyo contenido será administrado por ReactJS:
```html
<div id="root"></div>
```
* Para realizar el render de un elemento dentro del nodo raíz se emplea `ReactDOM.render()`:
```javascript
const element = <h1>Hello world!</h1>;
ReactDOM.render(element, document.getElementById('root'));
```
* Los elementos en ReactJS son inmutables. Una vez creados,  no es posible modificar elementos hijos  o atributos. 
* Un elemento  representa el estado de una vista en un instante en el tipo. Similar a un frame de un video. 
* La forma de actualizar una vista es creando un nuevo elemento.
##### Ejemplo:
```javascript
function tick() {
  const element = (
    <div>
      <h1>Hello, world!</h1>
      <h2>It is {new Date().toLocaleTimeString()}.</h2>
    </div>
  );
  ReactDOM.render(element, document.getElementById('root'));
}
setInterval(tick, 1000);
```
* En este caso, se invoca a la función `tick` cada segundo. Dicha función actúa como *callback* de `setInterval`
* En la práctica, las aplicaciones llaman una sola vez a `ReactDOM.render` y se hace uso de  componentes de tipo *stateful*
* La función `render`acepta un parámetro que corresponde al objeto Javascript donde se realizará el *render* del elemento. En este caso en el elemento raíz `<div id="root">`.
#### 2.1.2 Actualización dinámica.
 * ReactJS compara  el estado del elemento actual con el siguiente y actualiza únicamente las diferencias para mostrar el nuevo estado.
 * La forma correcta de visualizar los cambios de una vista es pensar en  **cómo se debe visualizar una vista en cierto instante en el tiempo**  en lugar de pensar en **cómo actualizarla a lo largo del tiempo** . 
### 2.2 Componentes en ReactJS
* Componentes en ReactJS permiten dividir una vista en  piezas independientes y reutilizables. 
* Los componentes pueden visualizarse como funciones JS. Reciben datos de entrada llamados **props**.
* Regresan objetos `React`que describen lo que debe aparecer en pantalla. 
* A los componentes también se les puede llamar *function components*.
```javascript
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}
``` 					
 * El código anterior se puede expresar también en términos de una clase ES6.
 ```javascript
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}</h1>;
  }
}
```
* Un elemento puede representar a un elemento del DOM, pero también puede representar a un componente creado por el usuario:
```javascript
const element = <Welcome name="Sara" />;
```
##### Ejemplo con propiedades.
* Definición del componente:
```javascript
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}
```
*  Creación de elementos:
```javascript 
const element = <Welcome name="Sara" />;
ReactDOM.render(
  element,
  document.getElementById('root')
);
```
* En el ejemplo anterior, lo que se mostrará en la vista será `<h1>Hello, Sara</h1>`.
#### 2.2.1 Componentes de componentes.
* La definición de un componente puede hacer referencia a otros componentes:
```javascript
function App() {
  return (
    <div>
      <Welcome name="Sara" />
      <Welcome name="Cahal" />
      <Welcome name="Edite" />
    </div>
  );
}

ReactDOM.render(
  <App />,
  document.getElementById('root')
);
```
* De esta manera una aplicación React  invoca una sola vez a `ReactDOM.render`
* Típicamente  una aplicación React define un solo componente llamado `<app/>` al inicio.   Este componente puede hacer referencia a los demás elementos y reutilizarlos.
* En el ejemplo anterior, el componente `<Welcome>`se reutiliza 3 veces.
##### Ejemplo:  componentes.html
* En el siguiente ejemplo se muestra  un ejemplo muy similar a la explicación anterior en la que se crea un componente llamado `<Saludo>` que  pinta un mensaje simple de saludo.
* Este componente es reutilizado varias veces por otro componente llamado `<App>`. 
* Observar el uso del parámetro `props` empleado para definir atributos del componente. En este caso, solo se define un atributo llamado  `nombre`.
* Los atributos deben ser ***read only*** , es decir,  las funciones no deberían modificar su valor.  En otras palabras, la función debe ser ***pura***  lo que significa que no altera el valor de sus parámetros  (al estilo funciona).
* Finalmente, observar que el primer parámetro  de `ReactDOM.render` es justamente el tag `<App>`  que hace referencia al componente creado a través de la función `App`.
```jsx
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Componentes en React con JSX</title>
  </head>
  <body>
    <h2>Componentes en React con JSX</h2>
    <!-- El componente de React será mostrado aquí. Generalmente este
         tag se queda vacío. -->
    <div id="root"></div>

    <!-- Cargar React. -->
    <!-- Nota: Para producción reemplazar "development.js" por "production.min.js". -->
    <script src="https://unpkg.com/react@16/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@16/umd/react-dom.development.js" crossorigin></script>
   
    <!-- compilador de JSX, no usar en producción --->
    <script src="https://unpkg.com/babel-standalone@6/babel.min.js"></script>

    <!-- codigo JXS --->
    <script type="text/babel">
      //Este componente define un elemento Html simple    
      function Saludo(props){
        return <h2> Hola, mi nombre es <i>{props.nombre}</i>!</h2>
      }
      //Este componente está formado del componente <Saludo> y lo reutiliza.
      function App(){
        return (
          <div>
            <i> Mostrando diversios mensajes de saludo </i>
            <Saludo nombre ="Juan"/>
            <Saludo nombre="Paco"/>
            <Saludo nombre="Mariana"/>
            <Saludo nombre="Lucia"/>
          </div>
        );
      }
      //Dibujando App Notar el uso de <App/> en lugar de una variable.
      ReactDOM.render(<App/>,
        document.getElementById('root')
      );
    </script>
  </body>
</html>
```
##### Fin de módulo.
