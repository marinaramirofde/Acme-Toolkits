package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;



@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("SELECT t FROM Toolkit t WHERE t.inventor.id= :id")
	Collection<Toolkit> findManyToolkitsByInventorId(int id);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("SELECT sum(q.amount*q.item.retailPrice.amount) FROM Quantity q WHERE q.toolkit.id = :id")
	Double retailPriceOfToolkitById(int id);
	
	@Query("SELECT q FROM Quantity q WHERE q.toolkit.id = :id")
	Collection<Quantity> findQuantityByToolkitId(int id);
	
	@Query("SELECT q.item FROM Quantity q WHERE q.id = :id")
	 Collection<Item> findManyItemByQuantityId(int id);

}