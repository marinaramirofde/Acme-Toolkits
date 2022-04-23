
package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;


@Service
public class AnyUserAccountListAllService implements AbstractListService<Any, UserAccount> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyUserAccountRepository repository;

	// AbstractListService<Administrator, UserAccount> interface --------------


	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;

		result = this.repository.findUserAccounts();
		
		for(final UserAccount user:result) {
			user.getRoles().forEach(r->{});
		}

		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		 
		final Collection<UserRole> R=entity.getRoles();
		  final StringBuilder cache = new StringBuilder();
	        for (final UserRole role : R) {
	            cache.append(role.getAuthorityName());
	        }


	        model.setAttribute("roleList", cache.toString());
            request.unbind(entity, model, "identity.name", "identity.surname");
		
	}

}
