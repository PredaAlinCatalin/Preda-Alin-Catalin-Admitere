package service;

import model.Candidat;
import model.Domeniu;
import repository.CandidatRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class CandidatService {
    private CandidatRepository candidat_repository;

    public CandidatService() {
        candidat_repository = new CandidatRepository();
    }
    public void afisareCandidati(){
        candidat_repository.afisareCandidati();
        AuditService.getInstanta().scrieDate("afisareCandidati", new Timestamp(System.currentTimeMillis()));
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu){
        candidat_repository.adaugareCandidat(c, domeniu);
        AuditService.getInstanta().scrieDate("adaugareCandidat", new Timestamp(System.currentTimeMillis()));

    }

    public void adaugareCandidat(Candidat c, ArrayList<Domeniu> domeniu){
        candidat_repository.adaugareCandidat(c, domeniu);
        AuditService.getInstanta().scrieDate("adaugareCandidat", new Timestamp(System.currentTimeMillis()));

    }

    public void adaugareCandidat(Candidat c){
        candidat_repository.adaugareCandidat(c);
        AuditService.getInstanta().scrieDate("adaugareCandidat", new Timestamp(System.currentTimeMillis()));

    }
    public void stergerePozitieCandidat(int index){
        candidat_repository.stergerePozitieCandidat(index);
        AuditService.getInstanta().scrieDate("stergerePozitieCandidat", new Timestamp(System.currentTimeMillis()));

    }
    public void stergereCandidat(String CNP){
        candidat_repository.stergereCandidat(CNP);
        AuditService.getInstanta().scrieDate("stergereCandidat", new Timestamp(System.currentTimeMillis()));

    }
    public int gasireCandidat(String CNP){
        AuditService.getInstanta().scrieDate("gasireCandidat", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.gasireCandidat(CNP);

    }
    public Candidat gasireCandidatMedieBacMaxima() {
        AuditService.getInstanta().scrieDate("gasireCandidatMedieBacMaxima", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.gasireCandidatMedieBacMaxima();

    }
    public ArrayList<Candidat> getCopieCandidati(){
        AuditService.getInstanta().scrieDate("getCopieCandidati", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.getCopieCandidati();
    }
    public Candidat getCopieCandidat(Candidat c){
        AuditService.getInstanta().scrieDate("getCopieCandidat", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.getCopieCandidat(c);
    }
    public ArrayList<Candidat> ordonareMedieExamen(){
        AuditService.getInstanta().scrieDate("ordonareMedieExamen", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.ordonareMedieExamen();
    }
    public Candidat getCandidatIndex(int index){
        AuditService.getInstanta().scrieDate("getCandidatIndex", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.getCandidatIndex(index);
    }
    public ArrayList<Candidat> getCandidat(){
        AuditService.getInstanta().scrieDate("getCandidat", new Timestamp(System.currentTimeMillis()));
        return candidat_repository.getCandidat();
   }
    public void setCandidat(ArrayList<Candidat> candidat) {
        AuditService.getInstanta().scrieDate("setCandidat", new Timestamp(System.currentTimeMillis()));
        candidat_repository.setCandidat(candidat);
    }
}
