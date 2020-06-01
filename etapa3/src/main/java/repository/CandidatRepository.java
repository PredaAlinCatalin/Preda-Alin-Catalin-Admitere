package repository;

import model.Candidat;
import model.Domeniu;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CandidatRepository{
    private final Connection connection;
    ArrayList<Candidat> candidat;


    public CandidatRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Candidat> getAllCandidati() throws SQLException {
        ArrayList<Candidat> candidati = new ArrayList();
        String sqlSelect = "SELECT * FROM candidati";
        PreparedStatement statement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            Candidat c = new Candidat(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getString(9), resultSet.getDouble(8));
            candidati.add(c);
        }

        return candidati;

    }

    public void adaugareCandidat(Candidat c) throws SQLException {

        String sqlAdd = "INSERT INTO candidati VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = this.connection.prepareStatement(sqlAdd);
//        statement.setInt(1, c.getId_candidat());
        statement.setString(1, c.getNume());
        statement.setString(2, c.getPrenume());
        statement.setString(3, c.getCNP());
        statement.setDouble(4, c.getMedie_Bac());
        statement.setDouble(5, c.getMedie_proba_obligatorie());
        statement.setDouble(6, c.getMedie_proba_optionala());
        statement.setDouble(7, c.getMedie_examen());
        statement.setString(8, c.getProfil_liceu());
        System.out.println(c.getMedie_examen());
        statement.executeUpdate();

    }
    public void deleteCandidat(int id_candidat) throws SQLException {
        String sqlDelete = "DELETE FROM candidati WHERE id_candidat = ?";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.setInt(1, id_candidat);
        statement.executeUpdate();
    }

    public void deleteAllCandidati() throws SQLException {
        String sqlDelete = "DELETE FROM candidati WHERE 1 = 1";
        PreparedStatement statement = connection.prepareStatement(sqlDelete);
        statement.executeUpdate();
    }

    public void schimbareNumeCandidat(String nume_nou, String nume_vechi) throws SQLException {
        String sqlUpdate = "UPDATE candidati SET nume = ? WHERE nume = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setString(1, nume_nou);
        statement.setString(2, nume_vechi);
        statement.executeUpdate();
    }

    public ArrayList<Candidat> getAllCandidatiOrderByMedieExamen() throws SQLException {

        ArrayList<Candidat> candidati = new ArrayList();
        String sqlSelect = "SELECT * FROM candidati ORDER BY medie_examen DESC";
        PreparedStatement statement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            Candidat c = new Candidat(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getString(9));
            candidati.add(c);
        }

        Collections.sort(candidati);
        return candidati;

    }

    public ArrayList<Candidat> getCandidat() {
        return candidat;
    }

    public void setCandidat(ArrayList<Candidat> candidat) {
        this.candidat = candidat;
    }
}
