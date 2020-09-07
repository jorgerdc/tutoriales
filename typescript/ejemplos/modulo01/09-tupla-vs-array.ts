let x: [number, number, string];
x = [10, -1, 'Mi casa']; // OK
// x = [10, -1, 'Mi casa', 'asd']; // Error
// x = [10, 'Casa del profe']; // Error

const puntos: [number, number, string][] = [
  [1, 2, 'prueba 1'],
  [2, 3, 'prueba 2'],
  [3, 4, 'prueba 3'],
  [4, 5, 'prueba 4']
];

puntos.forEach((p) => {
  // p[2].concat(p[0], p[1]); // Argument of type 'number' is not assignable to parameter of type 'string'.
  p[2].concat(p[0].toString(), p[1].toString()); // Válido
});
