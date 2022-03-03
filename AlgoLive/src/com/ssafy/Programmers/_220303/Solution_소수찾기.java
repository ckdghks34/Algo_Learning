package com.ssafy.Programmers._220303;

import java.util.HashMap;
import java.util.Iterator;

public class Solution_소수찾기 {
	public static char[] number;
	public static boolean[] visited;
	public static char[] selected;
	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {
//		String numbers = "17";
//		System.out.println("answer : " + 3);
		String numbers = "011";
		System.out.println("answer : " + 2);
		System.out.println("result : " + solution(numbers));
	}

	public static int solution(String numbers) {
		int answer = 0;
		number = numbers.toCharArray();
		visited = new boolean[number.length];

		for (int i = 1; i <= number.length; ++i) {
			selected = new char[i];
			per(i, 0);
		}

		Iterator<Integer> iter = map.keySet().iterator();

		while (iter.hasNext()) {
			int current = iter.next();

			if (isPrime(map.get(current)))
				answer++;
		}

		return answer;
	}

	public static void per(int size, int cnt) {
		if (cnt == size) {
			String tmp = "";
			for (int i = 0; i < selected.length; ++i)
				tmp += selected[i];

			int value = Integer.parseInt(tmp);
			map.put(value, value);
			System.out.println(value);
			return;
		}

		for (int i = 0; i < number.length; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = number[i];
				per(size, cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;

//		int len = num / 2;
		int len = (num / 2) + 1;

		// 해당 수의 반(1/2)를 기준으로 나눠보면 소수인지 아닌지 알 수 있음.
		for (int i = 2; i < len; ++i) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
