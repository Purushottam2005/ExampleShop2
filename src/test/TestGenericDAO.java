package test;

import static org.junit.Assert.*;
import interfaces.GenericDAO;

import javax.naming.InitialContext;


import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.Test;

import DAO.GenericDAOImpl;


import classes.Artikel;
import classes.Artikelgruppe;


public class TestGenericDAO {
	InitialContext context = null;
	GenericDAO dao = new GenericDAOImpl();
	
	@Before
	public void setUp() throws Exception {
//		Configuration configuration = new Configuration();
//		configuration.setProperty(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
//		configuration.setProperty(Environment.URL, "jdbc:oracle:thin:@localhost:1521");
//		configuration.setProperty(Environment.USER, "system");
//		configuration.setProperty(Environment.PASS, "system");
//		configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
//		configuration.setProperty(Environment.HBM2DDL_AUTO, "create");
//		configuration.setProperty(Environment.SHOW_SQL, "true");
//		configuration.addAnnotatedClass(Artikel.class);
//		configuration.addAnnotatedClass(Artikelgruppe.class);
		context = new InitialContext();
		dao = (GenericDAOImpl)context.lookup("GenericDAOImpl/remote");
		
	}
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
