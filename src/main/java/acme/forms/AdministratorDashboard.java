package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	
protected static final long serialVersionUID = 1L;

	/**
	 * Patronages.
	 */
	//Total number of proposed/accepted/denied patronages
	Integer totalNumberOfProposedPatronages; 
	Integer totalNumberOfAcceptedPatronages;
	Integer totalNumberOfDeniedPatronages;
	
	//PROPOSED patronages: Average, deviation, minimum and maximum budget.
	
	Double averageBudgetOfProposedPatronages;
	Double deviationBudgetOfProposedPatronages;
	Double minimumBudgetOfProposedPatronages;
	Double maximumBudgetOfProposedPatronages;
	
	//ACCEPTED patronages: Average, deviation, minimum and maximum budget.
	Double averageBudgetOfAcceptedPatronages;
	Double deviationBudgetOfAcceptedPatronages;
	Double minimumBudgetOfAcceptedPatronages;
	Double maximumBudgetOfAcceptedPatronages;
	
	//DENIED patronages: Average, deviation, minimum and maximum budget.
	Double averageBudgetOfDeniedPatronages;
	Double deviationBudgetOfDeniedPatronages;
	Double minimumBudgetOfDeniedPatronages;
	Double maximumBudgetOfDeniedPatronages;
	
	/**
	 * Components.
	 */
	// COMPONENTS: Total number, average, deviation, minimum and maximum retail.
	Integer totalNumberOfComponents;
	Double averageRetailPriceOfComponents;
	Double deviationRetailPriceOfComponents;
	Double minumimRetailPriceOfComponents;
	Double maximumRetailPriceOfComponents;
	
	/**
	 * Tools.
	 */
	// TOOLS: Total number, average, deviation, minimum and maximum retail.
	Integer totalNumberOfTools;
	Double averageRetailPriceOfTools;
	Double deviationRetailPriceOfTools;
	Double minumimRetailPriceOfTools;
	Double maximumRetailPriceOfTools;

}
