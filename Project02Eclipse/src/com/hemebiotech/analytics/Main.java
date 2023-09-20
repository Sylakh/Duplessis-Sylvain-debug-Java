package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		String filePathSymptoms = "C:\\Users\\sylak\\git\\Duplessis-Sylvain-debug-Java\\Project02Eclipse\\symptoms.txt";
		String filePathResult = "C:\\Users\\sylak\\git\\Duplessis-Sylvain-debug-Java\\Project02Eclipse\\result.out";

		Map<String, Integer> mapSymptom = new HashMap<String, Integer>();
		List<String> listSymptom = new ArrayList<String>();
		Map<String, Integer> sortedMapSymptom = new TreeMap<String, Integer>();

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(filePathSymptoms);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(mapSymptom, filePathResult);

		AnalyticsCounter count = new AnalyticsCounter(reader, writer);

		listSymptom = count.getSymptoms();

		/**
		 * for (int i = 0; i < listSymptom.size(); i++) {
		 * System.out.println(listSymptom.get(i)); }
		 */

		mapSymptom = count.countSymptoms(listSymptom);

		sortedMapSymptom = count.sortSymptoms(mapSymptom);

		writer.setListSymptom(sortedMapSymptom);

		/**
		 * for (Map.Entry<String, Integer> entry : mapSymptom.entrySet()) {
		 * 
		 * System.out.println("clé :" + entry.getKey() + " -> " + entry.getValue()); }
		 */

		count.writeSymptoms(sortedMapSymptom);

	}

}
