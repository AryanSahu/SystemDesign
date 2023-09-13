package com.study.coding.ds;

public class Greedy {


    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // Initialize the maximum sum to the first element
        int currentSum = nums[0];  // Initialize the current sum to the first element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum between the current element and the current sum plus the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public boolean canJump(int[] nums) {
        int maxReach = 0;  // Initialize the maximum reach as 0

        for (int i = 0; i < nums.length; i++) {
            // If we can't reach this index, return false
            if (i > maxReach) {
                return false;
            }

            // Update the maximum reach from this position
            maxReach = Math.max(maxReach, i + nums[i]);

            // If we can reach the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;  // If we can't reach the last index after the loop, return false
    }
}
