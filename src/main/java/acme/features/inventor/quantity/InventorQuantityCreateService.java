
package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityCreateService implements AbstractCreateService<Inventor, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;

	// AbstractCreateService<Inventor, Quantity> ---------------------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		boolean result;
		result = false;

		final Integer toolkitId = request.getModel().getInteger("masterId");
        final Toolkit toolkit = this.repository.findOneToolkitById(toolkitId);
        final Integer inventorId = toolkit.getInventor().getId();
        if(inventorId == request.getPrincipal().getActiveRoleId()) {
        	result=true;
        }

		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	
		
	
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		 
		final String itemCode = request.getModel().getString("item.code");
	    final Item item = this.repository.findOneItemByCode(itemCode);
	    
	    
	     
	    entity.setItem(item);
	    
		
	     request.bind(entity, errors, "amount", "item.code"); 
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Integer patronageId = request.getModel().getInteger("masterId");
		
		request.unbind(entity, model, "amount", "item.code");
		model.setAttribute("readonly", false);
		model.setAttribute("masterId", patronageId);
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;

		Quantity result;
		final Integer toolkitId = request.getModel().getInteger("masterId");

        final Toolkit toolkit=this.repository.findOneToolkitById(toolkitId);
        
		result = new Quantity();
		result.setToolkit(toolkit);
		result.setAmount(1);
		
	
		

		
		
		

		return result;
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		

				
		final String itemCode = request.getModel().getString("item.code");
	    final Item item = this.repository.findOneItemByCode(itemCode);
		
		entity.setItem(item);

		
		
		
		this.repository.save(entity);
	}

	

}
