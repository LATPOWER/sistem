package mx.com.simojica.persistence.repository;

import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.persistence.entity.Expedientes;


public interface ExpedientesRepository  {
	
	  public Expedientes persiste(Expedientes expedientes ) throws ExpedientesException ;
	  public Expedientes merge(Expedientes expediente ) throws ExpedientesException;
  
}


