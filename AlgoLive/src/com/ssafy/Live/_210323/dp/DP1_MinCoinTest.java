package com.ssafy.Live._210323.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DP1_MinCoinTest {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());
		int[] D = new int[money + 1]; // 각 금액에 대한 최소 동전개수

		// D[i-1],D[i-4],D[i-6]
		/*
		 * 1 + D[1-1] = 1 + D[0]
		 * 1 + D[4-4] = 1 + D[0]
		 * 1 + D[6-6] = 1 + D[0]
		 * 0원에 대한 최소 동전개수도 마찬가지로 사용해야하기 때문에 미리 배열에 만들어 놓는것이 좋다.
		 * 조건문으로 해결 할 수 도 있다.
		 */
		
		D[0] = 0; // 0원에 대한 최소동전개수 0
		
		for(int i = 1 ; i <= money;++i)
		{
			int min = Integer.MAX_VALUE;
			
			if(D[i-1]+1 < min)
				min = D[i-1]+1;
			
			if( i >= 4 && D[i-4]+1 <min)
				min = D[i-4]+1;
			
			if( i >= 6 && D[i-6]+1 < min)
				min = D[i-6]+1;
			D[i] = min;
		}
		System.out.println(D[money]);
		System.out.println(Arrays.toString(D));
	}

}
