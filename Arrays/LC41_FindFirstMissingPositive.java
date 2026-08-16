class LC41_FindFirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i<n; i++){

            while(nums[i] > 0 &&
                  nums[i] < n &&
                  nums[i] != nums[nums[i]-1]){

                    int correctIndex = nums[i]-1;

                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
            }
        }

        for(int i =0; i<n; i++){
            if(nums[i] != i+1){
                return i+1; 
            }
        }

        return n+1;
    }

    public static void main(String[] args) {
        LC41_FindFirstMissingPositive obj = new LC41_FindFirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        int missingPositive = obj.firstMissingPositive(nums);
        System.out.println("First missing positive: " + missingPositive);
    }
}

/**
 * Level : hard
 * link : https://leetcode.com/problems/first-missing-positive/description/
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 * Note : done after watching solution video.
 */