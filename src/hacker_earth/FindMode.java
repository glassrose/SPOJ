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
public class FindMode {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        for (int t=1; t<=T; t++)
        {
            int N = Integer.parseInt (br.readLine ());
            String split[] = br.readLine().split (" ");
            
            int freq[] = new int [1000001];
            int max = 0;
            for (String split1 : split) {
                int num = Integer.parseInt(split1);
                freq[num]++;
                max = Math.max(max, freq[num]);
            }
            
            for (int i=freq.length-1; i>=1; i--)
                if (freq[i]==max)
                    System.out.print (i+" ");
            
            System.out.println();
        }
    }
}
