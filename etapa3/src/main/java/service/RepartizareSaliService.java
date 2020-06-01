package service;

import model.RepartizareSali;
import repository.RepartizareSaliRepository;

import java.sql.*;
import java.util.ArrayList;

public class RepartizareSaliService {
    private RepartizareSaliRepository repartizare_sali_repository;
    public RepartizareSaliService(Connection connection) {
        repartizare_sali_repository = new RepartizareSaliRepository(connection);
    }

    public ArrayList<RepartizareSali> getAllRepartizariSali(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("getAllRepartizariSali", new Timestamp(System.currentTimeMillis()), thread_name);
        return repartizare_sali_repository.getAllRepartizariSali();

    }
    public void adaugareRepartizareSali(RepartizareSali rep, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("adaugareRepartizareSali", new Timestamp(System.currentTimeMillis()), thread_name);
        repartizare_sali_repository.adaugareRepartizareSali(rep);

    }
    public void deleteRepartizareSali(int id_repartizare_sali, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteRepartizareSali", new Timestamp(System.currentTimeMillis()), thread_name);
        repartizare_sali_repository.deleteRepartizareSali(id_repartizare_sali);
    }

    public void deleteAllRepartizareSali(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteAllRepartizareSali", new Timestamp(System.currentTimeMillis()), thread_name);
        repartizare_sali_repository.deleteAllRepartizareSali();
    }

    public void schimbareNumarSali(int numar_nou, int numar_vechi, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("schimbareNumarSali", new Timestamp(System.currentTimeMillis()), thread_name);
        repartizare_sali_repository.schimbareNumarSali(numar_nou, numar_vechi);
    }

}
