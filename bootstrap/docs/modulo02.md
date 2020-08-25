# Bootstrap
## 2. Containers,  Grid System, Texto, Colores
* El código de los ejemplos de este módulo se encuentran en GitHub, en la carpeta `ejemplos/modulo02`
### 2.1 Breakpoints responsivos.
* A través del concepto de *[media queries](https://developer.mozilla.org/en-US/docs/Web/CSS/Media_Queries/Using_media_queries)*   Bootstrap ha definido una serie de medidas sensibles que representan las dimensiones de una pantalla y  permiten disparar ciertas acciones.  Por ejemplo,  organizar los elementos de un formulario de forma vertical para que sean mostrados correctamente en el dispositivo, etc.
* Básicamente el uso de *media queries* puede visualizarse como una variable que permite aplicar diferentes estilos CSS  de forma dinámica cuyos valor  depende del dispositivo que se usa para mostrar una pantalla, o cuando la resolución o tamaño de la pantalla se ajusta. 
* La siguiente definición es tomada de los archivos Saas de Bootstrap:

```scss
// Extra small devices (portrait phones, less than 576px)
// No media query for `xs` since this is the default in Bootstrap

// Small devices (landscape phones, 576px and up)
@media (min-width: 576px) { ... }

// Medium devices (tablets, 768px and up)
@media (min-width: 768px) { ... }

// Large devices (desktops, 992px and up)
@media (min-width: 992px) { ... }

// Extra large devices (large desktops, 1200px and up)
@media (min-width: 1200px) { ... }
``` 
* Como se indica en el código anterior,  **xs** representa a un breakpoint válido, pero no existe una definición propia como *media query* ya que es el valor por default.  Los demás se abrevian como **sm, md, lg, xl**
* Es importante entender y tener en cuenta el concepto de *Responsive Breakpoint* ya que se emplea en diversas funcionalidades de Bootstrap.

### 2.2  Containers
* Representan el elemento básico para realizar la construcción de layouts.
* Necesarios  para hacer uso del *default grid system* de  Bootstrap el cual es muy útil para distribuir y organizar los componentes de una página HTML.
* Los conteedores pueden anidarse aunque no es muy frecuente su uso.
#### 2.2.1 Tipos de Containers
Bootstrap ofrece 3 tipos de containers:
* *Responsive:* Emplea el estilo `.container`. Establece un valor para el estilo `.max-width` que corresponde al valor máximo de ancho de pantalla que se ajusta dependiendo el dispositivo típicamente conocido como ***responsive breakpoint***.
* *Fluid width:*  Hace uso del estilo `.container-fluid` y establece el valor del ancho de la pantalla siempre al 100%  para todos los breakpoints:  `width: 100%`
* *Responsive with:*  Hace uso del estilo  `.container-{breakpoint}`, significa que el ancho máximo se establecerá al 100% pero hasta cierto breakpoint	.
##### ejemplos:
```html
<div class="container">
  <!-- Content here -->
</div>
<div class="container-fluid">
  <!-- Content here -->
</div>
```
* En la siguiente tabla se muestran las medidas y su uso por cada tipode container.

Estilo | Extra small <576px | Small >=576px | Medium >=768px | Large >=992px | Extra Large >=1200px|
-- | -- | -- | -- | -- | -- |
`.container` |100%	|540px|	720px|	960px|	1140px|
`.container-sm`|	100%|	540px|	720px|	960px|	1140px|
`.container-md`|	100%|	100%|	720px|	960px|	1140px|
`.container-lg`|	100%|	100%|	100%|	960px|	1140px|
`.container-xl`|	100%|	100%|	100%|	100%|	1140px|
`.container-fluid`|	100%|	100%|	100%|	100%|	100%|

##### Ejemplo:
```html
    <div class="container-sm themed-container">container-sm (small)</div>
    <div class="container-md themed-container">container-md (medium)</div>
    <div class="container-lg themed-container">container-lg (large)</div>
    <div class="container-xl themed-container">container-xl (extra large></div>
    <div class="container themed-container">container</div>    
    <div class="container-fluid themed-container">container-fluid (fluid) </div>
```
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/contenedores.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/contenedores.html)

