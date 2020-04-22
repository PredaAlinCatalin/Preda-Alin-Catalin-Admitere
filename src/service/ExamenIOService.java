package service;

import model.Examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ExamenIOService {
    private String cale_fisier;
    private String header_fisier;
    private static ExamenIOService examen_io_service;

    private ExamenIOService() {
        cale_fisier = "src/date/Examen.csv";
        header_fisier = "nume_examen, informatii_examen\n";
    }

    public static ExamenIOService getInstanta() {
        if (examen_io_service == null)
            examen_io_service = new ExamenIOService();
        return examen_io_service;
    }

    public void scriereDate(ArrayList<Examen> examen) {

        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter(cale_fisier);
            csvWriter.append(header_fisier);

            for (int i = 0; i < examen.size(); i++) {
                csvWriter.append(examen.get(i).getNume());
                csvWriter.append(",");
                csvWriter.append(examen.get(i).getInformatii_examen());
                csvWriter.append("\n");
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                csvWriter.flush();
                csvWriter.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Examen> citireDate() {

        ArrayList<Examen> rezultat = new ArrayList<>();

        BufferedReader csvReader = null;

        try {

            csvReader = new BufferedReader(new FileReader(cale_fisier));
            String row;
            int nr = 0;
            while ((row = csvReader.readLine()) != null) {
                if (nr != 0) {
                    String[] data = row.split(",");
                    String nume_examen = data[0];
                    String informatii_examen = data[1];

                    Examen examen = new Examen(nume_examen);
                    examen.setInformatii_examen(informatii_examen);

                    rezultat.add(examen);

                }
                nr++;

            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                csvReader.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        return rezultat;
    }

}
