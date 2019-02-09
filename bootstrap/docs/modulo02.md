# Bootstrap
## 2. Containers,  Grid System, Texto, Colores
* En código de los ejemplos de este módulo se encuentran en GitHub, en la carpeta `ejemplos/modulo02`
### 2.1  Containers
* Representan el elemento básico para realizar la construcción de layouts.
* Necesarios  para hacer uso del *default grid system* de  Bootstrap.
* Opciones para construir un contenedor:
	* Responsive
	* Fixed width
	* Fluid width (se extiende al 100% todo el tiempo).
##### ejemplo:
```html
<div class="container">
  <!-- Content here -->
</div>
<div class="container-fluid">
  <!-- Content here -->
</div>
```
### 2.2 Grid System
* Construido con Flexbox, permite hasta 12 columnas, se pueden agrupar.
* Grid System es responsivo, se adapta al tamaño de la pantalla.
* Restricción:  Cuidar que la suma de columnas sea 12 o menor.
* Principales estilos de bootstrap empleados para establecer el ancho de la celda  (de menor a mayor)
	*  `.col-`  (< 576px)
	*   `.col-sm-`  ( small  >= 576px)
	*   `.col-md-`  (medium <= 768px)
	*   `.col-lg-`  (large >= 992px)
	*   `.col-xl-`  (xlarge >= 1200px)
* Estos estilos escalan hacia arriba (crecen dinámicamente si el tamaño de la pantalla es mayor).
##### Ejemplo: grid-example.html
```html
<div class="row">
  <div class="col-sm-6">1</div>
  <div class="col-sm-6">2</div>
</div>
```
* En general el formato del estilo es `col-*-*` el primer valor corresponde con el ancho responsivo de la columna `sm, md, lg, xl`, y el segundo es un número que debe sumar 12 o menos.
* En el ejemplo,  se tendrán 2 columnas que se expanden a lo largo de la página al sumar 12.
##### Ejemplo:
```html
<div class="row">
  <div class="col-sm-10">1</div>
  <div class="col-sm-2">2</div>
</div>
```
* En este ejemplo, la columna 1 es mucho más ancha que la segunda, en una proporción 10 a 2.
##### Ejemplo:
```html
<div class="row">
	<div class="col-sm">1</div>
	<div class="col-sm">2</div>
	<div class="col-sm">3</div>
	<div class="col-sm">4</div>
</div>
```
* En este ejemplo, se obtienen columnas del mismo ancho. Notar que solo se especifican los valores `sm, md, lg, xl` para que sea responsiva.
### 2.3 Valores por default para manejo de texto
* `font-size` de 16px
* `line-height` de 1.5
* `font-family` es "Helvetica Neue", Helvetica, Arial, sans-serif.
* Elementos `<p>` tienen `margin-top: 0` y `margin-bottom: 1rem` (16px por default).
* Uso de `<h1>` hasta `<h6>`
	*  h1 Bootstrap heading  (2.5rem = 40px)
	* h2 Bootstrap heading  (2rem = 32px)
	* h3 Bootstrap heading  (1.75rem = 28px)
	* h4 Bootstrap heading  (1.5rem = 24px)
	* h5 Bootstrap heading  (1.25rem = 20px)
	* h6 Bootstrap heading  (1rem = 16px)
