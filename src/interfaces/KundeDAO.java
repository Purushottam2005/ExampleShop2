package interfaces;

import javax.ejb.Remote;

import classes.Kunde;

@Remote
public interface KundeDAO extends GenericDAO {
	public boolean checkPassword(String email, String password);
	public Kunde getKundeByEmailPasswort(String email, String password);
}
