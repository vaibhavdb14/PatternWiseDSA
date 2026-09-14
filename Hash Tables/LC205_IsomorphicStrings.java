import java.util.HashMap;

public class LC205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (sToT.containsKey(a)) {
                if (sToT.get(a) != b) {
                    return false;
                }
            } else {
                sToT.put(a, b);
            }

            if (tToS.containsKey(b)) {
                if (tToS.get(b) != a) {
                    return false;
                }
            } else {
                tToS.put(b, a);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        LC205_IsomorphicStrings obj = new LC205_IsomorphicStrings();
        String s = "egg";
        String t = "add";
        System.out.println("Are the strings isomorphic?  : " + obj.isIsomorphic(s, t));
    }
}

/**
 * Leetcode Problem 205: Isomorphic Strings
 * link: https://leetcode.com/problems/isomorphic-strings/
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(n)
 * 
 * Approach:
 * 1. Create two HashMaps to store the character mappings from s to t and t to s.
 * 2. Iterate through the characters of both strings simultaneously.
 * 3. For each character pair (a, b), check if a is already mapped to a different character in t. If so, return false.
 * 4. Similarly, check if b is already mapped to a different character in s. If so, return false.
 * 5. If both checks pass, add the mapping to both HashMaps.
 * 6. After iterating through all characters, return true if no conflicts were found.
 */