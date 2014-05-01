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

//To find the maximum of the sum of nodes of any of the paths from root to leaves in a binary tree
// Worst time complexity = O(no. of Nodes)

package practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

/**
 *
 * @author chandni
 */
class Node{
    int key;
    Node left;
    Node right;
    boolean isLeaf;
}

public class MaximumSumPathInBinaryTree {
    public static void main(String args[] ) {
        Node nodes[] = new Node[2];
        
        Node root = new Node ();
            root.key = 10;
            root.left = new Node ();
                root.left.key = 5;
                root.left.left = new Node ();
                    root.left.left.key = 15;
                    root.left.left.isLeaf = true;

            root.right = new Node ();
                root.right.key = 20;
                root.right.left = new Node ();
                    root.right.left.key = 3;
                    root.right.left.isLeaf = true;
                root.right.right = new Node ();
                    root.right.right.key = 1;
                    root.right.right.isLeaf = true;
        
        nodes[0] = root;
        
        root = new Node ();
            root.key = 1;
            root.left = new Node ();
                root.left.key = 2;
                root.left.left = new Node ();
                    root.left.left.key = 4;
                    root.left.left.isLeaf = true;
                root.left.right = new Node ();
                    root.left.right.key = 5;
                    root.left.right.isLeaf = true;

            root.right = new Node ();
                root.right.key = 3;
                root.right.left = new Node ();
                    root.right.left.key = 6;
                    root.right.left.isLeaf = true;
                root.right.right = new Node ();
                    root.right.right.key = 7;
                    root.right.right.isLeaf = true;
        nodes[1] = root;
                    
        for (int i=0; i<nodes.length; i++)
            System.out.println( getMaximumSumPath (nodes[i]) );
    }

    private static int getMaximumSumPath(Node root) {
        Deque<Node> stack= new ArrayDeque<> ();
        ArrayList<Integer> al= new ArrayList<> ();
        
        stack.push(root);
        while (stack.peek()!= null)
        {
            Node top = stack.peek();
            if (top.left==null && top.right== null)
            {
                if (top.isLeaf)
                    sumUp (stack, al);
                stack.pop();
                if (stack.peek()!= null && stack.peek().left!=null)
                    stack.peek().left=null;
                else
                    if (stack.peek()!= null && stack.peek().right!=null)
                        stack.peek().right=null;
            }
            else
            {
                if (top.left!=null)
                {
                    stack.push(top.left);
                    continue;
                }
                if (top.right!=null)
                {
                    stack.push (top.right);
                }
            }
        }
        
        int res = 0;
        for (Iterator itr = al.iterator(); itr.hasNext();)
            res = Math.max(res, (Integer)itr.next());
        
        return res;
    }

    private static void sumUp(Deque<Node> stack, ArrayList<Integer> al) {
        int sum = 0;
        for (Iterator itr = stack.iterator(); itr.hasNext (); )
            sum+=((Node)itr.next()).key;
        al.add(sum);
    }
}
