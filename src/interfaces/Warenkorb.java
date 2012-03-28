package interfaces;

import java.util.List;

import javax.ejb.Remote;

import classes.Artikel;
import classes.Kunde;

@Remote
public interface Warenkorb {
	public Kunde getKunde();
	public void setKunde(Kunde kunde);
	public List<Artikel> getArtikel();
}
