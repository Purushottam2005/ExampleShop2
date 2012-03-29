package DAO;

import java.util.List;

import javax.ejb.Stateful;

import classes.Artikel;
import classes.Artikelgruppe;
import interfaces.ArtikelDAO;
@Stateful(name="ArtikelDAOImpl")
public class ArtikelDAOImpl extends GenericDAOImpl implements ArtikelDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getAll() {
		return em.createQuery("Select a from Artikel a").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getByGrp(Artikelgruppe artikelgruppe) {
		return em.createQuery("Select f.artikel from Artikelgruppe f where f.id=?0").setParameter(0, artikelgruppe.getId()).getResultList();
	}

}
