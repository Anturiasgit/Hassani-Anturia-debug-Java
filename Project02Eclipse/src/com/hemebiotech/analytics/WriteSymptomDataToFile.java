package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
                    //ouvre l'écriture dans fichier
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
               //lit les symptomes
                writer.write(entry.getKey() + ": " + entry.getValue()); //écrit
                writer.newLine(); //passe à la ligne
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}