# ReactJS
## 8. AJAX y APIs
### 8.1.  Peticiones AJAX
* En ReactJS se puede emplear cualquier librería AJAX para realizar peticiones. Dentro de las más populares están:
	* [Axios](https://github.com/axios/axios)
	* [JQuery AJAX](https://api.jquery.com/jQuery.ajax/)
	* [Window.fetch](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API)  (Browser built-in) 
* Las llamadas AJAX por lo general se realizan el el método `compomentDidMount`  que es invocado durante el ciclo de vida del componente al ser incorporado al DOM.
* Se puede emplear `setState`para actualizar o inicializar el estado del componente.
### 8.2 Peticiones AJAX empleando  window.fetch
* La función `fetch`permite realizar peticiones AJAX. Recibe como parámetro un URL  y regresa un objeto tipo `Promise` que a su vez resuelve a un objeto `Response`.   El detalle de los objetos `Promise`se puede consultar [aquí](https://www.promisejs.org/)  y también [aquí](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise).
* Ojo: Para Internet Explorer se necesita [polyfill.](https://github.com/facebook/create-react-app/blob/master/packages/react-app-polyfill/README.md)
* En el ejemplo se muestra el contenido del siguiente [endpoint](https://jsonplaceholder.typicode.com/posts).
* La estructura de los datos obtenidos es la siguiente:
```json
[
  {
    "userId": 1,
    "id": 1,
    "title": "some title",
    "body": "some body"
  },
  {
    "userId": 1,
    "id": 2,
    "title": "some title ..",
    "body": "some body ..."
  },
  ...
]
```
* El componente React solo muestra los atributos `userId` y `title`. Notar que como key de los elementos `<li>`se emplea al atributo `id`.
```jsx
class AjaxBasico extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    }
  }
  componentDidMount(){
    //realiza la llamada AJAX
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then(res => res.json())
      .then (
        (result) =>{
          this.setState({
            isLoaded: true,
            items: result
          });
        }
        ,
        //Manejo del error
        (error)=>{
          this.setState({
            isLoaded: true,
            error
          });
        }
      );
  }
  render(){
    const{ error , isLoaded, items} = this.state;
    if(error){
      return <div>Error: {error.message}</div>
    } else if (!isLoaded){
       return <div>Cargando...</div>; 
    }else{
      return ( 
        <ul>
          {
            items.map(item => (
              <li key={item.id}>User id: {item.userId}, title: {item.title}</li>
            ))
          }
        </ul>
      )
    }
  }
}
ReactDOM.render(<AjaxBasico/>, document.getElementById('root'));
```
* La función `fetch` hace uso de métodos encadenados llamados `then`. Estos métodos reciben como parámetros funciones callback para recibir o procesar el resultado de la petición AJAX.
* En la segunda llamada del método `then` se obtiene resultado de la petición AJAX y se almacena en el estado del objeto React empleando los atributos `error`, `items` y `isLoaded`.
* `items` hace referencia al arreglo JSON y a partir de este se hace uso de la función map para extraer su contenido.
### 8.3 Uso de  async y await 
* Como se puede observar, el manejo de métodos `then`y el uso de `callbacks`puede volver al código complicado de entender.
* Las instrucciones  `async`y  `await` permite simplificar el manejo  de objetos  `Promise`
* `async` es una palabra reservada  que se emplea en la declaración de una función.
* `await`se emplea para el manejo del objeto `Promise`.
* `await` debe emplearse dentro de la función que incluye `async`.
* Las funciones marcadas con `async` regresan objetos `Promise` sin importar el objeto que se incluya en la cláusula `return`.
#### 8.3.1 Uso general de async y await.
El siguiente ejemplo muestra la forma general de uso de estas 2 instrucciones.
```javascript
//la siguiente función incluye async, por lo tanto se puede usar await
async function fetchContent(){
  //en lugar de emplear fetch, emplear await
  let contenido = await fetch("url");
  let text = await contenido.text();
  //el resultado de la variable text corresponde con el body de la petición
  console.log(text);
  //regresar el texto como objeto Promise
  return text;
}
```
* Invocar a la función de forma asíncrona.
```javascript
let promise = fetchContent().then(...);
```
##### Ejemplo:
* Modificar el ejemplo anterior y hacer uso de  `async`y  `await`.
```jsx
class AjaxBasico extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    }
  }

  async getJson(){
    try{
      let response = await fetch("https://jsonplaceholder.typicode.com/postss");
      if(response.status == 200){
        let json = await response.json();
        this.setState({
          isLoaded: true,
          items: json
        });  
      }
      throw new Error('Invalid HTTP code: '+response.status);
    }catch(e){
      this.setState({
        isLoaded: true,
        error: e
      });
    }    
  }
  componentDidMount() {
    this.getJson();
  }

  render(){
    const{ error , isLoaded, items} = this.state;
    if(error){
      return <div>Error: {error.message}</div>
    } else if (!isLoaded){
       return <div>Cargando...</div>; 
    }else{
      return ( 
        <ul>{items.map(item => (
              <li key={item.id}>User id: {item.userId}, title: {item.title}</li>
            ))}
        </ul>
      )
    }
  }
}
ReactDOM.render(<AjaxBasico/>, document.getElementById('root'));
```
* Observar que se evita el uso de llamadas a métodos `then`.
* Se hace uso de un bloque `try`- `catch` para realizar el manejo de errores y de códigos http no esperados. 
### 8.4  Uso de axios.
* Por sus características y requerimientos, se revisará este tema mas adelante ya que conviene incorporarlo una vez que se haya revisado el uso de ***Create  React App*** que será la herramienta a emplear para construir aplicaciones ReactJS ya en forma.
