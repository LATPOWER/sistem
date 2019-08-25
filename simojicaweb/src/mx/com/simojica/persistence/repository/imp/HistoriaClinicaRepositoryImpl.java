package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.HistoriaClinica;
import mx.com.simojica.persistence.repository.HistoriaClinicaRepository;

@Repository
public class HistoriaClinicaRepositoryImpl implements HistoriaClinicaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public HistoriaClinica guardarHistoriaClinica(HistoriaClinica historiaClinica) {
		
		entityManager.persist(historiaClinica);
		return historiaClinica;
	}

}
