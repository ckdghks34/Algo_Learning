package com.ssafy.Jungol._210318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_JO_1863_종교 {
	static int N, M;

	static int[] students;

	public static void make() {
		for (int i = 0; i < N; ++i) {
			students[i] = i;
		}
	}

	public static int find(int a) {
		if (students[a] == a)
			return a;
		return students[a] = find(students[a]);
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		students[bRoot] = aRoot;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		students = new int[N];

		int result = 1;

		List<Integer> list = new ArrayList<>();
		make();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			union(a, b);
		}

		Arrays.sort(students);
		int preVal = students[0];
		for (int i = 1; i < N; ++i) {
			if(preVal != students[i])
			{
				result++;
				preVal = students[i];
			}
		}

		/*
		 * list.add(students[0]);
		 * 
		 * 
		 * for (int i = 1; i < N; ++i) { boolean check = true;
		 * 
		 * for (int j = 0, size = list.size(); j < size; ++j) {
		 * if(students[i]==list.get(j)) { check = false; break; } }
		 * 
		 * if(check) { list.add(students[i]); } } result = list.size();
		 */
		System.out.println(result);
	}

}
