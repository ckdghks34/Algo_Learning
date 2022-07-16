package com.ssafy.Baekjoon._220717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> node = new HashMap<>();
    boolean end;
}

class Trie {
    Node root = new Node();

    void insert(String str) {
        Node node = this.root;

        int strLen = str.length();
        for (int i = 0; i < strLen; ++i) {
            node = node.node.computeIfAbsent(str.charAt(i), key -> new Node());
        }
        node.end = true;
    }

    boolean search(String str) {
        Node node = this.root;

        for (int i = 0; i < str.length(); ++i) {
            node = node.node.getOrDefault(str.charAt(i), null);

            // node가 없는 경우
            if (node == null)
                return false;

            if (node.end)
                return true;
        }
        return true;
    }
}

public class Main_G4_5052_전화번호목록_TREE {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
            Trie trie = new Trie();
            boolean valid = true;
            int n = Integer.parseInt(br.readLine());

            trie.insert(br.readLine());

            for (int j = 1; j < n; ++j) {
                String str = br.readLine();

                if (!trie.search(str))
                    trie.insert(str);
                else {
                    sb.append("NO").append("\n");
                    valid = false;
                    break;
                }
            }
            if (valid)
                sb.append("YES").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