### 2.3 Grid System
 * A través del uso de los conceptos de containers, uso de renglones y columnas, Bootstrap permite crear  layouts (diseños) para organizar y alinear grupos de objetos en una misma vista.
 * Construido con [Flexbox](https://css-tricks.com/snippets/css/a-guide-to-flexbox/#flexbox-background), permite hasta 12 columnas, se pueden agrupar.
* Grid System es responsivo, se adapta al tamaño de la pantalla.
* Restricción:  Cuidar que la suma de columnas sea 12 o menor.
* Principales estilos de bootstrap empleados para establecer el ancho de la celda  (de menor a mayor)
	*  `.col-`  (< 576px)
	*   `.col-sm-`  ( small  >= 576px)
	*   `.col-md-`  (medium <= 768px)
	*   `.col-lg-`  (large >= 992px)
	*   `.col-xl-`  (xlarge >= 1200px)
* Estos estilos escalan hacia arriba (crecen dinámicamente si el tamaño de la pantalla es mayor).
##### Ejemplo: 
```html
<div class="row">
  <div class="col-sm-4" style="background-color: lavender;">1</div>
  <div class="col-sm-4" style="background-color: orange;">2</div>
  <div class="col-sm-4" style="background-color: lightblue;">3</div>
</div>
```
* En el ejemplo anterior se crean 3 columnas de tamaño similar  para dispositivos  **sm, md, lg y xl** 
* Lo anterior significa que si se intenta mostrar este contenido en un dispositivo xs, las columnas se mostrarán en formato vertical. 
* ¿ Qué pasaría si el estimo se modifica a `col-lg-4` ?
	* Las columnas se mostrarán en formato vertical al 100% de ancho para pantallas **xs, sm, md**.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-01.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-01.html)  Modificar el breakpoint y redimensionar la ventana del navegador para comprobar los efectos.
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
* En este ejemplo, se obtienen columnas del mismo ancho. 
* Notar que solo se especifican los valores `sm, md, lg, xl` para que sea responsiva. Si se eliminan  los breakpoints, el grid ya no será responsivo. Puede ser  útil cuando el grid es el mismo en todos los tamaños de dispositivos. 
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-02.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-02.html)
##### Ejemplo
* Uso del estilo `col-{breakpoint}-auto`  para  auto - ajustar las columnas a su contenido.
```html
<div class="row">
  <div class="col-sm-auto" style="background-color: lavender;">texto corto</div>
  <div class="col-sm-auto" style="background-color: orange;">texto que no es corto</div>
  <div class="col-sm-auto" style="background-color: lightblue;">texto que ocupa m&aacute;s espacio</div>
</div>
```
* En este ejemplo, se muestra un grid ajustado al contenido a partir del breakpoint sm.  Para pantallas menores, el grid se muestra en forma vertical ocupando el 100% de ancho sin importar el contenido.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-03.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-03.html)  Modificar el estilo del contenedor  de `container-fluid` a `container`  para ver el efecto que produce.
##### Ejemplo:
* Uso de los estilos `col-#` en combinación con `col-{breakpoint}-#` para controlar el comportamiento del renglón al alcanzar el breakpoint.
* Hasta este momento, al alcanzar el breakpoint, las columnas se muestran de forma vertical y se expanden al 100%.  Con estas combinaciones se puede modificar el comportamiento. Revisar el siguiente ejemplo:

```html
<div>Row 1</div>
  <div class="row">
    <!--Columnas responsivas, se ajustan al 100% al alcanzar el breakpoint-->
    <div class="col-sm-4" style="background-color: lavender;">4 - 2</div>
    <div class="col-sm-4" style="background-color: royalblue;">4 - 2</div>
    <div class="col-sm-4" style="background-color: orange;">4 - 2</div>
  </div>
  <div>Row 2</div>
  <div class="row">
    <!--columnas responsivas, pero al alcanzar el breakpoint se quedan al 33.3%,
        no se expanden al 100% -->
    <div class="col-4 col-sm-4" style="background-color: lavender;">4 - 4</div>
    <div class="col-4 col-sm-4" style="background-color: royalblue;">4 - 4</div>
    <div class="col-4 col-sm-4" style="background-color: orange;">4 - 4</div>
  </div>
  <div>Row 3</div>
  <div class="row">
    <!--columnas responsivas, pero al alcanzar el breakpoint se distribuyen en proporción
        de 2, 7 y 3 en lugar de expander al 100% -->
    <div class="col-2 col-sm-4" style="background-color: lavender;">4 - 2</div>
    <div class="col-7 col-sm-4" style="background-color: royalblue;">4 - 7</div>
    <div class="col-3 col-sm-4" style="background-color: orange;">4 - 3</div>
  </div>
  <div>Row 4</div>
  <div class="row">
    <!--columnas responsivas, pero al alcanzar el breakpoint se distribuyen en proporción
        de 2, 8 y 8. Al sumar la tercer columna genera un valor de 18 que excede del 
        valor máximo 12, por lo tanto se baja al siguiente renglón conservando la proporción -->
    <div class="col-2 col-sm-4" style="background-color: lavender;">4 - 2</div>
    <div class="col-8 col-sm-4" style="background-color: royalblue;">4 - 7</div>
    <div class="col-8 col-sm-4" style="background-color: orange;">4 - 3</div>
  </div>
```
* El orden de los estilos es irrelevante.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-04.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-04.html)
##### Ejemplo
* Uso del estilo `row-cols-*` para simplificar la configuración por columna. El estilo se aplica desde el elemento padre (desde el elemento `row` )
* Se puede especificar el número de columnas a mostrar antes de pasarlas a un siguiente renglón.
```html
<div>Row 1</div>
<div class="row row-cols-2">
  <!--Columnas no responsivas, para todos los tamaños  se incluyen solo 2-->
  <div class="col" style="background-color: lavender;">1</div>
  <div class="col" style="background-color: royalblue;">2</div>
  <div class="col" style="background-color: orange;">3</div>
  <div class="col" style="background-color: greenyellow;">4</div>
  <div class="col" style="background-color: lightcoral;">5</div>
  <div class="col" style="background-color: lightgreen;">6</div>
</div>
<div>Row 2</div>
<!-- En este ejemplo el número de columnas cambia con base al breakpoint desde 
     1 columna en xs hasta 6 para xl-->
<div class="row  row-cols-1 row-cols-sm-2 row-cols-md-4 row-cols-lg-5 row-cols-xl-6">
  <div class="col" style="background-color: lavender;">1</div>
  <div class="col" style="background-color: royalblue;">2</div>
  <div class="col" style="background-color: orange;">3</div>
  <div class="col" style="background-color: greenyellow;">4</div>
  <div class="col" style="background-color: lightcoral;">5</div>
  <div class="col" style="background-color: lightgreen;">6</div>
</div>
``` 
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-05.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-05.html)

