package service;

import model.Domeniu;
import model.Facultate;
import model.InformatiiAdmitere;

public class FacultateMateInfo implements Facultate {
    private String nume;
    private Domeniu domeniu[];
    private int nr_domenii;
    private int nr_maxim_domenii = 4;
    private static FacultateMateInfo facultate_mate_info = null;
    private InformatiiAdmitere informatii_admitere;

    private FacultateMateInfo() {
        this.nume = "Facultatea de Matematica si Informatica";
        domeniu = new Domeniu[3];
        nr_domenii = 0;
    }

    public static FacultateMateInfo getInstanta(){
        if (facultate_mate_info == null)
            facultate_mate_info = new FacultateMateInfo();
        return facultate_mate_info;
    }

    public void afisareDomenii() {
        System.out.println("Domenii:");
        for (int i = 0; i < nr_domenii; i++) {
            domeniu[i].afisareDomeniu();
        }
        System.out.println();
    }

    public void afisareCandidatiDomenii() {
        System.out.println("Candidati pe domenii:");
        for (int i = 0; i < nr_domenii; i++) {
            domeniu[i].afisareDomeniu();
            domeniu[i].getCandidat_service().afisareCandidati();
        }
        System.out.println();
    }

    public void adaugareDomeniu(Domeniu c){
        if (nr_maxim_domenii != nr_domenii)
            domeniu[nr_domenii++] = c;
        else System.out.println("Nu se mai pot adauga domenii - memorie depasita");
    }

    public void stergerePozitiedomeniu(int index){
        try{
            for (int i = index; i < nr_domenii - 1; i++)
                domeniu[i] = domeniu[i + 1];
            domeniu[nr_domenii - 1] = null;
            nr_domenii--;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index-ul este incorect(este " + (index < 0 ? "negativ" : "mai mare decat dimensiunea vectorului") + ")" + e);
        }
    }

    public Domeniu getDomeniuIndex(int index){
        return domeniu[index];
    }

    public Domeniu[] getDomeniu() {
        return domeniu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDomeniu(Domeniu[] domeniu) {
        this.domeniu = domeniu;
    }

    public int getNr_domenii() {
        return nr_domenii;
    }

    public void setNr_domenii(int nr_domenii) {
        this.nr_domenii = nr_domenii;
    }

    public int getNr_maxim_domenii() {
        return nr_maxim_domenii;
    }

    public void setNr_maxim_domenii(int nr_maxim_domenii) {
        this.nr_maxim_domenii = nr_maxim_domenii;
    }

    public InformatiiAdmitere getInformatii_admitere() {
        return informatii_admitere;
    }

    public void setInformatii_admitere(InformatiiAdmitere informatii_admitere) {
        this.informatii_admitere = informatii_admitere;
    }
}

