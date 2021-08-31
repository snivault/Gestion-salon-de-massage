import React, { useState, useEffect } from 'react';
import axios from 'axios';

class VenteTable extends React.Component {
	constructor(props) {
		super(props);
		this.state={
			listVentes: this.props.ventes,
		}
	}

	render () {
		return (
			<table>
					<VenteTableHeader />
				{this.props.ventes.map((vente,index) => {
					return (<tbody key={vente.venteId}>
							<tr><td>{vente.dateVente}</td>
							<td>{vente.client.nomPrenom}</td>
							<td>{vente.montantEncaisse}</td>
							<td>{vente.moyenPaiement}</td>
							<td>{vente.nature}</td>
							<td>{vente.nature}</td>
							</tr></tbody>);
				})}
		</table>);
	}
} 

class VenteTableHeader extends React.Component {
	constructor(props) {
		super(props);
		// plus tard pour le tri et les filtres
	}
	render() {
		return ( <thead><tr><th>ID</th>
		<th>Date</th>
		<th>Client</th>
		<th>Montant Encaissé</th>
		<th>Moyen de paiement</th>
		<th>Nature</th>
		<th>Produit</th></tr></thead>);
	}
}

function Ventes () {

  const [ventes, setVentes] = useState([]);

  const fetchVentes = () => {
    axios.get("http://localhost:8081/api/v1/vente").then(res => {
      console.log(res);
      const data = res.data;
      setVentes(data);
    }
    );
  }


  useEffect(() => { fetchVentes(); }, [])

  return(
	  <div>
		  <VenteTable ventes={ventes} />
	  </div>
  )
};

export default Ventes;

