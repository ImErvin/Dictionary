package ie.gmit.sw;

import java.rmi.*; // Import RMI to use Remote and RemoteExcpetion

public interface DictionaryService extends Remote {
	// loopup method as stated in spec
	public String lookup(String s) throws RemoteException;
}
