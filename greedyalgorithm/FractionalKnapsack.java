package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int weight, value;

	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
}

class FractionalKnapsack {
	static double getMaxValue(Item[] items, int capacity) {
		// Sort items based on value-to-weight ratio in descending order
		Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());

		double totalValue = 0;
		int currentWeight = 0;

		for (Item item : items) {
			if (currentWeight + item.weight <= capacity) {
				// Take the whole item
				currentWeight += item.weight;
				totalValue += item.value;
			} else {
				// Take a fraction of the item to fill the remaining capacity
				int remainingCapacity = capacity - currentWeight;
				totalValue += (double) item.value / item.weight * remainingCapacity;
				break;
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {
		Item[] items = {
				new Item(10, 60),
				new Item(20, 100),
				new Item(30, 120)
		};
		int capacity = 50;
		double maxValue = getMaxValue(items, capacity);
		System.out.println("Maximum value that can be obtained = " + maxValue);
	}
}
