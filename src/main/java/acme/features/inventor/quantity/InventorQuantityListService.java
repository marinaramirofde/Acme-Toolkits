package acme.features.inventor.quantity;


import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class InventorQuantityListService implements AbstractListService<Inventor, Quantity>{
	
	@Autowired
	protected InventorQuantityRepository repository;
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		
		assert request != null;
		boolean result=false;
		final int toolkitId=request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(toolkitId);
		final int inventorId = toolkit.getInventor().getId();
		final int principalId= request.getPrincipal().getActiveRoleId();
		

		if(inventorId == principalId) {
			result=true;
		}

		
		return result;
	}

	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		
		final Collection<Quantity> result = new HashSet<Quantity>();
		final int toolkitId = request.getModel().getInteger("id");
		final Collection<Quantity> quantities = this.repository.findQuantityByToolkitId(toolkitId);
		result.addAll(quantities);
		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		final Integer toolkitId = request.getModel().getInteger("id");
		final Integer QuantityId=entity.getId();
		
		
		request.unbind(entity, model,"amount", "item.name", "item.code", "item.type"); 
		 
	}

}
