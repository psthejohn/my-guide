import React, { Component, Fragment } from 'react';
import axios from 'axios';

export default class App extends Component {
	state={
        cartoons:[]
    };

	componentDidMount() {
		console.log('component loaded ');
		axios.get('/api/cartoons').then(res => {
			console.log(res);
			const cartoons = res.data;
			console.log('cartoons=', cartoons);
			const stateCartoons = [...this.state.cartoons, ...cartoons];
			console.log('data is ', stateCartoons);
			this.setState({ cartoons: stateCartoons });
		});
	}

	handleCarttonNameChanged(event) {
		const newValue = event.target.value;
		console.log(newValue);
		this.setState({ cartoonName: newValue });
		console.log(this.state);
	}
	render() {
		return (
			<Fragment>
				<h2>{this.props.title}</h2>
				<form>
					<input
						value={this.state.cartoonName}
						onChange={this.handleCarttonNameChanged.bind(this)}
						type="text"
						placeholder="Name of  Cartoon"
					/>
					<input type="text" placeholder="Name of Creator" />
					<input type="submit" value="create " />
				</form>
				<ul>
					{this.state.cartoons.map(cartoon => (
						<li>{cartoon.name}</li>
					))}
				</ul>
			</Fragment>
		);
	}
}
