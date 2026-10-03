import java.util.HashMap;
public class LC532_ContinuousSubarraySum {
     public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
            int rem = sum%k;

            if(map.containsKey(rem)){
                int oldIndex = map.get(rem);
                if(i - oldIndex >= 2){
                    return true;
                }
            }else{
                map.put(rem, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC532_ContinuousSubarraySum solution = new LC532_ContinuousSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println("Does the array have a continuous subarray of at least size 2 that sums to a multiple of " + k + "? " + result);
    }
}

/**
 * Leetcode Problem 523: Continuous Subarray Sum
 * link: https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Time Complexity: O(n) - We traverse the array once, and each operation inside the loop is O(1).
 * Space Complexity: O(min(n, k)) - In the worst case, we may store all possible remainders in the hashmap.
 * 
 * Approach:
 * 1. We use a HashMap to store the first occurrence index of each remainder when the cumulative sum is divided by k.
 * 2. We initialize the map with (0, -1) to account for the case where a subarray itself sums to a multiple of k.
 * 3. As we iterate through the array, we keep a running total of the current sum.
 * 4. For each element, we calculate the remainder of the current sum when divided by k.
 * 5. If this remainder has been seen before, it means there are subarrays that sum to a multiple of k.
 * 6. We check if the length of such subarray is at least 2 by comparing the current index with the stored index.
 * 7. If such a subarray exists, we return true; otherwise, we continue checking.
 * 8. Finally, if no such subarray is found, we return false.
 */