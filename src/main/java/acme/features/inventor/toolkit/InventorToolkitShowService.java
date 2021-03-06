package acme.features.inventor.toolkit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor,Toolkit> {

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		boolean result = false;
		
		final int toolkitId = request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findOneToolkitById(toolkitId);
		
		final int inventorId = toolkit.getInventor().getId();
		final int idPrincipal = request.getPrincipal().getActiveRoleId();
		
		if(inventorId == idPrincipal) {
			result = true;
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
			
			
        Double nPrice;
    			
		nPrice=this.repository.findPriceOfToolkitByToolkitId(toolkitId);
		final List<String> lsPrice=this.repository.findMoneyTypePriceOfToolkitByToolkitId(toolkitId);
		String sPrice;
		if(!lsPrice.isEmpty()) {
		sPrice = lsPrice.get(0);
		}
		else {
	    sPrice = "EUR";
	    nPrice=0.0;
		}
		final Money resultPrice=new Money();
		
		resultPrice.setAmount(nPrice);
		resultPrice.setCurrency(sPrice);
		
        Boolean itemPresence;
		itemPresence=true;
		
		
		if(resultPrice.getAmount()==0) {
			itemPresence=false;
		}
		model.setAttribute("itemPresence", itemPresence);
        model.setAttribute("retailPrice", resultPrice);
		request.unbind(entity, model, "code", "title","description","assemblyNotes", "link","published");
		
		model.setAttribute("confirmation", false);
	
		
	}

}
