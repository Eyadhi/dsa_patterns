package techniques.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class Problems {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] < n && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i += 1;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int current = nums[i] - 1;
            if (nums[i] != nums[current]) {
                swap(nums, i, current);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int current = nums[i] - 1;
            if (nums[i] != nums[current]) {
                swap(nums, i, current);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int current = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[current]) {
                swap(nums, i, current);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {

    }
}
