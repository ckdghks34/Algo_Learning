package com.ssafy.Programmers._220311;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_skill2_2 {

	public static void main(String[] args) {

//		[2,1]
//		int[] progresses = {93,30,55};
//		int[] speeds = {1,30,5};

		// [1,3,2]
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		int[] day = new int[progresses.length];

		for (int i = 0; i < progresses.length; ++i) {
			day[i] = (100 - progresses[i]) / speeds[i];
			if ((100 - progresses[i]) % speeds[i] != 0)
				day[i] += 1;
		}

		int cur = day[0];
		int cnt = 1;
		for (int i = 1; i < day.length; ++i) {
			if (cur < day[i]) {
				list.add(cnt);
				cnt = 1;
				cur = day[i];
			} else
				cnt++;
		}
		list.add(cnt);

		answer = new int[list.size()];
		for (int i = 0; i < list.size(); ++i) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
