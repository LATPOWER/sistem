package mx.com.simojica.persistence.repository.imp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mx.com.simojica.persistence.entity.Direccion;
import mx.com.simojica.persistence.repository.DireccionRepository;

@Repository
public class DireccionRepositoryImpl implements DireccionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Direccion guardarDireccion(Direccion direccion) {
		entityManager.persist(direccion);
		return direccion;
	}
	
	

}
