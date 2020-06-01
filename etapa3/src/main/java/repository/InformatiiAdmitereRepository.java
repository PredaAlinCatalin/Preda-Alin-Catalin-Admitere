package repository;

import model.InformatiiAdmitere;
import model.RepartizareSali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InformatiiAdmitereRepository {
    private final Connection connection;

    public InformatiiAdmitereRepository(Connection connection) {
        this.connection = connection;
    }
    public ArrayList<InformatiiAdmitere> getAllInformatiiAdmiteri() throws SQLException {
        ArrayList<InformatiiAdmitere> informatii_admiteri = new ArrayList();
        String sqlSelect = "SELECT * FROM informatii_admiteri";
        PreparedStatement statement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            InformatiiAdmitere c = new InformatiiAdmitere(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            informatii_admiteri.add(c);
        }

        return informatii_admiteri;

    }
    public void adaugareInformatiiAdmitere(InformatiiAdmitere inf) throws SQLException {

        String sqlAdd = "INSERT INTO informatii_admiteri VALUES(NULL, ?, ?, ?)";
        PreparedStatement statement = this.connection.prepareStatement(sqlAdd);
        statement.setString(1, inf.getExamen().getNume());
        statement.setString(2, inf.getInformatii_preadmitere());
        statement.setString(3, inf.getInformatii_postadmitere());
        statement.executeUpdate();

    }
    public void deleteInformatiiAdmitere(int id_informatii_admitere) throws SQLException {
        String sqlDelete = "DELETE FROM informatii_admiteri WHERE id_informatii_admitere = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, id_informatii_admitere);
        statement.executeUpdate();
    }

    public void deleteAllInformatiiAdmitere() throws SQLException {
        String sqlDelete = "DELETE FROM informatii_admiteri WHERE 1 = 1";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.executeUpdate();
    }

    public void schimbareNumeExamen(String nume_nou, String nume_vechi) throws SQLException {
        String sqlUpdate = "UPDATE informatii_admiteri SET nume_examen = ? WHERE nume_examen = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setString(1, nume_nou);
        statement.setString(2, nume_vechi);
        statement.executeUpdate();
    }
}
