/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spoj;

import java.io.*;

/**
 *
 * @author chandni
 */
public class STPAR {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int n=0;
        try
        {
            n = Integer.parseInt(br.readLine());
        }
        catch (IOException e)
        {
            System.err.println ("Error reading line from console: "+ e);
        }
        
        while (n != 0)
        {
            String order;
            order = "";
            try
            {
                order = br.readLine();
            }
            catch (IOException e)
            {
                System.err.println ("Error reading line from console: "+ e);
            }
            
            String[] mobiles = order.split(" ");
            int[] mob = new int[mobiles.length];
            for (int i=0; i<mobiles.length; i++)
            {
                mob[i] = Integer.parseInt (mobiles[i]);
            }
            
            int find = 1;
            int stack[] = new int[n];
            int ptr = 0;
            
            for (int i=0;find<=n;)
            {
                if (i<n && (mob[i] == find))
                {
                    find++;
                    i++;
                }
                else if (ptr>0 && (stack[ptr-1] == find))
                {
                    find++;
                    ptr--;
                }
                else if (i<n && mob[i]>find)
                {
                    stack[ptr++] = mob[i++];
                    //find will remain same : keep finding same no.
                }
                else
                    break;
                
            }
            if (find == n+1)
                System.out.println("yes");
            else
                System.out.println("no");
            
            try
            {
                n = Integer.parseInt(br.readLine());
            }
            catch (IOException e)
            {
                System.err.println ("Error reading line from console: "+ e);
            }
        }
        
    }
    
}
