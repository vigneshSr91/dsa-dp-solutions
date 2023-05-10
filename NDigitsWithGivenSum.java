import java.util.Arrays;

public class NDigitsWithGivenSum {
    private int[][] dp;
    public int solve(int A, int B){
        dp = new int[A+1][B+1];
        for(int i=0; i<=A; i++){
            Arrays.fill(dp[i], -1);
        }
        return this.ndigit(A, B)%((10^9)+7);
    }

    public int ndigit(int digitsLeft, int totalLeft){
        if(digitsLeft==0 && totalLeft==0){
            return 1;
        }
        if(digitsLeft<=0 || totalLeft<=0){
            return 0;
        }
        if(dp[digitsLeft][totalLeft] != -1){
            return dp[digitsLeft][totalLeft];
        }

        int noOfWays = 0;
        if(digitsLeft==1 && totalLeft <= 9){
            dp[digitsLeft][totalLeft] = 1;
            return 1;
        }

        for(int i=0; i<=9; i++){
            noOfWays =  ( (noOfWays % ((10^9)+7)) +
                    ( this.ndigit(digitsLeft-1, totalLeft-i)  % ((10^9)+7))) % ((10^9)+7);
        }

        dp[digitsLeft][totalLeft] = noOfWays % ((10^9)+7);
        return dp[digitsLeft][totalLeft];

    }
}
