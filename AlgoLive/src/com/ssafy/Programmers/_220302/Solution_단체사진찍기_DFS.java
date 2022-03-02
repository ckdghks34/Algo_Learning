package com.ssafy.Programmers._220302;

public class Solution_단체사진찍기_DFS {
	public static String[] friends = { "A", "C", "F", "J", "M", "N", "R", "T" };
	public static boolean[] visited;
	public static String[] select;
	public static int answer = 0;

	public static void main(String[] args) {
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(solution(2, data));
	}

	public static int solution(int n, String[] data) {

		visited = new boolean[8];
		select = new String[8];
		dfs(0, data);

		return answer;
	}

	// 순열 찾기
	public static void dfs(int count, String[] data) {
		// 8명의 위치를 다 뽑았다면
		if (count == 8) {
			// 주어진 조건(data)에 해당하는지 확인
			if (check(data))
				// 해당되면 값 +
				answer++;
			return;
		}

		for (int i = 0; i < 8; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				select[count] = friends[i];
				dfs(count + 1, data);
				visited[i] = false;
			}
		}
	}

	public static boolean check(String[] data) {
		for (int i = 0; i < data.length; ++i) {
			char a = data[i].charAt(0);
			char b = data[i].charAt(2);
			int po1 = findplace(a); // 위치 인덱스 찾기
			int po2 = findplace(b); // 위치 인덱스 찾기

			char oper = data[i].charAt(3); // 연산자
			int index = data[i].charAt(4) - '0'; // 값

			// 무조건 1칸은 차이가 나기 때문에 +1 한 값과 비교한다.
			if (oper == '=') {
				if (!(Math.abs(po1 - po2) == index + 1))
					return false;
			} else if (oper == '>') {
				if (!(Math.abs(po1 - po2) > index + 1))
					return false;
			} else {
				if (!(Math.abs(po1 - po2) < index + 1))
					return false;
			}
		}
		return true;
	}

	public static int findplace(char c) {
		for (int i = 0; i < 8; ++i) {
			if (select[i].equals(Character.toString(c)))
				return i;
		}
		return 0;
	}
}
