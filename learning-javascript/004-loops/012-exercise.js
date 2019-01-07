// print sum of all multiple of 3 & 5 for a given number

console.log(sum(10));

// Multiples of 3 : 3,6,9
// Multiples of 5: 5,10

function sum(limit) {
	// find all multiples of 3 under limit
    let result = 0;
    
	for (let i = 0; i < limit; i++) 
		if (i % 3 === 0 || i % 5 === 0) 
            result += i;
            
    return result;
}
