public class LC167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left <= right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left+1, right+1};
            }
            if(sum > target){
                right--;
            }else{
                left++;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        LC167_TwoSumII_InputArrayIsSorted solution = new LC167_TwoSumII_InputArrayIsSorted();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
