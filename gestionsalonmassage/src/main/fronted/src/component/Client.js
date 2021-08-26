import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Clients() {
	const [clients, setClients] = useState([]);

	const fetchClients = () => {
		axios.get("http://localhost:8081/clients").then(res => {
			console.log(res);
			const data = res.data;
			setClients(data);
		}
		);
	}

	useEffect(() => { fetchClients(); }, [])

	return (
		<div><h1>Clients</h1>
			<table>
				<ClientTableHeader />
				{clients.map((client, index) => {
					return (<tbody><tr>
						<td>{client.clientId}</td>
						<td>{client.nom}</td>
						<td>{client.prenom}</td>
						<td>{client.adresse}</td>
						<td>{client.telephone}</td>
						<td>{client.mail}</td>
						<td>{client.pseudoFacebook}</td>
						<td>{(client.origineContact) ? client.origineContact.libelle : ''}</td>
						<td><ProblematiquesClient client={client} /></td>
						<ClientActions />
					</tr></tbody>);
				})}
			</table></div>);
};

function ProblematiquesClient(props) {
	return (
		<textarea disabled>
			{
				props.client.listProblematiques.map((prob, index) => {
					return (prob.libelle);
				}).join(",")}
		</textarea>);

}

function ClientTableHeader() {
	return (<thead><tr><th>ID</th>
		<th>Nom</th>
		<th>Prénom</th>
		<th>Adresse</th>
		<th>Téléphone</th>
		<th>Mail</th>
		<th>Pseudo Facebook</th>
		<th>Origine contact</th>
		<th>Problématique(s)</th></tr></thead>);
}

function ClientActions() {

	const [hiddenSelectVente, setHiddenSelectVente] = useState(true);
	const [btnModifierEnregistrer, setBtnModifierEnregistrer] = useState('Modifier');

	function afficherChoixVente() {
		setHiddenSelectVente(!hiddenSelectVente);
	}

	function changerModifierEnregistrer() {
		if (btnModifierEnregistrer === 'Modifier') {
			setBtnModifierEnregistrer('Enregistrer');
			// TODO : Changer le html de la table en champs modifiables

		} else {
			setBtnModifierEnregistrer('Modifier');
			// TODO : Changer le html de la table en champs libellés non modifiables
		}

	}

	return (
		<div>
			<button type="button" onClick={changerModifierEnregistrer}>{btnModifierEnregistrer}</button>
			<button type="button">Supprimer</button>
			<button type="button">Détails Fidélité</button>
			<button type="button" onClick={afficherChoixVente}>Nouvelle vente</button>
			<select id="selectVente" hidden={hiddenSelectVente}>
				<option value="Massage">Massage</option>
				<option value="ChequeCadeau">Chèque cadeau</option>
				<option value="Produit">Produit</option>
			</select>
		</div>

	);
}



export default Clients;

