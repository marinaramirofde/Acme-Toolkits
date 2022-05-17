package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorQuantityShowService implements AbstractShowService<Inventor, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;

	// AbstractShowService<Inventor, Quantity> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		boolean result=false;
		final int quantityId=request.getModel().getInteger("id");
		final Quantity quantity = this.repository.findOneQuantityById(quantityId);
		final int inventorId = quantity.getToolkit().getInventor().getId();
		final int idPrincipal = request.getPrincipal().getActiveRoleId();
		
		if(inventorId == idPrincipal) {
			result=true;
		}

		return result;
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;

		Quantity result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		request.unbind(entity, model, "amount", "item.name", "item.code", "item.technology", "item.description", "item.retailPrice", "item.link","item.type", "item.published");
		model.setAttribute("confirmation", false);

	}
	
}