package interfaces;

import java.util.List;

import javax.ejb.Remote;

import classes.Artikel;
import classes.Artikelgruppe;

@Remote
public interface ArtikelgruppenDAO extends GenericDAO {
	public List<Artikelgruppe> getAlleArtGrp();
	public List<Artikel> getAlleArtikelByGrp(Artikelgruppe grp);
}
