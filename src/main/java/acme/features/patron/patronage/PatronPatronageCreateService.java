
package acme.features.patron.patronage;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
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
			errors.state(request, entity.getStartMoment().before(entity.getCreationMoment()), "startMoment", "patron.patronage.form.error.invalid-date-start-moment");
		}
		
		if(!errors.hasErrors("endMoment")) {
			errors.state(request, entity.getEndMoment().after(entity.getCreationMoment()) && entity.getEndMoment().after(entity.getStartMoment()), "endMoment", "patron.patronage.form.error.invalid-date-end-moment");
		}
	
		
	
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		 
		final Integer inventorId = request.getModel().getInteger("inventor.id");
	    final Inventor inventor = this.repository.findOneInventorById(inventorId);
	    
	    
	    
	    entity.setInventor(inventor);
	    
		
	     request.bind(entity, errors, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status","inventor.id"); 
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Collection<Inventor> inventors = this.repository.findAllInventors();
		request.unbind(entity, model, "budget", "code", "creationMoment", "endMoment", "info", 
			"legalStuff","startMoment","status","inventor.id");
		model.setAttribute("readonly", false);
		model.setAttribute("inventors",inventors);
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		Patronage result;
		final Date moment = new Date(System.currentTimeMillis() - 1);
		final Date  startMoment = new Date(System.currentTimeMillis()-10);
		final Date endMoment = new Date(System.currentTimeMillis() + 3600000);
		final Money budget= new Money();
		budget.setAmount(215.5);
		budget.setCurrency("EUR");
	
		
        final Integer patronId = request.getPrincipal().getActiveRoleId();
        final Patron patron = this.repository.findOnePatronById(patronId);
      
        
		result = new Patronage();
		result.setCreationMoment(moment);
		result.setStartMoment(startMoment);
		result.setBudget(budget);
		result.setPatron(patron);
		result.setEndMoment(endMoment);
		result.setPublished(false);
		result.setCode("ABB-127");
		result.setLegalStuff("Example 1");
		

		
		
		

		return result;
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		Date moment;

				
        final Integer inventorId = request.getModel().getInteger("inventor.id");
        final Inventor inventor = this.repository.findOneInventorById(inventorId);
		
		moment = new Date(System.currentTimeMillis() - 1);
		
		entity.setInventor(inventor);
		entity.setCreationMoment(moment);
		
		
		
		this.repository.save(entity);
	}

	

}
