package acme.features.any.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyQuantityListAllService implements AbstractListService<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyQuantityRepository repository;

	// AbstractListService<Administrator, Quantity> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		assert request != null;

		Collection<Quantity> result;

		result = this.repository.findAllToolkits();

		return result;
	}
	
	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "toolkit.title", "toolkit.code", "toolkit.description","item.name");
	}

}
