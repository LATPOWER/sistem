package mx.com.simojica.service;

import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.persistence.entity.Consulta;
import mx.com.simojica.persistence.entity.ConsultaPK;
import mx.com.simojica.persistence.entity.Direccion;
import mx.com.simojica.persistence.entity.Expedientes;
import mx.com.simojica.persistence.entity.Familiar;
import mx.com.simojica.persistence.entity.HistoriaClinica;
import mx.com.simojica.persistence.repository.ConsultaRepository;
import mx.com.simojica.persistence.repository.DireccionRepository;
import mx.com.simojica.persistence.repository.ExpedientesRepository;


@Service
public class ExpedienteService {
	
	@Autowired
	private ExpedientesRepository  repository;
	
	@Autowired
	private ConsultaRepository  repositoryConsulta;
	
	@Autowired
	private DireccionRepository  repositoryDireccion;
	
	 @Transactional
	public void guardarExpediente(Expediente expediente) throws ExpedientesException {
		
		System.out.println("Service guardarExpediente ");
	
		Expedientes expedienteP = repository.persiste(new Expedientes( "A","B","C", null,	null, "123", "10", null,null,null,null,null));
		Direccion direccion = new Direccion();
		direccion.setExpediente(expedienteP);
		
		Direccion direccion2 = repositoryDireccion.guardarDireccion(direccion);
		System.out.println("ID DIRECCION "+direccion2.getIdDireccion());
		expedienteP.setDireccion(direccion2);
		expedienteP.setIdDirecion(direccion2.getIdDireccion());
		HistoriaClinica historiaClinica = new HistoriaClinica();
		historiaClinica.setExpediente(expedienteP);
		expedienteP.setHistoriaClinica(historiaClinica);
		Familiar papa = new Familiar();
		papa.setExpediente(expedienteP);
		expedienteP.setFamiliar1(papa);
		Familiar mama = new Familiar();
		mama.setExpediente(expedienteP);
		expedienteP.setFamiliar2(mama);
		System.out.println("calling merge");
		Expedientes expedienteF = repository.merge(expedienteP);
		
		Consulta consulta = new Consulta();
		
		consulta.setExpediente(expedienteF);
		
		System.out.println("ID CONSULTA "+consulta.getIdConsulta());
		
		
		consulta.setReceta(null);
		consulta = repositoryConsulta.guardarConsulta(consulta);
		
		
	//	repository.persiste();
	}

}
