package interfaces;

import javax.ejb.Remote;
import javax.naming.NamingException;

import classes.Artikel;
import classes.Kunde;


	@Remote
	public interface WarenkorbDAO {
		public void erstelleWarenkorb() throws NamingException;
		
		public void legeInWarenkorb(Artikel artikel);

		public void entferneAusWarenkorb(Artikel artikel);

		public int geheZurKasse();
		
		public void fuegeWarenkorbZuKunde(Kunde kunde);
	}

