import java.util.HashMap;

public class LC60_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for(int num : nums){
            currentSum += num;
            int needed = currentSum - k;

            if(map.containsKey(needed)){
                count += map.get(needed);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        LC60_SubarraySumEqualsK solution = new LC60_SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println("Number of subarrays that sum to " + k + ": " + result);
    }
}

/**
 * Leetcode Problem 560: Subarray Sum Equals K
 * link: https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Time Complexity: O(n) - We traverse the array once, and each operation inside the loop is O(1).
 * Space Complexity: O(n) - In the worst case, we may store all prefix sums in the hashmap.
 * 
 * Approach:
 * 1. We use a HashMap to store the cumulative sum (prefix sum) and its frequency.
 * 2. We initialize the map with (0, 1) to account for the case where a subarray itself sums to k.
 * 3. As we iterate through the array, we keep a running total of the current sum.
 * 4. For each element, we check if (currentSum - k) exists in the map. If it does, it means there is a subarray that sums to k.
 * 5. We update the count of such subarrays and also update the map with the current sum.
 * 6. Finally, we return the count of subarrays that sum to k.
 * 
 */