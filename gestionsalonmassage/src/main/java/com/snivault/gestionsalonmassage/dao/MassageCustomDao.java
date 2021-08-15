package com.snivault.gestionsalonmassage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface permettant d'interrogerla table Massage. Je l'ai créé pour
 * l'exemple de méthode personnalisée que nous aurions besoin de décrire dans
 * une implémentation de DAO. Ici ce n'est pas le cas, mais nous aurions pu
 * créer une classe qui implémente MassageDao lui meme implémentant cette
 * interface
 * 
 * @author Nous
 *
 */
public interface MassageCustomDao {

	/**
	 * La vue c_massage_adapte est déjà construite pour retourner les massages les
	 * plus adaptés à chaque client. Cette fonction retourne une liste de cette vue
	 * en fonction du client demandé.
	 * 
	 * @param clientId
	 * @return liste de massages adaptés
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM c_massage_adapte WHERE c_client_id=:clientId")
	List<ViewMassageAdapteDao> getMassageAdapte(@Param("clientId") int clientId);

}
