package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository {

	@Query("select i from Item i where i.id = :id")
	Item findOneItemById(int id);

	@Query("select c from Item c where c.type = 'COMPONENT'")
	Collection<Item> findAllComponents();
	
	@Query("select i from Item i where i.type = 'TOOL'")
	Collection<Item> findAllTools();

	@Query("select c from Item c where c.inventor.id = :inventorId")
	Collection<Item> findManyComponentsByInventorId(int inventorId);

	// Añadir el de tool
}
