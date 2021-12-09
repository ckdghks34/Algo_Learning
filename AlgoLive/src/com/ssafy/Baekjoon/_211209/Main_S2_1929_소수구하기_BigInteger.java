package com.ssafy.Baekjoon._211209;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_S2_1929_소수구하기_BigInteger {

	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		int[] arr = new int[(m.add(BigInteger.ONE).intValue())];
		
		// 소수이면 0, 소수가 아니면 1
		// 0과 1은 소수가 아니기 때문에 미리 변경해준다.
		arr[0] = 1;
		arr[1] = 1;
		// 2부터 시작해서 i의 배수를 모두 제외해줌.
		for(BigInteger i = new BigInteger("2"); i.compareTo(m) <= 0; i = i.add(BigInteger.ONE))
		{
			if(arr[i.intValue()] == 1)
				continue;

			
			for(BigInteger j = i.pow(2); j.compareTo(m)<=0; j = j.add(i))
			{
				arr[j.intValue()] = 1;
			}
			
			if(i.compareTo(n) >= 0)
			{
				sb.append(i);
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
