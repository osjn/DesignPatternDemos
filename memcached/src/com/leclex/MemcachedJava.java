package com.leclex;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public class MemcachedJava {

	public static void main(String[] args) {
		try {
			// connecting to memcached server on localhost
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			System.out.println("Connection to server successful.");
			
			// now set data into memcached server
			Future fo = mcc.set("leclex", 900, "glad to create, glad to share");
			
			// print status of set method
			System.out.println("set status: " + fo.get());
			
			// retrieve and check the value from cache
			System.out.println("leclex value in cache - " + mcc.get("leclex"));
			
			// try to add data with existing key
			Future fu = mcc.add("leclex", 900, "memcached");
			
			// print status of set method
			System.out.println("add status: " + fu.get());
			
			// adding a new key to memcached server
			fu = mcc.add("codingground", 900, "All Free compilers");
			
			// print status of set method
			System.out.println("add status: " + fu.get());
			
			// retrieve and check the value from cache
			System.out.println("codingground value in cache - " + mcc.get("codingground"));
			
			// shutdowns the memcached client
			mcc.shutdown();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
