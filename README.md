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
25. Prefix Sum

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

### Algorithm

Two pointers uses two index variables that move toward each other (or in the same direction) to avoid nested loops.

**Opposite-direction (converging) template:**
```
left = 0, right = n - 1
while left < right:
    if condition met:
        process / record result
        move both pointers
    else if need larger value:
        left++
    else:
        right--
```

**Same-direction (fast/slow) template:**
```
slow = 0
for fast = 1 to n-1:
    if condition met:
        slow++
        arr[slow] = arr[fast]
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Container With Most Water** | Converging pointers; shrink the side with the shorter height to maximise area | O(n) | O(1) |
| 2 | **Remove Duplicates in Sorted Array** | Slow pointer marks the last unique position; fast pointer scans ahead | O(n) | O(1) |
| 3 | **Two Sum II (sorted input)** | Converging pointers; move left if sum < target, right if sum > target | O(n) | O(1) |
| 4 | **3Sum** | Sort, fix one element, then use converging pointers for the remaining pair; skip duplicates | O(n²) | O(1) |
| 5 | **3Sum Closest** | Same as 3Sum but track the sum whose absolute difference from target is smallest | O(n²) | O(1) |

### Key Steps — Converging Pointers
1. **Sort** the array (if not already sorted).
2. Place `left = 0` and `right = n - 1`.
3. Compute the value using both pointers.
4. If the value satisfies the condition, record the result and advance both pointers (skip duplicates if needed).
5. If the value is too small, increment `left`; if too large, decrement `right`.
6. Repeat until `left >= right`.

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

### Algorithm

**Fixed-size window template:**
```
for right = 0 to n-1:
    add nums[right] to window
    if window size > k:
        remove nums[right - k] from window
    update result
```

**Variable-size window template:**
```
left = 0
for right = 0 to n-1:
    expand window by adding nums[right]
    while window violates condition:
        shrink window by removing nums[left]
        left++
    update result with (right - left + 1)
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Subarray Product Less Than K** | Variable window; shrink left while product >= k, count subarrays ending at right | O(n) | O(1) |
| 2 | **Maximum Average Subarray I** | Fixed window of size k; slide by adding right and removing left element | O(n) | O(1) |
| 3 | **Longest Substring Without Repeating Characters** | Variable window with HashSet; shrink left when duplicate found | O(n) | O(n) |
| 4 | **Minimum Window Substring** | Variable window with char frequency array; shrink when all chars covered | O(n) | O(1) |
| 5 | **Permutation in String** | Fixed window of size s1.length; compare frequency arrays | O(n) | O(1) |
| 6 | **Find All Anagrams in a String** | Fixed window; collect start indices where frequency arrays match | O(n) | O(1) |
| 7 | **Longest Substring with At Most K Distinct Characters** | Variable window with HashMap; shrink when distinct count > k | O(n) | O(k) |
| 8 | **Best Time to Buy and Sell Stock** | Track running minimum price; update max profit at each step | O(n) | O(1) |
| 9 | **Contains Duplicate II** | Fixed window HashSet of size k; check if element already in set | O(n) | O(k) |
| 10 | **Sliding Window Maximum** | Fixed window with monotonic deque; front always holds max index | O(n) | O(k) |

### Key Steps — Variable Window
1. Initialize `left = 0` and a data structure to track window state.
2. Expand the window by moving `right` forward and adding the element.
3. While the window violates the constraint, shrink from the left.
4. After shrinking, the window is valid — update the result.
5. Repeat until `right` reaches the end.

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

### Algorithm

Two pointers move at different speeds — slow moves one step, fast moves two steps. They meet only if there is a cycle.

**Template:**
```
slow = head, fast = head
while fast != null && fast.next != null:
    slow = slow.next
    fast = fast.next.next
    if slow == fast:
        // cycle detected
```

