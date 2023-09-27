package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Used to declare all methods needed in order to manipulate lists and maps to
 * create a file containing all "Key : value" of a map, line by line
 * 
 * @param object ReadSymptomDataFromFile
 * @param object WriteSymptomDataToFile
 */
public class AnalyticsCounter {

	private ReadSymptomDataFromFile reader;
	private WriteSymptomDataToFile writer;

	/**
	 * class constructor
	 * 
	 * @param object ReadSymptomDataFromFile
	 * @param object WriteSymptomDataToFile
	 */
	public AnalyticsCounter(ReadSymptomDataFromFile reader, WriteSymptomDataToFile writer) {
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
	 * @param list of all symptoms
	 * @return HashMap<String, Integer> not ordered
	 */

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

	/**
	 * Used to ordered a HashMap<String, Integer> by alphabetical order of the keys
	 * 
	 * @author sylvain
	 * @version 1.0
	 * 
	 * @param symptoms HashMap<String, Integer>
	 * @return TreeMap naturally ordered by keys
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>(symptoms);
		return sortedSymptoms;
	}

	/**
	 * Create a file containing all "Key : value" of a map, line by line
	 * 
	 * @author sylvain
	 * @version 1.0
	 * 
	 * @param map symptoms
	 * @return void
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
