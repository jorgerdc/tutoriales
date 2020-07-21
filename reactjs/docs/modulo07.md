# ReactJS
## 7. Formularios
### 7.1. Formularios en ReactJS
* En ReactJS los formularios se comportan ligeramente diferente a otros elementos del DOM, debido principalmente a que cada formulario guarda o define un *estado interno*.
* El comportamiento por default al hacer click en un botón *submit*  es enviar el formulario y mostrar una página nueva o simplemente recargar dicha página.
* Sin embargo, en la mayoría de los casos se desea contar con una *función* javascript que se encargue de controlar el envío del formulario así como acceder a los valores capturados.
* La forma estándar de realizar lo anterior es a través de un concepto llamado ***controlled components***.
### 7.2 Controlled components.
* En un formulario, elementos como `<input>`, `<textarea>`, etc.,  mantienen un *estado interno*  que depende de los valores capturados por el usuario.
* Por otro lado, en ReactJS, el estado de un componente se  representa a través del property `state`y se modifica empleando `setState()`.
* En ReactJS estos 2 estados se pueden combinar. 
* El componente que se encarga de mostrar al formulario también será el responsable de controlar lo que suceda en subsecuentes ediciones o capturas de datos por parte del usuario.
* Cada uno de los elementos de un formulario que son controlados por ReactJS se les conoce como ***controlled components***.
##### Ejemplo:
* Crear un componente llamado `NameForm` encargado de mostrar un *alert* al momento de enviar el formulario con el valor del nombre de una persona capturada en un campo de texto.
```jsx
class NameForm extends React.Component {
  constructor(props){
    super(props);
    this.state = {nombre: ''};
    this.submitHandler = this.submitHandler.bind(this);
    this.changeHandler = this.changeHandler.bind(this);
  }
  changeHandler(event){
    this.setState({nombre: event.target.value});
  }
  submitHandler(){
    alert('Nombre capturado: '+ this.state.nombre);
    event.preventDefault();
  }
  render(){
    return (
      <form onSubmit={this.submitHandler}>
        <label>
          Nombre:
          <input type ="text" value={this.state.nombre} 
            onChange={this.changeHandler}/>
         </label>
         <input type="submit" value ="Enviar"/> 
      </form>
    );    
  }
}
ReactDOM.render(<NameForm/>, document.getElementById('root'));
```
* Este ejemplo funciona para todos los elementos de un formulario que aceptan a un atributo `value`.
#### 7.2.1 Elemento `<textarea>`
* Este elemento no define un atributo `value`	 que permita obtener el texto capturado. 
* El texto se encuentra en el elemento hijo del tag `<textarea>`
```html
<textarea>
  Texto capturado
</textarea>
```
* A pesar de no contar con este atributo, ReactJS se emplea un atributo `value`para controlar el contenido del elemento:
```jsx
render(){
  return(
    <form onSubmit={this.submitHandler}>
      <label>
        Descripci&oacute;n
        <textarea value ={this.state.descripcion} onChange={this.changeHandler}/>
      </label>
    </form>
  );
}
```  
#### 7.2.2 Elemento `<select>`
* Considerar el siguiente ejemplo:
```html
Nivel de entrenamiento:
<select>
  <option value="basico">B&aacute;sico</option>
  <option selected value="intermedio">Intermedio</option>
  <option value="avanzado">Avanzado</option>
</select>
```
* En React no se emplea el atributo `selected`para realizar la selección inicial.  En su lugar se emplea un atributo `value`en el elemento raíz `<select>`.
##### Ejemplo:
```jsx
class SelectForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {nivel: 'intermedio'};
    this.changeHandler = this.changeHandler.bind(this);
    this.submitHandler = this.submitHandler.bind(this);
  }
  changeHandler(event){
    this.setState({nivel: event.target.value});
  }
  submitHandler(event){
    alert('Nivel de entrenamiento: '+ this.state.nivel);
    event.preventDefault();
  }
  render(){
    return(
      <form onSubmit={this.submitHandler}>
        <select value ={this.state.nivel} onChange={this.changeHandler}>
          <option value="basico">B&aacute;sico</option>
          <option value="intermedio">Intermedio</option>
          <option value="avanzado">Avanzado</option>
        </select>
        <input type="submit" value="Enviar" />
      </form>
    );
  }
}
ReactDOM.render(<SelectForm/>, document.getElementById('root'));
```
* Para un elemento `<select>` multiple, se le puede pasar un arreglo de elementos para marcar a más de una opción:
```jsx
<select multiple={true} value={['A','B','C']}>
```
* Los elementos `<input>`, `<textarea>` y `<select>` se manejan de forma muy similar a través del atributo `value`.
### 7.3 Manejando múltiples elementos.
* En el siguiente ejemplo se muestra la definición de un componente React que realiza el control de Múltiples elementos.
* En este ejemplo,  al enviar el formulario, se muestra un `alert` con los valores capturados de cada uno de los elementos.
##### Ejemplo:
```jsx
class MultipleElements extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      nombre: 'Mi nombre',
      descripcion: 'Descripción de mi mismo',
      nivelEntrenamiento: 'basico',
      enviaNotificaciones: false
    };
    //bind
    this.changeHandler = this.changeHandler.bind(this);
    this.submitHandler = this.submitHandler.bind(this);
  }
  changeHandler(event){    
    const nombre = event.target.name;
    let valor;
    //el valor capturado de todos los elementos se puede sacar del atributo
    //value excepto del checkbox. Para este elemento, se usa la siguiente validación
    if (event.target.name === 'enviaNotificaciones'){
      valor = event.target.checked;    
    }else{
      valor = event.target.value;
    }
    //Aquí se emplea el concepto de "computed property names", se
    //explica más adelante.
    this.setState(
      {[nombre]: valor}
    );
  }
  submitHandler(event){
    alert('El estado de los elementos es: \n'
      + this.state.nombre + '\n'
      + this.state.descripcion + '\n'
      + this.state.nivelEntrenamiento + '\n'
      + this.state.enviaNotificaciones
    );
    event.preventDefault();
  }
  render(){
    return(
      <form onSubmit={this.submitHandler}>
        Nombre: <br/>
        <input type ="text" name="nombre" onChange={this.changeHandler} 
          value={this.state.nombre}/><br/>
        Descripci&oacute;n: <br/>
        <textarea name="descripcion" onChange = {this.changeHandler} 
          value={this.state.descripcion}></textarea><br/>
        Nivel entrenamiento: <br/>
        <select name="nivelEntrenamiento" onChange={this.changeHandler}
          value ={this.state.nivelEntrenamiento}>
          <option value="basico">B&aacute;sico</option>
          <option value="intermedio">Intermedio</option>
          <option value="avanzado">Avanzado</option>
        </select><br/>
        Enviar notificiaciones:<br/>
        <input name="enviaNotificaciones" type = "checkbox" 
          onChange={this.changeHandler} 
          value = {this.state.enviarNotificaciones}/><br/>
        <input type="submit" value="Enviar" />
      </form>          
    );
  }
}
ReactDOM.render(<MultipleElements/>, document.getElementById('root'));
```
* Observar el uso del concepto de *Computed property names*
```jsx
this.setState(
  {[nombre]: valor}
);
```
* El método `changeHandler`recibe eventos que se producen en cualquiera de los elementos que integran al formulario, cada uno con su nombre. 
* El concepto de ***computed property names*** permite evaluar  o calcular el valor de la variable `nombre` la cual contiene el nombre del elemento html.  Este valor se sustituye para ser empleado como key o como nombre de cada uno de los properties  del estado.  Es decir, se obtendrá un estado con los siguientes properties:
```jsx
{
  nombre: 'Mi nombre',
  descripcion: 'Descripción de mi mismo',
  nivelEntrenamiento: 'basico',
  enviaNotificaciones: false
}
```
* Para mayores detalles en cuanto al concepto de *Computed property names*  revisar el [siguiente enlace](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Operators/Object_initializer#Computed_property_names).
### 7.4 Uncontrolled components. 
* En un componente controlado, los datos son administrados por ReactJS.
* En un componente no controlado, los datos son manejados por el propio DOM.
* En un componente no controlado, en lugar de escribir un `handler`se emplea el concepto de ***ref*** empleado para obtener los valores de un elemento a partir del DOM.
##### Ejemplo:
* Mostrar los valores de 3 componentes tipo `<input>` empleando `Refs`.
```jsx
class UncontrolledComponents extends React.Component {
  constructor(props){
    super(props);
    this.submitHandler = this.submitHandler.bind(this);
    this.refNombre = React.createRef();
    this.refApPat = React.createRef();
    this.refApMat = React.createRef();
  }
  submitHandler(event){
    event.preventDefault(); 
     alert('Valores de los elementos: \n '+
      this.refNombre.current.value + '\n' +
      this.refApPat.current.value + '\n' +
      this.refApMat.current.value + '\n'
    );
  }
  render(){
    return(
      <form onSubmit={this.submitHandler}>
      <label>
        Nombre:
        <input type="text" ref={this.refNombre} />
      </label><br/>
      <label>
        Ap Pat:
        <input type="text" ref={this.refApPat} />
      </label><br/>
      <label>
        Ap Mat:
        <input type="text" ref={this.refApMat} />
      </label><br/>
    <input type="submit" value="Submit" />
  </form>
    );
  }  
}
ReactDOM.render(<UncontrolledComponents/>, document.getElementById('root'));
```
* Cada `Ref` corresponde a un atributo de la clase.
* Estos objetos se asocian a los elementos html a través del atributo `ref`.
* Observar que esta técnica no requiere el uso de `handlers`.
#### 7.4.1 Elemento `<input type="file>"` 
* El archivo puede ser enviado al servidor a través de Javascript llamada [File API](https://developer.mozilla.org/en-US/docs/Web/API/File/Using_files_from_web_applications)
* En React este elemento siempre es considerado como *uncontrolled component* ya que su valor es establecido por le usuario, nunca de forma programática.
* Su manejo en un componente React se realiza a través del uso de un `Ref`.
##### Ejemplo:
* Generar un componente que muestre el nombre del archivo que será enviado al servidor.
```jsx
class FileElement extends React.Component{
  constructor(props){
    super(props);
    this.submitHandler = this.submitHandler.bind(this);
    this.fileRef = React.createRef();    
  }
  submitHandler(event){
    event.preventDefault();
    alert(`Archivo: ${this.fileRef.current.files[0].name}`);
  }
  render(){
    return(
      <form onSubmit={this.submitHandler}>
        Archivo: <br/>
        <input type="file" ref ={this.fileRef}/>
        <button type="submit">Enviar</button>
      </form>
    );
  }
}
ReactDOM.render(<FileElement/>, document.getElementById('root'));
```
* Finalmente, una de las soluciones más completas en cuanto al manejo de formularios, validación, manejo de eventos, etc., es [Formik.](https://formik.org/)
* Esta herramienta está basada en el concepto de *controlled components* y el uso de `setState`. Se revisará más adelante.
##### Fin de módulo.
