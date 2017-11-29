/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pf.estructuradatos;

/**
 *
 * @author Salvador
 */
public class Stack <T> 
{
    Node <T> top;
    int size;
    
    public Stack()
    {
        top = null;
        size = 0;
    }
    public Stack(T d)    
    {
        Node <T> node = new Node (d);
        top = node;
        size = 1;
    }
    public void push(T d)
    {
        Node <T> node = new Node(d);
        node.next=top;
        top = node;
        size++;
    }
    public T pop()
    {
        T d;
        if(!isEmpty())
        {
            d = top.data;
            top = top.next;
            size--;
        }
        else
        {
            d = null;
        }
        return d;
    }
    public T getTop()
    {
        if(!isEmpty())
        {
            return top.data;
        }
        else
        {
            return null;
        }
    }
    public void showStack()
    {
        Node <T> t = top;
        while(t!=null)
        {
            
            t=t.next;
        }
        System.out.println("NULL");
    }
    public boolean isEmpty()
    {
        return size==0;
    }
}
