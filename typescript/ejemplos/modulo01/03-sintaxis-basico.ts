export function sum(...params: number[]): number {
  let res = 0;
  for (const num of params) {
    res += num;
  }
  return res;
}

const a: number = 4;
const b = { prueba: 'hola' };
const c = '5';
const d = null;
const e = [1, 2, 3];
// const total = sum(a, b, c, d, e); // ERROR
const total = sum(a, 1, 2, 3); // ÉXITO
console.log('Resultado:', total);
