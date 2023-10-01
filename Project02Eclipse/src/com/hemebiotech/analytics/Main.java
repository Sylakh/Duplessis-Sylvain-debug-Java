package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class of the project Analytics Counter
 * <p>
 * Extract symptoms from the file symptoms.txt and put them in a ArrayList
 * <P>
 * Count occurrences and put them in aHashMap with symptoms as keys and
 * occurrences as value
 * <p>
 * Ordered the Map
 * <P>
 * Create the file result.out containing all data line by line.
 * <p>
 * File paths of files symptoms.txt and result.out have to be set
 * 
 * @author Sylvain
 * @version 1.0
 * 
 * 
 */
public class Main {

	/**
	 * file path of the file symptoms.txt
	 */
	final static String FILE_PATH_SYMPTOMS = ".\\Project02Eclipse\\symptoms.txt";
	/**
	 * file path of the file result.out
	 */
	final static String FILE_PATH_RESULT = ".\\Project02Eclipse\\result.out";

	/**
	 * main methods
	 * 
	 * @param args File paths of files symptoms.txt and result.out have to be set as
	 *             constant
	 */
	public static void main(String[] args) {

		// VARIABLES

		Map<String, Integer> mapSymptom = new HashMap<>();
		List<String> listSymptom;
		Map<String, Integer> sortedMapSymptom;

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(FILE_PATH_SYMPTOMS);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(mapSymptom, FILE_PATH_RESULT);

		AnalyticsCounter count = new AnalyticsCounter(reader, writer);

		// main

		listSymptom = count.getSymptoms();

		mapSymptom = count.countSymptoms(listSymptom);

		sortedMapSymptom = count.sortSymptoms(mapSymptom);

		writer.setListSymptom(sortedMapSymptom);

		count.writeSymptoms(sortedMapSymptom);

	}

}
