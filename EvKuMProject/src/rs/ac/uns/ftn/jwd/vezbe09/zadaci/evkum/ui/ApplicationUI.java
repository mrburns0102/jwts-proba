package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao.GradDao;
//import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.model.Grad;
import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.utils.ScannerWrapper;

public class ApplicationUI {
	private static Logger logger = LogManager.getLogger(ApplicationUI.class.toString());
	private static GradDao gradDao = new GradDao(); 
	
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
			
			System.out.print("opcija:");
			odluka = ScannerWrapper.ocitajCeoBroj();
			
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
				ispisiGradove();
				break;
			case 2:
				
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
			
		}
		logger.exit(true);
	}

	private static void ispisiMenu() {
		System.out.println("Evidencija kulturnih manifestacija i gradova");
		System.out.println("Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikaz gradova;");
		System.out.println("\tOpcija broj 2 - Prikaz kulturnih manifestacija;");
		System.out.println("\tOpcija broj 3 - Pretraga kulturne manifestacije po identifikatoru;");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA.");
		
	}
	
	/** METODE ZA ISPIS GRADOVA  ****/
	// ispisi sve studente
	public static void ispisiGradove() {
		List<String> sviGradovi = 
				gradDao.getGradovi(ApplicationUI.conn);
		System.out.println("\n");
		for (int i = 0; i < sviGradovi.size(); i++) {
			System.out.println(sviGradovi.get(i));
		}
		System.out.println("\n");
	}

}
