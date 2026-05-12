package techniques.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);

            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0); // Extend row
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        int maximum = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            int left = triangle.get(i).get(i - 1);
            int right = triangle.get(i).get(i);
            if (left > right) {
                maximum += left;
            } else {
                maximum += right;
            }
            dp[i] = maximum;
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = generate(n);
        System.out.println(res);

        List<List<Integer>> l1 = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7));
        System.out.println(minimumTotal(l1));

    }
}
