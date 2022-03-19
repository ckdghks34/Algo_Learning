package com.ssafy.codingTest.SK_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1 {

	public static void main(String[] args) {
		// int money = 4578;
		// int[] costs = { 1, 4, 99, 35, 50, 1000 };
		int money = 1999;
		int[] costs = { 2, 11, 20, 100, 200, 600 };

		System.out.println(Arrays.toString(costs));
		System.out.println(solution(money, costs));

	}

	public static int solution(int money, int[] costs) {
		int answer = 0;
		int[] money_cost = { 1, 5, 10, 50, 100, 500 };
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				double a = (double) o1[0] / o1[1];
				double b = (double) o2[0] / o2[1];
				return -Double.compare(a, b);
			}

		});

		for (int i = 0; i < costs.length; i++) {
			pq.offer(new int[] { money_cost[i], costs[i] });
		}

		while (!pq.isEmpty() && money > 0) {
			int[] cur = pq.poll();

			int count = money / cur[0];

			answer += count * cur[1];
			money = money % cur[0];
		}

		return answer;
	}

}
