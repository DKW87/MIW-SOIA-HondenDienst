package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hond;
import model.Klant;

public class HondDAO extends AbstractDAO {


    public HondDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaHondOp(Hond hond) {
        String sql = "INSERT INTO hond VALUES(?, ?, ?, ?);";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, hond.getChipnummer());
            preparedStatement.setString(2, hond.getNaam());
            preparedStatement.setString(3, hond.getRas());
            preparedStatement.setInt(4, hond.getEigenaar().getKlantnummer());
            executeManipulateStatement();
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }

    public List<Hond> getHonden() {
        KlantDAO klantDAO = new KlantDAO(dBaccess);
        List<Hond> hondenLijst = new ArrayList<>();
        String sql = "SELECT * FROM hond";
        Hond hond;
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String chipnummer = resultSet.getString(1);
                String hondnaam = resultSet.getString(2);
                String ras = resultSet.getString(3);
                int klantnummer = resultSet.getInt(4);
                Klant klant = klantDAO.getKlantPerId(klantnummer);
                hond = new Hond(chipnummer, hondnaam, ras, klant);
                hondenLijst.add(hond);
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return hondenLijst;
    }

    public Hond getHondPerId(String chipnummer){
        KlantDAO klantDAO = new KlantDAO(dBaccess);
        Hond hond = null;
        String sql = "SELECT * FROM hond WHERE chipnummer = ?;";
        try {
            setupPreparedStatement(sql);
            preparedStatement.setString(1, chipnummer);
            ResultSet resultSet = executeSelectStatement();
            resultSet.next();

            String hondnaam = resultSet.getString(2);
            String ras = resultSet.getString(3);
            int klantnummer = resultSet.getInt(4);
            Klant klant = klantDAO.getKlantPerId(klantnummer);
            hond = new Hond(chipnummer, hondnaam, ras, klant);

        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
        return hond;
    }

    public List<Hond> getHondenPerKlant(Klant klant) {
        KlantDAO klantDAO = new KlantDAO(dBaccess);
        List<Hond> hondenLijst = new ArrayList<>();
        String sql = "SELECT * FROM hond WHERE klantnummer = " + klant.getKlantnummer() + ";";
        Hond hond;
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String chipnummer = resultSet.getString(1);
                String hondnaam = resultSet.getString(2);
                String ras = resultSet.getString(3);
                hond = new Hond(chipnummer, hondnaam, ras, klant);
                hondenLijst.add(hond);
            }
        }
        catch (SQLException sqlFout){
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return hondenLijst;
    }


}