**Cycle start detection (Floyd's):**
```
// After meeting point found:
slow = head
while slow != fast:
    slow = slow.next
    fast = fast.next
// slow is now at cycle start
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Linked List Cycle** | Fast/slow meet → cycle exists; no meet → no cycle | O(n) | O(1) |
| 2 | **Linked List Cycle II** (detect start) | After meeting, reset slow to head; advance both one step until they meet again | O(n) | O(1) |
| 3 | **Middle of Linked List** | When fast reaches end, slow is at middle | O(n) | O(1) |
| 4 | **Palindrome Linked List** | Find middle with fast/slow, reverse second half, compare both halves | O(n) | O(1) |
| 5 | **Happy Number** | Treat digit-square-sum as a sequence; cycle means not happy, reaching 1 means happy | O(log n) | O(1) |

### Key Steps — Cycle Detection
1. Start both `slow` and `fast` at `head`.
2. Move `slow` by 1 and `fast` by 2 each iteration.
3. If they meet, a cycle exists.
4. To find the cycle start: reset `slow` to `head`, advance both by 1 until they meet again.

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

### Algorithm

**Merge template:**
```
sort intervals by start time
current = intervals[0]
for each interval:
    if interval.start <= current.end:
        current.end = max(current.end, interval.end)  // merge
    else:
        add current to result
        current = interval
add current to result
```

**Insert new interval template:**
```
1. Add all intervals that end before newInterval starts
2. Merge all intervals that overlap with newInterval
3. Add remaining intervals
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Merge Intervals** | Sort by start; merge when next.start <= current.end | O(n log n) | O(n) |
| 2 | **Insert Interval** | Three-pass: add non-overlapping left, merge overlapping, add non-overlapping right | O(n) | O(n) |
| 3 | **Meeting Rooms I** (can attend all?) | Sort by start; if any next.start < prev.end → conflict | O(n log n) | O(1) |
| 4 | **Meeting Rooms II** (min rooms needed) | Sort by start; use min-heap of end times; reuse room if top <= current.start | O(n log n) | O(n) |
| 5 | **Interval List Intersections** | Two pointers on both lists; intersection is [max(starts), min(ends)] if valid; advance the pointer with smaller end | O(n+m) | O(n+m) |

### Key Steps — Merge Intervals
1. **Sort** intervals by start time.
2. Initialize result with the first interval as `current`.
3. For each subsequent interval, check if it overlaps with `current` (`interval.start <= current.end`).
4. If yes, extend `current.end = max(current.end, interval.end)`.
5. If no, push `current` to result and set `current = interval`.
6. Push the last `current` to result.

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

### Algorithm

Place each number at its correct index (`nums[i]` should be at index `nums[i] - 1`). After sorting, scan for misplaced elements.

**Template:**
```
i = 0
while i < n:
    correct = nums[i] - 1
    if nums[i] != nums[correct]:
        swap(nums, i, correct)
    else:
        i++

// Then scan for anomalies
for i = 0 to n-1:
    if nums[i] != i + 1:
        // i+1 is missing or nums[i] is duplicate
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Missing Number** | Cyclic sort for range [0, n]; scan for index where `nums[i] != i` | O(n) | O(1) |
| 2 | **Find All Numbers Disappeared in an Array** | Cyclic sort; collect all indices where `nums[i] != i+1` | O(n) | O(1) |
| 3 | **Find All Duplicates in an Array** | Cyclic sort; collect `nums[i]` where `nums[i] != i+1` (those are duplicates) | O(n) | O(1) |
| 4 | **First Missing Positive** | Cyclic sort for valid range [1, n]; scan for first index where `nums[i] != i+1` | O(n) | O(1) |

### Key Steps
1. Iterate with index `i`.
2. Compute `correct = nums[i] - 1` (the index where `nums[i]` belongs).
3. If `nums[i] != nums[correct]`, swap them (don't increment `i`).
4. Otherwise, increment `i`.
5. After the sort pass, scan the array for the anomaly (missing/duplicate).

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

### Algorithm

**Reverse entire list template:**
```
prev = null, current = head
while current != null:
    next = current.next
    current.next = prev
    prev = current
    current = next
return prev
```

**Reverse sublist (positions left to right) template:**
```
1. Advance prev to node just before position left
2. For (right - left) iterations:
   - detach current.next
   - insert it right after prev
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Reverse Linked List** | Iterative three-pointer: prev, current, next | O(n) | O(1) |
| 2 | **Reverse Linked List II** (sublist) | Advance to left-1, then repeatedly move current.next to front of sublist | O(n) | O(1) |
| 3 | **Reverse Nodes in k-Group** | Recursively reverse each group of k; link tail of group to result of next group | O(n) | O(n/k) stack |
| 4 | **Rotate List** | Find length, make circular, break at `n - k % n` position | O(n) | O(1) |

### Key Steps — Reverse Sublist
1. Use a dummy node before head for easier edge handling.
2. Advance `prev` to the node just before position `left`.
3. `current = prev.next` (start of sublist).
4. For `right - left` iterations: detach `current.next`, insert it after `prev`.
5. Return `dummy.next`.

---

## Subsets
**File:** `subsets/Subsets.java`, `Permutation.java`, `GenerateParenthesis.java`, `LetterCombination.java`

**When to use:** Generating all combinations, permutations, or subsets.

**Time Complexity:** O(2^n) for subsets, O(n!) for permutations

**Space Complexity:** O(n) for recursion depth

**Pattern Recognition:**
- Generate all subsets/combinations
- Generate all permutations
- Parentheses generation
- Letter combinations

### Algorithm

**Backtracking template:**
```
backtrack(index, current):
    record current (add to result)
    for i = index to n-1:
        choose nums[i]
        backtrack(i+1, current)
        unchoose nums[i]          // undo
```

**Permutation template:**
```
permutation(start):
    if start == n: record current
    for i = start to n-1:
        swap(nums, start, i)
        permutation(start + 1)
        swap(nums, start, i)      // restore
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Subsets** | Backtrack: at each index, choose to include or skip | O(2^n) | O(n) |
| 2 | **Subsets II** (with duplicates) | Sort first; skip duplicate elements at the same recursion level | O(2^n) | O(n) |
| 3 | **Permutations** | Swap-based backtrack: fix position `start`, try each remaining element | O(n!) | O(n) |
| 4 | **Next Permutation** | Find rightmost descent, swap with next larger, reverse suffix | O(n) | O(1) |
| 5 | **Permutations II** (with duplicates) | Sort + `used[]` array; skip if `nums[i] == nums[i-1]` and `!used[i-1]` | O(n!) | O(n) |
| 6 | **Generate Parentheses** | Backtrack with open/close counters; add `(` if open < n, add `)` if close < open | O(4^n/√n) | O(n) |
| 7 | **Letter Combinations of a Phone Number** | Backtrack through digit map; try each letter for current digit | O(4^n) | O(n) |

### Key Steps — Subsets Backtracking
1. Start with an empty `current` list.
2. At each call, add a snapshot of `current` to results.
3. Loop from `index` to end: add `nums[i]`, recurse with `i+1`, then remove `nums[i]`.
4. For duplicates: sort first, skip `nums[i]` if it equals `nums[i-1]` and the previous wasn't used.

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

### Algorithm

**Standard binary search template:**
```
left = 0, right = n - 1
while left <= right:
    mid = left + (right - left) / 2
    if nums[mid] == target: return mid
    else if nums[mid] < target: left = mid + 1
    else: right = mid - 1
```

**Rotated array — determine which half is sorted:**
```
if nums[mid] >= nums[left]:   // left half is sorted
    if target in [nums[left], nums[mid]]: right = mid - 1
    else: left = mid + 1
else:                          // right half is sorted
    if target in [nums[mid], nums[right]]: left = mid + 1
    else: right = mid - 1
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Search in Rotated Sorted Array** | Identify sorted half at each step; check if target lies in it | O(log n) | O(1) |
| 2 | **Find Minimum in Rotated Sorted Array** | If `nums[mid] > nums[right]`, min is in right half; else left half | O(log n) | O(1) |
| 3 | **Find Peak Element** | If `nums[mid] < nums[mid+1]`, peak is to the right; else to the left | O(log n) | O(1) |
| 4 | **Find First and Last Position** (Search Range) | Binary search to find target, then expand left/right to find boundaries | O(log n) | O(1) |

### Key Steps — Rotated Array Search
1. Compute `mid = left + (right - left) / 2`.
2. If `nums[mid] == target`, return `mid`.
3. Check which half is sorted: if `nums[mid] >= nums[left]`, left half is sorted.
4. Determine if target falls in the sorted half; adjust `left` or `right` accordingly.
5. Repeat until found or `left > right`.

---

## Bitwise XOR

**File:** `bitmanipulation/bitwisexor/Problems.java`

**When to use:** Finding single numbers, missing numbers in arrays.

**Time Complexity:** O(n)

**Space Complexity:** O(1)

**Key Properties:**
```
a ^ a = 0       (same number cancels out)
a ^ 0 = a       (XOR with 0 is identity)
XOR is commutative and associative
```

**Pattern Recognition:**
- Single number problems
- Missing number in array
- Two single numbers

### Algorithm

**Single number template:**
```
result = 0
for each num in nums:
    result ^= num
// All duplicates cancel; result holds the unique number
```

**Two single numbers template:**
```
xor = XOR of all numbers          // xor = a ^ b
rightMostBit = xor & (-xor)       // isolate differing bit
a = 0, b = 0
for each num:
    if num & rightMostBit == 0: a ^= num
    else: b ^= num
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Even or Odd** | `(n ^ 1) == n + 1` is true only for even numbers | O(1) | O(1) |
| 2 | **Single Number I** | XOR all elements; duplicates cancel, unique remains | O(n) | O(1) |
| 3 | **Swap Without Temp** | `a^=b; b^=a; a^=b` | O(1) | O(1) |
| 4 | **Missing Number** | XOR indices 0..n with all elements; missing number remains | O(n) | O(1) |
| 5 | **Single Number II** (appears once, others 3×) | Bit counters `one` and `two` track bits seen 1 and 2 times mod 3 | O(n) | O(1) |
| 6 | **Single Number III** (two unique numbers) | XOR all → `a^b`; use rightmost set bit to split into two groups | O(n) | O(1) |
| 7 | **XOR of 1 to N** | Pattern repeats every 4: `n%4==0→n`, `1→1`, `2→n+1`, `3→0` | O(1) | O(1) |

### Key Steps — Single Number
1. Initialize `result = 0`.
2. XOR every element into `result`.
3. All elements appearing twice cancel out (`a ^ a = 0`).
4. The remaining value is the unique element.

---

## Top K Elements
**File:** `topkelements/pq/Problems.java`, `topkelements/quickselect/Problems.java`

**When to use:** Finding K largest/smallest elements, K closest elements.

**Time Complexity:** O(n log k) with heap, O(n) average with quickselect

**Space Complexity:** O(k)

**Pattern Recognition:**
- K largest/smallest elements
- K most frequent elements
- K closest points

### Algorithm

**Min-heap for K largest template:**
```
minHeap of size k
for each num:
    add num to heap
    if heap.size > k:
        heap.poll()          // remove smallest
return heap.peek()           // kth largest
```

**Quickselect template:**
```
partition array around pivot
if target index <= high: recurse left
else if target index >= low: recurse right
else: return nums[target]
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Kth Largest Element** | Min-heap of size k; poll when size exceeds k | O(n log k) | O(k) |
| 2 | **Kth Smallest Element** | Max-heap of size k; poll when size exceeds k | O(n log k) | O(k) |
| 3 | **Top K Frequent Elements** | Frequency map + min-heap ordered by frequency | O(n log k) | O(n) |
| 4 | **Kth Smallest in Sorted Matrix** | Max-heap of size k; skip elements larger than current peek | O(n² log k) | O(k) |
| 5 | **K Closest Points to Origin** | Max-heap by distance; poll when size exceeds k | O(n log k) | O(k) |
| 6 | **Find K Pairs with Smallest Sums** | Min-heap seeded with (nums1[i], nums2[0]); expand by advancing nums2 index | O(k log k) | O(k) |
| 7 | **Kth Largest (Quickselect)** | Partition around pivot; recurse only into the half containing target index | O(n) avg | O(1) |

### Key Steps — Heap Approach
1. Choose min-heap for K largest, max-heap for K smallest.
2. Push each element into the heap.
3. If heap size exceeds k, poll (removes the element that doesn't belong in top k).
4. After processing all elements, `heap.peek()` is the kth largest/smallest.

---

## Two Heaps
**File:** `twoheaps/MedianFinder.java`

**When to use:** Problems requiring the median of a data stream, or splitting data into two halves.

**Time Complexity:** O(log n) per insert, O(1) for median

**Space Complexity:** O(n)

**Pattern Recognition:**
- Median of a data stream
- Sliding window median
- Scheduling problems needing balance between two halves

### Algorithm

Maintain two heaps:
- **Max-heap** (left half) — stores the smaller half
- **Min-heap** (right half) — stores the larger half

**Invariant:** `maxHeap.size >= minHeap.size` and `maxHeap.peek() <= minHeap.peek()`

**Template:**
```
addNum(num):
    maxHeap.offer(num)
    minHeap.offer(maxHeap.poll())     // balance: push largest of left to right
    if maxHeap.size < minHeap.size:
        maxHeap.offer(minHeap.poll()) // rebalance: keep left >= right

findMedian():
    if sizes equal: return (maxHeap.peek() + minHeap.peek()) / 2.0
    else: return maxHeap.peek()
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Find Median from Data Stream** | Max-heap for lower half, min-heap for upper half; rebalance after each insert | O(log n) insert | O(n) |

### Key Steps
1. Always push to `maxHeap` first, then move its top to `minHeap`.
2. If `maxHeap.size < minHeap.size`, move `minHeap`'s top back to `maxHeap`.
3. Median is `maxHeap.peek()` if sizes differ, else average of both tops.

---

## 0/1 Knapsack
**File:** `knapsack/zerooneknapsack/Knapsack.java`

**When to use:** Optimization problems where each item can be used at most once.

**Time Complexity:** O(n × capacity)

**Space Complexity:** O(n × capacity) for 2D DP, O(capacity) for 1D optimized

**Pattern Recognition:**
- Each item included or excluded (binary choice)
- Subset sum / partition problems
- Max profit within a weight limit

### Algorithm

**2D DP table:**
```
dp[i][c] = max profit using first i items with capacity c

for each item i:
    for each capacity c:
        exclude = dp[i-1][c]
        include = profits[i] + dp[i-1][c - weights[i]]  (if weights[i] <= c)
        dp[i][c] = max(exclude, include)
```

**1D optimized (iterate capacity in reverse):**
```
dp[c] = max profit at capacity c
for each item:
    for c = capacity down to weights[i]:
        dp[c] = max(dp[c], profits[i] + dp[c - weights[i]])
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **0/1 Knapsack** | 2D DP: for each item, choose max of include vs exclude | O(n×W) | O(n×W) |
| 2 | **0/1 Knapsack (optimized)** | 1D DP: iterate capacity in reverse to avoid reusing items | O(n×W) | O(W) |
| 3 | **Partition Equal Subset Sum** | Reduce to subset sum: target = totalSum/2; boolean DP | O(n×S) | O(n×S) |
| 4 | **Partition Equal Subset Sum (optimized)** | 1D boolean DP; iterate target in reverse | O(n×S) | O(S) |

### Key Steps — 1D Knapsack
1. Initialize `dp[0..capacity] = 0`.
2. For each item, iterate capacity **from high to low** (prevents reuse).
3. `dp[c] = max(dp[c], profit + dp[c - weight])`.
4. Answer is `dp[capacity]`.

---

## Prefix Sum
**File:** `prefixsum/PrefixSum.java`

**When to use:** Range sum queries, finding equilibrium points, splitting arrays by sum.

**Time Complexity:** O(n) to build, O(1) per query

**Space Complexity:** O(n)

**Pattern Recognition:**
- Sum of subarray [i, j] in O(1)
- Equilibrium index (left sum == right sum)
- Count subarrays with a given sum

### Algorithm

**Build prefix sum array:**
```
prefix[0] = 0
for i = 1 to n:
    prefix[i] = prefix[i-1] + arr[i-1]

// Range sum [l, r] (0-indexed):
sum = prefix[r+1] - prefix[l]
```

**Equilibrium point template:**
```
totalSum = sum of all elements
prefixSum = 0
for i = 0 to n-1:
    suffixSum = totalSum - arr[i] - prefixSum
    if prefixSum == suffixSum: return i
    prefixSum += arr[i]
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Equilibrium Point** | At each index, check if left sum == right sum using running prefix and suffix | O(n) | O(1) |
| 2 | **Split Array into Equal Sum Parts** | Scan from right; track rightSum and leftSum; find split where they're equal | O(n) | O(1) |

### Key Steps — Equilibrium Point
1. Compute `totalSum` of the array.
2. Maintain `prefixSum = 0`.
3. At each index `i`, compute `suffixSum = totalSum - arr[i] - prefixSum`.
4. If `prefixSum == suffixSum`, index `i` is the equilibrium point.
5. Add `arr[i]` to `prefixSum` and continue.

---

## Backtracking
**File:** `backtracking/Ratmaze.java`, `backtracking/WordSearch.java`

**When to use:** Exploring all possible paths/solutions with pruning of invalid branches.

**Time Complexity:** O(b^d) where b = branching factor, d = depth

**Space Complexity:** O(d) recursion stack

**Pattern Recognition:**
- Path finding in a grid
- Word search in a matrix
- N-Queens, Sudoku solver
- All valid combinations with constraints

### Algorithm

**General backtracking template:**
```
backtrack(state):
    if goal reached:
        record solution
        return
    for each choice:
        if choice is valid:
            make choice (mark visited)
            backtrack(next state)
            undo choice (unmark)
```

**Grid path template (Rat in a Maze):**
```
solve(row, col, path):
    if out of bounds or blocked: return
    if reached destination: record path; return
    mark cell as visited
    explore all 4 directions
    unmark cell (backtrack)
```

### Problems

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | **Rat in a Maze** | DFS with backtracking on grid; mark visited, explore 4 directions, unmark on return | O(4^(n²)) | O(n²) |
| 2 | **Word Search** | DFS from each cell; mark visited with temp char, restore on backtrack | O(m×n×4^L) | O(L) |

### Key Steps — Grid Backtracking
1. Check boundary and validity conditions first (base cases).
2. Mark the current cell as visited to avoid revisiting.
3. Recursively explore all valid neighbors.
4. **Unmark** the cell after returning (this is the backtrack step).
5. Collect results when the goal condition is met.

---
