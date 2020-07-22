# ReactJS
## 5. Rendering condicional
### 5.1. Render de ciertos componentes.
* Es posible realizar la definición  de varios componentes que encargados de encapsular cierto comportamiento. 
* Dependiendo del estado de la aplicación solo ciertos componentes pueden ser mostrados con base al cumplimiento de ciertas condiciones.
* Considerar los siguientes 2 componentes que  muestran un mensaje de saludo dependiendo el tipo de persona: usuario o invitado.
```jsx
function SaludoUsuario(){
  return <h1>Bienvenido usuario!</h1>;
}
function SaludoInvitado(){
  return <h1>Bienvenido invitado</h1>;
}
```
* Considerar ahora un siguiente componente que muestra alguno de los 2 componentes anteriores con base al valor de una variable:

```jsx
function Saludo(props){
  const enSesion = props.enSesion;
  if(enSesion){
    return <SaludoUsuario/>;
  }else{
    return <SaludoInvitado/>;
  }
}
```
* Considerar los siguientes 2 componentes que muestran 2 botones. Uno para hacer `login`y otro para hacer `logout`
```jsx
function LoginButton(props){
  return <button onClick={props.onClick}>Iniciar sesión</button>; 
}
function LogoutButton(props){
  return <button onClick={props.onClick}>Cerrar sesión</button>;
}
```
* Notar el uso de `{props.onClick}`. El handler que se empleará para manejar el evento se obtiene a través del objeto `props` que recibe la función como parámetro.
* Como se verá en el siguiente componente, este hará uso de alguno de estos 2 botones empleando la siguiente expresión:
```jsx
<LoginButton onClick={this.loginClickHandler}/>
```
* El evento `onClick` forma también parte de los atributos del componente `LoginButton`y por lo tanto puede ser referenciado como cualquier parámetro a través del objeto `props`.   

* El siguiente paso es crear ahora un componente que muestre el botón y el saludo adecuado con base a su estado actual.  A este componente le llamaremos `ControlLogin`
```jsx
class ControlLogin extends React.Component{
  constructor(props){
    super(props);
    this.loginClickHandler= this.loginClickHandler.bind(this);
    this.logoutClickHandler= this.logoutClickHandler.bind(this);
    this.state ={enSesion: false};
  }
  loginClickHandler(){
    this.setState({enSesion: true});
  }
  logoutClickHandler(){
    this.setState({enSesion: false});
  }
  render(){
    const enSesion=this.state.enSesion;
    let boton;
    if(enSesion){
      boton= <LogoutButton onClick={this.logoutClickHandler}/>;
    } else{
      boton= <LoginButton onClick={this.loginClickHandler}/>;
    }
    //muestra el botón y el saludo con base al valor de enSesion
    return(
      <div>
        <Saludo enSesion={enSesion}/>              
        {boton}
      </div>
    );
  }
}
ReactDOM.render(
  <ControlLogin/>,document.getElementById('root')
);
```
* Básicamente esta clase ilustra el uso de una variable `boton`y de una constante `enSesion` que se emplean para condicionar a los componentes que serán mostrados en pantalla.
* Las variables que apunten a elementos o componentes pueden emplearse entre llaves `{}`  haciendo posible el render dinámico de un componente.
### 5.2. Inline If, operadores lógicos.
* Es posible insertar cualquier expresión JSX empleando `{}` como delimitadores. 	
* Es posible escribir expresiones booleanas y operadores lógicos como `&&`, `||`, etc.
##### Ejemplo:
```jsx
function MailBox(props){
  const numEmailsSinLeer=props.emailsSinLeer.length;
  return (
    <div>
      <h1>Bandeja de entrada</h1>
      { numEmailsSinLeer >0 &&
        <h2>Usted tiene {numEmailsSinLeer} emails nuevos.</h2>
      }
      { numEmailsSinLeer==0 &&
        <h2>Felicidades! No tiene correos por leer.</h2>
      }
    </div>
  );
}
const mensajes = ['m1','m2','m3'];
ReactDOM.render(
  <div>
    <MailBox emailsSinLeer={mensajes}/>
    <MailBox emailsSinLeer={[]}/>
  </div>
  ,document.getElementById('root')
);
```
* En este ejemplo se crea una expresión booleana  `boolean && expression` la cual en javascript evalúa a `expression`
* En la segunda expresión se compara con cero para simular la no existencia de emails por leer.
* Finalmente observar en el segundo uso de `MailBox` se usa un arreglo vacío lo que provoca el render de una bandeja de entrada sin correos por leer.
* Las siguientes expresiones muestran otras formas para manejar render condicional:
```jsx
render(){
  return(
    <div>
      El usuario <b>{enSesion ? 'está' : 'no está'}</b> en sesión. 
    </div>
  );
}
```
#### Prevenir render de un componente.
* Si se regresa `null`en el método `render` el componente no será mostrado.
```jsx
function WarningMessage(props){
  if(props.warning){
    return null;
  }
  return (
    <div>Warning!</div>
  );
}
```

* Ver la carpeta `ejemplos` para revisar el código fuente.
##### Fin de módulo.
