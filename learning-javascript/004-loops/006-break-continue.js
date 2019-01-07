let i = 0;
while (i < 10) {
	// if (i === 5) break;
	// break is used to jump out of the code and stop the loop execution

	if (i % 2 === 0) {
		i++;
		continue;
		// when js engine see continue keyword , it will jump to the beginning of the loop and continues execution of the next iteration
		//Note it skips the code after the continue keyword.
	}
	console.log(i);
	i++;
}
console.log('end of the code ');
// Note : with break keyword we jump out of loop and with continue keyword we jump to next iteration.
