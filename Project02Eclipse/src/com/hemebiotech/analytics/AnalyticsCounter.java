package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
		int count;

		for (int i = 0; i < symptoms.size(); i++) {
			if (mapSymptoms.containsKey(symptoms.get(i))) {

				count = mapSymptoms.get(symptoms.get(i)) + 1;
				mapSymptoms.put(symptoms.get(i), count);
			} else {
				mapSymptoms.put(symptoms.get(i), 1);
			}
		}
		return mapSymptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);
		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}

/**
 * import java.io.BufferedReader;
 * 
 * import java.io.FileReader; import java.io.FileWriter;
 * 
 * public class AnalyticsCounter {
 * 
 * private static int headacheCount = 0; private static int rashCount = 0;
 * private static int pupilCount = 0;
 * 
 * public static void main(String args[]) throws Exception { // first get input
 * BufferedReader reader = new BufferedReader( new
 * FileReader("C:\\Users\\sylak\\git\\Duplessis-Sylvain-debug-Java\\Project02Eclipse/symptoms.txt"));
 * String line = reader.readLine();
 * 
 * int i = 0;
 * 
 * while (line != null) { i++; System.out.println("symptom from file: " + line);
 * if (line.equals("headache")) { headacheCount++; System.out.println("number of
 * headaches: " + headacheCount); } else if (line.equals("rash")) { rashCount++;
 * System.out.println("number of rashs: " + rashCount); } else if
 * (line.contains("pupils")) { pupilCount++; System.out.println("number of
 * pupils: " + pupilCount); }
 * 
 * line = reader.readLine(); }
 * 
 * // next generate output FileWriter writer = new FileWriter(
 * "C:\\\\Users\\\\sylak\\\\git\\\\Duplessis-Sylvain-debug-Java\\\\Project02Eclipse/result.out");
 * writer.write("headache: " + headacheCount + "\n"); writer.write("rash: " +
 * rashCount + "\n"); writer.write("dialated pupils: " + pupilCount + "\n");
 * writer.close(); } }
 */