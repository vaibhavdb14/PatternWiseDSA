class LC06_ZigzagConversion {
    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;
        boolean goingDown = true;

        for(int i = 0; i < s.length(); i++){
            char currentChar  = s.charAt(i);
            
            if(goingDown){
                rows[currentRow].append(currentChar);
                currentRow++;
                if(currentRow == numRows-1)
                    goingDown = false;
        
            } else if(!goingDown){
                rows[currentRow].append(currentChar);
                currentRow--;
                if(currentRow == 0)
                    goingDown = true;
            }

        }

        for(int i = 1; i<rows.length; i++){
            rows[0].append(rows[i]);
        }

        return rows[0].toString();
    }

    public static void main(String[] args) {
        LC06_ZigzagConversion obj = new LC06_ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(obj.convert(s, numRows));

        s = "PAYPALISHIRING";
        numRows = 4;
        System.out.println(obj.convert(s, numRows));

        s = "A";
        numRows = 1;
        System.out.println(obj.convert(s, numRows));
    }

}

/**
 * link : https://leetcode.com/problems/zigzag-conversion/description/
 * Time - O(n)
 * Space- O(n)
 * Date : 2026-09-02
 */