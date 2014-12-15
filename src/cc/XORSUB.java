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
//NZEC and WA
package cc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chandni
 */
public class XORSUB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        for (int t=0; t<T; t++)
        {
            String split[] = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int K = Integer.parseInt(split[1]);
            split = br.readLine().split(" ");
            Integer arr[] = new Integer[N];
            for (int i=0; i<N; i++)
                arr[i] = Integer.parseInt (split[i]);
//            arr[N] = K;
            System.out.println (K^findMaxXORSum (arr));
        }
    }

    private static int findMaxXORSum(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());//Non-ascending
        
        int i=0, j;
        int firstPos = getFirstSetBitPos (arr[i]);
        if (firstPos==-1)
            return 0;//not possible as all elements are >1
        j = firstPos;
        while (i<arr.length && j>1)
        {
            
            int mask = 1<<j;
            
            if ((arr[i]|mask)==0)//this column is 0
            {
                int r;
                for (r=i+1; (arr[r]|mask)==0; r++)
                    ;
                //swap
                if (r<arr.length)
                {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                else
                {
                    j++;
                    continue;
                }
            }
            
            //make sure that no lower number has this bit set; r for row
            for (int r=i+1; r<arr.length && (arr[r]|mask)>0; r++)
                arr[r]^=arr[j];
            
            i++;
            j--;
        }
        
        int mask = 1<<firstPos;
        int result = arr[0];
        for (i=1; i<arr.length && mask>0; i++)
        {
            if ((result|mask)==0)
                result^=arr[i];
            mask>>=1;
        }
        
        return result;
    }

    //i is positive
    private static int getFirstSetBitPos(Integer i) {
        int pos = -1;
        while (i!=0)
        {
            pos++;
            i>>=1;
        }
        return pos;
    }
    
}
