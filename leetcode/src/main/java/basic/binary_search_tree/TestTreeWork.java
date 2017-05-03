package basic.binary_search_tree;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhouxuan on 2017/5/3.
 */
public class TestTreeWork {
    Node treeRoot;

    @Before
    public void buildTree() {
        treeRoot = new Node(5, new Node(3, new Node(2, null, null), new Node(5, null, null)), new Node(7, null, new Node(8, null, null)));
    }

    @Test
    public void inorder() {
        TreeWork.inorder(treeRoot);
    }

    @Test
    public void preorder() {
        TreeWork.preorder(treeRoot);
    }

    @Test
    public void postorder() {
        TreeWork.postorder(treeRoot);
    }
}
