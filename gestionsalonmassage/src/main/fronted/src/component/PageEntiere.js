import React from 'react';
import {
	BrowserRouter as Router,
	Switch,
	Route,
	NavLink
} from 'react-router-dom';

import Client from './Client';
import Vente from './Vente';

class PageEntiere extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			pageActive: 'Client',
		}
	}

	handleClick(page) {
		this.setState(() => ({ pageActive: page }));
	}

	render() {
		return (
			<Router>
				<div>
					<nav id="navigation">
						<ul>
							<li>
								<NavLink to="/api/v1/client" activeClassName="menu-actif">Client</NavLink>
							</li>
							<li>
								<NavLink to="/api/v1/vente" activeClassName="menu-actif">Vente</NavLink>
							</li>
							<li><a href="./Achat">Achats</a></li>
							<li><a href="./Parametrage">Paramétrage</a></li>
							<li><a href="./Comptabilite">Comptabilité</a></li>
						</ul>
					</nav>
					<Switch>
						<Route path="/api/v1/client">
							<Client />
						</Route>
						<Route path="/api/v1/vente">
							<Vente />
						</Route>
					</Switch>
				</div>
			</Router>
		)
	}
}

export default PageEntiere;