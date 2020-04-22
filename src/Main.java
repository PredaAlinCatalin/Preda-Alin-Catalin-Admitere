import constante.Constante;
import model.*;
import service.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static String generareCNP(){
        Random rand = new Random();
        //https://ro.wikipedia.org/wiki/Cod_numeric_personal

        int AA_aux = rand.nextInt(99) + 1;
        while (!((AA_aux >= 0 && AA_aux <= 2) || (AA_aux >= 97 && AA_aux <= 99))){
            AA_aux = rand.nextInt(99) + 1;
        }

        String AA = Integer.toString(AA_aux);

        if (AA.length() == 1)
            AA = '0' + AA;

        int strain = Math.random() >= 0.999 ? 1 : 0; // probabilitatea sa fie strain si sa aiba cetatenie romana

        int S_vect_1900[] = {1, 2};
        int S_vect_2000[] = {5, 6};
        int S_vect_straini[] = {7, 8};
        String S;

        if (strain == 0){
            int aux = rand.nextInt(2);

            if (AA.compareTo("00") >= 0 && AA.compareTo("02") <= 0)
                S = Integer.toString(S_vect_2000[aux]);
            else
                S = Integer.toString(S_vect_1900[aux]);
        }
        else{
            int aux = rand.nextInt(2);
            S = Integer.toString(S_vect_straini[aux]);

        }

        String LL = Integer.toString(rand.nextInt(12) + 1); // luna nasterii
        if (LL.length() == 1)
            LL = '0' + LL;

        String ZZ; // ziua nasterii
        if (LL.equals("1")|| LL.equals("3") || LL.equals("5") || LL.equals("7") || LL.equals("8") || LL.equals("10") || LL.equals("12"))
            ZZ = Integer.toString(rand.nextInt(31) + 1);
        if (LL.equals("4")|| LL.equals("6") || LL.equals("9") || LL.equals("11"))
            ZZ = Integer.toString(rand.nextInt(30) + 1);
        else
            ZZ = Integer.toString(rand.nextInt(28) + 1);
        if (ZZ.length() == 1)
            ZZ = '0' + ZZ;

        String JJ = Integer.toString(rand.nextInt(52) + 1); // judetul
        if (JJ.length() == 1)
            JJ = '0' + JJ;

        String NNN = Integer.toString(rand.nextInt(999) + 1);
        if (NNN.length() == 2)
            NNN = '0' + NNN;
        else if (NNN.length() == 1)
            NNN = "00" + NNN;

        Long numar_cifra_control = Long.parseUnsignedLong("279146358279");
        int aux_cifra_control[] = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma_aux = 0;
        int cifre_CNP[] = new int[12];
        int S_numar = Integer.parseInt(S);
        cifre_CNP[0] = S_numar;
        int AA_numar = Integer.parseInt(AA);
        cifre_CNP[1] = AA_numar / 10;
        cifre_CNP[2] = AA_numar % 10;
        int LL_numar = Integer.parseInt(LL);
        cifre_CNP[3] = LL_numar / 10;
        cifre_CNP[4] = LL_numar % 10;
        int ZZ_numar = Integer.parseInt(ZZ);
        cifre_CNP[5] = ZZ_numar / 10;
        cifre_CNP[6] = ZZ_numar % 10;
        int JJ_numar = Integer.parseInt(JJ);
        cifre_CNP[7] = JJ_numar / 10;
        cifre_CNP[8] = JJ_numar % 10;
        int NNN_numar = Integer.parseInt(NNN);
        cifre_CNP[9] = NNN_numar / 100;
        cifre_CNP[10] = NNN_numar / 10 % 10;
        cifre_CNP[11] = NNN_numar % 100;

        for (int i = 0; i < 12; i++)
            suma_aux += cifre_CNP[i] * aux_cifra_control[i];

        String C;
        if (suma_aux % 11 == 10)
            C = "1";
        else
            C = Integer.toString(suma_aux % 11);

        String CNP = S + AA + LL + ZZ + JJ + NNN + C;
        return CNP;
    }

    public static void main(String[] args) throws IOException {
        Candidat c1 = new Candidat("Predi", "Alin-Catalin", "1990801123456", 9.97, 9.96, 10, "Stiinte ale naturii");
        Candidat c2 = new Candidat("Preda", "Alin-Catalin", "1990801123457", 9.98, 9.95, 10, "Stiinte ale naturii");
        Candidat c3 = new Candidat("Predu", "Alin-Catalin", "1990801123458", 9.99, 9.94, 10, "Stiinte ale naturii");
        System.out.println();
        System.out.println("Calculam varsta unui candidat pornind de la CNP: " + c1.calculareVarsta());
        System.out.println("Calculam data nasterii pornind de la CNP-ul unui candidat: ");
        c1.afisareDataNasterii();
        System.out.println();

        System.out.println("Ne definim un service pentru clasa Candidat");
        CandidatService candidat_service = new CandidatService();
        System.out.println();

        System.out.println("Adaugam candidati in vectorul de tip Candidat");
        candidat_service.adaugareCandidat(c1);
        candidat_service.adaugareCandidat(c1);
        candidat_service.adaugareCandidat(c2);

        System.out.println("Afisam candidatii adaugati");
        candidat_service.afisareCandidati();

        System.out.println("Cautam candidatul cu medie de bac maxima");
        System.out.println(candidat_service.gasireCandidatMedieBacMaxima());

        System.out.println("Stergem un candidat dupa CNP");
        candidat_service.stergereCandidat(c1.getCNP()); // stergem un candidat dupa CNP-ul lui
        candidat_service.afisareCandidati();

        System.out.println("Stergem un candidat dupa pozitia lui in vectorul de candidati");
        candidat_service.stergerePozitieCandidat(0);
        candidat_service.afisareCandidati();

        System.out.println("Daca incercam o stergere dintr-un vector gol, vom primii o exceptie");
        candidat_service.stergerePozitieCandidat(0);
        candidat_service.afisareCandidati();
        System.out.println();

        System.out.println("Cream Facultatea de Matematica si Informatica");
        FacultateMateInfo fac_mate_info = FacultateMateInfo.getInstanta();
        System.out.println();

        System.out.println("Cream domeniul Informatica al facultatii de mate-info");
        DomeniuInformatica domeniu_info = new DomeniuInformatica();

        System.out.println("Adaugam un candidat daca acesta nu este deja adaugat la domeniul info");
        domeniu_info.getCandidat_service().adaugareCandidat(c1, domeniu_info);
        domeniu_info.getCandidat_service().afisareCandidati();

        System.out.println("Acest apel nu va adauga din nou candidatul c1");
        domeniu_info.getCandidat_service().adaugareCandidat(c1);
        domeniu_info.getCandidat_service().afisareCandidati();

        System.out.println("Adaugam un al doilea candidat la domeniul info");
        domeniu_info.getCandidat_service().adaugareCandidat(c2);
        domeniu_info.getCandidat_service().afisareCandidati();

        System.out.println("Sortam vectorul de candidati al domeniului info");
        Collections.sort(domeniu_info.getCandidat_service().getCandidat());
        domeniu_info.getCandidat_service().afisareCandidati();

        System.out.println("Cream domeniul Matematica al facultatii de mate-info si adaugam un candidat");
        DomeniuMatematica domeniu_mate = new DomeniuMatematica();
        domeniu_mate.getCandidat_service().adaugareCandidat(c3);


        fac_mate_info.adaugareDomeniu(domeniu_info);
        fac_mate_info.adaugareDomeniu(domeniu_mate);
        fac_mate_info.afisareDomenii();

        System.out.println("Stergem un candidat dupa CNP din domeniul de licenta cu indicele 0 al facultatii");
        fac_mate_info.getDomeniuIndex(0).getCandidat_service().stergereCandidat("1990801123456");
        fac_mate_info.afisareCandidatiDomenii();

        System.out.println("Luam informatiile despre examen din domeniul de licenta cu indicele 1 al facultatii\n");
        System.out.println(fac_mate_info.getDomeniuIndex(1).getExamen().getInformatii_examen());
        System.out.println();

        Examen examen = fac_mate_info.getDomeniuIndex(0).getExamen();
        InformatiiAdmitere informatii_admitere = new InformatiiAdmitere(examen);
        informatii_admitere.getInformatii_preadmitere();
        informatii_admitere.getInformatii_postadmitere();

        RepartizareSali repartizare_sali = new RepartizareSali(5, 30);
        repartizare_sali.repartizareCandidat(c1);
        repartizare_sali.repartizareCandidat(c2);
        repartizare_sali.repartizareCandidat(c3);

        String nume_de_familie_aux = "Popescu, Ionescu, Popa, Pop, Niță, Nițu, Constantinescu, Stan, Stanciu, Dumitrescu, Dima, Gheorghiu, Ioniță, Marin, Tudor, Dobre, Barbu, Nistor, Florea, Frățilă, Dinu, Dinescu, Georgescu, Stoica, Diaconu, Diaconescu, Mocanu, Voinea, Albu, Petrescu, Manole, Cristea, Toma, Stănescu, Pușcașu, Tomescu, Sava, Ciobanu, Rusu, Ursu, Lupu, Munteanu, Moldoveanu, Mureșan, Andreescu, Sava, Mihăilescu, Iancu, Teodorescu, Moisescu, Călinescu, Tabacu, Negoiță, Ifrim";
        String nume_de_familie[] = nume_de_familie_aux.split(", ");

        String prenume_feminine_aux = "Maria Elena Ioana Andreea Stefania Gabriela Teodora Ana Alexandra Natalia Ecaterina Georgiana Mihaela Nocoleta Parascheva Irina Petronela Florentina Ionela Victoria";
        String prenume_feminine[] = prenume_feminine_aux.split(" ");

        String prenume_masculine_aux = "Andrei Stefan Alexandru Gabriel Matei Constantin Ionut Luca Rares Tudor Ioan Mihail Teodor Cristian Marian George Petru Florin Iulian Mihail";
        String prenume_masculine[] = prenume_masculine_aux.split(" ");


        fac_mate_info.getDomeniuIndex(0).getCandidat_service().stergerePozitieCandidat(0);

        Random rand = new Random();
        for (int i = 0; i < 25; i++){
            //Candidat c1 = new Candidat("Predi", "Alin-Catalin", "1990801123456", 9.97, 9.96, 10, "Stiinte ale naturii");
            String CNP = generareCNP();
            String nume = nume_de_familie[rand.nextInt(nume_de_familie.length)];
            String prenume;
            if (CNP.charAt(0) == '1' || CNP.charAt(0) == '5' || CNP.charAt(0) == '7')
                prenume = prenume_masculine[rand.nextInt(prenume_masculine.length)];
            else
                prenume = prenume_feminine[rand.nextInt(prenume_feminine.length)];
            double min = 7.5, max = 10;
            double medie_bac =  min + Math.random() * (max - min);
            double medie_proba_obligatorie =  min + Math.random() * (max - min);
            double medie_proba_optionala =  min + Math.random() * (max - min);
            String profil;
            if (Math.random() >= 0.95)
                profil = "Stiinte ale naturii";
            else
                profil = "Matematica-Informatica";
            Candidat c = new Candidat(nume, prenume, CNP, medie_bac, medie_proba_obligatorie, medie_proba_optionala, profil);
            fac_mate_info.getDomeniuIndex(0).getCandidat_service().adaugareCandidat(c, fac_mate_info.getDomeniu());
        }
        fac_mate_info.getDomeniuIndex(0).getCandidat_service().afisareCandidati();

        System.out.println("Calculam rezultatele de la admitere");
        fac_mate_info.getDomeniuIndex(0).getRezultate_admitere().calculareRezultate(fac_mate_info.getDomeniuIndex(0).getCandidat_service());
        fac_mate_info.getDomeniuIndex(0).getRezultate_admitere().afisareRezultateAdmitere();

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Testare etapa a 2-a");

        CandidatIOService candidat_io_service = CandidatIOService.getInstanta();
        candidat_io_service.scriereDate(fac_mate_info.getDomeniuIndex(0).getCandidat_service()); // Luam informatiile din domeniul Informatica al facultatii de MateInfo

        CandidatService candidat_service_test = new CandidatService();
        candidat_service_test.setCandidat(candidat_io_service.citireDate());
        System.out.println("Afisam datele citite din fisierul csv: ");
        candidat_service_test.afisareCandidati();



        Examen examen1 = new Examen(Constante.examen_info);
        Examen examen2 = new Examen(Constante.examen_mate);
        Examen examen3 = new Examen(Constante.examen_cti);

        ArrayList<Examen> lista_examene = new ArrayList<>();
        lista_examene.add(examen1);
        lista_examene.add(examen2);
        lista_examene.add(examen3);

        ExamenIOService examen_io_service = ExamenIOService.getInstanta();
        examen_io_service.scriereDate(lista_examene);

        ArrayList<Examen> lista_examene_fisier = examen_io_service.citireDate();

        System.out.println("Afisam datele citite din fisierul csv: ");
        System.out.println(lista_examene_fisier.size());
        for (int i = 0; i < lista_examene_fisier.size(); i++)
            System.out.println(lista_examene_fisier.get(i));
        System.out.println();

        InformatiiAdmitere informatii_admitere1 = new InformatiiAdmitere(examen1);
        InformatiiAdmitere informatii_admitere2 = new InformatiiAdmitere(examen2);
        InformatiiAdmitere informatii_admitere3 = new InformatiiAdmitere(examen3);

        ArrayList<InformatiiAdmitere> lista_informatii_admitere = new ArrayList<>();
        lista_informatii_admitere.add(informatii_admitere1);
        lista_informatii_admitere.add(informatii_admitere2);
        lista_informatii_admitere.add(informatii_admitere3);

        InformatiiAdmitereIOService informatii_admitere_io_service = InformatiiAdmitereIOService.getInstanta();
        informatii_admitere_io_service.scriereDate(lista_informatii_admitere);

        ArrayList<InformatiiAdmitere> lista_informatii_admitere_fisier = informatii_admitere_io_service.citireDate();

        System.out.println("Afisam datele citite din fisierul csv: ");
        System.out.println(lista_informatii_admitere_fisier.size());
        for (int i = 0; i < lista_informatii_admitere_fisier.size(); i++)
            System.out.println(lista_informatii_admitere_fisier.get(i));
        System.out.println();

        RepartizareSali repartizare_sali1 = new RepartizareSali(4, 30);
        RepartizareSali repartizare_sali2 = new RepartizareSali(6, 35);
        RepartizareSali repartizare_sali3 = new RepartizareSali(5, 40);

        ArrayList<RepartizareSali> lista_repartizare_sali = new ArrayList<>();
        lista_repartizare_sali.add(repartizare_sali1);
        lista_repartizare_sali.add(repartizare_sali2);
        lista_repartizare_sali.add(repartizare_sali3);

        RepartizareSaliIOService repartizare_sali_io_service = RepartizareSaliIOService.getInstanta();
        repartizare_sali_io_service.scriereDate(lista_repartizare_sali);

        ArrayList<RepartizareSali> lista_repartizare_sali_fisier = repartizare_sali_io_service.citireDate();

        System.out.println("Afisam datele citite din fisierul csv: ");
        System.out.println(lista_repartizare_sali_fisier.size());
        for (int i = 0; i < lista_repartizare_sali_fisier.size(); i++)
            System.out.println(lista_repartizare_sali_fisier.get(i));
        




    }
}
