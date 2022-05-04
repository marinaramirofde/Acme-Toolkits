package acme.features.inventor.patronageReports;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReports.PatronageReport;
import acme.entities.patronages.Patronage;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {

	@Query("select p from PatronageReport p where p.patronage.inventor.id = :inventorId")
	Collection<PatronageReport> findManyPatronageReportsByInventorId(int inventorId);
	
	@Query("select i from Patronage i where i.id = :id")
	Patronage findOnePatronageById(int id);
	
	@Query("select count(pr) from PatronageReport pr where pr.patronage.id = :id")
	Integer countPatronageReportWithPatronageId(int id);
	
	@Query("select pr from PatronageReport pr where pr.patronage.id = :id")
	Collection<PatronageReport> PatronageReportWithPatronageId(int id);
	
	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findOne(int id);

	@Query("select p from Patronage p where p.inventor.id = :id")
	List<Patronage> findPatronageByInventorId(int id);
	
	@Query("select p from Patronage p where p.code = :code")
	Patronage findPatronageByCode(String code);
}
