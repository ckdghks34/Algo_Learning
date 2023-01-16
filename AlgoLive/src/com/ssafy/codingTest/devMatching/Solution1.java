package com.ssafy.codingTest.devMatching;

import java.util.*;
public class Solution1 {
    public static void main(String[] args) {
        String[] record = {};
    }

    static class Solution {
        static int[] stageFinisher = new int[5];

        public String[] solution(String[] record) {
            String[] answer = {};

            ArrayList<Recording> members = new ArrayList<>();

            for(int i =0 ;i < record.length;++i)
            {
                String[] tmp = record[i].split(":");
                String[] recordString = tmp[1].split(",");
                int[] recordTime = new int[5];
                for(int j = 0; j < 5;++j){
                    recordTime[j] = Integer.parseInt(recordString[j]);
                    if(recordTime[j] != 0)
                        stageFinisher[j]++;
                }
                members.add(new Recording(tmp[0], recordTime));
            }
            for(int i=0;i < 5;++i)
                getMedal(members,i);
            Collections.sort(members);

            for(int i =0 ;i < members.size();++i)
            {
                answer = Arrays.copyOf(answer, answer.length+1);
                answer[i] = members.get(i).name;
                System.out.println(members.get(i));
            }
            return answer;
        }
        public void getMedal(ArrayList<Recording> members,int stage){
            Collections.sort(members, new Comparator<Recording>(){
                @Override
                public int compare(Recording r1, Recording r2){
                    return r1.record[stage] - r2.record[stage];
                }
            });
            System.out.println("--------------------------------");
            System.out.println("** STAGE" +stage+" **");
            int goldenLimit = (int) Math.ceil((double)stageFinisher[stage] / 12);
            int silverLimit = (int) Math.ceil((double)stageFinisher[stage] / 4);
            int bronzeLimit = (int) Math.ceil((double)stageFinisher[stage] / 2);

            int count = 0;
            for(int i = 0; i < members.size();++i)
            {
                if(members.get(i).record[stage] != 0)
                {

                    if(count < goldenLimit)
                        members.get(i).golden++;
                    else if(count < silverLimit)
                        members.get(i).silver++;
                    else if(count < bronzeLimit)
                        members.get(i).bronze++;
                    count++;
                    System.out.println(members.get(i));
                }
            }
        }
        class Recording implements Comparable<Recording>{
            String name;
            int[] record = new int[5];
            int total = 0;
            int finishStageCount = 0;
            int maxStage = 0;
            int golden = 0, silver = 0, bronze = 0;

            Recording(String name)
            {
                this.name = name;
            }

            Recording(String name, int[] record)
            {
                this.name = name;
                this.record = record;

                for(int i =0;i < 5;++i)
                {
                    if(this.record[i] != 0)
                    {
                        if(maxStage < i)
                            maxStage = i;
                        finishStageCount++;
                    }
                }
                calcurateTotal();
            }

            public void setrecording(int index, int value)
            {
                this.record[index] = value;
                calcurateTotal();
            }

            public void calcurateTotal()
            {
                int sum = 0;
                for(int i =0 ;i < 5;++i)
                    sum += this.record[i];
                this.total = sum;
            }
            public String toString(){
                StringBuilder sb =new StringBuilder();
                sb.append("name : ").append(this.name).append(" ")
                        .append("total : ").append(this.total).append(" ")
                        .append("golden : ").append(this.golden).append(" ")
                        .append("silver : ").append(this.silver).append(" ")
                        .append("bronze : ").append(this.bronze).append(" ")
                        .append("maxStage : ").append(this.maxStage).append(" ")
                        .append("finishStageCount : ").append(this.finishStageCount).append(" ");
                return sb.toString();
            }
            @Override
            public int compareTo(Recording r)
            {
                if(this.finishStageCount == r.finishStageCount)
                {
                    if(r.maxStage == this.maxStage)
                    {
                        if(r.golden == this.golden)
                        {
                            if(r.silver == this.silver)
                            {
                                if(r.bronze == this.bronze)
                                {
                                    if(r.total == this.total)
                                        return r.name.compareTo(this.name);

                                    return r.total - this.total;
                                }
                                return r.bronze - this.bronze;
                            }
                            return r.silver - this.silver;
                        }
                        return r.golden - this.golden ;
                    }
                    return r.maxStage - this.maxStage;
                }
                return r.finishStageCount - this.finishStageCount;
            }
        }
    }

}
