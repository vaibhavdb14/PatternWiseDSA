import java.util.*;

class LC49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }

            map.get(str).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LC49_GroupAnagrams obj = new LC49_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = obj.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result);
    }
}

/**
 * Leetcode Problem 49: Group Anagrams
 * link: https://leetcode.com/problems/group-anagrams/
 * 
 * Time Complexity: O(n * k log k) where n is the number of strings in the input array and k is the maximum length of a string.
 * Space Complexity: O(n * k) where n is the number of strings in the input array and k is the maximum length of a string.
 * 
 * Approach: (Optimal for only HashMap)
 * 1. Create a HashMap to store sorted strings as keys and their corresponding anagrams as values.
 * 2. Iterate through the input array of strings.
 *    - For each string, convert it to a character array, sort it, and convert it back to a string.
 *    - Use this sorted string as a key in the HashMap.
 *    - If the key does not exist, create a new list for that key.
 *    - Add the original string to the list corresponding to that key.
 * 3. After processing all strings, return the values of the HashMap as a list of lists.
 */