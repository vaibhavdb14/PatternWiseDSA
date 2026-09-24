import java.util.HashMap;

public class LC1525_NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        HashMap<Character, Integer> Sright = new HashMap<>();
        HashMap<Character, Integer> Sleft  = new HashMap<>();

        for(char i : s.toCharArray()){
            Sright.put(i, Sright.getOrDefault(i, 0) + 1);
        }

        int goodsplit = 0;

        for(int i = 0; i < s.length()-1; i++){
            char ch = s.charAt(i);
            
            Sleft.put(ch, Sleft.getOrDefault(ch, 0) + 1);
            Sright.put(ch, Sright.getOrDefault(ch, 0) - 1);

            if(Sright.get(ch) == 0){
                Sright.remove(ch);
            }

            if(Sright.size() == Sleft.size()){
                goodsplit++;
            }
        }

        return goodsplit;
    }

    public static void main(String[] args) {
        LC1525_NumberOfGoodWaysToSplitAString solution = new LC1525_NumberOfGoodWaysToSplitAString();
        String s = "aacaba";
        int result = solution.numSplits(s);
        System.out.println("Number of good ways to split the string: " + result);
    }
}

/**
 * Leetcode 1525. Number of Good Ways to Split a String
 * link: https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * 
 * Time Complexity: O(n), where n is the length of the string s.
 * Space Complexity: O(1), since the size of the hash maps is bounded by the size of the character set.
 * 
 * Approach: (Optimized HashMap Approach)
 * 1. Create two hash maps, Sright and Sleft, to keep track of the character counts in the right and left substrings respectively.
 * 2. Iterate through the string s, updating the counts in Sleft and Sright as characters are moved from the right substring to the left substring.
 * 3. After each character is moved, check if the sizes of Sleft and Sright are equal. If they are, increment the goodsplit counter.
 * 4. Return the total count of good splits.
 */