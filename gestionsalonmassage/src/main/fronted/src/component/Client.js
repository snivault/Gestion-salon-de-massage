import React, { useState, useEffect } from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios';

const wait = function (duration = 1000) {
	return new Promise((resolve) => {
		window.setTimeout(resolve, duration);
	})
}

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

	/* Tuto de ReactJS : Si vous voulez exécuter un effet et le nettoyer une seule fois (au montage puis au démontage), vous pouvez passer un tableau vide ([]) comme second argument. 
	* Ça indique à React que votre effet ne dépend d’aucune valeur issue des props ou de l’état local, donc il n’a jamais besoin d’être ré-exécuté. */
	useEffect(() => { fetchClients(); }, [])

	// Hook form
	const form = useForm();
	const  { handleSubmit } = form;

	// handler
	const onSubmit = async data => {
		await wait(2000)
		console.log(data)
	};

	return (
		<div><h1>Clients</h1>
			<form onSubmit={handleSubmit(onSubmit)}>
				<table>
					<ClientTableHeader />
					{clients.map((client, index) => {
						return (
							<tbody key={"tbody".concat(client.clientId)} >
								<Client dataClient={client} modifiable={true} form={form} />
							</tbody>);
					})}
				</table>
			</form>
		</div>);
};

function Client(props) {
	let [dataClient, setDataClient] = useState(props.dataClient);
	const  { register, handleSubmit, formState, errors } = props.form;

	//defaultValue={dataClient.nom}
	// defaultValue={dataClient.prenom}
	// defaultValue={dataClient.adresse}
	// defaultValue={dataClient.telephone}
	// defaultValue={dataClient.mail}

	if (props.modifiable) {
		return (<tr>
			<td>{props.dataClient.clientId}</td>
			<td>
				<input type="text" className="form-control is-invalid" defaultValue={props.dataClient.nom} id={"nomClient".concat(props.dataClient.clientId)}
				key={"nomClient".concat(props.dataClient.clientId)}
			 		{...register("nomClient".concat(props.dataClient.clientId), { required: "Vous devez saisir un nom de client.", })}>
			</input></td>
			<td><input type="text" className="form-control is-invalid"  defaultValue={props.dataClient.prenom} id={"prenomClient".concat(props.dataClient.clientId)} 
				{...register("prenomClient".concat(props.dataClient.clientId), { required: "Vous devez saisir un prénom de client.", })}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.adresse} id={"adresseClient".concat(props.dataClient.clientId)} 
				{...register("adresseClient".concat(props.dataClient.clientId), {})}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.telephone} id={"adresseClient".concat(props.dataClient.clientId)} 
				{...register("telephoneClient".concat(props.dataClient.clientId), {})}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.mail} id={"mailClient".concat(props.dataClient.clientId)} 
				{...register("mailClient".concat(props.dataClient.clientId), { required: "Required:false", })}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.pseudoFacebook} id={"pseudoFacebook".concat(props.dataClient.clientId)} 
				{...register("pseudoFacebookClient".concat(props.dataClient.clientId), {})}>
			</input></td>
			<td>{(dataClient.origineContact) ? dataClient.origineContact.libelle : ''}</td>
			<td><ProblematiquesClient client={dataClient} />
			</td>
			<ClientActions />
		</tr>
		);
	} else {
		return (<tr>
			<td>{props.dataClient.clientId}</td>
			<td>{props.dataClient.nom}</td>
			<td>{props.dataClient.prenom}</td>
			<td>{props.dataClient.adresse}</td>
			<td>{props.dataClient.telephone}</td>
			<td>{props.dataClient.mail}</td>
			<td>{props.dataClient.pseudoFacebook}</td>
			<td>{(props.dataClient.origineContact) ? props.dataClient.origineContact.libelle : ''}</td>
			<td><ProblematiquesClient client={props.dataClient} />
			</td>
			<ClientActions />
		</tr>
		);
	}
}

function ProblematiquesClient(props) {
	return (
		<textarea disabled defaultValue={
				props.client.listProblematiques.map((prob, index) => {
					return (prob.libelle);
				}).join(",")} />);

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
		<td>
			<button type="submit" onClick={changerModifierEnregistrer}>{btnModifierEnregistrer}</button>
			<button type="button">Supprimer</button>
			<button type="button">Détails Fidélité</button>
			<button type="button" onClick={afficherChoixVente}>Nouvelle vente</button>
			<select id="selectVente" hidden={hiddenSelectVente}>
				<option value="Massage">Massage</option>
				<option value="ChequeCadeau">Chèque cadeau</option>
				<option value="Produit">Produit</option>
			</select>
		</td>

	);
}



export default Clients;

