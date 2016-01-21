package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.entity.CourseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class PlanningService {

    private static final int CSV_INDEX_CODE_ECTS = 0;
    private static final int CSV_INDEX_DATE = 1;
    private static final int CSV_INDEX_PROMO = 2;
    private static final int CSV_INDEX_MATIERE = 3;
    private static final int CSV_INDEX_ENSEIGNANT = 4;
    private static final int CSV_INDEX_HORAIRE = 5;
    private static final int CSV_INDEX_DUREE = 6;
    private static final int CSV_INDEX_SALLE = 7;

    public void uploadPlanning(InputStream csvFis) throws Exception {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";

        Exception ex = null;

        try {

            int i = 0;
            br = new BufferedReader(new InputStreamReader(csvFis));
            while ((line = br.readLine()) != null) {
                if(i == 0){
                    i++;
                    continue;
                }

                String lineFixed = fixEncoding(line);
                String[] datas = lineFixed.split(";");

                CourseEntity courseEntity = new CourseEntity()
                        .setCodeEcts(datas[CSV_INDEX_CODE_ECTS])
                        .setEnseignant(datas[CSV_INDEX_ENSEIGNANT])
                        .setMatiere(datas[CSV_INDEX_MATIERE])
                        .setPromo(datas[CSV_INDEX_PROMO])
                        .setSalle(datas.length >= 8 ? datas[CSV_INDEX_SALLE] : "");

                //Date
                DateFormat df = new SimpleDateFormat("EEEE d MMM yyyy hh:mm", Locale.FRANCE);
                String fullDateTime = datas[CSV_INDEX_DATE] + " " + datas[CSV_INDEX_HORAIRE];
                fullDateTime = fullDateTime.substring(0, 1).toUpperCase() + fullDateTime.substring(1);

                Date date = df.parse(fullDateTime);
                courseEntity.setDateTime(date);

                //Durée
                Long dureeMillis = Long.valueOf(datas[CSV_INDEX_DUREE]) * 3600L * 1000L;
                courseEntity.setDuration(dureeMillis);

                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ex = e;
        } catch (IOException e) {
            e.printStackTrace();
            ex = e;
        } finally {
            if (br != null) {
                br.close();
            }
        }

        if(ex != null) throw ex;
    }

    //Fix CSV encoding
    public String fixEncoding(String originalString){
        return originalString
                .replace("\uFFFD", "é");
    }

}
