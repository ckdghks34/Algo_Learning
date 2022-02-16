package com.ssafy.Baekjoon._220216;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_S3_9375_패션왕신해빈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		HashMap<String, Integer> hashmap;
		int T = Integer.parseInt(br.readLine());
		int n;

		for (int tc = 1; tc <= T; ++tc) {
			hashmap = new HashMap<>();
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				sb.append(0).append("\n");
				continue;
			}

			for (int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine(), " ");

				st.nextToken();
				String key = st.nextToken();

				if (hashmap.containsKey(key))
					hashmap.put(key, hashmap.get(key) + 1);
				else
					hashmap.put(key, 1);
			}

			Iterator<Integer> iter = hashmap.values().iterator();

			int result = iter.next() + 1;

			while (iter.hasNext())
				result *= iter.next() + 1;

			result -= 1;

			sb.append(result).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
