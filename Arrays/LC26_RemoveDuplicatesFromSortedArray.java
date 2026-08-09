public class LC26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
      
       int N = nums.length;
       int ptr1 = 0;
        
        for(int i = 1; i<N;  i++){
            if(nums[ptr1]  != nums[i]){
                ptr1++;
                nums[ptr1] = nums[i];
            }
        }

        return ptr1+1;
    }

    public static void main(String[] args) {
        LC26_RemoveDuplicatesFromSortedArray obj = new LC26_RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = obj.removeDuplicates(nums);
        System.out.println("Length of array after removing duplicates: " + length);
        System.out.print("Modified array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}   