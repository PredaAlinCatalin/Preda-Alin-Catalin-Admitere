package service;

import model.Candidat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CandidatIOService {

    private String cale_fisier;
    private String header_fisier;
    private static CandidatIOService candidat_io_service;

    private CandidatIOService() {
        cale_fisier = "src/date/Candidat.csv";
        header_fisier = "nume,prenume,CNP,id_candidat,medie_Bac,medie_proba_obligatorie,medie_proba_optionala,medie_examen,profil_liceu\n";
    }

    public static CandidatIOService getInstanta() {
        if (candidat_io_service == null)
            candidat_io_service = new CandidatIOService();
        return candidat_io_service;
    }

    public void scriereDate(CandidatService candidat_service) {

        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter(cale_fisier);
            csvWriter.append(header_fisier);

            for (int i = 0; i < candidat_service.getCandidat().size(); i++) {
                csvWriter.append(candidat_service.getCandidatIndex(i).getNume());
                csvWriter.append(",");
                csvWriter.append(candidat_service.getCandidatIndex(i).getPrenume());
                csvWriter.append(",");
                csvWriter.append(candidat_service.getCandidatIndex(i).getCNP());
                csvWriter.append(",");
                csvWriter.append(Integer.toString(candidat_service.getCandidatIndex(i).getId_candidat()));
                csvWriter.append(",");
                csvWriter.append(Double.toString(candidat_service.getCandidatIndex(i).getMedie_Bac()));
                csvWriter.append(",");
                csvWriter.append(Double.toString(candidat_service.getCandidatIndex(i).getMedie_proba_obligatorie()));
                csvWriter.append(",");
                csvWriter.append(Double.toString(candidat_service.getCandidatIndex(i).getMedie_proba_optionala()));
                csvWriter.append(",");
                csvWriter.append(Double.toString(candidat_service.getCandidatIndex(i).getMedie_examen()));
                csvWriter.append(",");
                csvWriter.append(candidat_service.getCandidatIndex(i).getProfil_liceu());
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

    public ArrayList<Candidat> citireDate() {

        CandidatService candidat_service = new CandidatService();

        BufferedReader csvReader = null;

        try {

            csvReader = new BufferedReader(new FileReader(cale_fisier));
            String row;
            int nr = 0;
            while ((row = csvReader.readLine()) != null) {
                if (nr != 0) {
                    String[] data = row.split(",");
                    String nume = data[0];
                    String prenume = data[1];
                    String CNP = data[2];
                    Integer id_candidat = Integer.parseInt(data[3]);
                    Double medie_Bac = Double.parseDouble(data[4]);
                    Double medie_proba_obligatorie = Double.parseDouble(data[5]);
                    Double medie_proba_optionala = Double.parseDouble(data[6]);
                    Double medie_examen = Double.parseDouble(data[7]);
                    String profil_liceu = data[8];

                    Candidat candidat = new Candidat(nume, prenume, CNP, medie_Bac, medie_proba_obligatorie, medie_proba_optionala, profil_liceu);
                    candidat.setId_candidat(id_candidat);
                    candidat.setMedie_examen(medie_examen);

                    candidat_service.adaugareCandidat(candidat);
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
        return candidat_service.getCandidat();
    }

}
