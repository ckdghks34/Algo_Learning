package com.ssafy.codingTest.TOSS;

import java.util.Arrays;

public class solution4 {
  public static void main(String[] args) {
    // String s = "2021:04:12:16:08:35";
    // String[] times = { "01:06:30:00", "01:04:12:00" };
    String s = "2021:04:12:16:08:35";
    String[] times = { "01:06:30:00", "01:01:12:00", "00:00:09:25" };
    System.out.println(Arrays.toString(solution(s, times)));
  }

  public static int[] solution(String s, String[] times) {
    int[] answer = {};
    String[] sStr = s.split(":");
    Date cur = new Date(Integer.parseInt(sStr[0]), Integer.parseInt(sStr[1]), Integer.parseInt(sStr[2]),
        Integer.parseInt(sStr[3]), Integer.parseInt(sStr[4]), Integer.parseInt(sStr[5]));

    boolean flag = true;
    int countdays = 1;
    for (int i = 0; i < times.length; ++i) {
      String[] str = times[i].split(":");
      int day = Integer.parseInt(str[0]);
      int hour = Integer.parseInt(str[1]);
      int min = Integer.parseInt(str[2]);
      int sec = Integer.parseInt(str[3]);

      Date tmp = new Date(cur);

      if (tmp.sec + sec >= 60) {
        tmp.min += 1;
        tmp.sec = tmp.sec + sec - 60;
      } else
        tmp.sec += sec;

      if (tmp.min + min >= 60) {
        tmp.hour += 1;
        tmp.min = tmp.min + min - 60;
      } else
        tmp.min += min;

      if (tmp.hour + hour >= 24) {
        tmp.day += 1;
        tmp.hour = tmp.hour + hour - 24;
      } else
        tmp.hour += hour;

      if (tmp.day + day > 30) {
        countdays += 1;
        tmp.day = tmp.day + day - 30;
      } else
        tmp.day += day;

      if (cur.day + 1 <= 30) {
        Date nextday = new Date(cur.year, cur.mon, cur.day + 1, 23, 59, 59);

        if (nextday.compareTo(tmp) < 0) {
          flag = false;
        }
      } else {
        Date nextday = new Date(cur.year, cur.mon + 1, 1, 23, 59, 59);

        if (nextday.compareTo(tmp) < 0) {
          flag = false;
        }
      }
      countdays += tmp.day - cur.day;
      cur = tmp;
    }

    answer = new int[2];
    answer[0] = flag ? 1 : 0;
    answer[1] = countdays;
    return answer;
  }
}

class Date implements Comparable<Date> {
  int year;
  int mon;
  int day;
  int hour;
  int min;
  int sec;

  public Date(int year, int mon, int day, int hour, int min, int sec) {
    this.year = year;
    this.mon = mon;
    this.day = day;
    this.hour = hour;
    this.min = min;
    this.sec = sec;
  }

  public Date(Date date) {
    this.year = date.year;
    this.mon = date.mon;
    this.day = date.day;
    this.hour = date.hour;
    this.min = date.min;
    this.sec = date.sec;
  }

  @Override
  public int compareTo(Date o) {
    if (year == o.year) {
      if (mon == o.mon) {
        if (day == o.day) {
          if (hour == o.hour) {
            if (min == o.min) {
              if (sec == o.sec) {
                return 0;
              }
              return sec - o.sec;
            }
            return min - o.min;
          }
          return hour - o.hour;
        }
        return day - o.day;
      }
      return mon - o.mon;
    }
    return year - o.year;
  }
}