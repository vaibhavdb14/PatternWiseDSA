class LC2348_NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        int continues0 = 0;
        long subarrays = 0;

        for(int i = 0; i < nums.length; i++){

            

            if(nums[i] != 0){
                continues0 = 0;
            }else{
                continues0++;
            }

            if(continues0 != 0){
                subarrays += continues0;
            }
        } 

        return subarrays;
    }

    public static void main(String[] args) {
        LC2348_NumberOfZeroFilledSubarrays obj = new LC2348_NumberOfZeroFilledSubarrays();
        int[] nums = {0,0,0,2,0,0};
        System.out.println(obj.zeroFilledSubarray(nums));
    }
}