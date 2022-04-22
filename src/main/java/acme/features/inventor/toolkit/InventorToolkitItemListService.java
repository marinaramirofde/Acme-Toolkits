package acme.features.inventor.toolkit;


import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service 
public class InventorToolkitItemListService implements AbstractListService<Inventor, Item>{
	
	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		
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
	public Collection<Item> findMany(final Request<Item> request) {
		
		final Collection<Item> result = new HashSet<Item>();
		final int toolkitId = request.getModel().getInteger("id");
		final Collection<Quantity> quantities = this.repository.findQuantityByToolkitId(toolkitId);
		for(final Quantity quantity: quantities) {
			final int id=quantity.getId();
			final Collection<Item> items=this.repository.findManyItemByQuantityId(id);
			result.addAll(items);
		}
		
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		
		final Integer toolkitId = request.getModel().getInteger("id");
		final Integer itemId=entity.getId();
		final Integer amount=this.repository.findAmountFromItemIdAndToolkitId(itemId, toolkitId);
		model.setAttribute("amount", amount);
		
		request.unbind(entity, model, "name", "code", "type"); 
		 
	}

}
