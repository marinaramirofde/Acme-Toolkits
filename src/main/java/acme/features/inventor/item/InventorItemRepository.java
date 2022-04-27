package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);
	
	@Query("select c from Item c where c.inventor.id= :inventorId")
	Collection<Item> findManyItemsInventorId(int inventorId);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findOneInventorById(int id);
		
}
