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
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class APRIL14_POTATOES {

    private static boolean[] getPrimes(int maxVal) {
        boolean[] prime = new boolean [maxVal+1];
        Arrays.fill (prime, true);
        prime[0] = prime[1] = false;
        
        for (int i=2; i<=Math.sqrt(maxVal); i++)
        {
            if (prime[i])
            {
                for (int j=i*i; j<=maxVal; j+=i)
                    prime[j] = false;
            }
        }
        return prime;
    }
    
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        boolean [] prime = getPrimes (2010);
        
        for (int t=0;t<T;t++)
        {
            String split[] = br.readLine().split(" ");
            int x = Integer.parseInt (split[0]);
            int y = Integer.parseInt (split[1]);
            
            int i;
            for (i= x+y+1; !prime[i]; i++)
                ;
            System.out.println ( i-(x+y) );
        }
    }
    
    

}
