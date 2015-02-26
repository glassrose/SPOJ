/*
 * The MIT License
 *
 * Copyright 2015 chandni.
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

package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class MinimizeExpressionModK {
    static boolean table[][];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String split[] = br.readLine().split(" ");
        int n = split.length;
        int[] operands = new int[n];
        for (int i=0; i<split.length; i++)
            operands[i] = Integer.parseInt(split[i]);
            
        int K = Integer.parseInt(br.readLine());
        
        /* table is a lookup table that keeps a track of which all remainders
           (js) are possible for an expression containing first i elements(0 to i-1).
        
           table is a member of class so all it's initial values default to 0.*/
        table = new boolean[n+1][K];
        for (int i=1; i<=n; i++)
        {
            if (i==1)
            {
                int thisOperand = operands[i-1]%K;
                table [i][thisOperand<0?thisOperand+K:thisOperand] = true;
            }
            else
                for (int j=0; j<K; j++)
                    if (table [i-1][j])
                    {
                        int thisOperand = operands[i-1]%K;
                        table [i][(j+ (thisOperand<0?thisOperand+K:thisOperand))%K] = true;
                        
                        int subtractionResidue = (j-(operands[i-1]%K))%K;
                        table [i][subtractionResidue<0?subtractionResidue+K:subtractionResidue] = true;
                    }
        }
        
        //for debugging
        for (int i=0; i<=n; i++)
        {
            for (int j=0; j<K; j++)
                System.out.print ((table[i][j]?1:0)+" ");
            System.out.println();
        }
        
        for (int j=0; j<K; j++)
            if (table [n][j])
            {
                System.out.println (j);
                break;
            }
    }
    
}
