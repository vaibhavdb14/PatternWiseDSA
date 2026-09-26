class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0; 
        int right = height.length - 1;
        int capacity = 0;
        while(left < right){
           if(height[left] < height[right]){
                int res = height[left] * (right - left);
                if(capacity < res){
                    capacity = res;
                }
                left++;
           }else{
                int res = height[right] * (right - left);
                if(capacity < res){
                    capacity = res;
                }
                right--;
           }
        }

        return capacity;
    }

    public static void main(String[] args) {
        LC11_ContainerWithMostWater solution = new LC11_ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = solution.maxArea(height);
        System.out.println("Maximum area: " + result);
    }
}

/**
 * LeetCode Problem 11: Container With Most Water
 * link: https://leetcode.com/problems/container-with-most-water/
 * 
 * Time Complexity: O(n) - We traverse the height array once using two pointers.
 * Space Complexity: O(1) - We use a constant amount of space for variables.
 * 
 * Approach:
 * 1. Initialize two pointers, left at the start of the array and right at the end.
 * 2. Calculate the area formed by the lines at the left and right pointers.
 * 3. Update the maximum area if the current area is larger.
 * 4. Move the pointer pointing to the shorter line inward, as this may lead to a larger area.
 * 5. Repeat steps 2-4 until the two pointers meet.
 * 6. Return the maximum area found.
 */