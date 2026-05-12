package subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(nums, 0, result);
        return result;
    }

    public static void permutation(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums)
                permutation.add(num);
            result.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permutation(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverseRemaining(nums, i + 1);
    }

    public static void reverseRemaining(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        permutationUnique(nums, list, used, result);
        return result;
    }

    public static void permutationUnique(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1] || (used[i]))
                continue;
            list.add(nums[i]);
            used[i] = true;
            permutationUnique(nums, list, used, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        List<List<Integer>> result = permute(nums);
        for (List<Integer> res : result) {
            System.out.println(res + " ");
        }

        nextPermutation(nums);
        System.out.print("next permutation:");
        for (int i : nums) {
            System.out.print(i + " ");
        }

        int[] nums1 = { 1, 1, 2 };
        List<List<Integer>> result1 = permuteUnique(nums1);
        for (List<Integer> res : result1) {
            System.out.println(res + " ");
        }
    }
}