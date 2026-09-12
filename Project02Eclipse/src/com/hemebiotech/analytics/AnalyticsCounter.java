package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headCount;	
	private static int rashCount;		
	private static int pupilCount;		

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.GetSymptoms();
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	public void writeSymptoms(Map<String, Integer> symptoms) { 
		return this.writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
		// first get input
		
		BufferedReader reader = new BufferedReader (new FileReader("../symptoms.txt"));
		String line = reader.readLine();

		headCount = 0;	
		rashCount = 0;
		pupilCount = 0;
		while (line != null) {	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashes: " + rashCount);
			}
			else if (line.contains("pupils")) {
				pupilCount++;
				System.out.println("number of pupils: " + pupilCount);
			}

			line = reader.readLine();	// get another symptom
		}

		reader.close();
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}