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

package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class APRIL14_BINTREE {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        for (int t=0;t<T;t++)
        {
            String split[] = br.readLine().split(" ");
            int x = Integer.parseInt (split[0]);
            int y = Integer.parseInt (split[1]);
            
            int res = 0;
            int hi = Math.max(x,y);
            int lo = Math.min(x,y);
            int loLevel = (int)(Math.log10(lo)/Math.log10(2));
            int hiLevel = (int)(Math.log10(hi)/Math.log10(2));
            while (((int)(Math.log10(hi)/Math.log10(2))-(int)(Math.log10(lo)/Math.log10(2)))>0)
            {
                hi>>=1;
                res++;
            }
            while (hi != lo)
            {
                hi>>=1;
                lo>>=1;
                res+=2;
            }
            
            System.out.println(res);
        }
    }       
}
