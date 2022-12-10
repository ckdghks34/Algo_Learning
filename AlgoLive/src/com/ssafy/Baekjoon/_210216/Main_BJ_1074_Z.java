package com.ssafy.Baekjoon._210216;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_Z{
	static int cnt = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);

		Z(size, row + 1, col + 1); // index 시작을 1부터 하기 위해 + 1 을 해줌.
		System.out.println(cnt);
	}

	public static void Z(int size, int row, int col) {
		int half = size / 2;

		if (size == 1) // size가 1이면 한칸이기 더이상 나눌 수 없음.
		{
			cnt += 1; // 자신의 값 +1
			return;
		}

		// 자신이 위치한 공간 찾기.
		if (row <= half && col <= half) // 첫번째 면
		{
			Z(half, row, col);
		}
		else if (row <= half && half < col) // 두번째 면
		{
			cnt += (half * half);
			Z(half, row, col - half);
		}
		else if (half < row && col <= half) // 세번째 면
		{
			cnt += (half * half * 2);
			Z(half, row - half, col);
		}
		else if (half < row && half < col) // 네번째 면
		{
			cnt += (half * half * 3);
			Z(half, row - half, col - half);
		}
	}
}