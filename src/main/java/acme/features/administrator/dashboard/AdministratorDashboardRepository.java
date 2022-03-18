package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	

	@Query("SELECT count(c) FROM Component c")

	//Total number of proposed/accepted/denied patronages
										                //  = acme.entities.patronage.Status.ACCEPTED
	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	Integer totalNumberOfProposedPatronages();

	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	Integer totalNumberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	Integer totalNumberOfDeniedPatronages();
	
	//Average, deviation, minimum and maximum budget of proposed patronages
	
	@Query("select avg(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double averageBudgetOfProposedPatronages();
	
	@Query("select avg(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double deviationBudgetOfProposedPatronages();

	@Query("select avg(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double minimumBudgetOfProposedPatronages();
	
	@Query("select avg(p.budget) from Patronage p where p.status = 'PROPOSED'")
	Double maximumBudgetOfProposedPatronages();
	
	//Average, deviation, minimum and maximum budget of accepted patronages
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double averageBudgetOfAcceptedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double deviationBudgetOfAcceptedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double minimumBudgetOfAcceptedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double maximumBudgetOfAcceptedPatronages();
	
	//Average, deviation, minimum and maximum budget of denied patronages
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'DENIED'")
	Double averageBudgetOfDeniedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'DENIED'")
	Double deviationBudgetOfDeniedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'DENIED'")
	Double minimumBudgetOfDeniedPatronages();
	
	@Query("select avg(p.budget) from Patronage p WHERE p.status = 'DENIED'")
	Double maximumBudgetOfDeniedPatronages();

  @Query("SELECT count(c) FROM Component c WHERE c.typeEntity ='COMPONENT'")
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
