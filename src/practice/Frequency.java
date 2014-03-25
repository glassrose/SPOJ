/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

1st number is the number to find the frequency of in the space 
seperated array of numbers to follow in the next line.
 */

package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chandni
 */
public class Frequency {
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int n = Integer.parseInt (br.readLine());
        String s = br.readLine();
        String nums[] = s.split(" ");
        
        int num[] = new int[nums.length];
        for (int i=0; i<nums.length; i++)
        {
            num[i] = Integer.parseInt(nums[i]);
        }
        
        int leftLoc = binarySearchLeftEnd (num, n);
        int rightLoc = binarySearchRightEnd (num, n);
        if (leftLoc==-1)
            System.out.println(0);
        else
            System.out.println(rightLoc-leftLoc+1);
    }

    private static int binarySearchRightEnd(int[] num, int n) {
        int lo = 0;
        int hi = num.length-1;
        int mid;
        while (lo<=hi)
        {
            mid = lo+(hi-lo)/2;
            if (num[mid] == n)
            {
                if ((mid+1)<num.length && (num[mid+1])>n)
                    return mid;
                else
                    if (mid == num.length-1)
                        return mid;
                else
                        lo = mid+1;
            }
            else if (num[mid]>n)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return -1;
    }

    private static int binarySearchLeftEnd(int[] num, int n) {
        int lo = 0;
        int hi = num.length-1;
        int mid;
        while (lo<=hi)
        {
            mid = lo+(hi-lo)/2;
            if (num[mid] == n)
            {
                if ((mid-1)>=0 && (num[mid-1])<n)
                    return mid;
                else
                    if (mid == 0)
                        return mid;
                else
                        hi = mid-1;
            }
            else if (num[mid]>n)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return -1;
    }
}
