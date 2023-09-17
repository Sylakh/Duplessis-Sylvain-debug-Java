package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * classe qui implemente l'interface ISymptonWriter doit ecrire le contenu d'une
 * MAP<String, Integer> dans un fichier result.out se poser la question de
 * l'ordre d'ecriture (ordre d'entree ou possibilité d'ecrire en fct de l'ordre
 * alphabetique?) pas besoin du filepath, le fichier sera creer dans la fct main
 * gerer les exceptions avec un try catch
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private Map<String, Integer> listSymptom = new HashMap<String, Integer>();
	private String filepath;

	public WriteSymptomDataToFile(HashMap<String, Integer> listSymptom) {
		this.listSymptom = listSymptom;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		if (symptoms != null) {
			try {
				FileWriter file = new FileWriter(filepath, false);
				BufferedWriter writeSymptoms = new BufferedWriter(file);

				for (Map.Entry<String, Integer> entry : listSymptom.entrySet()) {
					String key = entry.getKey();
					Integer value = entry.getValue();
					writeSymptoms.write(key + ": " + value + "\n");
				}
				writeSymptoms.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
