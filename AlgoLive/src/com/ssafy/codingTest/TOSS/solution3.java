package com.ssafy.codingTest.TOSS;

import java.util.Stack;

public class solution3 {
  public static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  public static void main(String[] args) {
    // String[] ledgers = { "01/01 4 50000", "01/11 6 3555", "02/01 0 -23555",
    // "02/25 5 5000", "03/25 0 -15000",
    // "06/09 8 43951", "12/30 9 99999" };
    String[] ledgers = { "04/01 1 40000", "05/01 5 20000", "08/31 4 10000", "11/11 0 -45000" };
    System.out.println(solution(ledgers));
  }

  public static int solution(String[] ledgers) {
    int answer = 0;
    Stack<Product> stack = new Stack<>();

    for (int i = 0; i < ledgers.length; ++i) {
      String[] tmp = ledgers[i].split(" ");
      String[] date = tmp[0].split("/");
      int month = Integer.parseInt(date[0]);
      int day = Integer.parseInt(date[1]);
      int rate = Integer.parseInt(tmp[1]);
      int amount = Math.abs(Integer.parseInt(tmp[2]));

      for (int j = 1; j < month; ++j)
        day += days[j];

      // 입금
      if (rate != 0) {
        double rates = (double) rate / 100;
        rates = Math.round(rates * 100) / 100.0;
        Product p = new Product(day, rates, amount);
        stack.push(p);
      }
      // 출금
      else {
        // 출금액이 0이 될때 까지
        while (amount != 0) {
          Product lastProduct = stack.pop();

          if (lastProduct.tradeAmount > amount) {
            lastProduct.tradeAmount -= amount;
            answer += (amount * lastProduct.rate) * ((double) (day - lastProduct.day) / 365);
            amount = 0;
            stack.push(lastProduct);
          } else {
            answer += (lastProduct.tradeAmount * lastProduct.rate) * ((double) (day - lastProduct.day) / 365);
            amount -= lastProduct.tradeAmount;
          }
        }
      }
    }
    while (!stack.isEmpty()) {
      Product p = stack.pop();
      answer += (p.tradeAmount * p.rate) * ((double) (365 - p.day) / 365);
    }

    return answer;
  }
}

class Product {
  int day;
  double rate;
  int tradeAmount;
  int period;

  public Product(int day, double rate, int tradeAmount) {
    this.day = day;
    this.rate = rate;
    this.tradeAmount = tradeAmount;
  }
}
