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

//Finding the transition points 0 to 1 and 1 to 2 in an infinite array of sorted numbers 0, 1 and 2.
//Worst time complexity : O(lg(n))

package practice;


/**
 *
 * @author chandni
 */
public class Transition012 {
    public static void main(String args[] ) {
        int [][]nos = {{0,0,0,1,1,1,1,2}, {}, {0,0,0,0}, {1,1,1},
                       {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2},
                       {0,0,0,0,0,0,0,2,2,2,2,2,2,2,2}};
        for (int i=0; i<nos.length; i++)
        {
            int []pts = getBothTransitionPoints (nos[i]);
            System.out.println (pts[0]+" "+pts[1]);
        }
    }

    private static int[] getBothTransitionPoints(int[] nos) {
        int pts[] = {-1,-1};//return -1 if 1s or 2s are absent altogether, respectively.
        int i;
        
        outer:for (i = 1; Math.pow (2, i-1)<nos.length; i++)/*dealing with infinite*/
        {
            //finding the beginning of 1s
            if (nos[Math.min((int)Math.pow (2,i), nos.length-1)] >= 1)
            {
                //We will find transition point between nos[2^(i-1)] and nos[2^(i)]
                int lo = i==1 ? 0 : (int)Math.pow (2, i-1);
                int hi = Math.min ((int)Math.pow (2,i), nos.length-1);
                
                int pos1 = binSearch (lo, hi, nos, 1); // first find any 1
                if (pos1 == -1)
                    break;//1 not found
                
                //find transition point 0-1
                hi = pos1;//new high
                
                //modified binary search
                while (lo<=hi)
                {
                    int mid = lo+(hi-lo)/2;
                    if (nos[mid] == 1)
                    {
                        if ((mid-1)>=0 && nos[mid-1]==0)
                        {
                            pts[0] = mid;
                            break outer;
                        }
                        else
                            if (mid == 0)
                            {
                                pts[0] = mid;
                                break outer;
                            }
                        else
                                hi = mid-1;
                    }
                    else
                        if (nos[mid] < 1)//to be explicit
                            lo = mid+1;
                    else//no scope of reaching here.
                            ;//do nothing
                }

            }
        }
        
        outer2:for (i = Math.max (1, i-2); Math.pow (2, i-1)<nos.length; i++)/*dealing with infinite*/
        {                  
            //finding the beginning of 2s
            if (nos[Math.min((int)Math.pow (2,i), nos.length-1)] == 2)
            {
                //We will find transition point between nos[2^(i-1)] and nos[2^(i)]
                int lo = i==1 ? 0 : (int)Math.pow (2, i-1);
                int hi = Math.min ((int)Math.pow (2,i), nos.length-1);

                int pos2 = binSearch (lo, hi, nos, 2); // first find any 2
                if (pos2 == -1)
                    break;//2 not found

                //find transition point 1-2 or 0-2
                hi = pos2;//new high

                //modified binary search
                while (lo<=hi)
                {
                    int mid = lo+(hi-lo)/2;
                    if (nos[mid] == 2)
                    {
                        if ((mid-1)>=0 && nos[mid-1]<2)
                        {
                            pts[1] = mid;
                            break outer2;
                        }
                        else
                            if (mid == 0)
                            {
                                pts[1] = mid;
                                break outer2;
                            }
                        else
                                hi = mid-1;
                    }
                    else
                        if (nos[mid] < 2)//to be explicit
                            lo = mid+1;
                    else//no scope of reaching here.
                            ;//do nothing
                }
            }
        }
        return pts;
    }

    private static int binSearch(int lo, int hi, int[] nos, int i) {
        while (lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if (nos[mid]==i)
                return mid;
            else
                if (nos[mid]<i)
                    lo = mid+1;
            else
                    hi = mid-1;
        }
        return -1;
    }
}
