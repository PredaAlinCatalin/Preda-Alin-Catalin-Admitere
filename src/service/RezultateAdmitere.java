package service;

import model.Candidat;
import model.Examen;
import repository.CandidatRepository;
import service.CandidatService;

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
        Candidat aux[] = candidat_service.ordonareMedieExamen();
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < aux.length; i++)
            System.out.println(aux[i]);
        if (nr_locuri_buget > aux.length){
            Candidat aux1[] = new Candidat[aux.length];
            for (int i = 0; i < aux.length; i++)
                candidati_buget.adaugareCandidat(aux[i]);
        }
        else if (nr_locuri_buget + nr_locuri_taxa < aux.length){
            for (int i = 0; i < nr_locuri_buget; i++)
                candidati_buget.adaugareCandidat(aux[i]);

            for (int i = 0; i < nr_locuri_taxa; i++)
                candidati_taxa.adaugareCandidat(aux[i + nr_locuri_buget]);
        }
        else{
            Candidat aux1[] = new Candidat[nr_locuri_buget];
            for (int i = 0; i < nr_locuri_buget; i++)
                candidati_buget.adaugareCandidat(aux[i]);
            int nr_candidati_ramasi = aux.length - aux1.length;
            for (int i = 0; i < nr_candidati_ramasi; i++)
                candidati_taxa.adaugareCandidat(aux[i + nr_locuri_buget]);
        }
    }

    public void afisareRezultateAdmitere()
    {
        System.out.println("Candidatii acceptati la buget:");
        candidati_buget.afisareCandidati();
        System.out.println();
        System.out.println("Candidatii acceptati la taxa:");
        candidati_taxa.afisareCandidati();

    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public CandidatService getCandidati_buget() {
        return candidati_buget;
    }

    public void setCandidati_buget(CandidatService candidati_buget) {
        this.candidati_buget = candidati_buget;
    }

    public CandidatService getCandidati_taxa() {
        return candidati_taxa;
    }

    public void setCandidati_taxa(CandidatService candidati_taxa) {
        this.candidati_taxa = candidati_taxa;
    }

    public int getNr_locuri_buget() {
        return nr_locuri_buget;
    }

    public void setNr_locuri_buget(int nr_locuri_buget) {
        this.nr_locuri_buget = nr_locuri_buget;
    }

    public int getNr_locuri_taxa() {
        return nr_locuri_taxa;
    }

    public void setNr_locuri_taxa(int nr_locuri_taxa) {
        this.nr_locuri_taxa = nr_locuri_taxa;
    }
}
