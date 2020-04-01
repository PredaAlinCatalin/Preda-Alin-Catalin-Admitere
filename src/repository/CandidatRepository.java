package repository;

import model.Candidat;
import model.Domeniu;

import java.util.Arrays;
import java.util.Comparator;

public class CandidatRepository{
    private Candidat candidat[];
    private int nr_candidati;
    private int nr_maxim_candidati = 5;

    public CandidatRepository() {
        candidat = new Candidat[1];
        nr_candidati = 0;
    }

    public void afisareCandidati(){
        System.out.println("Numar candidati: " + nr_candidati);
        for (int i = 0; i < nr_candidati; i++)
            System.out.println(candidat[i]);
        System.out.println();
    }

    public void adaugareCandidat(Candidat c){
        boolean ok2 = true;
        for (int i = 0; i < nr_candidati; i++)
            if (c.equals(candidat[i])){
                ok2 = false;
                break;
            }
        if (ok2 == true) {
            redimensionareVector(1);
            candidat[nr_candidati] = new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu());
            nr_candidati++;
        }
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu){
        boolean ok = true;
        for (int j = 0; j < domeniu.getCandidat_service().getCandidat().length; j++)
            if (c.equals(domeniu.getCandidat_service().getCandidatIndex(j))){
                ok = false;
                break;
            }
        if (ok == true) {
            boolean ok2 = true;
            for (int i = 0; i < nr_candidati; i++)
                if (c.equals(candidat[i])){
                    ok2 = false;
                    break;
                }
            if (ok2 == true) {
                redimensionareVector(1);
                candidat[nr_candidati] = new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu());
                nr_candidati++;
            }
        }
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu[]){
        boolean ok = true;
        for (int i = 0; i < domeniu.length && ok == true; i++)
            for (int j = 0; j < domeniu[i].getCandidat_service().getCandidat().length; j++)
                if (candidat.equals(domeniu[i].getCandidat_service().getCandidatIndex(j))){
                    ok = false;
                    break;
                }
        if (ok == true) {
            boolean ok2 = true;
            for (int i = 0; i < nr_candidati; i++)
                if (c.equals(candidat[i])){
                    ok2 = false;
                    break;
                }
            if (ok2 == true) {
                redimensionareVector(1);
                candidat[nr_candidati] = new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu());
                nr_candidati++;
            }
        }
    }

    public void stergerePozitieCandidat(int index){
        try{

            for (int i = index; i < nr_candidati - 1; i++)
                candidat[i] = candidat[i + 1];
            candidat[nr_candidati - 1] = null;
            nr_candidati--;

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index-ul este incorect(este " + (index < 0 ? "negativ" : "mai mare decat dimensiunea vectorului") + ")" + e);
        }
    }

    public void stergereCandidat(String CNP){
        int index = gasireCandidat(CNP);
        stergerePozitieCandidat(index);
    }

    public int gasireCandidat(String CNP){
        for (int i = 0; i < nr_candidati; i++)
            if (CNP.equals(candidat[i].getCNP()))
                return i;
        return -1;
    }

    public Candidat gasireCandidatMedieBacMaxima()
    {
        double maxim = 0;
        int poz = -1;
        for (int i = 0; i < nr_candidati; i++)
            if (candidat[i].getMedie_Bac() > maxim) {
                maxim = candidat[i].getMedie_Bac();
                poz = i;
            }
        return getCandidatIndex(poz);
    }

    public Candidat[] ordonareMedieExamen(){
        Candidat temp[] = getCopieCandidati();
        Arrays.sort(temp);
        return temp;

    }

    public Candidat[] getCopieCandidati(){
        Candidat temp[] = new Candidat[nr_candidati];
        for (int i = 0; i < nr_candidati; i++)
            temp[i] = new Candidat(candidat[i].getNume(), candidat[i].getPrenume(), candidat[i].getCNP(), candidat[i].getMedie_Bac(),
                    candidat[i].getMedie_proba_obligatorie(), candidat[i].getMedie_proba_optionala(), candidat[i].getProfil_liceu());
        return temp;
    }

    public Candidat getCopieCandidat(Candidat candidat){
        Candidat temp = new Candidat(candidat.getNume(), candidat.getPrenume(), candidat.getCNP(), candidat.getMedie_Bac(),
                candidat.getMedie_proba_obligatorie(), candidat.getMedie_proba_optionala(), candidat.getProfil_liceu());
        return temp;
    }

    public Candidat getCandidatIndex(int index){
        return candidat[index];
    }

    public void redimensionareVector(int size){
        Candidat temp[] = new Candidat[nr_candidati + size];
        for (int i = 0; i < nr_candidati; i++)
            temp[i] = getCopieCandidat(candidat[i]);
        candidat = temp;
    }

    public Candidat[] getCandidat() {
        return candidat;
    }

    public int getNr_candidati() {
        return nr_candidati;
    }

    public void setNr_candidati(int nr_candidati) {
        this.nr_candidati = nr_candidati;
    }

    public int getNr_maxim_candidati() {
        return nr_maxim_candidati;
    }

    public void setNr_maxim_candidati(int nr_maxim_candidati) {
        this.nr_maxim_candidati = nr_maxim_candidati;
    }

    public void setCandidat(Candidat[] candidat) {
        this.candidat = candidat;
    }
}
