package com.ssafy.Baekjoon._220728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tree {
    Node root;
    int size;

    Tree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(Node newNode) {
        if (this.size == 0) {
            this.root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (newNode.data <= cur.data) {
                    if (cur.left == null)
                        cur.left = newNode;
                    else
                        queue.add(cur.left);
                } else {
                    if (cur.right == null)
                        cur.right = newNode;
                    else
                        queue.add(cur.right);
                }
            }
        }
        this.size++;
    }

    public String PreOrder(Node node, StringBuilder builder) {
        if (node != null) {
            builder.append(node.data).append("\n");
            PreOrder(node.left, builder);
            PreOrder(node.right, builder);
        }
        return builder.toString();
    }

    public String PostOrder(Node node, StringBuilder builder) {
//        if (node != null) {
//            PostOrder(node.left, builder);
//            PostOrder(node.right, builder);
//            builder.append(node.data).append("\n");
//        }
        if(node.left != null)
            PostOrder(node.left,builder);
        if(node.right != null)
            PostOrder(node.right,builder);

        builder.append(node.data).append("\n");
        return builder.toString();
    }

    public String InOrder(Node node, StringBuilder builder) {
        if (node != null) {
            InOrder(node.left, builder);
            builder.append(node.data).append("\n");
            InOrder(node.right, builder);
        }
        return builder.toString();
    }

}

public class Main_G5_5639_이진검색트리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree tree = new Tree();

        while (true) {
            String input = br.readLine();

            // input.equals("") NullPointer 에러 발생
            if (input == null)
                break;

            int data = Integer.parseInt(input);

            tree.insert(new Node(data));
        }

        // 전위 순회
        // bw.write(tree.PreOrder(tree.root, new StringBuilder()));

        // 중위 순회
        // bw.write(tree.InOrder(tree.root, new StringBuilder()));

        // 후위 순회
        bw.write(tree.PostOrder(tree.root, new StringBuilder()));

        bw.flush();
        bw.close();
        br.close();
    }
}
