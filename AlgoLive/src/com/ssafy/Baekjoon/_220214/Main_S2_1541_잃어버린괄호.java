package com.ssafy.Baekjoon._220214;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		int result = 0;

		// '+' 연산을 먼저한 한 뒤 '-'연산을 하여 가장 최솟값을 구한다.

		// '-' 를 기준으로 문자열을 나눔.
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		// 나눈 문자열이 있을 때 까지 반복
		while (st.hasMoreTokens()) {
			// 다시 '+'를 기준으로 문자열을 나눈 뒤 숫자를 모두 더한다.
			StringTokenizer tokenizer = new StringTokenizer(st.nextToken(), "+");
			int cur = 0;

			while (tokenizer.hasMoreTokens()) {
				cur += Integer.parseInt(tokenizer.nextToken());
			}

			// 모든 숫자를 queue에 저장
			queue.add(cur);
		}

		// 가장 앞에 있는 수를 먼저 저장한다.
		// 그렇지 않으면 가장 앞에 있는 숫자까지 '-' 하기 때문에 값이 다름.
		result = queue.poll();

		// queue에 저장된 모든 수를 '-'연산하여 저장한다.
		while (!queue.isEmpty())
			result -= queue.poll();

		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();

	}
}
