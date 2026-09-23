import java.util.*;

public class LC792_NumberOfMatchingSubsequence {

     public int numMatchingSubseq_1(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>())
               .add(i);
        }

        int count = 0;

        for(String word : words){
            if(isSubsequence(word, map)){
                count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(String word, Map<Character, List<Integer>> map){
        int prev = -1;

        for(char c : word.toCharArray()){

            if(!map.containsKey(c)){
                return false;
            }

            List<Integer> positions = map.get(c);

            int index = upperBound(positions, prev);

            if(index == positions.size()){
                return false;
            }

            prev = positions.get(index);
        }

        return true;
    }

    private int upperBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = left + (right - left) / 2;

            if(list.get(mid) <= target){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return left;
    }

    public int numMatchingSubseq_2(String s, String[] words) {
        HashMap<Character, List<String>> map = new HashMap<>();

        for (String str : words) {
            char ch = str.charAt(0);
            map.computeIfAbsent(ch, k -> new ArrayList<>())
                    .add(str);
        }

        int count = 0;

        for (char c : s.toCharArray()) {
            List<String> word = map.get(c);

            if (word == null) {
                continue;
            }

            List<String> current = new ArrayList<>(word);
            word.clear();

            for (String str : current) {
                if (str.length() == 1) {
                    count++;
                    continue;
                }

                String next = str.substring(1); 

                char nextchar = next.charAt(0);
                map.computeIfAbsent(nextchar, k -> new ArrayList<>())
                        .add(next);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC792_NumberOfMatchingSubsequence solution = new LC792_NumberOfMatchingSubsequence();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        
        //HashMap + Binary Search Method
        int result1 = solution.numMatchingSubseq_1(s, words);
        System.out.println("Number of matching subsequences (Method 1): " + result1);

        //HashMap + buckets Method
        int result2 = solution.numMatchingSubseq_2(s, words);
        System.out.println("Number of matching subsequences (Method 2): " + result2);
    }
}

/**
 * Leetcode Problem 792: Number of Matching Subsequences
 * link: https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 * Time Complexity:
 * - Method 1: O(n + m log k), where n is the length of string s, m is the total length of all words, and k is the average length of the lists in the map.
 * - Method 2: O(n + m), where n is the length of string s and m is the total length of all words.
 * 
 * Space Complexity:
 * - Method 1: O(n + m), for storing the frequency map and positions.
 * - Method 2: O(m), for storing the buckets in the map.
 * 
 * Approach:
 * - Method 1: Use a HashMap to store the positions of each character in string s. For each word, check if it can be formed as a subsequence using binary search on the positions.
 * - Method 2: Use a HashMap to create buckets for each character. For each character in s, process the words that start with that character and move them to the next character's bucket or count them if they are fully matched.
 */