package DAO;

import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import classes.Artikel;
import classes.Kunde;
import classes.WarenkorbImpl;
import interfaces.GenericDAO;
import interfaces.Warenkorb;
import interfaces.WarenkorbDAO;
/**
 * 
 * @author andreas
 * 
 * non-entity stateful session bean for warenkorb. is used as interface between interface AND object, there
 * should not be any direct actions between user and class
 *
 */
@Stateful(name="WarenkorbDAOImpl")
public class WarenkorbDAOImpl implements WarenkorbDAO {
	InitialContext context = null;
	Warenkorb wk = new WarenkorbImpl();

	@Override
	public void legeInWarenkorb(Artikel artikel) {

		if(wk!=null){
			wk.artikelhinzu(artikel);
		}
		

	}

	@Override
	public void entferneAusWarenkorb(Artikel artikel) {
		if(wk != null){
			wk.getArtikel().remove(artikel);
		}

	}

	@Override
	public int geheZurKasse() {
		System.out.println(wk.getArtikel().size());
		System.out.println(wk.getKunde().getEmail());
		return 0;
	}

	@Override
	public void fuegeWarenkorbZuKunde(Kunde kunde) {
		if(wk!=null){
			wk.setKunde(kunde);			
		}else{
			wk.setKunde(null);
		}
		

	}

	@Override
	public void erstelleWarenkorb() throws NamingException {
		context = new InitialContext();
		wk = (Warenkorb)context.lookup("WarenkorbImpl/remote");		
	}

}
