class NumArray {
    private int prefix[];

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return prefix[right];
        }else{
            return prefix[right] - prefix[left - 1];
        }
    }
}

class LC303_RangeSumQuery_Immutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5)); 
        System.out.println(numArray.sumRange(0, 5)); 
    }
}

/*
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

/**
 * Leetcode 303. Range Sum Query - Immutable
 * link: https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * Time Complexity: O(n) for the constructor, O(1) for sumRange
 * Space Complexity: O(n) for the prefix sum array
 * 
 * Approach:
 * 1. Create a prefix sum array where each element at index i contains the sum of elements from index 0 to i in the original array.
 * 2. For the sumRange query, if left is 0, return the prefix sum at right. Otherwise, return the difference between the prefix sum at right and the prefix sum at left - 1.
 * 
 */