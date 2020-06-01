package gui;

import constante.Constante;
import model.Candidat;
import model.Examen;
import repository.DbConnectionUtil;
import repository.CandidatRepository;
import repository.ExamenRepository;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ManageExamenFrame extends JFrame {

    private Connection connection = DbConnectionUtil.getDBConnection();
    private ExamenRepository repository = new ExamenRepository(connection);

    public ManageExamenFrame(String title) throws SQLException {
        super(title);

        JButton button_navigare = new JButton("Mergi la ecran1");
        button_navigare.setBounds(5, 0, 150, 30);
        button_navigare.addActionListener(event -> {
            try {
                ManageCandidatFrame ecran1 = new ManageCandidatFrame("Candidat");
                ecran1.setVisible(true);
                this.dispose();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        JLabel nume_examenLabel = new JLabel("Numele examenului: ");
        String[] examene = {Constante.examen_info, Constante.examen_mate, Constante.examen_cti};
        final JComboBox<String> nume_examen = new JComboBox<String>(examene);
        nume_examen.setVisible(true);
        nume_examenLabel.setBounds(5, 50, 200, 30);
        nume_examen.setBounds(200, 50, 400, 30);

        JLabel informatii_examenLabel = new JLabel("Informatii despre examen: " );
        JTextField informatii_examen = new JTextField();
        informatii_examenLabel.setBounds(5, 100, 200, 30);
        informatii_examen.setBounds(200, 100, 200, 30);


        JButton button = new JButton("Adauga Examen");
        button.setBounds(5, 150, 150, 30);
        button.addActionListener(event -> {
            try {
                addExamenDB(nume_examen, informatii_examen);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel id_examenLabel = new JLabel("Id-ul examenului pentru stergere: " );
        JTextField id_examen = new JTextField();
        id_examenLabel.setBounds(5, 200, 200, 30);
        id_examen.setBounds(200, 200, 200, 30);

        JButton button_stergere = new JButton("Sterge Candidat");
        button_stergere.setBounds(5, 250, 150, 30);
        button_stergere.addActionListener(event -> {
            try {
                deleteExamentDB(id_examen);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel nume_nouLabel = new JLabel("Numele nou al examenului: " );
        final JComboBox<String> nume_nou = new JComboBox<String>(examene);
        nume_examen.setVisible(true);
        nume_nouLabel.setBounds(5, 300, 200, 30);
        nume_nou.setBounds(200, 300, 400, 30);


        JLabel nume_vechiLabel = new JLabel("Numele vechi al examenului: " );
        final JComboBox<String> nume_vechi = new JComboBox<String>(examene);
        nume_examen.setVisible(true);
        nume_vechiLabel.setBounds(5, 350, 200, 30);
        nume_vechi.setBounds(200, 350, 400, 30);


        JButton button_modificare = new JButton("Modifica nume examen");
        button_modificare.setBounds(5, 400, 150, 30);
        button_modificare.addActionListener(event -> {
            try {
                schimbareNumeExamenDB(nume_nou, nume_vechi);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        JLabel listLabel = new JLabel("Lista examenelor");
//        listLabel.setHorizontalAlignment(JLabel.CENTER);
        listLabel.setForeground(Color.blue);
        listLabel.setBounds(5, 450, 200, 20);

//        JList<Candidat> studentJList = new JList<>();
//        studentJList.setBounds(5, 550, 1200, 1000);
//        studentJList.setListData(getCandidats());

        String[] columns = {"Id examen", "Nume examen", "Informatii examen"};

        JTable tabel  = new JTable(getExamene(), columns);
        tabel.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//        tabel.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 500, 1100, 1000);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(scrollPane);


        add(button_navigare);

        add(nume_examen);
        add(nume_examenLabel);

        add(informatii_examen);
        add(informatii_examenLabel);


        add(button);

        add(id_examen);
        add(id_examenLabel);
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

    public void schimbareNumeExamenDB(JComboBox<String> nume_nou, JComboBox<String> nume_vechi) throws SQLException {
        String nume_nou1 = (String)nume_nou.getSelectedItem();
        String nume_vechi1 = (String)nume_vechi.getSelectedItem();
        this.repository.schimbareNumeExamen(nume_nou1, nume_vechi1);
        JOptionPane.showMessageDialog(this, "Numele examenului a fost modificat cu succes!");

    }

    public void deleteExamentDB(JTextField id_examen) throws SQLException {
        Integer id_examen1 = Integer.parseInt(id_examen.getText());
        this.repository.deleteExamen(id_examen1);
        JOptionPane.showMessageDialog(this, "Examenul a fost sters cu succes!");
    }

    public void addExamenDB(JComboBox<String> nume, JTextField informatii) throws SQLException {

        String nume1 = (String)nume.getSelectedItem();
        String informatii1 = informatii.getText();

        Examen examen = new Examen(nume1, informatii1);
        this.repository.adaugareExamen(examen);
        JOptionPane.showMessageDialog(this, "Examenul a fost adaugat cu succes!");

    }

    public String[][] getExamene() throws SQLException {
        ArrayList<Examen> examene =  repository.getAllExamene();
        String[][] data = new String[10000][100];
        for (int i = 0; i < examene.size(); i++) {

            data[i][0] = Integer.toString(examene.get(i).getId_examen());
            data[i][1] = examene.get(i).getNume();
            data[i][2] = examene.get(i).getInformatii_examen();
        }
        return data;


    }
}
