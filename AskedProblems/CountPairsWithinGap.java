
/**
 * Problem: Count Pairs Within Gap
 * Given an array of request IDs and their corresponding timestamps, count the number of pairs of requests
 * that have the same request ID and whose timestamps are within a specified gap.
 * Example:
 * Input:
 *    requestIds = ["r1", "r1", "r1", "r2", "r2"]
 *    timestamps = [100, 105, 200, 300, 302]
 *    gap = 5
 * Output: 2
 * Explanation: There is one pair of requests with the same request ID "r1" whose timestamps (100 and 105) are within the gap of 5. 
 */

import java.util.HashMap;

public class CountPairsWithinGap {

    public static int countPairs(String[] requestIds, int[] timestamps, int gap) {

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < requestIds.length; i++) {

            String req = requestIds[i];
            int time = timestamps[i];

            if (!map.containsKey(req)) {
                map.put(req, time);
            } else {
                int previous = map.get(req);

                if (time - previous <= gap) {
                    count++;
                    map.remove(req);
                } else {
                    map.put(req, time);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[] requestIds = { "r1", "r1", "r1", "r2", "r2" };

        int[] timestamps = { 100, 105, 200, 300, 302 };

        int gap = 5;

        int result = countPairs(requestIds, timestamps, gap);

        System.out.println("Result: " + result);
    }
}

// Asked in Godaddy