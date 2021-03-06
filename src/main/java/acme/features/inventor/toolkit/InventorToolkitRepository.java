package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;



@Repository
public interface InventorToolkitRepository extends AbstractRepository{
	
	@Query("SELECT t FROM Toolkit t WHERE t.inventor.id= :inventorId")
	Collection<Toolkit> findManyToolkitsByInventorId(int inventorId);
	
	@Query("SELECT t FROM Toolkit t WHERE t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	
	
	/** Quantity **/
	@Query("SELECT sum(q.amount*q.item.retailPrice.amount) FROM Quantity q WHERE q.toolkit.id = :toolkitId")
	Double retailPriceOfToolkitById(int toolkitId);
	
	@Query("SELECT q FROM Quantity q WHERE q.toolkit.id = :id")
	Collection<Quantity> findQuantityByToolkitId(int id);
	
	@Query("SELECT q.item FROM Quantity q WHERE q.id = :id")
	Collection<Item> findManyItemByQuantityId(int id);
	
	@Query("SELECT q FROM Inventor q WHERE q.id = :id")
	Inventor findInventorById(int id);
	
	@Query("SELECT q.toolkit FROM Quantity q WHERE q.toolkit.inventor.id = :id")
	Toolkit findToolkitByInventorId(int id);
	
	@Query("select q.amount from Quantity q where q.item.id= :itemId and q.toolkit.id= :toolkitId")
	Integer findAmountFromItemIdAndToolkitId(int itemId, int toolkitId);
	
	@Query("select t from Toolkit t where t.code = :code")
	Toolkit findOneToolkitByCode(String code);
	
	@Query("select q.item from Quantity q where q.item.published = true and q.item "
		+ "not in (select q.item from Quantity q where q.item.type = 'TOOL' and q.toolkit.id =:toolkitId)")
	Collection<Item> findManyItemNotToolExistingNotPublished(int toolkitId);
	
	@Query("select sum(q.item.retailPrice.amount*q.amount) from Quantity q where q.toolkit.id = :id")
	Double findPriceOfToolkitByToolkitId(int id);
	
	@Query("select q.item.retailPrice.currency from Quantity q where q.toolkit.id = :id")
	List<String> findMoneyTypePriceOfToolkitByToolkitId(int id);



}