package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashborard implements Serializable {

	protected static final long serialVersionUID = 1L;
	
	//Attributes
	
	//Total number of proposed/accepted/denied patronages
	
	Integer totalNumberOfProposedPatronages; 
	Integer totalNumberOfAcceptedPatronages;
	Integer totalNumberOfDeniedPatronages;
	
	//Average, deviation, minimum and maximum budget of proposed patronages
	
	Double averageBudgetOfProposedPatronages;
	Double deviationBudgetOfProposedPatronages;
	Double minimumBudgetOfProposedPatronages;
	Double maximumBudgetOfProposedPatronages;
	
	//Average, deviation, minimum and maximum budget of accepted patronages
	
	Double averageBudgetOfAcceptedPatronages;
	Double deviationBudgetOfAcceptedPatronages;
	Double minimumBudgetOfAcceptedPatronages;
	Double maximumBudgetOfAcceptedPatronages;
	
	//Average, deviation, minimum and maximum budget of denied patronages
	
	Double averageBudgetOfDeniedPatronages;
	Double deviationBudgetOfDeniedPatronages;
	Double minimumBudgetOfDeniedPatronages;
	Double maximumBudgetOfDeniedPatronages;
}