##### Ejemplo
* Alineación  horizontal de  renglones.
* Se emplean los estilos` justify-content-start, justify-content-center, justify-content-end, justify-content-around, justify-content-between`
* Estos estilos se especifican en conjunto con el estilo `row`
```html
<div>Row 1</div>
<div class="row justify-content-start">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 2</div>
<div class="row justify-content-center">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 3</div>
<div class="row justify-content-end">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 4</div>
<div class="row justify-content-around">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 5</div>
<div class="row justify-content-between">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
```
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-06.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-06.html)

##### Ejemplo.
* Alineación vertical de  renglones completos y de celdas individuales.
* En este caso se emplean los estilos `align-items-start, align-items-center, align-items-end` , de igual forma, estos estilos se especifican en conjunto con el estilo `row`
* Para realizar alineación por celda individual se emplean los estilos `align-self-start, align-self-center, align-self-end`.
* El estilo `big_row` solo se emplea para agrandar el alto de cada renglón para poder apreciar el efecto.
```html
<div>Row 1 align-items-start </div>
<div class="row align-items-start big_row">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 2 align-items-center</div>
<div class="row align-items-center big_row">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>
<div>Row 3 align-items-end </div>
<div class="row align-items-end big_row">
  <div class="col-2" style="background-color: lavender;">1</div>
  <div class="col-2" style="background-color: royalblue;">2</div>
</div>    
<div>Alinear por columna</div>
<div class="row big_row">
  <div class="col-2 align-self-start" style="background-color: lavender;">1 align-self-start </div>
  <div class="col-2 align-self-center" style="background-color: royalblue;">2 align-self-center </div>
  <div class="col-2 align-self-end" style="background-color: lightsalmon;">3  align-self-end</div>
</div>
```
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-07.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-07.html)
##### Ejemplo
* Uso de offsets para mover o agregar espacios entre celdas.
* Existen 2 técnicas
	* Empleando estilos del propio Grid System (offset classes)
	* Haciendo uso de utilerías para márgenes. 
* Los estilos del Grid system incluyen los estilos `offset-{breakpoint}-*`  el asterisco indica en número de columna  [1-12].
* Dependiendo el estilo, la columna se mueve hacia la derecha
```html
<div>Row 1</div>
<div class="row">
  <div class="col-sm-2 offset-sm-2" style="background-color: lavender;">1</div>
  <div class="col-sm-2 offset-sm-2" style="background-color: royalblue;">2</div>
  <div class="col-sm-2 offset-sm-2" style="background-color: lightsalmon;">3</div>
</div>
<div>Row 2</div>
<div class="row">
  <div class="col-md-2" style="background-color: lavender;">1</div>
  <div class="col-md-2 offset-sm-8" style="background-color: royalblue;">2</div>
</div>
<div>Row 3</div>
<div class="row">
  <div class="col-md-2 offset-md-5" style="background-color: lavender;">1</div>
</div>
```
* Observar que se trata de cuidar que la suma de las columnas + los offsets sea 12.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/grid-example-07.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/grid-example-07.html)

### 2.4 Valores por default para manejo de texto
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
##### Ejemplos: 
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
* El  código completo puede consultarse [aquí.](../ejemplos/modulo02/text-example.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/text-example.html)
   ### 2.4 Colores en Bootstrap
* Bootstrap define una serie de estilos para colores de  fuente dependiendo el contexto: `text-muted`, `text-primary`, `text-success`, `text-info`, `text-warning`, `text-danger`, `text-secondary`, `text-white`, `text-dark`, `text-body` , `text-light`.
* De forma similar,  existen estilos para fondos contextuales: `bg-primary`, `bg-success`, `bg-info`, `bg-warning`, `bg-danger`, `bg-secondary`, `bg-dark` and `bg-light`
##### Ejemplo:
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
 * El  código completo puede consultarse [aquí.](../ejemplos/modulo02/color-example.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo02/color-example.html)
   ##### Fin de módulo.
   
