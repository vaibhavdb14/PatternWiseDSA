/**
 * This solution has a time complexity of O(n) and a space complexity of O(1).
 * This solution passed 694 / 695 test cases on LeetCode. 
 * The only test case shows "Time Limit Exceeded" error. This is because the input array is too large and the solution is not optimized for such cases.
 * But except for that, the solution is correct and efficient for most cases.
 * I tried to optimize the solution further, but I couldn't find a better approach than this.
 * But if we try same logic with diffrent language like C++ or Python, it will pass all test cases. I think this is because of the way Java handles large arrays and memory allocation.
 * I only tried it with Java and C++. It accepted in C++ but not in Java.
 * If anyone has a better solution or optimization, please let me know. I would love to learn from it.
*/

class LC189_RotateArray {

    public static void reverse(int[] arr, int start, int end){
        
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        
        int len = nums.length;

        if(k == len){
            return;
        }

        k = k % len;

        if(k == 0){
            return;
        }

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    public static void main(String[] args) {
        LC189_RotateArray solution = new LC189_RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}