package acme.features.any.quantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.quantities.Quantity;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyQuantityController extends AbstractController<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyQuantityListAllService		listAllService;

	@Autowired
	protected AnyQuantityShowService			showService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-all-toolkits", "list", this.listAllService);
	}

}
