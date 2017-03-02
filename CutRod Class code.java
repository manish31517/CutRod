import java.util.ArrayList;


/*
   Class: CutRod

   Explores dynamic programming using the example of cutting a rod

   Author:  Melany Diaz
   with assistance from: hafizur-rahman
   Creation date:  2/22/2016

   Modifications:
        Date         Name          reason
        2/25/2016    Melany Diaz   Added printCutRodSolution(p,n)
        2/27/2016	 Melany Diaz   Added prices for lengths 11-15
*/


/**
 * Given a rod of length n and an array that contains the prices of all 
 * the pieces of size smaller than n, this will determine the 
 * maximum value abtainable by cutting the rod and selling the pieces.
 *
 @author Melany Diaz
 */
public class CutRod
{

    /**
     * a bottom-up method for cutRod
     * @param  price, price table
     * @param  rodLength, rod size n
     */
    private static ArrayList<Integer> cutRod(int[] price, int rodLength) {
    	//let val[0..n] and s[0..n] be new arrays
        int[] val = new int[rodLength + 1];
        int[] cuts = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int maxVal = Integer.MIN_VALUE;

            for (int j = 1; j <= i; j++) {
                int tmp = price[j - 1] + val[i - j];
                if (tmp > maxVal) {
                    maxVal = tmp;

                    cuts[i] = j;
                }
            }

            val[i] = maxVal;
        }

        //PRINT-CUT-ROD-SOLUTION(p,n)
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        int n = rodLength;
        while (n > 0) {
            sizes.add(cuts[n]);
            n = n - cuts[n];
        }
        return sizes;
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for (int y = 1; y <= 15; y++){
        ArrayList<Integer> sizes = cutRod(price, y);

        int totalPrice = 0;
        for (int s : sizes) {
            totalPrice += price[s-1];
        }

        System.out.println("Length: " + y + " Value: " + totalPrice+ " Cuts " + sizes);
    }
}
}