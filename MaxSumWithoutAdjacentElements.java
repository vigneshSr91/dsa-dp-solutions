/*
Similar problem on leetcode -https://leetcode.com/problems/house-robber/
Problem Description

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and
no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.

Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000


Output Format

Return an integer, representing the maximum possible sum.



Example Input

Input 1:

 A = [
        [1]
        [2]
     ]
Input 2:

 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]


Example Output

Output 1:

 2
Output 2:

 8

Example Explanation

Explanation 1:

 We will choose 2.
Explanation 2:

 We will choose 3 and 5.
 */
import java.lang.Math;
public class MaxSumWithoutAdjacentElements {
    private static int [][] dpArray;
    private static int [][] givenArrayIn1D;
    public int adjacent(int[][] A) {
        givenArrayIn1D = new int[1][A[0].length];
        for(int i = 0; i<A[0].length; i++){
            givenArrayIn1D[0][i] = Math.max(A[0][i],A[1][i]);
        }
        dpArray = new int[1][givenArrayIn1D[0].length];                  // 1 * N
        int N = A[0].length;
        // Initialize the dp array with integer minimum
        for(int i=0; i<1; i++){
            for(int j=0; j<N; j++){
                dpArray[i][j] = Integer.MIN_VALUE;
            }
        }
        dpArray[0][N-1] = solve(0,N-1);
        return dpArray[0][N-1];
    }
    public int solve(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dpArray[i][j] != Integer.MIN_VALUE){
            return dpArray[i][j];
        }

        dpArray[i][j] = Math.max(givenArrayIn1D[i][j] + solve(i,j-2),solve(i,j-1));
        return dpArray[i][j];


    }

}
