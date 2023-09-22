package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main class of the project Analytics Counter
 * 
 * Extract symptoms from the file symptoms.txt and put them in a ArrayList
 * 
 * Count occurrences and put them in aHashMap with symptoms as keys and
 * occurrences as value
 * 
 * Ordered the Map
 * 
 * Create the file result.out containing all data line by line
 * 
 * Filepaths of files symptoms.txt and result.out have to be set
 * 
 * @author sylvain
 * @Version 1.0
 * 
 * 
 */

public class Main {

	public static void main(String[] args) {

		// CONSTANTS

		final String FILEPATHSYMPTOMS = ".\\Project02Eclipse\\symptoms.txt";
		final String FILEPATHRESULT = ".\\Project02Eclipse\\result.out";

		// VARIABLES

		Map<String, Integer> mapSymptom = new HashMap<String, Integer>();
		List<String> listSymptom = new ArrayList<String>();
		Map<String, Integer> sortedMapSymptom = new TreeMap<String, Integer>();

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(FILEPATHSYMPTOMS);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(mapSymptom, FILEPATHRESULT);

		AnalyticsCounter count = new AnalyticsCounter(reader, writer);

		// methods needed

		listSymptom = count.getSymptoms();

		mapSymptom = count.countSymptoms(listSymptom);

		sortedMapSymptom = count.sortSymptoms(mapSymptom);

		writer.setListSymptom(sortedMapSymptom);

		count.writeSymptoms(sortedMapSymptom);

	}

}
