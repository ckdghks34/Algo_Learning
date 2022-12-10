package com.ssafy.exSoftAcademy._221210;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_d2_14510_나무높이 {
    static int max = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\Hwan\\IdeaProjects\\Algo_Learning\\AlgoLive\\src\\com\\ssafy\\exSoftAcademy\\_221210\\14510_Sample_Input.txt"));
//        System.setIn(new FileInputStream(System.getProperty("user.dir") +"");
//        System.out.println(System.getProperty("user.dir"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append(" ");
            // 가장 큰 나무 높이 초기화
            max = 0;
            // 날짜
            int countDate = 0;

            // 나무 갯수
            int N = Integer.parseInt(br.readLine());


            ArrayList<Integer> treeList = new ArrayList<>();
            // 입력
            st = new StringTokenizer(br.readLine());

            // 나무 높이 list 저장
            for (int i = 0; i < N; ++i) {
                int treeHeight = Integer.parseInt(st.nextToken());
                treeList.add(treeHeight);

                // 가장 큰 나무 높이 구하기
                max = Math.max(max, treeHeight);
            }

            while (!checkValid(treeList)) {
                countDate++;
                treeList.sort(Collections.reverseOrder());
                growTree(treeList, countDate);
            }
            sb.append(countDate).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 성장해야할 나무가 있는지 없는지 확인 함수
    // 반환값 True : 모두 같은 크기로 성장
    // 반환값 false : 하나라도 덜 성장
    private static boolean checkValid(ArrayList<Integer> treeList) {
        for (int i = 0; i < treeList.size(); ++i) {
            // 한 그루라도 최대 크기보다 작으면 false
            if (treeList.get(i) != max)
                return false;
        }

        return true;
    }

    private static void growTree(ArrayList<Integer> treeList, int countDate) {

        for (int i = 0; i < treeList.size(); ++i) {
            // 이미 최대로 성장한 나무가 아니라면
            if (treeList.get(i) != max) {
                // 홀수 날
                if (countDate % 2 == 1) {
                    // 마지막 나무가 아니면
                    if (treeList.size() - i > 1) {
                        // 점수 추가
                        treeList.set(i, treeList.get(i) + 1);
                    } else {    // 마지막 나무 라면
                        // 정확히 2점이 모자랄 경우 건너뛰고 다음날(짝수)일 때 키우면 된다.
                        if (max - treeList.get(i) == 2)
                            break;

                        // 그게 아니라면 점수 추가
                        treeList.set(i, treeList.get(i) + 1);
                    }
                } else {    // 짝수 날
                    // 마지막 나무가 아니라면
                    if (treeList.size() - i > 1) {
                        // 최대 높이 까지 2보다 더 남아 있으면
                        if (max - treeList.get(i) >= 2)
                            treeList.set(i, treeList.get(i) + 2);
                        else {
                            // 현재 나무가 높이가 최대보다 1 작을 때, 현재 나무에 물을 줄 수 없음.
                            // 다른 나무 중에 남은 높이가 2이상 인 나무 찾기
                            for (int j = i + 1; j < treeList.size(); ++j) {
                                // 최대 까지 남은 높이가 2 이상이면
                                if (max - treeList.get(j) >= 2) {
                                    // 높이 2 추가
                                    treeList.set(j, treeList.get(j) + 2);
                                    break;
                                }
                            }
                        }
                    } else {    // 마지막 나무라면
                        if (max - treeList.get(i) >= 2) // 남은 높이가 2점 이상일 경우
                            treeList.set(i, treeList.get(i) + 2);
                    }
                }
                break;
            }
        }
    }
}
