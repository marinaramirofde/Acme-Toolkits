package acme.features.administrator.announcement;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorAnnouncementShowService implements AbstractShowService<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------
	
		@Autowired
		protected AdministratorAnnouncementRepository repository;
	
	// AbstractListService<Administrator, Announcement> interface --------------
	
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		
		boolean result;
		Calendar calendar;
		Date deadline;
		Announcement announcement;
		int id;
		
		calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		deadline = calendar.getTime();
		
		id = request.getModel().getInteger("id");
		announcement = this.repository.find0neAnnouncementById(id);
		result = announcement.getCreationMoment().after(deadline);
		
		return result;
	}

	@Override
	public Announcement findOne(final Request<Announcement> request) {
		assert request != null;
		
		Announcement result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.find0neAnnouncementById(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "creationMoment", "critical", "body", "link");
		model.setAttribute("confirmation", false);
	}

}
