import java.util.Arrays;

public class CuttingARod {
    public int solve(int[] A) {
        // dp array logic pending
        int [] dp = new int[A.length];

        Arrays.fill(dp, -1);
        return this.backtracking(0,A.length, A, dp);
    }
    public int backtracking(int i, int N, int [] A, int[] dp ){
        if(i==N){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }


        // Given first I items, what is the maximum value that can be achieved
        int value = 0;

        for(int r=i; r < N; r++){
            value = Math.max(value, A[r-i] + this.backtracking(r+1, N, A, dp ));
        }

        return dp[i] = value;

    }

    public static void main(String[] args) {
        int [] A = {17,32,33,42,26,40,2,4,33,37,52,51,68,28,96,29,27,22,69,62,30,77,150,51,4,23,21,145,90,8,23,14,
                161,123,124,40,169,2,186,74,109,61,1,0,236,128,99,29,102,195,189,248,172,2,1,284,81,206,22,4,69,
                39,131,6,257,6,139,302,171,305,306,86,135,268,218,284,172,7,19,348,8,79,309,362,283,282,372,104,
                295,117,1,318,350,125,79,293,210,186,8};

        System.out.println(new CuttingARod().solve(A));

    }
}
