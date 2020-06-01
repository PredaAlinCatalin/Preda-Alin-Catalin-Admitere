package model;
import constante.Constante;

public class Examen {
    private String nume;
    private String informatii_examen;
    private int id_examen;

    public Examen(String nume, String informatii) {
        this.nume = nume;
        this.informatii_examen = informatii;
    }

    public Examen(int id_examen, String nume, String informatii) {
        this.id_examen = id_examen;
        this.nume = nume;
        this.informatii_examen = informatii;
    }

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getInformatii_examen() {
        return informatii_examen;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "nume='" + nume + '\'' +
                ", informatii_examen='" + informatii_examen + '\'' +
                '}';
    }

    public void setInformatii_examen(String informatii_examen) {
        this.informatii_examen = informatii_examen;
    }
}
