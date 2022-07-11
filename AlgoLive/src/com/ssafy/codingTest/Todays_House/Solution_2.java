package com.ssafy.codingTest.Todays_House;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		
		map.put("a", "B");
		a.add("ss");
		a.add("gg");
		System.out.println(map.get("a"));
		System.out.print(map.get("b"));
		
		System.out.println(a.indexOf("gg"));
	}

}
