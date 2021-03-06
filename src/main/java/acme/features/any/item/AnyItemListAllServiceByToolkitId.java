package acme.features.any.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyItemListAllServiceByToolkitId implements AbstractListService<Any, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemRepository repository;

	// AbstractListService<Administrator, Item> interface --------------


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		assert request != null;

		Collection<Item> result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findAllItemsFromToolkitId(id);
		return result;
	}
	
	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Integer toolkitId = request.getModel().getInteger("id");
		final Integer itemId=entity.getId();
		final Integer amount=this.repository.findAmountFromItemIdAndToolkitId(itemId, toolkitId);
		model.setAttribute("amount", amount);
		request.unbind(entity, model, "name", "code", "type");
	}

}
