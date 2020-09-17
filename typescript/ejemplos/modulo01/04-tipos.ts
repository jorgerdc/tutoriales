let isDone: boolean;

let numero: number;
numero = 6;
numero = 0x3E8; // hex
numero = 0b1010; // binary
numero = 0o1750;  // octal

let color: string;
color = "blue"; // TS Valid, Linter Error
color = 'red';
const nombre = `Victor Servin`;
const edad = 37;
const mensaje = `Hola, mi nombre es ${nombre},

Tendré ${ edad + 1 } años el siguiente mes!`;
console.log(mensaje);

let fechaDeHoy: Date;
fechaDeHoy = new Date();

function mostrar(o: object) {
  console.log(o);
}
mostrar({ color: 'rojo' }); // Válido
mostrar({ color: 'rojo', nombre: 'teclado' }); // Válido
// mostrar(null); // Argument of type 'null' is not assignable to parameter of type 'object'.
// mostrar('string'); // Argument of type '"string"' is not assignable to parameter of type 'object'.
// mostrar(100); // Argument of type '100' is not assignable to parameter of type 'object'.
// mostrar(false); // Argument of type 'false' is not assignable to parameter of type 'object'.

const sinTipo: any = 5;
sinTipo.unMetodoQueNoExiste(); // un método que nunca se declaró, pero TS no se molesta en verificar
const errorPorqueNoEsCadena = sinTipo.length; // length es una propiedad de una cadena
const asignacionQueProbablementeMateTodo: Date = sinTipo.toFixed(); // toFixed es un método para números

// declare var $: any;
// const elemento: object = $( 'li.item-ii' ).find( 'li' ).css( 'background-color', 'red' );

function mandarAviso(mensaje: string): void {
  console.log(mensaje);
}

let numeroQueYaNoMeSirve: any;
let pruebaDeAlgo: any;
if (pruebaDeAlgo) {
  numeroQueYaNoMeSirve = 10;
}
console.log(numeroQueYaNoMeSirve.toString()); // Válido, sin embargo, numeroQueYaNoMeSirve es posiblemente undefined

let maybe: unknown;
// const aNumber: number = maybe; // Type 'unknown' is not assignable to type 'number'.

if (maybe === true) {
  // TypeScript knows that maybe is a boolean now
  const aBoolean: boolean = maybe; // TS sabe que si entra al bloque del if solo es posible que sea un booleano
  // const aString: string = maybe; // Type 'boolean' is not assignable to type 'string'.
}

if (typeof maybe === 'string') {
  const aString: string = maybe; // sabe que "maybe" es una cadena
  // const aBoolean: boolean = maybe; // Type 'string' is not assignable to type 'boolean'.
}

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
// traeFecha(5).toUTCString(); // Property 'toUTCString' does not exist on type 'string'
(traeFecha(5) as Date).toUTCString(); // Válido
// traeFecha(5, true).split(', '); // Property 'split' does not exist on type 'Date'
(traeFecha(5, true) as string).split(', '); // Válido
