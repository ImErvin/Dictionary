package dictionarypackage;

import java.rmi.*;
import java.rmi.server.*;

public class SearchableImpl extends UnicastRemoteObject implements Searchable{
	
	// Use of a default serialiser to pack and unpack remote object across network.
	private static final long serialVersionUID = 1L;
	
	// Default constructor
	public SearchableImpl() throws RemoteException{
		
	}
	
	
}
