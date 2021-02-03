package com.ssafy.Baekjoon._210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치켜고끄기_구미_4_허창환 {

	public static int[] toggle;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int student;
		toggle = new int[T + 1]; // 0 인덱스는 사용 x

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int tokensize = st.countTokens();
		
		for (int i = 1; i <= tokensize; ++i) {
			toggle[i] = Integer.parseInt(st.nextToken());
		}

		student = Integer.parseInt(br.readLine());

		// 학생 수 만큼 반복
		for (int i = 1; i <= student; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());	// 1 : 남학생 , 2: 여학생
			int l = Integer.parseInt(st.nextToken());	// 부여받은 위치
			
			// 남학생일 경우
			if (s == 1) {
				// 부여받은 번호의 배수가 배열 사이즈 보다 작을 때 반복
				for (int j = 1; j*l <= T; ++j) 
						toggle[l * j] = toggle[l * j] == 0 ? 1 : 0; // 부여받은 스위치 번호 값 변경
			} 
			// 여학생일 경우
			else {
				toggle[l] = toggle[l] == 0 ? 1 : 0; // 부여받은 스위치 번호 값 변경
				
				int down = l - 1;
				int up = l + 1;

				for (int j = 0; j <= T / 2; ++j) {
					if (down < 1 || up > T) // 대칭 되는 인덱스가 배열보다 커지거나 1보다 작아질때
						break;
					
					// 대칭되는 값들이 다르면 멈춤
					if (toggle[down] != toggle[up]) 
						break;
					
					toggle[down] = (toggle[down] == 0) ? 1:0;
					toggle[up] = (toggle[up] == 0) ? 1:0;
					// 삼항연산자 때문에 증감연산자를 따로 빼서 사용
					// 디버깅해볼것.
					down--;
					up++;
					
				}
			}
		}
		
		for (int i = 1; i <= T; ++i) {
			if (i == T) {
				System.out.print(toggle[i]);
				break;
			}
			if(i%20 == 0)
				System.out.println(toggle[i]);
			else
			{
				System.out.print(toggle[i] + " ");
			}
				
		}
	}

}
