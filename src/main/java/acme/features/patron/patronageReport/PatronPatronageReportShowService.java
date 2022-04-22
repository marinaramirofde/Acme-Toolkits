package acme.features.patron.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageReportShowService implements AbstractShowService<Patron, PatronageReport> {

	@Autowired
	protected PatronPatronageReportRepository repository;
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		int patronageReportId;
		PatronageReport patronageReport;
		
		patronageReportId = request.getModel().getInteger("id");
		
		patronageReport = this.repository.findOne(patronageReportId);
		
		result = patronageReport.getPatronage().getPatron().getId() == request.getPrincipal().getActiveRoleId();
		return result;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;
		
		PatronageReport result;
		int patronageReportId;
		
		patronageReportId = request.getModel().getInteger("id");
		result = this.repository.findOne(patronageReportId);
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "sequenceNumber", "creationMoment", "memorandum", "info");
	}
	
}
