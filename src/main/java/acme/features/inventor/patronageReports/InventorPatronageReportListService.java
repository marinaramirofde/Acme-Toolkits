package acme.features.inventor.patronageReports;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportListService implements AbstractListService<Inventor, PatronageReport> {
	
	@Autowired
	protected InventorPatronageReportRepository repository;

	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		int masterId;
		Patronage patronage;
		
		masterId = request.getModel().getInteger("masterId");
		patronage = this.repository.findOnePatronageByPatronageId(masterId);
		result = true;
		if(patronage != null) result = request.isPrincipal(patronage.getInventor());

		return result;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		assert request != null;
		
		Collection<PatronageReport> result;
		int masterId;

		masterId = request.getModel().getInteger("masterId");
		result = this.repository.findManyPatronageReportsByMasterId(masterId);

		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sequenceNumber", "creationMoment", "memorandum", "info", "patronage");
		
	}

}
