package com.ssafy.Programmers._221215;

import java.util.*;

/*
 * 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.
 * 주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 */
public class 주차연습계산 {
    public static void main(String[] args) {
//        int[] fees = {180, 5000, 10, 600};
        int[] fees = {120, 0, 60, 591};
//        int[] fees = {1, 461, 1, 10};

//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
//        String[] records = {"00:00 1234 IN"};

        System.out.println(Arrays.toString(new Solution().solution(fees, records)));
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer = {};
            final int LastOutTime = 23 * 60 + 59;
            TreeMap<String, Integer> timeMap = new TreeMap<>();

            ArrayList<Parking> parkInList = new ArrayList<>();
            ArrayList<Parking> parkOutList = new ArrayList<>();

            for (String record : records) {
                String[] splitString = record.split(" ");
                String[] splitTime = splitString[0].split(":");
                int time = Integer.parseInt(splitTime[0]) * 60;
                time += Integer.parseInt(splitTime[1]);

                String number = splitString[1];
                String inOut = splitString[2];

                if (inOut.equals("IN"))
                    parkInList.add(new Parking(time, number));
                else
                    parkOutList.add(new Parking(time, number));
            }
            Collections.sort(parkInList);
            Collections.sort(parkOutList);

            for (int i = 0; i < parkOutList.size(); ++i) {
                Parking outPark = parkOutList.get(i);
                Parking inPark = null;

                for (int j = 0; j < parkInList.size(); ++j) {
                    if (outPark.number.equals(parkInList.get(j).number)) {
                        inPark = parkInList.get(j);
                        parkInList.remove(j);
                        break;
                    }
                }
                int parkingTime = outPark.time - inPark.time;

                if (timeMap.containsKey(outPark.number)) {
                    int currentTime = timeMap.get(outPark.number);
                    timeMap.put(outPark.number, currentTime + parkingTime);
                } else
                    timeMap.put(outPark.number, parkingTime);
            }

            for (Parking curPark : parkInList) {
                int parkingTime = LastOutTime - curPark.time;

                if (timeMap.containsKey(curPark.number)) {
                    int currentTime = timeMap.get(curPark.number);
                    timeMap.put(curPark.number, currentTime + parkingTime);
                } else
                    timeMap.put(curPark.number, parkingTime);
            }

            for(Integer time : timeMap.values())
            {
                int totalfee = fees[1];
                if(time > fees[0]) {
                    totalfee += ((time - fees[0]) / fees[2]) * fees[3];
                    totalfee += ((time - fees[0]) % fees[2]) > 0 ? fees[3] : 0;
                }

                int answerLen = answer.length;
                answer = Arrays.copyOf(answer, answerLen+1);
                answer[answerLen] = totalfee;
            }
            return answer;
        }

        static class Parking implements Comparable<Parking> {
            int time;
            String number;

            Parking(int time, String number) {
                this.time = time;
                this.number = number;
            }

            @Override
            public int compareTo(Parking o) {
                if (this.number.compareTo(o.number) == 0)
                    return this.time - o.time;
                return this.number.compareTo(o.number);
            }
        }
    }
}
