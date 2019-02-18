// Factory Function to create new Objects
function createCircle(radius) {
	return {
		radius,
		draw() {
			console.log('draw the circle');
		}
	};
}

// Constructor Function to create new Objects
function Cirle(radius) {
	this.radius = radius;
	this.draw = function() {
		console.log('draw circle');
	};
}

const circle = new Cirle(1);
