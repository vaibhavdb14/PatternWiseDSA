import java.util.HashMap;
import java.util.Map;

class LC1512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        int goodpairs = 0;

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int freq = e.getValue();
            goodpairs += freq * (freq-1) / 2;
        }

        return goodpairs;
    }

    public static void main(String[] args) {
        LC1512_NumberOfGoodPairs obj = new LC1512_NumberOfGoodPairs();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println("Number of good pairs: " + obj.numIdenticalPairs(nums));
    }
}

/**
 * Leetcode Problem 1512: Number of Good Pairs
 * link: https://leetcode.com/problems/number-of-good-pairs/
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(n)
 * 
 * Approach:
 * 1. Create a HashMap to store the frequency of each number in the array.
 * 2. Iterate through the array and populate the HashMap with the frequency of each number.
 * 3. Initialize a variable goodpairs to 0.
 * 4. Iterate through the entries of the HashMap and for each entry, calculate the number of good pairs using the formula freq * (freq - 1) / 2, where freq is the frequency of the number.
 * 5. Add the calculated good pairs to the goodpairs variable.
 * 6. Return the total number of good pairs.
 */