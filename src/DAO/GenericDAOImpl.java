package DAO;

import java.util.List;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import interfaces.GenericDAO;

/**
 * 
 * 
 * @author andreas
 * 
 * stateful session bean implementation of the remote genericdao-interface
 *
 */
@Stateful(name="GenericDAO")
public class GenericDAOImpl implements GenericDAO {
	@PersistenceContext EntityManager em;
	
	
	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void save(T entity) {
		if(entity != null){
			em.persist(entity);
		}
	}

	@Override
	public <T> void update(T entity) {
		if(entity  != null){
			em.persist(entity);
		}

	}

	@Override
	public <T> void remove(T entity) {
		if(entity != null){
			em.remove(entity);
		}
	}
	
	public boolean checkEntityManager(){
		return em != null;
	}

}
