# Bootstrap
## 3. Formularios, diálogos modales.
* El código de los ejemplos de este módulo se encuentran en GitHub, en la carpeta `ejemplos/modulo03`
* Elementos soportados en Bootstrap:
	* input
	* textarea
	* checkbox
	* radio
	* select
* Para el caso del elemento `<input>`  es importante asignar el valor correcto del atributo `type` según sea el caso: `text, password, datetime, datetime-local, date, month, time, week, number, email, url, search, tel, color`.
* Bootstrap soporta 2 formas distintas de organizar elementos de un formulario:
	* Stacked (full-width) form
	* Inline form
* En general, los formularios deben estar dentro de un container.
### 3.1 Stacked form
* Por default, Bootstrap aplica los siguientes estilos a la mayoría de los elementos de un formulario: `display: block` y `width: 100%`
* Lo anterior significa que  cada elemento se mostrará en  un renglón alineados verticalmente.
#### 3.1.1 Grupos de elementos y estilos
* Para proporcionar una estructura adecuada, un formulario puede estar compuesto por grupos.  En general, cada grupo  puede contener los siguientes integrantes:
	* Elemento del formulario: `<input>`, etc.
	* Etiqueta del elemento HTML: `<label>`, etc.
	* Elemento para mostrar algún mensaje de validación. Por ejemplo, empleando el elemento `<span>`.
* Se emplea el estilo `form-group` para agrupar elementos y homologar apariencia
* Se emplea el estilo `form-control`  para homologar los estilos y apariencia  para los elementos `<input>, <textarea>, <select>`
* Se emplean los estilos `form-control-lg, form-control-md, form-control-sm ` para controlar el tamaño de los elementos (altura).
* Para un elemento `<input type = "file">` se emplea `form-control-file`
* Para elementos solo de lectura se emplea el atributo `readonly` y el estilo `form-control-plaintext`
##### Ejemplo: 
```html
<form action="">
  <!-- group 1-->
  <div class="form-group">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" class="form-control" 
      placeholder="Nombre del usuario">
  </div>
  <!-- group 2 -->
  <div class="form-group">
    <label for="password">Contrase&ntilde;a</label>
    <input type="password" name="password" id="password" class="form-control" 
        placeholder="Contrase&ntilde;a">
    <small class="form-text text-muted">Escribir al menos 8 caracteres</small>
  </div>
  <!--group 3-->
  <div class="form-group">
    <label for "carrera">Carrera</label>
    <select class="form-control" id="carrera" name="carrera">
      <option>Ing. Computaci&oacute;n</option>
      <option>Ing. Electr&oacute;nica</option>
      <option>Otra</option>
    </select>
  </div>
  <!--tamaño de elementos-->
  <br/>
  <h6 class="text-secondary">Tama&ntilde;o de los elementos (altura)</h6>
  <!--group 4-->
  <div class="form-group">
    <label for="lg">Large (lg)</label>
    <input class="form-control form-control-lg" type="text" placeholder=".form-control-lg">
  </div>
  <!--group 5-->
  <div class="form-group">
    <label for="lg">Default</label>
    <input class="form-control" type="text" placeholder="Default">
  </div>
  <!--group 6-->
  <div class="form-group">
    <label for="lg">Small (sm)</label>
    <input class="form-control form-control-sm" type="text" placeholder=".form-control-sm">
  </div>
  <!--group 7-->
  <div class="form-group">
    <label for="read_only">Solo de lectura</label>
    <input class="form-control-plaintext" readonly type="text" placeholder="No editable">
  </div>
  <!-- group 8-->
  <div class="form-group">
    <label for="file">Subir archivo</label>
    <input class="form-control-file" type="file" placeholder="Subir archivo">
  </div>
  <button type="submit" class="btn btn-primary">Siguiente</button> 
 </form>
```
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-01.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-01.html)
### 3.2 Inline forms
* el tag `<form>` debe contener el estilo `form-inline`
* La apariencia del formulario puede ser mejorado con las utilerías de espaciado de Bootstrap.
#### 3.2.1 Spacing
* Bootstrap ofrece estilos para proporcionar valores de las propiedades `margin` y `padding`  de forma responsiva. 
* Los valores de espaciado van de `.25rem` a `3rem` (rem = medida relativa al tamaño de la letra del elemento root).
* El espaciado aplica a todos los breakpoints, desde `xs` hasta `xl` . Para  `xs` no existe abreviatura por ser el menor.
* Los estilos tienen la siguiente notación: `{property}{sides}-{breakpoint}-{size}`
* Valores para `property:`
	*  m - margin
	* p - padding
