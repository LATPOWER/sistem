package mx.com.simojica.persistence.repository;

import mx.com.simojica.persistence.entity.Consulta;


public interface ConsultaRepository {
	
	
	public long getConsultaPkSequence();
	public Consulta guardarConsulta(Consulta consulta);
	

}
