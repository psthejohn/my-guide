let name = 'ashu';
let age = 213;
// we can define an object inplace of defining diff diff variables  , lets see how

// {} -> object literal
let person = {
	// add key value pairs
	name1: 'ashu',
	age1: 213
};
console.log(person);

// accessing the elements :
// Dot notation
console.log(person.age1);
person.age1 = 312;
console.log(person.age1);
// Bracket [] notation
person['name1'] = 'alok';
console.log(person.name1);
