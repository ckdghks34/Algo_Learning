package com.ssafy.Live._210202.exhaustive;

public class C1_Zigzag {

	static int ROW = 3;
	static int COL = 4;
	static int[][] arr = new int[ROW][COL];
	
	public static void main(String[] args) {
		Circuit01();
		System.out.println();
		Circuit02();
	}
	public static void Circuit01()
	{
		for(int i = 0; i <ROW;++i)
		{
			if(i%2 == 0)
			{
				for(int j =0; j <COL; ++j)
				{
					System.out.println(arr[i][j]+ "\t");
				}
			}
			else
			{
				for(int j =COL-1; j<=0;--j)
				{
					System.out.println(arr[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}
	
	public static void Circuit02()
	{
		
	}
}
