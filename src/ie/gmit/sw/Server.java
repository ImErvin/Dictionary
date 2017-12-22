package ie.gmit.sw;

import java.rmi.*; // Import rmi to use Naming
import java.rmi.registry.LocateRegistry; // Import registry to create a new registry

public class Server {
	public static void main(String[] args) throws Exception{
		
		// Set an instance of Searchable to use the implementation
		DictionaryService s = new DictionaryServiceImpl();
		
		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-breadable name "searchable"
		Naming.rebind("dictionaryService", s);

		//Print a message to standard output
		System.out.println("Server ready.");
	}
}
