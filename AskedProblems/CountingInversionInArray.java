package AskedProblems;
/*
    Problem: Counting Inversions in an Array
    Given an array of integers, count the number of inversions in the array.
    An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].

    Example:
    Input:
        arr = [2, 4, 1, 3, 5]
    Output:
        3

*/

public class CountingInversionInArray {
    
    public static int countInversions(int[] arr) {
        int n = arr.length;
        int inversions = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inversions++;
                }
            }
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int inversionCount = countInversions(arr);
        System.out.println("Number of inversions in the array: " + inversionCount);
    }
}


// Asked in Lumber 