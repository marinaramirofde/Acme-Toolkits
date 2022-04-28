package acme.features.inventor.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.entities.patronages.PatronageStatus;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageUpdateService implements AbstractUpdateService<Inventor, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageRepository repository;

	// AbstractUpdateService<Inventor, Patronage> interface -----------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		boolean result;
		int patronageId;
		Patronage patronage;

		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findOnePatronageById(patronageId);
		
		result = patronage != null && 
			patronage.getStatus().equals(PatronageStatus.PROPOSED) && 
			request.isPrincipal(patronage.getInventor());

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
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status");
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status");
		
		model.setAttribute("inventorId", entity.getInventor().getId());
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
//		@Column(unique = true)
//		protected String code;
		if(!errors.hasErrors("code")) {
			Patronage existing;
			existing = this.repository.findOnePatronageByCode(entity.getCode());
			errors.state(request, existing == null || existing.getId() == entity.getId(), "code", "inventor.patronage.form.error.duplicated");
		}
		
//		MONEY
//		@Digits(integer = 10, fraction = 2)
//		protected Double			amount;
		if(!errors.hasErrors("budget")) {
			errors.state(request, entity.getBudget().getAmount() > 0, "budget", "inventor.patronage.form.error.negative-amount");
		}
		
		// AÑADIR RESTRICCIÓN DE LA FECHA ---------------------------------------------------------------
				// 	endMoment << startMoment << creationMoment;
		if(!errors.hasErrors("startMoment")) {
//			Calendar calendar;
//			Date minimumDate;
//
//			calendar = entity.getCreationMoment();
//			calendar.add(Calendar.WEEK_OF_MONTH, 1);
//			minimumDate = calendar.getTime();
			
		//	errors.state(request, endMoment() > entity.getStartMoment() > creationMoment()+1 Month, "startMoment", "inventor.patronage.form.error.time-fail");
		}

	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
