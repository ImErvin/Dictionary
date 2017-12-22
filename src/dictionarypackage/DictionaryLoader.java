package dictionarypackage;

import java.io.*;
import java.util.*;

public class DictionaryLoader {
	private HashMap<String, String> hm = new HashMap<String, String>();
	private String fileName;
	
	public DictionaryLoader(String fileName){
		this.fileName = fileName;
	}
	
	public HashMap<String, String> loadDictionary(){
		// Reading line by line from buffered reader
		// Adapted from https://stackoverflow.com/questions/17678862/reading-lines-with-bufferedreader-and-checking-for-end-of-file
		try{
			File f = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = "";
			
			while((s=br.readLine())!=null){
				// Split the into key/value pairs
				// Adapted from https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by
				String[] parts = s.split(":");
	            String key = parts[0].toLowerCase();
	            String value = parts[1];
	            hm.put(key, value);
			}
			
			br.close();
			return hm;
		}catch(IOException e)
		{
			System.out.println(e.toString());
			return null;
		}
	}
}
