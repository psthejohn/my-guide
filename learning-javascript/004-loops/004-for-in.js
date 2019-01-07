const person = {
	name: 'ashu',
	age: 30
};

for (let key in person) console.log(key, person[key]);
// since person dont have a property with name key thats why person.key will be undefined
