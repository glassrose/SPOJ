/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


One of the many ways of representing a tree is to have an array(of length same as number of nodes), where each element in the node denotes the parent of that node.	
Eg - 
{-1, 0, 0, 1, 1} would represent a tree with - 
* 0 as root 
* 1 and 2 as children of 0 
* 3 and 4 as children of 1 

Given a similar representation, you have to print reverse level order traversal of the corresponding tree. 
Level order traversal of a tree is where we traverse levels of tree one by one. 

Eg - 
For the above given tree, level order traversal would be - 
0 
1 2 
3 4 
And hence, the reverse level order traversal is - 
3 4 
1 2 
0 
Please note - 
* An element with parent = -1 is the root element. 
* An element with the least index becomes the left most child. (ie. a node with always be on left of all its siblings that have higher index than it) 
* When printing a level of tree you need to maintain left to right order. 
Input Format - 
First line of the input contains number of nodes in the tree (N) 
Next line contains N (space seperated) numbers that denote where i-th number will denote the parent node of i-th node. 

Output Format - 
Print reverse level order traversal of the corresponding tree, with every new level starting in a different line. 
Notes/Limits - 
* 1 <= N <= 50 
* There will be only one root element in any given test case 
* Given numbers will always form a valid undivided tree 
* Output should be in the exact format as specified (including whitespaces) 
Sample Test Cases -	
Input - 
5 
-1 0 0 2 1 
Output - 
4 3 
1 2 
0 

Input - 
9 
8 7 0 5 5 8 7 0 -1 
Output - 
1 6 
2 7 3 4 
0 5 
8 
Input - 
45 
24 42 4 30 29 43 22 15 26 36 26 16 3 22 21 41 18 16 34 41 12 29 32 30 43 15 4 38 36 -1 24 42 18 6 21 38 6 17 32 17 3 
34 12 14 14 
Output - 
1 31 
20 42 9 28 
12 40 33 36 
3 23 37 39 6 13 27 35 
0 30 11 17 22 38 7 25 
5 24 16 32 15 19 
8 10 43 44 18 41 
2 26 14 34 
4 21 
29 

Input - 
33 
17 25 0 14 7 2 5 25 18 8 16 27 10 9 19 7 31 31 19 0 8 14 9 17 18 2 30 16 30 10 5 -1 27 
Output - 
13 22 
26 28 4 15 9 20 
6 30 1 7 3 21 8 24 
5 25 14 18 
12 29 11 32 2 19 
10 27 0 23 
16 17 
31


 */

package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author chandni
 */

class TreeNode<T>
{
    T key;
    ArrayList<TreeNode<T>> children;
    
    public TreeNode (T key)
    {
        this.key = key;
        children = new ArrayList<>();
    }
    
    private static final int indent = 2;
    public String printTree(int increment) 
    {
        String s = "";
        String inc = "";
        for (int i = 0; i < increment; ++i) {
          inc = inc + " ";
        }
        s = inc + key;
        for (TreeNode<T> child : children) {
          s += "\n" + child.printTree(increment + indent);
        }
        return s;
    }
}
public class LayeredBFS {
    static TreeNode []nodeArr;
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String s = br.readLine ();
        int N  = Integer.parseInt (s);
        String nodes[] = br.readLine().split(" ");
        int parentsArr[] = new int[nodes.length];
        for (int i=0;i<nodes.length;i++)
        {
            parentsArr[i] = Integer.parseInt(nodes[i]);
        }
        nodeArr = new TreeNode[parentsArr.length];
        TreeNode<Integer> root = constructTree (parentsArr);
        
        //System.out.println (root.printTree (0));//for testing
        
        //Store layerwise nodes
        ArrayList<ArrayList<TreeNode<Integer>>> layers= new ArrayList<>();
        ArrayList<TreeNode<Integer>> zero = new ArrayList<>();
        zero.add(root);
        layers.add(zero);
        
        for (int i=0;i<layers.size();i++)
        {
            ArrayList<TreeNode<Integer>> prev = layers.get(i);
            if (prev.size()>0)
            {
                ArrayList<TreeNode<Integer>> next = new ArrayList<>();
                for (int prevI = 0; prevI<prev.size(); prevI++)
                {
                    for (int j = 0; j<prev.get(prevI).children.size(); j++)
                        next.add(prev.get(prevI).children.get(j));
                }
                layers.add(next);
            }
        }
        
        //print all node layers from leaves to root
        for (int i=layers.size()-1; i>=0; i--)
        {
            for (int j = 0; j<layers.get(i).size(); j++)
            {
                System.out.print(layers.get(i).get(j).key);
                if (j != layers.get(i).size()-1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static TreeNode<Integer> constructTree(int[] parentsArr) {
        TreeNode<Integer> root = null;
        for (int i=0;i<parentsArr.length;i++)
        {
            if (nodeArr[i] == null)
                nodeArr[i] = new TreeNode<>(i);
            if (parentsArr[i]==-1)
                root = nodeArr[i];
            else
            {
                if (nodeArr[parentsArr[i]]==null)
                    nodeArr[parentsArr[i]]=new TreeNode<> (parentsArr[i]);
                nodeArr[parentsArr[i]].children.add(nodeArr[i]);
            }
        }
        return root;
    }
}
