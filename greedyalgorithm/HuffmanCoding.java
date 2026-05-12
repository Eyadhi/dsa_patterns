package greedyalgorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode {
    int frequency;
    char data;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }
}

class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.frequency - node2.frequency;
    }
}

class HuffmanCoding {
    private static void buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(new HuffmanComparator());

        // Create a leaf node for each character and add it to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.offer(node);
        }

        // Build the Huffman tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            // Create a new internal node with the combined frequency and add it to the
            // priority queue
            int combinedFrequency = left.frequency + right.frequency;
            HuffmanNode newNode = new HuffmanNode('\0', combinedFrequency);
            newNode.left = left;
            newNode.right = right;

            priorityQueue.offer(newNode);
        }

        HuffmanNode root = priorityQueue.poll();
        encode(root, "");
    }

    private static void encode(HuffmanNode root, String code) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.data + " : " + code);
            return;
        }

        // Recursively encode the left and right subtrees
        encode(root.left, code + "0");
        encode(root.right, code + "1");
    }

    public static void main(String[] args) {
        String input = "Huffman coding";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Calculate the frequency of each character in the input string
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        buildHuffmanTree(frequencyMap);
    }
}
