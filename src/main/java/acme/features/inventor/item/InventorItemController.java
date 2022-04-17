package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemShowService			showService;

	@Autowired
	protected InventorComponentListMineService componentListMineService;
	
	@Autowired
	protected InventorToolListMineService toolListMineService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list-all-mine-components", "list", this.componentListMineService);
		super.addCommand("list-all-mine-tools", "list", this.toolListMineService);
		
	}

}