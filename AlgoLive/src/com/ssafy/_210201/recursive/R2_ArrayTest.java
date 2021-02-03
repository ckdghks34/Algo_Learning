package com.ssafy._210201.recursive;

public class R2_ArrayTest {
	
	static int arr[] = {10,20,30};
	
	// 현재 배열의 윈소의 출력
	private static void printArray1(int index) {
		if(index == arr.length-1)
		{
			System.out.println(arr[index]);
			return;
		}
		
		System.out.print(arr[index]+", ");
		printArray1(index+1);
	}
	
	static int arr2[][] = {{11,12,13},{20,30,40}};
	
	private static void printRowArray(int i) {
		
		if(i == arr2.length)
			return;
		
		for(int j =0 ; j < arr2[i].length;j++)
		{
			System.out.print(arr2[i][j] + "\t");
		}
		System.out.println();
		
		printRowArray(i+1);
	}
	
	private static void printRowColArray(int i,int j) {
		
		if(i == arr2.length)
			return;
		
		if(j == arr2[i].length)
		{
			System.out.println();
			printRowColArray(i+1, 0);
		}
		else
		{
			System.out.print(arr2[i][j] + "\t");
			printRowColArray(i,j+1);			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		printArray1(0);
		
		printRowArray(0);
		printRowColArray(0,0);
	}

}
