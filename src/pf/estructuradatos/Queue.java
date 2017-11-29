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
public class Queue <T> {
    private Node front;
    private Node rear;
    private int size;
    
    public Queue()
    {
        front=rear=null;
        size=0;
    }
    public Queue(T d)
    {
        Node node = new Node(d);
        if(isEmpty())
        {
            front=rear=node;
            size=1;
        }
        else
        {
            rear.next=node;
            rear=node;
            size++;
        }
    }
    public void enqueue(T d)
    {
        Node node = new Node(d);
        if(isEmpty())
        {
            front=rear=node;
            size=1;
        }
        else
        {
            rear.next=node;
            rear=node;
            size++;
        }
    }
    public T dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            Node fd = front;
            front=front.next;
            size--;
            return (T) fd.data;
        }
    }
    public T getFront()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            return (T) front.data;
        }
    }
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public void clearQueue()
    {
        front=rear=null;
        size=0;
    }
    public void showQueue()
    {
        System.out.print("front->");
        Node p = front;
        if(p==null)
        {
            System.out.print("NULL");
        }
        while(p!=null)
        {
            p=p.next;
        }
        System.out.print("<-rear");
        System.out.println("");
    }
}
