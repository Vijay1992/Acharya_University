package com.au.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Temp {
public static void main(String[] args) {
	Map map = new HashMap<>();
	map.put(1, "vijay");
	map.put(2, "vijay1");
	map.put(3, "vijay2");
	map.put(4, "vijay3");
	map.put(5, "vijay4");
	
	
	Set key = map.keySet();
	Collection val = map.values();
	System.out.println(key);
	System.out.println(val);

	Set ss = map.entrySet();
	Iterator it = ss.iterator();

	while(it.hasNext()) {
		System.out.println(it.next());
	}
}
}
