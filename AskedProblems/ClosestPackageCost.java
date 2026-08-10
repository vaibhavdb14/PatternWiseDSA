/*
    Problem: Closest Package Cost
    Given a 2D array, rows represent category and columns represent the cost of items in that category.
    You are given a target cost. You need to find the closest absolute difference to the target.
    Input:
    N : number of categories
    M : number of items in each category
    target : target cost
    cost : 2D array of costs

    Output:
    Return the closest absolute difference to the target cost.

    Example:
    Input:
        N = 3, M = 2, target = 62
        cost = [[15,10],[25,10],[40,40]]
    Output:
        2
    Explanation:
        The closest cost to the target 62 is 60 (15 + 25 + 20), and the absolute difference is |62 - 60| = 2.
    
*/

package AskedProblems;

public class ClosestPackageCost {
    
    public static int closestCost(int[][] cost, int target){
        int result  = 0;

        
        return result;
    }

    public static void main(String[] args) {
        int[][] cost = {{15, 10}, {25, 10}, {40, 40}};
        int target = 62;
        int closestDifference = closestCost(cost, target);
        System.out.println("Closest absolute difference to the target cost: " + closestDifference);
    }
}
