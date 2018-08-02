package interview.algorithm.easy.accepted;

import interview.algorithm.easy.questions.IslandPerimeter;

import java.util.*;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * <p>
 * Example:
 * <p>
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * https://leetcode.com/static/images/problemset/island.png
 * Created by zhouxuan on 2016/12/8.
 */
public class IslandPerimeterAns implements IslandPerimeter {
    @Override
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                perimeter += grid[x][y] == 1 ? perimeter(grid, x, y) : 0;
            }
        }
        return perimeter;
    }

    private int perimeter(int[][] grid, int x, int y) {
        int result = 0;
        result += (x == 0 || grid[x - 1][y] == 0) ? 1 : 0;
        result += (y == 0 || grid[x][y - 1] == 0) ? 1 : 0;
        result += (x == grid.length - 1 || grid[x + 1][y] == 0) ? 1 : 0;
        result += (y == grid[0].length - 1 || grid[x][y + 1] == 0) ? 1 : 0;
        return result;
    }

    public static void main(String[] args) {
        int[] ints={12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,36,16,65,95,64,59,53,93};
        Arrays.sort(ints);
        for (int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
        Map map;
        List list;

    }
}
class PrintA implements Runnable {
    private Object objectA = null;
    private Object objectB = null;

    PrintA(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }
    @Override
    public void run() {
        System.out.println("PrintA start......");
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printA print " + i);
        }

        try {
            // A线程打印完了1、2、3后通知线程开始打印并且自身开始等待
            synchronized(objectA) {
                synchronized(objectB) {
                    objectB.notify();
                }
                objectA.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PrintA reStart......");
        for (int i = 7; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printA print " + i);
        }
    }

}

class PrintB implements Runnable {
    private Object objectA = null;
    private Object objectB = null;

    PrintB(Object printACon, Object printBCon) {
        objectA = printACon;
        objectB = printBCon;
    }

    @Override
    public void run() {
        try {
            // 刚开始B线程等待A线程打印完1、2、3
            synchronized(objectB) {
                objectB.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PrintB start......");
        for (int i = 4; i < 7; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("printB print " + i);
        }

        // B线程打印完了4、5、6后就通知A线程继续打印
        synchronized(objectA) {
            objectA.notify();
        }
    }
}