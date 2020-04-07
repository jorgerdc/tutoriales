# ReactJS
## 3. Estado y ciclo de vida de un componente.
### 3.1  Estado de un componente.
* Hasta el momento, la única forma que se conoce para cambiar el estado de la UI (User Interface) es a través de `ReactDOM.render()`.
* Para ilustrar el ciclo de vida de un componente se retoma el ejemplo del Reloj en el que el DOM es actualizado cada segundo con la hora actual. 
* El componente se reestructura de la siguiente manera:
```jsx
function Clock(props){
  return (
    <div>
      <h1>Mi reloj con ReactJS!</h1>
      <h2> Son las {props.date.toLocaleTimeString()} </h2>
    </div>
  );
}

function tick(){
  ReactDOM.render(
    <Clock date={new Date()} />,
    document.getElementById('root')
  );
}
setInterval(tick,1000);
```
* El código anterior tiene  un detalle:  necesita auxiliarse de la función `setInterval`para poder actualizar la hora cada segundo. 
* Lo ideal sería que el componente se actualizara por si mismo.
* Para ello es necesario que el componente `Clock`se actualice por si solo. Para ello el componente deberá contar con su *estado*.
* Cada componente administra de forma privada o local  a su propio estado.
* Para realizar lo anterior, el componente debe ser reescrito o ser convertido en una **clase**.
#### 3.1.1 Conversión de un function component a una Clase.
1. Crear una Clase  ES6  con el mismo nombre  del componente que extienda de `React.Component`
2. Agregar un método sin argumentos llamado `render()`.
3. Mover el código del componente al cuerpo del método.
4. Reemplazar `props`con `this.props` en el método `render()`.
##### Ejemplo:
```jsx
class Clock extends React.Component {
  render(){
    return (
      <div>
        <h1>Mi reloj con ReactJS!</h1>
        <h2> Son las {this.props.date.toLocaleTimeString()} </h2>
      </div>
    );
  }
}
```
* El método `render`será invocado cada vez que ocurra un cambio.
#### 3.1.2 Agregando  local state a la clase.
* Para el ejemplo del reloj, la fecha será agregada al *estado* de la clase:
1. Se agrega un constructor:
```jsx
class Clock extends React.Component {
  constructor(props){
	 //siempre se debe llamar al constructor base
    super(props);
    // se agrega la fecha al estado de la clase.
    this.state = {date: new Date()};
  }
  ...
}
```
2. Se actualiza la referencia a la fecha, ahora forma parte del objeto `state`.
```jsx
<h2>It is {this.state.date.toLocaleTimeString()}.</h2>
```
* El código final quedará así:
```jsx
class Clock extends React.Component {

  constructor(props){
    //invocar siempre al constructor nbase
    super(props);
    // se agrega la fecha al estado de la clase.
    this.state = {date: new Date()};
  }
  render(){
    return (
      <div>
        <h1>Mi reloj con ReactJS!</h1>
        <h2> Son las {this.props.date.toLocaleTimeString()} </h2>
      </div>
    );
  }
  ReactDOM.render(</Clock>, document.getElementById('root'));
}
```
#### 3.1.3 Agregando métodos para controlar el ciclo de vida de un componente.
* `componentDidMount`: Se invoca cuando se hace el render del componente en el DOM por primera vez. A este proceso se le conoce como *mounting* 
* `componentWillUmount`: Invocado justo antes de que el componente sea removido del DOM.
* Para el ejemplo del reloj ser hará uso de `componentDidMount` para inicializar el timer:
```jsx
componentDidMount(){
  this.timerId = setInterval(
    () => this.tick(),
    1000
  );
}
```
* En el código anterior se configura un timer.  el método `tick` definido más adelante en esta misma clase deberá ser invocado cada 1000 segundos. 
* El timer se guarda en un atributo de la clase llamado `timerId`.
* Hasta este momento la clase `Clock` define 3 atributos:
	* `this.props`: Inicializado por React
	* `this.state`: Define el estado del componente
	* `this.timerId`: Atributo personalizado.  En cada clase es posible definir  los atributos que sean necesarios (Similar a un atributo de instancia en Java).
