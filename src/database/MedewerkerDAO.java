package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Medewerker;

public class MedewerkerDAO extends AbstractDAO {

	public MedewerkerDAO(DBaccess dBaccess) {
		super(dBaccess);
	}
	
	public void slaMedewerkerOp(Medewerker medewerker) {
		String sql = "INSERT INTO Medewerker VALUES (?,?,?,?) ;";
		try {
			setupPreparedStatement(sql);
			preparedStatement.setString(1, medewerker.getMedewerkerCode());
			preparedStatement.setString(2, medewerker.getVoornaam());
			preparedStatement.setString(3, medewerker.getAchternaam());
			preparedStatement.setInt(4, medewerker.getStartjaar());
			executeManipulateStatement();
		} catch (SQLException sqlFout) {
			System.out.println("SQL fout " + sqlFout.getMessage());
		}
	}
	
	public Medewerker getMedewerkerPerId(String code) {
		String sql = "SELECT * FROM Medewerker WHERE medewerkercode = ?";
		Medewerker medewerker = null;
		try {
			setupPreparedStatement(sql);
			preparedStatement.setString(1, code);
			ResultSet resultSet = executeSelectStatement();
			while (resultSet.next()) {
				String medewerkervoornaam = resultSet.getString("medewerkervoornaam");
				String medewerkerachternaam = resultSet.getString("medewerkervoornaam");
				int jaar = resultSet.getInt("startjaar");
				medewerker = new Medewerker(code, medewerkervoornaam, medewerkerachternaam, jaar);
			}
		} catch (SQLException sqlFout) {
			System.out.println("SQL fout " + sqlFout.getMessage());
		}
		return medewerker;
	}
}
