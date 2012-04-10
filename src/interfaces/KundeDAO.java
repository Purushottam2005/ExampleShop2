package interfaces;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import classes.Kunde;

@Remote
public interface KundeDAO extends GenericDAO {
	public boolean checkPassword(String email, String password);
	public Kunde getKundeByEmailPasswort(String email, String password);
	public void save(Kunde k);
	public EntityManager getEm();
	public void setEm(EntityManagerFactory emf);
}
