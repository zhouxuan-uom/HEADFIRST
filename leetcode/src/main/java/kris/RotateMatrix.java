package kris;

/**
 * Created by zhouxuan on 16/7/6.
 */
public class RotateMatrix {
    public static void solution(int num) {
        double sizeD = Math.pow(num, 0.5);
        if (sizeD != (int) sizeD) {
            sizeD++;
        }
        int size = (int) sizeD;
        int[][] matrix = new int[size][size];
        int pointX = 0;
        int pointY = 0;
        Direction direction = Direction.RIGHT;
        for (int i = 0; i < num; i++) {
            switch (direction) {
                case RIGHT:
                    if (matrix[pointX + 1][pointY] == 0) {
                        matrix[pointX + 1][pointY] = i;
                    } else {
                        matrix[pointX][pointY + 1] = i;
                        direction = Direction.DOWN;
                    }
                    break;
                case LEFT:
                    if (matrix[pointX + 1][pointY] == 0) {
                        matrix[pointX + 1][pointY] = i;
                    } else {
                        matrix[pointX][pointY + 1] = i;
                        direction = Direction.DOWN;
                    }
                    break;
                case UP:
                    if (matrix[pointX + 1][pointY] == 0) {
                        matrix[pointX + 1][pointY] = i;
                    } else {
                        matrix[pointX][pointY + 1] = i;
                        direction = Direction.DOWN;
                    }
                    break;
                case DOWN:
                    if (matrix[pointX + 1][pointY] == 0) {
                        matrix[pointX + 1][pointY] = i;
                    } else {
                        matrix[pointX][pointY + 1] = i;
                        direction = Direction.DOWN;
                    }
                    break;
            }
        }
    }

    private enum Direction {
        LEFT, RIGHT, UP, DOWN;
    }
}
