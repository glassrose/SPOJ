/*
 * The MIT License
 *
 * Copyright 2014 chandni.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hacker_earth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class InLoveWithPrimes {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        boolean primes[] = getPrimes (100000);
        for (int t=1; t<=T; t++)
        {
            int n = Integer.parseInt (br.readLine ());
            boolean ArjitWins = true;
            for (int i=2; i<=n/2; i++)
                if (primes[i]&&primes[n-i])
                {
                    ArjitWins = false;
                    break;
                }
            if (ArjitWins)
                System.out.println("Arjit");
            else
                System.out.println("Deepa");
        }
    }

    private static boolean[] getPrimes(int n) {
        boolean [] primes = new boolean [n+1];
        Arrays.fill (primes, true);
        primes[0] = primes [1] = false;
        
        for (int i=2; i<=Math.sqrt(n); i++)
            if (primes[i])
                for (int j=i*i; j<=n; j+=i)
                    primes[j] = false;
        return primes;
    }
}
