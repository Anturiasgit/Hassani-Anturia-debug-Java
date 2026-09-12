package com.hemebiotech.analytics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe responsable de l'analyse des symptômes : récupération, comptage
 * des occurrences et tri par ordre alphabétique.
 * Elle s'appuie sur une implémentation de ISymptomReader pour la lecture
 * des données et sur une implémentation de ISymptomWriter pour leur écriture.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Construit un AnalyticsCounter à partir d'un lecteur et d'un écrivain
	 * de symptômes.
	 *
	 * @param reader l'objet chargé de récupérer la liste des symptômes
	 * @param writer l'objet chargé d'écrire le résultat du traitement
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Récupère la liste des symptômes grâce à l'instance de ISymptomReader
	 * fournie au constructeur.
	 *
	 * @return la liste des symptômes lus
	 */
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}

	/**
	 * Compte le nombre d'occurrences de chaque symptôme présent dans la
	 * liste fournie.
	 *
	 * @param symptoms la liste des symptômes à analyser
	 * @return une map associant chaque symptôme à son nombre d'occurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> occurrences = new LinkedHashMap<>();

		for (String symptom : symptoms) {
			if (occurrences.containsKey(symptom)) {
				occurrences.put(symptom, occurrences.get(symptom) + 1);
			} else {
				occurrences.put(symptom, 1);
			}
		}

		return occurrences;
	}

	/**
	 * Trie une map de symptômes et de leurs occurrences par ordre
	 * alphabétique des symptômes.
	 *
	 * @param symptoms la map à trier
	 * @return une nouvelle map triée par ordre alphabétique des clés
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Écrit le résultat final (symptômes triés avec leurs occurrences)
	 * grâce à l'instance de ISymptomWriter fournie au constructeur.
	 *
	 * @param symptoms la map triée des symptômes et de leurs occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}