package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyUserAccountRepository extends AbstractRepository {

	@Query("select q from UserAccount q where q.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("select u from UserAccount u join u.roles r where u.enabled = 1 and "
	+ "Administrator not in (select type(r2) from UserAccount u2 join u2.roles r2 "
	+ "where u2.id = u.id)")
    Collection<UserAccount> findUserAccounts();
	
	

}
