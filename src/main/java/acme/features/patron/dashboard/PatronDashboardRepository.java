package acme.features.patron.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
	
}
