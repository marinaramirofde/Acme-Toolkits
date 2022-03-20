package acme.entities.systemConfiguration;

import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

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
	
	@NotBlank
	protected String acceptedCurrencies;

	@NotBlank
	protected String strongTerms;

	@Range(min = 0, max = 100)
	@Digits(integer = 2, fraction = 2)
	protected double strongThreshold;

	@NotBlank
	protected String weakTerms;

	@Range(min = 0, max = 100)
	@Digits(integer = 2, fraction = 2)
	protected double weakThreshold;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
}
