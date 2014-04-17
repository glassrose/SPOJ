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
/* If input number is -1, print Kth Largest of the input numbers else keep calculating. Exit on -2 */
package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class FindKthLargestFromInfiniteNumbers {
    static final int K=5;
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        int minHeap[] = new int[K+1];
        //first fill the array with K elements.
        for (int i=1; i<=K; i++)
        {
            minHeap[i] = Integer.parseInt (br.readLine ());
        }
        
        buildMinHeap (minHeap);
        
        int n = Integer.parseInt (br.readLine());
        while (n!=-2)
        {
            if (n==-1)
                System.out.println (minHeap[1]);
            else
                if (n>minHeap[1])
                {
                    minHeap[1]=n;
                    minHeapify(minHeap, 1);
                }
            
            n = Integer.parseInt (br.readLine());
        }
    }

    private static void buildMinHeap(int[] minHeap) {
        for (int i=(minHeap.length-1)/2; i>=1; i--)
            minHeapify (minHeap, i);
    }


    private static void minHeapify(int[] minHeap, int i) {
        int l = i*2;
        int r = i*2+1;
        int smallest, len = minHeap.length;
        
        if (l<len && minHeap[l]<minHeap[i])
            smallest = l;
        else
            smallest = i;
        if (r<len && minHeap[r]<minHeap[smallest])
            smallest = r;
        
        if (smallest!=i)
        {
            minHeap[i]+=minHeap[smallest];
            minHeap[smallest]=minHeap[i]-minHeap[smallest];
            minHeap[i]=minHeap[i]-minHeap[smallest];
            
            minHeapify(minHeap, smallest);
        }
    }
}

