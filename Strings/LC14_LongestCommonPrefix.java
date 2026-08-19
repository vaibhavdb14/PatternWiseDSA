class LC14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
           
            while ( j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            if(j == 0){
                return "";
            }
            
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }

    public static void main(String[] args) {
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result); // Output: "fl"
    }
}