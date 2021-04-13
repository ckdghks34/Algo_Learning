package com.ssafy.exSoftAcademy._210413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
1
6 2
3 3 3 2 1 1
3 3 3 2 2 1
3 3 3 3 3 2
2 2 3 2 2 2
2 2 3 2 2 2
2 2 2 2 2 2
 */
public class Solution_test_4014_활주로건설 {
	static int N, X;
	static int[][] map;
	static int[][] tmap;
	static int min;
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			tmap = new int[N][N];

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmap[j][i] = map[i][j];
				}
			}

			System.out.println(process());
			System.out.println(process2());
		}
	}

	private static int process() {
		int count = 0;
		for (int i = 0; i < N; ++i) {
			if (makeRoadByRow(i))
				count++;
			if (makeRoadByCol(i))
				count++;
		}

		return count;
	}

	private static int process2() {
		int count = 0;
		for (int i = 0; i < N; ++i) {
			if (makeRoad(map[i]))
				count++;
			if (makeRoad(tmap[i]))
				count++;

		}
		return count;
	}

	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0];
		int size = 1;
		int i = 1; // 탐색열 위치
		while (i < N) {
			if (beforeHeight == road[i]) 
			{
				size++;
				i++;
			} 
			else if (beforeHeight + 1 == road[i]) 
			{ // 오르막
				if (size < X) // 경사로 설치 불가
					return false;
				beforeHeight++;
				size = 1;
				++i;
			} 
			else if (beforeHeight - 1 == road[i]) 
			{
				int count = 0;
				
				for (int k = i; k < N; k++) {
					if (road[k] != beforeHeight - 1)
						break;
					if (++count == X)
						break;
				}
				
				if (count < X)
					return false; // 경사로 설치불가
				beforeHeight--;
				size = 0;
				i += X;
			} 
			else
				return false;
		}
		
		return true;
	}

	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[i][0];
		int size = 1;
		int j = 0; // 탐색열 위치
		while (j < N) {
			if (beforeHeight == map[j][i]) {
				size++;
				j++;
			} else if (beforeHeight + 1 == map[j][i]) { // 오르막
				if (size < X) // 경사로 설치 불가
					return false;
				beforeHeight++;
				size = 1;
				++j;
			} else if (beforeHeight - 1 == map[i][j]) {
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[k][i] != beforeHeight - 1)
						break;
					if (++count == X)
						break;
				}
				if (count < X)
					return false; // 경사로 설치불가
				beforeHeight--;
				size = 0;
				j += X;
			} else
				return false;
		}

		return true;
	}

	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[i][0];
		int size = 1;
		int j = 0; // 탐색열 위치
		while (j < N) {
			if (beforeHeight == map[i][j]) {
				size++;
				j++;
			} else if (beforeHeight + 1 == map[i][j]) { // 오르막
				if (size < X) // 경사로 설치 불가
					return false;
				beforeHeight++;
				size = 1;
				++j;
			} else if (beforeHeight - 1 == map[i][j]) {
				int count = 0;
				for (int k = j; k < N; k++) {
					if (map[i][k] != beforeHeight - 1)
						break;
					if (++count == X)
						break;
				}
				if (count < X)
					return false; // 경사로 설치불가
				beforeHeight--;
				size = 0;
				j += X;
			} else
				return false;
		}

		return true;
	}
}
