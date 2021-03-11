package com.ssafy.Programmers._220311;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_skill2_1 {

	public static void main(String[] args) {
		System.out.println(solution(7, 1, 6));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;

		Queue<int[]> queue = new LinkedList<int[]>();

		for (int i = 1; i <= n; ++i)
			queue.offer(new int[] { i, 0 });

		while (!queue.isEmpty()) {
			int[] curA = queue.poll();
			int[] curB = queue.poll();

			if ((curA[0] == a && curB[0] == b) || (curA[0] == b && curB[0] == a)) {
				answer = curA[1] + 1;
				break;
			}

			if (curA[0] == a || curA[0] == b)
				queue.offer(new int[] { curA[0], curA[1] + 1 });
			else if (curB[0] == a || curB[0] == b)
				queue.offer(new int[] { curB[0], curB[1] + 1 });
			else
				queue.offer(new int[] { curA[0], curA[1] + 1 });

		}
		return answer;
	}
}
