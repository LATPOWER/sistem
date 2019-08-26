package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Familiar;
import mx.com.simojica.persistence.repository.FamiliarRepository;

@Repository
public class FamiliarRepositoryImpl implements FamiliarRepository {
	
	private static final Logger LOGGER = LogManager.getLogger(FamiliarRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Familiar guardarFamiliar(Familiar familiar) {
		LOGGER.info(" guardarFamiliar ");
		 entityManager.persist(familiar);
		 return familiar;
	}

}
