package DAO;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classes.Kunde;
import interfaces.KundeDAO;
@Stateful(name="KundeDAOImpl")
public class KundeDAOImpl extends GenericDAOImpl implements KundeDAO {

	public KundeDAOImpl(){
		//super();
	}
	
	public EntityManager getEm(){
		return this.em;
	}
	
	@Override
	public boolean checkPassword(String email, String password) {
		try{
			if (em != null){
				return em.createQuery("Select k from Kunde k where k.email=?0 and k.password=?1").setParameter(0, email).setParameter(1, password).getResultList().size()==1;				
			}else{
				System.out.println("Information: Entitymanager is null");
				return false;
			}			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Kunde getKundeByEmailPasswort(String email, String password) {
		try{
			return (Kunde) em.createQuery("Select k from Kunde k where k.email=?0 and k.password=?1").setParameter(0, email).setParameter(1, password).getResultList().get(0);			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void save(Kunde k) {
		if(k!=null){
			if (!checkPassword(k.getEmail(), k.getPassword())){
				super.save(k);
			}			
		}

		
	}

	@Override
	public void setEm(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		this.em = emf.createEntityManager();
	}

}
