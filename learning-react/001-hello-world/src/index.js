import React from 'react';
import ReactDOM from 'react-dom';

// ****************************************
// Part 1:

// ReactDOM.render(
// 	<h1>Hello World , welcome to react hello world example</h1>,
// 	document.getElementById('root')
// );

// ****************************************

// Part 2:  the above code can also be rendered as ->

// ****************************************
// const element = <h1>Hello World , welcome to react hello world example</h1>;
// ReactDOM.render(element, document.getElementById('root'));

// what we have done here is to put the complete html part in an element

// ****************************************

// Part 3:
// contents put in {} are executed just before the rendering on browser
// const name = 'ashu';
// const element = <h2>Hi , {name} !! How are you?</h2>;

// ReactDOM.render(element, document.getElementById('root'));

// ****************************************

// Part 4:

// function formatName(user) {
// 	return user.firstName + ' ' + user.lastName;
// }

// const user = {
// 	firstName: 'Asto',
// 	lastName: 'gamay'
// };

// const element = <h2>Hi , {formatName(user)} !! How are you?</h2>;

// ReactDOM.render(element, document.getElementById('root'));

// ****************************************

// Part 5:

// function getGreeting(user) {
// 	if (user) {
// 		return <h2>Hi , {formatName(user)} !! How are you?</h2>;
// 	} else {
// 		return <h2>Hello Stranger !! How are you?</h2>;
// 	}
// }

// function formatName(user) {
// 	return user.firstName + ' ' + user.lastName;
// }
// const user = {
// 	firstName: 'Asto',
// 	lastName: 'gamay'
// };

// ReactDOM.render(getGreeting(user), document.getElementById('root'));

// ****************************************

// Part 6:

// multi line tags:

// const element = (
// 	<div>
// 		<h1>Hello world</h1>
// 		<h2>ohh wow its working</h2>
// 	</div>
// );

// ReactDOM.render(element, document.getElementById('root'));

// ****************************************

// Part 7:

// JSX Represents Objects
// Babel compiles JSX down to React.createElement() calls. lets see how!!

// const element = <h1 className="greeting">Hello, world!</h1>;

// now the above statement is same as this statement

// const element = React.createElement(
// 	'h1',
// 	{ className: 'greeting' },
// 	'Hello World!!'
// );

// which is again same to this detailed but more clear statement

// const element = {
// 	type: 'h1',
// 	props: {
// 		className: 'greeting',
// 		children: 'Hello World!!'
// 	}
// };
// note this above statement is asking for an array rendering inspite of element

// ReactDOM.render(element, document.getElementById('root'));

// ************************************

// Part 8:

// Ticking clock example

function tick() {
	const element = (
		<div>
			<h1>Hello, world!</h1>
			<h2>It is {new Date().toLocaleTimeString()}.</h2>
		</div>
	);
	ReactDOM.render(element, document.getElementById('root'));
}

setInterval(tick, 1000);
