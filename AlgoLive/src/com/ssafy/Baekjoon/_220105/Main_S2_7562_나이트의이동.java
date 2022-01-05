package com.ssafy.Baekjoon._220105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S2_7562_나이트의이동 {
	static class Node {
		int x;
		int y;
		int cntmove;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			cntmove = 0;
		}

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			cntmove = cnt;
		}
		
		
	}

	public static int T;
	public static int N;
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
	//
	public static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	public static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Node start = new Node(x, y);
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Node arrival = new Node(x, y);


			bfs(start, arrival);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(Node start, Node arrival) {
		Queue<Node> queue = new LinkedList<Node>();

		boolean[][] visited = new boolean[N][N];
		queue.offer(start);
		visited[start.y][start.x] = true;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.x == arrival.x && cur.y == arrival.y) {
				sb.append(cur.cntmove).append("\n");
				break;
			}
			for (int i = 0; i < 8; ++i) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[ny][nx]) {
						visited[ny][nx] = true;
						queue.offer(new Node(nx, ny, cur.cntmove + 1));
					}
				}
			}

		}
	}
}
