package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface AdminitratorDashboardRepository extends AbstractRepository {
	
	//Queries
	
	//Total number of proposed/accepted/denied patronages
	
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
	
}
