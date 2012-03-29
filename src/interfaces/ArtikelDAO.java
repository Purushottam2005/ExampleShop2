package interfaces;

import java.util.List;

import javax.ejb.Remote;

import classes.Artikel;
import classes.Artikelgruppe;
@Remote
public interface ArtikelDAO extends GenericDAO {
	public List<Artikel> getAll();
	public List<Artikel> getByGrp(Artikelgruppe artikelgruppe);
}
