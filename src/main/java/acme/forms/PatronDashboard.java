package acme.forms;

import java.io.Serializable;
import java.util.Map;

import acme.entities.patronages.Patronage;
import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{

	protected static final long    serialVersionUID= 1L;

	/**
	 * Total number of pro-posed/accepted/denied patronages.
	 */
	Integer totalNumberOfProposedPatronages;
	Integer totalNumberOfAcceptedPatronages; 
	Integer totalNumberOfDeniedPatronages; 

	/**
	 * Average.
	 */
	Double averageBudgetOfProposedPatronages;
	Double averageBudgetOfAcceptedPatronages;
	Double averageBudgetOfDeniedPatronages;

	/**
	 * Deviation.
	 */
	Double budgetDeviationOfProposedPatronages;
	Double budgetDeviationOfAcceptedPatronages;
	Double budgetDeviationOfDeniedPatronages;
	
	/**
	 * Minimum.
	 */
	Double minimumBudgetOfProposedPatronages;
	Double minimumBudgetOfAcceptedPatronages;
	Double minimunBudgetOfAcceptedPatronages;
	
	/**
	 * Maximum.
	 */
	Double maximumBudgetOfProposedPatronages;
	Double maximumBudgetOfAcceptedPatronages;
	Double maximumBudgetOfDeniedPatronage;
	
	/**
	 * ... patronages grouped by currency.
	 */	
	Map<Patronage, Money> patronagesGroupedByCurrency;
	
}
