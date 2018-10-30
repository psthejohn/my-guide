import React from 'react';
import ReactDOM from 'react-dom';

// simplest way to define a component is to write a  javascript function

// function Welcome(props) {
// 	return <h2>Hello , {props.name}</h2>;
// }

// we can also use an ES6 class to define a component
// this is equivalant to what we have written above

// class Welcome extends React.Component {
// 	render() {
// 		return <h2>Hello , {this.props.name}</h2>;
// 	}
// }

// function Welcome(props) {
// 	return <h1>Hello , {props.name}</h1>;
// }
// const element = <Welcome name="sara" />;
// ReactDOM.render(element, document.getElementById('root'));

// note we can render multiple components in same way

function Welcome(props) {
	return <h1>Hello , {props.name}</h1>;
}
function App() {
	return (
		<div>
			<Welcome name="sara" />
			<Welcome name="abc" />
			<Welcome name="xyz" />
		</div>
	);
}
ReactDOM.render(<App/>, document.getElementById('root'));
