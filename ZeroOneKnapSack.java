import java.util.Arrays;

public class ZeroOneKnapSack {
    public int solve(int[] A, int[] B, int C) {
        int maximumValue = 0;
        if(Arrays.stream(B).min().getAsInt() > C){
            return 0;
        }

        int [][] dp = new int[2][C+1];

        for(int i=0; i<=C; i++){
            if(B[0] <= i){
                dp[0][i] = A[0];
            }else{
                dp[0][i] = 0;
            }
        }

        int [] previousRow = dp[0];
        int [] currentRow = dp[1];

        for(int i=1; i<A.length; i++){
            for(int j=0; j<=C; j++ ){
                if(B[i] <= j){
                    currentRow[j] = Math.max(A[i]+previousRow[j-B[i]], previousRow[j]);
                }else{
                    currentRow[j] = previousRow[j];
                }
                if(maximumValue < currentRow[j]){
                    maximumValue = currentRow[j];
                }
                int [] temp = previousRow;
                previousRow = currentRow;
                currentRow = temp;
            }
        }
        return maximumValue;

    }

    private int findMax(int i, int j, int[][] dp, int[] values, int[] weights){
        if(i == 0 || j == 0){
            // This means to get a Weight 0 from 0 Items, will always be zero
            return 0;
        }
        /*
        if(i == 0 && j != 0){
            // This means, I have 0 Items to pick to attain a value of J, which is not possible
            // will always return Infinity
            return Integer.MAX_VALUE;
        }


        if(i > 0 && j==0){
            return 0;
        }
        */
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(weights[i-1]<=j){
            // min(Pick an Item, Don't pick an Item)
            return dp[i][j] = Math.max(values[i-1] + this.findMax(i-1,j-weights[i-1], dp, values, weights),
                                this.findMax(i-1,j,dp, values,weights));
        } else {
            // We cannot pick the item as value assigned to the item is higher
            return dp[i][j] = this.findMax(i-1,j,dp, values,weights);
        }

    }

    public static void main(String[] args) {
       int [] A = {6, 10, 12};
       int [] B = {10, 20, 30};
       int C = 50;

        System.out.println(new ZeroOneKnapSack().solve(A, B, C));
    }
}


