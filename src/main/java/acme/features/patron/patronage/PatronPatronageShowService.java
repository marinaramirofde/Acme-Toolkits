package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractShowService<Patron, Patronage> interface --------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		boolean result=false;
		final int patronageId=request.getModel().getInteger("id");
		final Patronage patronage = this.repository.findOnePatronageById(patronageId);
		final int patronId = patronage.getPatron().getId();
		final int idPrincipal = request.getPrincipal().getActiveRoleId();
		
		if(patronId == idPrincipal) {
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
		final String inventorFullName=entity.getInventor().getIdentity().getFullName();
		model.setAttribute("inventorFullName", inventorFullName);
		
		request.unbind(entity, model, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status","inventor.id","inventor.company",
			"inventor.info","inventor.statement");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}
	
}