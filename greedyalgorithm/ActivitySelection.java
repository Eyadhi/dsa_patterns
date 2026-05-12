package techniques.greedyalgorithm;

import java.util.*;

class Activity {
	int start, finish;

	public Activity(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}
}

public class ActivitySelection {
	static void printMaxActivities(Activity arr[], int n) {
		// Sort jobs according to finish time
		System.out.println("Following activities are selected :");
		// The first activity always gets selected
		int i = 0;
		System.out.print("(" + arr[i].start + ", " + arr[i].finish + ")");
		// Consider rest of the activities
		for (int j = 1; j < n; j++) {
			// If this activity has start time greater than or equal to the finish time of
			// previously selected activity, then select it
			if (arr[j].start >= arr[i].finish) {
				System.out.print(", (" + arr[j].start + ", " + arr[j].finish + ")");
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[] start = { 5, 1, 3, 0, 5, 8 };
		int[] finish = { 9, 2, 4, 6, 7, 9 };
		Activity arr[] = new Activity[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Activity(start[i], finish[i]);
		}
		Arrays.sort(arr, Comparator.comparingInt(a -> a.finish));
		// Function call
		printMaxActivities(arr, n);
	}
}
