public class LC260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        
        int allXor = 0;
        for(int i : nums){
            allXor ^= i;
        }

        int diffBit = allXor & -allXor;
        int num1 = 0;
        int num2 = 0;

        for(int i : nums){
            if((i & diffBit) != 0){
                num1 ^= i;
            }else{
                num2 ^= i;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        LC260_SingleNumberIII solution = new LC260_SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = solution.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}

/**
 * leetcode 260. Single Number III
 * link : https://leetcode.com/problems/single-number-iii/
 * 
 * Time Complexity: O(n) where n is the length of the input array nums.
 * Space Complexity: O(1) - We use a constant amount of space for variables.
 * 
 * Explanation:
 * In this approach, we first find the XOR of all numbers in the array, which gives us the XOR of the two unique numbers (let's call them a and b). 
 * The result will have at least one bit set to 1, indicating that a and b differ at that bit position. 
 * We can isolate this differing bit using the expression allXor & -allXor. 
 * Then, we partition the numbers into two groups based on whether they have this differing bit set or not, and XOR each group separately to find the two unique numbers.
 */
