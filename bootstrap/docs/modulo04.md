# Bootstrap
## 4. NavBars.
* Elemento clásico de Bootstrap que permite crear una barra de navegación responsiva, util para crear menus, o encabezados de un sitio web.
* Se hace uso de los estilos `navbar`, `navbar-expand-xl|lg|md|sm`.
* Para agregar ligas a la barra, se usan los elementos `<ul class ="nav-item"><li>..</li></ul>`
##### Ejemplo: [navbar-example-01.html](../ejemplos/modulo3/navbar-example-01.html)
```html
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Menu 1</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Menu 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Menu 3</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled Menu</a>
    </li>
  </ul>
</nav>
```
* Observar el uso de `bg-dark navbar-dar` empleados para modificar el look & feel.  Otros estilos pueden ser `bg-primary`, `bg-success`, `bg-info`, `bg-warning`, `bg-danger`, `bg-secondary`, `bg-dark` y `bg-light`
* Notar el uso de `nav-item active` para resaltar la opción activa del menú.
* El estilo `nav-link disabled`  permite inhabilitar un link.
### 4.1 Barras verticales.
* Para crear una barra vertical se elimina el estilo el estilo `navbar-expand-xl|lg|md|sm`.  Ejemplo: [navbar-example-02.html](../ejemplos/modulo3/navbar-example-02.html)
### 4.2 Agregando logo
*  Agregando logo a la barra.  Se emplea `navbar-brand``
##### Ejemplo: [navbar-example-03.html](../ejemplos/modulo3/navbar-example-03.html)
```html
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a  class="navbar-brand" href="#"><img src="raven.png" style="height:25px;"></a>
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Menu 1</a>
    </li>
  </ul>
</nav>
```
### 4.3 Barra responsiva.
* En pantallas pequeñas, las ligas se pueden ocultar y en su lugar mostrar un botón  de menu.
* Se emplea un elemento `<button>`.   Los elementos que se desplegarán al hacer clic en el botón se ocultan en un elemento `<div>` haciendo uso de su id para relacionarlos.
##### Ejemplo: [navbar-example-04.html](../ejemplos/modulo3/navbar-example-04.html)
```html
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a  class="navbar-brand" href="#"><img src="raven.png" style="height:25px;"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div id="menu" class="collapse navbar-collapse">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Menu 1</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Menu 2</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Menu 3</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled Menu</a>
      </li>
    </ul>
  </div>
</nav>
```
* Notar el uso del atributo `id` con valor `menu`empleado para asociar el contenido del botón del menú.  Para ilustrar el efecto,  reducir la pantalla  hasta tamaño `md`.
### 4.4 Dropdown menu.
* Permite construir un menú.
##### Ejemplo: [navbar-example-05.html](../ejemplos/modulo3/navbar-example-05.html)
```html
<li class="nav-item active dropdown">
  <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Menu 1</a>
  <div class="dropdown-menu bg-dark">
    <a class="dropdown-item text-white" href="#">Menu 1.1 </a>
    <a class="dropdown-item text-white" href="#">Menu 1.2 </a>
    <a class="dropdown-item text-white" href="#">Menu 1.3 </a>
  </div>
</li>
<li class="nav-item dropdown">
  <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Menu 2</a>
  <div class="dropdown-menu bg-dark">
    <a class="dropdown-item text-white" href="#">Menu 2.1 </a>
    <a class="dropdown-item text-white" href="#">Menu 2.2 </a>
    <a class="dropdown-item text-white" href="#">Menu 2.3 </a>
  </div>
</li>
```
* Observar el uso del estilo `dropdown` en el elemento `li` para indicar el inicio del dropdown.
* El link padre se le asigna el estilo `dropdown-toggle` que permitirá mostrar u ocultar los 3 submenus 2.1, 2.2, 2.3
* Cada elemento o nodo hijo va acompañado del estilo `dropdown-item`
### 4.5 Agregando formularios a la barra.
* Se emplea el elemento `<form>` y el estilo `form-inline`
##### Ejemplo: [navbar-example-06.html](../ejemplos/modulo3/navbar-example-06.html)
```html
<ul class="navbar-nav ml-auto">
  <li class="nav-item">
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-md-2" type="search" placeholder="Buscar.." aria-label="Buscar">
      <button class="btn btn-primary my-2 my-md-0" type="submit">Buscar</button>
    </form>
  </li>
</ul>
```
* Se agrega un elemento `<ul>`al final de los menus. 
* El estilo `ml-auto` permite desplazar el formulario a la derecha.
* Observar el uso de los estilos para proporcionar márgenes adecuados al reducir el tamaño de la página  menor a `md`.
### 4.6 Fijando la barra.
* Se emplea el estilo `fixed-top`. `fixed-bottom`   posiciona la barra en en inferior de la página.
##### Ejemplo: [navbar-example-07.html](../ejemplos/modulo3/navbar-example-07.html)
```html
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
...
</nav>
```
##### Fin de módulo.
