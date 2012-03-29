package DAO;

import java.util.List;

import javax.ejb.Stateful;

import classes.Artikel;
import classes.Artikelgruppe;
import interfaces.ArtikelDAO;
@Stateful(name="ArtikelDAOImpl")
public class ArtikelDAOImpl extends GenericDAOImpl implements ArtikelDAO {

	@Override
	public List<Artikel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artikel> getByGrp(Artikelgruppe artikelgruppe) {
		// TODO Auto-generated method stub
		return null;
	}

}
