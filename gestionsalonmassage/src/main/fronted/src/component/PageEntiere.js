import React, { useState, useEffect } from 'react';
import { render } from 'react-dom';
import BoutonNav from './BoutonNav';
import SectionCentrale from './SectionCentrale';

class PageEntiere extends React.Component {
	constructor(props) {
		super(props);
		this.state= {
			pageActive:'Client',
		}
	}

	handleClick(page) {
		this.setState(() => ({pageActive: page}));
	} 

	render() {
		return(
			<div>
				<nav className="menu">
					<ul>
						<li><BoutonNav 
							value="Client" onClick={() => this.handleClick("Client")} /></li>
						<li><BoutonNav 
							value="Vente" onClick={() => this.handleClick("Vente")} /></li>
						<li><a href="./Achat">Achats</a></li>
						<li><a href="./Parametrage">Paramétrage</a></li>
						<li><a href="./Comptabilite">Comptabilité</a></li>
					</ul>
		</nav>				
        		<SectionCentrale page={this.state.pageActive} />
			</div>
		)
	}
}

export default PageEntiere;