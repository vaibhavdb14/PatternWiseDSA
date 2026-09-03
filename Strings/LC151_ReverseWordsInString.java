class LC151_ReverseWordsInString {

    //helper function to reverse the string
    public static void reverse(char arr[], int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Time O(n) & Space O(n) : self
    public String reverseWordsApproch2(String s) {
        StringBuilder result = new StringBuilder();
        String finalString = "";
        s = s.trim();

        boolean nextspace = false;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                result.append(s.charAt(i));

                if (nextspace) {
                    nextspace = false;
                }
            }

            if (s.charAt(i) == ' ') {
                if (!nextspace) {
                    finalString = result.toString() + " " + finalString;
                    result.setLength(0);
                }
                nextspace = true;
            }
        }

        finalString = result.toString() + " " + finalString;

        return finalString.stripTrailing();
    }

    // Time O(n) & Space O(n) : self
    public String reverseWordsApproch1(String s) {
        StringBuilder result = new StringBuilder();

        String[] words = s.split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            if (i != 0) {
                result.append(words[i] + " ");
            } else {
                result.append(words[i]);
            }
        }
        return result.toString();
    }

    // Time O(n) & Space O(1) : with the help of chatGPT
    public String reverseWordsApproch3(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != ' ') {
                arr[slow] = arr[fast];
                slow++;
            } else {
                if (slow > 0 && arr[slow - 1] != ' ') {
                    arr[slow] = ' ';
                    slow++;
                }
            }
        }

        if (slow > 0 && arr[slow - 1] == ' ') {
            slow--;
        }

        reverse(arr, 0, slow - 1);

        int ptr = 0;
        for (int i = 0; i < slow; i++) {
            if (arr[i] == ' ') {
                reverse(arr, ptr, i - 1);
                ptr = i + 1;
            }
        }

        reverse(arr, ptr, slow - 1);

        String result = new String(arr, 0, slow);

        return result;
        
    }

    public static void main(String[] args) {
        LC151_ReverseWordsInString obj = new LC151_ReverseWordsInString();
        String s = "the sky is blue";
        System.out.println(obj.reverseWordsApproch1(s));
        System.out.println(obj.reverseWordsApproch2(s));
        System.out.println(obj.reverseWordsApproch3(s));

        s = "  hello world  ";
        System.out.println(obj.reverseWordsApproch1(s));
        System.out.println(obj.reverseWordsApproch2(s));
        System.out.println(obj.reverseWordsApproch3(s));

        s = "a good   example";
        System.out.println(obj.reverseWordsApproch1(s));
        System.out.println(obj.reverseWordsApproch2(s));
        System.out.println(obj.reverseWordsApproch3(s));

        s = "  Bob    Loves  Alice   ";
        System.out.println(obj.reverseWordsApproch1(s));
        System.out.println(obj.reverseWordsApproch2(s));
        System.out.println(obj.reverseWordsApproch3(s));

        s = "Alice does not even like bob";
        System.out.println(obj.reverseWordsApproch1(s));
        System.out.println(obj.reverseWordsApproch2(s));
        System.out.println(obj.reverseWordsApproch3(s));
    }
}


/**
 * Optimal Approach:
 * 
 * Convert the string into a mutable character array.
 * Use two pointers (fast and slow) to scan the array and compact it:
    * Remove leading spaces.
    * Remove trailing spaces.
    * Replace multiple consecutive spaces between words with a single space.
 * Reverse the entire valid portion of the cleaned character array.
 * Traverse the reversed array and reverse each individual word to restore the characters of each word.
 * Convert only the valid portion of the character array back to a String.
 */