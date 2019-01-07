console.log(false || true);

console.log(false || 'ashu');
// here o/p is 'ashu' as its not a boolean TRUE ,so its truthy
console.log(false || 1);
// here o/p is 1 as its truthy

// when javascript engine tries to evaluate an expression it looks at each operand ,
// if the operand is not boolean true or false it will try to interpret it as truthy or falsy

// Falsy (kind of like boolean false)
// undefined
// null
// 0
// false
// ''
// NaN
// anything that is not falsy is truthy

console.log(false || 1 || 2);
// o/p 1: as soon as evaluation starts and it find the first operand as truthy it retruns the value and stops the execution , it doesnt matter what next 
// this is called short-curcuiting

let userColor = 'red';
let defaultColor = 'blue';
let currentColor = userColor || defaultColor;

console.log(currentColor);
