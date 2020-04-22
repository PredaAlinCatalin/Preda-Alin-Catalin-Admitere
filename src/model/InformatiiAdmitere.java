package model;

import constante.Constante;

public class InformatiiAdmitere {
    private Examen examen;
    private String informatii_preadmitere;
    private String informatii_postadmitere;

    public InformatiiAdmitere(Examen examen) {
        this.examen = examen;
        if (examen.getNume().equals(Constante.examen_info) || examen.getNume().equals(Constante.examen_mate) ||
                examen.getNume().equals(Constante.examen_cti)) {
            informatii_postadmitere = "Informatii Post-Admitere" +
                    " 1. Cazare in caminele UB: Calendar cazare FMI: http://fmi.unibuc.ro/ro/pdf/2019/cazare/Calendar_Cazare_FMI.pdf." +
                    " ~  Numar locuri FMI: http://fmi.unibuc.ro/ro/pdf/2019/cazare/Locuri_FMI_Camine.pdf " +
                    " ~  Calendar cazare UB: http://fmi.unibuc.ro/ro/pdf/2019/cazare/Calendar_Cazare_UB.pdf " +
                    " ~  Anunt cazare: http://fmi.unibuc.ro/ro/pdf/2019/cazare/ANUNT_CAZARE_2019-2020.pdf " +
                    " ~  Cerere de cazare: http://fmi.unibuc.ro/ro/pdf/2019/cazare/CERERE-DE-CAZARE-2019-2020.pdf " +
                    " ~  Metodologia generala de cazare a UB: http://fmi.unibuc.ro/ro/pdf/2019/cazare/Metodologie-privind-cazarea-in-caminele-Universitatii-din-Bucuresti.pdf" +
                    " 2. Cursurile de aducere la nivel pentru candidatii admisi se vor desfasura in perioada 9-20 septembrie 2019. Cursurile se vor tine la disciplinele Matematica" +
                    " si Programare in C cf. urmatorului program: http://fmi.unibuc.ro/ro/pdf/2019/admitere/licenta/Program_CAN_2019.pdf" +
                    " ~  Prioritate au candidatii admisi la domeniul Matematica cu media sub 7 (pentru cursurile de Matematica) respectiv cei admisi la domeniile CTI sau" +
                    " Informatica ID (pentru cursurile de Programare in C)." +
                    " ~  Pentru inscriere va rugam sa completati formularul de la adresa: https://docs.google.com/forms/d/e/1FAIpQLSeOxoj0rktzARPoej7LrFlJFA2xdEr3DJspyorosVofjkUGTQ/viewform" +
                    " ~  Lista studentilor inscrisi la cursurile de aducere pana in data de 8 septembrie 2019: http://fmi.unibuc.ro/ro/pdf/2019/admitere/licenta/CAN_2019_lista_studenti.pdf" +
                    " ~  Candidatii care au solicitat cazare pentru cursurile de aducere la nivel se vor prezenta la caminul Grozavesti B luni 9 septembrie 2019 intre orele 9:00 si 12:00." +
                    " Adresa: Splaiul Independentei nr. 204; mijloace de transport: Metrou - Grozavesti RATB - 1 601 105. Taxa de cazare este de 25 lei pe noapte." +
                    " 3. Repartizarea in grupe: Cereri de repartizare cu alti colegi admisi la acelasi domeniu de licenta invatamant cu frecventa: http://fmi.unibuc.ro/ro/pdf/2019/admitere/licenta/ANUNT-Cereri_repartizare_grupe_2019.pdf" +
                    " Felicitari promotiei 2021/2022 care a intrat in Facultatea de Matematica si Informatica! Candidatii admisi si confirmati sunt invitati sa se inscrie in grupul" +
                    " oficial al promotiei - FMI 2019 si sa urmareasca site-ul facultatii pentru a se informa despre inceperea anului universitar." +
                    " 4. Facultatea de Matematica si Informatica nu mai organizeaza admitere pentru programele de licenta in luna septembrie 2019.";
        }

        if (examen.getNume().equals(Constante.examen_info) || examen.getNume().equals(Constante.examen_mate) ||
                examen.getNume().equals(Constante.examen_cti)) {
            informatii_preadmitere = " Informatii Pre-Admitere" +
                    " 1. Aplicatia de inscriere online a fost publicata la adresa https://admitere.fmi.unibuc.ro. Crearea contului si autentificarea" +
                    " se face din meniul din dreapta sus. La crearea contului veti primi un mesaj cu un link de confirmare pe adresa de email pe care ati completat-o." +
                    " 2. Daca nu primiti mesajul in Inbox va rugam sa il cautati si in Spam pe unele servere de email poate ajunge acolo si sa il declarati ca nu este spam" +
                    " pentru ca respectivele servere de email sa invete in timp. Daca intampinati probleme cu aplicatia va rugam sa ne scrieti pe adresa admitere@fmi.unibuc.ro." +
                    " 3. Noutati in metodologia de admitere 2019: La inscrierea in facultate sau la confirmarea locului (pentru candidatii care se inscriu online) candidatii vor depune" +
                    " un singur dosar de inscriere cu o singura fisa de inscriere si un singur rand de acte indiferent la cate domenii de licenta se inscriu. In fisa de " +
                    "inscriere (generata din aplicatie) vor fi trecute toate domeniile de licenta pentru care se face inscrierea in ordinea preferintelor fiecarui candidat. " +
                    " 4. Candidatii care se inscriu la mai multe domenii de licenta vor putea concura pe listele finale la toate domeniile la care au obtinut media de admitere cel " +
                    " putin 5 in ordinea preferintelor din fisa de inscriere atat pentru locurile de la buget cat si pentru cele cu taxa." +
                    " 5. Aplicatia online de inscriere la admitere va fi disponibila incepand din data de 8 iulie 2019. Daca va inscrieti online nu mai este nevoie sa veniti la" +
                    " facultate decat la sustinerea probei de concurs si apoi la confirmarea locului (de admis sau in asteptare). In plus beneficiati de o reducere de 25% din" +
                    " valoarea taxei de inscriere. Daca aveti probleme cu utilizarea aplicatiei online puteti sa va inscrieti la facultate dar in acest caz este posibil sa fie" +
                    " cozi la inscriere sau plata taxei trebuie sa veniti cu dosarul de inscriere cu acte si nu mai beneficiati de reducerea de taxa. Diferentele dintre inscrierea" +
                    " online si inscrierea la facultate." +
                    " 6. Inscrirea fara diploma/adeverinta de bacalaureat (promotia curenta): Candidatii care au sustinut bacalaureatul in sesiunea curenta - 2019 - se pot inscrie online" +
                    " fara diploma sau adeverinta de bacalaureat prin specificarea in aplicatia de inscriere a acordului de a le fi preluate rezultatele la bacalaureat din aplicatia" +
                    " SIIIR pusa la dispozitie facultatilor de catre MEN. Inscrierea pe baza rezultatelor la bacalaureat descarcate din SIIR este disponibila si la facultate dar doar" +
                    " dupa publicarea rezultatelor finale in SIIIR de catre MEN. incepand cu data de 13 iulie 2019." +
                    " 7. Taxa de inscriere la admitere se poate plati si online la adresa: https://po.unibuc.ro/admitere.php. Candidatii care se insciu online beneficiaza de reducere" +
                    " de 25% din valoare taxei de inscriere la admitere indiferent de numarul de domenii la care candideaza. La inscrierea online plata se face dupa completarea" +
                    " formularului la valoarea calculata in aplicatie in functie de numarul de domenii la care se face inscrierea si de eventuala scutire de taxa la care are" +
                    " dreptul candidatul. Atentie: doar plata taxei de inscriere nu reprezinta dovada de inscriere la concursul de admitere. Inscrierea propriu-zisa se face prin" +
                    " parcurgerea tuturor pasilor prevazuti." +
                    " 8. Cazarea pe perioada admiterii: Candidatii la admitere se pot caza gratuit in caminele UB pe perioada admiterii pentru maxim 3 nopti pe baza legitimatiei" +
                    " de concurs in limita locurilor disponibile. Candidatii care doresc sa se cazeze in camin pe perioada admiterii trebuie sa completeze acest formular pana in " +
                    " data de 14 iulie 2019." ;

        }
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
