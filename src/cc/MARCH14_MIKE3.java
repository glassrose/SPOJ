/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class MARCH14_MIKE3 {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s = br.readLine();
        String [] split = s.split(" ");
        int N = Integer.parseInt (split[0]);
        int M = Integer.parseInt (split[1]);
        
        Offer offers[] = new Offer[M];
        for (int m=0; m<M; m++)
        {
            offers[m] = new Offer (br.readLine());
        }
        
        Arrays.sort(offers);
        
        boolean checked [] = new boolean[N+1];
        int cnt=0;
        for (int i=0; i<M; i++)
        {
            boolean taken = false;
            for (int j=0; j<offers[i].stamps.length; j++)
            {
                if (checked[offers[i].stamps[j]])
                {
                    taken=true;
                    break;
                }
            }
            if (!taken)
            {
                cnt++;
                for (int j=0; j<offers[i].stamps.length; j++)
                    checked[offers[i].stamps[j]] = true;
            }
        }
        
        System.out.println(cnt);
    }

    private static class Offer implements Comparable<Offer>{
        int [] stamps;
        
        public Offer(String offerLine) {
            String split[] = offerLine.split(" ");
            stamps = new int[Integer.parseInt(split[0])];
            
            for (int i = 1; i < split.length; i++)
                stamps[i-1] = Integer.parseInt(split[i]);
        }

        @Override
        public int compareTo(Offer o) {
            if (this.stamps.length < o.stamps.length)
                return -1;
            else
                if (this.stamps.length > o.stamps.length)
                    return 1;
            return 0;
        }
    }
}
