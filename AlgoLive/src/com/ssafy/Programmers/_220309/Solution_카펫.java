package com.ssafy.Programmers._220309;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_카펫 {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] brown = { 10, 8, 24 };
		int[] yellow = { 2, 1, 24 };

		sb.append(Arrays.toString(solution(brown[0], yellow[0]))).append("\n");
		sb.append(Arrays.toString(solution(brown[1], yellow[1]))).append("\n");
		sb.append(Arrays.toString(solution(brown[2], yellow[2]))).append("\n");

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int total = brown + yellow;

		for (int i = 3; i < total; ++i) {
			if (total % i == 0) {
				int row = total / i;
				int col = total / row;

				if (row >= col) {
					answer[0] = row;
					answer[1] = col;

					if ((row - 2) * (col - 2) == yellow)
						return answer;
				}
			}
		}

		return answer;
	}
}
