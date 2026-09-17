/**
 * Problem: Maximum Alternating Sum After Rearrangement
 * Given an array of coins, rearrange the coins in any order to maximize the alternating sum
 * calculated as A1 - A2 + A3 - A4 + ...
 * Example:
 * Input:
 *    coins = [1, -6, -5, -12, 1, 3, 8, -3]
 * Output: 39
 * Explanation: The coins can be rearranged to produce the maximum possible alternating sum.
 */

import java.util.Arrays;

public class MaximumAlternatingSum {
    
    public int maxCircuitSum(int totalCoins, int[] coins){

        Arrays.sort(coins);
        int sum = 0;
        int negPositions = totalCoins / 2;

        for(int i = 0; i < negPositions; i++){
            sum -= coins[i];
        }

        for(int i = negPositions; i < totalCoins; i++){
            sum += coins[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        MaximumAlternatingSum mas = new MaximumAlternatingSum();

        int[] coins1 = {1, -6, -5, -12, 1, 3, 8, -3};
        int[] coins2 = {-99, -1, 0, 50, 10};

        System.out.println("For 1st coin collection maximum sum is " + mas.maxCircuitSum(coins1.length, coins1));
        System.out.println("For 2nd coin collection maximum sum is " + mas.maxCircuitSum(coins2.length, coins2));
        
    }
}

//Asked in Rockwell Automation

