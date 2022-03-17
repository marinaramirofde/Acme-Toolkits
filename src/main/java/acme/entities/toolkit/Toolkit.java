package acme.entities.toolkit;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import acme.framework.entities.AbstractEntity;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.Setter;

import acme.entities.component.Component
import acme.entities.tool.Tool

@Entity
@Getter
@Setter
public class Toolkit extends AbstractEntity {
	
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{3}-[0-9]{3}(-[A-Z])?$")
	protected String code;
	
	@ManyToMany(cascade={CascadeType.ALL})
	protected Set<Component> components;
	
	@ManyToMany(cascade={CascadeType.ALL})
	protected Set<Tool> tools;
	
	@NotEmpty
	@Length(min=1, max=101)
	protected String title;
	
	@NotEmpty
	@Length(min=1, max=256)
	protected String description;
	
	@NotEmpty
	@Length(min=1, max=256)
	protected String assemblyNotes;
	
	@URL
	protected String link;
	

}
