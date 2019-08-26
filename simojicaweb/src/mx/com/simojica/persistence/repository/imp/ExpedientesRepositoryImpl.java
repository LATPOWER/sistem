package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.persistence.entity.Expedientes;
import mx.com.simojica.persistence.repository.ExpedientesRepository;

@Repository
public class ExpedientesRepositoryImpl implements ExpedientesRepository{
	
	private static final Logger LOGGER = LogManager.getLogger(ExpedientesRepositoryImpl.class);
			
	 @PersistenceContext
	    private EntityManager entityManager;
	  
	
	  @Transactional
	  public Expedientes persiste(Expedientes expedientes ) throws ExpedientesException {
		  LOGGER.info("ExpedientesRepository persiste ");
		  entityManager.persist(expedientes);
		  LOGGER.info(" flush");
		  entityManager.flush();
		  LOGGER.info("id expediente es :"+expedientes.getIdExpediente());
		  return expedientes;
	  }
	  
	  @Transactional
	  public Expedientes merge(Expedientes expediente ) throws ExpedientesException {
		  LOGGER.info("ExpedientesRepository merge ");
		  LOGGER.info("ExpedientesRepository merge after direccion "+expediente.getIdDirecion());
		  entityManager.merge(expediente);
		  entityManager.flush();
		  LOGGER.info("id expediente es :"+expediente.getIdExpediente());
		  return expediente;
	  }

}
