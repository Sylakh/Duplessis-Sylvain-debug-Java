package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * An implementation of the interface ISymptomWriter
 * 
 * Create a file containing keys and values of a map, line by line
 * 
 * @author Sylvain
 * @version 1.0
 * 
 * @param listSymptom Map<String, Integer> containing symptoms with their
 *                    occurrences
 * @param filePath    String with a full or partial path to file result.out
 * 
 *                    result.out has no duplicate
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private Map<String, Integer> listSymptom;
	private String filePath;

	// constructor

	public WriteSymptomDataToFile(Map<String, Integer> listSymptom, String filePath) {
		this.listSymptom = listSymptom;
		this.filePath = filePath;
	}

	// getters and setters

	public Map<String, Integer> getListSymptom() {
		return listSymptom;
	}

	public void setListSymptom(Map<String, Integer> listSymptom) {
		this.listSymptom = listSymptom;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		if (symptoms != null && filePath != null) {
			FileWriter file;
			BufferedWriter writeSymptoms = null;

			try {
				file = new FileWriter(filePath, false);
				writeSymptoms = new BufferedWriter(file);

				for (Map.Entry<String, Integer> entry : listSymptom.entrySet()) {
					String key = entry.getKey();
					Integer value = entry.getValue();
					writeSymptoms.write(key + ": " + value + "\n");
				}

			} catch (IOException e) {
				System.err.println("error while writing file " + e.getMessage() + "caused by" + e.getCause());
			} finally {
				try {
					if (writeSymptoms != null) {
						writeSymptoms.close();
					}

				} catch (IOException e) {
					System.err.println("error while closing file " + e.getMessage() + "caused by" + e.getCause());
				}
			}

		}
	}
}
