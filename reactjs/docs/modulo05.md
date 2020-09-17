# ReactJS
## 5. Rendering condicional
* En general el concepto de Rendering condicional se refiere a la posibilidad de incorporar sentencias de control  javascript, como son  `if`, `else`, operador `?` , `:`, etc.,  dentro de código JSX para mostrar solo determinados componentes al momento de invocar a una operación `render`.

### 5.1. Render de ciertos componentes.
*  A través del uso de una función o de una clase, es posible realizar la definición  de varios componentes.
* Dependiendo del estado de la aplicación o de alguna condición en particular solo ciertos componentes deberían ser mostrados. 
* Con ayuda del estado del componente o con base a los valores de sus  `properties`, se puede decidir qué contenido mostrar (contenido condicionado).
##### Ejemplo.
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
* El  código completo puede consultarse [aquí.](../ejemplos/modulo05/controlLogin.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/reactjs/ejemplos/modulo05/controlLogin.html)
### 5.2. Inline If, operadores lógicos.	
* Es posible escribir expresiones booleanas cuyo operando izquierdo sea cualquier expresión que se evalúe a verdadero o falso.  Para renderizar un componente por medio de un `inline-if` es necesario encerrar la expresión JSX entre `{ }`. A nivel general la sintaxis queda de la siguiente forma:	
```jsx
{expresionBooleanaEnJS && <expresionJSX>...</expresionJSX>}
``` 
* Observar que después de la expresión booleana se escribe el operador lógico `&&` seguido de la expresión a renderizar cuando la condición se evalúa a `true`. 	
##### Ejemplo.
* Simulación de una bandeja de entrada de correos electrónicos.
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
* En este ejemplo se crea una expresión booleana  `boolean && expression`.  Al realizar su evaluación se obtiene como resultado a la propia expresión representada por `expression` cuando `boolean`sea `true`. 
* Dicho de otra forma,  `numEmailsSinLeer > 0 && <h2> ...</h2>` obtendrá como resultado al elemento `<h2>...</h2>` cuando `numEmailsSinLeer > 0` genere un valor verdadero. 
* En la segunda expresión se compara con cero para simular la no existencia de emails por leer.
* Finalmente observar en el segundo uso de `MailBox`, se usa un arreglo vacío lo que provoca el render de una bandeja de entrada sin correos por leer.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo05/mailBox.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/reactjs/ejemplos/modulo05/mailBox.html)
#### 5.2.1 Formas alternativas para hacer  render condicionado
* Las siguientes expresiones muestran otras formas para manejar render condicional empleando el operador ternario.
```jsx
render(){
  const enSesion=this.state.enSesion;
  let boton;
  //se hace uso del operador ternario 
  //condición ? expresión1 : expresión2;   
  boton = enSesion ?
    <LogoutButton onClick={this.logoutClickHandler}/> :
    <LoginButton onClick={this.loginClickHandler}/>;
  //muestra el botón y el saludo con base al valor de enSesion
  return(
    <div>
      <Saludo enSesion={enSesion}/>              
      {boton}
    </div>
  );
}
```
#### 5.2.2 Prevenir render de un componente.
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

