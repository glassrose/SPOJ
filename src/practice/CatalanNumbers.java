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

/**
 *
 * @author chandni
 */
public class CatalanNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10;
        for (int i=1; i<=n; i++)
        {
            System.out.println ("Catalan number "+i+" is         : "+ getCatalanNumber (i));
            System.out.println ("Binary Trees with "+i+" nodes is: "+ countTrees (i));//Structurally unique
        }
    }

    public static long getCatalanNumber(int n) {
        int C=1;
        for (int i=1; i<=n; i++)
        {
            C = (2*(2*(i-1)+1)*C/((i-1)+2));
        }
        return C;
    }
    
    public static int countTrees(int numKeys) { 
    if (numKeys <=1) { 
      return(1); 
    } 
    else { 
      // there will be one value at the root, with whatever remains 
      // on the left and right each forming their own subtrees. 
      // Iterate through all the values that could be the root... 
      int sum = 0; 
      int left, right, root;

      for (root=1; root<=numKeys; root++) { 
        left = countTrees(root-1); 
        right = countTrees(numKeys - root);

        // number of possible trees with this root == left*right 
        sum += left*right; 
      }

      return(sum); 
    } 
  } 
    
}
