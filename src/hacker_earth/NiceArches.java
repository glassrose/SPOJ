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
import java.util.ArrayDeque;

/**
 *
 * @author chandni
 */
public class NiceArches {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        int cnt = 0;
        
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int len = s.length();
            
            if (len%2==1)
                continue;
            
            ArrayDeque<Character> stack =
                        new ArrayDeque<>((int)Math.ceil((double)s.length()/2));
            
            for (int i=0; i<len; i++)
            {
                if (!stack.isEmpty() && stack.peek() == s.charAt(i))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            
            if (stack.size()==0)
                cnt++;
        }
        System.out.println (cnt);
    }
    
}
