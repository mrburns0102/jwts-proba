package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.model.KM;

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
		System.out.println(retVal);
		return retVal;
	}
	
	public List<String> kmMaxPosetilaca(Connection conn) {
		List<String> retVal = new ArrayList<String>();
		String query = "SELECT km.naziv, grad.naziv, km.br_posetilaca FROM km, grad WHERE km.grad = grad.ptt_broj AND km.br_posetilaca IN (SELECT MAX(br_posetilaca) FROM km);";	
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()){
				String s = String.format("%-24s %-19s %-8d", rset.getString(1), rset.getString(2), rset.getInt(3));
				retVal.add(s);
			}
				rset.close();
				stmt.close();
			
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne može se učitati manifestacija sa najvećim brojem posetilaca.");
		}
		return retVal;
	}
	
	public KM nadjiKMPoNazivu(Connection conn, String nazivKM) {
		KM km = new KM();
		String query = "SELECT naziv FROM km WHERE naziv = " + nazivKM;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			if(rset.next()){
				km.setId(rset.getInt(1));
				km.setNaziv(rset.getString(2));
				//km.setBrPosetilaca(rset.getInt(3));
				//km.setGrad(rset.getInt(4));
				
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Po nazivu km ne moze.");
		}
		return km;
		
	}
	
	
}
