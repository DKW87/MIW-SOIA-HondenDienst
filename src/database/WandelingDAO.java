package database;

import model.Wandeling;

import java.sql.SQLException;

public class WandelingDAO extends AbstractDAO {

    HondInWandelingDAO hondInWandelingDAO;

    public WandelingDAO(DBaccess dBaccess) {
        super(dBaccess);
        hondInWandelingDAO = new HondInWandelingDAO(dBaccess);
    }

    public void slaWandelingOp(Wandeling wandeling) {
        String sql = "INSERT INTO wandeling(datum, duur, medewerkercode) VALUES( ?, ?, ?);";
        int pKey = 0;
        try {
            setupPreparedStatementWithKey(sql);
            preparedStatement.setString(1, wandeling.getUitlaatDatum().toString());
            preparedStatement.setDouble(2, wandeling.getDuur());
            preparedStatement.setString(3, wandeling.getUitlaatMedewerker().getMedewerkerCode());
            pKey = executeInsertStatementWithKey();
            wandeling.setWandelingId(pKey);
            hondInWandelingDAO.slaHondenInWandelingOp(wandeling);
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }

}
