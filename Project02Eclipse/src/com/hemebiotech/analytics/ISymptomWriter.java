package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface définissant le contrat pour l'écriture du résultat de
 * l'analyse des symptômes vers une destination quelconque (fichier,
 * base de données, etc.).
 */
public interface ISymptomWriter {

    /**
     * Écrit le résultat de l'analyse des symptômes.
     *
     * @param symptoms la map des symptômes et de leurs occurrences à écrire
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}