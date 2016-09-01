package interview.algorithm;

import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * Created by zhouxuan on 16/8/24.
 */
public interface BinaryTreePostorderTraversal {
    List<Integer> postorderTraversal(TreeNode root);
}
