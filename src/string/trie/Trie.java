package string.trie;

import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

public class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node());  // 현재 노드의 자식 중에 c가 없으면 자식으로 c를 생성
            cur = cur.child.get(c);  // 현재 노드 포인터를 자식으로 이동

            if (i == str.length() - 1) {  // 마지막 글자까지 모두 처리한 경우
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {  // 현재 글자 c를 마지막으로 하는 단어가 있는 경우
                    return false;
                }
            }
        }
        return true;
    }
}
