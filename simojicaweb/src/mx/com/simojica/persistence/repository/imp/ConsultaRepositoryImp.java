package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Consulta;
import mx.com.simojica.persistence.repository.ConsultaRepository;

@Repository
public class ConsultaRepositoryImp implements ConsultaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Consulta guardarConsulta(Consulta consulta) {
		System.out.println("Guardando consulta");
		entityManager.persist(consulta);
		return consulta;
	}

	@Override
	public long getConsultaPkSequence() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
