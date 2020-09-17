/// <reference path="13-1-namespaces.ts" />
// Para compilar este archivo se ejecuta en el módulo raiz: tsc --outFile dist/13-namespaces.js 13-2-namespaces.ts

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
