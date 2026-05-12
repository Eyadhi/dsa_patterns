package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrackUnique(0, nums, list, used, result);
        return result;
    }

    public static void backtrackUnique(int index, int[] nums, List<Integer> list, boolean[] used,
            List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1] || (used[i]))
                continue;
            list.add(nums[i]);
            used[i] = true;
            backtrackUnique(i + 1, nums, list, used, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));

        int[] nums1 = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums1));
    }
}
