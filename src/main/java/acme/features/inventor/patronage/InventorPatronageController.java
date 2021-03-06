package acme.features.inventor.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronages.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorPatronageController extends AbstractController<Inventor, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageShowService			showService;

	@Autowired
	protected InventorPatronageListMineService patronagesListMineService;
	
	@Autowired
	protected InventorPatronageUpdateService 	   updateService;


	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("update", this.updateService);
		
		super.addCommand("list-all-mine-patronages", "list", this.patronagesListMineService);
		
	}

}