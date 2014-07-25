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
// AC ;)
package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class PPATH {
    static boolean[] primes;
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s = br.readLine ();
        int T = Integer.parseInt (s);
        
        primes = getPrimes (9999);
        
        for (int t=0; t<T; t++)
        {
            String[] split = br.readLine().split(" ");
            int res = bfs (Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            if (res==-1)
                System.out.println ("Impossible");
            System.out.println (res);
        }
    }

    private static boolean[] getPrimes(int size) {
        boolean primes[] = new boolean[size+1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        
        for (int i=2; i<=Math.sqrt(size); i++)
            if (primes[i])
                for (int j=i*i; j<=size; j+=i)
                    primes[j] = false;
        
        return primes;  
    }

    private static int bfs(int start, int end) {
        if (start==end)
            return 0;
        
        ArrayDeque<PPathData> q = new ArrayDeque<PPathData>();
        boolean[] visited = new boolean[9999-1000+1];//all false
        
        q.add(new PPathData (start, 0));
        visited[start-1000] = true;
        
        int[] d= new int[4];
        while (!q.isEmpty())
        {
            PPathData out = q.pop();
            
            int st = out.num;
            d[0] = st%10;
            st/=10;
            d[1] = st%10;
            st/=10;
            d[2] = st%10;
            st/=10;
            d[3] = st;
            
            for (int i=3; i>=0; i--)
                for (int j=0; j<10; j++)
                {
                    if (i==3 && j==0)
                        continue;
                    
                    int newNum;
                    if (i==0)
                        newNum = d[3]*1000 + d[2]*100 + d[1]*10 +j;
                    else if (i==1)
                        newNum = d[3]*1000 + d[2]*100 + j*10 +d[0];
                    else if (i==2)
                        newNum = d[3]*1000 + j*100 + d[1]*10 +d[0];
                    else// (i==3)
                        newNum = j*1000 + d[2]*100 + d[1]*10 +d[0];
                    
                    if (newNum==end)
                        return out.distance+1;
                    if (primes[newNum] && !visited[newNum-1000])
                    {
                        q.add (new PPathData (newNum, out.distance+1));
                        visited[newNum-1000] = true;
                    }
                }
        }
        return -1;
    }
}

class PPathData
{
    int num;
    int distance;
    PPathData (int num, int distance)
    {
        this.num=num;
        this.distance=distance;
    }
}