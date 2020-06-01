package main;

import constante.Constante;
import gui.ManageCandidatFrame;
import model.*;
import repository.DbConnectionUtil;
import service.*;
import thread.MyThread;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main extends Thread{
    @Override
    public void run() {
        super.run();
    }

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

    public static void main(String[] args) throws IOException, SQLException {
        MyThread th = new MyThread();
//        th.start();

        Candidat c1 = new Candidat("Predi", "Alin-Catalin", "1990801123456", 9.97, 9.96, 10, "Stiinte ale naturii");
        Candidat c2 = new Candidat("Preda", "Alin-Catalin", "1990801123457", 9.98, 9.95, 10, "Stiinte ale naturii");
        Candidat c3 = new Candidat("Predu", "Alin-Catalin", "1990801123458", 9.99, 9.94, 10, "Stiinte ale naturii");
        System.out.println();
        System.out.println("Calculam varsta unui candidat pornind de la CNP: " + c1.calculareVarsta());
        System.out.println("Calculam data nasterii pornind de la CNP-ul unui candidat: ");
        c1.afisareDataNasterii();
        System.out.println();

        Connection connection = DbConnectionUtil.getDBConnection();

        System.out.println("Ne definim un service pentru clasa Candidat");
        CandidatService candidat_service = new CandidatService(connection);
        System.out.println();

        System.out.println("Adaugam candidati in vectorul de tip Candidat");
        candidat_service.adaugareCandidat(c1, "Main");
        candidat_service.adaugareCandidat(c2, "Main");
        candidat_service.adaugareCandidat(c3, "Main");

        candidat_service.deleteCandidat(1, "Main");
        candidat_service.schimbareNumeCandidat("Pre", "Predu", "Main");


        System.out.println("Afisam candidatii adaugati");
        ArrayList<Candidat> candidati = candidat_service.getAllCandidati("Main");
//        candidat_service.deleteAllCandidati();

        candidati.forEach(c -> System.out.println(c));

        RepartizareSali repartizare_sali1 = new RepartizareSali(4, 30);
        RepartizareSali repartizare_sali2 = new RepartizareSali(6, 35);
        RepartizareSali repartizare_sali3 = new RepartizareSali(5, 40);

        RepartizareSaliService repartizare_sali_service = new RepartizareSaliService(connection);
        repartizare_sali_service.adaugareRepartizareSali(repartizare_sali1, "Main");
        repartizare_sali_service.adaugareRepartizareSali(repartizare_sali2, "Main");
        repartizare_sali_service.adaugareRepartizareSali(repartizare_sali3, "Main");
        ArrayList<RepartizareSali> repartizari_sali = repartizare_sali_service.getAllRepartizariSali("Main");
//        repartizare_sali_service.deleteAllRepartizareSali();

        repartizari_sali.forEach(r -> System.out.println(r));


        Examen examen1 = new Examen(Constante.examen_info, "");
        Examen examen2 = new Examen(Constante.examen_mate, "");
        Examen examen3 = new Examen(Constante.examen_cti, "");

        ExamenService examen_service = new ExamenService(connection);
        examen_service.adaugareExamen(examen1, "Main");
        examen_service.adaugareExamen(examen2, "Main");
        examen_service.adaugareExamen(examen3, "Main");
        ArrayList<Examen> examene = examen_service.getAllExamene("Main");
//        examen_service.deleteAllExamene();

        examene.forEach(e-> System.out.println(e));


        InformatiiAdmitere informatii1 = new InformatiiAdmitere(Constante.examen_info, "1", "2");
        InformatiiAdmitere informatii2 = new InformatiiAdmitere(Constante.examen_mate, "1", "2");
        InformatiiAdmitere informatii3 = new InformatiiAdmitere(Constante.examen_cti, "1", "2");

        InformatiiAdmitereService informatii_admitere_service = new InformatiiAdmitereService(connection);
        informatii_admitere_service.adaugareInformatiiAdmitere(informatii1, "Main");
        informatii_admitere_service.adaugareInformatiiAdmitere(informatii2, "Main");
        informatii_admitere_service.adaugareInformatiiAdmitere(informatii3, "Main");
        ArrayList<InformatiiAdmitere> informatiiAdmiteri = informatii_admitere_service.getAllInformatiiAdmiteri("Main");
//        informatii_admitere_service.deleteAllInformatiiAdmitere();

        informatiiAdmiteri.forEach(inf -> System.out.println(inf));

        new ManageCandidatFrame("Candidat");


    }
}
