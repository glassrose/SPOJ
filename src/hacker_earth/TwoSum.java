/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class TwoSum {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        for (int t =0; t<T; t++)
        {
            String s = br.readLine();
            String nums[] = s.split(" ");
            int a = Integer.parseInt (nums[0]);
            int b = Integer.parseInt (nums[1]);
            System.out.println(a+b);
        }
    }
}
