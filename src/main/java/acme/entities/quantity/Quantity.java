package acme.entities.quantity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import acme.entities.toolkit.Toolkit;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Quantity extends AbstractEntity{
	
	protected static final long serialVersionUID = 1L;
	
	@Min(1)
	protected int amount;
	
	@NotEmpty
	@ManyToOne(optional = false)
	protected Item item;
	
	@NotEmpty
	@ManyToOne(optional = false)
	protected Toolkit toolkit;


}
