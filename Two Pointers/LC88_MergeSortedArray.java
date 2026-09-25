class LC88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        for(int i = m+n-1; i >= 0; i--){
            if(p1 >= 0 && p2 >= 0){
                if(nums1[p1] > nums2[p2]){
                    nums1[i] = nums1[p1];
                    p1--;
                }else{
                    nums1[i] = nums2[p2];
                    p2--;
                }
            }else if(p2 >= 0){
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        LC88_MergeSortedArray solution = new LC88_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        solution.merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

/**
 * Leetcode Problem 88: Merge Sorted Array
 * link: https://leetcode.com/problems/merge-sorted-array/
 * 
 * Time Complexity: O(m + n) where m is the length of nums1 and n is the length of nums2.
 * Space Complexity: O(1) since we are modifying nums1 in place.
 * 
 * Approach:
 * 1. We use two pointers, p1 and p2, initialized to the last elements of nums1 and nums2 respectively.
 * 2. We iterate from the end of nums1 (from index m+n-1 to 0) and compare the elements pointed by p1 and p2.
 * 3. We place the larger element at the current index and move the corresponding pointer (p1 or p2) backwards.
 * 4. If p1 is exhausted (i.e., p1 < 0), we continue to copy the remaining elements from nums2 into nums1.  
 * 
 * Note: If p1 is exhausted, we don't need to do anything for the remaining elements of nums1 since they are already in place.
 * and if p2 is exhausted, we don't need to do anything for the remaining elements of nums2 since they are already in place.
 */