package service;

import model.Domeniu;
import model.Examen;

import java.sql.Timestamp;

public class DomeniuInformatica extends Domeniu {

    private Examen examen;
    private CandidatService candidat_service;
    private RezultateAdmitere rezultate_admitere;

    public DomeniuInformatica(){

        examen = new Examen("Examen la domeniul de licenta Informatica");
        candidat_service = new CandidatService();
        rezultate_admitere = new RezultateAdmitere(examen);

    }

    public void afisareDomeniu(){       
        AuditService.getInstanta().scrieDate("afisareDomeniu(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        System.out.println("Domeniul de licenta Informatica");
    }

    public Examen getExamen() {
        AuditService.getInstanta().scrieDate("getExamen(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        return examen;
    }

    public void setExamen(Examen examen) {
        AuditService.getInstanta().scrieDate("setExamen(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        this.examen = examen;
    }

    public CandidatService getCandidat_service() {
        AuditService.getInstanta().scrieDate("getCandidat_service(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        return candidat_service;
    }

    public void setCandidat_service(CandidatService candidat_service) {
        AuditService.getInstanta().scrieDate("setCandidat_service(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        this.candidat_service = candidat_service;
    }

    public RezultateAdmitere getRezultate_admitere() {
        AuditService.getInstanta().scrieDate("getRezultate_admitere(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        return rezultate_admitere;
    }

    public void setRezultate_admitere(RezultateAdmitere rezultate_admitere) {
        AuditService.getInstanta().scrieDate("setRezultate_admitere(DomeniuInformatica)", new Timestamp(System.currentTimeMillis()));

        this.rezultate_admitere = rezultate_admitere;
    }
}
