package acme.features.any.patron;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface AnyPatronRepository extends AbstractRepository {

	@Query("select q from Patron q where q.id = :id")
	Patron findOnePatronById(int id);

	@Query("select q from Patron q")
	Collection<Patron> findAllPatrons();
	
	

}
