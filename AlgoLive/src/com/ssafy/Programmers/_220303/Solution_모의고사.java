package com.ssafy.Programmers._220303;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_모의고사 {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
		System.out.println("Answer : [" + 1 + "]");

//		int[] answers = { 1, 3, 2, 4, 2 };
//		System.out.println("Answer : [" + "1, 2, 3" + "]");

		System.out.println("result : " + Arrays.toString(solution(answers)));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};
		int max = 0;

		// 각 수포자들의 정답 갯수 저장
		int[] count = new int[3];

		// 각 수포자들의 패턴을 저장
		int[] first = { 1, 2, 3, 4, 5 };
		int[] second = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] third = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int fsize = first.length;
		int ssize = second.length;
		int tsize = third.length;

		for (int i = 0; i < answers.length; ++i) {
			int current = answers[i];

			if (current == first[i % fsize])
				count[0]++;
			if (current == second[i % ssize])
				count[1]++;
			if (current == third[i % tsize])
				count[2]++;
		}

		// 가장 많이 맞춘 정답 갯수
		max = Math.max(count[0], Math.max(count[1], count[2]));

		// ArrayList 사용
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 3; ++i) {
			if (max == count[i])
				list.add(i + 1);
		}

		answer = list.stream().mapToInt((i) -> i.intValue()).toArray();

//		// 배열을 사용하여 저장
//		int cnt = 0;
//		for (int i = 0; i < 3; ++i)
//			if (max == count[i])
//				cnt++;
//
//		answer = new int[cnt];
//
//		int tmp = 0;
//		for (int i = 0; i < 3; ++i) {
//			if (max == count[i]) {
//				answer[tmp++] = i + 1;
//			}
//		}

		return answer;
	}

}
