import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';
import Cartoon from './cartoon';

// ReactDOM.render(<h2>Hello World</h2>, document.getElementById('root'));
// ReactDOM.render(<App />, document.getElementById('root'));
const cartoons = [
	{ id: 1, name: 'Micky mouse', creator: 'walt disney', show: true },
	{ id: 2, name: 'Tom & Jerry', creator: 'Hanna N Barbara', show: false }
];

ReactDOM.render(
	<ul>
		<li>{2 + 2}</li>
		{/* contents inside {} get execcuted before redering */}
		{cartoons.map(cartoon => (
			<Fragment key={cartoon.id}>
				{cartoon.show ? (
					<li>
						<Cartoon name={cartoon.name} creator={cartoon.creator}>
							<i>&copy;</i>
						</Cartoon>
					</li>
				) : null}
			</Fragment>
		))}
	</ul>,
	document.getElementById('root')
);
