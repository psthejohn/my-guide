// if objects contains logic we need diff way to create the objects
// either through factory or constructor functions

// Factory functions

function createCircle(radius) {
	return {
		radius, // its equivalent to radius: radius
		draw() {
			console.log('draw');
		}
	};
}

const circle1 = createCircle(1);
console.log(circle1);
circle1.draw();
