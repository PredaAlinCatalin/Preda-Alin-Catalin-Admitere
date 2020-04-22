package service;

import model.RepartizareSali;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RepartizareSaliIOService {
    private String cale_fisier;
    private String header_fisier;
    private static RepartizareSaliIOService repartizare_sali_io_service;

    private RepartizareSaliIOService() {
        cale_fisier = "src/date/RepartizareSali.csv";
        header_fisier = "numar_sali,capacitate_sala\n";
    }

    public static RepartizareSaliIOService getInstanta() {
        if (repartizare_sali_io_service == null)
            repartizare_sali_io_service = new RepartizareSaliIOService();
        return repartizare_sali_io_service;
    }

    public void scriereDate(ArrayList<RepartizareSali> repartizare_sali) {

        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter(cale_fisier);
            csvWriter.append(header_fisier);

            for (int i = 0; i < repartizare_sali.size(); i++) {
                csvWriter.append(Integer.toString(repartizare_sali.get(i).getNr_sali()));
                csvWriter.append(",");
                csvWriter.append(Integer.toString(repartizare_sali.get(i).getCapacitate_sala()));
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

    public ArrayList<RepartizareSali> citireDate() {

        ArrayList<RepartizareSali> rezultat = new ArrayList<>();

        BufferedReader csvReader = null;

        try {

            csvReader = new BufferedReader(new FileReader(cale_fisier));
            String row;
            int nr = 0;
            while ((row = csvReader.readLine()) != null) {
                if (nr != 0) {
                    String[] data = row.split(",");
                    String nr_sali = data[0];
                    String capacitate_sala = data[1];

                    RepartizareSali repartizare_sali = new RepartizareSali(Integer.parseInt(nr_sali), Integer.parseInt(capacitate_sala));
                    rezultat.add(repartizare_sali);

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
