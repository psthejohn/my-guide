// calculate the grade of students

const marks = [80, 80, 50];
// average = 70

// 1-59: F
// 60-69: D
// 70-79: C
// 80-89: B
// 90-100: A

console.log(calculateGrade(marks));
// calculateGrade(marks);
function calculateGrade(marks) {
	let result = calculateAverage(marks);
	if (result < 60) return 'F';
	if (result < 70) return 'D';
	if (result < 80) return 'C';
	if (result < 90) return 'B';
	return 'A';
}

function calculateAverage(array) {
	let sum = 0;

	for (let value of array) {
		sum += value;
	}

	return sum / array.length;
}
