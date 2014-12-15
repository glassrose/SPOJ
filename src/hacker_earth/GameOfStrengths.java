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

/**
 *
 * @author chandni
 */
public class GameOfStrengths {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        for (int t=1; t<=T; t++)
        {
            br.readLine ();
            String split[] = br.readLine().split (" ");
            int len = split.length;
            int A[] = new int[len];
            int maxS = 0;
            for (int i=0; i<len; i++)
            {
                A[i] = Integer.parseInt (split[i]);
                maxS = Math.max (maxS, A[i]);
            }
            
            int sum = 0;
            for (int i=0; i<len-1; i++)
                for (int j=i+1; j<len; j++)
                {
                    sum+=(Math.abs(A[i]-A[j]));
                }
            sum*=maxS;
            sum%=1000000007;
            
            System.out.println(sum);
        }
    }
}
