package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Used to declare all methods needed in order to manipulate lists and maps to
 * create a file containing all "Key : value" of a map, line by line count all
 * occurences of a key of the raw list of symptoms
 * 
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * class constructor
	 * 
	 * @param reader ISymptomReader
	 * @param writer ISymptomWriter
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * get the list from an object ReadSymptomDataFromFile, part of an object
	 * AnalyticsCounter
	 * 
	 * @return the list from an object ReadSymptomDataFromFile, part of an object
	 *         AnalyticsCounter
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Used to create a map with symptoms as keys and occurrences as values from a
	 * list of symptoms
	 * 
	 * @author sylvain
	 * @version 1.0
	 * 
	 * @param symptoms list of all symptoms
	 * @return HashMap not ordered containing all symptoms with their occurrences
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> mapSymptoms = new HashMap<>();
		int count;

		for (String symptom : symptoms) { // Enhanced version
			if (mapSymptoms.containsKey(symptom)) {

				count = mapSymptoms.get(symptom) + 1;
				mapSymptoms.put(symptom, count);
			} else {
				mapSymptoms.put(symptom, 1);
			}
		}
		return mapSymptoms;
	}

	/**
	 * Used to ordered a HashMap by alphabetical order (keys)
	 * 
	 * @author sylvain
	 * @version 1.0
	 * 
	 * @param symptoms HashMap containing symptoms with their occurrences
	 * @return TreeMap naturally ordered by keys
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Create a file containing all "Key : value" of a map, line by line
	 * 
	 * @author sylvain
	 * @version 1.0
	 * 
	 * @param symptoms Map containing symptoms with their occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
