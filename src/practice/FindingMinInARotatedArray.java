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

package practice;

/**
 *
 * @author chandni
 */
public class FindingMinInARotatedArray {
    public static void main (String args[])
    {
        int arr[][] = {{}, {4,5,6,7,1,2,3}, {1,2,3,4,5,6}, {0,1,2,3,4,5}};
        for (int[] arr1 : arr) {
            System.out.println(findMin(arr1, 0, arr1.length-1));
        }
    }

//    private static int findMin(int[] a, int lo, int hi) {
//        if (lo<hi)
//            return a[lo];
//        while (lo>=hi)
//        {
//            int mid = lo+(hi-lo)/2;
//            if (a[mid-1]>a[mid])
//                return mid;
//            
//        }
//    }
    
    private static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
           return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
           return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
           return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }
}
