package DAO;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfaces.GenericDAO;


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

}
