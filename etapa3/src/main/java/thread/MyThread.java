package thread;

import constante.Constante;
import gui.ManageCandidatFrame;
import model.Candidat;
import model.Examen;
import model.InformatiiAdmitere;
import model.RepartizareSali;
import repository.DbConnectionUtil;
import service.CandidatService;
import service.ExamenService;
import service.InformatiiAdmitereService;
import service.RepartizareSaliService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyThread extends Thread{
    @Override
    public void run() {
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
//        candidat_service.adaugareCandidat(c1);
//        candidat_service.adaugareCandidat(c2);
//        candidat_service.adaugareCandidat(c3);

        try {
            candidat_service.deleteCandidat(1, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            candidat_service.schimbareNumeCandidat("Pre", "Predu", getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            candidat_service.adaugareCandidat(c1, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            candidat_service.adaugareCandidat(c2, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            candidat_service.adaugareCandidat(c3, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("Afisam candidatii adaugati");
        ArrayList<Candidat> candidati = null;
        try {
            candidati = candidat_service.getAllCandidati(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            candidat_service.deleteAllCandidati(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        candidati.forEach(c -> System.out.println(c));

        RepartizareSali repartizare_sali1 = new RepartizareSali(4, 30);
        RepartizareSali repartizare_sali2 = new RepartizareSali(6, 35);
        RepartizareSali repartizare_sali3 = new RepartizareSali(5, 40);

        RepartizareSaliService repartizare_sali_service = new RepartizareSaliService(connection);
        try {
            repartizare_sali_service.adaugareRepartizareSali(repartizare_sali1, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            repartizare_sali_service.adaugareRepartizareSali(repartizare_sali2, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            repartizare_sali_service.adaugareRepartizareSali(repartizare_sali3, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ArrayList<RepartizareSali> repartizari_sali = null;
        try {
            repartizari_sali = repartizare_sali_service.getAllRepartizariSali(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            repartizare_sali_service.deleteAllRepartizareSali(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        repartizari_sali.forEach(r -> System.out.println(r));


        Examen examen1 = new Examen(Constante.examen_info, "");
        Examen examen2 = new Examen(Constante.examen_mate, "");
        Examen examen3 = new Examen(Constante.examen_cti, "");

        ExamenService examen_service = new ExamenService(connection);
        try {
            examen_service.adaugareExamen(examen1, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            examen_service.adaugareExamen(examen2, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            examen_service.adaugareExamen(examen3, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ArrayList<Examen> examene = null;
        try {
            examene = examen_service.getAllExamene(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            examen_service.deleteAllExamene(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        examene.forEach(e-> System.out.println(e));


        InformatiiAdmitere informatii1 = new InformatiiAdmitere(Constante.examen_info, "1", "2");
        InformatiiAdmitere informatii2 = new InformatiiAdmitere(Constante.examen_mate, "1", "2");
        InformatiiAdmitere informatii3 = new InformatiiAdmitere(Constante.examen_cti, "1", "2");

        InformatiiAdmitereService informatii_admitere_service = new InformatiiAdmitereService(connection);
        try {
            informatii_admitere_service.adaugareInformatiiAdmitere(informatii1, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            informatii_admitere_service.adaugareInformatiiAdmitere(informatii2, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            informatii_admitere_service.adaugareInformatiiAdmitere(informatii3, getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ArrayList<InformatiiAdmitere> informatiiAdmiteri = null;
        try {
            informatiiAdmiteri = informatii_admitere_service.getAllInformatiiAdmiteri(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            informatii_admitere_service.deleteAllInformatiiAdmitere(getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        informatiiAdmiteri.forEach(inf -> System.out.println(inf));

        try {
            new ManageCandidatFrame("Candidat");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
