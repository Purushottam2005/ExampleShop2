package DAO;

import java.util.List;

import javax.ejb.Stateful;

import classes.Artikel;
import classes.Artikelgruppe;
import interfaces.ArtikelgruppenDAO;
@Stateful(name="ArtikelgruppenDAOImpl")
public class ArtikelgruppenDAOImpl extends GenericDAOImpl implements
		ArtikelgruppenDAO {

	@Override
	public List<Artikelgruppe> getAlleArtGrp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artikel> getAlleArtikelByGrp(Artikelgruppe grp) {
		// TODO Auto-generated method stub
		return null;
	}

}
