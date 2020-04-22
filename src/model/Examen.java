package model;
import constante.Constante;

public class Examen {
    private String nume;
    private String informatii_examen;

    public Examen(String nume) {
        this.nume = nume;
        if (nume.equals(Constante.examen_info))
            informatii_examen = "La domeniul de licenta Informatica proba de concurs este o probă scrisă cu redactarea soluțiilor și durata de 3 ore. Se propun patru" +
                    "subiecte câte unul din următoarele discipline studiate în liceu: algebră analiză matematică geometrie" +
                    "și trigonometrie informatică. Candidații tratează în mod obligatoriu subiectul de informatică și la" +
                    "alegere unul dintre celelalte trei subiecte propuse. ";

        else if (nume.equals(Constante.examen_mate))
            informatii_examen = "La domeniul de licenta Matematica proba de concurs este o probă scrisă cu redactarea soluțiilor și durata de 3 ore. Se propun patru" +
                    "subiecte câte unul din următoarele discipline studiate în liceu: algebră analiză matematică geometrie" +
                    "și trigonometrie informatică. Candidații tratează la alegere două dintre cele patru subiecte propuse.";

        else if (nume.equals(Constante.examen_cti))
            informatii_examen = "La domeniul de licenta CTI proba de concurs este o probă scrisă de tip grilă cu durata de 3 ore. Se propun trei subiecte câte" +
                    "unul din următoarele discipline studiate în liceu: matematică informatică fizică. Fiecare subiect" +
                    "conține câte 15 exerciții de tip grilă cu câte 4 variante de răspuns. Subiectul de matematică este" +
                    "compus din câte 5 exerciții de algebră analiză matematică respectiv geometrie și trigonometrie." +
                    "Subiectul de fizică este compus din câte 5 exerciții de mecanică termodinamică respectiv curent" +
                    "continuu. Candidații tratează în mod obligatoriu subiectul de matematică și la alegere unul dintre" +
                    "celelalte două subiecte propuse informatică sau fizică. ";
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
