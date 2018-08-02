package basic.binary_search_tree;

/**
 * Created by zhouxuan on 2017/5/3.
 */
public class TreeWorkRecursion {
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
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
