/*
 * The MIT License
 *
 * Copyright 2014 chandni.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author chandni
 */
public class LittleBearAndStrings {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String S, T1, T2;
        while (!(S = br.readLine()).equals(""))
        {
            T1 = br.readLine();
            T2 = br.readLine();
            
            Set set = new HashSet();
            for (int i=0; i<S.length(); i++)
            {
                i = S.indexOf(T1, i);
                for (int j=i; j<S.length(); j++)
                {
                    j = S.indexOf(T2, j);
                    String good = S.substring(i, j+T2.length());
                    set.add(good);
                }
            }
            
            System.out.println(set.size());
        }
    }
}
