import React, { useState, useEffect } from 'react';
import { Redirect } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import axios from 'axios';

const wait = function (duration = 1000) {
	return new Promise((resolve) => {
		window.setTimeout(resolve, duration);
	})
}

const instanceAxios = axios.create({
  baseURL: "http://localhost:8081/api/v1/client",
  timout: 10000,
  headers: {
    "Content-type": "application/json"
  }
});

function Clients() {
	const [clients, setClients] = useState([]);

	const fetchClients = () => {
		instanceAxios.get(instanceAxios.defaults.baseURL).then(res => {
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
	const  { handleSubmit, watch } = form;
	// handler
	const onSubmit = async data => {
		await wait(2000)
		console.log(data)
		
	};
	return (
		<div><h1>Clients</h1>
			<form onSubmit={handleSubmit(onSubmit)}>
				<button>Ajouter</button>
				<table>
					<ClientTableHeader />
					{clients.map((client, index) => {
						return (
							<tbody key={"tbody".concat(client.clientId)} >
								<Client dataClient={client} modifiable={true} form={form} key={"client".concat(client.clientId)} />
							</tbody>);
					})}
				</table>
			</form>
		</div>);
};

function Client(props) {
	let [dataClient, setDataClient] = useState(props.dataClient);
	const  { register, handleSubmit, formState, errors,watch } = props.form;
	const index = props.dataClient.clientId;

	console.log(watch("telephoneClient".concat(props.dataClient.clientId)));


	if (props.modifiable) {
		return (<tr>
			<td>{index}</td>
			<td>
				<input type="text" className="form-control is-invalid" defaultValue={props.dataClient.nom} id={"nomClient".concat(index)}
				key={"nomClient".concat(index)}
				{...register("nomClient".concat(index), {required: "Vous devez saisir un nom de client.", })} >
				</input>
				{/* {errors.nomClient && <span>{errors.nomClient.message}</span>} */}
			</td>
			<td><input type="text" className="form-control is-invalid" defaultValue={props.dataClient.prenom} id={"prenomClient".concat(index)}
				key={"prenomClient".concat(index)}
				{...register("prenomClient".concat(index), { required: "Vous devez saisir un prénom de client.", })}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.adresse} id={"adresseClient".concat(index)}
				key={"adresseClient".concat(index)}
				{...register("adresseClient".concat(index), {})}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.telephone} id={"telephoneClient".concat(index)}
				key={"telephoneClient".concat(index)}
				{...register("telephoneClient".concat(index), {})}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.mail} id={"mailClient".concat(index)}
				key={"mailClient".concat(index)}
				{...register("mailClient".concat(index), { required: "Required:false", })}>
			</input></td>
			<td><input type="text" className="form-control" defaultValue={props.dataClient.pseudoFacebook} id={"pseudoFacebook".concat(index)}
				key={"pseudoFacebook".concat(index)}
				{...register("pseudoFacebookClient".concat(index), {})}>
			</input></td>
			<td>{(dataClient.origineContact) ? dataClient.origineContact.libelle : ''}</td>
			<td><ProblematiquesClient client={dataClient} />
			</td>
			<ClientActions dataClient={props.dataClient} />
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

function ClientActions(props) {

	const [hiddenSelectVente, setHiddenSelectVente] = useState(true);
	const [btnModifierEnregistrer, setBtnModifierEnregistrer] = useState('Modifier');

	function afficherChoixVente() {
		setHiddenSelectVente(!hiddenSelectVente);
	}

	async function clicModifierEnregistrer() {
		if (btnModifierEnregistrer === 'Enregistrer' && props.dataClient) {
			// Enregistrer les modifications
			await instanceAxios.put(instanceAxios.defaults.baseURL+ '/' + props.dataClient.clientId,props.dataClient)
			.then(response => {
				// this.setState({clientId: response.data.clientId});
				console.log('Enregistrement du client N°:' + props.dataClient.clientId + ' OK.');
			})
			.catch(error => {
				// this.setState({errorMessage: error.message});
				console.log("Erreur lors de l'enregistrement du client N°:".concat(props.dataClient.clientId).concat(error.message));
			})

			setBtnModifierEnregistrer('Modifier');
			// TODO : Changer le html de la table en champs libellés non modifiables

		} else {

			setBtnModifierEnregistrer('Enregistrer');
			// TODO : Changer le html de la table en champs modifiables
		}

	}
	// Attendre que le serveur ait exécuté la requête
	async function supprimerClient() {
		await instanceAxios.delete(instanceAxios.defaults.baseURL + '/' + props.dataClient.clientId)
			.then(response => {
				// TODO : afficher setStatus('Suppression ok');
				console.log('Suppression du client N°:' + props.dataClient.clientId + ' OK.');
				// TODO : supprimer le client de la liste et réafficher
			})
			.catch(error => {
				// TOTO : setErrorMessage(error.message);
				console.log('Erreur lors de la suppression du client n°:' + props.dataClient.clientId + ' ' + error.message);
			});
	}

	return (
		<td>
			<button type="submit" onClick={clicModifierEnregistrer}>{btnModifierEnregistrer}</button>
			<button type="button" onClick={() => supprimerClient()}>Supprimer</button>
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

