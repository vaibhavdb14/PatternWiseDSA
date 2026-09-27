class LC42_TrappingRainWater{

    //With help of ChatGPT
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int storedWater = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                leftMax = Math.max(leftMax, height[left]);
                storedWater += leftMax - height[left];
                 
                left++;

            } else {

                rightMax = Math.max(rightMax, height[right]);
                storedWater += rightMax - height[right];
                
                right--;

            }
        }

        return storedWater;
    }

    public static void main(String[] args) {
        LC42_TrappingRainWater solution = new LC42_TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int result = solution.trap(height);
        System.out.println("Trapped water: " + result);
    }
}

/**
 * Leetcode Problem 42: Trapping Rain Water
 * leetcode.com/problems/trapping-rain-water/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Approach: Two Pointers
 * 1. Initialize two pointers, left and right, at the start and end of the height array.
 * 2. Initialize two variables, leftMax and rightMax, to keep track of the maximum height encountered from the left and right sides, respectively.
 * 3. While the left pointer is less than the right pointer:
 *   a. If the height at the left pointer is less than or equal to the height at the right pointer:
 *     i. Update leftMax to be the maximum of leftMax and the height at the left pointer.
 *    ii. Calculate the trapped water at the left pointer as leftMax - height[left] and add it to storedWater.
 *   iii. Move the left pointer to the right (left++).
 *  b. Else:
 *    i. Update rightMax to be the maximum of rightMax and the height at the right pointer.
 *   ii. Calculate the trapped water at the right pointer as rightMax - height[right] and add it to storedWater.
 *  iii. Move the right pointer to the left (right--).
 * 4. Return the total storedWater after the loop ends.
 * 
 */



/*
    # First Try (Initial approach | Not successful | Passed 323/325 test cases | Brute Force approach)
    public int trap(int[] height) {
        int storedWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftmax = 0;
            int rightmax = 0;
            int j = i + 1;
            while (j < height.length) {
                if (height[j] > height[i] && height[j] > rightmax) {
                    rightmax = height[j];
                }
                j++;
            }
            int k = i - 1;
            while (k >= 0) {
                if (height[k] > height[i] && height[k] > leftmax) {
                    leftmax = height[k];
                }
                k--;
            }
            int temp = Math.min(leftmax, rightmax) - height[i];
            storedWater += (temp < 0) ? 0 : temp;
        }
        return storedWater;
    }

    # Second Try (Successful approach)
    public int trap(int[] height) {
        int storedWater = 0;
        int n = height.length;
        int leftmax = height[0];

        int rightmax[] = new int[n];
        rightmax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
        }

        for (int i = 1; i < n - 1; i++) {
            leftmax = Math.max(leftmax, height[i]);
            int res = Math.min(leftmax, rightmax[i]) - height[i];
            storedWater += (res < 0) ? 0 : res;
        }
        return storedWater;
    }
 */