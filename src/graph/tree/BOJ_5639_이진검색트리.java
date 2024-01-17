package graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제 분석]
 * 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_5639_이진검색트리 {

    static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 루트 노드 설정
        Node root = new Node(Integer.parseInt(br.readLine()));

        // 트리 구성
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    // 후위순회: 왼쪽자식-오른쪽자식-부모
    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }

}