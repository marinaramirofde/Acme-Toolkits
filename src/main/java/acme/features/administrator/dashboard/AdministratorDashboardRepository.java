package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	
	@Query("SELECT count(c) FROM Component c")
	Integer totalNumberOfComponents();
	
	@Query("SELECT avg(c.retailPrice.amount) FROM Component c GROUP BY c.technology and c.retailPrice.currency")
	Double averageRetailPriceOfComponents();
	
	@Query("SELECT stddev(c.retailPrice.amount) FROM Component c GROUP BY c.technology and c.retailPrice.currency")
	Double deviationRetailPriceOfComponents();
	
	@Query("SELECT min(c.retailPrice.amount) FROM Component c GROUP BY c.technology and c.retailPrice.currency")
	Double minimumRetailPriceOfComponents();
	
	@Query("SELECT max(c.retailPrice.amount) FROM Component c GROUP BY c.technology and c.retailPrice.currency")
	Double maximumRetailPriceOfComponents();
	
	////
	
	@Query("SELECT count(t) FROM Tool t")
	Integer totalNumberOfTools();
	
	@Query("SELECT avg(t.retailPrice.amount) FROM Tool t GROUP BY t.retailPrice.currency")
	Double averageRetailPriceOfTools();
	
	@Query("SELECT stddev(t.retailPrice.amount) FROM Tool t GROUP BY t.retailPrice.currency")
	Double deviationRetailPriceOfTools();
	
	@Query("SELECT min(t.retailPrice.amount) FROM Tool t GROUP BY t.retailPrice.currency")
	Double minimumRetailPriceOfTools();
	
	@Query("SELECT max(t.retailPrice.amount) FROM Tool t GROUP BY t.retailPrice.currency")
	Double maximumRetailPriceOfTools();

}
