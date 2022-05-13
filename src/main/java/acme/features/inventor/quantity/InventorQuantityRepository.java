package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorQuantityRepository extends AbstractRepository {

	
	
	@Query("select i from Quantity i where i.id = :id")
	Quantity findOneQuantityById(int id);
	
	@Query("select i from Quantity i where i.toolkit.id = :id")
	List<Quantity> findQuantityByToolkitId(int id);
		
	@Query("select t from Item t where t.code = :code")
	Item findOneItemByCode(String code);
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("SELECT q.item FROM Quantity q WHERE q.id = :id")
	Collection<Item> findManyItemByQuantityId(int id);
	
	@Query("select q.amount from Quantity q where q.item.id= :itemId and q.toolkit.id= :toolkitId")
	Integer findAmountFromItemIdAndToolkitId(int itemId, int toolkitId);
	
	



	
}
