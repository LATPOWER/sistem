package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Familiar;
import mx.com.simojica.persistence.repository.FamiliarRepository;

@Repository
public class FamiliarRepositoryImpl implements FamiliarRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Familiar guardarFamiliar(Familiar familiar) {
		
		 entityManager.persist(familiar);
		 
		 return familiar;
	}

}
