package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * An implementation of the interface ISymptomWriter
 * <p>
 * Create a file containing keys and values of a map, line by line
 * 
 * @author Sylvain
 * @version 1.0
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private Map<String, Integer> listSymptom;
	private String filePath;

	/**
	 * class constructor
	 * 
	 * @param listSymptom Map containing symptoms with their occurrences
	 * @param filePath    containing the file path of the file result.out
	 */
	public WriteSymptomDataToFile(Map<String, Integer> listSymptom, String filePath) {
		this.listSymptom = listSymptom;
		this.filePath = filePath;
	}

	/**
	 * set a map in an object WriteSymptomDataToFile
	 * 
	 * @param listSymptom Map containing symptoms with their occurrences
	 */
	public void setListSymptom(Map<String, Integer> listSymptom) {
		this.listSymptom = listSymptom;
	}

	/**
	 * Override of the methods declared in the interface ISymptomWriter. Create a
	 * file containing all keys with their occurrences from the map symptoms, line
	 * by line.
	 * 
	 * @param symptoms Map containing symptoms with their occurrences
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		if (symptoms != null && filePath != null) {

			try (BufferedWriter writeSymptoms = new BufferedWriter(new FileWriter(filePath))) {

				for (Map.Entry<String, Integer> entry : listSymptom.entrySet()) {
					String key = entry.getKey();
					Integer value = entry.getValue();
					writeSymptoms.write(key + ": " + value + "\n");
				}

			} catch (IOException e) {
				System.err.println("error while writing file " + e.getMessage() + "caused by" + e.getCause());
			}

		}
	}
}
