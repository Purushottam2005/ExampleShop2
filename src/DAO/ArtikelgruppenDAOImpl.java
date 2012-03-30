package DAO;

import java.util.List;

import javax.ejb.Stateful;

import classes.Artikel;
import classes.Artikelgruppe;
import classes.Kunde;
import interfaces.ArtikelgruppenDAO;
@Stateful(name="ArtikelgruppenDAOImpl")
public class ArtikelgruppenDAOImpl extends GenericDAOImpl implements
		ArtikelgruppenDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikelgruppe> getAlleArtGrp() {
		try{
			return em.createQuery("Select a from Artikelgruppe a").getResultList();			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artikel> getAlleArtikelByGrp(int id) {
		try{
			return em.createQuery("Select f.artikel from Artikelgruppe f where f.id=?0").setParameter(0, id).getResultList();		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
