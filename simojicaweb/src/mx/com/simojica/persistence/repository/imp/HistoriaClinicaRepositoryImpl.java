package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.HistoriaClinica;
import mx.com.simojica.persistence.repository.HistoriaClinicaRepository;

@Repository
public class HistoriaClinicaRepositoryImpl implements HistoriaClinicaRepository{
	
	private static final Logger LOGGER = LogManager.getLogger(HistoriaClinicaRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
		LOGGER.debug("guardarHistoriaClinica ");
		entityManager.persist(historiaClinica);
		return historiaClinica;
	}

}
