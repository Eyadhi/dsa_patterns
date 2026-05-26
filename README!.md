# Complete LeetCode DSA Patterns Cheatsheet

**Table of Contents**

1.	Two Pointers
2.	Sliding Window
3.	Fast & Slow Pointers
4.	Merge Intervals
5.	Cyclic Sort
6.	In-place Reversal of LinkedList
7.	Breadth First Search
8.	Depth First Search
9.	Two Heaps
10.	Subsets
11.	Modified Binary Search
12.	Bitwise XOR
13.	Top K Elements
14.	K-way Merge
15.	0/1 Knapsack
16.	Unbounded Knapsack
17.	Fibonacci Numbers
18.	Palindromic Subsequence
19.	Longest Common Substring
20.	Topological Sort
21.	Trie
22.	Union Find
23.	Monotonic Stack
24.	Backtracking

## Two Pointers
**File:** `twopointers/Problems.java`

**When to use:** Problems involving sorted arrays, pairs, triplets, or subarrays.

**Time Complexity:** O(n) or O(n²) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Target sum problems
- Removing duplicates
- Comparing elements from both ends
- Palindrome verification

---

## Sliding Window
**File:** `slidingwindow/SlidingWindow.java`

**When to use:** Problems involving contiguous subarrays/substrings with specific conditions.

**Time Complexity:** O(n)

**Space Complexity:** O(1) to O(k)

**Pattern Recognition:**
- Maximum/minimum subarray of size K
- Substrings with K distinct characters
- String permutation problems
- Longest substring with condition

---

## Fast & Slow Pointers
**File:** `fastslowpointers/Problems.java`

**When to use:** Linked list cycle detection, finding middle element, palindrome checking.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Cycle detection in linked lists
- Finding middle of linked list
- Palindrome linked list
- Happy number problem

---

## Merge Intervals
**File:** `mergeintervals/MergeIntervals.java`

Sort intervals by start time, then merge overlapping ones by comparing end times.

**When to use:** Problems involving overlapping intervals, scheduling, range merging.

**Time Complexity:** O(n log n) 

**Space Complexity:** O(n)

**Pattern Recognition:**
- Overlapping intervals
- Meeting room problems
- Insert intervals
- Interval intersection

---

## Cyclic Sort
**File:** `cyclicsort/Problems.java`

**When to use:** Problems with arrays containing numbers in a given range, missing numbers.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Array contains numbers from 1 to n
- Finding missing/duplicate numbers
- First missing positive

---

## In-place Reversal of LinkedList
**File:** `reverseinlinkedlist/Problems.java`

**When to use:** Reversing linked lists or parts of linked lists without extra space.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Reverse entire linked list
- Reverse sublist
- Reverse in groups

---

## Subsets
**File:** `subsets/Subsets.java`

**When to use:** Generating all combinations, permutations, or subsets.

**Time Complexity:** O(2^n) for subsets, O(n!) for permutations 

**Space Complexity:** O(n) for recursion depth

**Pattern Recognition:**
- Generate all subsets/combinations
- Generate all permutations
- Parentheses generation
- Letter combinations

---

## Modified Binary Search
**File:** `modifiedbinarysearch/Problems.java`

**When to use:** Searching in rotated/modified sorted arrays, finding peak elements.

**Time Complexity:** O(log n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Search in rotated sorted array
- Find peak element
- Search in infinite array
- Find minimum in rotated sorted array

---

## Bitwise XOR

**When to use:** Finding single numbers, missing numbers in arrays.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Key Properties:**
a ⊕ a = 0
a ⊕ 0 = a
XOR is commutative and associative

**Pattern Recognition:**
- Single number problems
- Missing number in array
- Two single numbers

---

## Top K Elements
**File:** `topkelements/pq/Problems.java`

**When to use:** Finding K largest/smallest elements, K closest elements.

**Time Complexity:** O(n log k) with heap, O(n) with quickselect 

**Space Complexity:** O(k)

**Pattern Recognition:**
- K largest/smallest elements
- K most frequent elements
- K closest points

---