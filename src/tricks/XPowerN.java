/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
O(ln N) solution to calculate Nth power of a number.
*/
package tricks;

/**
 *
 * @author chandni
 */
public class XPowerN {
    public static void main (String args[])
    {
        int X = 5, N = 4;
        if (args.length >= 2)
        {
            X = Integer.parseInt (args[0]);
            N = Integer.parseInt (args[1]);
        }
        
        System.out.println (X+" raised to the power "+ N +" is : "+pow(X,N));
    }

    private static long pow(int X, int N) {
        if (N == 0)
            return 1;
        
        long accumulator = 1, S=X;
        while (N != 0)
        {
            if ((N&1) == 1)
            {
                accumulator *=S;
            }
            S*=S;
            N>>=1;
        }
        return accumulator;
    }
}
