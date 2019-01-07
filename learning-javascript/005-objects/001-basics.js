const circle = {
	radius: 1,
	location: {
		x: 1,
		y: 1
	},
	isVisible: true,
	draw: function() {
		console.log('draw');
	}
};

circle.draw();

// if a function is a part of an object we call that function as method
