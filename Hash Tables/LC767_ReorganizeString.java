import java.util.HashMap;
import java.util.Map;

class LC767_ReorganizeString {

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char maxChar = ' ';
        int maxfreq = 0;

        for(char i : s.toCharArray()) {

            map.put(i, map.getOrDefault(i, 0) + 1);

            if(maxfreq < map.get(i)) {
                maxfreq = map.get(i);
                maxChar = i;
            }
        }

        int n = s.length();

        if (maxfreq > (n + 1) / 2) {
            return "";
        }

        char[] result = new char[n];
        int idx  = 0;

        while(map.get(maxChar)>0){
            result[idx] = maxChar;
            map.put(maxChar, map.get(maxChar)-1);
            idx += 2;

            if(idx >= n){
                idx = 1;
            }
        }

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            char ch = e.getKey();

            while(map.get(ch) > 0){
                result[idx] = ch;
                
                map.put(ch, map.get(ch)-1);

                idx += 2;

                if(idx >= n){
                    idx = 1;
                }
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        LC767_ReorganizeString reorganizer = new LC767_ReorganizeString();
        String input = "aab";
        String output = reorganizer.reorganizeString(input);
        System.out.println("Reorganized String: " + output);

        String input2 = "aaab";
        String output2 = reorganizer.reorganizeString(input2);
        System.out.println("Reorganized String: " + output2);
    }

}

/**
 * 
 * leetcode 767. Reorganize String
 * link: https://leetcode.com/problems/reorganize-string/
 * 
 * Time Complexity: O(n), where n is the length of the input string s. We iterate through the string to count character frequencies and then construct the result.
 * Space Complexity: O(n), for storing character frequencies in the HashMap and the result array.
 * 
 * Approach: (Optimal only for HashMap)
 * 1. Count the frequency of each character in the input string using a HashMap.
 * 2. Identify the character with the maximum frequency.
 * 3. Check if it's possible to reorganize the string by ensuring that no character appears more than (n + 1) / 2 times.
 * 4. Place the most frequent character at even indices first, then fill in the remaining characters at odd indices.
 * 5. Return the reorganized string or an empty string if reorganization is not possible.
 * 
 */