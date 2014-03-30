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
public class ANeedleInTheHaystack {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        for (int t =0; t<T; t++)
        {
            String pattern = br.readLine ();
            String text = br.readLine ();
            byte freq[] = new byte[26];
            byte pFreq[] = new byte[26];
            
            int cnt = 0;
            for (int i=0; i<pattern.length(); i++)
            {
                pFreq[pattern.charAt(i)-'a']++;
                freq[text.charAt(i)-'a']++;
                
            }
            if (freqMatch (pFreq, freq))
                cnt++;
            
            for (int i=1; i+pattern.length()-1<text.length(); i++)
            {
                freq[text.charAt(i-1)-'a']--;
                freq[text.charAt(i+pattern.length()-1)-'a']++;
                if (freqMatch(pFreq, freq))
                    cnt++;
                if (cnt > 0)
                {
                    break;
                }
            }
            
            if (cnt == 0)
                System.out.println("NO");
            else
                System.out.println ("YES");
        }
    }

    private static boolean freqMatch(byte[] pFreq, byte[] freq) {
        boolean match = true;
        for (int i=0;i<26;i++)
        {
            if (pFreq[i] != freq[i])
            {
                match = false;
                break;
            }
        }
        return match;
    }
}
