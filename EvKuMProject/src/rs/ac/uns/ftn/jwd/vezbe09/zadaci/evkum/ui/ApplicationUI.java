package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao.GradDАО;
import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao.KMDAO;
import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.utils.ScannerWrapper;

public class ApplicationUI {
	private static Logger logger = LogManager.getLogger(ApplicationUI.class.toString());
	private static GradDАО gradDao = new GradDАО();
	private static KMDAO kmDao = new KMDAO();

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
				prikazKM();
				break;
			case 3:
				prikazKMById();
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

	/** METODA ZA ISPIS GRADOVA ****/
	// ispisi sve gradove
	public static void ispisiGradove() {
		List<String> sviGradovi = gradDao.getGradovi(ApplicationUI.conn);
		for (int i = 0; i < sviGradovi.size(); i++) {
			System.out.println(sviGradovi.get(i));
		}
		System.out.println("\n");
	}

	/** METODA ZA ISPIS KULTURNIH MANIFESTACIJA ****/
	// ispisi sve kulturne manifestacije
	public static void prikazKM() {
		System.out.printf("Kulturna manifestacija | Mesto održavanja\n");
		List<String> sveKM = kmDao.prikazKM(ApplicationUI.conn);
		for (int i = 0; i < sveKM.size(); i++) {
			System.out.println(sveKM.get(i));
		}
		System.out.println("\n");
	}

	public static void prikazKMById() {
		System.out.println("Unesite id kulturne manifestacije.");
		int id = ScannerWrapper.ocitajCeoBroj();
		System.out.printf("Kulturna manifestacija | Mesto održavanja\n");
		String km = kmDao.pretragaKMById(ApplicationUI.conn, id);
		System.out.println(km + "\n");
	}
}
