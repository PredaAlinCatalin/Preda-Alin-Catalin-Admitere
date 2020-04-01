package service;

import model.Domeniu;
import model.Examen;

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
        System.out.println("Domeniul de licenta Informatica");
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public CandidatService getCandidat_service() {
        return candidat_service;
    }

    public void setCandidat_service(CandidatService candidat_service) {
        this.candidat_service = candidat_service;
    }

    public RezultateAdmitere getRezultate_admitere() {
        return rezultate_admitere;
    }

    public void setRezultate_admitere(RezultateAdmitere rezultate_admitere) {
        this.rezultate_admitere = rezultate_admitere;
    }
}
