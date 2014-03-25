/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class Primes {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int n = Integer.parseInt (br.readLine());
        boolean []isPrime = getPrimes(n);
        for (int i=0; i<isPrime.length; i++)
            if (isPrime[i])
                System.out.print (i+" ");
        System.out.println();
    }

    //Returns Seive of Eratosthenes
    private static boolean[] getPrimes(int n) {
        boolean isPrime[] = new boolean [n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2;i<n;i++)
            if (isPrime[i])
                for (int j=i*i; j<=n; j+=i)
                    isPrime[j] = false;
        
        return isPrime;
    }
}
