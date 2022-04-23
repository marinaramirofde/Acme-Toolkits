package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageShowService implements AbstractShowService<Inventor, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageRepository repository;

	// AbstractShowService<Inventor, Patronage> interface --------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean result=false;
		final int patronageId=request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findOnePatronageById(patronageId);
		final int inventorId = patronage.getInventor().getId();
		final int idPrincipal = request.getPrincipal().getActiveRoleId();
		
		if(inventorId == idPrincipal) {
			result=true;
		}

		return result;
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOnePatronageById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Integer PatronId=entity.getPatron().getId();
		final String PatronFullName=entity.getPatron().getIdentity().getFullName();
		model.setAttribute("PatronId", PatronId);
		model.setAttribute("patronFullName", PatronFullName);
		
		request.unbind(entity, model, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status","patron.id","patron.company",
			"patron.info","patron.statement");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}
	
}