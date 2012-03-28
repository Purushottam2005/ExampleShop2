package test;

import interfaces.GenericDAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import DAO.GenericDAOImpl;

public class Main {


	public static void main(String[] args) throws NamingException {
		InitialContext context = new InitialContext();
		GenericDAO dao = (GenericDAO)context.lookup("GenericDAO/remote");
		if (dao!=null){
			System.out.println("test");
		}

	}

}
