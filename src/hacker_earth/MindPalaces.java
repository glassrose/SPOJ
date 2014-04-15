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
 *
 * @author chandni
 */
public class MindPalaces {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s = br.readLine();
        String [] split = s.split(" ");
        int N = Integer.parseInt (split[0]);
        int M = Integer.parseInt (split[1]);
        
        int arr[][] = new int [N][M];
        for (int n=0; n<N; n++)
        {
            split = br.readLine().split(" ");
            for (int m=0; m<M; m++)
                arr[n][m] = Integer.parseInt (split[m]);
        }
        int Q = Integer.parseInt (br.readLine());
        outer:for (int q=0; q<Q; q++)
        {
            int num = Integer.parseInt (br.readLine());
            
            int i = 0, j = M-1;
            while (i<N && j>=0)
            {
                if (arr[i][j]==num)
                {
                    System.out.println(i+" "+j);
                    continue outer;
                }
                else
                    if (arr[i][j]<num)
                        i++;
                else
                        j--;
            }
            System.out.println ("-1 -1");
        }
    }
        
}
