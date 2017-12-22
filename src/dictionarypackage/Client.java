package dictionarypackage;

import java.rmi.Naming;

public class Client {
	public static void main(String[] args) throws Exception {
		//Ask the registry running on localhost and listening in port 1099 for the instance of
		//the FileService object that is bound to the RMI registry with the name fileService.
		DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");

		System.out.println("Hangbird:" + ds.lookup("Hangbird".toLowerCase()));
	}

}
