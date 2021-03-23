package com.ssafy.exSoftAcademy._210315;

import java.io.*;
import java.util.*;

public class Solution_d4_8382_방향전환_4_허창환_BFS {
	static class Point {
		int x;
		int y;
		int cnt;
		boolean dir; // 가로 false, 세로 true;

		public Point() {
			x = 0;
			y = 0;
			cnt = 0;
			dir = false;
		}

		public Point(int x, int y, int cnt, boolean dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int[] dx = { 0, 0, -1, 1 }; // 상하,좌우
	static int[] dy = { -1, 1, 0, 0 }; //

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./res/ES_input_d4_8382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int dist = Math.abs(x1 - x2) + Math.abs(x1 - x2);

			Queue<Point> queue = new LinkedList<Point>();
			boolean[][][] visited = new boolean[201][201][2]; // 가로 0, 세로 1

			queue.offer(new Point(x1, y1, 0, false)); // x,y,cnt,dir
			visited[x1][y1][0] = true; // 가로0
			queue.offer(new Point(x1, y1, 0, true)); // x,y,cnt,dir
			visited[x1][y1][1] = true; // 세로1

			while (!queue.isEmpty()) {
				Point p = queue.poll();
				if (dist < (Math.abs(x2 - p.x) + Math.abs(y2 - p.y)))
					continue;
				if (p.x == x2 && p.y == y2) {
					sb.append("#").append(tc).append(" ").append(p.cnt).append("\n");
					break;
				}

				if (p.dir == false) { //가로 false
					for(int d =2; d <4; d++)
					{
						int nx = p.x +dx[d];
						int ny = p.y +dy[d];
						
						if(nx < 0 || nx < nx || ny <0 || 100 < ny)
							continue;
						if(visited[nx][ny][1]) 
							continue;
						queue.offer(new Point(nx,ny,p.cnt+1,!p.dir));
						visited[nx][ny][0] = true;
					}
				} else if (p.dir == true) { // 세로 true
					for(int d =0; d<2; d++)
					{
						int nx = p.x +dx[d];
						int ny = p.y +dy[d];
						
						if(nx < 0 || nx < nx || ny <0 || 100 < ny)
							continue;
						if(visited[nx][ny][0]) 
							continue;
						queue.offer(new Point(nx,ny,p.cnt+1,!p.dir));
						visited[nx][ny][0] = false;
					}
				}
			}
		}
		System.out.print(sb.toString());
		br.close();
	}

}
