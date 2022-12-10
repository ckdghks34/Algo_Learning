package com.ssafy.codingTest.KaKao2022;

public class Solution2 {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        solution(cap, n, deliveries, pickups);
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        int total = 0;
        for (int i = 0; i < n; ++i)
            total += deliveries[i] + pickups[i];

        while (total > 0) {
            int goTruck = 0;
            int returnTruck = 0;

            for (int i = n - 1; i >= 0; --i) {
                if(cap >= goTruck + deliveries[i])
                {
                    goTruck +=deliveries[i];
                    returnTruck += deliveries[i];
                }
                else
                {

                }
            }



        }
        return answer;
    }

}
