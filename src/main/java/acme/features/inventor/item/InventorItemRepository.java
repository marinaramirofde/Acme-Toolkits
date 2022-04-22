package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select c from Item c where c.inventor.id = :inventorId and c.type = acme.entities.items.ItemType.COMPONENT")
	Collection<Item> findManyComponentsByInventorId(int inventorId);
	
	@Query("select c from Item c where c.inventor.id = :inventorId and c.type = acme.entities.items.ItemType.TOOL")
	Collection<Item> findManyToolsByInventorId(int inventorId);

	
}
