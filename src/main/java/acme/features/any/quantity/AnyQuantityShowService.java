package acme.features.any.quantity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyQuantityShowService implements AbstractShowService<Any, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyQuantityRepository repository;

	// AbstractShowService<Administrator, Quantity> interface --------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final int quantityId = request.getModel().getInteger("id");
		final Quantity quantity = this.repository.findOneToolkitById(quantityId);
	
		return quantity.getToolkit().isPublished();
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;

		Quantity result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model)  {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Integer toolkitId = entity.getToolkit().getId();		
		final Double nPrice=this.repository.findPriceOfToolkitByToolkitId(toolkitId);
		final List<String> lsPrice=this.repository.findMoneyTypePriceOfToolkitByToolkitId(toolkitId);
		final String sPrice = lsPrice.get(0);
		final Money price=new Money();
		
		price.setAmount(nPrice);
		price.setCurrency(sPrice);
		
        model.setAttribute("ToolkitId", toolkitId);
        model.setAttribute("price", price);
		request.unbind(entity, model,"toolkit.assemblyNotes", "toolkit.code","toolkit.description","toolkit.link","toolkit.published","toolkit.title","item.name","item.id");
	
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", true);
	}
	
}
