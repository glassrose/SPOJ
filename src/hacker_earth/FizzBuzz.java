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
public class FizzBuzz {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        String s = br.readLine();
        String[] Ns = s.split(" ");
        int N;
        for (int t =0; t<T; t++)
        {
            N = Integer.parseInt (Ns[t]);
            for (int i=1; i<=N; i++)
            {
                if (i%15==0)
                    System.out.println("FizzBuzz");
                else
                    if (i%3 == 0)
                        System.out.println("Fizz");
                else
                        if (i%5 == 0)
                            System.out.println("Buzz");
                else
                            System.out.println(i);
            }
        }
    }
}
