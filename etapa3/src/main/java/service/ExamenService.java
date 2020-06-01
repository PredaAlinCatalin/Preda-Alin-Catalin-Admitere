package service;

import model.Examen;
import repository.ExamenRepository;

import java.sql.*;
import java.util.ArrayList;

public class ExamenService {
    private ExamenRepository examen_repository;

    public ExamenService(Connection connection) {
        examen_repository = new ExamenRepository(connection);
    }
    public ArrayList<Examen> getAllExamene(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("getAllExamene", new Timestamp(System.currentTimeMillis()),thread_name);
        return examen_repository.getAllExamene();

    }
    public void adaugareExamen(Examen e, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("adaugareExamen", new Timestamp(System.currentTimeMillis()), thread_name);
        examen_repository.adaugareExamen(e);

    }
    public void deleteExamen(int id_examen, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteExamen", new Timestamp(System.currentTimeMillis()), thread_name);
        examen_repository.deleteExamen(id_examen);
    }

    public void deleteAllExamene(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteAllExamene", new Timestamp(System.currentTimeMillis()), thread_name);
        examen_repository.deleteAllExamene();
    }

    public void schimbareNumeExamen(String nume_nou, String nume_vechi, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("schimbareNumeExamen", new Timestamp(System.currentTimeMillis()), thread_name);
        examen_repository.schimbareNumeExamen(nume_nou, nume_vechi);
    }
}
