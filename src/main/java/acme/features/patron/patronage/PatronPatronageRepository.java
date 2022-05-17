package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository {

	@Query("select i from Patronage i where i.id = :id")
	Patronage findOnePatronageById(int id);
	
	@Query("select i from Inventor i")
	Collection<Inventor> findAllInventors();

	@Query("select c from Patronage c where c.patron.id = :patronId")
	Collection<Patronage> findManyPatronagesByPatronId(int patronId);
	
	@Query("select i from Patron i where i.id = :id")
	Patron findOnePatronById(int id);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findOneInventorById(int id);
	
	@Query("select t from Patronage t where t.code = :code")
	Patronage findOnePatronageByCode(String code);

	@Query("select pr from PatronageReport pr where pr.patronage.id = :id")
	Collection<PatronageReport> findPatronageReportsByPatronageId(int id);



	
}
