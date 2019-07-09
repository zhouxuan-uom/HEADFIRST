package interview.algorithm.medium.answers;

import interview.algorithm.medium.questions.CountCompleteTreeNodes;
import interview.algorithm.struct.TreeNode;

/**
 * Created by zhouxuan on 2018/8/20
 *
 * @Author: zhouxuan
 * @Date: 2018/8/20
 */

public class CountCompleteTreeNodesAns implements CountCompleteTreeNodes {
    int start = 0;
    int end = 0;
    int level = 0;
    boolean finish = false;

    @Override
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        level = this.getLevel(root);
        end = (int) Math.pow(2, level - 1);
        this.recur(root);
        return 9;
    }

    private void recur(TreeNode root) {
        if (finish) {
            return;
        }
        int count = 1;
        TreeNode node = root.left;
        while (count != level) {
            count++;
            if (node.right == null) {
                end = start + (end - start) / 2;
                if (node.left != null) {
                    finish = true;
                    return;
                }
                recur(root.left);
            }
            node = node.right;
        }
        start = start + (end - start) / 2;
        recur(root.right);
    }

    private int getLevel(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "PPALLP";
        System.out.println(s.indexOf("LLL") == -1);
        System.out.println((s.indexOf("A") != -1 && s.indexOf("A") != s.lastIndexOf("A")));
    }

}
