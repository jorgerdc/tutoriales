﻿# ReactJS

## 6. Lists, Keys

### 6.1. Transformación de listas en Javascript

- Una de las funciones comúnmente empleadas para manejar listas de componentes es la función `map`.
- Esta función se emplea para realizar operaciones sobre cada uno de los elementos de un arreglo al estilo programación funcional.
- Uno de sus parámetros es una función o _callback_ que contiene el código a ejecutar en cada iteración.

##### Ejemplo:

- Obtener un arreglo B cuyos valores de sus elementos correspondan al doble de los valores de un arreglo A

```javascript
const arregloA = [1, 2, 3, 4, 5];
const arregloB = arregloA.map((numero) => numero * 2);
console.log(arregloB);
```

##### Ejemplo:

- Obtener un arreglo de 5 componentes `ul` para formar el siguiente código html:

```html
<ul>
  <li>1</li>
  <li>2</li>
  <li>3</li>
  <li>4</li>
  <li>5</li>
</ul>
```

- Solución:

```jsx
const numeros = [1, 2, 3, 4, 5];
const componentes = numeros.map((numero) => <li>{numero}</li>);
ReactDOM.render(<ul>{componentes}</ul>, document.getElementById("root"));
```

- Notar que el código javascript dentro del código JSX se escribe entre `{}`.

##### Ejemplo:

- Crear un componente llamado `<NumberList>`.
- El componente recibirá un arreglo de números como parámetro y deberá generar una salida similar al ejemplo anterior.

```jsx
function NumberList(props){
  const numeros = props.numeros;
  const componentes =numeros.map(
    (numero) => <li>{numero}</li>
  );
  return (
    <ul>{componentes}</ul>
  );
}

const numeros=[1,2,3,4,5];
ReactDOM.render(
  <NumberList numeros={numeros} />,
  document.getElementById('root');
);
```

- Al ejecutar el código anterior se obtendrá el siguiente warning:

```javascript
Warning: Each child in a list should have a unique "key" prop.
```

- Una llave o key hace referencia a un atributo especial que se requiere agregar a los componentes JSX cuando se generan listas.

#### 6.2 Keys

- Las Keys ayudan a ReactJS a identificar si alguno de los elementos de dicha lista ha cambiado o si alguno de sus elementos ha sido eliminado.
- Cada elemento de la lista debe contar con valor _único_ asignado como _key_. Típicamente su valor corresponde con algún identificador o id.
- Los valores deben ser únicos entre elementos de la misma lista, es decir, los valores se pueden repetir pero en listas diferentes.
- Se emplea el atributo `key` para especificar su valor.

##### Ejemplo:

```jsx
const numeros = [1, 2, 3, 4, 5];
const items = numeros.map((numero) => (
  <Item key={numero.toString()} value={numero} />
));
```

- En caso de no contar con algún Id propio, o estos no sean únicos, se puede emplear el índice de la propia lista que se proporciona como parte de los argumentos del método `map`.

```jsx
const numeros = [1, 1, 2, 2, 2];
const items = numeros.map((numero, index) => (
  <Item key={index} value={index + 1} />
));
```

- Ojo: No emplear índices si el orden de los elementos de la lista cambia.

#### 6.3 Generación de objetos JSX con keys.

- La asignación de la _key_ a cada elemento de la lista se debe realizar cuando se escribe el elemento JSX en lugar de hacerlo con los elementos HTML estándar.
- Por ejemplo, suponer que se tiene un componente `ListItem` que define a un elemento `<li>valor</li>`, la definición del atributo key debe asignarse al usar `<ListItem>` en lugar de hacerlo con el elemento `<li>`

##### Ejemplo:

```jsx
function Producto(props) {
  // forma correcta. Aquí no se hace uso de key
  return (
    <li>
      {props.numProducto + 1} - {props.nombre}
    </li>
  );
}

function OrdenCompra(props) {
  const productos = props.productos;
  const productosJsx = productos.map((prod, index) => (
    //forma correcta, aquí se debe asignar a la key
    <Producto key={index} nombre={prod} numProducto={index} />
  ));
  return <ul>{productosJsx}</ul>;
}

const productos = ["Laptop", "Mouse", "Mochila"];
ReactDOM.render(
  <OrdenCompra productos={productos} />,
  document.getElementById("root")
);
```

