package service;

import model.Candidat;
import model.Examen;
import repository.CandidatRepository;
import service.CandidatService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class RezultateAdmitere {
    private Examen examen;
    private CandidatService candidati_buget;
    private CandidatService candidati_taxa;
    private int nr_locuri_buget;
    private int nr_locuri_taxa;

    public RezultateAdmitere(Examen examen) {
        this.examen = examen;
        if (examen.getNume().equals("Examen la domeniul de licenta Informatica") || examen.getNume().equals("Examen la domeniul de licenta Matematica") ||
                examen.getNume().equals("Examen la domeniul de licenta Calculatoare si tehnologia informatiei")){
            nr_locuri_buget = 10;
            nr_locuri_taxa = 5;
        }
        candidati_buget = new CandidatService();
        candidati_taxa = new CandidatService();
    }
    public void calculareRezultate(CandidatService candidat_service){
        AuditService.getInstanta().scrieDate("calculareRezultate(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        ArrayList<Candidat> aux = candidat_service.ordonareMedieExamen();
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < aux.size(); i++)
            System.out.println(aux.get(i));
        if (nr_locuri_buget > aux.size()){
            Candidat aux1[] = new Candidat[aux.size()];
            for (int i = 0; i < aux.size(); i++)
                candidati_buget.adaugareCandidat(aux.get(i));
        }
        else if (nr_locuri_buget + nr_locuri_taxa < aux.size()){
            for (int i = 0; i < nr_locuri_buget; i++)
                candidati_buget.adaugareCandidat(aux.get(i));

            for (int i = 0; i < nr_locuri_taxa; i++)
                candidati_taxa.adaugareCandidat(aux.get(i + nr_locuri_buget));
        }
        else{
            ArrayList<Candidat> aux1 = new ArrayList<Candidat>(nr_locuri_buget);
            for (int i = 0; i < nr_locuri_buget; i++)
                candidati_buget.adaugareCandidat(aux.get(i));
            int nr_candidati_ramasi = aux.size() - aux1.size();
            for (int i = 0; i < nr_candidati_ramasi; i++)
                candidati_taxa.adaugareCandidat(aux.get(i + nr_locuri_buget));
        }
    }

    public void afisareRezultateAdmitere()
    {
        AuditService.getInstanta().scrieDate("afisareRezultateAdmitere(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        System.out.println("Candidatii acceptati la buget:");
        candidati_buget.afisareCandidati();
        System.out.println();
        System.out.println("Candidatii acceptati la taxa:");
        candidati_taxa.afisareCandidati();

    }

    public Examen getExamen() {
        AuditService.getInstanta().scrieDate("getExamen(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        return examen;
    }

    public void setExamen(Examen examen) {
        AuditService.getInstanta().scrieDate("setExamen(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        this.examen = examen;
    }

    public CandidatService getCandidati_buget() {
        AuditService.getInstanta().scrieDate("getCandidati_buget(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        return candidati_buget;
    }

    public void setCandidati_buget(CandidatService candidati_buget) {
        AuditService.getInstanta().scrieDate("setCandidati_buget(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        this.candidati_buget = candidati_buget;
    }

    public CandidatService getCandidati_taxa() {
        AuditService.getInstanta().scrieDate("getCandidati_taxa(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        return candidati_taxa;
    }

    public void setCandidati_taxa(CandidatService candidati_taxa) {
        AuditService.getInstanta().scrieDate("setCandidati_taxa(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        this.candidati_taxa = candidati_taxa;
    }

    public int getNr_locuri_buget() {
        AuditService.getInstanta().scrieDate("getNr_locuri_buget(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        return nr_locuri_buget;
    }

    public void setNr_locuri_buget(int nr_locuri_buget) {
        AuditService.getInstanta().scrieDate("setNr_locuri_buget(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        this.nr_locuri_buget = nr_locuri_buget;
    }

    public int getNr_locuri_taxa() {
        AuditService.getInstanta().scrieDate("getNr_locuri_taxa(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        return nr_locuri_taxa;
    }

    public void setNr_locuri_taxa(int nr_locuri_taxa) {
        AuditService.getInstanta().scrieDate("setNr_locuri_taxa(RezultateAdmitere)", new Timestamp(System.currentTimeMillis()));
        this.nr_locuri_taxa = nr_locuri_taxa;
    }
}
