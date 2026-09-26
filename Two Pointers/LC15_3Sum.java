import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int x = 0;
        int j = 0;
        int k = 0;

        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            x = 0 - nums[i];
            j = i + 1;
            k = len - 1;

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == x) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        k--;
                        j++;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }

                        // skip duplicate k values
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }

                        continue;
                }

                if (sum < x) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LC15_3Sum solution = new LC15_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println("Triplets: " + result);
    }
}

/**
 * LeetCode Problem 15: 3Sum
 * link: https://leetcode.com/problems/3sum/
 * 
 * Time Complexity: O(n^2) - We have a nested loop where the outer loop runs n times and the inner loop runs at most n times.
 * Space Complexity: O(1) - We use a constant amount of space for variables, excluding the space used for the output list.
 * 
 * Approach:
 * 1. Sort the input array to facilitate the two-pointer technique and to handle duplicates easily.
 * 2. Iterate through the array with an index i, treating nums[i] as the first element of the triplet.
 * 3. For each nums[i], use two pointers (j and k) to find pairs that sum up to -nums[i].
 * 4. Skip duplicate values for nums[i], nums[j], and nums[k] to ensure unique triplets in the result.
 * 5. Add valid triplets to the result list and return it after processing all elements.
 */
