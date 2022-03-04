package com.ssafy.Programmers._220304;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {

	public static void main(String[] args) {
//		int[] numbers = {6,10,2};
//		int[] numbers = {3,30,34,5,9};
		int[] numbers = { 0, 0, 0, 0 };

		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";

		String[] tmp = new String[numbers.length];
		for (int i = 0; i < numbers.length; ++i) {
			tmp[i] = Integer.toString(numbers[i]);
		}

		Arrays.sort(tmp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});

		for (int i = tmp.length - 1; i >= 0; --i)
			answer += tmp[i];

		if (answer.charAt(0) == '0')
			return "0";

		return answer;
	}

}
