package acme.entities.toolkit;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.component.Component;
import acme.entities.tool.Tool;
import acme.framework.entities.AbstractEntity;
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
	
	@ManyToMany(cascade={CascadeType.ALL})
	protected Set<Component> components;
	
	@ManyToMany(cascade={CascadeType.ALL})
	protected Set<Tool> tools;
	
	@NotEmpty
	@Length(min=1, max=100)
	protected String title;
	
	@NotEmpty
	@Length(min=1, max=255)
	protected String description;
	
	@NotEmpty
	@Length(min=1, max=255)
	protected String assemblyNotes;
	
	@URL
	protected String link;
	

}
