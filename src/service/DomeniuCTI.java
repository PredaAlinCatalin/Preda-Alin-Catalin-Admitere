package service;

import model.Examen;
import model.Domeniu;

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
        System.out.println("Domeniul de licenta Calculatoare si tehnologia informatiei");
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
