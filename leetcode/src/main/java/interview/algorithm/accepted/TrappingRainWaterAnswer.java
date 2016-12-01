package interview.algorithm.accepted;

import interview.algorithm.questions.TrappingRainWater;

/**
 * Created by zhouxuan on 16/8/19.
 */
public class TrappingRainWaterAnswer implements TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftValue = 0;
        int rightValue = 0;
        int total = 0;
        for (int i = 1; i < height.length && left <= right; i++) {
            if (height[i] >= height[left]) {
                total += leftValue;
                left = i;
                leftValue = 0;
            }
            if (height[height.length - 1 - i] > height[right]) {
                total += rightValue;
                right = height.length - 1 - i;
                rightValue = 0;
            }
            leftValue += height[left] - height[i];
            rightValue += height[right] - height[height.length - 1 - i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] value = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWaterAnswer();
        System.out.println(trappingRainWater.trap(value));
    }
}
