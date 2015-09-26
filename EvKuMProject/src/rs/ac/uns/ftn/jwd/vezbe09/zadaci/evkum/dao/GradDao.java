package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.model.Grad;

public class GradDao {
	public static Logger log = LogManager.getLogger(GradDao.class.getName());

	public List<String> getGradovi(Connection conn) {
		List<String> retVal = new ArrayList<String>();
		try {
			String query = "SELECT naziv FROM grad;";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				String naziv = rset.getString(1);
				retVal.add(naziv);
			}
			rset.close();
			stmt.close();

		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Gradovi se ne mogu učitati.");
		}
		return retVal;
	}

}
