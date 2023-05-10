import java.util.Arrays;
import java.util.HashMap;

public class FlipArray {
    int total;
    int noOfElements;

    HashMap<String, Integer> resultHash;

    public int solve(final int[] A) {

        this.total = Arrays.stream(A).sum();
        resultHash = HashMap.newHashMap(total + 1);
        int n = A.length;
        int result=0;
        for (int i = 0; i <= this.total; i++) {
            result = this.flip(n, i, A);
            if (result != 9999999) {
                return result;
            }
        }
        return result;
    }

        public int flip ( int currentIndex, int currentBalance, int[] A){
            // Base cases
            if (currentIndex == 1) {
                if (A[currentIndex - 1] == currentBalance) {
                    return 0;
                } else if (A[currentIndex - 1] == -currentBalance) {
                    return 1;
                } else {
                    return 9999999;
                }
            }

            String searchKey = ((Integer) currentIndex).toString().concat(":").concat(((Integer) currentBalance).toString());

            if (resultHash.get(searchKey) != null) {
                return resultHash.get(searchKey);
            }

            int noFlip = this.flip(currentIndex - 1, currentBalance - A[currentIndex-1], A);
            int flip = this.flip(currentIndex - 1, currentBalance + A[currentIndex-1], A)+1;

            int result = Math.min(flip, noFlip);

            String key = ((Integer) currentIndex).toString().concat(":").concat(((Integer) currentBalance).toString());
            resultHash.put(key, result);
            return result;

        }

        public static void main (String[]args){
            int[] A = {15, 10, 6};
            System.out.println(new FlipArray().solve(A));
        }
    }

