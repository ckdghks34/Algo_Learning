package com.ssafy.Live._210317.disjointset_mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST2_PrimTest {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		
		for(int i =0 ; i < N;++i)
		{
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; ++j)
			{
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0; // 0을 시작정점으로 처리하기 위해 0 세팅
		
		for(int i = 0 ; i <N;++i)
		{
			int min = Integer.MAX_VALUE;
			int minVertex =0;
			// 신장트리에 연결되지 않은 정점 중 minEdge 비용이 최소인 정점
			
			for(int j =0 ; j < N; ++j)
			{
				if(visited[i] &&min> minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			result += min; // 해당 정점의 간선비용 누적
			visited[minVertex] = true;
			
			for(int j =0 ; j < N; ++i)
			{
				if(visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i])
				{
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
	}

}
