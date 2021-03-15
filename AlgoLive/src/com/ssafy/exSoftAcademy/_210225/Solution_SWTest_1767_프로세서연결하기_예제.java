package com.ssafy.exSoftAcademy._210225;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWTest_1767_프로세서연결하기_예제 {

	static int T, N, max, totalCnt, min, map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			go(0,0);
			}
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void go(int index, int cCnt) // index : 부분집합에 고려할 코어 인덱스 / cCnt : 연결된 코어 개수
	{
		if(cCnt+(totalCnt-index)<max) // totalCnt-index : 남은 코어수
			return;
		
		if (index == totalCnt) {
			int res = getLength();
			if (max < cCnt) {
				max = cCnt;
				min = res;
			}
			else if (max == cCnt) {
				if (res < min)
					min = res;
			}
			return;
		}
		
		// 코어 선택 전선 놓아보기(4방향으로 놓아보기)
		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];

		for (int d = 0; d < 4; ++d) {
			if (isAvailable(r, c, d)) {
				// 전선놓기
				setStatus(r, c, d, 2);
				// 다음코어로 넘어가기
				go(index + 1, cCnt + 1);
				// 놓았던 전선 되돌려 놓기
				setStatus(r, c, d, 0);
			}
		}

		// 코어 비선택
		go(index + 1, cCnt);
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;

			map[nr][nc] = s;
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) // 계속 해당 방향으로 직진을 해서 경계를 벗어남. : 전원연결 가능
				break;
			if (map[nr][nc] == 1 || map[nr][nc] == 2) // 코어나 전선이 놓아져있어 불가능.
				return false;
		}
		return true;
	}
	
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) lCnt++;
				
			}
		}
		return lCnt;
	}
}