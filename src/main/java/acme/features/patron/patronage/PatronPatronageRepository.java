package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronages.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

	@Query("select i from Patronage i where i.id = :id")
	Patronage findOnePatronageById(int id);

	@Query("select c from Patronage c where c.patron.id = :patronId")
	Collection<Patronage> findManyPatronagesByPatronId(int patronId);

	
}
