package acme.forms;

import java.io.Serializable;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable{

	protected static final long    serialVersionUID= 1L;

	/**
	 * Total number of pro-posed/accepted/denied patronages.
	 */
	int totalNumberOfProposedPatronages;
    int totalNumberOfAcceptedPatronages;
    int totalNumberOfDeniedPatronages;

    /**
	 *   PROPOSED PATRONAGES: Average, Deviation, Minimum and Maximum Budget  ByCurrencyAndStatus
	 */
    Map<String, Double> averageBudgetOfProposedPatronagesByCurrency;
    Map<String, Double> deviationBudgetOfProposedPatronagesByCurrency;
    Map<String, Double> minimumBudgetOfProposedPatronagesByCurrency;
    Map<String, Double> maximumBudgetOfProposedPatronagesByCurrency;

    /**
   	 *   ACCEPTED PATRONAGES: Average, Deviation, Minimum and Maximum Budget  ByCurrencyAndStatus
   	 */
    Map<String, Double> averageBudgetOfAcceptedPatronagesByCurrency;
    Map<String, Double> deviationBudgetOfAcceptedPatronagesByCurrency;
    Map<String, Double> minimumBudgetOfAcceptedPatronagesByCurrency;
    Map<String, Double> maximumBudgetOfAcceptedPatronagesByCurrency;

    /**
   	 *   DENIED PATRONAGES: Average, Deviation, Minimum and Maximum Budget  ByCurrencyAndStatus
   	 */
    Map<String, Double> averageBudgetOfDeniedPatronagesByCurrency;
    Map<String, Double> deviationBudgetOfDeniedPatronagesByCurrency;
    Map<String, Double> minimumBudgetOfDeniedPatronagesByCurrency;
    Map<String, Double> maximumBudgetOfDeniedPatronagesByCurrency;
	
    /**
     *  POSIBLE OPTIMIZACIÓN: Map<Pair<Status,String>,Double> averageBudgetOfPatronagesByCurrencyAndStatus
     */
}
