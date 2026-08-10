
# 3sum closest

Sort array
   ↓
Fix nums[i]
   ↓
left = i + 1, right = n - 1
   ↓
Calculate 3-number sum
   ↓
Update closest answer
   ↓
sum < target → left++
sum > target → right--
sum == target → return immediately

# Container With Most Water

Two Pointers + Greedy

left = 0
right = n - 1

while (left < right):
    width  = right - left
    height = min(height[left], height[right])
    area   = width × height

    update maximum

    move the pointer with smaller height