import java.util.HashSet;

public class LC128_LongestConsecativeSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numset = new HashSet<>();
        for(int num : nums){
            numset.add(num);
        }

        int count = 0;
        for(int i : numset){
            if(!numset.contains(i-1)){
                int it = i;
                int cnt = 0;
                while(numset.contains(it)){
                    cnt++;
                    it++;
                }

                if(cnt > count){
                    count = cnt;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC128_LongestConsecativeSequence longestConsecutive = new LC128_LongestConsecativeSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive.longestConsecutive(nums);
        System.out.println("Longest consecutive sequence length: " + result);
    }
}

/**
 * Leetcode Problem 128: Longest Consecutive Sequence
 * link: https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * Space Complexity: O(n), for storing the elements in the HashSet.
 * 
 * Approach:
 * 1. Store all numbers in a HashSet for O(1) lookups.
 * 2. Iterate through each number in the HashSet and check if it is the start of a sequence (i.e., num - 1 is not in the set).
 * 3. If it is the start, count the length of the consecutive sequence by checking for the next numbers in the sequence (num + 1, num + 2, ...).
 * 4. Keep track of the maximum length found during the iteration.
 * 5. Return the maximum length of the consecutive sequence found.
 */