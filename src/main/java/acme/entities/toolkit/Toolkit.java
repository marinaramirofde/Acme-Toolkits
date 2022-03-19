package acme.entities.toolkit;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import acme.framework.entities.Quantity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@ManyToOne(optional = false)
	protected Quantity quantity;
	
	protected boolean published;
	
	@NotBlank
	@Length(min=1, max=100)
	protected String title;
	
	@NotBlank
	@Length(min=1, max=255)
	protected String description;
	
	@NotBlank
	@Length(min=1, max=255)
	protected String assemblyNotes;
	
	@URL
	protected String link;
	

}
