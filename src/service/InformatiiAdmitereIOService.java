package service;

import model.Examen;
import model.InformatiiAdmitere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InformatiiAdmitereIOService {

    private String cale_fisier;
    private String header_fisier;
    private static InformatiiAdmitereIOService informatii_admitere_io_service;

    private InformatiiAdmitereIOService() {
        cale_fisier = "src/date/InformatiiAdmitere.csv";
        header_fisier = "nume_informatii_admitere, informatii_preadmitere, informatii_postadmitere\n";
    }

    public static InformatiiAdmitereIOService getInstanta() {
        if (informatii_admitere_io_service == null)
            informatii_admitere_io_service = new InformatiiAdmitereIOService();
        return informatii_admitere_io_service;
    }

    public void scriereDate(ArrayList<InformatiiAdmitere> informatii_admitere) {

        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter(cale_fisier);
            csvWriter.append(header_fisier);

            for (int i = 0; i < informatii_admitere.size(); i++) {
                csvWriter.append(informatii_admitere.get(i).getExamen().getNume());
                csvWriter.append(",");
                csvWriter.append(informatii_admitere.get(i).getInformatii_preadmitere());
                csvWriter.append(",");
                csvWriter.append(informatii_admitere.get(i).getInformatii_postadmitere());
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

    public ArrayList<InformatiiAdmitere> citireDate() {

        ArrayList<InformatiiAdmitere> rezultat = new ArrayList<>();

        BufferedReader csvReader = null;

        try {

            csvReader = new BufferedReader(new FileReader(cale_fisier));
            String row;
            int nr = 0;
            while ((row = csvReader.readLine()) != null) {
                if (nr != 0) {
                    String[] data = row.split(",");
                    String nume_examen = data[0];
                    String informatii_preadmitere = data[1];
                    String informatii_postadmitere = data[2];

                    Examen examen = new Examen(nume_examen);
                    InformatiiAdmitere informatii_admitere = new InformatiiAdmitere(examen);
                    informatii_admitere.setInformatii_preadmitere(informatii_preadmitere);
                    informatii_admitere.setInformatii_postadmitere(informatii_postadmitere);

                    rezultat.add(informatii_admitere);

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
