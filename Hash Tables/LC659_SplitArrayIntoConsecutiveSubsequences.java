import java.util.HashMap;

public class LC659_SplitArrayIntoConsecutiveSubsequences {
     public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> need = new HashMap<>();

        for(int num : nums){
            if(freq.get(num) == 0){
                continue;
            }

            if(need.getOrDefault(num, 0)> 0){
                freq.put(num, freq.get(num) - 1);
                need.put(num, need.get(num) - 1);
                need.put(num+1, need.getOrDefault(num+1, 0) + 1);
            }else{
                if(freq.getOrDefault(num+1, 0) == 0 ||
                   freq.getOrDefault(num+2, 0) == 0 ){
                    return false;
                }

                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num+1) - 1);
                freq.put(num + 2, freq.get(num+2) - 1);

                need.put(num+3, need.getOrDefault(num+3, 0) + 1);
            }
        }

        return true ;
    }

    public static void main(String[] args) {
        LC659_SplitArrayIntoConsecutiveSubsequences solution = new LC659_SplitArrayIntoConsecutiveSubsequences();
        int[] nums = {1, 2, 3, 3, 4, 5};
        boolean result = solution.isPossible(nums);
        System.out.println("Can the array be split into consecutive subsequences? " + result);
    }
}

/**
 * Leetcode Problem 659: Split Array into Consecutive Subsequences
 * link: https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 * 
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * Space Complexity: O(n), for storing the frequency and need maps.
 * 
 * Approach:
 * 1. Use a frequency map to count occurrences of each number in the array.
 * 2. Use a need map to track how many subsequences are waiting for a specific number to continue.
 * 3. Iterate through each number in the array:
 *    - If the number is already used (frequency is 0), skip it.
 *    - If there is a subsequence that needs this number, extend that subsequence.
 *    - If not, check if we can start a new subsequence with this number and the next two consecutive numbers.
 *    - If neither option is possible, return false.
 * 4. If we can process all numbers successfully, return true.
 */