import java.util.Arrays;
public class LongestCommonSubsequence {
    public int solve(String A, String B) {
        int [][] dp = new int [A.length()][B.length()];
        for(int i = 0; i<A.length(); i++){
            Arrays.fill(dp[i],0);
        }
        return this.findLCS(A, B, A.length()-1, B.length()-1, dp);
    }

    public int findLCS(String A, String B, int i, int j, int [][] dp){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }

        if(A.charAt(i)==B.charAt(j)){
            dp[i][j] = 1 + this.findLCS(A, B, i-1, j-1, dp);
        }else{
            dp[i][j] = Math.max(this.findLCS(A, B, i-1, j, dp),
                    this.findLCS(A, B, i, j-1, dp));
        }

        return dp[i][j];

    }
}
