package ie.gmit.sw;

import java.rmi.*;
import java.util.*;

public class Client{
	// Member Variables
	// Remote object DictionaryService
	private DictionaryService ds;
	// LinkedHashMap (Spec said to that inQueue is a map) that holds an integer key (job#) and string (definition)
	// inQueue will create a list of jobs to do
	private LinkedHashMap<Integer, String> inQueue = new LinkedHashMap<Integer, String>();
	// outQueue will hold the result of those jobs
	private LinkedHashMap<Integer, String> outQueue = new LinkedHashMap<Integer, String>();
	private int jobId;
	
	// Default Constructor accepts a string parameter which is the search word
	public Client(String s) {
		// Add's that search word to the queue.
		addInQueue(s);
	}
	
	// getWord is used to retrieve the definition of the First item of LinkedHashMap
	public void getWord() throws Exception{
		// Using RMIs naming.lookup to search the registry for dictionaryService
		ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
		// Add the response of the first searchword in inQueue passing the first key and definition of that key
		outQueue.put(getFirstKey(inQueue), ds.lookup(inQueue.get(getFirstKey(inQueue))));
		// Remove it after it has been processed into the outqueue
		inQueue.remove(getFirstKey(inQueue));
	}
	
	// Method to retrieve the name of the first key in LinkedHashMap - need this as i'm not using a LinkedList
	// And this is my alternative to finding the head.
	// Adapted from https://stackoverflow.com/questions/1936462/java-linkedhashmap-get-first-or-last-entry
	public int getFirstKey(LinkedHashMap<Integer, String> hm) {
	  int out = 0;
	  for (int key : hm.keySet()) {
		out = key;
		break;
	  }
	  return out;
	}
	
	// Method to retrieve the definition of the first item of the LinkedHashMap
	public String getDefinition(){
		// Set's string response to the definition - this acts as temp variable
		String response = outQueue.get(getFirstKey(outQueue));
		// Remove that key from the LinkedHashMap
		outQueue.remove(getFirstKey(outQueue));
		// Return the temp variable to be displayed on the client
		return response;
	}
	
	// Method to add to the inQueue hashmap
	public void addInQueue(String s) {
		// Control for while
		boolean control = true;
		// Initiate jobId
		jobId = 0;
		
		// Infinite loop while control is true
		while (control) {
			// Random number between 0..100
			jobId = new Random().nextInt(100);
			
			// If that number is already in the job queue - create a new one
			control = inQueue.containsKey(jobId) ? true : false;
		}
		
		// Add to the hashmap
		inQueue.put(jobId, s.toLowerCase());
	}
	
	// Getter for jobId to display it on client
	public int getJobId() {
		return jobId;
	}
	
}
