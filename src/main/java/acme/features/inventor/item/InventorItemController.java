package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.items.Item;
import acme.features.inventor.toolkit.InventorToolkitItemListService;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item> {

	// Internal state ---------------------------------------------------------


	@Autowired
	protected InventorItemShowService			showService;

	@Autowired
	protected InventorListMineItemService itemListMineService;
	
	@Autowired
	protected InventorToolkitItemListService inventorToolkitItemListService;
	
	@Autowired
	protected InventorItemCreateService		createService;

	@Autowired
	protected InventorItemUpdateService		updateService;

	@Autowired
	protected InventorItemDeleteService		deleteService;


	@Autowired
	protected InventorItemPublishService	publishService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		
		super.addCommand("show", this.showService);
		super.addCommand("create", this.createService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);
		
		super.addCommand("list-all-mine-items", "list", this.itemListMineService);
		super.addCommand("listToolkitItems", "list", this.inventorToolkitItemListService);
		
		super.addCommand("publish", "update", this.publishService);
		
	}

}