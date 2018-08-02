package basic.binary_search_tree;

import java.util.Stack;

/**
 * Created by zhouxuan on 2017/5/3.
 */
public class TreeWorkIteration {
    public static void inorder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.value);
        }
    }
}
