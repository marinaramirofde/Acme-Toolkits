package acme.features.inventor.toolkit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor,Toolkit> {

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		
		assert request != null;
		boolean result=false;
		final int toolkitId=request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(toolkitId);
		final int inventorId = toolkit.getInventor().getId();
		final int idPrincipal = request.getPrincipal().getActiveRoleId();
		
		if(inventorId == idPrincipal) {
			result=true;
		}
		return result;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		
		assert request != null;
		Toolkit result;
		final int toolkitId = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(toolkitId);	
		
		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final int toolkitId = request.getModel().getInteger("id");
		final Double retailPrice = this.repository.retailPriceOfToolkitById(toolkitId);
		model.setAttribute("retailPrice", retailPrice);

		request.unbind(entity, model, "code", "title","description","assemblyNotes", "link", "inventor.userAccount.username");
		
	}

}
