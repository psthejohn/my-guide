// print pyramid of stars
// *
// **
// ***

showStars(5);

function showStars(rows) {
	for (let i = 0; i < rows; i++) {
		let pattern = ' ';
		for (let j = 0; j < i; j++) {
			pattern += '*';
		}
		console.log(pattern);
	}
}
