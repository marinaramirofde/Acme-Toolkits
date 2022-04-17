package acme.features.any.patron;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;
import acme.roles.Patron;

@Controller
public class AnyPatronController extends AbstractController<Any, Patron> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyPatronListAllService		listAllService;

	@Autowired
	protected AnyPatronShowService			showService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-all-patrons", "list", this.listAllService);
	}

}
