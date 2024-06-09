package database;

import model.Klant;
import model.Wandeling;
import model.Hond;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HondInWandelingDAO extends AbstractDAO {

    public HondInWandelingDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaHondenInWandelingOp(Wandeling wandeling) {
        String sql = "INSERT INTO hondinwandeling VALUES(?, ?);";

        try {
            setupPreparedStatement(sql);
            preparedStatement.setInt(1, wandeling.getWandelingId());
            for (Hond hond: wandeling.getHonden()) {
                preparedStatement.setString(2, hond.getChipnummer());
                executeManipulateStatement();
            }
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }

    public List<Hond> getHondenPerWandeling(Wandeling wandeling) {
        List<Hond> hondenLijst = new ArrayList<>();
        String sql = "SELECT chipnummer FROM HondInWandeling WHERE wandelingId = ?";
        Hond hond;
        HondDAO hondDAO = new HondDAO(dBaccess);
        try {
            setupPreparedStatement(sql);
            preparedStatement.setInt(1, wandeling.getWandelingId());
            ResultSet resultSet = executeSelectStatement();
            while (resultSet.next()) {
                String chipnummer = resultSet.getString("chipnummer");
                hond = hondDAO.getHondPerId(chipnummer);
                hondenLijst.add(hond);
            }
        } catch (SQLException sqlFout) {
            System.out.println("SQL fout " + sqlFout.getMessage());
        }
        return hondenLijst;
    }
}