* Valores para `sides`
	* t  - top
	* b - bottom
	* l - left
	* r - right
	* x - left y right
	* y - top y bottom
* Valores para `size`
	* 0 - 0
	* 1 - 0.25
	* 2 - 0.5
	* 3 - 1
	* 4 - 1.5
	* 5 - 3
	* auto - margen automático.
* Por ejemplo, `mr-sm-2` agrega un margen a la derecha del elemento de tamaño pequeño (`sm`).   El estilo `sb-2` agrega un margen abajo de elemento para los casos en los que los elementos se muestran verticalmente para pantallas pequeñas.
* El estilo `mx-auto` puede ser empleado para  centrar contenido de forma horizontal con tamaño fijo:
```html
<div class="mx-auto" style="width: 200px;">
  Contenido centrado
</div>
```
#### 3.2.2 Ejemplos de formularios inline con espaciado
```html
<form action="" class="form-inline">
 <div class="form-group">
   <label for="nombre" class="mr-lg-5 mr-md-3 mr-sm-1">Nombre</label>
   <input type="text" name="nombre" class="form-control mb-2 mr-5">        
 </div>
 <div class="form-group">
   <label for="apellido" class="mr-lg-5 mr-md-3 mr-sm-1">Apellido</label>
   <input type="text" class="form-control mb-2 mr-2">    
 </div>  
 <button type="submit" class="btn btn-primary mb-2">Siguiente</button>
</form>  
```
* Observar los margenes responsivos de los elementos `<label>`.  Para `lg` se establece un valor de 5. Al alcanzar `md` se modifica a 3 y con `sm` se modifica a 1.
* Al botón se le asigna un margen inferior `mb-2` 
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-02.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-02.html)
### 3.3 Formularios responsivos empleando Grid System.
* El uso de Grid System permite construir formularios complejos de múltiples columnas y tamaños  diferentes.
* Se hace uso de los estilos del Grid System
* Para habilitar el uso de Grid system, el formulario debe tener wrapper con:
	*  `<div class row>...</div>`
	* `<div class form-row>...</div>`  Sobrescribe a los valores por default de Grid System, proporcionando valores más compactos, adecuados para formularios.
