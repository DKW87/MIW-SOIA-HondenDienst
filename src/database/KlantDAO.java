package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Klant;

public class KlantDAO extends AbstractDAO {


	public KlantDAO(DBaccess dBaccess) {
		super(dBaccess);
	}


	public List<Klant> getKlanten() {
		List<Klant> klantenLijst = new ArrayList<>();
		String sql = "SELECT * FROM Klant";
		Klant klant;
		try {
			setupPreparedStatement(sql);
			ResultSet resultSet = executeSelectStatement();
			while (resultSet.next()) {
				int klantnummer = resultSet.getInt("klantnummer");
				String voorletters = resultSet.getString("voorletters");
				String tussenvoegsel = resultSet.getString("tussenvoegsel");
				String achternaam = resultSet.getString("achternaam");
				String telefoon = resultSet.getString("telefoon");
				klant = new Klant(klantnummer, voorletters, tussenvoegsel, achternaam,  telefoon);
				klantenLijst.add(klant);
			}
		}
		catch (SQLException sqlFout){
			System.out.println("SQL fout " + sqlFout.getMessage());
		}
		return klantenLijst;
	}
}
