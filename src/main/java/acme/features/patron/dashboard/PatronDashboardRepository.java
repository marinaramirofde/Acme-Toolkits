package acme.features.patron.dashboard;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.Patronage;
import acme.forms.Money;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronDashboardRepository extends AbstractRepository{

	/**
	 * Total number of pro-posed/accepted/denied patronages.
	 */
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED")
	Integer totalNumberOfProposedPatronages();
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED")
	Integer totalNumberOfAcceptedPatronages(); 
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED")
	Integer totalNumberOfDeniedPatronages(); 

	/**
	 * Average.
	 */
	@Query("select avg(select count(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED)")
	Double averageBudgetOfProposedPatronages();
	@Query("select avg(select count(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED)")
	Double averageBudgetOfAcceptedPatronages();
	@Query("select avg(select count(p.budget) from Patronage p where p.status = acme.entities.patronage.Status.DENIED)")
	Double averageBudgetOfDeniedPatronages();
	
	@Query("SELECT STDEV(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.PROPOSED) AS [Standard Deviation] FROM")
	Double budgetDeviationOfProposedPatronages();
	@Query("SELECT STDEV(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.ACCEPTED) AS [Standard Deviation]")
	Double budgetDeviationOfAcceptedPatronages();
	@Query("SELECT STDEV(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.DENIED) AS [Standard Deviation]")
	Double budgetDeviationOfDeniedPatronages();
	
	@Query("SELECT MIN(COUNT(p.budget.amount)) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.PROPOSED) ")
	Double minimumBudgetOfProposedPatronages();
	@Query("SELECT MIN(COUNT(p.budget.amount)) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.ACCEPTED) ")
	Double minimumBudgetOfAcceptedPatronages();
	@Query("SELECT MIN(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.DENIED) ")
	Double minimumBudgetOfDeniedPatronages();
	
	@Query("SELECT MAX(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.PROPOSED) ")
	Double maximumBudgetOfProposedPatronages();
	@Query("SELECT MAX(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.ACCEPTED) ")
	Double maximumBudgetOfAcceptedPatronages();
	@Query("SELECT MAX(p.budget.amount) FROM Patronage p WHERE p.status = acme.entities.patronage.Status.DENIED) ")
	Double maximumBudgetOfDeniedPatronages();
	
	@Query("SELECT Patronage FROM Patronage p GROUPED BY p.budget.currency ")
	Map<Patronage, Money> patronagesGroupedByCurrency();
	
}
