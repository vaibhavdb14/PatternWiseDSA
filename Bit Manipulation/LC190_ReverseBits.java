class LC190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++){
           int bit = n & 1;
           n = n >> 1;
           result = (result << 1) | bit;
        }

        return result;
    }

    public static void main(String[] args) {
        LC190_ReverseBits solution = new LC190_ReverseBits();
        //1
        int n = 43261596;
        int result = solution.reverseBits(n);
        System.out.println("The reversed bits of " + n + " is: " + result); 
    }
}

/**
 * leetcode 190. Reverse Bits
 * link : https://leetcode.com/problems/reverse-bits/
 * 
 * Time - O(1) - The loop runs a fixed number of times (32 iterations), regardless of the input size.
 * Space - O(1) - We use a constant amount of space for the variable result.
 * 
 * Approach Knowledge :
 * The idea is to iterate through each bit of the input integer n, extract the least significant bit (LSB), and build the reversed integer by shifting the result to the left and adding the extracted bit.
 * We repeat this process for all 32 bits of the integer.
 */