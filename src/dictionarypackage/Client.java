package dictionarypackage;

import java.rmi.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class Client {
	private DictionaryService ds;
	private Map<Integer, String> inQueue = new LinkedHashMap<Integer, String>();
	private Map<Integer, String> outQueue = new LinkedHashMap<Integer, String>();

	public Client(String s) {
		System.out.println(addInQueue(s));
	}

	public void getWord() throws Exception{
		ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
		String response = ds.lookup(inQueue.get(getFirstKey()));
		inQueue.remove(getFirstKey());
		System.out.println(response);
	}
	
	public int getFirstKey() {
	  int out = 0;
	  for (int key : inQueue.keySet()) {
		out = key;
		break;
	  }
	  return out;
	}
	
	public int addInQueue(String s) {
		boolean control = true;
		int jobId = 0;
		
		while (control) {
			jobId = new Random().nextInt(100);

			control = inQueue.containsKey(jobId) ? true : false;
		}
		
		inQueue.put(jobId, s.toLowerCase());
		return jobId;
	}
	
	public static void main(String[] args) throws Exception {
		Client c = new Client("Jumbler");
		
		c.getWord();
	}

}
