package repository;

import model.Examen;
import model.RepartizareSali;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamenRepository {
    private final Connection connection;

    public ExamenRepository(Connection connection) {
        this.connection = connection;
    }
    public ArrayList<Examen> getAllExamene() throws SQLException {
        ArrayList<Examen> examene = new ArrayList();
        String sqlSelect = "SELECT * FROM examene";
        PreparedStatement statement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            Examen e = new Examen(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            examene.add(e);
        }

        return examene;

    }
    public void adaugareExamen(Examen rep) throws SQLException {

        String sqlAdd = "INSERT INTO examene VALUES(NULL, ?, ?)";
        PreparedStatement statement = this.connection.prepareStatement(sqlAdd);
        statement.setString(1, rep.getNume());
        statement.setString(2, rep.getInformatii_examen());
        statement.executeUpdate();

    }
    public void deleteExamen(int id_examen) throws SQLException {
        String sqlDelete = "DELETE FROM examene WHERE id_examen = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, id_examen);
        statement.executeUpdate();
    }

    public void deleteAllExamene() throws SQLException {
        String sqlDelete = "DELETE FROM examene WHERE 1 = 1";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.executeUpdate();
    }

    public void schimbareNumeExamen(String nume_nou, String nume_vechi) throws SQLException {
        String sqlUpdate = "UPDATE examene SET nume = ? WHERE nume = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setString(1, nume_nou);
        statement.setString(2, nume_vechi);
        statement.executeUpdate();
    }
}
