package interfaces;

import java.util.List;

import javax.ejb.Remote;




@Remote
public interface GenericDAO {
	public <T>List <T>findAll(Class<T> entityClass);
	public <T> void save(T entity);
	public <T> void update(T entity);
	public <T> void remove(T entity);
  //more to come
}
