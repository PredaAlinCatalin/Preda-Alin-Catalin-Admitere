package service;

import model.Candidat;
import model.Domeniu;
import repository.CandidatRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class CandidatService {
    private CandidatRepository candidat_repository;
    private final Connection connection;

    public CandidatService(Connection connection) {
        this.connection = connection;
        candidat_repository = new CandidatRepository(connection);
    }
    public ArrayList<Candidat> getAllCandidati(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("getAllCandidati", new Timestamp(System.currentTimeMillis()), thread_name);
        return candidat_repository.getAllCandidati();

    }

    public ArrayList<Candidat> getAllCandidatiOrderByMedieExamen(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("getAllCandidatiOrderByMedieExamen", new Timestamp(System.currentTimeMillis()), thread_name);
        return candidat_repository.getAllCandidatiOrderByMedieExamen();

    }

    public void adaugareCandidat(Candidat c, String thread_name) throws SQLException {
        candidat_repository.adaugareCandidat(c);
        AuditService.getInstanta().scrieDate("adaugareCandidat", new Timestamp(System.currentTimeMillis()), thread_name);

    }
    public void deleteCandidat(int id_candidat, String thread_name) throws SQLException {
        candidat_repository.deleteCandidat(id_candidat);
        AuditService.getInstanta().scrieDate("deleteCandidat", new Timestamp(System.currentTimeMillis()), thread_name);

    }

    public void deleteAllCandidati(String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("deleteAllCandidati", new Timestamp(System.currentTimeMillis()), thread_name);
        candidat_repository.deleteAllCandidati();
    }

    public void schimbareNumeCandidat(String nume_nou, String nume_vechi, String thread_name) throws SQLException {
        AuditService.getInstanta().scrieDate("schimbareNumeCandidat", new Timestamp(System.currentTimeMillis()), thread_name);
        candidat_repository.schimbareNumeCandidat(nume_nou, nume_vechi);
    }



    
}
