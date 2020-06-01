package service;

import model.InformatiiAdmitere;
import repository.InformatiiAdmitereRepository;

import java.sql.*;
import java.util.ArrayList;

public class InformatiiAdmitereService {
    private InformatiiAdmitereRepository informatii_admitere_repository;
    public InformatiiAdmitereService(Connection connection) {
        informatii_admitere_repository = new InformatiiAdmitereRepository(connection);
    }
    public ArrayList<InformatiiAdmitere> getAllInformatiiAdmiteri(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("getAllInformatiiAdmiteri", new Timestamp(System.currentTimeMillis()), thread_name);
        return informatii_admitere_repository.getAllInformatiiAdmiteri();

    }
    public void adaugareInformatiiAdmitere(InformatiiAdmitere inf, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("adaugareInformatiiAdmitere", new Timestamp(System.currentTimeMillis()), thread_name);
        informatii_admitere_repository.adaugareInformatiiAdmitere(inf);
    }
    public void deleteInformatiiAdmitere(int id_informatii_admitere, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteInformatiiAdmitere", new Timestamp(System.currentTimeMillis()), thread_name);
        informatii_admitere_repository.deleteInformatiiAdmitere(id_informatii_admitere);
    }

    public void deleteAllInformatiiAdmitere(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteAllInformatiiAdmitere", new Timestamp(System.currentTimeMillis()), thread_name);
        informatii_admitere_repository.deleteAllInformatiiAdmitere();
    }

    public void schimbareNumeExamen(String nume_nou, String nume_vechi, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("schimbareNumeExamen", new Timestamp(System.currentTimeMillis()), thread_name);
        informatii_admitere_repository.schimbareNumeExamen(nume_nou, nume_vechi);
    }
}
