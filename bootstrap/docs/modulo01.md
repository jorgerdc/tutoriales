# Bootstrap
## 1. Introducción
* En código de los ejemplos de este módulo se encuentran en GitHub, en la carpeta `ejemplos/modulo01`
### 1.1 ¿Qué es Bootstrap?
* Representa uno de los frameworks front-end más populares empleados para construir sitios responsivos, con una gran variedad de elementos gráficos, templates entre otros.
* El siguiente código muestra la plantilla básica para iniciar a trabajar con Bootstrap.  Importente:  
	* Hacer uso de  HTML 5
	* Emplear `viewport` meta tag (permite un comportamiento responsivo adecuado).
	* Algunos componentes hacen uso de JQuery, Popper.js así como algunos plugins JS.
```html
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" 
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" 
      crossorigin="anonymous">
    <title>Hello, world!</title>
  </head>
  <body>
    <h1>Hello, world!</h1>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
      crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" 
      integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" 
      crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" 
      integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" 
      crossorigin="anonymous">
    </script>
  </body>
</html>
```
### 1.2 Uso de elementos globales.
* Bootstrap hace uso de estilos globales empleados en todas las vistas. De aquí la importancia de conocerlos y tenerlos presentes en todo momento.
	* Uso de html 5 doctype
	* Responsive meta-tag
	* Uso de Reboot para proporcionar un *render* homogéneo entre navegadores y dispositivos móviles.
	* Para obtener un mejor dimensionamiento  de los elementos empleando CSS,  se actualiza el valor de  la propiedad `box-sizing` de `content-box` a `border-box`.
### 1.3 Obtener e Instalar Bootstrap
* Bootstrap se puede descargar (archivo zip)  en su forma *compilada* (¡en bootstrap los archivos CSS se compilan empleando  *Sass compiler* !) y  *reducida*   (archivos css y js reducidos).
	* La siguiente imagen muestra la estructura del archivo zip
```plaintext
bootstrap/
├── css/
│   ├── bootstrap-grid.css
│   ├── bootstrap-grid.css.map
│   ├── bootstrap-grid.min.css
│   ├── bootstrap-grid.min.css.map
│   ├── bootstrap-reboot.css
│   ├── bootstrap-reboot.css.map
│   ├── bootstrap-reboot.min.css
│   ├── bootstrap-reboot.min.css.map
│   ├── bootstrap.css
│   ├── bootstrap.css.map
│   ├── bootstrap.min.css
│   └── bootstrap.min.css.map
└── js/
    ├── bootstrap.bundle.js
    ├── bootstrap.bundle.js.map
    ├── bootstrap.bundle.min.js
    ├── bootstrap.bundle.min.js.map
    ├── bootstrap.js
    ├── bootstrap.js.map
    ├── bootstrap.min.js
    └── bootstrap.min.js.map
```

* Bootstrap puede incorporarse haciendo uso de  BootstrapCDN  (Content Delivery Network).  Esta técnica se empleó en el ejemplo anterior.   Se trata de un URL público en donde se  encuentra la bootstrap compilado y reducido listo para emplearse en los proyectos.   Se hace uso de un caché para mejorar el desempeño.
##### Ejemplo:
```
https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css
```
*  Bootstrap se puede instalar empleando package managers como  `npm`, `yarn` , etc.
### 1.4  Bootstrap theming
* A partir de Bootstrap 4 se hace uso de *Variables Saas* , *Saas Maps*, y CSS personalizado para construir la apariencia de un sitio web. 
#### 1.4.1 Variables Saas
* Las variables  Saas tienen definen valores por default.  Estos valores pueden ser sobrescritos empleando scripts saas  (archivos con extensión saas: `custom.scss`). El archivo personalizado realizará `@import` de los archivos saas de Bootstrap para extender o sobrescribir  su valor.
```scss
$body-bg: #000;
```
#### 1.4.2 Saas Maps
* Bootstrap hace uso de Maps y Loops para representar a un conjunto de reglas CSS relacionadas.
```scss
$theme-colors: (
  "primary": #0074d9,
  "danger": #ff4136
);
```
* Este tipo de definiciones se pueden sobrescribir empleando un archivo `saas`personalizado.
#### 1.4.3 Functions.
* Las funciones representan otro elemento  para personalizar la apariencia de un sitio. 
```scss
@function color($key: "blue") {
  @return map-get($colors, $key);
}
```
#### 1.4.4 Variables personalizadas
* Empleadas para personalizar estilos CSS globales, por ejemplo, variables `$enable-*`
#### 1.4.5 @each
* Algunos componentes en Bootstrap y utilerías hacen uso de `@each` para iterar sobre Map Saas. Estas iteraciones permiten aplicar variantes a un componente al modificar los valores de las variables en cada iteración.
##### Fin de módulo.
