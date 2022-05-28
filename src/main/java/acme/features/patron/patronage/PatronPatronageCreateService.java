
package acme.features.patron.patronage;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.entities.patronages.PatronageStatus;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractCreateService<Patron, Patronage> ---------------------------


	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;
		
		boolean result;
		
		result = request.getPrincipal().hasRole(Patron.class); 

		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("code")) {
			final Patronage existing = this.repository.findOnePatronageByCode(entity.getCode());
			errors.state(request,existing==null, "code", "patron.patronage.form.error.duplicated-code");
		}
		
		if(!errors.hasErrors("startMoment")) {
			
			final Date minCreationDate = DateUtils.addMonths(entity.getCreationMoment(), 1);
			
			errors.state(request,entity.getStartMoment().after(minCreationDate),
				"startMoment", "patron.patronage.form.error.min-one-month-later");
			
		}
		
		if(!errors.hasErrors("endMoment")) {
			
			final Date minStartDate = DateUtils.addMonths(entity.getStartMoment(), 1);
			
			errors.state(request,entity.getEndMoment().after(minStartDate),
				"endMoment", "patron.patronage.form.error.after-start-date");
			
		}
	
		
	
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		 
		final Integer inventorId = Integer.valueOf(request.getModel().getAttribute("inventorId").toString());
	    final Inventor inventor = this.repository.findOneInventorById(inventorId);
	    
	    
	    
	    entity.setInventor(inventor);
	    
		
	     request.bind(entity, errors, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status","inventorId"); 
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Collection<Inventor> inventors = this.repository.findAllInventors();
		
		request.unbind(entity, model, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status");
		
		model.setAttribute("readonly", false);
		model.setAttribute("inventors",inventors);
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		
		final Date moment = new Date(System.currentTimeMillis() - 1);
			
        final Integer patronId = request.getPrincipal().getActiveRoleId();
        final Patron patron = this.repository.findOnePatronById(patronId);
   
        
		result = new Patronage();
		result.setCreationMoment(moment);
		result.setPatron(patron);
		result.setStatus(PatronageStatus.PROPOSED);
		result.setInventor(this.repository.findManyInventors().get(0));
		
		
		return result;
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		Date moment;

		
		moment = new Date(System.currentTimeMillis() - 1);
		
		
		entity.setCreationMoment(moment);
		
		if(entity.getStatus()!=PatronageStatus.PROPOSED && entity.getStatus()!=PatronageStatus.ACCEPTED
			&& entity.getStatus()!=PatronageStatus.DENIED) {
			entity.setStatus(PatronageStatus.PROPOSED);
		}
		
		
		
		this.repository.save(entity);
	}

	

}
