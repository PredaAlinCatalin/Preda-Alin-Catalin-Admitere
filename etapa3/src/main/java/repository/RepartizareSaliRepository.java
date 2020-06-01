package repository;

import model.Candidat;
import model.RepartizareSali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepartizareSaliRepository {
    private final Connection connection;

    public RepartizareSaliRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<RepartizareSali> getAllRepartizariSali() throws SQLException {
        ArrayList<RepartizareSali> repartizari_sali = new ArrayList();
        String sqlSelect = "SELECT * FROM repartizari_sali";
        PreparedStatement statement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            RepartizareSali c = new RepartizareSali(resultSet.getInt(2), resultSet.getInt(3));
            repartizari_sali.add(c);
        }

        return repartizari_sali;

    }
    public void adaugareRepartizareSali(RepartizareSali rep) throws SQLException {

        String sqlAdd = "INSERT INTO repartizari_sali VALUES(NULL, ?, ?)";
        PreparedStatement statement = this.connection.prepareStatement(sqlAdd);
        statement.setInt(1, rep.getNr_sali());
        statement.setInt(2, rep.getCapacitate_sala());
        statement.executeUpdate();

    }
    public void deleteRepartizareSali(int id_repartizare_sali) throws SQLException {
        String sqlDelete = "DELETE FROM repartizari_sali WHERE id_repartizare_sali = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, id_repartizare_sali);
        statement.executeUpdate();
    }

    public void deleteAllRepartizareSali() throws SQLException {
        String sqlDelete = "DELETE FROM repartizari_sali WHERE 1 = 1";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.executeUpdate();
    }

    public void schimbareNumarSali(int numar_nou, int numar_vechi) throws SQLException {
        String sqlUpdate = "UPDATE repartizari_sali SET nr_sali = ? WHERE nr_sali = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setInt(1, numar_nou);
        statement.setInt(2, numar_vechi);
        statement.executeUpdate();
    }
}
