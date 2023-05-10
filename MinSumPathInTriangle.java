import java.lang.reflect.Array;
import java.util.ArrayList;

public class MinSumPathInTriangle {
    private ArrayList<ArrayList<Integer>> givenArray=new ArrayList<ArrayList<Integer>>();
    public int minimumTotal(ArrayList<ArrayList<Integer>> a){
        Integer N = a.size();
        Integer M = a.get(a.size()-1).size();

        ArrayList<ArrayList<Integer>> dp_array = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<M; i++){
            ArrayList<Integer> dp_row = new ArrayList<Integer>();
            for(int j=0; j<M; j++){
                dp_row.add(0);
            }
            dp_array.add(dp_row);
        }

        int result = Integer.MAX_VALUE;
        for(int j=M-1; j>=0; j--){
            result = Math.min(result, this.solve(N-1, j, dp_array=dp_array, givenArray=a));
        }
        return result;
        /*
        int result = 0;
        int currentValue = Integer.MAX_VALUE;
        int currentIndex = 0;
        for(int i=0; i<N; i++){
            currentValue = Integer.MAX_VALUE;
            int j_start = Math.max(0,currentIndex-1);
            int j_end = Math.min(currentIndex+1,a.get(i).size()-1);
            for(int j=j_start; j<=j_end; j++){
                if(currentValue >= a.get(i).get(j)){
                    currentIndex = j;
                    currentValue = a.get(i).get(j);
                }
            }
            result += currentValue;
        }
        return result;

         */

    }

    public int solve(int i, int j, ArrayList<ArrayList<Integer>> dp_array, ArrayList<ArrayList<Integer>> givenArray){
        if(i<0 | j>i | j< 0){
            return Integer.MAX_VALUE;
        }


        if(i==0 & j==0){
            return givenArray.get(i).get(j);
        }

        if(dp_array.get(i).get(j) != 0){return dp_array.get(i).get(j);};

        int value = givenArray.get(i).get(j) +
                Math.min(   this.solve(i-1, j-1, dp_array, givenArray),
                            this.solve(i-1,  j, dp_array, givenArray));

        ArrayList<Integer> currentRow = dp_array.get(i);

        currentRow.set(j, value);

        return value;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a_sublist = new ArrayList<Integer>();
        a_sublist.add(2);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(6);
        a_sublist.add(6);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(7);
        a_sublist.add(8);
        a_sublist.add(4);
        a.add(a_sublist);
/*
        a_sublist = new ArrayList<Integer>();
        a_sublist.add(8);
        a_sublist.add(3);
        a_sublist.add(9);
        a_sublist.add(0);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(5);
        a_sublist.add(2);
        a_sublist.add(2);
        a_sublist.add(7);
        a_sublist.add(3);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(7);
        a_sublist.add(9);
        a_sublist.add(0);
        a_sublist.add(2);
        a_sublist.add(3);
        a_sublist.add(9);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(9);
        a_sublist.add(7);
        a_sublist.add(0);
        a_sublist.add(3);
        a_sublist.add(9);
        a_sublist.add(8);
        a_sublist.add(6);
        a.add(a_sublist);

        a_sublist = new ArrayList<Integer>();
        a_sublist.add(5);
        a_sublist.add(7);
        a_sublist.add(6);
        a_sublist.add(2);
        a_sublist.add(7);
        a_sublist.add(0);
        a_sublist.add(3);
        a_sublist.add(9);
        a.add(a_sublist);*/
         MinSumPathInTriangle solution = new MinSumPathInTriangle();
        System.out.println(solution.minimumTotal(a));
    }

    /*
    8 9 3 8 0 2 4 8 3 9 0 5 2 2 7 3 7 9 0 2 3 9 9 7 0 3 9 8 6 5 7 6 2 7 0 3 9

                 {                      { 9 },                              9
                                      { 3,  8 },                            3
                                    { 0,  2,   4 },                         0
                                   { 8,    3,   9,   0 },                   3
                               { 5,    2,   2,   7,   3 },                  2
                              { 7,    9,   0,   2,   3,   9 },              0
                            { 9,      7,   0,   3,   9,   8,   6 },         0
                          { 5,   7,   6,   2,   7,   0,     3,   9 } }      2


     */
    public Integer solve(Integer i, Integer j){
        /*
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }
        if(i>=givenArray.size() || j >= givenArray.get(givenArray.size()-1).size()){
            return Integer.MAX_VALUE;
        }
        Integer currentValue = this.givenArray.get(i).get(j)
        Integer result = currentValue + Math.min(this.solve(i+1, j-1), this.solve(i+1, j+1);
        return result;
        */
        return 0;
    }
}
