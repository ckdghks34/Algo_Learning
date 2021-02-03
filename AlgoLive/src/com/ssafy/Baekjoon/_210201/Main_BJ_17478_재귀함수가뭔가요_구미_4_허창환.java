package com.ssafy.Baekjoon._210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_17478_재귀함수가뭔가요_구미_4_허창환 {

	public static String s1 = "\"재귀함수가 뭔가요?\"\n" + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
			+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
			+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" + "라고 답변하였지.";
	public static String s2 = "\"재귀함수가 뭔가요?\"\n" + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" + "라고 답변하였지.";
	public static String[] arr;
	public static String[] arr2;
	public static int index = 0;
	public static boolean turn = false;
	public static boolean last = false;

	public static void recur1(int i, int k) {
		if (i == k)
			turn = true;
		if (turn && i == 0)
		{
			System.out.println(arr2[2]);
			return;
		}
		
		if (!turn) 
		{
			for (int j = 0; j < 4; ++j) {
				for (int n = 0; n < i; ++n)
					System.out.print("____");
				System.out.println(arr[j]);
			}
			recur1(i + 1, k);
		} 
		else 
		{
			if (!last)
			{
				for (int j = 0; j < 3; ++j) {
					for (int n = 0; n < i; ++n) {
						System.out.print("____");
					}
					System.out.println(arr2[j]);
				}
				last = true;
				//recur1(i-1,k);
			}
			else 
			{
				for (int n = i; n > 0; --n)
					System.out.print("____");
				System.out.println(arr2[2]);
				//recur1(i-1,k);
			}
			
			recur1(i-1,k);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		arr = s1.split("\n");
		arr2 = s2.split("\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recur1(0, T);

	}

}
