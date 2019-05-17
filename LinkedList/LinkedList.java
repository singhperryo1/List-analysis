/*
Singh, Gagandeep
 */
package LinkedList;

/**
 *
 * @author Singh Gagan
 */
public class LinkedList {
    public static void main(String[] args) {
    
        Node oneElement = new Node();
        oneElement.data = 25;
        oneElement.next = null;
        
        Node anotherElement = new Node();
        anotherElement.data = 35;
        anotherElement.next = oneElement;
        
        System.out.println(anotherElement);
        System.out.println(oneElement);
        
        LinkedList l = new LinkedList();
        l.insert(25);
        l.insert(5);
        l.insert(15);
        l.insert(35);
        l.append(90);
        System.out.println(l);
        
        System.out.println(l.search(15));
        System.out.println(l.search(20));
        
        System.out.println(l.update(15,20));
        System.out.println(l);
        System.out.println(l.update(18,28));
        System.out.println(l);

        System.out.println(l.delete(15));
        System.out.println(l);
        System.out.println(l.delete(35));
        System.out.println(l);
        System.out.println(l.delete(5));
        System.out.println(l);

    }
    
}
