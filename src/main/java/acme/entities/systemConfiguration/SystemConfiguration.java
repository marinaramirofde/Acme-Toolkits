package acme.entities.systemConfiguration;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfiguration extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
		
		@NotBlank
		protected String systemCurrency;
		
		@NotNull
		@ElementCollection()
		protected List<String> acceptedCurrencies;
		
		@NotNull
		@Min(1)
		@Max(100)
		protected double strongThreshold;
		
		@NotNull
		@ElementCollection()
		protected List<String> strongTerms;
		
		@NotNull
		@Min(1)
		@Max(100)
		protected double weakThreshold;
		
		@NotNull
		@ElementCollection()
		protected List<String> weakTerms;
		
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
}
