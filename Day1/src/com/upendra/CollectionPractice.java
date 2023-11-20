package com.upendra;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class CollectionPractice {
	public static void main(String[] args) {
		String str = "capgemini";
 
		Map<Character, Integer> oMap = new HashMap<>();
		char[] chars = str.toCharArray();
  
		for (char c : chars) {
 
			Integer integer = oMap.get(c);
 
			if (integer == null) {
				oMap.put(c, 1);
			} else {
				oMap.put(c, integer + 1);
			}
 
		}
		System.out.println(oMap);
	}
}
