/*
 * InventorQuantityUpdateService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.ItemType;
import acme.entities.quantities.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorQuantityDeleteService implements AbstractDeleteService<Inventor, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;

	// AbstractUpdateService<Inventor, Quantity> interface -----------------


	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		boolean result;
		int quantityId;
		final Quantity quantity;

		quantityId = request.getModel().getInteger("id");
		quantity = this.repository.findOneQuantityById(quantityId);
		
		result =  request.isPrincipal(quantity.getToolkit().getInventor()) && !quantity.getToolkit().isPublished();


		return result;

	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("amount")) {
			final int amount = entity.getAmount();
			final ItemType itemType = entity.getItem().getType();
			if(amount>1 && itemType==ItemType.TOOL) {
				errors.state(request, false, "amount","inventor.quantity.form.error.duplicated");
			}
		}
		
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "amount");
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		final Boolean result = request.isPrincipal(entity.getToolkit().getInventor()) && !entity.getToolkit().isPublished();
		model.setAttribute("canBeModified", result);
		request.unbind(entity, model, "amount");
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;

		final Integer id = request.getModel().getInteger("id");
	


		return this.repository.findOneQuantityById(id);
	}

	@Override
	public void delete(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

	

}
