# TypeScript

## Contenido módulo 1

1. [Introducción a TypeScript](#introducción-a-typescript)
    1. [¿Qué es TypeScript?](#qué-es-typescript)
    2. [Instalación y preparación de nuestro entorno de desarrollo](#instalación-y-preparación-de-nuestro-entorno-de-desarrollo)
        1. Instalación de npm en MacOS y Windows
        2. Instalación de npm en Linux
        3. tsconfig.json
        4. tslint
    3. [Sintaxis básico](#sintaxis-básico)
    4. [Tipos](#tipos)
        1. Boolean
        2. Number
        3. String
        4. Array
        5. Tuple
        6. Enum
        7. Date
        8. Object
        9. Any
        10. Void
        11. Null/Undefined
        12. Unknown
    5. [Afirmación (Assertions)](#afirmación-assertions)
    6. [Variables](#variables)
        1. Scope
        2. Funciones anónimas ES6
    7. [Utilidades (Number, String, Array)](#utilidades-number-string-array)
        1. Number
        2. String
        3. Array
    8. [Enumeraciones](#enumeraciones)
    9. [Tupla vs Array](#tupla-vs-array)
    10. [Interfaces y tipos](#interfaces-y-tipos)
    11. [Unión e intersección](#unión-e-intersección)
        1. Unión
        2. Intersección
    12. [Clases](#clases)
        1. Herencia
        2. Modificadores de acceso
    13. [Namespaces](#namespaces)

# Introducción a TypeScript

## ¿Qué es TypeScript?

TypeScript es un super-conjunto de JavaScript, esto quiere decir que TS abarca todo el contenido de JS y le añade funcionalidad que JS no
incluye, principalmente agrega el uso de tipos, aunque el atractivo más grande de TS es la implementación completa de la POO con clases,
interfaces, etc. Si llegamos a experimentar con JavaScript, es realmente sencillo hacer malas prácticas, tanto por código como en lógica.
Esto frecuentemente sucede porque no se cuenta con un compilador como tal, JS es un lenguaje de programación interpretado. 

Antes de entrar un poco en TS, hablemos un poco de EcmaScript, ES es el estándar que proporciona las reglas, detalles y pautas para JS, ha
habido constantes actualizaciones para ES, esto quiere decir, actualizaciones para JS. La versión `ES5` o `ES 2009`, es la que funciona con
la mayoría de los navegadores en el mercado, sin embargo, tenemos muchas actualizaciones con nuevas utilidades como las lambdas, clases,
herencia, etc. que no se incluyen en `ES5`, TypeScript nos permite utilizarlas al indicarle a que versión de `ES` queremos compilar nuestro
proyecto.

JS utiliza tipos de variables primitivas como cadena, número y objeto. Nunca le importa si en toda tu aplicación utilizas una sola variable
y la reestructuras en tiempo de ejecución, a TS si le importa y proporciona una extensa gama de tipados e interfaces como veremos a
continuación.\
Es importante recalcar que **el navegador no comprende TS**, **Nuestro código TS necesita ser compilado a JS**.

A continuación haremos unos ejemplos curiosos

```javascript
  console.log(new Array() == false) // outputs true
  console.log([] == false) // outputs true
  console.log('' == false) // outputs true
  var a = 2;
  a = 'hello';
  a = false;
  a = { color: 'red' };
  a = new Array();
```

ahora veremos la salida de TypeScript

```typescript
  console.log(new Array() == false) // error, does not compile, outputs: "the types have no overlap"
  console.log([] == false) // v: "the types have no overlap"
  console.log('' == false) // v: "the types have no overlap"
  var a = 2; // warning 'var' depecated, use instead of 'let' or 'const' 
  a = 'hello'; // error, outputs: "Type '"hello"' is not assignable to type 'number'."
  a = false; // error, outputs: "Type 'false' is not assignable to type 'number'."
  a = { color: 'red' }; // error, outputs: "Type '{ color: string; }' is not assignable to type 'number'."
  a = new Array(); // error, outputs: "Type 'any[]' is not assignable to type 'number'."
```

![TypeScript](https://www.filepicker.io/api/file/19uUx4kDS7ecP6YDadXg)

## Instalación y preparación de nuestro entorno de desarrollo

Estaremos trabajando desde consola y un editor, por lo que previamente necesitamos instalar NodeJS para poder hacer uso de su gestor de
paquetes npm e instalar el compilador de TypeScript (tsc por sus siglas en inglés).

#### Instalación de npm en MacOS y Windows

Simplemente ingresamos al [sitio oficial de node](https://nodejs.org/) y bajamos el instalador para nuestro sistema operativo, posterior a
la instalación, abrimos un cmd/powershell o una terminal y ejecutamos los comandos `node -v` y `npm -v`. Para efectos de este curso, se
usará la versión 12.x.x de node.

```console
> node -v
v12.18.3
> npm -v
6.14.8
```

#### Instalación de npm en Linux

Para instalar node desde alguna distro basada en debian hay que agregar el setup para la versión que queremos utilizar.

```console
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash –
sudo apt-get install nodejs
node -v
npm -v
```

Una vez instalado node, procedemos a agregar tsc a nuestro npm global, esto nos permitirá usar el CLI para compilar nuestro código fuente de
.ts a .js, **si estamos trabajando en windows no es necesario usar sudo**.

```console
sudo npm install -g typescript
tsc -v
```

Podemos ejecutar un fragmento del código JS sin la necesidad de importarlo en un navegador (siempre y cuando no trabajemos con el DOM)
con el compilador de node haciendo uso del comando `node mi-archivo.js`.

#### tsconfig.json

Debemos generar este archivo de forma manual, es el archivo que contiene todas las configuraciones que tomará el compilador de TS, contiene
opciones como para saber en que versión de JS debe generar el código, si debe excluir alguna capeta, etc.

En el archivo de [ejemplo para el módulo 1](../ejemplos/modulo01/tsconfig.json) se incluye un ejemplo básico de cómo configurar un archivo,
para la documentación de que hace cada parámetro y que valores puede tener, visitar la [documentación oficial](https://www.typescriptlang.org/tsconfig).

#### tslint

Para mantener nuestro código escalable, aun cuando estemos trabajando en un equipo de desarrollo donde cada quién mantiene su estilo de
programación, existe una herramienta que se llama "linter", esta herramienta nos permite agregar reglas para el estilo de código y la
reconocen todos los editores e IDEs modernos, podemos decir que no se permite la identación por tabulaciones, queremos específicamente que
sea identación a 2 espacios y si alguien intenta crear un archivo con diferente identación, se marcará un error. Es importante mencionar que
**las reglas en el linter no afectan la lógica o la ejecución de nuestro programa, solo afecta el estilo de código**.

Para usar el liter para typescript ([tslint](https://github.com/buzinas/tslint-eslint-rules)) haremos lo siguiente:
- Debemos verificar si nuestro proyecto es un proyecto de npm: debe existir un archivo llamado `package.json`, los frameworks como angular,
react o vue cuando son creados mediante npm, ya inicializan nuestro proyecto con npm.
- En caso que no exista, debemos crear nuestro package.json, aunque como ya instalamos `npm` en nuestro sistema, podemos inicializarlo desde
la línea de comandos con `npm init`.
- Debemos instalar en las dependencias de desarrollo el paquete para tslint y typescript.

```console
npm init 
npm install --save-dev tslint typescript
```

Al verificar nuestro `package.json`, debe estar la siguiente información:

```json
{
  "devDependencies": {
    "tslint": "^6.1.3",
    "typescript": "^4.0.2"
  }
}
```

En el archivo de [ejemplo para el módulo 1](../ejemplos/modulo01/tslint.json) se incluye un ejemplo básico de reglas comúnmente estandarizadas.

## Sintaxis básico

Veamos un ejemplo de una suma en JavaScript con un error intencional, sin embargo, JavaScript nunca lo detecta.

```javascript
function sum(...params) {
  let res = 0;
  for (const num of params) {
    res += num;
  }
  return res;
}

const a = 4;
const b = { prueba: 'hola' };
const c = '5';
const d = null;
const e = [1, 2, 3];
const total = sum(a, b, c, d, e);
console.log('Resultado:', total);
```

Dado que el archivo js anterior no utiliza el DOM, se puede probar mediante node, ejecutando `node 01-sintaxis-basico.js`.

Si observamos el output de consola, podremos visualizar que el output es: el resultado es `Resultado: 4[object Object]5null1,2,3`, esto es
porque el operador `+` de JS funciona tanto para concatenar como para sumar, al tener valores no-numéricos esta concatenando la
interpretación en string que JS tiene de cada valor. La falta de tipado, nos permite darle por parámetro a la función `sum` el valor que
sea e increíblemente, funciona.\
Si generamos un archivo typescript ([03-sintaxis-basico.ts](../ejemplos/modulo01/03-sintaxis-basico.ts)) con exactamente el mismo código,
agregando tipos e intentamos ejecutar el compilador usando `tsc` en la raiz de nuestra carpeta `modulo01`, la salida será un error similar a:

```typescript
function sum(...params: number[]): number {
  let res = 0;
  for (const num of params) {
    res += num;
  }
  return res;
}

const a = 4;
const b = { prueba: 'hola' };
const c = '5';
const d = null;
const e = [1, 2, 3];
const total = sum(a, b, c, d, e);
console.log('Resultado:', total);
```

```console
03-sintaxis-basico.ts:14:22 - error TS2345: Argument of type '{ prueba: string; }' is not assignable to parameter of type 'number'.

14 const total = sum(a, b, c, d, e);
                        ~


Found 1 error.
```

Lo cual nos indica que la función "sum" solo acepta por parámetro a números y nos retornará un número, sin embargo, estamos intentando
llamarla con parámetros número, objeto, string, null y arreglo de números, por lo que nos marcará error al compilar y no generará ningún
archivo ".js", si corregimos el código y pasamos valores válidos y volvemos a ejecutar el comando `tsc`, no habrá salida en consola y se
generará el archivo ".js" en una carpeta de salida, denominada `dist`.

## Tipos

En esta sección hablaremos un poco acerca de los tipos de las variables en TS, algo importante de mencionar es que hay tipos de variable
inferidos, es decir, si declaramos una variable con un valor inicial, no es necesario indicar de que tipo se trata, dado que el tipo se toma
en cuenta por el valor que estemos asignando, por ejemplo:

```typescript
const a: number = 4;
```

TSLint arrojará un error que menciona "**Type number trivially inferred from a number literal, remove type annotation(no-inferrable-types)**"
que menciona que el tipo "number" se infiere del valor asignado, es decir, del 4 que le estamos asignando a la variable "a", lo correcto,
sería alguna de las siguientes opciones:

```typescript
const a = 4;
let b: number;
b = 4;
```

tanto `a` como `b` son reconocidos en TS como `number`.

Aquí se enlistan y ejemplifican algunos tipos básicos de TS

##### Boolean

El tipo más básico de dato, simplemente toma el valor de verdadero o falso.

```typescript
let isDone: boolean;
```

##### Number

Este tipo incluye a todos los números, sean de punto flotante, enteros o algún tipo de número en diferentes bases se pueden asignar sin
problema.

```typescript
let numero: number;
numero = 6;
numero = 0xf00d; // hex
numero = 0b1010; // binary
numero = 0o744;  // octal
```
##### String

Este tipo se traduce como cadena de caracteres, es el tipo más común en TS y JS, no hay diferencia entre char y string, para JS ambos tipos
son iguales, se puede usar doble o simple comilla (aunque para el lint estándar debe ser comilla simple).

```typescript
let color: string;
color = "blue";
color = 'red';
```

Hay una forma muy interesante de "insertar" variables en una cadena y estas se llaman *"template strings"*, se utiliza el caracter \` para
delimitar la cadena y se puede insertar código JS con la siguiente forma `${ <código JS> }` y también reconoce los saltos de linea.

```typescript
const nombre = `Victor Servin`;
const edad = 37;
const mensaje = `Hola, mi nombre es ${nombre},

Tendré ${ edad + 1 } años el siguiente mes!`;
console.log(mensaje);
```

Lo equivalente con concatenación sería:

```typescript
const nombre = `Victor Servin`;
const edad = 37;
const mensaje = "Hola, mi nombre es " + nombre + ",\n\n" + "Tendré " + (edad + 1) + " años el siguiente mes!";
console.log(mensaje);
```

Pero typescript considera usar la concatenación una mala práctica, siempre se debe priorizar el uso de template strings.

##### [Array](#tupla-vs-array)

##### [Tuple](#tupla-vs-array)

##### [Enum](#enumeraciones)

##### Date

Date es un tipo de objeto preexistente en javascript que hace referencia a un objeto de tipo "Date", este objeto ya existe en JS y TS, que
funciona para hacer manipulación y lógica de fechas al invocar `new Date()` obtenemos una instancia con la fecha actual de nuestro sistema.

##### Object

Object es un tipo primitivo que hace referencia a un objeto llave-valor, es diferente a cualquiera de los tipos antes mencionados.

```typescript
function mostrar(o: object) {
  console.log(o);
}
mostrar({ color: 'rojo' }); // Válido
mostrar({ color: 'rojo', nombre: 'teclado' }); // Válido
mostrar(null); // Argument of type 'null' is not assignable to parameter of type 'object'.
mostrar('string'); // Argument of type '"string"' is not assignable to parameter of type 'object'.
mostrar(100); // Argument of type '100' is not assignable to parameter of type 'object'.
mostrar(false); // Argument of type 'false' is not assignable to parameter of type 'object'.
```

##### Any

Any es un tipo de valor que no recomiendo usar **nunca**, sin embargo, tiene sus aplicaciones en algunos escenarios particulares, básicamente
sirve para decir que un tipo de retorno o variable puede tomar cualquier valor y ninguna operación con esa variable o retorno generará error
en nuestro compilador.

```typescript
const sinTipo: any = 5;
sinTipo.unMetodoQueNoExiste(); // un método que nunca se declaró, pero TS no se molesta en verificar
const errorPorqueNoEsCadena = sinTipo.length; // length es una propiedad de una cadena
const asignacionQueProbablementeMateTodo: Date = sinTipo.toFixed(); // toFixed es un método para números
```

Sin embargo `any` sirve mucho, por ejemplo, hay muchos paquetes en npm destinadas a node con JS y no con TS, esto quiere decir que nunca
fueron tipadas sus herramientas, por lo que si intentamos hacer un método de este tipo de usos, se generaría un error en TS. Un ejemplo
podría ser una librería que no requiere introducción.

```typescript
$( 'li.item-ii' ).find( 'li' ).css( 'background-color', 'red' ); //  Cannot find name '$' Property 'find' does not exist on type 'object'.
```

Y para solucionar esta situación, simplemente necesitamos un `declare var $: any;` (siempre y cuando estemos importando en nuestro DOM JQuery)

##### Void

Es un tipo muy reconocido para los que empezamos a trabajar en C, representa literalmente el vacío o la ausencia de datos en general, se usa
comúnmente para indicar funciones que no retornan un valor.

```typescript
function mandarAviso(mensaje: string): void {
  console.log(mensaje);
}
```

##### Null/Undefined

Es un poco complicado pero ayuda un poco en algunos escenarios de nuestra aplicación el tener estos 2 valores, existen 2 valores que en otros
lenguajes es lo mismo, nulo e indefinido. Null hace referencia a algo inexistente, lo podemos retornar o asignar a alguna variable, lo mismo
sucede con undefined, sin embargo, ¿Cuál es la diferencia? En la práctica yo siempre trabajo con null, aunque en ocasiones undefined es
común de encontrarse, y ayuda un poco a depurar errores el no trabajar con undefined.
Tal vez sea más fácil un ejemplo visual.

```typescript
let numeroQueYaNoMeSirve: any;
let pruebaDeAlgo: any;
if (pruebaDeAlgo) {
  numeroQueYaNoMeSirve = 10;
}
console.log(numeroQueYaNoMeSirve.toString()); // Válido, sin embargo, numeroQueYaNoMeSirve es posiblemente undefined
```

En el ejemplo anterior, en ningún momento digo que la variable es undefined, sin embargo, toma ese valor porque no esta definida, si en algún
momento llegamos a tener un error que diga algo similar a `is undefined` probablemente es porque nos falta inicializar algo en nuestro
programa.

##### Unknown

Unknown o desconocido se utiliza cuando desconocemos el tipo de retorno de una función o no sabemos si una variable podrá tomar valor de
número, string, etc. en algún momento posterior a su declaración. Este tipo llega a usarse cuando hacemos una petición a una API y no
estamos completamente seguros del retorno o el retorno es variable. Para solventar esto se utilizan  en conjunto con los Assertions.

```typescript
let maybe: unknown;
const aNumber: number = maybe; // Type 'unknown' is not assignable to type 'number'.

if (maybe === true) {
  // TypeScript knows that maybe is a boolean now
  const aBoolean: boolean = maybe; // TS sabe que si entra al bloque del if solo es posible que sea un booleano
  const aString: string = maybe; // Type 'boolean' is not assignable to type 'string'.
}

if (typeof maybe === "string") {
  const aString: string = maybe; // sabe que "maybe" es una cadena
  const aBoolean: boolean = maybe; // Type 'string' is not assignable to type 'boolean'.
}
```

## Afirmación (Assertions)

Puede existir alguna situación donde sepamos "más" que el compilador en la ejecución de nuestro proyecto dónde sea necesario "forzar" el
tipo de una variable o retorno de una función, hagamos un ejemplo.\
Tengo una función que hice en JS, que le paso una cantidad en número de días y esta función, me regresa el objeto (Date) actual con el
número de días sumado, pero existe la posibilidad que lo retorne como cadena formateada o como instancia de `Date` por ejemplo:

```javascript
function traeFecha(dias, esCadena) {
  const hoy = new Date();
  hoy.setHours(hoy.getHours() + dias * 24);
  if (esCadena) {
    return hoy.toLocaleString();
  }
  return hoy;
}
// ...
console.log(traeFecha(7)); // Instancia de objeto Date
console.log(traeFecha(7, true)); // String formateada en [d/m/yyyy, h:mm:ss aa]
```

Nosotros sabemos que si pasamos un solo parametro, nos retornará siempre una instancia de Date, por lo que podemos hacer operaciones
correspondientes a esa instancia, y sabemos que si pasamos 2 parámetros, siempre será una string, por lo que podemos hacer operaciones a esa
string, por ejemplo:

```javascript
traeFecha(7).toUTCString(); // Paso la instancia de date a tiempo UTC
traeFecha(7, true).split(', ') // Divido la fecha y hora en array
```

Si pasamos el código anterior a TypeScript, haremos algo similar a

```typescript
function traeFecha(dias: number, esCadena = false) {
  const hoy = new Date();
  const horasEnUnDia = 24;
  hoy.setHours(hoy.getHours() + dias * horasEnUnDia);
  if (esCadena) {
    return hoy.toLocaleString();
  }
  return hoy;
}
// ...
traeFecha(5).toUTCString(); // Property 'toUTCString' does not exist on type 'string'
traeFecha(5, true).split(', '); // Property 'split' does not exist on type 'Date'
```

Los errores que nos indica el compilador de typescript es que no tiene muy claro el tipo de salida de nuestra función, si es Date o si es
string, entonces arroja errores al intentar usar métodos que solo existen en una de las 2 posibilidades de salida. Esta es una situación
donde sabemos más que el compilador y podemos forzar el tipo de retorno del método `traeFecha` de la siguiente forma:

```typescript
(traeFecha(5) as Date).toUTCString(); // Válido
(<string>traeFecha(5, true)).split(', '); // Válido
```

El uso de los pico-paréntesis o el `as` tiene la misma función, aunque el `as` es el estándar para los assertions.

**Pero ojo!** Estamos haciendo una especie de invalidación al tipo de la variable, así que permitiría el compilador pasar un error que JS
permite y TS no debería, por ejemplo:

```typescript
const numero = 5;
(numero as Date).toLocaleString(); // Válido
```

Lo anterior pasaría la compilación pero generaría un error en tiempo de ejecución, si nos vemos en la necesidad de usar assertions, ser en
extremo cuidadosos.

## Variables

En esta sección no hablaremos del scope que no es algo particular de TS, también de JS, además de la forma de declarar variables en TS.\
Las siguientes formas de declarar una variable, todas son válidas para TS, aunque no todas para un linter.

```typescript
var variable1: unknown = 'string'; // <scope | reasignacion> <nombre de la variable>: <tipo> = <valor asignado>;
let variable2: unknown; // <scope | reasignacion> <nombre de la variable>: <tipo>;
const variable3 = 'string'; // <scope | reasignacion> <nombre de la variable> = <valor asignado>;
var variable4; // <scope | reasignacion>;
```

La `variable1` tiene un tipo unknown y tiene valor inicial `'string'`, la `variable2` tiene de tipo unknown y valor inicial `undefined`,
la `variable3` tiene un valor `'string'` y un tipo inferido de `string`, la variable 4 tiene tipo `any` y valor inicial `undefined`.

#### Scope

El estándar `ES 2015` o `ES6` trajo cambios muy relevantes a JS, el más importante el uso de scopes, introdujo 2 tipos de variable más
(`let` y `const`), cuando antes solo existía 1 (`var`).

Existen 2 tipos de scopes
- Scope global (var)
- Scope de bloque (let y const)

Existen 2 tipos de mutabilidad
- Variable inmutable (const)
- Variable mutable (var y let)

La mutabilidad es en pocas palabras si puede o no cambiar de valor **dentro de su bloque**, la const o constante nunca cambiará de valor,
mientras que las mutables pueden cambiar infinitas veces durante la ejecución de nuestro programa.

El scope es el alcance de una variable, es decir, que tanto puede acceder dentro de nuestro programa. Hagamos el ejemplo

```typescript
const valor = 10;
function unaFuncion() {
  let valor = 20;
  if (!isNaN(valor)) {
    const valor = 30;
    console.log(valor);
  }
  valor += 5;
  console.log(valor);
}
unaFuncion();
console.log(valor);
```

Estoy haciendo uso de 3 variables en 3 diferentes "bloques" y 2 diferentes scopes, el primer scope es el llamado "global", su scope es el
ámbito global de código, el siguiente es un scope de función, las funciones tienen su propio scope y podemos hacer referencia a él,
utilizando la palabra reservada `this`, sin embargo, tenemos 3 bloques, los 2 que mencionamos anteriormente (cada scope es un bloque)
y el último es el scope de un if. Si, cualquier cosa que se envuelva entre llaves se considera un bloque, la salida del código anterior es
`30 25 10`, la variable `let` y `const` existe dentro de su bloque y al ver los logs, podemos ver su independencia.

Si tuviéramos un código usando únicamente `var`, se estaría reescribiendo el valor de la variable `valor`, aun cuando volvamos a usar la
palabra reservada `var`, se reescribe el valor de la variable.

```typescript
var valor = 10;
function unaFuncion() {
  var valor = 20;
  if (!isNaN(valor)) {
    var valor = 30;
    console.log(valor);
  }
  valor += 5;
  console.log(valor);
}
unaFuncion();
console.log(valor);
```

La salida del código anterior es `30 35 10`, llama la función y declara variables, manda un log dentro del if (que en el caso del ejemplo es
true) que da 30, pero al salir del if, le aumenta 5 y le hace otro log, sin embargo el último valor que había tomado es 30, dado que la
variable de tipo `var` no existe en un bloque, existe en un scope y a pesar de "re-declararla" usando `var`, se reemplaza el valor de 20,
haciendo que el output al sumar 5 sea 35.\
TS nos permite usar sin problema var, es una funcionalidad de JS, sin embargo, el linter nos mostrará un error: *Forbidden 'var' keyword,
use 'let' or 'const' instead(no-var-keyword)*.

#### Funciones anónimas ES6

Dentro de JS y TS tenemos algo que se llaman funciones anónimas o función sin nombre y no se usan mucho en sintaxis de ES5, sin embargo,
cuando se introdujo los cambios de ES6 con los scopes, también trajo cambios a las funciones anónimas con la posibilidad de hacer funciones
anónimas de tipo flecha o "arrow functions". Como vimos en el ejemplo de los scopes, las funciones crean sus propios scopes, sin embargo,
una función anónima no y la sintaxis es la misma que una lambda. 

```javascript
// ES5
var x = function(x, y) {
   return x * y;
}

// ES6
const x = (x, y) => x * y;
const x = (x, y) => { return x * y };
```

Las "arrow functions" no tienen su propio `this` o scope, por lo que también debe ser definida antes de ser usada, al igual que una variable,
en la declaración siempre es recomendable usar `const`, dado que su definición no cambia. Se puede omitir el return únicamente si no se
utilizan llaves y se tiene una sola operación.

Las arrow functions son de extrema utilidad cuando se están utilizando callbacks, promesas o en librerías avanzadas como RxJS.

Un ejemplo es para buscar un usuario con cierto ID:

```typescript
const usuarios: { id: string, nombre: string }[] = [
  { id: '1', nombre: 'Vic' },
  { id: '2', nombre: 'Sam' },
  { id: '3', nombre: 'Jorge' }
];
const usuario = usuarios.find(u => u.id === '2'); // Sam
const usuarioInexistente = usuarios.find(u => u.id === '5'); // undefined
```

También podemos añadirle tipeo a las funciones utilizando una arrow function como tipeo y funciona tanto para funciones nombradas y anónimas.

```typescript
const miSuma: (valorBase: number, incremento: number) => number = (x, y) => {
  return x + y;
};
const miResta: (valorBase: number, decremento: number) => number = function (x, y) {
  return x + y;
};
console.log(miSuma(2, 5));
console.log(miResta(5, 3));
```

Y agregarles parámetros opcionales o con valores por "default"

```typescript
const construyeNombre = (nombre: string, apellido?: string): string => apellido ? `${nombre} ${apellido}` : nombre; // apellido opcional
const construyeNombreFormal = (nombre:string, apellido: string, prefijo = '"Sr.'): string => `${prefijo} ${nombre} ${apellido}`; // default
console.log(construyeNombre('Victor')); // Victor
console.log(construyeNombre('Victor', 'Servin')); // Victor Servin
console.log(construyeNombreFormal('Victor', 'Servin')); // Sr. Victor Servin
console.log(construyeNombreFormal('Victor', 'Servin', 'Ing.')); // Ing. Victor Servin
```

## Utilidades (Number, String, Array)

Existen algunas utilidades con los objetos globales en TS y JS que nos permiten manejar mejor las situaciones que se nos presentan día a día

#### Number

Se puede usar su constructor para validar un valor `const valor = new Number(123)`, en caso de pasar un valor no-numérico como argumento,
el resultado siempre será un número particular llamado NaN (Not-a-Number), pero si, su tipo de variable es número, para validar si un número
es válido podemos utilizar la función `isNaN('Hola')` que retornará un `boolean`.

- `Number.MAX_VALUE` el valor máximo posible en JS.
- `Number.MIN_VALUE` el valor mínimo posible en JS.
- `Number.NaN` siempre retorna el valor NaN.
- `Number.NEGATIVE_INFINITY` el valor menor que MIN_VALUE, considerado como infinito negativo.
- `Number.POSITIVE_INFINITY` el valor mayor que MAX_VALUE, considerado como infinito positivo.

#### String

Existen muchos métodos de utilidad para las cadenas, entre ellos se encuentran:

- `charAt(pos: number): string` regresa el caracter en el índice especificado.
- `charCodeAt(index: number): number` regresa el valor unicode del caracter en el índice especificado.
- `concat(...strings: string[]): string` combina el texto de las cadenas pasadas como parámetro con la cadena original.
- `indexOf(searchString: string, position?: number): number;` Retorna el índice de la primer coincidencia de una búsqueda de una cadena en
otra, podemos indicar a partir de que índice empezar a buscar.
- `lastIndexOf(searchString: string, position?: number): number;` Retorna el índice de la última coincidencia de una búsqueda de una cadena
en otra, podemos indicar a partir de que índice empezar a buscar.
- `localeCompare(that: string): number;` Compara si 2 cadenas son iguales en el locale de trabajo, locale hace referencia a algún idioma
con caracteres especiales.
- `match(regexp: string | RegExp): RegExpMatchArray | null;` Retorna si hay alguna o varias coincidencias con una expresión regular.
- `replace(searchValue: string | RegExp, replaceValue: string): string;` Busca y reemplaza alguna búsqueda de cadena o expresión regular en
la cadena actual.
- `split(separator: string | RegExp, limit?: number): string[];` Dividimos una cadena en arreglo de cadena a partir de un separador, podemos
limitar la cantidad de divisiones generadas.
- `substring(start: number, end?: number): string;`  Regresa una sección de la cadena actual sin hacer mutación.
- `toLowerCase(): string;` Transforma la cadena a minúsculas.
- `toLocaleLowerCase(locales?: string | string[]): string;` Transforma la cadena a minúsculas tomando en cuenta caracteres especiales como la ñ.
- `toUpperCase(): string;` Transforma la cadena a mayúsculas.
- `toLocaleUpperCase(locales?: string | string[]): string;`Transforma la cadena a mayúsculas tomando en cuenta caracteres especiales como la ñ.
- `trim(): string;` Quita los saltos de línea o espacios al principio y final de la cadena.

#### Array

Principalmente hay utilidades del Array que podamos tomar buen provecho, como podemos inicializar un arreglo con casillas vacías, pero con
cierto número específico de casillas haciendo uso de su constructor `const arr: any[] = new Array(5)`, ésto creará un arreglo con 5 casillas
vacías. Los arrays tienen muchos métodos que podemos utilizar en práctica, los más comunes son:

- `pop()` Retorna el valor que estaba en la última casilla del array y la elimina del array original.
- `push(v)` Agrega al final del array un valor ingresado, retorna void.
- `shift()` Retorna el valor que estaba en la primer casilla del array y la elimina del array original.
- `unshift(v)` Agrega al principio del array un valor ingresado, retorna void.
- `every(callbackfn: (value: T, index: number) => unknown, thisArg?: any): boolean;` Verifica que todos los valores del array cumplan lo que
especifique un callback.
- `some(callbackfn: (value: T, index: number) => unknown, thisArg?: any): boolean;` Verifica que al menos uno de los valores del array
cumplan lo que especifique un callback.
- `forEach(callbackfn: (value: T, index: number) => void, thisArg?: any): void;` Hace un recorrido en cada uno de los valores del array a
forma de callback.
- `join(separator?: string): string;` Mediante un separador, une cada uno de los valores del array y retorna la unión como cadena.

Hay una cantidad gigante de métodos para arreglos y probablemente tardemos mucho en explicar todos y cada uno de ellos, lo mejor es
usarlos en la práctica usando alguna documentación, en mi caso me gusta la documentación de
[Mozilla](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array).

## Enumeraciones

TS agrega un tipo de dato llamado enumeración o `enum`, es un tipo muy común en lenguajes como C# o Java, en palabras muy simples, permite
usar valores más comprensibles al programador a valores que solo utilizan números.

```typescript
enum Color {
  Red,
  Green,
  Blue,
}
let c: Color = Color.Green;
```

De forma predeterminada, las enumeraciones empiezan con 0, pero podemos indicarle el inicio de su secuencia igualando su primer valor a un
número o igualando valores predeterminados.

```typescript
enum Color {
  Red = 1,
  Green = 2,
  Blue = 4,
}
let c: Color = Color.Green;
```

## Tupla vs Array

Un arreglo en TS siempre debe ser un arreglo de determinado tipo, ese tipo puede ser simple o complejo (los complejos los veremos en la
sección de interfaces y tipos), pero una tupla o `tuple` permite expresar un arreglo con un número fijo de casillas (length) pero con
elementos no necesariamente iguales, por ejemplo, queremos representar un punto en un mapa y ese punto se caracteriza por tener latitud,
longitud y un nombre (number, number, string), una solución podría ser tener una tupla.

```typescript
// Declaramos una tupla de longitud 3 donde siempre su primer y segundo valor son number y su tercer valor siempre es string
let x: [number, number, string];
x = [10, -20, 'Mi casa']; // OK
x = [10, 'Casa del profe']; // Error
```

Y podemos combinar una tupla con un arreglo, tomando el ejemplo anterior, si tengo un arreglo de puntos con esa estructura y posteriormente
lo itero, se reconoce el tipo de los puntos.

```typescript
const puntos: [number, number, string][] = [
  [1, 2, 'prueba 1'],
  [2, 3, 'prueba 2'],
  [3, 4, 'prueba 3'],
  [4, 5, 'prueba 4']
];

puntos.forEach((p) => {
  p[2].concat(p[0], p[1]); // Argument of type 'number' is not assignable to parameter of type 'string'.
});
```

## Interfaces y tipos

Aquí vamos a entrar un poco en conflicto con la POO, en POO las interfaces se definen como clases o métodos abstractos que definen contratos
de interacción entre objetos y solo le importa el comportamiento de los objetos, no puedes declarar una propiedad en una interfaz (o no
debería).\
Esto se ilustra en la siguiente imagen:\
![Interface](https://www3.ntu.edu.sg/home/ehchua/programming/java/images/OOP_InterfaceShape.png)

Sin embargo, en TS si podemos definir una estructura de un objeto, no solamente del comportamiento de una clase. Esto se llama ocasionalmente
como "duck typing" o "structural subtyping".

También podemos auxiliarnos de declarar nuestro propios "types", indicando una interfaz pero destinado a un tipo y no a un objeto. Esto se
ilustra a continuación

```typescript
interface Usuario {
  nombre: string;
  apellido: string;
  readonly edad: number;
  profesion?: string;
}
type FuncionNumeros = (...numeros: number[]) => number;
interface Auto {
  color: string;
  marca: string;
  [propiedad: string]: any;
}
interface Animal {
  nombre: string;
}
interface Perro extends Animal {
  raza: string;
}
interface ClockInterface {
  currentTime: Date;
  setTime(d: Date): void;
}
```

Todos estos ejemplos se pueden visualizar en el [código de ejemplo](../ejemplos/modulo01/10-interfaces-tipos.ts).

## Unión e intersección

Frecuentemente nos encontraremos en la situación donde nuestras funciones, métodos o utilidades pueden recibir diferentes tipos de datos y
retornar diferentes posibilidades de ellos, la unión e intersección nos ayudan a combinar algún tipo o interfaz existente en vez de realizar
lógica de cero.

#### Unión

La unión genera un tipo nuevo, tomando en cuenta lo que tienen en común 2 interfaces o tipos como se puede ver en el ejemplo:

```typescript
interface Bird {
  fly(): void;
  layEggs(): void;
}
interface Fish {
  swim(): void;
  layEggs(): void;
}
let pet: Fish | Bird;
pet.layEggs(); // Disponible en sus 2 posibles tipos
pet.swim(); // Solo disponible en uno de sus tipos: Property 'swim' does not exist on type 'Bird | Fish'.
```

También sirve para indicar que es una posibilidad entre varias.

```typescript
type NetworkLoadingState = {
  state: 'loading';
};
type NetworkFailedState = {
  state: 'failed';
  code: number;
};
type NetworkSuccessState = {
  state: 'success';
  response: {
    title: string;
    duration: number;
    summary: string;
  };
};
// Creamos un tipo que representa uno de los tipos de arriba, pero aún no sabemos cual es
type NetworkState = NetworkLoadingState | NetworkFailedState | NetworkSuccessState;

function networkStatus(state: NetworkState): string {
  // console.log(state.code); // Property 'code' does not exist on type 'NetworkState'.
  switch (state.state) {
    case 'loading':
      return 'Descargando...';
    case 'failed':
      return `Error ${state.code} descargando`;
    case 'success':
      return `Descargado ${state.response.title} - ${state.response.summary}`;
  }
}
```

#### Intersección

Es muy similar a la unión, pero combina todas las diferencias que tienen las interfaces y tipos a combinar.

```typescript
interface ManejadorDeErrores {
  success: boolean;
  error?: { message: string };
}
interface Articulos {
  articulos: { title: string }[];
}
type RespuestaDeArticulos = Articulos & ManejadorDeErrores;

const handler = (response: RespuestaDeArticulos) => {
  if (response.error) {
    console.log(response.error.message);
    throw response.error;
  }
  console.log(response.articulos);
};
```

## Clases

El JS tradicional utiliza funciones y herencia basada en prototipos para construir componentes reusables, pero siendo desarrolladores que
estamos acostumbrados a una POO estándar, esto se siente un poco incómodo, dónde no tenemos una herencia con funcionalidad y objetos creados
con clases. A partir de ES6 podemos trabajar con clases en JS, con algunas restricciones como en los modificadores de acceso. En TS se
permite utilizar todas las técnicas que conocemos de POO sin problema alguno y se compila para cualquier versión de JS, sin tener que
esperar a una versión específica de JS que soporte todas nuestras necesidades.

Un ejemplo de clase simple

```typescript
class Saludador {
  private readonly saludo: string;

  constructor(message: string) {
    this.saludo = message;
  }

  greet() {
    return `Hello, ${this.saludo}`;
  }
}

let saludador = new Saludador('world');
```

#### Herencia

```typescript
class Animal {
  mover(distanciaEnMetros: number) {
    console.log(`Animal se movió ${distanciaEnMetros}m.`);
  }
}
class Perro extends Animal {
  ladrar() {
    console.log('Woof! Woof!');
  }
}
const dog = new Perro();
dog.ladrar();
dog.mover(10);
dog.ladrar();
```

#### Modificadores de acceso

Aquí se cumplen todas las normas de la POO, se pueden tener niveles públicos `public`, protegidos `protected` y privados `private`, a
diferencia de los lenguajes como C#, el nivel público no tiene que ser explícito, si no ponemos ningún modificador de acceso en alguna
propiedad o método, se tomarán como públicos. Además, se toma en cuenta el modificador `readonly`, que funciona similar a `const`,
únicamente permite la asignación de su valor directo o por constructor. Nunca permite ser modificado en otro lado.\
Para recordar.

- `public` puede ser accedido en cualquier lugar, en los métodos de la clase, en sus clases heredadas y en la instancia.
- `protected` puede ser accedido en los métodos de la clase y en sus clases heredadas, no se puede acceder desde la instancia.
- `private` puede ser accedido únicamente desde la definición de la clase, en sus clases heredadas y en la instancia no se puede.
- `<public | protected | private> readonly` puede ser accedido en el lugar indicado, pero emitirá error si se intenta re-asignar, únicamente
puede ser asignado en el constructor o con valor por default.

```typescript
class Persona {
  protected _nombre: string;
  private uid: string;
  protected constructor(theName: string) {
    this._nombre = theName;
    this.uid = (new Date()).getTime().toString();
  }
  traeNombre() {
    return this._nombre;
  }
}
class Empleado extends Persona {
  private readonly departamento: string;

  constructor(nombre: string, departamento: string) {
    super(nombre);
    this.departamento = departamento;
    // console.log(this._nombre); // Válido
    // console.log(this.uid); // Error: Property 'uid' is private and only accessible within class 'Persona'.
  }

  public traePresentacion() {
    // this.departamento = 'Prueba'; // Error: Attempt to assign to const or readonly variable
    return `Hola, mi nombre es ${this.traeNombre()} y trabajo en ${this.departamento}.`;
  }
}
let howard = new Empleado('Victor', 'departamento de TI');
console.log(vic.traePresentacion());
// let john = new Persona('Victor'); // Constructor of class 'Persona' is protected and only accessible within the class declaration.
```

#### Getters y setters

TS también admite la posibilidad de usar getters y setters en sus clases, recordemos que un método `get` no puede recibir parámetros y
retornar un valor no-vacío. Un método `set` siempre debe retornar `void` y tener exactamente un parámetro.

```typescript
class Persona {
  protected _name: string;
  public get name() {
    return this._name;
  }
  public set name(newName: string) {
    this._name = newName;
  }
}
```

#### Propiedades por parámetro

Podemos asignar una propiedad a nuestra clase que se asignará en el constructor y se pide al momento de instanciarlo, esto es particularmente
útil para inyección en Angular.

```typescript
class Pulpo {
  readonly numberOfLegs: number = 8;
  constructor(readonly name: string) {}
}
let pulpo = new Pulpo('Animal que tiene 8 fuertes tentáculos');
console.log(pulpo.name);
```

#### Propiedades, métodos y clases estáticas

Hasta ahora hemos trabajado con clases, sus propiedades y métodos que usamos instanciando con `new Clase()`, sin embargo, podemos hacer uso
de lo estático, que no requiere ser instanciado y se trabaja con la definición directa de una clase.

```typescript
class Grid {
  static origen = { x: 0, y: 0 };

  calculaDistanciaDesdeElOrigen(punto: { x: number; y: number }): number {
    const xDist = punto.x - Grid.origen.x;
    const yDist = punto.y - Grid.origen.y;
    return Math.sqrt(xDist * xDist + yDist * yDist) / this.escala;
  }

  constructor(public escala: number) {}

  static calculaDistanciaEnUnEje(eje: 'x' | 'y', distancia: number): number {
    let dist = distancia - Grid.origen.x;
    if (eje === 'y') {
      dist = distancia - Grid.origen.y;
    }
    return dist;
  }
}

let grid1 = new Grid(1.0); // escala 1x
let grid2 = new Grid(5.0); // escala 5x

console.log(grid1.calculaDistanciaDesdeElOrigen({ x: 10, y: 10 }));
console.log(grid2.calculaDistanciaDesdeElOrigen({ x: 10, y: 10 }));
console.log(Grid.calculaDistanciaEnUnEje('x', 100));
```

#### Clases abstractas

Las clases abstractas son claes "base" en las cuales otras clases se derivan, se caracterizan por no poder ser instanciadas directamente,
pero, a diferencia de una interfaz, una clase abstracta puede contener implementación de sus métodos.

```typescript
abstract class Mamifero {
  abstract makeSound(): void;

  move(): void {
    console.log('roaming the earth...');
  }
}
class Gato implements Mamifero {
  makeSound(): void {
    console.log('Meow');
  }

  move(): void {
    console.log('Roaming the earth...');
  }

}
const mamifero = new Mamifero(); // Error: Cannot create an instance of an abstract class.
```

#### Interfaces y clases

Podemos hacer una especie de combinación de uso a las clases e interfaces, es importante mencionar que una clase si existirá en runtime de
JS, pero una interfaz no. Esto quiere decir que si queremos checar el tipo con `typeof` de un objeto, únicamente podremos hacerlo con
chequeo de clase, pero no de interfaz.

```typescript
class Point {
  x: number = 0;
  y: number = 0;
}
interface Point3d extends Point {
  z: number;
}
class Coordenadas implements Point3d {
  private origen = { x: 0, y: 0, z: 0 };
  constructor(public x: number, public y: number, public z: number) {}
}
let point3d: Point3d = { x: 1, y: 2, z: 3 };
let coordenadas: Coordenadas = new Coordenadas(1, 2, 3);
```

## Namespaces

Los namespaces nos ayudan a desarrollar cuando estamos utilizando TS para desarrollar en un entorno como el navegador. Cuando trabajamos con
varios archivos JS, es necesario importar cada uno en el HTML que estemos trabajando, para utilizar alguna función que tenemos declarado en
otro archivo, bastaba con importarlo en el orden correcto en el HTML, sin embargo el editor y/o IDE no reconocía de forma correcta las
funciones, no teníamos autocompletado, etc. Con TS esto no es problema, imaginemos que tenemos un archivo con clases validadoras como el
siguiente:

```typescript
const lettersRegexp = /^[A-Za-z]+$/;
const numberRegexp = /^[0-9]+$/;

interface StringValidator {
  isAcceptable(s: string): boolean;
}

class LettersOnlyValidator implements StringValidator {
  isAcceptable(s: string) {
    return lettersRegexp.test(s);
  }
}
class ZipCodeValidator implements StringValidator {
  isAcceptable(s: string) {
    return s.length === 5 && numberRegexp.test(s);
  }
}
```

Sin embargo, queremos hacer uso de `LettersOnlyValidator` y `ZipCodeValidator` en otro archivo. Si estuviéramos trabajando con node
simplemente podríamos exportar e importar lo que necesitemos, de la siguiente forma:

```typescript
// Validadores.ts
const lettersRegexp = /^[A-Za-z]+$/;
const numberRegexp = /^[0-9]+$/;

export interface StringValidator {
  isAcceptable(s: string): boolean;
}

export class LettersOnlyValidator implements StringValidator {
  isAcceptable(s: string) {
    return lettersRegexp.test(s);
  }
}
export class ZipCodeValidator implements StringValidator {
  isAcceptable(s: string) {
    return s.length === 5 && numberRegexp.test(s);
  }
}
// App.ts
import { StringValidator, LettersOnlyValidator, ZipCodeValidator } from './Validadores';

let validators: { [s: string]: StringValidator } = {};
validators['ZIP code'] = new ZipCodeValidator();
validators['Letters only'] = new LettersOnlyValidator();
```

Sin embargo, si utilizamos este tipo de nomenclatura, todo está correcto para TS, pero una vez que utilicemos el archivo en nuestro
navegador, no funcionará correctamente, dado que el JS de node, utiliza module.exports como forma de export/import y los módulos no existen
en el navegador (a nivel código). Aquí es donde los `namespace` entran.

Todos los archivos que queramos "exportar" serán envueltos por un namespace de la siguiente forma:

```typescript
namespace Validation {
  const lettersRegexp = /^[A-Za-z]+$/;
  const numberRegexp = /^[0-9]+$/;
  export interface StringValidator {
    isAcceptable(s: string): boolean;
  }
  export class LettersOnlyValidator implements StringValidator {
    isAcceptable(s: string) {
      return lettersRegexp.test(s);
    }
  }
  export class ZipCodeValidator implements StringValidator {
    isAcceptable(s: string) {
      return s.length === 5 && numberRegexp.test(s);
    }
  }
}
```

Ahora, está listo para ser importado en otro archivo, supongamos que tenemos un archivo dónde usaremos las validaciones, pero, ¿Cómo podemos
importarlas y compilarlas? Previo al uso del código debemos hacer una especie de referencia que reconozca TS, esto se hace con una especie de
etiqueta:

```typescript
/// <reference path="Validadores.ts" />
```

Posteriormente, podemos hacer uso sin problema de los "exports" del namespace, para el ejemplo anterior podemos hacer uso de las clases 
`ZipCodeValidator` y `LettersOnlyValidator`, o de la interfaz `StringValidator`, pero no podremos hacer uso de `lettersRegexp` ni
`numberRegexp`, por ejemplo:

```typescript
/// <reference path="Validadores.ts" />

let strings = ['Hello', '98052', '101']; // Cadenas a validar

// Validadores a usar
let validators: { [s: string]: Validation.StringValidator } = {};
validators['ZIP code'] = new Validation.ZipCodeValidator();
validators['Letters only'] = new Validation.LettersOnlyValidator();

// Muestra si cada cadena pasa cada validador.
for (const s of strings) {
  for (const name of Object.keys(validators)) {
    console.log(`"${s}" - ${validators[name].isAcceptable(s) ? 'matches' : 'does not match'} ${name}`);
  }
}
```

Ahora debemos compilar un poco diferente nuestros archivos, dado que la sección de `<reference path="Validadores.ts" />` se toma como un
comentario más de nuestro archivo, el parámetro `--outFile` y como argumento los archivos que utilizamos (namespaces y usos), combinará
los archivos un uno solo, resolviendo las dependencias que tienen entre ellos.

```console
tsc --outFile dist/13-namespaces.js 13-1-namespaces.ts 13-2-namespaces.ts
```

Esto generará el archivo `13-namespaces.js` dentro de la carpeta `dist`, tomando en cuenta el código de los archivos `13-1-namespaces.ts` y
`13-2-namespaces.ts`, listo para ser importado en un navegador o probar con node.

Se agregan con este proyecto unos cuantos scripts de npm básicos, para construir todos los archivos, estos scripts se pueden ver en el
archivo `package.json` en la sección `scripts`.

```json
{
  "scripts": {
    "build": "tsc && npm run build:namespace",
    "build:namespace": "tsc --outFile dist/13-namespaces.js 13-1-namespaces.ts 13-2-namespaces.ts",
    "run:namespace": "tsc --outFile dist/13-namespaces.js 13-1-namespaces.ts 13-2-namespaces.ts && node dist/13-namespaces.js"
  }
}
```

##### Fin de módulo
