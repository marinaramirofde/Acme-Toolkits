
package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.items.ItemType;
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
		
	
		
		if(!errors.hasErrors("amount")) {
			final Item item = entity.getItem();
			final Toolkit toolkit = entity.getToolkit();
			final Quantity q = this.repository.findQuantityFromItemIdAndToolkitId(item.getId(), toolkit.getId());
			if((q != null && q.getItem().getType()==ItemType.TOOL)
				||(entity.getAmount()>1 && entity.getItem().getType()==ItemType.TOOL)) {
				errors.state(request, false, "amount", "inventor.quantity.form.error.duplicated");
			}
		}
		if(!errors.hasErrors("item.code")) {
			Item existing;
			existing = this.repository.findItemNotPublishedByItemId(entity.getItem().getId());
			errors.state(request, existing == null, "item.code", "inventor.quantity.form.error.notpublished");
			
			
		}
	
		
	
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
	    final Integer itemId = item.getId();
	    final Integer toolkitId = request.getModel().getInteger("masterId");
        final Quantity q = this.repository.findQuantityFromItemIdAndToolkitId(itemId, toolkitId);
       
        
        
		entity.setItem(item);
        if(q!=null) {
        	q.setAmount(q.getAmount()+entity.getAmount());
        	this.repository.save(q);
        }
        else {
        	this.repository.save(entity);
        }
		
		
		
		
	}

	

}
