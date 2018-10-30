import React from 'react';
import ReactDOM from 'react-dom';

// function tick() {
// 	const element = (
// 		<div>
// 			<h2>Hello world</h2>
// 			<h2>It is {new Date().toLocaleString()}</h2>
// 		</div>
// 	);
// 	ReactDOM.render(element, document.getElementById('root'));
// }
// setInterval(tick, 1000);

// we are going to change the above code into reusable components / funtions with props

// function Clock(props) {
// 	return (
// 		<div>
// 			<h2> Hello world</h2>
// 			<h2> It is {props.date.toLocaleString()}</h2>
// 		</div>
// 	);
// }
// function tick() {
// 	ReactDOM.render(
// 		<Clock date={new Date()} />,
// 		document.getElementById('root')
// 	);
// }
// setInterval(tick, 1000);

// now we will change the above code to use stats and convert function in class

class Clock extends React.Component {
	constructor(props) {
		super(props);
		this.state = { date: new Date() };
	}
	render() {
		return (
			<div>
				<h2>Hello World</h2>
				<h2>It is {this.state.date.toLocaleString()}</h2>
			</div>
		);
	}
}

function tick() {
	ReactDOM.render(<Clock />, document.getElementById('root'));
}
setInterval(tick, 1000);
