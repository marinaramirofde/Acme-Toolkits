package acme.features.inventor.patronageReports;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("select p from PatronageReport p where p.patronage.id = :masterId")
	Collection<PatronageReport> findManyPatronageReportsByMasterId(int masterId);
	
	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findOne(int id);
	
	@Query("select p.patronage from PatronageReport p where p.patronage.id = :masterId")
	Patronage findOnePatronageByPatronageId(int masterId);

}
