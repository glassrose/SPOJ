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
public class IdenticalTrees {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<Integer>(1);
        root1.left = new BinaryTreeNode<>(2);
        root1.right = new BinaryTreeNode<>(3);
        root1.left.left = new BinaryTreeNode<>(4);
        root1.left.right = new BinaryTreeNode<>(5);
        
        root2.left = new BinaryTreeNode<>(2);
        root2.right = new BinaryTreeNode<>(3);
        root2.left.left = new BinaryTreeNode<>(4);
        root2.left.right = new BinaryTreeNode<>(5);
        
        if (areIdentical(root1, root2))
//        if (areIdentical(null, null))
            System.out.println ("Identical");
        else
            System.out.println ("Not Identical");
    }
    
    public static boolean areIdentical (BinaryTreeNode<Integer> a,
            BinaryTreeNode<Integer> b)
    {
        if (a==null && b==null)
            return true;
        
        if (a!=null && b==null || a==null && b!=null)
            return false;
        
        return a.data==b.data && areIdentical(a.left, b.left) &&
                areIdentical(a.right, b.right);
    }
}
