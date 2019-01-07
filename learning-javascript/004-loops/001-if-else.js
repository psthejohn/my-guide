// hour
// if hour is between 6am and 12 pm : Good Morning
// if hour is between 12 pm and 6 pm : Good AfterNoon
// otherwise GoodEvening

let hour = 23;
if (hour >= 6 && hour < 12) {
	console.log('Good Morning');
} else if (hour >= 12 && hour < 18) {
	console.log('Good AfterNoon');
} else {
	console.log('Good Evening');
}
