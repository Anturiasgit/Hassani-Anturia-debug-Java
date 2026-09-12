package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de ISymptomWriter qui écrit le résultat de l'analyse
 * des symptômes dans un fichier texte.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * @param filepath le chemin du fichier dans lequel écrire le résultat
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Écrit chaque symptôme et son nombre d'occurrences sur une ligne
     * du fichier, au format "symptome: nombre".
     *
     * @param symptoms la map des symptômes et de leurs occurrences à écrire
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(filepath));

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}