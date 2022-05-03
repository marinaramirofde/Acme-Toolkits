
package acme.features.administrator.announcement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorAnnouncementRepository repository;

	// AbstractCreateService<Administrator, Announcement> ---------------------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		
		boolean result;
		
		result = request.getPrincipal().hasRole(Administrator.class); 

		return result;
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;
		
		
		

		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "title", "creationMoment", "critical", "body", "link");
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		

		request.unbind(entity, model, "title", "creationMoment", "critical", "body", "link");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", false);
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;

		Announcement result;
		Date creationMoment;
		creationMoment = new Date(System.currentTimeMillis() - 1);

		
        
		result = new Announcement();
		

		result.setCreationMoment(creationMoment);

		

		
		
		

		return result;
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;
		Date moment;

				
        
		
		moment = new Date(System.currentTimeMillis() - 1);
		
		entity.setCreationMoment(moment);
		
		
		this.repository.save(entity);
	}

	

}