##### Ejemplo:
```html
<form>
  <div class="form-row">
    <div class="col-md-2">
      <input type="text" class="form-control" placeholder="Nombre">
    </div>
    <div class="col-md-10">
      <input type="text" class="form-control" placeholder="Direccion">
    </div>
  </div>
</form>
```
* En este ejemplo, se crean un renglón con 2 columnas. La primera con tamaño 2 y la segunda  con tamaño 10.  recordar que la suma de las longitudes de las columnas debe ser 12.
* Notar que en cada celda solo se incluye un elemento: `<input`>.  Al ser un solo elemento,  no es necesario crear grupos de elementos por cada celda.
* Finalmente, observar el uso del estilo `form-control`. Este estilo es importante ya que permite que los elementos se muestren correctamente  y se expandan a lo largo de la columna.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-03.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-03.html)
##### Ejemplo: 
*  Formulario para capturar los  datos generales de un curso.
```html
<div class="form-row">
  <div class="form-group col-md-9">
    <label for="nombre">Nombre</label>
    <input type="text" class="form-control" name="nombre" id="nombre"
      placeholder="Nombre o t&iacute;tulo del curso">
  </div>
  <div class="form-group col-md-3">
    <label for="totalHoras">Total de horas</label>
    <input type="text" class="form-control w-50" name="totalHoras" id="totalHoras"
      placeholder="00">
  </div>
</div>
```
* En este ejemplo se crea un renglón con 2 columnas. La primera de longitud 9 y la segunda con longitud 3
* Cada columna está  formada por un grupo de elementos. Esto se especifica empleando el estilo `form-group`. 
* Cada grupo está formado por una etiqueta `<label>` y el elemento del formulario `<input>`.
* Notar el uso del estilo `w-50` para personalizar el ancho del elemento `<input>`.
##### Ejemplo:
```html
<div class="form-row">
  <div class="form-group col-md-6">
    <div>
      <label>Modalidad del curso</label>
    </div>
    <!--radio 1-->
    <div class="custom-control custom-radio custom-control-inline">
      <input type="radio" name="modalidad" class="custom-control-input" id="presencial" 
        value="P">
      <label class="custom-control-label" for="presencial">Presencial</label>
    </div>
    <!--radio 2-->
    <div class="custom-control custom-radio custom-control-inline">
      <input type="radio" name="modalidad" class="custom-control-input" id="en-linea" 
        value="L">
      <label class="custom-control-label" for="en-linea">En l&iacute;nea</label>
    </div>
    <!--radio 3-->
    <div class="custom-control custom-radio custom-control-inline">
      <input type="radio" name="modalidad" class="custom-control-input" id="hibrido" 
        value="H">
      <label class="custom-control-label" for="hibrido">H&iacute;brido</label>
    </div>
  </div>
  <div class="form-group col-md-6">
    <label for="status">Status del curso</label>
    <input type="text" name="status" id="status" class="form-control w-50" 
      readonly="readonly" value="VIGENTE">
  </div>
</div>
```
* Este ejemplo es un poco más complicado con respecto a los anteriores.
* Se crean únicamente 2 columnas, cada una de longitud 6.
* La primera columna contiene un grupo de radio buttons desplegados horizontalmente  (inline). 
* Notar el uso de un elemento `<div>`que actúa como *wrapper*  de un radio button y su correspondiente etiqueta:
```html
<div class="custom-control custom-radio custom-control-inline">...</div>
```
* Por cada radio button se agrega su correspondiente wrapper.  Esto permite mejorar la apariencia del elemento.
* Observar el uso de los estilos `custom-control-input` y `custom-control-label` . Se emplean también para mejorar la apariencia del elemento y su etiqueta.
* Un punto importante a mencionar es que el valor del atributo `id` de la etiqueta `<label>` debe corresponder con el `id`de su correspondiente radio button.
##### Ejemplo:
```html
<div class="row justify-content-center">      
    <input class="btn btn-primary mr-1" type="reset" value="Limpiar">  
    <button type="submit" class="btn btn-primary ml-1">Siguiente</button>
</div>
```
* En este ejemplo, se muestran 2 botones centrados  al final del formulario.
* Notar el uso del estilo `justify-content-center` empleado para posicionar los  botones al centro de la pantalla.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-04.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-04.html)
##### Ejemplo:
*  El siguiente ejemplo se muestra otra manera de agrupar los elementos del formularios.  En lugar de agrupar la etiqueta  de cada elemento del formulario,  esta se incluye en una celda separada. Esto provoca que la etiqueta quede del lado izquierdo de la pantalla.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-05.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-05.html)
### 3.4 Diálogos modales.
* El siguiente ejemplo muestra los estilos necesarios a configurar para crear diálogos modales en Bootstrap.
##### Ejemplo:
```html
<a href="#" class="offset-md-9"  data-toggle="modal" data-target="#addTopic"> 
  Agregar t&oacute;pico
</a>
```
* En el ejemplo, se creará un dialogo modal. Observar el uso del atributo `data-toggle`  y `data-target` el cual apunta al id del elemento html (típicamente `<div>`) cuyo contenido será mostrado como dialogo. 
```html
<div class="modal fade" id="addTopic">
  <div class="modal-dialog modal-lg">
   <div class="modal-content">
     <!--header --> 
     <div class="modal-header">
       <h4>Capturar T&oacute;pico</h4>
     </div>
     <!--body-->
     <div class="modal-body">
       <div class="container-fluid">
           <!-- contenido del dialogo -->
       </div>
     </div>
     <!--footer -->
     <div class="modal-footer">
       <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cerrar</button>
     </div>
    </div>
  </div>
</div>
```
* Observar el uso de los elementos `<div>`para  armar el header, body y footer de un dialogo. 
* El estilo `modal`se emplea para implementar este componente.
* El estilo `fade`para generar un efecto.
* El estilo `modal-lg`especifica el tamaño del dialogo:  `lg, md, lx, sm`
* La referencia completa de estilos se puede encontrar [aquí](https://www.w3schools.com/bootstrap4/bootstrap_ref_js_modal.asp)
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-06.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-06.html)
### 3.5  Formularios personalizados.
Estas configuraciones permiten visualizar y homologar elementos HTML que sobrescriben los valores predeterminados de los navegadores. Ofrecen mayor consistencia en especial al usar distintos navegadores.
* Checkboxes.  Emplear:
	*  `custom-control, custom-checkbox`  en el elemento `<div>`
	* `custom-control-input`  en el elemento `<input>`
	* `custom-control-label` en el elemento `<label>` 
	* `custom-control-inline` en el elemento `<div>` para mostrar los elementos inline
