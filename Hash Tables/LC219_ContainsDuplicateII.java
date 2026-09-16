import java.util.HashMap;

public class LC219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, i);
            }else{
                int prev = map.get(num);
                if((i - prev) <= k){
                    return true;
                }

                map.put(num, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC219_ContainsDuplicateII obj = new LC219_ContainsDuplicateII();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println("Does the array contain nearby duplicates? : " + obj.containsNearbyDuplicate(nums, k));
    }
}

/**
 * Leetcode Problem 219: Contains Duplicate II
 * link: https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * Time Complexity: O(n) where n is the length of the input array.
 * Space Complexity: O(n) where n is the number of unique elements in the input array.
 * 
 * Approach: (Optimal for only HashMap)
 * 1. Create a HashMap to store the last index of each number encountered in the array.
 * 2. Iterate through the array and for each number, check if it exists in the HashMap.
 *    - If it does, calculate the difference between the current index and the last index stored in the HashMap.
 *    - If the difference is less than or equal to k, return true as a nearby duplicate has been found.
 *    - If it doesn't exist in the HashMap, add it with its current index.
 * 3. If no nearby duplicates are found after iterating through the entire array, return false.
 */