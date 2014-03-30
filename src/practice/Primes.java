/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class Primes {
    public static void main (String args[]) throws IOException
    {
//        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
//        int n = Integer.parseInt (br.readLine());
//        boolean []isPrime = getPrimes(n);
//        for (int i=0; i<isPrime.length; i++)
//            if (isPrime[i])
//                System.out.print (i+" ");
//        System.out.println();
        
        System.out.println (find11th11DigitPrimeNoInDigitsOfPI ());
    }

    //Returns Seive of Eratosthenes
    private static boolean[] getPrimes(int n) {
        boolean isPrime[] = new boolean [n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2;i<=Math.sqrt(n);i++)
            if (isPrime[i])
                for (int j=i*i; j<=n; j+=i)
                    isPrime[j] = false;
        
        return isPrime;
    }

    static boolean primesTill10pow6[];
    private static long find11th11DigitPrimeNoInDigitsOfPI() {
        primesTill10pow6 = getPrimes(1000000);
        
        String digits = getPITillNthDigit(10000);
        
        int cnt = 0;
        for (int i=0;i+11<=digits.length();i++)
        {
            Long num = Long.parseLong(digits.substring(i,i+11));
            if (isPrime (num))
                cnt++;
            if (cnt == 11)
                return num;
        }
        
        System.out.println ("Not reached!");
        return 0;
    }

    private static String getPITillNthDigit(int i) {
        BigDecimal pi = practice.Pi.pi(i);
        String res = "3"+pi.toPlainString().substring(2);
        return res;
    }

    private static boolean isPrime(long num) {
        for (int i=0;i<primesTill10pow6.length;i++)
        {
            if (primesTill10pow6[i])
            {
                if (num%i==0)
                    return false;
            }
        }
        return true;
    }
}