- Notar que en el componente `Producto` se incluye su `key`, así como su nombre y un atributo llamado `numProducto`.
- Observar que este último atributo también contiene al valor de la `key`.
- Este atributo es necesario cuando se desee mostrar en el componente el valor de la `key`.
- El atributo `key` es empleado por ReactJS para detectar cambios, pero este no está disponible como property. Si se desea mostrarlo, se usa otro property con nombre diferente, en este caso al atributo `numProducto`.
- Una forma más compacta de hacer uso de la función `map` es emplearla directamente en la instrucción `return` y evitar así la declaración de la variable `productosJsx`

```jsx
function OrdenCompra(props){
  const productos = props.productos;
  return <ul>{
    productos.map((prod,index) =>
      <Producto  key ={index}  nombre ={prod}  numProducto ={index} />
    );
  }</ul>
}
```

- Tener cuidado ya que esto puede generar código complicado de leer.
- Ver la carpeta `ejemplos` para revisar el código fuente.

##### Ejemplo:

- Crear una página que muestre el historial académico de un alumno para un semestre en específico (se debe incluir el nombre del alumno, el semestre y una tabla con los datos de las materias cursadas y sus correspondientes calificaciones). Si alguna calificación es menor a siete se debe resaltar el texto en color rojo.
- Emplear Bootstrap para dar estilos a la tabla.

```jsx
const Materia = (props) => {
  const item = props.item;
  const index = props.index;
  const className = item.calificacion < 7 ? "text-danger font-weight-bold" : "";
  return (
    <tr className={className}>
      <th scope="row">{index + 1}</th>
      <td>{item.asignatura}</td>
      <td className="text-center">{item.creditos}</td>
      <td>{item.profesor}</td>
      <td className="text-center">{item.grupo}</td>
      <td className="text-center">{item.calificacion}</td>
    </tr>
  );
};

const Calificaciones = (props) => {
  const calificaciones = props.calificaciones;
  return (
    <div>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Asignatura</th>
            <th scope="col" className="text-center">
              Créditos
            </th>
            <th scope="col">Profesor</th>
            <th scope="col" className="text-center">
              Grupo
            </th>
            <th scope="col" className="text-center">
              Calificación
            </th>
          </tr>
        </thead>
        <tbody>
          {calificaciones.map((item, index) => (
            <Materia key={index} item={item} index={index} />
          ))}
        </tbody>
      </table>
    </div>
  );
};

const RegistroAlumno = (props) => {
  const alumno = props.alumno;
  return (
    <div>
      <h1 className="mt-5">Historial Académico</h1>
      <p className="mb-0">
        <span className="font-weight-bold">Nombre:</span> {alumno.nombre}
      </p>
      <p>
        <span className="font-weight-bold">Semestre:</span> {alumno.semestre}
      </p>
      <h4>Detalle de las calificaciones:</h4>
      <Calificaciones calificaciones={alumno.calificaciones} />
    </div>
  );
};

const alumno = {
  nombre: "Juanito López",
  semestre: "2020-2",
  calificaciones: [
    {
      asignatura: "Bases de Datos",
      creditos: 8,
      profesor: "Jorge A. Rodríguez Campos",
      grupo: 1,
      calificacion: 10,
    },
    {
      asignatura: "Diseño Digital",
      creditos: 8,
      profesor: "Juan Flores López",
      grupo: 3,
      calificacion: 7,
    },
    {
      asignatura: "Economía",
      creditos: 8,
      profesor: "Andrés Manuel López Obrador",
      grupo: 4,
      calificacion: 6,
    },
  ],
};

ReactDOM.render(
  <RegistroAlumno alumno={alumno} />,
  document.getElementById("root")
);
```

##### Fin de módulo.
