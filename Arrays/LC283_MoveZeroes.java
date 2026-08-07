public class LC283_MoveZeroes {
    public void moveZeroes(int[] nums) {
            int N = nums.length;

            int ptr = 0;

            for(int i = 0; i<N; i++){
                if(nums[i] != 0){
                    if(ptr != i){
                        nums[ptr] = nums[i];
                        nums[i] = 0;
                    }
                    ptr++;
                }
            }  
    }

    public static void main(String[] args) {
        LC283_MoveZeroes solution = new LC283_MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}