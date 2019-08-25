package mx.com.simojica.persistence.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.simojica.exceptions.ExpedientesException;
import mx.com.simojica.persistence.HibernateJPAConfiguration;
import mx.com.simojica.persistence.entity.Expedientes;

@Repository
public class ExpedientesRepository  {
	
	  @PersistenceContext
	    private EntityManager entityManager;
	  
	
	  @Transactional
	  public Expedientes persiste(Expedientes expedientes ) throws ExpedientesException {
		  System.out.println("ExpedientesRepository persiste ");
		//  Expedientes expedientes = new Expedientes(1l, "A","B","C", null,	null, "123", "10", null);
		//  Transaction tx = transactionManager.
		
		  System.out.println("ExpedientesRepository persiste after new");
		  
		  entityManager.persist(expedientes);
		  
		  System.out.println(" flush");
		  entityManager.flush();
		  System.out.println("id expediente es :"+expedientes.getIdExpediente());
		  return expedientes;
	  }
	  
	  @Transactional
	  public Expedientes merge(Expedientes expediente ) throws ExpedientesException {
		  System.out.println("ExpedientesRepository merge ");
		//  Expedientes expedientes = new Expedientes(1l, "A","B","C", null,	null, "123", "10", null);
		//  Transaction tx = transactionManager.
		
		  System.out.println("ExpedientesRepository merge after direccion "+expediente.getIdDirecion());
		
		  entityManager.merge(expediente);
		  entityManager.flush();
		  System.out.println("id expediente es :"+expediente.getIdExpediente());
		  return expediente;
	  }
	  
	  
}


