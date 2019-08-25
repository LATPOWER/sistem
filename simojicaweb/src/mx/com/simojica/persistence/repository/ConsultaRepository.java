package mx.com.simojica.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Consulta;


public interface ConsultaRepository {
	
	
	public long getConsultaPkSequence();
	public Consulta guardarConsulta(Consulta consulta);
	

}
