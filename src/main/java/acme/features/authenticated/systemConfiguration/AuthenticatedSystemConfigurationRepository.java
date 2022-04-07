package acme.features.authenticated.systemConfiguration;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.systemConfigurations.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedSystemConfigurationRepository extends AbstractRepository{
	
	@Query("SELECT s FROM SystemConfiguration s")
	Collection<SystemConfiguration> findSystemConfiguration();
	

}
