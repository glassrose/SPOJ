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
//TLE :(
package hacker_earth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class WeirdFunction {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        for (int t=1; t<=T; t++)
        {
            String split[] = br.readLine().split (" ");
            int a = Integer.parseInt (split[0]);
            int b = Integer.parseInt (split[1]);
            
            int ans = 0;
            for (int i=a; i<=b; i++)
            {
                ans+=(MW(i)%1000000007);
            }
            ans%=1000000007;
            System.out.println(ans);
        }
    }

    private static long MW(int i) {
        long res = 0;
        for (int j=1; j<=i; j++)
        {
            if (GCD(j,i)==j)
                res+=Math.pow(j, i);
        }
        return res;
    }

    private static int GCD(int j, int i) {
        if (i==0)
            return j;
        return GCD(i, j%i);
    }
}
