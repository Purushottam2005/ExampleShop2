package test;

import static org.junit.Assert.*;

import java.util.List;

import interfaces.ArtikelgruppenDAO;
import interfaces.GenericDAO;
import interfaces.KundeDAO;
import interfaces.Warenkorb;
import interfaces.WarenkorbDAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.constraints.AssertTrue;


import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.Test;

import DAO.GenericDAOImpl;
import DAO.WarenkorbDAOImpl;


import classes.Artikel;
import classes.Artikelgruppe;
import classes.Kunde;
import classes.WarenkorbImpl;


public class TestGenericDAO {
	InitialContext context = null;
	GenericDAO dao = new GenericDAOImpl();
	
	@Before
	public void setUp() throws Exception {
		context = new InitialContext();
		dao = (GenericDAO)context.lookup("GenericDAO/remote");
		
	}
	
	
	/**
	 * Verwendung der Datenbank: Bei gestartetem JBoss in der Adressleiste des Browsers http://localhost:8080/jmx-console/HtmlAdaptor
	 * eingeben, den Link "database=localDB,service=Hypersonic" klicken und den Button INVOKE unter der �berschrift
	 * "startDatabaseManager()" dr�cken. Schon erscheint die GUI f�r HSQLDB (Standarddatenbank die bei JBOSS dabei ist)
	 */
	
	@Test
	public void testArtikelRelatedClasses() {
		//Artikelgruppen erzeugen
		Artikelgruppe grp1 = new Artikelgruppe();
		grp1.setBezeichnung("Gruppe 1");
		grp1.setInfo("Dies ist die Artikelgruppe 1");
		Artikelgruppe grp2 = new Artikelgruppe();
		grp2.setBezeichnung("Gruppe 2");
		grp2.setInfo("Dies ist die Artikelgruppe 2");
		//Verschiedene Artikel erzeugen
		Artikel art1 = new Artikel();
		art1.setBezeichnung("Artikel 1");
		art1.setImg_url("leer");
		art1.setInfo("Dies ist Artikel 1");
		art1.setVk_brutto(21.00);
		Artikel art2 = new Artikel();
		art2.setBezeichnung("Artikel 2");
		art2.setImg_url("leer");
		art2.setInfo("Dies ist Artikel 2");
		art2.setVk_brutto(22.00);
		Artikel art3 = new Artikel();
		art3.setBezeichnung("Artikel 3");
		art3.setImg_url("leer");
		art3.setInfo("Dies ist Artikel 3");
		art3.setVk_brutto(23.00);		
		//Artikel zu Gruppen hinzuf�gen
		grp1.artikelhinzu(art1);
		grp1.artikelhinzu(art2);
		grp2.artikelhinzu(art3);
		//Artikelgruppen speichern (und damit die Artikel)
		dao.save(grp1);
		dao.save(grp2);		
	}
	@Test
	public void TestWarenkorb() throws NamingException{
		//ArtikelgruppenDAO erzeugen
		ArtikelgruppenDAO grpDAO = (ArtikelgruppenDAO)context.lookup("ArtikelgruppenDAOImpl/remote");
		//Artikelgruppen erzeugen
		Artikelgruppe grp3 = new Artikelgruppe();
		grp3.setBezeichnung("Gruppe 3");
		grp3.setInfo("Dies ist die Artikelgruppe 3");		
		Artikel art4 = new Artikel();
		art4.setBezeichnung("Artikel 4");
		art4.setImg_url("leer");
		art4.setInfo("Dies ist Artikel 4");
		art4.setVk_brutto(23.00);
		grp3.artikelhinzu(art4);
		grpDAO.save(grp3);
		//Artikelgruppedao Testen (mit fixer id 3)		
		assertTrue(grpDAO.getAlleArtikelByGrp(3).size()>0);
		assertTrue(grpDAO.getAlleArtGrp().size()>0);
		//Kundedao erzeugen
		KundeDAO kdao = (KundeDAO)context.lookup("KundeDAOImpl/remote");		
		//Kunde erzeugen
		Kunde k2 = new Kunde();
		k2.setAdresse("Sch�tzenstrasse 4 53474 Ahrweiler");
		k2.setEmail("tirza@diemonschaus.de");
		k2.setPassword("test");
		k2.setVorname("tirza");
		kdao.save(k2);
		//Kundendao testen
		assertTrue(kdao.checkPassword("tirza@diemonschaus.de", "test"));
		assertFalse(kdao.checkPassword("blub", "blab"));
		Kunde kunde = new Kunde();
		kunde = kdao.getKundeByEmailPasswort("tirza@diemonschaus.de", "test");
		assertTrue(kunde.getVorname().equals("tirza"));
		//Warenkorb erzeugen
		WarenkorbDAO wk = (WarenkorbDAO)context.lookup("WarenkorbDAOImpl/remote");
		wk.erstelleWarenkorb();
		wk.fuegeWarenkorbZuKunde(k2);
		wk.legeInWarenkorb(art4);
		wk.geheZurKasse();

	}

}
