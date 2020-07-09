# ReactJS
## 4. Manejo de eventos
### 4.1  Eventos en ReactJS.
* La notación empleada en ReactJS para realizar el manejo de eventos es *camel case*
* Empleando JSX el  código que atiende al evento es representado por una función y esta es pasada como parámetro al *event handler* 
##### Ejemplo:
```jsx
<button onClick={validaFormulario}>Enviar</button>
```
* Para prevenir el comportamiento por default del elemento DOM se  debe invocar al método `preventDefault`
##### Ejemplo:
```jsx
function ActionLink(){
  function manejaClick(e){
	e.preventDefault();
    console.log('Se realizó click en la liga');
  }
  return (
    <a href="#" onClick={manejaClick}>Presionar aquí</a>
  );
}
``` 
* La especificación del objeto e se puede consultar [aquí](https://reactjs.org/docs/events.html)
* A este objeto se le conoce como *SyntheticEvent*
* Si se hace uso de una clase [ES6](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Classes),  por convención el método que maneja al evento se define como un método de la clase.
##### Ejemplo:
```jsx
class Toggle extends React.Component{
  /**
   *Constructor
   */
  constructor(props){
    super(props);
    this.state = {encendido: true}
    //este binding es necesario para poder usar 'this.manejaClick' 
    //en el html. Se explica más adente.
    this.manejaClick = this.manejaClick.bind(this);   
  }
  
  /**
   *Método encargado de manejar el evento
   */
  manejaClick(){
    this.setState( state => ({
      encendido: !state.encendido
	}));
  }
  
  /**
   * Render
   */
   render(){
     return(
       <button onClick={this.manejaClick}>
         {this.state.encendido ? 'ON': 'OFF'}
       </button>
     );
   }
}
ReactDOM.render(
  <Toggle/>,document.getElementById('root')
);
```

* Se debe tener cuidado del significado de `this`  en  callbacks de JSX .
* En Javascript un método por default no se **asocia** a la clase que lo contiene.
* Por esta razón, se debe incluir la línea arriba mostrada en el constructor.
* Si se omite esta línea, al incluir `this.manejaClick` en la expresión `onClick={this.manejaClick}`  se obtendría `undefined`.
* Este comportamiento no es particular de ReactJS.  
* En general, en JavaScript si se hace referencia a un método sin `()` después de su nombre, justo como se hace al usar `onClick`,  se debe realizar  la asociación o `bind`del método hacia la clase.
* Existe una sintaxis alterna para evitar este proceso de *binding*
```jsx
<button onClick={() => this.handleClick()}>
``` 
*  La desventaja es que se crea un  nuevo callback cada vez que se realiza el render del botón. Esto puede generar detalles de desempeño.  Se recomienda  realizar el `binding` mencionado.

### 4.2  Parámetros en event handlers 
* Los siguientes ejemplos son equivalentes:

```jsx
<button onClick={(e) => this.deleteRow(id, e)}>Delete Row</button>
<button onClick={this.deleteRow.bind(this, id)}>Delete Row</button>
``` 

* Ver ejemplo  `toggle.html` 

##### Fin de módulo
