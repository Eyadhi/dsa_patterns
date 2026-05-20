# Techniques

Problem-solving patterns and algorithmic techniques. Each folder contains implementations with real problems.

---

## Two Pointers
**File: ** `twopointers/Problems.java`

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

```
nums = [10, 5, 2, 6],  k = 100

right=0: product=10,  window=[10],      count += 1
right=1: product=50,  window=[10,5],    count += 2
right=2: product=100, shrink → [5,2],   count += 2
right=3: product=60,  window=[5,2,6],   count += 3
Total = 8
```

**Implemented:** `numSubarrayProductLessThanK` — count subarrays with product less than k.

| Type | Description |
|------|-------------|
| Fixed window | Window size is constant |
| Variable window | Window grows/shrinks based on condition |

---

## Fast & Slow Pointers

**When to use:** Linked list cycle detection, finding middle element, palindrome checking.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Cycle detection in linked lists
- Finding middle of linked list
- Palindrome linked list
- Happy number problem

## Prefix Sum
**File:** `prefixsum/PrefixSum.java`

Precomputes cumulative sums so any range sum can be answered in O(1).

```
arr = [1, 1, 1, 1]
prefix = [1, 2, 3, 4]

Sum from index i to j = prefix[j] - prefix[i-1]
```

**Implemented:**
- `equilibriumPoint(arr)` — find index where left sum equals right sum
- `splitArray(arr)` — split array into two parts with equal sum

**When to use:** Range sum queries, subarray sum problems, equilibrium index.

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

```
Input:  [[1,3],[2,6],[8,10],[15,18]]
Sort:   [[1,3],[2,6],[8,10],[15,18]]
Merge:  [2,6] overlaps [1,3] → [1,6]
Output: [[1,6],[8,10],[15,18]]
```

**Implemented:**
- `merge(intervals)` — merge all overlapping intervals
- `insert(intervals, newInterval)` — insert a new interval and merge if needed

---

## Cyclic Sort

**When to use:** Problems with arrays containing numbers in a given range, missing numbers.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Array contains numbers from 1 to n
- Finding missing/duplicate numbers
- First missing positive

---

## Binary Search (Problems)
**File:** `binarySearch/Problems.java`

Applying binary search beyond simple array lookup — on answer spaces and circular arrays.

**Implemented:**
- `nextGreatestLetter(letters, target)` — find the smallest letter greater than target in a sorted circular array

**When to use:** Any monotonic condition where you can eliminate half the search space. Think: "Can I binary search on the answer?"

---

## In-place Reversal of LinkedList
**When to use:** Reversing linked lists or parts of linked lists without extra space.

