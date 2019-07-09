package interview.algorithm.medium.questions;

import interview.algorithm.struct.TreeNode;

/**
 * Created by zhouxuan on 2018/8/20
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 *
 * @Author: zhouxuan
 * @Date: 2018/8/20
 */

public interface CountCompleteTreeNodes {
    int countNodes(TreeNode root);
}
