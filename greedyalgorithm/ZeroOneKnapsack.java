package techniques.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ZeroOneKnapsack {
	static int getMaxValue(Item[] items, int capacity) {
		Arrays.sort(items, Comparator.comparingInt((Item item) -> item.weight).reversed());
		int totalValue = 0;
		int currentWeight = 0;

		for (Item item : items) {
			if (currentWeight + item.weight <= capacity) {
				// Take the whole item
				currentWeight += item.weight;
				totalValue += item.value;
			}
		}
		return totalValue;
	}

	public static void main(String[] args) {
		Item[] item = {
				new Item(10, 60),
				new Item(20, 100),
				new Item(30, 120),
		};
		int maxvalue = getMaxValue(item, 50);
		System.out.println(maxvalue);
	}
}
