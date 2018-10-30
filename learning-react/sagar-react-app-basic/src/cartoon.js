import React from 'react';
import './cartoon.css';

const styles = {
	name: {
		color: 'green'
	},
	creator: {
		fontWeight: 'bold'
	}
};
export default function Cartoon(props) {
	return (
		<div>
			<span className="name" style={styles.name}>
				{props.name}
			</span>
			{props.children} -
			<span className="creator" style={styles.creator}>
				{props.creator}
			</span>
		</div>
	);
}
