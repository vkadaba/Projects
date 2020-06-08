// Assignment #: 10
//         Name: Vishnu Kadaba
//    StudentID: 1217459815
//  Lab Lecture: Tu Th 1:30-2:45PM
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
			
		
   }

   //only instance variable that points to the first node.
   private Node first;
 
   //LinkedList list2 = new LinkedList();

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;	
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   //additional elements 
   public int size()
   {
	  int size=0;
	  Node temp = first;
	  while(temp!=null)
	  {
		  size++;
		  temp=temp.next;	
	  }
	  return size;
   }
   
   public void addElement(Object element)
   {
	   Node newElem = new Node();
	   newElem.data=element;
	   if(first==null)
	   {
		   newElem.next=null;
		   first=newElem;
		   return;		   
	   }
	   else if(element.toString().compareTo(first.data.toString())<0)
	   {
		   newElem.next=first;
		   first=newElem;
	   }
	   else
	   {
		   Node temp1=first.next;
		   Node temp2=first;
		   while(temp1!=null)
		   {
			   if(element.toString().compareTo(temp2.data.toString())<0)
				   break;
			   temp1=temp2;
			   temp2=temp2.next;
			   
		   }
		   newElem.next=temp2.next;
		   temp2.next=newElem;
	   }
	   
   }
   
   public void removeElementsAtEvenIndices()
   {
	   int counter=0;
	   ListIterator i=new LinkedListIterator();
	   while(i.hasNext())
	   {
		   i.next();
		   if((counter%2)==0)
		   {
			   i.remove();
		   }
		   counter++;
	   }
   }
   
   public int indexOfLast(Object strin)
   {
	   int index=0;
	   int strinIndex=1;
	   if(first==null)
	   {
		   throw new NoSuchElementException();
	   }
	   else
	   {
		   Node temp = first;
		   while(temp!=null)
		   {
			   String temp2=temp.data.toString();
			   int counter=strin.toString().compareTo(temp2);
			   if(counter==0)
				   strinIndex=index;
			   index++;
			   temp=temp.next;
		   }
		   return strinIndex;
	   }
   }
   
   public void duplicateEach()
   {
	   Node temp = first;
	   Node temp2 = first;
	   while(temp2!=null)
	   {
		   String s = temp2.data.toString();
		   Node temp3= new Node();
		   temp3.data=s;
		   temp3=temp.next;
		   temp.next=temp3;
		   temp=temp2;
		   
	   }
   }
   
   
   public Object removeElementAt(int index) throws IndexOutOfBoundsException
   {
	Node temp=this.first;
	int size=0;
	while(temp!=null)
	{
		temp=temp.next;
		size++;
	}
	if(size<=index)
	{
		throw new IndexOutOfBoundsException();
	}
	if(index==0)
	{
		Node remove=this.first;
		this.first=this.first.next;
		return remove.data;
	}
	temp=this.first;
	for(int i=0;i<index-1;i++)
	{
		temp=temp.next;
	}
	Node remove=temp.next;
	temp.next=temp.next.next;
	return remove.data;
			 
   }
   
   public int howManyAppearBefore(Object element)
   {
	   String s = element.toString();
	   int count=0;//for counting previous elements
       Node current = first;//setting the head
       while (current != null) {//looping till there is no element left
           if (current.data.toString().equalsIgnoreCase(s))//finding the element
               return count;//returning the number of previus element before the object
           count++;//increasing count
           current = current.next;//changing current
       }
       return -1;//whne the element is not found
   }
   
   
   public String toString()
   {
	   String output="{ ";
	   if(first==null)
		   return "{ }";
	   Node temp=first;
	   while(temp!=null)
	   {
		   output+=temp.data.toString()+"";
		   temp=temp.next;
	   }
	   return output+" }\n";
   }


   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class
