@SuppressWarnings("ALL")
public class CoinSumInfiniteKnapSack {
    public int coinchange2(int[] coins, int target) {
        int mod = (1000000)+7;
        long[] dp = new long[target+1];
        dp[0] = 1;

        for(int j=1; j<dp.length; j++){
            if(j-coins[0]>=0) dp[j] = dp[j-coins[0]];
        }
        
        for(int index = 1; index < coins.length; index++){
            for(int j=coins[index]; j<dp.length; j++){
                dp[j]+=dp[j-coins[index]];
                dp[j]%=mod;
            }
        }

        return (int)dp[target];
    }
    


public static void main(String[] args) {
    int [] A = {18,24,23,10,16,19,2,9,5,12,17,3,28,29,4,13,15,8};
    System.out.println(new CoinSumInfiniteKnapSack().coinchange2(A,458));
}

}
