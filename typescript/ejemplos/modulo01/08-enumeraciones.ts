enum Color {
  Red,
  Green,
  Blue
}
let c: Color = Color.Green;
console.log(c); // 1

enum Color2 {
  Red = 1,
  Green = 2,
  Blue = 4
}
let c2: Color2 = Color2.Green;
console.log(c2); // 2

console.log(Color[2]); // Podemos visualizar que "nombre" le corresponde al valor de una enumeración
