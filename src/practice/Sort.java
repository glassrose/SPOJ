/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class Sort {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String[] input = br.readLine ().split(" ");
        int len = input.length;
        Integer numbers[] = new Integer [len];
        
        for (int i=0; i<len; i++)
            numbers[i] = Integer.parseInt(input[i]);
        
        mergesort (numbers, 0, numbers.length);
        
        for (int i=0;i<len;i++)
        {
            System.out.print(numbers[i]);
            if (i<len-1)
                System.out.print (" ");
        }
        System.out.println();
    }

    private static void mergesort(Comparable[] array, int p, int r) {
        if (p<(r-1))
        {
            int q = (p+(r-1))/2; //or (p+(r-1-p)/2)
            mergesort(array, p, q+1);
            mergesort(array, q+1, r);
            merge (array, p, q, r);
        }
    }

    private static void merge(Comparable[] array, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q-1;
        
        Object[] a1 = new Object[n1];
        Object[] a2 = new Object[n2];
        
        for (int i=0;i<n1;i++)
            a1[i] = array[p+i];
        for (int i=0;i<n2;i++)
            a2[i] = array[q+1+i];
        
        int a1Cnt = 0, a2Cnt = 0;
        for (int i=p; i<r; i++)
        {
            if (a1Cnt==n1)
                array[i] = (Comparable)a2[a2Cnt++];
            else
                if (a2Cnt==n2)
                    array[i] = (Comparable)a1[a1Cnt++];
            else
            {
                if (((Comparable)a1[a1Cnt]).compareTo(a2[a2Cnt])<=0)//stable sort
                    array[i] = (Comparable)a1[a1Cnt++];
                else
                    array[i] = (Comparable)a2[a2Cnt++];
            }
        }
    }
}
