package repository;

import model.Candidat;
import model.Domeniu;

import java.lang.reflect.Array;
import java.util.*;

public class CandidatRepository{
    private ArrayList<Candidat> candidat;

    public CandidatRepository() {
        candidat = new ArrayList<>();
    }

    public void afisareCandidati(){
        System.out.println("Numar candidati: " + candidat.size());
        for (int i = 0; i < candidat.size(); i++)
            System.out.println(candidat.get(i));
        System.out.println();
    }

    public void adaugareCandidat(Candidat c){
        boolean ok2 = true;
        for (int i = 0; i < candidat.size(); i++)
            if (c.equals(candidat.get(i))){
                ok2 = false;
                break;
            }
        if (ok2 == true) {
            candidat.add(candidat.size(),new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu()));
        }
    }

    public void adaugareCandidat(Candidat c, Domeniu domeniu){
        boolean ok = true;

        if (domeniu.getCandidat_service().getCandidat().contains(c))
            ok = false;

        if (ok == true) {
            boolean ok2 = true;

            if (candidat.contains(c))
                ok2 = false;
            if (ok2 == true) {
                candidat.add(candidat.size(),new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu()));
            }
        }
    }

    public void adaugareCandidat(Candidat c, ArrayList<Domeniu> domeniu){
        boolean ok = true;
        for (int i = 0; i < domeniu.size() && ok == true; i++)
            if (domeniu.get(i).getCandidat_service().getCandidat().contains(c))
                ok = false;
        if (ok == true) {
            boolean ok2 = true;
            if (candidat.contains(c))
                ok2 = false;
            if (ok2 == true) {
                candidat.add(candidat.size(),new Candidat(c.getNume(), c.getPrenume(), c.getCNP(), c.getMedie_Bac(), c.getMedie_proba_obligatorie(), c.getMedie_proba_optionala(), c.getProfil_liceu()));
            }
        }
    }

    public void stergerePozitieCandidat(int index){

        try{
            candidat.remove(index);

        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void stergereCandidat(String CNP){
        int index = gasireCandidat(CNP);
        stergerePozitieCandidat(index);
    }

    public int gasireCandidat(String CNP){
        for (int i = 0; i < candidat.size(); i++)
            if (CNP.equals(candidat.get(i).getCNP()))
                return i;
        return -1;
    }

    public Candidat gasireCandidatMedieBacMaxima()
    {
        double maxim = 0;
        int poz = -1;
        for (int i = 0; i < candidat.size(); i++)
            if (candidat.get(i).getMedie_Bac() > maxim) {
                maxim = candidat.get(i).getMedie_Bac();
                poz = i;
            }
        return getCandidatIndex(poz);
    }

    public ArrayList<Candidat> ordonareMedieExamen(){
        ArrayList<Candidat> temp = getCopieCandidati();
        Collections.sort(temp);
        return temp;

    }

    public ArrayList<Candidat> getCopieCandidati(){
        ArrayList<Candidat> temp = new ArrayList<>(candidat.size());
        for (int i = 0; i < candidat.size(); i++)
            temp.add(new Candidat(candidat.get(i).getNume(), candidat.get(i).getPrenume(), candidat.get(i).getCNP(), candidat.get(i).getMedie_Bac(),
                    candidat.get(i).getMedie_proba_obligatorie(), candidat.get(i).getMedie_proba_optionala(), candidat.get(i).getProfil_liceu()));
        return temp;
    }

    public Candidat getCopieCandidat(Candidat candidat){
        Candidat temp = new Candidat(candidat.getNume(), candidat.getPrenume(), candidat.getCNP(), candidat.getMedie_Bac(),
                candidat.getMedie_proba_obligatorie(), candidat.getMedie_proba_optionala(), candidat.getProfil_liceu());
        return temp;
    }

    public Candidat getCandidatIndex(int index){
        return candidat.get(index);
    }

    public ArrayList<Candidat> getCandidat() {
        return candidat;
    }

    public void setCandidat(ArrayList<Candidat> candidat) {
        this.candidat = candidat;
    }
}
