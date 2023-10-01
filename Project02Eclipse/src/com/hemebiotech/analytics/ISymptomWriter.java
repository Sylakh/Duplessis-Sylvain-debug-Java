package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface to declare any abstract methods in order to extract data from a map
 * and write it in a file.
 * 
 * 
 */

public interface ISymptomWriter {

	/**
	 * Used to extract data from a map and write it in a file, line by line with
	 * their occurrences. Create a file containing each key and value of the map
	 * 
	 * @param symptoms map containing symptoms with their occurrences as value
	 * 
	 * @version 1.0
	 * @author Sylvain
	 */

	void writeSymptoms(Map<String, Integer> symptoms);

}
