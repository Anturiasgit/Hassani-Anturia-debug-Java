package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Point d'entrée de l'application. Instancie les objets nécessaires
 * (lecteur, écrivain, compteur) et orchestre l'enchaînement des
 * traitements : lecture, comptage, tri, écriture.
 */
public class Main {

	/**
	 * Méthode principale : lit les symptômes depuis le fichier source,
	 * compte leurs occurrences, les trie par ordre alphabétique, puis
	 * écrit le résultat dans le fichier de sortie.
	 *
	 * @param args arguments de la ligne de commande (non utilisés)
	 * @throws Exception si une erreur survient lors de la lecture ou de l'écriture
	 */
		public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile("../symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = analyticsCounter.getSymptoms();
		Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

		analyticsCounter.writeSymptoms(sortedSymptoms);
	}
}