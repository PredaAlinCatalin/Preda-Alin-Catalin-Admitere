package gui;

import model.Candidat;
import repository.DbConnectionUtil;
import repository.CandidatRepository;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ManageCandidatFrame extends JFrame {

    private Connection connection = DbConnectionUtil.getDBConnection();
    private CandidatRepository repository = new CandidatRepository(connection);

    public ManageCandidatFrame(String title) throws SQLException {
        super(title);

        JButton button_navigare = new JButton("Merg la ecran2");
        button_navigare.setBounds(5, 0, 150, 30);
        button_navigare.addActionListener(event -> {
            try {
                ManageExamenFrame ecran2 = new ManageExamenFrame("Examen");
                ecran2.setVisible(true);
                this.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        JLabel numeLabel = new JLabel("Nume: " );
        JTextField nume = new JTextField();
        numeLabel.setBounds(5, 50, 200, 30);
        nume.setBounds(150, 50, 200, 30);

        JLabel prenumeLabel = new JLabel("Prenume: " );
        JTextField prenume = new JTextField();
        prenumeLabel.setBounds(5, 100, 200, 30);
        prenume.setBounds(150, 100, 200, 30);

        JLabel CNPLabel = new JLabel("CNP: " );
        JTextField CNP = new JTextField();
        CNPLabel.setBounds(5, 150, 200, 30);
        CNP.setBounds(150, 150, 200, 30);

        JLabel medie_bacLabel = new JLabel("medie_bac: " );
        JTextField medie_bac = new JTextField();
        medie_bacLabel.setBounds(5, 200, 200, 30);
        medie_bac.setBounds(150, 200, 200, 30);

        JLabel medie_proba_obligatorieLabel = new JLabel("medie_proba_obligatorie: " );
        JTextField medie_proba_obligatorie = new JTextField();
        medie_proba_obligatorieLabel.setBounds(5, 250, 200, 30);
        medie_proba_obligatorie.setBounds(150, 250, 200, 30);

        JLabel medie_proba_optionalaLabel = new JLabel("medie_proba_optionala: " );
        JTextField medie_proba_optionala = new JTextField();
        medie_proba_optionalaLabel.setBounds(5, 300, 200, 30);
        medie_proba_optionala.setBounds(150, 300, 200, 30);

        JLabel medie_examenLabel = new JLabel("medie_examen: " );
        JTextField medie_examen = new JTextField();
        medie_examenLabel.setBounds(5, 350, 200, 30);
        medie_examen.setBounds(150, 350, 200, 30);

        JLabel profil_liceuLabel = new JLabel("profil_liceu: " );
//        JTextField profil_liceu = new JTextField();
        profil_liceuLabel.setBounds(5, 400, 200, 30);
//        profil_liceu.setBounds(150, 400, 200, 30);

        String[] profiluri = {"Matematica-Informatica", "Stiinte ale naturii"};
        final JComboBox<String> profil_liceu = new JComboBox<String>(profiluri);
        profil_liceu.setVisible(true);
        profil_liceu.setBounds(150, 400, 200, 30);

        JButton button = new JButton("Add Candidat");
        button.setBounds(5, 450, 150, 30);
        button.addActionListener(event -> {
            try {
                addCandidatDB(nume, prenume, CNP, medie_bac, medie_proba_obligatorie, medie_proba_optionala, medie_examen, profil_liceu);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel id_candidatLabel = new JLabel("Id-ul candidatului pentru stergere: " );
        JTextField id_candidat = new JTextField();
        id_candidatLabel.setBounds(5, 500, 200, 30);
        id_candidat.setBounds(200, 500, 200, 30);

        JButton button_stergere = new JButton("Sterge Candidat");
        button_stergere.setBounds(5, 550, 150, 30);
        button_stergere.addActionListener(event -> {
            try {
                deleteCandidatDB(id_candidat);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel nume_nouLabel = new JLabel("Numele nou al candidatului: " );
        JTextField nume_nou = new JTextField();
        nume_nouLabel.setBounds(5, 600, 200, 30);
        nume_nou.setBounds(200, 600, 200, 30);

        JLabel nume_vechiLabel = new JLabel("Numele vechi al candidatului: " );
        JTextField nume_vechi = new JTextField();
        nume_vechiLabel.setBounds(5, 650, 200, 30);
        nume_vechi.setBounds(200, 650, 200, 30);

        JButton button_modificare = new JButton("Modifica nume");
        button_modificare.setBounds(5, 700, 150, 30);
        button_modificare.addActionListener(event -> {
            try {
                schimbareNumeCandidatDB(nume_nou, nume_vechi);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel listLabel = new JLabel("List of all students");
//        listLabel.setHorizontalAlignment(JLabel.CENTER);
        listLabel.setForeground(Color.blue);
        listLabel.setBounds(5, 750, 200, 20);

//        JList<Candidat> studentJList = new JList<>();
//        studentJList.setBounds(5, 550, 1200, 1000);
//        studentJList.setListData(getCandidats());

        String[] columns = {"Id candidat", "Nume", "Prenume", "CNP", "Medie Bac", "Medie proba obligatorie", "Medie proba optionala",
                                "Medie examen", "Profil liceu"};

        JTable tabel  = new JTable(getCandidats(), columns);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(30);
        tabel.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(6).setPreferredWidth(100);
        tabel.getColumnModel().getColumn(7).setPreferredWidth(40);
        tabel.getColumnModel().getColumn(8).setPreferredWidth(80);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//        tabel.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 800, 1100, 1000);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);

        add(button_navigare);

        add(nume);
        add(numeLabel);

        add(prenume);
        add(prenumeLabel);

        add(CNP);
        add(CNPLabel);

        add(medie_bac);
        add(medie_bacLabel);

        add(medie_proba_obligatorie);
        add(medie_proba_obligatorieLabel);

        add(medie_proba_optionala);
        add(medie_proba_optionalaLabel);

        add(medie_examen);
        add(medie_examenLabel);

        add(profil_liceu);
        add(profil_liceuLabel);

        add(button);

        add(id_candidat);
        add(id_candidatLabel);
        add(button_stergere);

        add(nume_nou);
        add(nume_nouLabel);
        add(nume_vechi);
        add(nume_vechiLabel);
        add(button_modificare);

        add(listLabel);
//        add(studentJList);
        add(panel);

        setSize(1400, 1100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void schimbareNumeCandidatDB(JTextField nume_nou, JTextField nume_vechi) throws SQLException {
        String nume_nou1 = nume_nou.getText();
        String nume_vechi1 = nume_vechi.getText();
        this.repository.schimbareNumeCandidat(nume_nou1, nume_vechi1);
        JOptionPane.showMessageDialog(this, "Numele candidatului a fost modificat cu succes!");

    }
    
    public void deleteCandidatDB(JTextField id_candidat) throws SQLException {
        Integer id_candidat1 = Integer.parseInt(id_candidat.getText());
        this.repository.deleteCandidat(id_candidat1);
        JOptionPane.showMessageDialog(this, "Candidatul a fost sters cu succes!");
    }

    public void addCandidatDB(JTextField nume, JTextField prenume, JTextField CNP, JTextField medie_bac, JTextField medie_proba_obligatorie,
                              JTextField medie_proba_optionala, JTextField medie_examen, JComboBox<String> profil_liceu) throws SQLException {

        String nume1 = nume.getText();
        String prenume1 = prenume.getText();
        String CNP1 = CNP.getText();
        Double medie_bac1 = Double.parseDouble(medie_bac.getText());
        Double medie_proba_obligatorie1 = Double.parseDouble(medie_proba_obligatorie.getText());
        Double medie_proba_optionala1 = Double.parseDouble(medie_proba_optionala.getText());
        Double medie_examen1 = Double.parseDouble(medie_examen.getText());
        String profil_liceu1 = (String)profil_liceu.getSelectedItem();


        Candidat candidat = new Candidat(nume1, prenume1, CNP1, medie_bac1, medie_proba_obligatorie1, medie_proba_optionala1, profil_liceu1, medie_examen1);
        System.out.println(candidat.getMedie_examen());
        this.repository.adaugareCandidat(candidat);
        JOptionPane.showMessageDialog(this, "Candidatul a fost adaugat cu succes!");

    }

    public String[][] getCandidats() throws SQLException {
        ArrayList<Candidat> candidati =  repository.getAllCandidati();
        String[][] data = new String[10000][100];
        for (int i = 0; i < candidati.size(); i++) {

            DecimalFormat df = new DecimalFormat("##.##");
            data[i][0] = Integer.toString(candidati.get(i).getId_candidat());
            data[i][1] = candidati.get(i).getNume();
            data[i][2] = candidati.get(i).getPrenume();
            data[i][3] = candidati.get(i).getCNP();
            data[i][4] = Double.toString(candidati.get(i).getMedie_Bac());
            data[i][5] = Double.toString(candidati.get(i).getMedie_proba_obligatorie());
            data[i][6] = Double.toString(candidati.get(i).getMedie_proba_optionala());
            data[i][7] = Double.toString(candidati.get(i).getMedie_examen());
            BigDecimal bd = new BigDecimal(data[i][7]);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            data[i][7] = Double.toString(bd.doubleValue());
            data[i][8] = candidati.get(i).getProfil_liceu();
        }
        return data;


    }
}
