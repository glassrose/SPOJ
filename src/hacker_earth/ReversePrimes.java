/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* http://www.hackerearth.com/india-hacks-2014/approximate/reverse-primes/ */

package hacker_earth;

import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class ReversePrimes {
    public static void main (String args[])
    {
        boolean prime[] = getPrimes (10000000);
        int cnt = 0;
        for (int i=2;i<prime.length; i++)
        {
            int rev;
            if (prime[i] && prime[rev=reverse(i)] && rev > i)
            {
                System.out.println (i);
                prime[rev] = false;
                cnt++;
                if (cnt==1000000)
                    break;
            }
        }
    }

    private static boolean[] getPrimes(int n) {
        boolean seive[] = new boolean [n+1];
        Arrays.fill(seive, true);
        seive[0] = seive[1] = false;
        
        for (int i=0; i<=Math.sqrt(n); i++)
        {
            if (seive[i])
            {
                for (int j=i*i; j<=n; j+=i)
                    seive[j] = false;
            }
        }
        return seive;
    }

    private static int reverse(int n) {
        int res = 0;
        while (n!=0)
        {
            res = res*10+ (n%10);
            n /= 10;
        }
        return res;
    }
}
