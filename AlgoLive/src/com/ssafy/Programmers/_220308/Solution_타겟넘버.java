package com.ssafy.Programmers._220308;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_타겟넘버 {
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
//		int[] numbers = {1,1,1,1,1};
//		int target = 3;

		int[] numbers = { 4, 1, 2, 1 };
		int target = 4;

		sb.append(solution(numbers, target));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		Queue<int[]> queue = new LinkedList<int[]>();
		int maxcnt = numbers.length;

		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cursum = cur[0];
			int curcnt = cur[1];

			if (curcnt == maxcnt) {
				if (cursum == target)
					answer++;
				continue;
			}

			queue.offer(new int[] { cursum + numbers[curcnt], curcnt + 1 });
			queue.offer(new int[] { cursum - numbers[curcnt], curcnt + 1 });
		}
		return answer;
	}

}
