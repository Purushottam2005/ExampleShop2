package DAO;

import javax.ejb.Stateful;

import classes.Kunde;
import interfaces.KundeDAO;
@Stateful(name="KundeDAOImpl")
public class KundeDAOImpl extends GenericDAOImpl implements KundeDAO {

	@Override
	public boolean checkPassword(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Kunde getKundeByEmailPasswort(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
