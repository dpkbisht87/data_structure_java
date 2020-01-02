package com.practice.java.tree;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class ManagedServer {
	String name;
	boolean isPodRunning = false;

	ManagedServer(String name, boolean isRunning) {
		this.name = name;
		this.isPodRunning = isRunning;
	}

}

public class LinkedListImpl {

	public static void main(String[] args) {
		int cec_replicas = 3;
		waitForManagedServersToStart(cec_replicas);
	}

	private static void waitForManagedServersToStart(int cecReplicas) {
	
		Map<String, Boolean> serverMap = new ConcurrentHashMap<String, Boolean>();
		int attempt = 1;
		for(int i = 0; i < cecReplicas; i ++) {
			String name = "cec-server-" + i;
			serverMap.put(name, false);
		}
		
		for(Map.Entry<String, Boolean> entry : serverMap.entrySet()) {
			System.out.println("Key :" +entry.getKey()+ "  Value: "+ entry.getValue());
		}
		
		while (attempt < 5 && ! serverMap.isEmpty()) {
			for(Map.Entry<String, Boolean> entry : serverMap.entrySet()) {
				//boolean isPodRunning = false;
				if (entry.getKey().equals("cec-server-1")) {
					serverMap.remove(entry.getKey());
				}
			}
			attempt++;
		}
		System.out.println("After");
		System.out.println(serverMap.keySet().toString());
		for(Map.Entry<String, Boolean> entry : serverMap.entrySet()) {
			System.out.println("Key :" +entry.getKey()+ "  Value: "+ entry.getValue());
		}
		/*List<String> serverList = new ArrayList<String>(cecReplicas); 
		
		// Create a list of servers. 
		for(int i = 0; i < cecReplicas; i ++) {
			serverList.add("cec-server-" + i);
		}
		System.out.println("size:"+serverList.size());
		int size = cecReplicas;
		
		for(String server : serverList) {
			System.out.println(server);
			boolean isPodRunning = true;
			if (isPodRunning) {
				System.out.println("size:"+size);
				serverList.remove(server);
				size --;
			}
		}*/
//		while (attempt < 3 && ! serverList.isEmpty()) {
			
			/*for(int i = 0; i < size; i ++) {
//				boolean isPodRunning = waitForManagedServerToStart(serverList.get(i));
				boolean isPodRunning = true;
				if (isPodRunning) {
					System.out.println("size:"+size);
					serverList.remove(i);
					size --;
				}
			}*/

		//}
		
//		for(int j = 0; j < cecReplicas; j ++) {
//			System.out.println(serverList.get(j));
//		}
//		
		/*List<ManagedServer> ms_servers = new LinkedList<ManagedServer>();
		int attempt = 1;

		for (int i = 0; i < cecReplicas; i++) {
			String servername = "cec_server_" + i;
			ManagedServer ms = new ManagedServer(servername, false);
			ms_servers.add(ms);
		}
		
		while (attempt < 3 && ! ms_servers.isEmpty()) {
			for (ManagedServer server : ms_servers) {
				String name = server.name;
				System.out.println(server.name);
				System.out.println(server.isPodRunning);

				boolean isPodRunning = waitForManagedServerToStart(name);
				if (isPodRunning) {
					ms_servers.remove(server);
				}
			}
		}*/
	}

	private static boolean waitForManagedServerToStart(String ms) {

		return false;

	}

}
