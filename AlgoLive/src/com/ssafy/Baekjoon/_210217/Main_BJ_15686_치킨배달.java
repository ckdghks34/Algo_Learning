package com.ssafy.Baekjoon._210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_BJ_15686_치킨배달 {

	static int N, M;
	static List<house> h = new ArrayList<house>();
	static List<chicken> c = new ArrayList<chicken>();
	static chicken[] sc;
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sc = new chicken[M];
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				int tmp = Integer.parseInt(st.nextToken());

				if (tmp == 1)
					h.add(new house(j, i));
				if (tmp == 2)
					c.add(new chicken(j, i));
			}
		}
		
		combi(0,0);
		
		System.out.println(result);
		
	}

	static void combi(int start, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0, size = h.size(); i < size; ++i) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; ++j) {
					int distance = Math.abs(h.get(i).x - sc[j].x) + Math.abs(h.get(i).y - sc[j].y);
					min = Math.min(min, distance);
				}
				
				sum += min;
				
				if(sum > result)
					return;
			}
			result = sum;
			return;
		}

		for (int i = start, size = c.size(); i < size; ++i) {
			sc[cnt] = c.get(i);
			combi(i + 1, cnt + 1);
		}
	}

	static class house {
		int x, y;
		
		public house(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class chicken {
		int x, y;
		
		public chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
