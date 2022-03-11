package acme.entities.announcement;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Announcement extends AbstractEntity{

	protected static final long serialVersionUID= 1L;
	
	@NotNull
	protected Date creationMoment;
	
	@NotBlank
	@Length(min=1, max=101)
	protected String title;
	
	@NotBlank
	@Length(min=1, max=256)
	protected String body;
	
	@NotNull
	protected Boolean critical;
	
	@URL
	protected String link;
	
}
