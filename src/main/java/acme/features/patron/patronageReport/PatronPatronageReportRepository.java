package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface PatronPatronageReportRepository extends AbstractRepository {

	@Query("select p from PatronageReport p where p.patronage.patron.id = :patronId")
	Collection<PatronageReport> findManyPatronageReportsByPatronId(int patronId);
	
	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findOne(int id);
	

}
