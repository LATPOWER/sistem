package mx.com.simojica.service;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.simojica.domain.Expediente;
import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.persistence.entity.Consulta;
import mx.com.simojica.persistence.entity.Direccion;
import mx.com.simojica.persistence.entity.Expedientes;
import mx.com.simojica.persistence.entity.Familiar;
import mx.com.simojica.persistence.entity.HistoriaClinica;
import mx.com.simojica.persistence.repository.ConsultaRepository;
import mx.com.simojica.persistence.repository.DireccionRepository;
import mx.com.simojica.persistence.repository.ExpedientesRepository;

@Service
public class ExpedienteService {
	
	private static final Logger LOGGER = LogManager.getLogger(ExpedienteService.class);
	
	@Autowired
	private ExpedientesRepository  repository;
	
	@Autowired
	private ConsultaRepository  repositoryConsulta;
	
	@Autowired
	private DireccionRepository  repositoryDireccion;
	
	 @Transactional
	public void guardarExpediente(Expediente expediente) throws ExpedientesException {
		
		LOGGER.info("Service guardarExpediente ");
		Expedientes expedienteP = repository.persiste(crearExpedientes(expediente));
		Direccion direccion = new Direccion();
		direccion.setExpediente(expedienteP);
		
		Direccion direccion2 = repositoryDireccion.guardarDireccion(direccion);
		LOGGER.info("ID DIRECCION "+direccion2.getIdDireccion());
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
		LOGGER.info("calling merge");
		Expedientes expedienteF = repository.merge(expedienteP);		
		Consulta consulta = new Consulta();		
		consulta.setExpediente(expedienteF);		
		LOGGER.info("ID CONSULTA "+consulta.getIdConsulta());		
		consulta.setReceta(null);
		consulta = repositoryConsulta.guardarConsulta(consulta);
	}
	 
	private Expedientes crearExpedientes(Expediente expediente) {
		Expedientes expedienteEntity = new Expedientes();
		expedienteEntity.setNombre("Jesus");
		expedienteEntity.setApellidoPaterno("ApellidoPaterno");
		expedienteEntity.setApellidoMaterno("ApellidoMaterno");
		
		return expedienteEntity;
	}

}
