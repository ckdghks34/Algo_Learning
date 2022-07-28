package com.ssafy.Baekjoon._220726;

import java.io.*;

//0
//01
//0110
//0110 1001
//0110 1001 1001 0110
//1001 0110 0110 1001
//
//0) 0                                                                                    1
//1) 01                                                                                   2
//2) 0110                                                                                 4
//3) 0110 1001                                                                            8
//4) 0110 1001 1001 0110                                                                  16
//5) 0110 1001 1001 0110 1001 0110 0110 1001                                              32
//6) 0110 1001 1001 0110 1001 0110 0110 1001 1001 0110 0110 1001 1001 0110 0110 1001      64
//   0110 1001 1001 0110 1001 0110 0110 1001 1001 0110 0110 1001 1001 0110 0110 1001
//   0110 0110 0110 0110 0110 0110 0110 0110
public class Main_S2_18222_투에모스문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        long b = Long.parseLong(br.readLine());
//        int a = (int) (Math.log(b) / Math.log(2)); // 반복횟수
//        // 1 < a == 0 한번도 돌지않는다. 그럼 0?
//        String str = "01";
//
//        if(b == 1)
//            bw.write("0");
//        else if(b==2)
//            bw.write("1");
//        else {
//            String X = thueMorse(str,0, a-2);
//            long Xlen = X.length();
//            System.out.println(Xlen);
//            long bbb = b - Xlen;
//            bw.write(X.charAt((int)(Xlen - bbb) - 1));
//        }
//
//        bw.flush();
        long[] map = new long[64];
        map[0] = 1;

        long K = Long.parseLong(br.readLine());

        for (int i = 1; i < 64; ++i)
            map[i] = map[i - 1] * 2;

        bw.write(Integer.toString(thueMorse(map, K)));
        bw.flush();
    }

    private static int thueMorse(long[] map, long k) {
        if (k == 1) return 0;

        for (int i = 0; i < 64; ++i) {
            if (k <= map[i])
                return 1 - thueMorse(map, k - map[i - 1]);
        }
        return 0;
    }

//    public static String thueMorse(String str, int depth, int max) {
//        if(depth > max)
//            return str;
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//
//        for(int i =0 ; i < str.length();++i) {
//            char cur = str.charAt(i) == '0' ? '1' : '0';
//            sb.append(cur);
//        }
//        return thueMorse(sb.toString(),depth+1,max);
//    }
}

