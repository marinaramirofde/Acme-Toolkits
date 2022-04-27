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
public class InventorItemPublishService implements AbstractUpdateService<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractUpdateService<Inventor, Item> interface ---------------------------


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
		
		result = !item.isPublished() && inventor.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
//		@Column(unique=true)
//		protected String code;
		if(errors.hasErrors("code")) {
			Item existing;
			existing = this.repository.findOneItemByCode(entity.getCode());
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "inventor.item.form.error.duplicated");
		}
		
//		@Digits(integer = 10, fraction = 2)
//		protected Double			amount;
		if(!errors.hasErrors("retailPrice")) {
			errors.state(request, entity.getRetailPrice().getAmount() > 0, "retailPrice", "inventor.item.form.error.negative-amount");
		}
		
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

		entity.setPublished(true);
		this.repository.save(entity);
	}

}
