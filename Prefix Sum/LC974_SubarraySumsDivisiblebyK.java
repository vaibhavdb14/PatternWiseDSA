import java.util.HashMap;

public class LC974_SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int num : nums){
            currentSum += num;

            int rem = (currentSum % k + k) % k;

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        LC974_SubarraySumsDivisiblebyK solution = new LC974_SubarraySumsDivisiblebyK();
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int result = solution.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays that sum to a multiple of " + k + ": " + result);
    }
}

/**
 * Leetcode Problem 974: Subarray Sums Divisible by K
 * link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 * Time Complexity: O(n) - We traverse the array once, and each operation inside the loop is O(1).
 * Space Complexity: O(min(n, k)) - In the worst case, we may store all possible remainders in the hashmap.
 * 
 * Approach:
 * 1. We use a HashMap to store the frequency of remainders when the cumulative sum is divided by k.
 * 2. We initialize the map with (0, 1) to account for the case where a subarray itself sums to a multiple of k.
 * 3. As we iterate through the array, we keep a running total of the current sum.
 * 4. For each element, we calculate the remainder of the current sum when divided by k.
 * 5. If this remainder has been seen before, it means there are subarrays that sum to a multiple of k.
 * 6. We update the count of such subarrays and also update the map with the current remainder.
 * 7. Finally, we return the count of subarrays that sum to a multiple of k.
 */