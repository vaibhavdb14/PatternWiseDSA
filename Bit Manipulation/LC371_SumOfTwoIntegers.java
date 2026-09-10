import java.util.Scanner;
public class LC371_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        
        int carry = 1;
        int sum = 0;

        while(carry != 0){
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return sum;
    }

    public static void main(String[] args) {
        LC371_SumOfTwoIntegers solution = new LC371_SumOfTwoIntegers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers to sum: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = solution.getSum(a, b);
        System.out.println("The sum of " + a + " and " + b + " is: " + result);
        sc.close();
    }
}

/**
 * leetcode 371. Sum of Two Integers
 * link : https://leetcode.com/problems/sum-of-two-integers/
 * 
 * Time Complexity: O(1) - The number of iterations is limited by the number of bits in the integers.
 * Space Complexity: O(1) - We use a constant amount of space for variables.
 * 
 * Explanation:
 * In this approach, we use bitwise operations to calculate the sum of two integers without using the '+' operator. 
 * 1. First we calculate the sum without carry using the XOR operation (a ^ b).
 * 2. Then we calculate the carry using the AND operation (a & b) and left shift it by 1 to add it to the next higher bit.
 * 3. Now continuasly add the calulcated carry to the sum until there is no carry left.
 * 4. Finally, we return the sum which is the result of adding a and b
 */