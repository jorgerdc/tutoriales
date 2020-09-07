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

const usuarioDePrueba: Usuario = {
  nombre: 'Victor',
  apellido: 'Servin',
  edad: 25
};
// usuarioDePrueba.edad = usuarioDePrueba.edad + 1; // Cannot assign to 'edad' because it is a read-only property.
console.log(usuarioDePrueba);
console.log(usuarioDePrueba.profesion); // undefined

let sumatoria: FuncionNumeros;
sumatoria = (...nums) => nums.reduce((a, v) => a + v, 0);

const modeloS: Auto = {
  color: 'negro',
  marca: 'Tesla',
  traccion: 'AWD',
  almacenamiento: 804,
  garantia: {
    vehiculo: true,
    bateria: true
  }
};

const caramelo: Perro = {
  nombre: 'caramelo',
  raza: 'Boxer'
};

class Reloj implements ClockInterface {
  currentTime: Date;

  constructor() {
    this.currentTime = new Date();
  }

  setTime(d: Date) {
    this.currentTime = d;
  }
}
