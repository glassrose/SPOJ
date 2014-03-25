/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Prints all unique subsets of the string. 
Given a string write a function which prints all the subsets of the string. 
Now make the function to return only unique solutions
*/
package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author chandni
 */
public class UniqueStrSubsets {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s = br.readLine ();
        
        int len = s.length ();
        Set<String> set = new HashSet<> ();
        for (int i=0; i<Math.pow(2, len); i++)
        {
            int num = i, cnt=0;
            StringBuilder str = new StringBuilder ("");
            while (num>0)
            {
                if ((num&1)==1)
                {
                    str.append(s.charAt (cnt));
                }
                cnt++;
                num>>=1;
            }
            set.add (str.toString()); 
            /*We add String objects since StringBuilder's equals checks 
              if they are the same object or not and same character sequences 
              appear more than once in results. */
        }
        
        for (String str:set)
        {
            System.out.println (str);
        }
    }
}
