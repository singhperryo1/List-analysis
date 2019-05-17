/*
 Singh, Gagandeep
 */
package LinkedList;

/**
 *
 * @author Singh Gagan
 */
public class LinkedList {
    
    public Node head;
    
    public LinkedList()
    {
        head = null;
    }
    public void insert(int value)
    {
	Node newNode = new Node();
	newNode.data = value;
	newNode.next = head;
	head = newNode;
    }
    public void append(int value)
    {
	Node newNode = new Node();
        newNode.data = value;
	newNode.next = null;

        if (head == null)
            head = newNode;
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }
    public Node search(int value)
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.data == value)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    public boolean update(int oldValue, int newValue)
    {
        Node temp = search(oldValue);

        if (temp == null)
            return false;

        temp.data = newValue;
        return true;
    }
    
    public boolean delete(int value)
    {
        Node current = head;

        // case 1
        if (current == null)
            return false; 					

        // case 2
        if (current.data == value)
        {
            head = current.next;
            current = null;
            return true;
        }
        // case 3
        current = head.next;
        Node previous = head;
        while (current != null)
        {
            if (current.data == value)
            {
                previous.next = current.next;
                current = null;
                return true;
            }
            current = current.next;
            previous = previous.next;
        }

        return false;
    }

}
