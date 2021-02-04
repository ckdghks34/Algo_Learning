package com.ssafy.exSoftAcademy._210204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d3_1225_암호생성기 {

	static final int T = 10;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/ES_input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();

		for (int tc = 1; tc <= T; ++tc) {

			int tmp = 0;
			boolean end = false;
			int test = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 입력
			while (st.hasMoreTokens()) // st.hastMoreTokens() == 다음 토큰이 존재하는지 확인
				q.offer(Integer.parseInt(st.nextToken()));

			/*while (!end) {
				for (int i = 1; i <= 5; ++i) {
					tmp = q.poll() - i;
					if (tmp <= 0) {
						q.offer(0);
						end = true;
						break;
					}
					q.offer(tmp);
				}
			}*/

			while (!end) {
				int i = 1;
				while (i <= 5) {
					if (q.peek() - i <= 0) {
						q.poll();
						q.offer(0);
						end = true;
						break;
					}
					q.offer(q.poll() - i++);
				}
			}

			System.out.print("#" + test + " ");

			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}

			System.out.println();
		}
		br.close();
	}
}
