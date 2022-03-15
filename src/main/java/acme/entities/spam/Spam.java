package acme.entities.spam;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Spam extends AbstractEntity {

	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
		
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
