package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationUI {
	private static Logger logger = LogManager.getLogger(ApplicationUI.class.toString());

	public static Connection conn;

	static {
		try {
			// ucitavanje MySQL drajvera
			Class.forName("com.mysql.jdbc.Driver");

			// konekcija
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evkum", "root", "000358753");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	public static void main(String args[]) {
		logger.entry();

		int odluka = -1;
		while (odluka != 0) {
			ApplicationUI.ispisiMenu();
		}
	}

	private static void ispisiMenu() {
		System.out.println("Evidencija kulturnih manifestacija i gradova");
		System.out.println("\tOsnovne opcije:");
		System.out.println("\t1. Prikaz gradova;");
		System.out.println("\t1. Prikaz kulturnih manifestacija;");
		System.out.println("\t1. Prikaz kulturnih manifestacija;");
		
	}

}
