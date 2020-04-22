package service;

import model.Examen;
import model.Domeniu;

import java.sql.Timestamp;

public class DomeniuCTI extends Domeniu{

    private Examen examen;
    private CandidatService candidat_service;
    private RezultateAdmitere rezultate_admitere;
    public DomeniuCTI(){

        examen = new Examen("Examen la domeniul de licenta Calculatoare si tehnologia informatiei");
        rezultate_admitere = new RezultateAdmitere(examen);
        candidat_service = new CandidatService();
    }

    public void afisareDomeniu(){       
        AuditService.getInstanta().scrieDate("afisareDomeniu(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        System.out.println("Domeniul de licenta Calculatoare si tehnologia informatiei");
    }

    public Examen getExamen() {
        AuditService.getInstanta().scrieDate("getExamen(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        return examen;
    }

    public void setExamen(Examen examen) {
        AuditService.getInstanta().scrieDate("setExamen(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        this.examen = examen;
    }

    public CandidatService getCandidat_service() {
        AuditService.getInstanta().scrieDate("getCandidat_service(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        return candidat_service;
    }

    public void setCandidat_service(CandidatService candidat_service) {
        AuditService.getInstanta().scrieDate("setCandidat_service(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        this.candidat_service = candidat_service;
    }

    public RezultateAdmitere getRezultate_admitere() {
        AuditService.getInstanta().scrieDate("getRezultate_admitere(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        return rezultate_admitere;
    }

    public void setRezultate_admitere(RezultateAdmitere rezultate_admitere) {
        AuditService.getInstanta().scrieDate("setRezultate_admitere(DomeniuCTI)", new Timestamp(System.currentTimeMillis()));

        this.rezultate_admitere = rezultate_admitere;
    }
}
