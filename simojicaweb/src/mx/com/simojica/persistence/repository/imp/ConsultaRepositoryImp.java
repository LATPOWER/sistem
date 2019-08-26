package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Consulta;
import mx.com.simojica.persistence.repository.ConsultaRepository;

@Repository
public class ConsultaRepositoryImp implements ConsultaRepository{

	private static final Logger LOGGER = LogManager.getLogger(ConsultaRepositoryImp.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Consulta guardarConsulta(Consulta consulta) {
		LOGGER.info("Guardando consulta");
		entityManager.persist(consulta);
		return consulta;
	}

	@Override
	public long getConsultaPkSequence() {
		
		return 0;
	}
	
	
	
}
