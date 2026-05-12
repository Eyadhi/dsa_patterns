package techniques.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, count = 0;
        long product = 1;

        for (int right = 0; right < n; right++) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxSum = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(sum, maxSum);
        }
        return (maxSum / k);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> s1 = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        int right;
        for (right = 0; right < s.length(); right++) {
            while (s1.contains(s.charAt(right))) {
                s1.remove(s.charAt(left));
                left++;
            }
            s1.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static String minimumWindowSubstring(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        int[] charCount = new int[128];
        for (char ch : t.toCharArray()) {
            charCount[ch]++;
        }

        int left = 0, right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (charCount[ch] > 0) {
                required--;
            }

            charCount[ch]--;

            right++;
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                charCount[leftChar]++;

                if (charCount[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static boolean permutationInString(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }

        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= k) {
                window[s2.charAt(i - k) - 'a']--;
            }

            if (matches(s1Count, window)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matches(int[] a1, int[] b1) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != b1[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length())
            return result;

        int[] pCount = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= k) {
                window[s.charAt(i - k) - 'a']--;
            }

            if (matches(pCount, window)) {
                result.add(i - k + 1);
            }
        }
        return result;
    }

    public static int longestSubstringWithAtmostKDistinctCharacters(String str, int k) {
        if (k == 0 || str.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, maxLen = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() > k) {
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 5, 2, 6 };
        System.out.println(numSubarrayProductLessThanK(nums, 100));

        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring(s, t));

        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(permutationInString(s1, s2));

        String st = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(st, p);
        System.out.println(result);

        String str = "eceba";
        int k = 2;
        System.out.println(longestSubstringWithAtmostKDistinctCharacters(str, k));

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));

        int[] nums1 = { 1, 2, 3, 1 };
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1));

        int[] nums2 = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k2 = 3;
        int[] result1 = maxSlidingWindow(nums2, k2);
        for (int value : result1) {
            System.out.print(value + " ");
        }
    }
}
