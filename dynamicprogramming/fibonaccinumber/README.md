### Fibonacci
Classic DP intro. `fib[i] = fib[i-1] + fib[i-2]`

| Method | Approach |
|--------|----------|
| `fibonacci(n)` | Bottom-up tabulation |
| `fibonacci1(n)` | Returns full array |
| `SpecFibo(n)` | Recursive (exponential — for comparison) |

---

### Climbing Stairs 
Count ways to reach step n taking 1 or 2 steps at a time. Same recurrence as Fibonacci.

```
n=3: [1+1+1, 1+2, 2+1] = 3 ways
dp[i] = dp[i-1] + dp[i-2]
```

---

### House Robbery 
Max sum from non-adjacent elements. Can't rob two consecutive houses.

```
nums = [2, 3, 1, 3, 4]
dp[i] = max(dp[i-1], dp[i-2] + nums[i])
Answer: 8  (2 + 3 + 3 or 3 + 1 + 4)
```

Space-optimized with two variables `prev1`, `prev2` instead of full array.

---