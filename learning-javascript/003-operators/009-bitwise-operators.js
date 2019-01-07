// bitwise operators

// in real life we use number system like 1,2,3,4 etc
// but computers read the numbers in 0 and 1 only
// eg 1     = 00000001
// eg 2     = 00000010
// result   = 00000011 => 3
// result   = 00000000 => 0
// bitwise operators are similar to logical operators but they work on binary numbers

console.log(1 | 2); // bitwise OR
console.log(1 & 2);

// real world example
// Read , Write and Execute
// read only 00000100
// read and write 00000110
// read write and execute 00000111

const readPermission = 4;
const writePermission = 2;
const executePermission = 1;
let myPermission = 0;
myPermission = myPermission | readPermission | writePermission;
console.log(myPermission);

let message = myPermission & readPermission ? 'yes' : 'no';
console.log(message)
