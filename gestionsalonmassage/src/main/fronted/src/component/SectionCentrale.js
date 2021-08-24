import React, { useState, useEffect, Component } from 'react';
import { render } from 'react-dom';
import Client from './Client';
import Vente from './Vente';

class SectionCentrale extends React.Component {
	constructor(props) {
		super(props);
	}

	getComposant() {
		switch(this.props.page) {
			case 'Client':
				return <Client />;
			case 'Vente':
				return <Vente />;
			default:
				return <Client />;
		}
	}

	render() {
		return(
		<section><article>{this.getComposant()}</article></section>
		);
	}
}

export default SectionCentrale;