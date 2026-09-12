import java.util.HashMap;
import java.util.Map;
class LC1189_MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        HashMap<Character, Integer> map  = new HashMap<>();
        for(char i : balloon.toCharArray())
            map.put(i, 0);

        for(char i : text.toCharArray()){
            if(balloon.indexOf(i) != -1){
                    if( i == 'b' || i == 'a' || i == 'n')
                        map.put(i, map.get(i)+2);
                    else
                        map.put(i, map.get(i)+1);
            }
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(min > e.getValue()){
                min = e.getValue();
            }
        }

        return min/2;
    }

    public static void main(String[] args) {
        LC1189_MaximumNumberOfBalloons obj = new LC1189_MaximumNumberOfBalloons();
        System.out.println(obj.maxNumberOfBalloons("nlaebolko"));
    }
}

/**
 * Leetcode 706. Design HashMap
 * link: https://leetcode.com/problems/design-hashmap/
 * 
 * Time Complexity: O(n) where n is the length of the input string
 * Space Complexity: O(1) since the size of the hashmap is constant (26 letters
 * 
 * My Approach:
 * 1. Create a hashmap to store the count of each character in the word "balloon".
 * 2. Iterate through the input string and update the countb(if char is 'b','a','n' count+= 2 and otherwise count+= 1) of each character in the hashmap (This is basically used to normalize the count among the characters in "balloon").
 * 3. Find the minimum count of the characters in the hashmap and return it divided by 2.
 * 
 * Poslished Approach:
 * 1. Create a hashmap to store the count of each character in the word "balloon".
 * 2. Iterate through the input string and update the count of each character in the hashmap.(do only count+=1 for all characters)
 * 3. Find the minimum count of the characters, but before comparing, divide each count by the required frequency in "balloon" (e.g. 'l' and 'o' have a frequency of 2, while 'b', 'a', and 'n' have a frequency of 1).
 * 4. Return the minimum count found in step 3.
 */
