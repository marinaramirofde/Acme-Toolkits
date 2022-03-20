package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{

	protected static final long serialVersionUID = 1L;

	/**
	 * COMPONENTS: Total number, average, deviation, minimum and maximum retail.
	 */
	int totalNumberOfComponents;
	Map<Pair<String,String>,Double> averageRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double> deviationRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double> minimumRetailPriceOfComponentsByTechnologyAndCurrency;
	Map<Pair<String,String>,Double>  maximumRetailPriceOfComponentsByTechnologyAndCurrency;


	/**
	 * TOOLS: Total number, average, deviation, minimum and maximum retail.
	 */
	int totalNumberOfTools;
	Map<String,Double> averageRetailPriceOfToolsByCurrency;
	Map<String,Double> deviationRetailPriceOfToolsByCurrency;
	Map<String,Double> minimumRetailPriceOfToolsByCurrency;
	Map<String,Double> maximumRetailPriceOfToolsByCurrency;

	/**
	 * Total number of pro-posed/accepted/denied patronages.
	 */
	int totalNumberOfProposedPatronages;
	int totalNumberOfAcceptedPatronages;
	int totalNumberOfDeniedPatronages;

	/**
	 *   PROPOSED PATRONAGES: Average, Deviation, Minimum and Maximum Budget 
	 */
	double averageBudgetOfProposedPatronages;
	double deviationBudgetOfProposedPatronages;
	double minimumBudgetOfProposedPatronages;
	double maximumBudgetOfProposedPatronages;

	 /**
   	 *   ACCEPTED PATRONAGES: Average, Deviation, Minimum and Maximum Budget 
   	 */
	double averageBudgetOfAcceptedPatronages;
	double deviationBudgetOfAcceptedPatronages;
	double minimumBudgetOfAcceptedPatronages;
	double maximumBudgetOfAcceptedPatronages;

	/**
   	 *   DENIED PATRONAGES: Average, Deviation, Minimum and Maximum Budget 
   	 */
	double averageBudgetOfDeniedPatronages;
	double deviationBudgetOfDeniedPatronages;
	double minimumBudgetOfDeniedPatronages;
	double maximumBudgetOfDeniedPatronages;
	
	/**
     *  POSIBLE OPTIMIZACIÓN: Map<Status, double> averageBudgetOfPatronagesByStatus
     */

}
