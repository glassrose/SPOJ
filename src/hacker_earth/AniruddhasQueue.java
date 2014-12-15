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

/**
 *
 * @author chandni
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;


class AniruddhasQueue {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String split[] = br.readLine().split (" ");
            int days[] = new int[N];
            long sum = 0;
            for (int i=0; i<N; i++)
            {
            	days[i] = Integer.parseInt (split[i]);
                sum+=days[i];
            }
            long M = Long.parseLong(br.readLine());
            M%=sum;
            
            int dayNo = 0;
            while (M>0)
            {
                M-=days[dayNo];
                dayNo = nextDay(N, dayNo);
            }
            dayNo--;
            if (dayNo==-1) dayNo=N-1;
            System.out.println (dayNo+1);
        }
    }
    
    public static int nextDay (int N, int dayNo)
    {
        dayNo++;
        if (dayNo == N)
            return 0;
        return dayNo;
    }
}

