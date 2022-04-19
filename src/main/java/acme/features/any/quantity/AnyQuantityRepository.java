package acme.features.any.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyQuantityRepository extends AbstractRepository {

	@Query("select q from Quantity q where q.id = :id")
	Quantity findOneToolkitById(int id);

	@Query("select q from Quantity q where q.toolkit.published = True")
	Collection<Quantity> findAllToolkits();
	
	@Query("select q from Quantity q")
	Collection<Quantity> findAllToolkitsNPI();
	
	@Query("select q from Quantity q where q.item.id = :id")
	Collection<Toolkit> findAllToolkitsByItemId(int id);
	
	@Query("select sum(q.item.retailPrice.amount*q.amount) from Quantity q where q.toolkit.id = :id")
	Double findPriceOfToolkitByToolkitId(int id);
	
	@Query("select q.item.retailPrice.currency from Quantity q where q.toolkit.id = :id")
	List<String> findMoneyTypePriceOfToolkitByToolkitId(int id);


}
