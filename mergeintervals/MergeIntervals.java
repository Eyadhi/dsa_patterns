package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(interval[1], current[1]);
            } else {
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Integer.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Integer.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static boolean meetingRooms(int[][] input) {
        if (input.length == 0)
            return true;

        Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < input.length; i++) {
            if (input[i][0] < input[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static int minimumMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                result.add(new int[] { start, end });
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    // Helper to print 2D array
    static String print(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] a : arr)
            sb.append(Arrays.toString(a)).append(", ");
        if (arr.length > 0)
            sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // ─── merge ────────────────────────────────────────────────────────────────
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println("merge [[1,3],[2,6],[8,10],[15,18]]:");
        System.out.println("  " + print(merge(intervals1)));
        // Expected: [[1,6],[8,10],[15,18]]

        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        System.out.println("merge [[1,4],[4,5]]:");
        System.out.println("  " + print(merge(intervals2)));
        // Expected: [[1,5]]

        // ─── insert ───────────────────────────────────────────────────────────────
        int[][] existing = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        System.out.println("insert [2,5] into [[1,3],[6,9]]:");
        System.out.println("  " + print(insert(existing, newInterval)));
        // Expected: [[1,5],[6,9]]

        int[][] existing2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = { 4, 8 };
        System.out.println("insert [4,8] into [[1,2],[3,5],[6,7],[8,10],[12,16]]:");
        System.out.println("  " + print(insert(existing2, newInterval2)));
        // Expected: [[1,2],[3,10],[12,16]]

        // ─── meetingRooms ─────────────────────────────────────────────────────────
        int[][] meetings1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("meetingRooms [[0,30],[5,10],[15,20]]: "
                + meetingRooms(meetings1)); // false (overlap)

        int[][] meetings2 = { { 7, 10 }, { 2, 4 } };
        System.out.println("meetingRooms [[7,10],[2,4]]:          "
                + meetingRooms(meetings2)); // true (no overlap)

        // ─── minimumMeetingRooms ──────────────────────────────────────────────────
        int[][] rooms1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("minimumMeetingRooms [[0,30],[5,10],[15,20]]: "
                + minimumMeetingRooms(rooms1)); // 2

        int[][] rooms2 = { { 2, 7 }, { 3, 19 }, { 8, 12 }, { 10, 20 }, { 11, 30 } };
        System.out.println("minimumMeetingRooms [[2,7],[3,19],[8,12],[10,20],[11,30]]: "
                + minimumMeetingRooms(rooms2)); // 4

        // ─── intervalIntersection ─────────────────────────────────────────────────
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        System.out.println("intervalIntersection:");
        System.out.println("  " + print(intervalIntersection(firstList, secondList)));
        // Expected: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    }
}
