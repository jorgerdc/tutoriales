# Bootstrap
## 3. Formularios, diálogos modales.
* El código de los ejemplos de este módulo se encuentran en GitHub, en la carpeta `ejemplos/modulo03`
* Bootstrap soporta 2 formas distintas de organizar elementos de un formulario:
	* Stacked (full-width) form
	* Inline form
* En general, los formularios deben estar dentro de un container.
### 3.1 Stacked form
* Por default, Bootstrap aplica los siguientes estilos a la mayoría de los elementos de un formulario: `display: block` y `width: 100%`
* Lo anterior significa que  cada elemento se mostrará en  un renglón alineados verticalmente.
#### 3.1.1 Grupos de elementos.
* Para proporcionar una estructura adecuada, un formulario puede estar compuesto por grupos.  En general, cada grupo  puede contener los siguientes integrantes:
	* Elemento del formulario: `<input>`, etc.
	* Etiqueta del elemento html: `<label>`, etc.
	* Elemento para mostrar algún mensaje de validación. Por ejemplo, empleando el elemento `<span>`.
* Bootstrap emplea el estilo `form-group`
##### Ejemplo: [form-example-01.html](../ejemplos/modulo3/form-example-01.html)
```html
<!-- group 1-->
<div class="form-group">
  <label for="nombre">Nombre: *</label>
  <input type="text" name="nombre" id="nombre" class="form-control" 
    placeholder="Nombre del usuario">
</div>
<!-- group 2 -->
<div>
  <label for="password">Contrase&ntilde;a: *</label>
  <input type="password" name="password" id="password" class="form-control" 
      placeholder="Contrase&ntilde;a">
  <small class="form-text text-muted">Escribir al menos 8 caracteres</small>
</div>
```
* Notar que los elementos del formulario contienen el estilo `form-control`
* Adicional al estilo `form-control`existen las variantes `.form-control-lg` y `.form-control-sm` para modificar el tamaño de los elementos
### 3.2 Inline form
* el tag `<form>` debe contener el estilo `form-inline`
* La apariencia del formulario puede ser mejorado con las utilerías de espaciado de Bootstrap. 
* Por ejemplo, `mr-sm-2` agrega un margen a la derecha del elemento (`mr`) de tamaño pequeño (`sm`).   El estilo `sb-2` agrega un margen abajo de elemento para los casos en los que los elementos se muestran verticalmente para pantallas pequeñas.
##### Ejemplo:  [form-example02.html](../ejemplos/modulo3/form-example-02.html)
```html
<form action="" class="form-inline">
  <label for="nombre" class="mr-sm-2">Nombre *</label>
  <input type="text" name="nombre" class="form-control mb-2 mr-sm-2">        
  <label for="descripcion" class="mr-sm-2">Descripcion *</label>
  <textarea name="descripcion" class="form-control mb-2 mr-sm-2"></textarea>        
  <button type="sumbmit" class="btn btn-primary">Siguiente</button>
 </form>  
```
### 3.3 Formularios responsivos empleando Grid System.
* El uso de Grid System permite construir formularios complejos de múltiples columnas y tamaños  diferentes.
* Se hace uso de los estilos del Grid System
* Para habilitar el uso de Grid system, el formulario debe tener wrapper con:
	*  `<div class row>...</div>`
	* `<div class form-row>...</div>`  Sobrescribe a los valores por default de Grid System, proporcionando valores más compactos, adecuados para formularios.
##### Ejemplo: [form-example-03.html](../ejemplos/modulo3/form-example-03.html)
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
* Los siguientes ejemplos corresponden a un formulario para capturar los  datos generales de un curso.  El formulario completo se encuentra en [form-example-04.html](../ejemplos/modulo3/form-example-04html)
##### Ejemplo: 
```html
<div class="form-row">
  <div class="form-group col-md-9">
    <label for="nombre">Nombre: *</label>
    <input type="text" class="form-control" name="nombre" id="nombre"
      placeholder="Nombre o t&iacute;tulo del curso">
  </div>
  <div class="form-group col-md-3">
    <label for="totalHoras">Total de horas: *</label>
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
      <label>Modalidad del curso: *</label>
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
    <label for="status">Status del curso: *</label>
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
<div class="form-group form-row">
  <div class="offset-sm-5 col-sm-6">
    <input class="btn btn-primary" type="reset" value="Limpiar">
    <button type="submit" class="btn btn-primary">Siguiente</button>  
  </div>
</div>
```
* En este ejemplo, se muestran 2 botones centrados  al final del formulario.
* Notar el uso del estilo `offset-sm-5` empleado para saltar posiciones hacia la derecha.  Esto permite posicionar los  botones al centro de la pantalla.
*  El siguiente ejemplo se muestra otra manera de agrupar los elementos del formularios.  En lugar de agrupar la etiqueta  de cada elemento del formulario,  esta se incluye en una celda separada. Esto provoca que la etiqueta quede del lado izquierdo de la pantalla.  Ver: [form-example-05.html](../ejemplos/modulo3/form-example-05html)
### 3.4 Dialogos modales.
* El siguiente ejemplo muestra los estilos necesarios a configurar para crear diálogos modales en Bootstrap.
##### Ejemplo: [form-example-06.html](../ejemplos/modulo3/form-example-06html)
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
