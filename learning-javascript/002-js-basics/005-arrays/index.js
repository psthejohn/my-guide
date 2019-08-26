let selectedColors = ['red', 'blue'];
console.log(selectedColors);
console.log(selectedColors[0]);
console.log(selectedColors.length);

// Pushing an element to array
selectedColors.push('black');
console.log(selectedColors[2]); // it adds black color at last

// Removing the last element from array
selectedColors.pop();
console.log(selectedColors);// it should remove black color

// Removing from front of an array
selectedColors.shift();
console.log(selectedColors); // it removes red color from front

// Adding an element to front of array
selectedColors.unshift('red');
console.log(selectedColors); // it adds red color in front

// Finding index of an element in array
console.log(selectedColors.indexOf('red'));// it checks position of red in array
