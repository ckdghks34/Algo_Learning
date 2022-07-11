package com.ssafy.codingTest.Socar;

import java.util.HashMap;
import java.util.Iterator;

public class solution1 {

	// '[]([[]){}' = 3
	public static void main(String[] args) {
		String s = "[]([[]){}";		
		
		char missing = Checkingchar(s);
		
		System.out.println(missing);
	}
	
	public static char Checkingchar(String s) {
		HashMap<Character,Integer> map = new HashMap<>();

		for(int i = 0; i < s.length();++i)
		{
			char cur = s.charAt(i);
			
			if(!map.containsKey(cur))
			{
				map.put(cur, 1);
			}
			else
			{
				map.replace(cur, map.get(cur)+1);
			}
		}
		
		Iterator<Character> keys = map.keySet().iterator();
		
		
		char findChar = ' ';
		
		while(keys.hasNext())
		{
			char key = keys.next();
			
			if(map.get(key) % 2 != 0)
				{findChar = key;
					break;
				}
		}
		
		return findChar;
	}

}
