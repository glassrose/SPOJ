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
public class MARCH14_TMSLT {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        for (int t =0; t<T; t++)
        {
            String s = br.readLine();
            String var[] = s.split(" ");
            int N = Integer.parseInt (var[0]);
            int a = Integer.parseInt (var[1]);
            int b = Integer.parseInt (var[2]);
            int c = Integer.parseInt (var[3]);
            int d = Integer.parseInt (var[4]);
            
            int stren[] = new int [N];
            stren[0] = d;
            
            for (int i=1;i<N;i++)
            {
                stren[i] = (int)((((long)a*Math.pow(stren[i-1], 2)) + (b*stren[i-1]) + c)%1000000);
            }
            
            //Arrays.sort(stren);
            stren = Sort.countingSort(stren, 1000000);
            
            long sum1=0, sum2=0;
            for (int i=0; i<N; i++)
            {
                if (i%2==0)//sum1
                    sum1+= stren[i];
                else
                    sum2+= stren[i];
            }
            
            System.out.println(Math.abs(sum1-sum2));
        }
    }
}

class Sort {
    public static void mergesort(Comparable[] array, int p, int r) {
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

    static int[] countingSort(int[] A, int maxVal) {
        int B[] = new int[A.length];
        int C[] = new int[maxVal+1];//all initialized to 0
        
        for (int i=0; i<A.length; i++)
            C[A[i]]++;
        
        for (int i=1; i<C.length; i++)
            C[i]+=C[i-1];
        
        for (int i=A.length-1; i>=0; i--)
        {
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        
        return B;
    }
}
