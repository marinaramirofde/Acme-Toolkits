package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemShowService implements AbstractShowService<Inventor, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorItemRepository repository;

	// AbstractShowService<Inventor, Item> interface --------------


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		boolean result = false;
		
		 final int itemId = request.getModel().getInteger("id");
		 final Item item = this.repository.findOneItemById(itemId);
		 
		if(item.getInventor().getId() == request.getPrincipal().getActiveRoleId()) {
			result = true;
		}

		return result;
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
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "technology", "description", "retailPrice", "link","type", "published");
		
	}
	
}