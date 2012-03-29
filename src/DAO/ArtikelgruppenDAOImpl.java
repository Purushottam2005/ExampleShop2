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

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getAlleArtikelByGrp(int id) {
		return em.createQuery("Select f.artikel from Artikelgruppe f where f.id=?0").setParameter(0, id).getResultList();
	}

}
