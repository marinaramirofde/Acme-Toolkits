
package acme.features.inventor.patronageReports;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;

	// AbstractCreateService<Inventor, PatronageReport> ---------------------------


	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		
		result = request.getPrincipal().hasRole(Inventor.class); 

		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;
		//String sN1;
		//String code1;
		//Patronage patronage1;
		//sN1 = entity.getSequenceNumber();
		//code1 = sN1.split(":")[0];
		//patronage1 = this.repository.findPatronageByCode(code1);
		//patronage1 = entity.getPatronage();
		
		

		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
		//errors.state(request, patronage1!=null, "sequenceNumber","error");
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "sequenceNumber", "creationMoment", "memorandum", "info");
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Integer patronageId = request.getModel().getInteger("masterId");

		request.unbind(entity, model, "sequenceNumber", "creationMoment", "memorandum", "info");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", false);
		model.setAttribute("masterId", patronageId);
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis() - 1);
		
		final Integer patronageId = request.getModel().getInteger("masterId");
		final Patronage patronage = this.repository.findOnePatronageById(patronageId);
	    final Integer nPR=this.repository.countPatronageReportWithPatronageId(patronageId);
	    final String nPRformatted = String.format("%04d", nPR);	    
	    final String sequenceNumber=patronage.getCode()+":"+nPRformatted;
		
        
		result = new PatronageReport();
		result.setPatronage(patronage);
		result.setCreationMoment(creationMoment);
		result.setSequenceNumber(sequenceNumber);
		

		
		
		

		return result;
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;
		Date moment;

				
        
		
		moment = new Date(System.currentTimeMillis() - 1);
		
		entity.setCreationMoment(moment);
		
		
		this.repository.save(entity);
	}

	

}
