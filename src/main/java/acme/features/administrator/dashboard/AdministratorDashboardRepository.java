package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	
	//Total number of proposed/accepted/denied patronages
	@Query("select count(p) from Patronage p where p.status = 'PROPOSED'")
	Integer totalNumberOfProposedPatronages();

	@Query("select count(p) from Patronage p where p.status = 'ACCEPTED'")
	Integer totalNumberOfAcceptedPatronages();
	
	@Query("select count(p) from Patronage p where p.status = 'DENIED'")
	Integer totalNumberOfDeniedPatronages();
	
	//Average, deviation, minimum and maximum budget of proposed patronages
	
	@Query("select avg(p.budget.amount) from Patronage p where p.status = 'PROPOSED'")
	Double averageBudgetOfProposedPatronages();
	
	@Query("select stddev(p.budget.amount) from Patronage p where p.status = 'PROPOSED'")
	Double deviationBudgetOfProposedPatronages();

	@Query("select min(p.budget.amount) from Patronage p where p.status = 'PROPOSED'")
	Double minimumBudgetOfProposedPatronages();
	
	@Query("select max(p.budget.amount) from Patronage p where p.status = 'PROPOSED'")
	Double maximumBudgetOfProposedPatronages();
	
	//Average, deviation, minimum and maximum budget of accepted patronages
	
	@Query("select avg(p.budget.amount) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double averageBudgetOfAcceptedPatronages();
	
	@Query("select stddev(p.budget.amount) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double deviationBudgetOfAcceptedPatronages();
	
	@Query("select min(p.budget.amount) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double minimumBudgetOfAcceptedPatronages();
	
	@Query("select max(p.budget.amount) from Patronage p WHERE p.status = 'ACCEPTED'")
	Double maximumBudgetOfAcceptedPatronages();
	
	//Average, deviation, minimum and maximum budget of denied patronages
	
	@Query("select avg(p.budget.amount) from Patronage p WHERE p.status = 'DENIED'")
	Double averageBudgetOfDeniedPatronages();
	
	@Query("select stddev(p.budget.amount) from Patronage p WHERE p.status = 'DENIED'")
	Double deviationBudgetOfDeniedPatronages();
	
	@Query("select min(p.budget.amount) from Patronage p WHERE p.status = 'DENIED'")
	Double minimumBudgetOfDeniedPatronages();
	
	@Query("select max(p.budget.amount) from Patronage p WHERE p.status = 'DENIED'")
	Double maximumBudgetOfDeniedPatronages();

	////
	
	@Query("SELECT count(it) FROM Item it WHERE it.type = 'COMPONENT'")
	Integer totalNumberOfComponents();
	
	@Query("SELECT avg(it.retailPrice.amount) FROM Item it WHERE it.type = 'COMPONENT' GROUP BY it.technology, it.retailPrice.currency")
	Double averageRetailPriceOfComponents();
	
	@Query("SELECT stddev(it.retailPrice.amount) FROM Item it WHERE it.type = 'COMPONENT' GROUP BY it.technology, it.retailPrice.currency")
	Double deviationRetailPriceOfComponents();
	
	@Query("SELECT min(it.retailPrice.amount) FROM Item it WHERE it.type = 'COMPONENT' GROUP BY it.technology, it.retailPrice.currency")
	Double minimumRetailPriceOfComponents();
	
	@Query("SELECT max(it.retailPrice.amount) FROM Item it WHERE it.type = 'COMPONENT' GROUP BY it.technology, it.retailPrice.currency")
	Double maximumRetailPriceOfComponents();
	
	////
	
	@Query("SELECT count(it) FROM Item it WHERE it.type = 'TOOL'")
	Integer totalNumberOfTools();
	
	@Query("SELECT avg(it.retailPrice.amount) FROM Item it WHERE it.type = 'TOOL' GROUP BY it.retailPrice.currency")
	Double averageRetailPriceOfTools();
	
	@Query("SELECT stddev(it.retailPrice.amount) FROM Item it WHERE it.type = 'TOOL' GROUP BY it.retailPrice.currency")
	Double deviationRetailPriceOfTools();
	
	@Query("SELECT min(it.retailPrice.amount) FROM Item it WHERE it.type = 'TOOL' GROUP BY it.retailPrice.currency")
	Double minimumRetailPriceOfTools();
	
	@Query("SELECT max(it.retailPrice.amount) FROM Item it WHERE it.type = 'TOOL' GROUP BY it.retailPrice.currency")
	Double maximumRetailPriceOfTools();
}