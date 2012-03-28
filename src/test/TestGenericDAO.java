package test;

import static org.junit.Assert.*;

import java.util.List;

import interfaces.GenericDAO;
import interfaces.Warenkorb;
import interfaces.WarenkorbDAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;


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
	 * eingeben, den Link "database=localDB,service=Hypersonic" klicken und den Button INVOKE unter der Überschrift
	 * "startDatabaseManager()" drücken. Schon erscheint die GUI für HSQLDB (Standarddatenbank die bei JBOSS dabei ist)
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
		//Artikel zu Gruppen hinzufügen
		grp1.artikelhinzu(art1);
		grp1.artikelhinzu(art2);
		grp2.artikelhinzu(art3);
		//Artikelgruppen speichern (und damit die Artikel)
		dao.save(grp1);
		dao.save(grp2);		
	}
	@Test
	public void TestKunden(){
		Kunde k1 = new Kunde();
		k1.setAdresse("Professor Neu Alle 3 53225 Bonn");
		k1.setEmail("andreas@diemonschaus.de");
		k1.setPassword("test");
		k1.setVorname("andreas");
		dao.save(k1);
	}
	@Test
	public void TestWarenkorb(){
		//no dbaccess here
		//Artikelgruppen erzeugen
		Artikelgruppe grp3 = new Artikelgruppe();
		grp3.setBezeichnung("Gruppe 3");
		grp3.setInfo("Dies ist die Artikelgruppe 3");		
		Artikel art4 = new Artikel();
		art4.setBezeichnung("Artikel 4");
		art4.setImg_url("leer");
		art4.setInfo("Dies ist Artikel 3");
		art4.setVk_brutto(23.00);
		dao.save(grp3);
		//Kunde erzeugen
		Kunde k2 = new Kunde();
		k2.setAdresse("Schützenstrasse 4 53474 Ahrweiler");
		k2.setEmail("tirza@diemonschaus.de");
		k2.setPassword("test");
		k2.setVorname("tirza");
		dao.save(k2);
		//Warenkorb erzeugen
		WarenkorbDAO wk = new WarenkorbDAOImpl();
		try {
			wk.erstelleWarenkorb();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wk.fuegeWarenkorbZuKunde(k2);
		wk.legeInWarenkorb(art4);
		wk.geheZurKasse();

	}

}
