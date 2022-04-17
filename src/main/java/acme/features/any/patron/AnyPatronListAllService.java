
package acme.features.any.patron;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class AnyPatronListAllService implements AbstractListService<Any, Patron> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyPatronRepository repository;

	// AbstractListService<Administrator, Patron> interface --------------


	@Override
	public boolean authorise(final Request<Patron> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Patron> findMany(final Request<Patron> request) {
		assert request != null;

		Collection<Patron> result;

		result = this.repository.findAllPatrons();

		return result;
	}

	@Override
	public void unbind(final Request<Patron> request, final Patron entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "info", "statement");
	}

}
