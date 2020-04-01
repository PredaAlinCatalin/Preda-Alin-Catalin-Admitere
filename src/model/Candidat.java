package model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Objects;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Candidat implements Comparable <Candidat>{
    private String nume, prenume, CNP;
    private int id_candidat;
    public static int nr_candidati = 0;
    private double medie_Bac, medie_proba_obligatorie, medie_proba_optionala, medie_examen; // De exemplu la proba obligatorie Matematica, proba optionala Informatica sau Fizica
    private String profil_liceu;

    public Candidat(String nume, String prenume, String CNP, double medie_Bac, double medie_proba_obligatorie, double medie_proba_optionala, String profil_liceu) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.medie_Bac = medie_Bac;
        this.medie_proba_obligatorie = medie_proba_obligatorie;
        this.medie_proba_optionala = medie_proba_optionala;
        this.profil_liceu = profil_liceu;
        this.medie_examen = (medie_proba_obligatorie + medie_proba_optionala) / 2;
        nr_candidati++;
        id_candidat = nr_candidati;

    }

    @Override
    public int compareTo(Candidat c){
        if (medie_examen > c.medie_examen)
            return -1;
        else if (medie_examen < c.medie_examen)
            return 1;
        return 0;
    }

    public int calculareVarsta(){
        int an_nastere = Integer.parseInt(CNP.substring(1, 3));
        int luna_nastere = Integer.parseInt(CNP.substring(3, 5));
        int zi_nastere = Integer.parseInt(CNP.substring(5, 7));
        if (an_nastere >= 0 && an_nastere <= 20)
            an_nastere += 2000;
        else
            an_nastere += 1900;
        Date data_curenta = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        String data_curenta_formatata = formatter.format(data_curenta);
        int an_curent = Integer.parseInt(data_curenta_formatata.substring(0, 2));
        int luna_curenta = Integer.parseInt(data_curenta_formatata.substring(3, 5));
        int zi_curenta = Integer.parseInt(data_curenta_formatata.substring(6, 8));
        if (an_curent >= 0 && an_curent <= 20)
            an_curent += 2000;
        else
            an_curent += 1900;
        int varsta;
        if (luna_curenta > luna_nastere)
            varsta = an_curent - an_nastere;
        else if (luna_curenta == luna_nastere && zi_curenta >= zi_nastere)
            varsta = an_curent - an_nastere;
        else
            varsta = an_curent - an_nastere - 1;
        return varsta;
    }
    public String afisareDataNasterii() {
        String an_nastere = CNP.substring(1, 3);
        String luna_nastere = CNP.substring(3, 5);
        String zi_nastere = CNP.substring(5, 7);
        String data_nastere = "";
        if (Integer.parseInt(an_nastere) >= 0 && Integer.parseInt(an_nastere) <= 20)
            data_nastere += "20" + an_nastere;
        else
            data_nastere += "19" + an_nastere;
        data_nastere += '-' + luna_nastere + '-' + zi_nastere;
        System.out.println("Data nasterii: " + data_nastere);
        String result = "Data nasterii: " + data_nastere;
        return result;
    }



    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public double getMedie_Bac() {
        return medie_Bac;
    }

    public void setMedie_Bac(double medie_Bac) {
        this.medie_Bac = medie_Bac;
    }

    public double getMedie_proba_obligatorie() {
        return medie_proba_obligatorie;
    }

    public void setMedie_proba_obligatorie(double medie_proba_obligatorie) {
        this.medie_proba_obligatorie = medie_proba_obligatorie;
    }

    public double getMedie_proba_optionala() {
        return medie_proba_optionala;
    }

    public void setMedie_proba_optionala(double medie_proba_optionala) {
        this.medie_proba_optionala = medie_proba_optionala;
    }

    public double getMedie_examen() {
        return medie_examen;
    }

    public String getProfil_liceu() {
        return profil_liceu;
    }

    public void setProfil_liceu(String profil_liceu) {
        this.profil_liceu = profil_liceu;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }

    public static int getNr_candidati() {
        return nr_candidati;
    }

    public static void setNr_candidati(int nr_candidati) {
        Candidat.nr_candidati = nr_candidati;
    }

    public void setMedie_examen(double medie_examen) {
        this.medie_examen = medie_examen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return Double.compare(candidat.medie_Bac, medie_Bac) == 0 &&
                Double.compare(candidat.medie_proba_obligatorie, medie_proba_obligatorie) == 0 &&
                Double.compare(candidat.medie_proba_optionala, medie_proba_optionala) == 0 &&
                Double.compare(candidat.medie_examen, medie_examen) == 0 &&
                nume.equals(candidat.nume) &&
                prenume.equals(candidat.prenume) &&
                CNP.equals(candidat.CNP) &&
                profil_liceu.equals(candidat.profil_liceu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, CNP, medie_Bac, medie_proba_obligatorie, medie_proba_optionala, medie_examen, profil_liceu);
    }

    @Override
    public String toString() {
        DecimalFormat df2 = new DecimalFormat("#.##");

        return "Candidat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", id_candidat=" + id_candidat +
                ", medie_Bac=" + df2.format(medie_Bac) +
                ", medie_proba_obligatorie=" + df2.format(medie_proba_obligatorie) +
                ", medie_proba_optionala=" + df2.format(medie_proba_optionala) +
                (medie_examen == 0 ? "" : ", medie_examen=" + df2.format(medie_examen)) +
                ", profil_liceu='" + profil_liceu + '\'' +
                '}';
    }

    public int getId_candidat() {
        return id_candidat;
    }
}
