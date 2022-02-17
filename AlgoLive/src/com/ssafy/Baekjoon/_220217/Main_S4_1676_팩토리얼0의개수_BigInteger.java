package com.ssafy.Baekjoon._220217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main_S4_1676_팩토리얼0의개수_BigInteger {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		BigInteger fac = new BigInteger("1");

		for (int i = N; i > 1; --i) {
			fac = fac.multiply(BigInteger.valueOf(i));
		}

		BigInteger Bigten = new BigInteger("10");
		while (fac.remainder(Bigten) == BigInteger.ZERO) {
			count++;
			fac = fac.divide(Bigten);
		}

		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
