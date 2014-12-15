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
public class BreakupApp {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int N = Integer.parseInt (br.readLine());
        
        int wtage[] = new int[32];
        for (int n=0;n<N;n++)
        {
            String split[] = br.readLine().split(" ");
            int wt=split[0].charAt(0)=='G'?2:1;
            
            for(int i=1;i<split.length;i++)
            {
                int num=0;
                try{
                    num=Integer.parseInt(split[i]);
                }
                catch (NumberFormatException nfe)
                {
                    continue;
                }
                if (1<=num && num<=31)
                    wtage[num]+=wt;
            }
        }
        
        int max=0, cnt=0, maxVal=0;
        for (int i=1;i<wtage.length;i++)
        {
            if (wtage[i]>max)
            {
                max = wtage[i];
                maxVal = i;
            }
        }
        for (int i=0;i<wtage.length;i++)
            if (wtage[i]==max)
                cnt++;
        if (cnt>1)
            System.out.println("No Date");
        else
            if (maxVal==19 || maxVal==20)
                System.out.println("Date");
        else
                System.out.println("No Date");
    }
}
