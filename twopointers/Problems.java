package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {
    public int ContainerWithMostWater(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = (right - left) * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int[] RemoveDuplicatesInSortedArray(int[] arr) {
        if (arr.length == 0)
            return arr;

        int slow = 0;
        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                arr[++slow] = arr[fast];
            }
        }
        return arr;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 };
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l1 = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n < 3)
            return l1;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    l1.add(List.of(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return l1;
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int closestTarget = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closestTarget)) {
                    closestTarget = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestTarget;
    }

    public static void main(String[] args) {
        int[] nums2 = { 1, 1, 2 };
        int[] result2 = RemoveDuplicatesInSortedArray(nums2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
    }
}
