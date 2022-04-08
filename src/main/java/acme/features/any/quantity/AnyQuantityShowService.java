package acme.features.any.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyQuantityShowService implements AbstractShowService<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyQuantityRepository repository;

	// AbstractShowService<Administrator, Quantity> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		return true;
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;

		Quantity result;
		int id;
		
		
		
		

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model)  {
		assert request != null;
		assert entity != null;
		assert model != null;
        model.setAttribute("ItemId", entity.getItem().getId());
		request.unbind(entity, model,"toolkit.assemblyNotes", "toolkit.code","toolkit.description","toolkit.link","toolkit.published","toolkit.title","item.name","item.id");
		
		
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}
	
}
