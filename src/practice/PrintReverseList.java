/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practice;

import java.io.IOException;

/**
 *
 * @author Admin
 */
class SinglyLinkedList<T>
{

    class SinglyLinkedListNode<T>
    {
        T data;
        SinglyLinkedListNode next;
        public SinglyLinkedListNode (T data)
        {
            this.data = data;
        }
    }
    
    SinglyLinkedListNode last;
    SinglyLinkedListNode root;
    int size;
    public void add (T data)
    {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode<T>(data);
        if (last==null)
            last = newNode;
        else
        {
            last.next = newNode;
            last = last.next;
        }
        size++;
        if (size==1)
            root = last;
    }
    
    public void printReverseList ()
    {
        SinglyLinkedListNode rootCopy = root;
        printReverse (rootCopy);
    }
    
    private void printReverse(SinglyLinkedListNode root) {
        if (root==null)
            return;
        
        printReverse(root.next);
        System.out.println (root.data.toString());
    }
}
public class PrintReverseList {
    public static void main (String args[]) throws IOException
    {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<Integer>();
        ll.add(4);
        ll.add(6);
        ll.add(5);
        ll.add(2);
        ll.add(66);
        ll.printReverseList();
        
        SinglyLinkedList<Integer> ll2 = new SinglyLinkedList<Integer>();
        ll2.printReverseList();
    }
}
