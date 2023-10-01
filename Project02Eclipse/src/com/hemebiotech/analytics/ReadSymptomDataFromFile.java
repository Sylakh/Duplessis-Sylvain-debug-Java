package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the interface IsymptomReader
 * <p>
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	/**
	 * class constructor of ReadSymptomDataFromFile
	 * 
	 * @param filePath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Override of the methods declared in the interface ISymptomReader. Return a
	 * raw list of all symptoms which are written in a file, one per line.
	 * 
	 * @return list of all symptoms, duplicates may exist. If no filePath, return an
	 *         empty list
	 * 
	 * @version 1.0
	 * @author Sylvain
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filePath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.err.println("error while reading file " + e.getMessage() + "caused by" + e.getCause());
			}
		}

		return result;
	}

}
