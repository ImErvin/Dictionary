package ie.gmit.sw;

import java.rmi.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class Client {
	private DictionaryService ds;
	private LinkedHashMap<Integer, String> inQueue = new LinkedHashMap<Integer, String>();
	private LinkedHashMap<Integer, String> outQueue = new LinkedHashMap<Integer, String>();
	private int jobId;
	
	public Client(String s) {
		addInQueue(s);
	}

	public void getWord() throws Exception{
		ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
		outQueue.put(getFirstKey(inQueue), ds.lookup(inQueue.get(getFirstKey(inQueue))));
		inQueue.remove(getFirstKey(inQueue));
	}
	
	public int getFirstKey(LinkedHashMap<Integer, String> hm) {
	  int out = 0;
	  for (int key : hm.keySet()) {
		out = key;
		break;
	  }
	  return out;
	}
	
	public String getDefinition(){
		String response = outQueue.get(getFirstKey(outQueue));
		outQueue.remove(getFirstKey(outQueue));
		return response;
	}
	
	public int addInQueue(String s) {
		boolean control = true;
		jobId = 0;
		
		while (control) {
			jobId = new Random().nextInt(100);

			control = inQueue.containsKey(jobId) ? true : false;
		}
		
		System.out.println("addinqueue " + s);
		inQueue.put(jobId, s.toLowerCase());
		return jobId;
	}

	public int getJobId() {
		return jobId;
	}
	
}
