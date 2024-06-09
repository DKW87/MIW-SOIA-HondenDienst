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

	public void slaKlantOp(Klant klant) {
		String sql = "INSERT INTO klant(voorletters, tussenvoegsel, achternaam, telefoon) VALUES(?, ?, ?, ?);";
		int pKey = 0;
		try {
			setupPreparedStatementWithKey(sql);
			preparedStatement.setString(1, klant.getVoorletters());
			preparedStatement.setString(2, klant.getTussenvoegsel());
			preparedStatement.setString(3, klant.getAchternaam());
			preparedStatement.setString(4, klant.getTelefoon());
			pKey = executeInsertStatementWithKey();
			klant.setKlantnummer(pKey);
		} catch (SQLException sqlFout) {
			System.out.println(sqlFout);
		}
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

	public Klant getKlantPerId(int klantId){
		Klant klant = null;
		String sql = "SELECT * FROM klant WHERE klantnummer = ?;";
		try {
			setupPreparedStatement(sql);
			preparedStatement.setInt(1, klantId);
			ResultSet resultSet = executeSelectStatement();
			resultSet.next();
			String voorletters = resultSet.getString(2);
			String tussenvoegsel = resultSet.getString(3);
			String achternaam = resultSet.getString(4);
			String telefoon = resultSet.getString(5);
			klant = new Klant(klantId, voorletters, tussenvoegsel, achternaam,  telefoon);

		} catch (SQLException sqlFout) {
			System.out.println(sqlFout);
		}
		return klant;
	}

}
