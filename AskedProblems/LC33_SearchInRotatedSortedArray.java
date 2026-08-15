package AskedProblems;

/*
    Problem: Search in Rotated Sorted Array
    Given a sorted array that has been rotated at some pivot unknown to you beforehand, and a target value, search for the target in the array. If found, return its index; otherwise, return -1.

    Example:
    Input:
        nums = [4,5,6,7,0,1,2], target = 0
    Output:
        4

*/

public class LC33_SearchInRotatedSortedArray {
    
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { 
                
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
        
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = search(nums, target);
        System.out.println("Index of target " + target + ": " + index);
    }
}

// link : https://leetcode.com/problems/search-in-rotated-sorted-array/description/
// Asked in Demandbase.