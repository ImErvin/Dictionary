package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class DictionaryLoader {
	// Hashmap to store key/value pairs - words being keys and definitions are
	// values
	private HashMap<String, String> hm = new HashMap<String, String>();
	// The filename of the file
	private String fileName;

	// Constructor accepts filename and set's local filename
	public DictionaryLoader(String fileName) {
		this.fileName = fileName;
	}

	// Method to read the file, store it into a hashmap and return that hashmap
	public HashMap<String, String> loadDictionary() {
		// Reading line by line from buffered reader
		// Adapted from
		// https://stackoverflow.com/questions/17678862/reading-lines-with-bufferedreader-and-checking-for-end-of-file
		try {
			// initiate the file
			File f = new File(fileName);
			// Create a bufferedreader
			BufferedReader br = new BufferedReader(new FileReader(f));
			// empty string used to catch each line in the buffered reader
			String s = "";

			// While not EOF
			while ((s = br.readLine()) != null) {
				// Split the into key/value pairs
				// Adapted from
				// https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by
				String[] parts = s.split(":");
				// Set to lowercase for universal referencing
				String key = parts[0].toLowerCase();
				String value = parts[1];

				// Add the key/values to map
				hm.put(key, value);
			}

			// Close buffered reader
			br.close();

			// Return the hashmap
			return hm;
		} catch (IOException e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
