package com.ssafy.Live._210225.sort;

public class Sort {
	public static void countingSort(int[] list) {
		final int Size = list.length;
		int[] result = new int[Size];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < Size; ++i) {
			if (list[i] < min)
				min = list[i];
			if (list[i] > max)
				max = list[i];
		}

		int[] count = new int[max + 1];

		// 배열 원소 카운팅
		for (int i = 0; i < Size; ++i) {
			count[list[i]]++;
		}

		// 카운팅 변형 : 누적합
		for (int i = min + 1; i <= max; ++i) {
			count[i] = count[i - 1] + count[i];
		}

		// 배열원소 하나씩 들여다보며 결과배열의 각 원소값에 해당하는 위치에 채움
		for (int i = Size - 1; i >= 0; i--) {
			result[--count[list[i]]] = list[i];
		}

		System.arraycopy(result, 0, list, 0, Size);
	}

	public static void mergeSort(int[] list) {
		mergeSort(list, 0, list.length - 1);
	}

	private static void mergeSort(int[] list, int start, int end) {
		
		if(start == end) return;
		
		// 2집합으로 분할하여 각각 정렬시킴
		int middle = (start + end) / 2;

		mergeSort(list, start, middle);	// 왼쪽 집합
		mergeSort(list, middle + 1, end); // 오른쪽 집합

		// 정렬된 2집합을 이용하여 병합
		merge(list, start, middle, end);
	}

	private static void merge(int[] list, int start, int middle, int end) {
		int[] newArr = new int[end - start + 1];
		int left = start, right = middle + 1;
		int i = 0;
		do {
			if (list[left] < list[right]) {
				newArr[i++] = list[left++];
			} else
				newArr[i++] = list[right++];
		} while (left <= middle && right <= middle);

		// 오른쪽 집합이 다 소비된 경우.
		while (left <= middle) {
			newArr[i++] = list[left++];
		}
		
		// 왼쪽 집합이 다 소비된 경우
		while (right <= end) {
			newArr[i++] = list[right++];
		}
		
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}
}
