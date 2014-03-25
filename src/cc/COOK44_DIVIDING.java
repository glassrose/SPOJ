/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class COOK44_DIVIDING {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int N = Integer.parseInt (br.readLine());
        
        String line[] = br.readLine().split(" ");
        int stampSum = 0;
        for (int i=0; i<line.length; i++)
            stampSum+=Integer.parseInt(line[i]);
        
        System.out.println (stampSum == (N*(N+1))/2 ? "YES" : "NO");
    }
}
