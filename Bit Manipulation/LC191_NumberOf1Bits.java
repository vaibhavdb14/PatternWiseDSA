public class LC191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while(n>0){
            n = n & (n-1);
            count++;
        }

        return count;
    }
}

/**
 * leetcode 191. Number of 1 Bits
 * link : https://leetcode.com/problems/number-of-1-bits/
 * 
 * Time - O(k) - where k is the number of 1 bits in the binary representation of n. In the worst case, k can be at most 32 (for a 32-bit integer).
 * Space - O(1) - We use a constant amount of space for the variable count.
 * 
 * Approach Knowledge :
 * The expression n & (n-1) removes the rightmost set bit (1) from n. 
 * By repeatedly applying this operation and counting how many times we can do it before n becomes zero, we can determine the number of set bits in n.
 * 
 */