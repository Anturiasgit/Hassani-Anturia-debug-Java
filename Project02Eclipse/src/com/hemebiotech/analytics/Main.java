package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		// 1. Instanciation des implémentations concrètes des interfaces
		ISymptomReader reader = new ReadSymptomDataFromFile("../symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		// 2. Instanciation de AnalyticsCounter avec ces deux objets
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		// 3. Enchaînement des traitements dans le bon ordre
		List<String> symptoms = analyticsCounter.getSymptoms();
		Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

		// 4. Écriture du résultat (si la méthode d'écriture existe déjà dans AnalyticsCounter)
		analyticsCounter.writeSymptoms(sortedSymptoms);
	}
}