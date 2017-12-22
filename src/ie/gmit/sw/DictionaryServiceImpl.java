package ie.gmit.sw;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
	
	// Use of a default serialiser to pack and unpack remote object across network.
	private static final long serialVersionUID = 999L;
	private HashMap<String, String> hm = new HashMap<String, String>(); // Hashmap stores key/value pairs of words and definitions
	private DictionaryLoader dl = new DictionaryLoader("dictionary.txt"); // Creates a new dictionaryloader
	
	// Default constructor
	public DictionaryServiceImpl() throws RemoteException{
		hm = dl.loadDictionary(); // Delegate hashmap population to dictionaryloader
	}
	
	@Override
	public String lookup(String s) throws RemoteException{
		// Return the definition of the word if it exists - else return 404 message
		return hm.containsKey(s) ? hm.get(s) : "404 - Word not found";
	}
	
	
}
