package acme.entities.quantity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import acme.entities.toolkit.Toolkit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@NotNull
	@Min(1)
	protected Integer number;
	
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Toolkit toolkit;
	
	@ManyToOne(optional = false)
	@Valid
	@NotNull
	protected Item item;
}
