package acme.entities.patronages;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patronage extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotNull
	protected PatronageStatus status;
	
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	@Column(unique = true)
	protected String code;
	
	@NotBlank
	@Length(max=255)
	protected String legalStuff;
	
	@NotNull
	@Valid
	protected Money budget;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	protected Date period;
	
	@URL
	protected String info;
	
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
