import java.io.*;
import java.util.*;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class Main {
    static TreeNode root;

    // 이진 트리에 노드를 삽입하는 메소드
    static void insert(int value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (true) {
            parent = current;
            if (value < current.value) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    static void postorder(TreeNode node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && input.length() != 0) {
            int value = Integer.parseInt(input);
            insert(value);
        }

        postorder(root);
    }
}
