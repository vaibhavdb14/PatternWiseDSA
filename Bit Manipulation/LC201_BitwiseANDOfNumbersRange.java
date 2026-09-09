public class LC201_BitwiseANDOfNumbersRange {

    // Approach 1: Common Prefix Method
    public int rangeBitwiseAnd1(int left, int right) {

        int shift = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        return left << shift;
    }

    // Approach 2: Bit Manipulation Method (trick to turn off the rightmost set bit)
    public int rangeBitwiseAnd2(int left, int right) {

        while (right > left) {
            right = right & (right - 1);
        }

        return right;
    }

    public static void main(String[] args) {
        LC201_BitwiseANDOfNumbersRange solution = new LC201_BitwiseANDOfNumbersRange();
        // 1
        int left = 5;
        int right = 7;
        int result = solution.rangeBitwiseAnd2(left, right);
        System.out.println("The bitwise AND of numbers in range [" + left + ", " + right + "] is: " + result);

        // 2
        left = 1;
        right = 2147483647;
        result = solution.rangeBitwiseAnd1(left, right);
        System.out.println("The bitwise AND of numbers in range [" + left + ", " + right + "] is: " + result);
    }
}

/**
 * leetcode 201. Bitwise AND of Numbers Range
 * link : https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 * Approach 1: Common Prefix Method
 * Time Complexity: O(logN) where N is the difference between right and left.
 * Space Complexity: O(1)
 * 
 * Explanation:
 * In this approach, we find the common prefix of the binary representations of left and right. 
 * We keep right-shifting both left and right until they are equal, counting the number of shifts. 
 * The result is then obtained by left-shifting the common prefix back to its original position.
 * 
 * Approach 2: Bit Manipulation Method (trick to turn off the rightmost set bit)
 * Time Complexity: O(logN) where N is the difference between right and left.
 * Space Complexity: O(1)
 * 
 * Explanation:
 * In this approach, we repeatedly turn off the rightmost set bit of right until it becomes less than or equal to left.
 * And since the AND operation will turn off any bits that differ between left and right, the final value of right will be the result of the AND operation over the entire range.
 */
