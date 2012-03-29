package DAO;

import javax.ejb.Stateful;

import classes.Kunde;
import interfaces.KundeDAO;
@Stateful(name="KundeDAOImpl")
public class KundeDAOImpl extends GenericDAOImpl implements KundeDAO {

	@Override
	public boolean checkPassword(String email, String password) {
		return em.createQuery("Select k from Kunde k where k.email=?0 and k.password=?1").setParameter(0, email).setParameter(1, password).getResultList().size()==1;
	}

	@Override
	public Kunde getKundeByEmailPasswort(String email, String password) {
		return (Kunde) em.createQuery("Select k from Kunde k where k.email=?0 and k.password=?1").setParameter(0, email).setParameter(1, password).getResultList().get(0);
	}

	@Override
	public void save(Kunde k) {
		if (!checkPassword(k.getEmail(), k.getPassword())){
			super.save(k);
		}
		
	}

}
