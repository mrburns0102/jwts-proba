package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KMDAO {
	private static Logger log = LogManager.getLogger(KMDAO.class.getName());

	public String pretragaKMById(Connection conn, int id) {
		String s = "";
		String query = "SELECT km.naziv, grad.naziv FROM km, grad WHERE km.grad = grad.ptt_broj AND km.km_id = " + id;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				s = String.format("%-24s %-19s", rset.getString(1), rset.getString(2));
			}
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Neuspešno očitavanje kulturne manifestacije po id-u.");
		}

		return s;
	}

	public List<String> prikazKM(Connection conn) {
		List<String> retVal = new ArrayList<String>();

		String query = "SELECT km.naziv, grad.naziv FROM km, grad WHERE km.grad = grad.ptt_broj;";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				String s = String.format("%-24s %-19s", rset.getString(1), rset.getString(2));
				retVal.add(s);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne mogu se učitati kulturne manifestacije.");
		}
		return retVal;
	}
}
