package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AuditService {

    private String cale_fisier;
    private String header_fisier;
    private static AuditService audit_service;

    private AuditService() {
        cale_fisier = "src/date/AuditService.csv";
        header_fisier = "nume_actiune, timestamp_actiune\n";
        FileWriter csvWriter = null;

        try {

            csvWriter = new FileWriter(cale_fisier);
            csvWriter.append(header_fisier);

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

        public static AuditService getInstanta() {
        if (audit_service == null)
            audit_service = new AuditService();
        return audit_service;
    }

        public void scrieDate(String nume_actiune, Date data) {

            FileWriter csvWriter = null;

            try {

                csvWriter = new FileWriter(cale_fisier, true);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                csvWriter.append(nume_actiune);
                csvWriter.append(",");
                csvWriter.append(formatter.format(data));
                csvWriter.append("\n");

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


}
