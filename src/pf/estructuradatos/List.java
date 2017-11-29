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
public class List<T> {
    Node first;
    Node last;
    Node pointer;
    int length;
    
    public List()
    {
        first=null;
        last=null;
        pointer=null;
        length=0;
    }
    public List (T data)
    {
        Node node = new Node(data);
        first = node;
        last = node;
        node.next = null;
        length++;
    }
    public Node getPointer()
    {
        return pointer;
    }
    public boolean isEmpty()
    {
        return first==null;
    }
    public void insertFirst(T d)
    {
        Node node = new Node(d);
        if(isEmpty())
        {
            first = node;
            last = node;
            node.next=null;
            
        }
        else
        {
            node.next=first;
            first=node;
        }
        length++;
    }
    public void insertLast(T d)
    {
        Node node = new Node(d);
        if(isEmpty())
        {
            first = node;
            last = node;
            node.next=null;
        }
        else
        {
            last.next = node;
            last = node;
        }
        length++;
    }
    public void deleteFirst()
    {
        if(!isEmpty())
        {
            if(first.next==null)
            {
                first=null;
                last=null;
            }
            else
            {
                first=first.next;
            }
        }
        length--;
    }
    public void deleteLast()
    {
        if(!isEmpty())
        {
            if(first==last)
            {
                first=last=null;
            }
            else
            {
                pointer=first;
                while(pointer.next!=last)
                {
                    pointer=pointer.next;
                }
                last = pointer;
                last.next = null;
                pointer = null;
            }
        }
        length--;
    }
    //Eliminar nodo
    public boolean deleteNode(T n)
    {
       Node p=fetchBack(n);
       if(p!=null)
       { 
            if(p.data==n)
            { 
                deleteFirst();
            }
            else if(fetch(n)==last.data)
            {
                deleteLast();
            }
            else
            { 
                p.next=p.next.next;       
                length--;     
            }
       return true;
       }
    return false;    
    }
    
    public Node fetch(T n)
    {
        if(!isEmpty())
        {
            if(first.data==n)
            {
                return first;
            }
            else
            {
                Node node = fetchBack(n); //Uses fetchBack to receive the node before the one we're searching for.
                if(node!=null) //If it it doesn't return null, it means it has found it.
                {
                    return node.next; //Then, sends the next one so we receive the actual node
                }   
            }
        }
        return null;
    }
    public Node fetchBack(T n)
    {
        pointer=first;
        if(!isEmpty())
        {
            if(first==last)
            {
                if(first.data==n)
                {
                    return first;
                }
                else
                { 
                    return null;
                }
            }
            else
            {
                if(first.data==n)
                {
                  return first;
                }
                else
                {
                    pointer=first;
                    int i=0;
                    while(pointer.next!=null)
                    {
                        if(pointer.next.data==n)
                        {
                            return pointer; 
                        }
                        pointer=pointer.next;
                    } 
                }   
            }
        }
        return null;
    }
    public void showlist()
    {
        pointer=first;
        System.out.print("first ->");
        for (int i=0;i<length;i++)
        {
            System.out.print("["+pointer.data.toString()+"]->");
            pointer=pointer.next;
        }
        System.out.println("<-last");
    }
}