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
console.log(saludador.greet());

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

class Persona {
  protected _nombre: string;
  private uid: string;
  protected constructor(theName: string) {
    this._nombre = theName;
    this.uid = (new Date()).getTime().toString();
  }
  get nombre() {
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
    return `Hola, mi nombre es ${this.nombre} y trabajo en ${this.departamento}.`;
  }
}
let vic = new Empleado('Victor', 'departamento de TI');
console.log(vic.traePresentacion());
// let john = new Persona('Victor'); // Constructor of class 'Persona' is protected and only accessible within the class declaration.

class Pulpo {
  readonly numberOfLegs: number = 8;
  constructor(readonly name: string) {}
}
let pulpo = new Pulpo('Animal que tiene 8 fuertes tentáculos');
console.log(pulpo.name);

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
let grid1 = new Grid(1.0); // 1x scale
let grid2 = new Grid(5.0); // 5x scale
console.log(grid1.calculaDistanciaDesdeElOrigen({ x: 10, y: 10 }));
console.log(grid2.calculaDistanciaDesdeElOrigen({ x: 10, y: 10 }));
console.log(Grid.calculaDistanciaEnUnEje('x', 100));

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
// const mamifero = new Mamifero(); // Error: Cannot create an instance of an abstract class.

class Point {
  x = 0;
  y = 0;
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
