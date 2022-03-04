package com.ssafy.Programmers._220304;

import java.util.Arrays;

public class Solution_K번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(Arrays.toString(solution(array, commands)));

	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		int size = commands.length;

		answer = new int[size];

		for (int i = 0; i < size; ++i) {
			int a = commands[i][0];
			int b = commands[i][1];
			int c = commands[i][2];
			
			int[] tmp = Arrays.copyOfRange(array, a-1, b);
			Arrays.sort(tmp);
			
			answer[i] = tmp[c-1];
		}

		return answer;
	}

//	public static int[] solution(int[] array, int[][] commands) {
//		int[] answer = {};
//		int size = commands.length;
//
//		answer = new int[size];
//
//		for (int a = 0; a < size; ++a) {
//			int i = commands[a][0];
//			int j = commands[a][1];
//			int k = commands[a][2];
//
//			int[] tmp = new int[j - i + 1];
//			int tcnt = 0;
//			for (int b = i - 1; b < j; ++b)
//				tmp[tcnt++] = array[b];
//
//			Arrays.sort(tmp);
//
//			answer[a] = tmp[k - 1];
//		}
//
//		return answer;
//	}
}
