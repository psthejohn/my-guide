// divisible by 3 -> fizz
// divisible by 5 -> buzz
// divisible by both 3 & 5 => fizzBuzz
// not divisible by 3 or 5 => input
// not a number => 'Not a Number'
const output = fizzBuzz('abc');
console.log(output);

function fizzBuzz(input) {
	if (typeof input !== 'number') return 'Not a Number';
	if (input % 3 === 0 && input % 5 === 0) return 'fizzBuzz';
	if (input % 3 === 0) return 'fizz';
	if (input % 5 === 0) return 'buzz';
	else return input;
}
