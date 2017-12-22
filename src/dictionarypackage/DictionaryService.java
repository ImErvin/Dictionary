package dictionarypackage;

import java.rmi.*; // Import RMI to use Remote and RemoteExcpetion

public interface DictionaryService extends Remote{
	public String lookup(String s) throws RemoteException;
}
