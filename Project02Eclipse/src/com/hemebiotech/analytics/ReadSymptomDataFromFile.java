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
	 * @param String filepath a full or partial path to file with symptom strings in
	 *               it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filePath = filepath;
	}

	/**
	 * Override of the methods declared in the interface ISymptomReader. Return a
	 * brut list of all symptoms written in a file, one per line.
	 * 
	 * @param String filepath a full or partial path to file with symptom strings in
	 *               it
	 * 
	 * @return list of all symptoms, duplicates may exist. If no filepath, return an
	 *         empty list
	 * 
	 * @version 1.0
	 * @author Sylvain
	 */

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
