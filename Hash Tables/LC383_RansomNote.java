import java.util.HashMap;

class LC383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magChar = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            magChar.put(ch, magChar.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (magChar.containsKey(ch) && magChar.get(ch) > 0) {
                magChar.put(ch, magChar.getOrDefault(ch, 0) - 1);
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LC383_RansomNote obj = new LC383_RansomNote();
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println("Can the ransom note be constructed from the magazine?  : " + obj.canConstruct(ransomNote, magazine));
    }
}

/**
 * Leetcode Problem 383: Ransom Note
 * link: https://leetcode.com/problems/ransom-note/
 * 
 * Time Complexity: O(n+m) where n is the length of the ransom note and m is the length of the magazine.
 * Space Complexity: O(k) where k is the number of unique characters in the magazine.
 * 
 * Approach: (Optimal for only HashMap)
 * 1. Create a HashMap to store the character counts of the magazine.
 * 2. Iterate through the characters of the magazine and populate the HashMap with character counts.
 * 3. Iterate through the characters of the ransom note.
 * 4. For each character in the ransom note, check if it exists in the HashMap and has a count greater than 0.
 *    - If it does, decrement the count in the HashMap.
 *    - If it doesn't, return false as the ransom note cannot be constructed from the magazine.
 * 5. If all characters in the ransom note can be matched with characters in the magazine, return true.
 * 
 * Alternative Approach: (Most Optimal for LC383)
 * 1. Create an integer array of size 26 to store the character counts of the magazine (assuming only lowercase letters).
 * 2. Iterate through the characters of the magazine and populate the array with character counts.
 * 3. Iterate through the characters of the ransom note.
 * 4. For each character in the ransom note, check if the corresponding count in the array is greater than 0.
 *    - If it is, decrement the count in the array.
 *    - If it isn't, return false as the ransom note cannot be constructed from the magazine.
 * 5. If all characters in the ransom note can be matched with characters in the magazine, return true.
 * 
 */