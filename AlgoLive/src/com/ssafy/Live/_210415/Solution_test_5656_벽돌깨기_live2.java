package com.ssafy.Live._210415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_test_5656_벽돌깨기_live2 {

	private static int N, W, H, min;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int[][] map = new int[H][W];

			for (int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			go(0, map);
			sb.append(min);
			System.out.println(sb.toString());
		}
	}

	// 중복순열로 구슬 떨어뜨리기
	// cnt : 구슬을 떨어뜨린 횟수
	private static boolean go(int cnt, int[][] map) {
		int result = getRemain(map);
		if(result == 0) { //모두 빈칸(깨뜨릴 벽돌이 없다)
			min = 0;
			return true;
		}
		if (cnt == N) {
			min = Math.min(min,result);
			return false;
		}
		int[][] newMap = new int[H][W];

		// 매 열 마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; ++c) {
			int r = 0;

			while (r < H && map[r][c] == 0)
				++r;

			if (r == H) // 맞는 벽돌 없음(모두 빈칸)
				continue; // 다음 열로 구슬 떨어뜨리기.
			
			else {
				// 기존 cnt-1 구슬까지의 상태로 초기화
				copy(map, newMap);
				// 벽돌 깨뜨리기
				boom(newMap, r, c);
				// 벽돌 내리기(깨지고 난 빈 공간 처리)
				down(newMap);
				// 다음 구슬 던지기
				if(go(cnt + 1, newMap)) return true;
			}
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int count =0 ;
		for(int i =0 ; i < H;++i)
		{
			for(int j =0; j < W;++j)
			{
				if(map[i][j] > 0)
					++count;;
			}
		}
		return count;
	}

	private static void boom(int[][] map, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		if (map[r][c] > 1) {
			queue.offer(new int[] { r, c, map[r][c] });
		}
		map[r][c] = 0; // 제거처리 (방문처리 효과)

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int d = 0; d < 4; ++d) {
				int nr = p[0];
				int nc = p[1];

				for (int k = 1; k < p[2]; ++k) {
					nr += dr[d];
					nc += dc[d];
					if (0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1)
							queue.offer(new int[] { r, c, map[r][c] });

						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			int r = H - 1;
			while (r >= 0 && map[r][c] == 0)
				--r;
			if (r < 0) // 모두 빈칸이면 내릴것이 없으므로 옆열 내리기
				continue;

			r = H - 1;
			while (r > 0) {
				if (map[r][c] == 0) { // 빈칸이면
					// 직전부터 위쪽 탐색하며 가장 가까운 벽돌 찾기
					int nr = r - 1;
					while (0 < nr && map[nr][c] == 0)
						--nr;
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

}
