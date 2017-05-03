package interview.algorithm.easy.accepted;

import interview.algorithm.easy.questions.IslandPerimeter;

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
}
