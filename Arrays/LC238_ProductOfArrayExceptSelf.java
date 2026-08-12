class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
       
        int len = nums.length;
        int[] answer = new int[len];
        
        // First approach : Time - O(n) and Space - O(n)
        // int[] prefix = new int[len];
        // int[] sufix = new int[len];

        // prefix[0] = nums[0];
        // for(int i = 1; i < len; i++){
        //     prefix[i] = nums[i] * prefix[i-1];
        // }

        // sufix[len-1] = nums[len-1];
        // for(int i = len-2; i >= 0; i--){
        //     sufix[i] = nums[i] * sufix[i+1];
        // }

        // for(int i = 0; i < len; i++){

        //     if(i == 0){
        //         answer[i] = sufix[i+1];
        //     }
        //     else if(i == len-1){
        //         answer[i] = prefix[len-2]; 
        //     }else{
        //         answer[i] = prefix[i-1] * sufix[i+1];
        //     }
        // }


        // Second approach : Time - O(n) and Space - O(1)
        //left product calculation 
        for(int i = 0 ; i<len; i++){
            if(i==0){
                answer[i] = 1;
            }else{
                answer[i] = answer[i-1] * nums[i-1];
            }
        }

        //right product calculation 
        int rightProduct= 1;
        for(int i = len-1; i>=0; i--){
            
            if(i == len-1){
                rightProduct = 1 * nums[i];
            }else{
                
                answer[i] = rightProduct * answer[i];
                rightProduct = rightProduct * nums[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LC238_ProductOfArrayExceptSelf solution = new LC238_ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}