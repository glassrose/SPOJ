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
// BinarySearchTree.java 
public class BinarySearchTree { 
  // Root node pointer. Will be null for an empty tree. 
  private Node root; 
 

  /* 
   --Node-- 
   The binary tree is built using this nested node class. 
   Each node stores one data element, and has left and right 
   sub-tree pointer which may be null. 
   The node is a "dumb" nested class -- we just use it for 
   storage; it does not have any methods. 
  */ 
  private static class Node { 
    Node left; 
    Node right; 
    int data;

    Node(int newData) { 
      left = null; 
      right = null; 
      data = newData; 
    } 
  }

  /** 
   Creates an empty binary search tree -- a null root pointer. 
  */ 
  public void BinarySearchTree() { 
    root = null; 
  } 
 

  /** 
   Returns true if the given target is in the binary tree. 
   Uses a recursive helper. 
  */ 
  public boolean lookup(int data) { 
    return(lookup(root, data)); 
  } 
 

  /** 
   Recursive lookup  -- given a node, recur 
   down searching for the given data. 
  */ 
  private boolean lookup(Node node, int data) { 
    if (node==null) { 
      return(false); 
    }

    if (data==node.data) { 
      return(true); 
    } 
    else if (data<node.data) { 
      return(lookup(node.left, data)); 
    } 
    else { 
      return(lookup(node.right, data)); 
    } 
  } 
 

  /** 
   Inserts the given data into the binary tree. 
   Uses a recursive helper. 
  */ 
  public void insert(int data) { 
    root = insert(root, data); 
  } 
 

  /** 
   Recursive insert -- given a node pointer, recur down and 
   insert the given data into the tree. Returns the new 
   node pointer (the standard way to communicate 
   a changed pointer back to the caller). 
  */ 
  private Node insert(Node node, int data) { 
    if (node==null) { 
      node = new Node(data); 
    } 
    else { 
      if (data <= node.data) { 
        node.left = insert(node.left, data); 
      } 
      else { 
        node.right = insert(node.right, data); 
      } 
    }

    return(node); // in any case, return the new pointer to the caller 
  }
  
}
