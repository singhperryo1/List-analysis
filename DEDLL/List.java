/*
 Singh, Gagandeep
Data Structures Project-1
 */
package dedll;

/**
 *
 * @author Singh Gagan
 */
public class List {
    private int currentSize; 
    private Node head; 
    private Node tail;
    public void setHead(Node head)      //setter for head 
    {
        this.head = head; 
    }
    public void setTail(Node tail)     //setter for tail 
    {
        this.tail= tail; 
    }
    public void setSize(int currentSize)     //setter for size
    {
     this.currentSize= currentSize;    
    }    
    public Node getHead()      //getter for head 
    {
        return head; 
    }
    public Node getTail()     //getter for tail
    {
        return tail; 
    }
    public int getSize()     //getter for size
    {
        return currentSize;  
    }
     public List()          //default contstructor, name changed 
     {
         setHead(null);  
         setTail(null);  
         setSize(0);  
     }
     
     public void insertFront(int n)
     {
         Node newNode = new Node();
           newNode.previous= null;     
           newNode.data = n ;        
      if(getSize()==0)          //when list is empty  
      {
          newNode.next= null; 
          setHead(newNode);     //tail points to the newNode
          setTail(newNode);     //head points to the newNode
      }
      else{
      Node temp = head;         //when list is not empty     
      newNode.next = temp;
      temp.previous = newNode;  
      setHead(newNode);  
      }
      setSize(++currentSize); 
     }
     public void append (int n)
     {
         Node newNode = new Node(); 
         newNode.data= n ; 
         newNode.next = null ;     //inserting at end means next will go null always
         if(getSize()==0)         // list is empty
         {
             newNode.previous = null; 
             setHead(newNode); 
            setTail(newNode); 
         }
         else
         {
         Node temp = tail;        //when list is not empty 
         temp.next = newNode; 
         newNode.previous= temp; 
         setTail(newNode); 
         }
           setSize(++currentSize);  
     }
     public Node search(int n)
     {
         if(getSize()==0)           //case 1, when the list is empty 
             return null;
         Node headStart = head;     //case 2, when the list in not-empty
         Node tailStart = tail; 
         while(headStart!=tailStart)  
         {
             if(headStart.data==n)
                 return headStart;
             if(tailStart.data==n)
                 return tailStart;
             headStart = headStart.next; 
             tailStart = tailStart.previous;
         }
           if(headStart.data==n)        //when currentSize is odd
                 return headStart;
         return null;                   //when n is not found in list
     }
     public boolean update (int o, int n)
     {
         Node temp = search(o); 
       if(temp==null)
           return false ; 
       
       temp.data=n; 
       return true; 
     }
     public boolean delete (int n)
     {
         if(getSize()==0)                      //case 1, when list is empty 
             return false;
         if(getSize()==1)
         {
             if(getHead().data==n)            //case 2, when there is one node
             {
             setHead(null); 
             setTail(null) ; 
             setSize(--currentSize); 
             return true;
             }
             return false;                  // n is not found when currentSize is 1
         }
         
               Node headStart = head;      //when currentSize>1
               Node tailStart = tail;
             if(headStart.data==n)         //when n is in first node
             {
                 Node temp = headStart; 
                 headStart = headStart.next; 
                 temp = null;
                setHead(headStart); 
                 head.previous = null; 
                 setSize(--currentSize);
                 return true; 
             }
             
               if(tailStart.data== n)     //when n is in the last node 
             {
                  Node temp = tailStart;
                  tailStart = tailStart.previous;
                  temp = null; 
                 setTail(tailStart); 
                 tailStart.next= null; 
                   setSize(--currentSize); 
                   return true; 
             }
           
        headStart = headStart.next;      //to avoid second check iteration for head and tail
        tailStart = tailStart.previous;  
        while(headStart!=tailStart)
        {
            if(headStart.data==n)         
            {
                Node temp = headStart; 
                headStart = headStart.next;
                head.next= headStart; 
                headStart.previous= head; 
                temp = null; 
                setSize(--currentSize); 
                return true; 
            }
            if(tailStart.data==n)    
            {
            Node temp = tailStart; 
            tailStart = tailStart.previous;
            tail.previous = tailStart;
            tailStart.next= tail; 
            temp = null;
            setSize(--currentSize); 
            return true; 
            }
            headStart = headStart.next;      //traverse headStart to next 
            tailStart= tailStart.previous;   //traverse tailStart to previous
        }
             if(headStart.data==n)           //when headStart == tailStart 
            {
              headStart = headStart.previous; 
              Node temp = tailStart.next;
              headStart.next = temp; 
              temp.previous = headStart; 
                tailStart = null; 
                 setSize(--currentSize); 
                return true; 
            }  
            
       return false ;                      //when n is not in list
     }   
     
