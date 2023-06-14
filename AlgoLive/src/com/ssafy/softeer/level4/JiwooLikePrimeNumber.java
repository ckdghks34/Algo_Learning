package com.ssafy.softeer.level4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class JiwooLikePrimeNumber {
    static final int inf = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 체육관 개수
        int N = Integer.parseInt(st.nextToken());
        // 길 개수
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= N; ++i)
            list.add(new ArrayList<>());

        // 길 입력
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int minLevel = Integer.parseInt(st.nextToken());

            list.get(start).add(new int[]{destination, minLevel});
            list.get(destination).add(new int[]{start, minLevel});
        }

        int result = findMinLevel(list)+1;

        while (!isPrimeNumber(result))
            result++;

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findMinLevel(List<List<int[]>> list) {
        int start = 1;
        int[] minLevelForMove = new int[list.size() + 1];
        boolean[] visited = new boolean[list.size() + 1];

        Arrays.fill(minLevelForMove, inf);
        minLevelForMove[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.minLevel - b.minLevel;
            }
        });

        queue.offer(new Node(start, minLevelForMove[start]));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 이미 방문했던 노드라면  다시 볼 필요 없음.
            if (visited[cur.idx])
                continue;

            // 방문처리
            visited[cur.idx] = true;

            // 현재 Node의 위치가 마지막 체육관이라면 값 반환
            if (cur.idx == list.size()-1)
                return minLevelForMove[cur.idx];

            // 연결된 체육관들을 확인한다.
            for (int i = 0; i < list.get(cur.idx).size(); ++i) {
                int[] next = list.get(cur.idx).get(i);

                // 방문하지 않고
                // 현재 체육관의 레벨과 연결된 다음 체육관의 레벨 중 높은 것 중 큰 값과
                // 연결된 다음 체육관까지으 최소 레벨을 비교하여 작으면 최소레벨을 수정한다.
                if (!visited[next[0]] && minLevelForMove[next[0]] > Math.max(minLevelForMove[cur.idx], list.get(cur.idx).get(i)[1])) {
                    minLevelForMove[next[0]] = Math.max(minLevelForMove[cur.idx], next[1]);
                    queue.offer(new Node(next[0], minLevelForMove[next[0]]));
                }
            }
        }

        return minLevelForMove[list.size()-1];
    }

    // 에라토스테네스의 체
    public static boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static class Node {
        int idx;
        int minLevel;

        Node(int idx, int minLevel) {
            this.idx = idx;
            this.minLevel = minLevel;
        }
    }
}
