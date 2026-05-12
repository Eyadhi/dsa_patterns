package prefixsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrefixSum {
    public static int equilibriumPoint(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int prefixsum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < n; i++) {
            int suffixsum = sum - arr[i] - prefixsum;
            if (prefixsum == suffixsum) {
                return i;
            }
            prefixsum += arr[i];
        }
        return -1;
    }

    public static List<List<Integer>> splitArray(int[] arr) {
        int n = arr.length;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += arr[i];
        }

        int rightSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightSum += arr[i];
            leftSum -= arr[i];

            if (rightSum == leftSum) {
                List<Integer> leftPart = new ArrayList<>();
                List<Integer> rightPart = new ArrayList<>();

                for (int j = 0; j < i; j++) {
                    leftPart.add(arr[j]);
                }
                for (int j = i; j < n; j++) {
                    rightPart.add(arr[j]);
                }

                List<List<Integer>> result = new ArrayList<>();
                result.add(leftPart);
                result.add(rightPart);
                return result;
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1 };
        System.out.println(equilibriumPoint(arr));

        int[] arr1 = { 1, 2, 3, 4, 5, 5 };
        List<List<Integer>> res = splitArray(arr1);
        if (res.isEmpty()) {
            System.out.println("No equal split possible.");
        } else {
            System.out.println("Left: " + res.get(0));
            System.out.println("Right: " + res.get(1));
        }
    }
}
