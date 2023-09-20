package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * classe qui implemente l'interface ISymptonWriter doit ecrire le contenu d'une
 * MAP<String, Integer> dans un fichier result.out se poser la question de
 * l'ordre d'ecriture (ordre d'entree ou possibilité d'ecrire en fct de l'ordre
 * alphabetique? besoin du filepath, le fichier sera creer dans la fct main
 * gerer les exceptions avec un try catch getter and setter?
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private Map<String, Integer> listSymptom;
	private String filePath;

	public WriteSymptomDataToFile(Map<String, Integer> listSymptom, String filePath) {
		this.listSymptom = listSymptom;
		this.filePath = filePath;
	}

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
		if (symptoms != null) {
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
