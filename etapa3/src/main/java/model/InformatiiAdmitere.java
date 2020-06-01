package model;

import constante.Constante;

public class InformatiiAdmitere {
    private Examen examen;
    private String informatii_preadmitere;
    private String informatii_postadmitere;
    int id_informatii_admitere;

    public InformatiiAdmitere(String nume_examen, String informatii_preadmitere, String informatii_postadmitere) {
        this.examen = new Examen(nume_examen, "");
        this.informatii_preadmitere = informatii_preadmitere;
        this.informatii_postadmitere = informatii_postadmitere;
    }

    public InformatiiAdmitere(int id_informatii_admitere, String nume_examen, String informatii_preadmitere, String informatii_postadmitere) {
        this.id_informatii_admitere = id_informatii_admitere;
        this.examen = new Examen(nume_examen, "");
        this.informatii_preadmitere = informatii_preadmitere;
        this.informatii_postadmitere = informatii_postadmitere;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getInformatii_preadmitere() {
        return informatii_preadmitere;
    }

    public void setInformatii_preadmitere(String informatii_preadmitere) {
        this.informatii_preadmitere = informatii_preadmitere;
    }

    public String getInformatii_postadmitere() {
        return informatii_postadmitere;
    }

    public void setInformatii_postadmitere(String informatii_postadmitere) {
        this.informatii_postadmitere = informatii_postadmitere;
    }

    @Override
    public String toString() {
        return "InformatiiAdmitere{" +
                "nume_examen=" + examen.getNume() +
                ", informatii_preadmitere='" + informatii_preadmitere + '\'' +
                ", informatii_postadmitere='" + informatii_postadmitere + '\'' +
                '}';
    }
}
