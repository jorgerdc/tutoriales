# Bootstrap
## 5.  Tablas en Bootstrap
### 5.1  Estructura general.
* Para hacer uso de los estilos  que proporciona Bootstrap, la estructura de la tabla de contener los siguientes elementos:
```html
<table class=" table">
  <thead class="thead-dark">
    <tr>
      <th scope="col"> columna 1 </th>
      <th scope="col"> columna 2 </th>
      <th scope="col"> columna 3 </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row"> Celda 1-1</th>
      <td>Celda 1-2</td>
      <td>Celda 1-3</td>
    </tr>
    <tr>
      <th scope="row"> Celda 2-1</th>
      <td>Celda 2-2</td>
      <td>Celda 2-3</td>
    </tr>
  </tbody>
</table>
```
* El ejemplo anterior muestra una tabla con los estilos mínimos, es decir, toda tabla debe contener al menos el estilo `table`
* Notar el uso de los elementos `<th>` y el atributo `scope` empleado para identificar claramente las partes o componentes de la tabla.

### 5.2 Estilos básicos para el elemento `<table>`

Estilo | Descripción
-- | -- |
`.table` | Estilo básico
`.table-striped` | Estilo zebra dentro de `<tbody>`
`.table-bordered` | Borde en todas las celdas
`.table-hover` |  cambia el estilo al pasar el mouse dentro de `<tbody>`
`.table-dark` | Estilo obscuro.
`.table-borderless` | Sin borde
`.table-sm` | Los elementos de la tabla se muestran de forma compacta
`.table-active` `.table-primary` `.table-secondary` `.table-success` `.table-danger` `.table-warning` `.table-info` `.table-light` `.table-dark` | Empleados para personalizar cada renglón o inclusive cada columna. Pueden aplicarse a los elementos `<tr>` o `<td>`
`.bg-primary` `.bg-success` `.bg-warning` `.bg-danger` `.bg-info`  | Se aplican de la misma forma que el grupo anterior

### 5.3 Estilos básicos para el elemento `<thead>`

Estilo | Descripción
-- | -- |
`.thead-light` | Estilo claro
`.thead-dark`| Estilo obscuro
##### Ejemplo.
* El  código completo de los estilos vistos hasta este punto puede consultarse [aquí.](../ejemplos/modulo05/ejemplo-tabla-01.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo05/ejemplo-tabla-01.html)
### 5.4 Estilos para tablas responsivas.
* En una tabla responsiva aparece un scroll horizontal cuando se alcanza al breakpoint configurado.
* `.table-responsive` la tabla se comporta de manera responsiva en todos los breakpoints.
* `table-responsive{-sm|-md|-lg|-xl}` La tabla se comporta de forma responsiva hasta alcanzar el breakpoint configurado. Posterior al breakpoint el scroll horizontal desaparece.
##### Ejemplo:
* Observar que el estilo `table-responsive`  no se especifica en el elemento `<table>`.  Se emplea un elemento que actua como wrapper, típicamente el elemento `<div>`.
```html
<div  class="table-responsive">
  <table  class="table">
  <!-- definición de la tabla -->
  </table>
</div>
```
* Cuando el contenido de alguna de las celdas ya no cabe, aparece el scroll horizontal. 
* Si el contenido es texto, este se ajusta en varios renglones.  Si una sola palabra es demasiado grande para ser mostrada, aparecerá el scroll horizontal.    Considerar el siguiente caso:
```html
<th  scope="col">estaesunacolumnasinespacioslarga</th>
```
*  Con `.table-responsive`  aparecerá el scroll horizontal cuando ya no sea posible mostrar este texto largo.  
* ¿Qué pasaría si se emplea `table-responsive-sm` ?   Para breakpoint mayores, el scroll horizontal no aparecerá aunque la palabra  no pueda visualizarse correctamente, es decir,  aparecería un scroll horizontal pero a nivel de la página, no a nivel de la tabla.  Esto significa que el estilo está mal ajustado.
* El  código completo puede consultarse [aquí.](../ejemplos/modulo05/ejemplo-tabla-02.html)
* El resultado del ejemplo se puede visualizar [aquí.](https://jorgerdc.github.io/tutoriales/bootstrap/ejemplos/modulo05/ejemplo-tabla-02.html)
