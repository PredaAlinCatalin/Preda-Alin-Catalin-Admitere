package service;

import model.Domeniu;
import model.Facultate;
import model.InformatiiAdmitere;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;

public class FacultateMateInfo implements Facultate {
    private String nume;
    private ArrayList<Domeniu> domeniu;
    private int nr_domenii;
    private int nr_maxim_domenii = 4;
    private static FacultateMateInfo facultate_mate_info = null;
    private InformatiiAdmitere informatii_admitere;

    private FacultateMateInfo() {
        this.nume = "Facultatea de Matematica si Informatica";
        domeniu = new ArrayList<>();
        nr_domenii = 0;
    }

    public static FacultateMateInfo getInstanta(){
        if (facultate_mate_info == null)
            facultate_mate_info = new FacultateMateInfo();
        return facultate_mate_info;
    }

    public void afisareDomenii() {
        AuditService.getInstanta().scrieDate("afisareDomenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        System.out.println("Domenii:");
        for (int i = 0; i < nr_domenii; i++) {
            domeniu.get(i).afisareDomeniu();
        }
        System.out.println();
    }

    public void afisareCandidatiDomenii() {
        AuditService.getInstanta().scrieDate("afisareCandidatiDomenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        System.out.println("Candidati pe domenii:");
        for (int i = 0; i < nr_domenii; i++) {
            domeniu.get(i).afisareDomeniu();
            domeniu.get(i).getCandidat_service().afisareCandidati();
        }
        System.out.println();
    }

    public void adaugareDomeniu(Domeniu c){
        AuditService.getInstanta().scrieDate("sadaugareDomeniu(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        if (nr_maxim_domenii != nr_domenii) {
            domeniu.add(c);
            nr_domenii++;
        }
        else System.out.println("Nu se mai pot adauga domenii - memorie depasita");
    }

    public void stergerePozitiedomeniu(int index){
        AuditService.getInstanta().scrieDate("stergerePozitiedomeniu(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        try{
            domeniu.remove(index);
            nr_domenii--;
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public Domeniu getDomeniuIndex(int index){
        AuditService.getInstanta().scrieDate("getDomeniuIndex(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        return domeniu.get(index);
    }

    public ArrayList<Domeniu> getDomeniu() {
        AuditService.getInstanta().scrieDate("getDomeniu", new Timestamp(System.currentTimeMillis()));
        return domeniu;
    }

    public String getNume() {
        AuditService.getInstanta().scrieDate("getNume(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        return nume;
    }

    public void setNume(String nume) {
        AuditService.getInstanta().scrieDate("setNume(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        this.nume = nume;
    }

    public void setDomeniu(ArrayList<Domeniu> domeniu) {
        AuditService.getInstanta().scrieDate("setDomeniu(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        this.domeniu = domeniu;
    }

    public int getNr_domenii() {
        AuditService.getInstanta().scrieDate("getNr_domenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        return nr_domenii;
    }

    public void setNr_domenii(int nr_domenii) {
        AuditService.getInstanta().scrieDate("setNr_domenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        this.nr_domenii = nr_domenii;
    }

    public int getNr_maxim_domenii() {
        AuditService.getInstanta().scrieDate("getNr_maxim_domenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        return nr_maxim_domenii;
    }

    public void setNr_maxim_domenii(int nr_maxim_domenii) {
        AuditService.getInstanta().scrieDate("setNr_maxim_domenii(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        this.nr_maxim_domenii = nr_maxim_domenii;
    }

    public InformatiiAdmitere getInformatii_admitere() {
        AuditService.getInstanta().scrieDate("getInformatii_admitere(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        return informatii_admitere;
    }

    public void setInformatii_admitere(InformatiiAdmitere informatii_admitere) {
        AuditService.getInstanta().scrieDate("setInformatii_admitere(FacultateMateInfo)", new Timestamp(System.currentTimeMillis()));
        this.informatii_admitere = informatii_admitere;
    }
}

