package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	
	protected static final long serialVersionUID = 1L;
	
	Integer totalNumberOfComponents;
	Double averageRetailPriceOfComponents;
	Double deviationRetailPriceOfComponents;
	Double minumimRetailPriceOfComponents;
	Double maximumRetailPriceOfComponents;
	
	Integer totalNumberOfTools;
	Double averageRetailPriceOfTools;
	Double deviationRetailPriceOfTools;
	Double minumimRetailPriceOfTools;
	Double maximumRetailPriceOfTools;

}