**Time Complexity:** O(n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Reverse entire linked list
- Reverse sublist
- Reverse in groups

---

## Subsets

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

**When to use:** Searching in rotated/modified sorted arrays, finding peak elements.

**Time Complexity:** O(log n) 

**Space Complexity:** O(1)

**Pattern Recognition:**
- Search in rotated sorted array
- Find peak element
- Search in infinite array
- Find minimum in rotated sorted array

---

## Top K Elements

**When to use:** Finding K largest/smallest elements, K closest elements.

**Time Complexity:** O(n log k) with heap, O(n) with quickselect 

**Space Complexity:** O(k)

**Pattern Recognition:**
- K largest/smallest elements
- K most frequent elements
- K closest points

---

## Bit Manipulation
**File:** `bitmanipulation/BitProblem.java`

Uses bitwise operators to solve problems in O(1) time and space.

| Problem | Trick | Code |
|---------|-------|------|
| Check even/odd | Last bit is 0 for even | `(n & 1) == 0` |
| Power of two | Only one bit set | `n > 0 && (n & (n-1)) == 0` |

**Common bit tricks:**

```
n & 1        → check if odd
n & (n-1)    → clear lowest set bit
n | (1 << i) → set bit at position i
n & (1 << i) → check bit at position i
n ^ n        → 0 (XOR with itself)
n ^ 0        → n (XOR with 0)
a ^ b ^ a    → b (find unique element)
```

**When to use:** Flags, subsets, finding unique elements, power of 2 checks, swapping without temp.

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

## Backtracking
**Files:** `backtracking/Ratmaze.java`, `backtracking/WordSearch.java`

Explore all possibilities recursively. Mark a choice as taken, recurse, then undo (backtrack) to try the next option.

```
Template:
  void backtrack(state) {
      if (goal reached) → add to result, return
      for each choice:
          make choice
          backtrack(new state)
          undo choice       ← this is the backtrack step
  }
```

### Rat in a Maze — `Ratmaze.java`
Find all paths from top-left to bottom-right in a binary maze (1 = open, 0 = blocked). Moves: D, U, R, L.

```
Maze:
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1

Paths: DDRDRR, DRDDRR
```

- Mark cell as visited (set to 0) before recursing
- Restore cell (set back to 1) after recursing

### Word Search — `WordSearch.java`
Find if a word exists in a 2D character grid by moving up/down/left/right.

```
Board:
a b c e
f a c g
a d e f

Word: "abccec" → true
```

- Mark visited cell with `'!'` to avoid reuse
- Restore original character after recursing

**When to use:** Permutations, subsets, combinations, maze/grid paths, constraint satisfaction (N-Queens, Sudoku).

---

## Dynamic Programming
**Files:** `dynamicprogramming/`

Break problem into overlapping subproblems. Store results to avoid recomputation (memoization or tabulation).

```
Key question: "Does this problem have overlapping subproblems and optimal substructure?"
```

### Fibonacci — `Fibonaci.java`
Classic DP intro. `fib[i] = fib[i-1] + fib[i-2]`

| Method | Approach |
|--------|----------|
| `fibonacci(n)` | Bottom-up tabulation |
| `fibonacci1(n)` | Returns full array |
| `SpecFibo(n)` | Recursive (exponential — for comparison) |

---

### Climbing Stairs — `ClimbingStairs.java`
Count ways to reach step n taking 1 or 2 steps at a time. Same recurrence as Fibonacci.

```
n=3: [1+1+1, 1+2, 2+1] = 3 ways
dp[i] = dp[i-1] + dp[i-2]
```

---

### House Robbery — `HouseRobbery.java`
Max sum from non-adjacent elements. Can't rob two consecutive houses.

```
nums = [2, 3, 1, 3, 4]
dp[i] = max(dp[i-1], dp[i-2] + nums[i])
Answer: 8  (2 + 3 + 3 or 3 + 1 + 4)
```

Space-optimized with two variables `prev1`, `prev2` instead of full array.

---

### Pascal's Triangle — `PascalTriangle.java`
Each element = sum of two elements above it.

```
Row 0:    1
Row 1:   1 1
Row 2:  1 2 1
Row 3: 1 3 3 1
```

| Method | Description |
|--------|-------------|
| `generate(numRows)` | Build full triangle |
| `getRow(rowIndex)` | Get single row in O(n) space |
| `minimumTotal(triangle)` | Max path sum from top to bottom |

---

### Array DP Problems — `ArrayProblems.java`

| Method | Problem | Approach |
|--------|---------|----------|
| `maxSubArray(arr)` | Maximum subarray sum | Kadane's Algorithm |
| `maxProductSub(nums)` | Maximum product subarray | Track max and min (negatives flip sign) |
| `sequence(arr)` | Max sum non-adjacent | House Robber pattern |
| `removeDuplicates(arr)` | Remove duplicates (allow max 2) | Two pointer |

---

## Greedy Algorithm
**Files:** `greedyalgorithm/`

Make the locally optimal choice at each step. No backtracking — commit to each decision.

```
Key question: "Does a locally optimal choice always lead to a globally optimal solution?"
```

### Activity Selection — `ActivitySelection.java`
Select maximum number of non-overlapping activities.

```
Activities sorted by finish time:
(1,2), (3,4), (0,6), (5,7), (5,9), (8,9)

Selected: (1,2), (3,4), (5,7), (8,9) → 4 activities
```

**Strategy:** Always pick the activity that finishes earliest.

---

### Fractional Knapsack — `FractionalKnapsack.java`
Maximize value in a knapsack — items can be broken into fractions.

```
Items: (w=10,v=60), (w=20,v=100), (w=30,v=120)  Capacity=50
Ratio: 6.0,          5.0,           4.0

Take all of item1 (10kg, 60val)
Take all of item2 (20kg, 100val)
Take 2/3 of item3 (20kg, 80val)
Total = 240
```

**Strategy:** Sort by value/weight ratio descending, take greedily.

---

### 0/1 Knapsack — `ZeroOneKnapsack.java`
Each item is either taken or not — no fractions. Greedy approach (note: optimal solution requires DP).

**Strategy here:** Sort by weight descending, take whole items that fit.

---

### Job Scheduling — `JobScheduling.java`
Schedule jobs with deadlines to maximize total profit. Each job takes 1 unit of time.

```
Jobs: (id=3,deadline=1,profit=40), (id=4,deadline=2,profit=30),
      (id=1,deadline=4,profit=20), (id=2,deadline=1,profit=10)

Slot 1: Job 3 (profit 40)
Slot 2: Job 4 (profit 30)
Total profit = 70
```

**Strategy:** Sort by profit descending, assign each job to the latest available slot before its deadline.

---

### Huffman Coding — `HuffmanCoding.java`
Lossless data compression. Assigns shorter codes to more frequent characters.

```
Input: "Huffman coding"
Frequency: H=1, u=1, f=2, m=1, a=1, n=2, ...

Build min-heap → merge two lowest → repeat
Result: frequent chars get shorter binary codes
```

**Strategy:** Always merge the two nodes with lowest frequency using a min-heap (PriorityQueue).

---

## Technique Comparison

| Technique | Key Idea | Time | When to Use |
|-----------|----------|------|-------------|
| Sliding Window | Expand/shrink window | O(n) | Contiguous subarray/substring |
| Prefix Sum | Precompute cumulative sums | O(1) query | Range sum, equilibrium |
| Merge Intervals | Sort + scan | O(n log n) | Overlapping ranges |
| Binary Search | Eliminate half each step | O(log n) | Sorted/monotonic space |
| Bit Manipulation | Bitwise ops | O(1) | Flags, unique elements, powers |
| Backtracking | Try all + undo | Exponential | Permutations, paths, constraints |
| Dynamic Programming | Overlapping subproblems | Varies | Optimization, counting |
| Greedy | Local optimal choice | O(n log n) | Scheduling, knapsack variants |
