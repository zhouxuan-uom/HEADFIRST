package interview.algorithm.easy.answers;

import interview.algorithm.easy.questions.PerfectRectangle;

import java.util.HashSet;
import java.util.Set;

/**
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 * Example 1:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 * Example 2:
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * Return false. Because there is a gap between the two rectangular regions.
 * Example 3:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * Return false. Because there is a gap in the top center.
 * Example 4:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * Return false. Because two of the rectangles overlap with each other.
 * Created by zhouxuan on 2017/4/30.
 */
public class PerfectRectangleAns implements PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Point> intSet = new HashSet<Point>();
        for (int[] line : rectangles) {
            Point pointA = new Point(line[0], line[1]);
            Point pointB = new Point(line[2], line[3]);
            Point pointC = new Point(line[0], line[3]);
            Point pointD = new Point(line[2], line[1]);
            if (intSet.contains(pointA)) {
                intSet.remove(pointA);
            } else {
                intSet.add(pointA);
            }
            if (intSet.contains(pointB)) {
                intSet.remove(pointB);
            } else {
                intSet.add(pointB);
            }
            if (intSet.contains(pointC)) {
                intSet.remove(pointC);
            } else {
                intSet.add(pointC);
            }
            if (intSet.contains(pointD)) {
                intSet.remove(pointD);
            } else {
                intSet.add(pointD);
            }
        }
        return intSet.size() == 4;
    }

    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        PerfectRectangle perfectRectangle = new PerfectRectangleAns();
        int[][] ins = {{1, 1, 2, 2}, {1, 1, 2, 2}, {2, 1, 3, 2}};
        System.out.println(perfectRectangle.isRectangleCover(ins));
    }
}
