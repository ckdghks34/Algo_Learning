package com.ssafy.Live._210215.compare;

import java.util.Arrays;
import java.util.Comparator;

public class C2_SortTest2 {

	public static void main(String[] args) {
		int[][] students = { { 1, 10 }, { 3, 50 }, { 4, 10 }, { 1, 100 } };

		print(students);
		Arrays.sort(students, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
//				int diff = o1[0] - o2[0];
				int diff = Integer.compare(o1[0], o2[0]);
				return diff != 0 ? diff : Integer.compare(o2[1],o1[1]);
			}
		});
		print(students);
	}

	private static void print(int[][] arr) {
		for (int[] is : arr)
			System.out.print(Arrays.toString(is));
		System.out.println();
	}

}
