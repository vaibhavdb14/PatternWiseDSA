class LC334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE; 
        
        for(int i = 0; i < nums.length; i++){

            if(nums[i] < first){
                first = nums[i];
            }
            if(nums[i] > first && nums[i] < second){
                second = nums[i];
            }
            if(first < second && second < nums[i]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC334_IncreasingTripletSubsequence obj = new LC334_IncreasingTripletSubsequence();
        int[] nums = {2,1,5,0,4,6};
        System.out.println(obj.increasingTriplet(nums));
    }

}

// link : https://leetcode.com/problems/increasing-triplet-subsequence/description/
// Time - O(n) - we are traversing the array once
// Space - O(1) - we are using constant space