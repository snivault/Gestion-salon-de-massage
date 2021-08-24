import React, { useState, useEffect } from 'react';
import axios from 'axios';

class ClientTable extends React.Component {
	constructor(props) {
		super(props);
		this.state={
			listClients: this.props.clients,
		}
	}

	render () {
		return (
			<div><h1>Clients</h1>
			<table>
					<ClientTableHeader />
				{this.props.clients.map((client,index) => {
					return (<tbody>
							<tr><td>{client.nom}</td>
							<td>{client.prenom}</td>
							<td>{client.adresse}</td>
							<td>{client.telephone}</td>
							<td>{client.mail}</td>
							<td>{client.pseudoFacebook}</td>
							<td>{client.origineContact}</td>
							<td><ProblematiquesClient client={client} /></td></tr></tbody>);
				})}
		</table></div>);
	}
} 

function ProblematiquesClient(props) {
	function concatenerProblematiques(listProb) {
		const reducer = (accumulateur,currentValue) => accumulateur.concat(currentValue);
		listProb.reduce(reducer);
	}


	return (
		<textarea>
			
			{
			props.client.listProblematiques.map((prob,index)=>{
			return (prob.libelle);
		}).join(",")}
		</textarea>);

}

class ClientTableHeader extends React.Component {
	constructor(props) {
		super(props);
		// plus tard pour le tri et les filtres
	}
	render() {
		return ( <thead><tr><th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Adresse</th>
		<th>Téléphone</th>
		<th>Mail</th>
		<th>Pseudo Facebook</th>
		<th>Origine contact</th>
		<th>Problématique(s)</th></tr></thead>);
	}
}

function Clients () {

  const [clients, setClients] = useState([]);

  function transformerJSONProblematiques(data) {
		let stringJson=data.stringify;
		// dataProblematiques = data.listProblematiques.map;

  }

  const fetchClients = () => {
    axios.get("http://localhost:8081/clients").then(res => {
      console.log(res);
	  const data = res.data;
	  let dataProb = transformerJSONProblematiques(data);
      setClients(data);
    }
    );
  }


  useEffect(() => { fetchClients(); }, [])

  return(
	  <div>
		  <ClientTable clients={clients} />
	  </div>
  )
};

export default Clients;

