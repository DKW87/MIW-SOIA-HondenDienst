package database;

import model.Wandeling;

import java.sql.SQLException;

public class WandelingDAO extends AbstractDAO {

    public WandelingDAO(DBaccess dBaccess) {
        super(dBaccess);
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
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }
    }

}
