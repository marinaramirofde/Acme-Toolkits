package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkits.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Toolkit>{
	// Internal state ---------------------------------------------------------

			@Autowired
			protected InventorToolkitListService		toolkitListService;
			

			@Autowired
			protected InventorToolkitShowService	showService;
			
			@PostConstruct
			protected void initialise() {
				super.addCommand("list", "list", this.toolkitListService);
				super.addCommand("show", this.showService);
			}
}
