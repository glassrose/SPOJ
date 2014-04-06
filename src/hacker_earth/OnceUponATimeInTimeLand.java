/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* http://www.hackerearth.com/problem/algorithm/once-upon-a-time-in-time-land/ */

package hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class OnceUponATimeInTimeLand {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        for (int t =0; t<T; t++)
        {
            String s = br.readLine();
            String var[] = s.split(" ");
            int N = Integer.parseInt (var[0]);
            int K = Integer.parseInt (var[1]);
            
            var = br.readLine().split(" ");
            int slips[] = new int[N];
            for (int i=0; i<N; i++)
            {
                slips[i] = Integer.parseInt(var[i]);
                //slips[i] = Math.max(slips[i], 0);//Zero negatives
            }
            
            
            long dp[] = new long[N];
            dp[0] = Math.max(slips[0], 0);
            for (int i=1; i<N; i++)
            {
                if (i<=K)
                    dp[i] = Math.max(slips[i], dp[i-1]);
                else
                {
                    dp[i] = Math.max (dp[i-1], slips[i]+dp[i-K-1]);
                }
            }
            
            System.out.println (dp[N-1]);
        }
    }
}