* Elementos `display` para textos mas grandes.
* Elementos `blockquote` con estilos `blockquote`y `blockquote-footer`.
* Elementos `<dl>`  (description list).
* Contenido inline se emplea el tag `<code>`
* Keyboard elements empleando el tag `<kbd>`
* Uso del tag `<pre>` 
* Finalmente, la lista completa de estilos ccs  [aquí](https://www.w3schools.com/bootstrap4/bootstrap_ref_all_classes.asp)
##### Ejemplos: ver text-example.html
```html
<div class="container-fluid">
   Normal  text style row 1<br>
   Normal  text style row 2<br>
   <p>Paragraph text style 1</p>
   <p>Paragraph text style 2</p>
   Normal  text style row 3<br>
   Normal  text style row 4<br>
   <h1>H1 Text default style</h1>
   <h2>H2 Text default style</h2>
   <h3>H3 Text default style</h3>
   <h4>H4 Text default style</h4>
   <h5>H5 Text default style</h5>
   <h6>H6 Text default style</h6>
   <p> Display elements: </p>
   <h1 class="display-1">Display 1</h1>
   <h1 class="display-2">Display 2</h1>
   <h1 class="display-3">Display 3</h1>
   <h1 class="display-4">Display 4</h1>
   <p> Small elements: </p>
   <h1>H1 Text default style <small>smaller style</small></h1>
   <h2>H2 Text default style <small>smaller style</small></h2>
   <h3>H3 Text default style <small>smaller style</small></h3>
   <h4>H4 Text default style <small>smaller style</small></h4>
   <h5>H5 Text default style <small>smaller style</small></h5>
   <h6>H6 Text default style <small>smaller style</small></h6>
   <p> Mark examples:</p>
   <p> This is <mark>Use the mark task to highlight some important text</mark> or paragraph</p>
   <p> Blockquote example: </p>
   <blockquote class="blockquote">
     this is an example of text inside of blockquote tag
     The blockquote element is used to present content from another source.
     <footer class="blockquote-footer"> Text from www.other.site.com</footer>
   </blockquote>
   <p> Description list examples:</p>
   <dl>
     <dt>Fruit</dt>
     <dd> - Apples</dd>
     <dd> - Grapes</dd>
     <dt>Animals</dt>
     <dd> - Dog</dd>
     <dd> - Cat</dd>
   </dl>
   <p> Examples with code tag </p>
   <p> Here are <code>some</code> elements using the 
     <code>code</code> tag (<code>inline elements</code>) 
   </p>
   <p>Keyboard elements using kbd tag:</p>
   <p> To print: <kbd>Ctrl + P</kbd> Copy: <kbd>Ctrl + C</kbd> </p>
   <p> Exaples with pre tag </p>
   <pre> 
     This is an example of pre tag
     This is another example of pre tag
     1       one
       2       two
         3       three
           4       four
     More text using pre tag
   </pre>
</div>
   ```
   ### 2.4 Colores en Bootstrap
   * Bootstrap define una serie de estilos para colores de  fuente dependiendo el contexto: `text-muted`, `text-primary`, `text-success`, `text-info`, `text-warning`, `text-danger`, `text-secondary`, `text-white`, `text-dark`, `text-body` , `text-light`.
   * De forma similar,  existen estilos para fondos contextuales: `bg-primary`, `bg-success`, `bg-info`, `bg-warning`, `bg-danger`, `bg-secondary`, `bg-dark` and `bg-light`
##### Ejemplo, ver text-example.html
```html
<div class="container-fluid">
  <p>Contextual colors:</p>
  <p class="text-muted">This text is muted.</p>
  <p class="text-primary">This text is important.</p>
  <p class="text-success">This text indicates success.</p>
  <p class="text-info">This text represents some information.</p>
  <p class="text-warning">This text represents a warning.</p>
  <p class="text-danger">This text represents danger.</p>
  <p class="text-secondary">Secondary text.</p>
  <p class="text-dark">This text is dark grey.</p>
  <p class="text-body">Default body color (often black).</p>
  <p class="text-light">This text is light grey (on white background).</p>
  <p class="text-white">This text is white (on white background).</p>
  <p>Contextual backgrounds:</p>
  <p>Use the contextual background classes to provide "meaning through colors".</p>
  <p>Note that you can also add a .text-* class if you want a different text color:</p>
  <p class="bg-primary text-white">This text is important.</p>
  <p class="bg-success text-white">This text indicates success.</p>
  <p class="bg-info text-white">This text represents some information.</p>
  <p class="bg-warning text-white">This text represents a warning.</p>
  <p class="bg-danger text-white">This text represents danger.</p>
  <p class="bg-secondary text-white">Secondary background color.</p>
  <p class="bg-dark text-white">Dark grey background color.</p>
  <p class="bg-light text-dark">Light grey background color.</p>
</div>
   ```
   ##### Fin de módulo.
