class LC392_IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int k = 0;

        for(int i = 0; i < t.length(); i++){
            if(k < s.length() && s.charAt(k) == t.charAt(i)){
                k++;
            }
        }

        if(k == s.length()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        if(isSubsequence(s, t)){
            System.out.println("Yes, Subsequence");
        }else{
            System.out.println("No, Subsequence");
        }

        s = "axc";
        t = "ahbgdc";

        if(isSubsequence(s, t)){
            System.out.println("Yes, Subsequence");
        }else{
            System.out.println("No, Subsequence");
        }
    }
}

/**
 * link : https://leetcode.com/problems/is-subsequence/description/
 * Time - O(n)
 * Space- O(1)
 */