     public void printSize()
     {
         System.out.print("The size of the list is: ");
         System.out.println(getSize());
     }
     public void printHead()
     {
         if(getSize()==0)               //when the list is empty, the currentSize is 0 
             System.out.println("Empty List"); 
         
         System.out.print("The head of the list contains: ");
         System.out.println(head.data);
     }
     public void printTail()
     {
         if(getSize()==0)              //when the list is empty, the currentSize is 0 
             System.out.println("Empty List"); 
         
         System.out.print("The tail of the list contains: "); 
         System.out.println(tail.data); 
     }
     public void printForward()
     {
         if(getSize()==0)             //when the list is empty 
                System.out.print("Empty List"); 
         Node headStart = head;
         while(headStart!=null)
         {
             System.out.print(headStart.data+" ");    //used -> to make it visually good 
             headStart = headStart.next ; 
         }
         System.out.println();       //to make it look good 
     }
     public void printReverse()
     {
          if(getSize()==0)           //when the list is empty 
                System.out.print("Empty List"); 
          Node tailStart = tail; 
          while(tailStart!=null)
          {
              System.out.print(tailStart.data+" ");
              tailStart = tailStart.previous; 
          }
         System.out.println();     //to make it look good 
     }
     /*Extended Functions */
     public void printMiddle()
     {
         if(getSize()==0)         //case 1, when list is empty 
             System.out.println("Empty List");
        if(getSize()==1 ||getSize()==2)         //case 2, when list has only 1 node or two nodes 
            System.out.println(head.data);
                                      //case 3, when currentSize>2
                                   //list can have odd or even no of nodes, the following cases arises
       int middle ;                //the middle node of the list 
       if(getSize()%2==0)         //to check if its even or odd
         middle = getSize()/2;
       else
           middle = 1+ (getSize()/2); 
    Node headStart = head;
    int count =1 ; 
    while(count<=(middle))
            {
                  if(count==middle)
            {
                System.out.println(headStart.data);
            }
            headStart = headStart.next;
            count++; 
            }
     }
     public void removeDuplicates()
     {
     if(getSize()==0) //list is empty
       {
           System.out.println("No duplicates found, the list is Empty!");
           return; 
       }
    Node curo = head;
    Node trav = tail; 
    while(curo!=null)
    {
        int d = curo.data; 
   while(trav!=curo)
   {
    if(trav.data==d)
    {
       if(trav.next==null)
       { 
        tail = trav.previous;  
        Node temp = trav; 
        trav = trav.previous; 
        trav.next = null;
        temp.previous = null; 
        temp = null; 
        currentSize--; 
       }
       else
           {
                   Node temp = trav; 
                   Node temp2 = trav.next; 
                   trav = trav.previous; 
                   trav.next = temp2;
                   temp2.previous = trav; 
                   temp = null; 
                   currentSize--; 
           }
       }
       else
           trav = trav.previous; 
   }
   trav = tail;
   //if(curo.next==null)
     //  break; 
        curo = curo.next;     
    }
     }

       
public void deleteAll()
     {
         if(getSize()==0)
         {
             System.out.println("List is Empty");
             return ;              //to avoid JavaNullPtrException  
         }
         Node headStart = head; 
         Node tailStart = tail; 
         while(headStart!=tailStart)  
         {
          
             System.out.println("Removed " + headStart.data);
             delete(headStart.data);   
             headStart = headStart.next; 
         }
         System.out.println("Removed " +headStart.data);
         setHead(null); 
         setTail(null);  
         setSize(0);  
     }
     public void reverse()
     {
         if(getSize()==0)
             System.out.println("List is Empty!");
         Node headStart = head; 
         Node tailStart = tail;
        int count = 1; 
         while(count<=(getSize()/2))           
         {
             Node temp = new Node(); 
             temp.data= tailStart.data; 
             tailStart.data=headStart.data;
             headStart.data= temp.data;
             tailStart = tailStart.previous; 
             headStart = headStart.next;
             count++; 
         }
     }
}
