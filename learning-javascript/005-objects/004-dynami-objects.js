// Objects in javascript are dynamic in nature
// It simply means that we can add / remove the properties of the objects ever after creating an object.

const circle = {
	radius: 1
};

console.log(circle); // o/p: {radius:1}

circle.color = 'yellow';
console.log(circle); // o/p: { radius: 1, color: 'yellow' }

// adding a new function
circle.draw = function() {};
console.log(circle); // o/p: { radius: 1, color: 'yellow', draw: [Function] }

// we can use the delete keyword to delete the properties or the methods of an object
delete circle.color;
delete circle.draw;

console.log(circle); // o/p: { radius: 1 }

// please note it down that every object has an constructor property that we can use respectively.

// eg :
// new String();
// new Boolean();
// 
