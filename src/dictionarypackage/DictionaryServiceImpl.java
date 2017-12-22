package dictionarypackage;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
	
	// Use of a default serialiser to pack and unpack remote object across network.
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> hm = new HashMap<String, String>();
	private DictionaryLoader dl = new DictionaryLoader("dictionary.txt");
	
	// Default constructor
	public DictionaryServiceImpl() throws RemoteException{
		hm = dl.loadDictionary();
	}
	
	@Override
	public String lookup(String s) throws RemoteException{
		
		String res = hm.containsKey(s) ? hm.get(s) : "404 - Word not found";
		
		return res;
	}
	
	
}
