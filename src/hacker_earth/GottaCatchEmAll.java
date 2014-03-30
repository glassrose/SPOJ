/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chandni
 */
public class GottaCatchEmAll {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        

        String[] times = br.readLine ().split(" ");
        Integer time[] = new Integer[times.length];
        int totTime[] = new int[times.length];

        int res=0;
        for (int i=0; i<T; i++)
        {
            time[i] = Integer.parseInt(times[i]);
        }
        
        Arrays.sort (time, Collections.reverseOrder());
        
        for (int i = 0; i<time.length; i++)
        {
            totTime[i] = (i+1) + (time[i]) + (1);
            res = totTime[i]>res?totTime[i]:res;
        }
        System.out.println(res);
    }
}
