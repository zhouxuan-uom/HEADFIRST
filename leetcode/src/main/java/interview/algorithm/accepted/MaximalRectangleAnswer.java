package interview.algorithm.accepted;

import interview.algorithm.questions.MaximalRectangle;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 6.
 * <p>
 * 思想:
 * 读取每一行,并算出当前行的"高度",并计算最大面积
 * 都读完之后,返回最大面积
 * Created by zhouxuan on 2016/11/28.
 */
public class MaximalRectangleAnswer implements MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] currentLine = new int[matrix[0].length];
        for (int i = 0; i < currentLine.length; i++) {
            currentLine[i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            this.fillLine(matrix, currentLine, i);
            int currentMax = this.calcMax(currentLine);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    private void fillLine(char[][] matrix, int[] currentLine, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '0') {
                currentLine[i] = 0;
            } else {
                currentLine[i]++;
            }
        }
    }

    private int calcMax(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("1234".substring(3,3));
    }
}
