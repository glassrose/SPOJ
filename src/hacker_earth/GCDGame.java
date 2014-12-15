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
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * url: http://www.hackerearth.com/thoughtworks-hiring-challenge/algorithm/gcd-game-11/
 * @author chandni
 */
public class GCDGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        for (int t=0; t<T; t++)
        {
            String[] split = br.readLine().split(" ");
            int A = Integer.parseInt (split[0]);
            int B = Integer.parseInt (split[1]);
            
            boolean playerA = true;
            while (A!=1 && B!=1)
            {
                int gcd = gcd (A, B);
                if (playerA)
                {
                    if (gcd>1)
                    {
                        if (B-1==1)
                            B--;
                        else
                            B/=gcd;
                    }
                    else if (gcd==1)
                        B--;
                }
                else
                {
                    if (gcd>1)
                    {
                        if (A-1==1)
                            A--;
                        else
                            A/=gcd;
                    }
                    else if (gcd==1)
                        A--;
                }
                playerA = !playerA;
            }
            if (A==1 && B==1)
                System.out.println ("Draw");
            else
                if (A==1)
                    System.out.println("Chandu Don");
            else
                    System.out.println("Arjit");
        }
    }

    private static int gcd(int A, int B) {
        if (B==0) return A;
        return gcd(B, A%B);
    }
    
}