##### Ejemplo:
```html
<div class="custom-control custom-checkbox custom-control-inline">
  <input type="checkbox" class="custom-control-input" name="1" id="1">
  <label class="custom-control-label" for="1">Uno</label>
</div>
```
* Radio buttons. Emplear: 
	* `custom-control, custom-radio`, en el elemento `<div>` 
	* `custom-control-input`  en el elemento `<input>`
	* `custom-control-label` en el elemento `<label>`
	* `custom-control-inline` en el elemento `<div>` para mostrar los elementos inline
##### Ejemplo:
```html
<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="lunes" name="lunes" class="custom-control-input">
  <label class="custom-control-label" for="lunes">lunes</label>
</div>
```
* Switches. Emplear: 
	* `custom-control, custom-switch`, en el elemento `<div>` 
	* `custom-control-input`  en el elemento `<input>`
	* `custom-control-label` en el elemento `<label>`
	* `custom-control-inline` en el elemento `<div>` para mostrar los elementos inline
##### Ejemplo:
```html
<div class="custom-control custom-switch custom-control-inline">
  <input type="checkbox" class="custom-control-input" id="notificar">
  <label class="custom-control-label" for="notificar">notificar</label>
</div>
```
* Elemento file. Emplear: 
	* `custom-file`, en el elemento `<div>` 
	* `custom-file-input`  en el elemento `<input>`
	* `custom-file-label` en el elemento `<label>`
##### Ejemplo:
```html
<div class="custom-file">
  <input type="file" class="custom-file-input" id="archivo">
  <label class="custom-file-label" for="customFile">Seleccionar archivo</label>
</div>
```
* Elemento Select. Emplear: 
	* `custom-select`, en el elemento `<select>`
##### Ejemplo:
```html
<div class="form-group">
  <label for="carrera">Carrera</label>
  <select class="custom-select" id="carrera" name="carrera">
    <option>Ing. Computaci&oacute;n</option>
    <option>Ing. Electr&oacute;nica</option>
    <option>Otra</option>
  </select>
</div>
```
* El  código completo puede consultarse [aquí.](../ejemplos/modulo03/form-example-07.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo03/form-example-07.html)