* Para cerrar recursos se emplea  `componentWillUmount`. 
```jsx
componentWillUmount(){
  clearInterval(this.timerId);
}
```
* Por último, el método `tick` será invocado cada segundo con base a la definición del timer. 
* En cada invocación se realzará un cambio en el estado del componente para que el método `render`sea invocado y de esta forma la UI sea actualizada. El código completo es el siguiente:
```jsx
class Clock extends React.Component {

  /**
   * Constructor. Se agrega un objeto date al estado del componente. Si
   * su valor llegara a cambiar el método render será invocado y por lo tanto
   * La UI será actualizada
   */
  constructor(props){
    //invocar siempre al constructor nbase
    super(props);
    // se agrega la fecha al estado de la clase.
    this.state = {date: new Date()};
  }
  
  /**
   * Render. Actualiza la UI con el código definido en este método
   * El valor de la fecha ahora se toma del estado de la clase.
   */
  render(){
    return (
      <div>
        <h1>Mi reloj con ReactJS!</h1>
        <h2> Son las {this.state.date.toLocaleTimeString()} </h2>
      </div>
    );
  }

  /**
   * Se inicializa el timer justo después de montar el componente
   * En el DOM
   */
  componentDidMount(){
    this.timerId = setInterval(
      () => this.tick(),
      1000
    );
  }

  /**
   * Se liberan recursos justo antes de remover el componente del DOM.
   */
  componentWillUmount(){
    clearInterval(this.timerId);
  }

  /**
   * Este método actúa como callback del timer. Se invoca cada
   * segundo. El método provoca un cambio en  state.date  Esto
   * provoca un cambio en el estado de la clase y por lo tanto dispara
   * la ejecución del método render.
   */
   tick(){
    this.setState(
      {date: new Date()}
    );
   }  
}
//ya fuera de la clase:
ReactDOM.render(<Clock/>, document.getElementById('root'));
```
* Al momento de pasarle el componente a `ReactDOM.render` React llama al su constructor.  Se inicializa el estado del componente.
* Se invoca a `render` Al invocarlo React determina lo que se debe actualizar en la UI. React actualiza el DOM con el contenido de este método.
* Al actualizar el DOM, se invoca a `componentDidMount`. Con base al ejemplo, el componente le solicita al navegador inicializar el timer haciendo uso del método `tick`como callback.
* Cada segundo el navegador invoca a la función `tick`. Al actualizar la fecha, se produce un cambio en la UI al invocar a `setState`, es decir, se invoca nuevamente a `render`con la fecha actualizada. 
#### 3.1.4 Algunas reglas para administrar el estado de un componente.
* No modificar el estado de forma directa:
```jsx
//incorrecto
this.state.comment='Hola';
//correcto
this.setState({comment: 'Hello'});
```
* El único punto donde se puede asignar objetos al `state`es en el constructor.
* React puede *unir* varias llamadas a `setState`en una sola para mejorar desempeño.
* `this.props`y `this.state`pueden ser actualizadas de form asíncrona, por lo que no debe ser usadas de forma conjunta para determinar el siguiente estado del componente.
```jsx
//incorrecto
this.setState(
  {counter: this.props.increment + this.state.counter}
);
//correcto
this.setState(
  (state,props)=>({props.increment + state.counter})
);
//de forma equivalente:
this.setState(
  function (state,props){
    return {counter: props.increment + state.counter}
  }
);
```
* En el código correcto se invoca a `setState`que recibe:
	*  El estado anterior del componente
	* el objeto`props`con los valores que tendrá el componente al momento de ser actualizado.

* Ningún componente puede saber si otro componente es stateful, stateless, ni tampoco sabe si el componente fue definido como una función o como una clase.
* Por lo anterior al estado de un componente se le llama *local* o *encapsulado*.  No es accesible a otros componentes. 
* Lo que si se puede hacer es pasar su estado en términos de propiedades hacia otros objetos:
```jsx
<h2>It is {this.state.date.toLocaleTimeString()}.</h2>
```
* En este ejemplo,  `<h2>`  no sabe que la fecha que se le pasa como valor proviene de un estado, o si inclusive fue escrita a mano.
##### Fin de módulo.
