class LC338_CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        //better approach
        // for(int i = 0; i<n+1; i++){
        //     int m = i;
        //     int count = 0;
        //     while(m>0){
        //         m = m & (m-1);
        //         count++;
        //     }
        //     ans[i] = count;
        // }


        //best approach
        for(int i=0; i<n+1; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LC338_CountingBits solution = new LC338_CountingBits();
        int n = 5;
        int[] result = solution.countBits(n);
        System.out.print("The number of 1 bits for numbers from 0 to " + n + " are: ");
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}


/**
 * leetcode 338. Counting Bits
 * link : https://leetcode.com/problems/counting-bits/
 * 
 * Time - O(n) - We iterate through all numbers from 0 to n, and for each number, we perform a constant amount of work (calculating the number of 1 bits).
 * Space - O(n) - We use an array of size n+1 to store the
 * 
 * Approach Knowledge :
 * The expression i >> 1 effectively divides i by 2, which means we are looking at the number of 1 bits in the previous number (i/2). 
 * The expression (i & 1) checks if the least significant bit of i is set (1) or not (0). 
 * By combining these two, we can build the count of 1 bits for each number based on the counts of previous numbers.      
 * 
 */