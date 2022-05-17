package acme.features.inventor.patronageReports;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportListService implements AbstractListService<Inventor, PatronageReport> {
	
	@Autowired
	protected InventorPatronageReportRepository repository;

	/**
	 *  No hace falta añadir nada el Framework se encarga de
	 *   sasociar las listas al poner AbstractListService
	 **/
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		assert request != null;
		
		Collection<PatronageReport> result;
		Principal principal;
		principal = request.getPrincipal();
		final Boolean mId = request.getModel().hasAttribute("masterId");
		
		if(Boolean.TRUE.equals(mId)) {
			final Integer patronageId=request.getModel().getInteger("masterId");
			result =this.repository.patronageReportWithPatronageId(patronageId);
		}
		else {
		result = this.repository.findManyPatronageReportsByInventorId(principal.getActiveRoleId());
		}

		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("patronageId", entity.getPatronage().getId());
		request.unbind(entity, model, "creationMoment");
		
	}

}
