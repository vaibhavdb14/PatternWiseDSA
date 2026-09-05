class LC136_SingleNumber {
    public int singleNumber(int[] nums) {
        int nonRepeated = nums[0];
        for(int i = 1; i<nums.length; i++){
            nonRepeated = nonRepeated ^ nums[i]; 
        }

        return nonRepeated;
    }

    public static void main(String[] args) {
        LC136_SingleNumber solution = new LC136_SingleNumber();
        //1
        int[] nums = {4, 1, 2, 1, 2};
        int result = solution.singleNumber(nums);
        System.out.println("The single number is: " + result); 

        //2
        int[] nums2 = {2, 2, 1};
        int result2 = solution.singleNumber(nums2);
        System.out.println("The single number is: " + result2);

        //3
        int[] nums3 = {1};
        int result3 = solution.singleNumber(nums3);
        System.out.println("The single number is: " + result3);
    }
}


/**
 * leetcode 136. Single Number
 * link : https://leetcode.com/problems/single-number/
 * 
 * Time - O(n) - We traverse the array once, where n is the length of the array.
 * Space - O(1) - We use a constant amount of space for the variable non
 * 
 * Approach Knowledge :
 * The XOR operation has the property that a ^ a = 0 and a ^ 0 = a. 
 * Therefore, when we XOR all elements in the array, the repeated elements will cancel out, leaving only the single element.
 * As XOR is commutative and associative, the order of operations does not matter, and we can XOR the elements in any order.
 * for example, if the input array is [4, 1, 2, 1, 2], the XOR operation will be:
 * 4 ^ 1 ^ 2 ^ 1 ^ 2 = (4 ^ 1 ^ 1) ^ (2 ^ 2) = 4 ^ 0 ^ 0 = 4
 */