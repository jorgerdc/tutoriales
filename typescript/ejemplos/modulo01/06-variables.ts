var variable1: unknown = 'string'; // <scope | reasignacion> <nombre de la variable>: <tipo> = <valor asignado>;
let variable2: unknown; // <scope | reasignacion> <nombre de la variable>: <tipo>;
const variable3 = 'string'; // <scope | reasignacion> <nombre de la variable> = <valor asignado>;
var variable4; // <scope | reasignacion>;
variable4 = 2;
variable4.toString();
variable4 = 'ASD';
variable4.toLowerCase();

var valor = 10;
// const valor = 10;
function unaFuncion() {
  var valor = 20;
  // let valor = 20;
  if (!isNaN(valor)) {
    var valor = 30;
    // const valor = 30;
    console.log(valor);
  }
  valor += 5;
  console.log(valor);
}
unaFuncion();
console.log(valor);

const prod = (x: number, y: number): number => x * y;
console.log('Arrow function:', prod(1, 2));

const usuarios: { id: string, nombre: string }[] = [
  { id: '1', nombre: 'Vic' },
  { id: '2', nombre: 'Sam' },
  { id: '3', nombre: 'Jorge' }
];
const usuario = usuarios.find(u => u.id === '2'); // Sam
const usuarioInexistente = usuarios.find(u => u.id === '5'); // undefined

const miSuma: (baseValue: number, increment: number) => number = (x, y) => {
  return x + y;
};
console.log(miSuma(2, 5));

const construyeNombre = (nombre: string, apellido?: string): string => apellido ? `${nombre} ${apellido}` : nombre;
const construyeNombreFormal = (nombre:string, apellido: string, prefijo = '"Sr.'): string => `${prefijo} ${nombre} ${apellido}`;
console.log(construyeNombre('Victor'));
console.log(construyeNombre('Victor', 'Servin'));
console.log(construyeNombreFormal('Victor', 'Servin'));
console.log(construyeNombreFormal('Victor', 'Servin', 'Ing.'));
