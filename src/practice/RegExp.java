/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Write a function in language of your choice that takes in two strings, and 
returns true if they match. Constraints are as follows: String 1, the text to 
match to, will be alphabets and digits. String 2, the pattern, will be 
alphabets, digits, '.' and '*'. '.' means either alphabet or digit will be
considered as a "match". "*" means the previous character is repeat 0 or more 
# of times. For example: Text: Facebook Pattern: F.cebo*k returns true.
*/
package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class RegExp {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s1 = br.readLine ();
        String s2 = br.readLine ();
        
        int l1 = s1.length ();
        int l2 = s2.length ();
        
        int ptr1=0, ptr2=0;
        boolean res = true;
        outerwhile: while (true)
        {
            if (ptr1==l1 && ptr2==l2)
                break;
            else if (ptr1 == l1 && ptr2<l2 || ptr1<l1 && ptr2==l2)
            {
                res = false;
                break;
            }
            else if ((('A' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= 'Z')
                            || ('a' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= 'z')
                            || ('0' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= '9'))
                    && (('A' <= s2.charAt (ptr2) && s2.charAt (ptr2) <= 'Z')
                            || ('a' <= s2.charAt (ptr2) && s2.charAt (ptr2) <= 'z')
                            || ('0' <= s2.charAt (ptr2) && s2.charAt (ptr2) <= '9')))
            {
                while (ptr1<l1 && ptr2<l2 && s1.charAt (ptr1) == s2.charAt (ptr2))
                {
                    ptr1++;
                    ptr2++;
                }
            }
            else if (ptr1<l1 && ptr2<l2 && s2.charAt (ptr2) == '.'
                        && (('A' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= 'Z')
                            || ('a' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= 'z')
                            || ('0' <= s1.charAt (ptr1) && s1.charAt (ptr1) <= '9')))
            {
                ptr1++;
                ptr2++;
            }
            else if (ptr1<l1 && ptr2<l2 && s2.charAt (ptr2) == '*')
            {
                char c = s1.charAt (ptr1-1);
                while (s1.charAt (ptr1)==c)
                    ptr1++;
                
                ptr2++;
                int s2c = 0;
                while (s2.charAt (ptr2+s2c) == c)
                {
                    s2c++;
                }
                if (s2c>0)
                {
                    for (int j=ptr1-s2c;j<ptr1;j++)
                        if (s1.charAt(j)!= c)
                        {
                            res = false;
                            break outerwhile;
                        }
                    ptr2+=s2c;
                }
            }
            else
            {
                res = false;
                break;
            }
        }
        System.out.println (res);
    }
}
