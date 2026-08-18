class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length()-1;
        
        while(left <= right){
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if(!Character.isLetterOrDigit(lc)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(rc)){
                right--;
                continue;
            }
            if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        LC125_ValidPalindrome solution = new LC125_ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = solution.isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);
    }
}