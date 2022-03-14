package acme.forms;

import java.io.Serializable;

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

	// ----- budget:
	
	// Deviation ----------> USAR: stddev()
	// minimum 
	// maximum  
	//proposed 
	//accepted
	//denied 
	//       ... patronages grouped by currency.
}
