package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorItemUpdateService implements AbstractUpdateService<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractUpdateService<Inventor, Item> -------------------------------------


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
	
		boolean result;
		int itemId;
		Item item;
		Inventor inventor;
		Principal principal;

		itemId = request.getModel().getInteger("id");
		item = this.repository.findOneItemById(itemId);
		
		inventor = item.getInventor();
		principal = request.getPrincipal();
		
		result = inventor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

//		if (entity.isPublished() == true) {
//			errors.add("published", "Item is published");
//		}
//
//		boolean published;
//
//		if(errors.hasErrors("published")) {
//			published = request.getModel().getBoolean("published");
//			errors.state(request, !published, "published", "javax.validation.constraints.AssertTrue.message");
//		}
		
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "technology", "description", "retailPrice", "link","type");
		
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "link","type");
//		model.setAttribute("published", false);
//		model.setAttribute("readonly", false);
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);

		return result;
	}

	@Override
	public void update(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
