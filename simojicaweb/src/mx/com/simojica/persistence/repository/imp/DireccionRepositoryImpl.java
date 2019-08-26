package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Direccion;
import mx.com.simojica.persistence.repository.DireccionRepository;

@Repository
public class DireccionRepositoryImpl implements DireccionRepository {

	private static final Logger LOGGER = LogManager.getLogger(DireccionRepositoryImpl.class);
			
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Direccion guardarDireccion(Direccion direccion) {
		LOGGER.info("guardarDireccion");
		entityManager.persist(direccion);
		return direccion;
	}
	
	

}
