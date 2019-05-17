/*
Singh, Gagan 
 */
package dedll; 
public class DEDLL {

    public static void main(String[] args) {
//for testing purpose
List b = new List(); 
//--------------------------//
b.append(0);
b.insertFront(789);
b.insertFront(450);
b.append(96);
b.insertFront(120);
//------------------------//
b.printForward();
b.reverse();
b.printForward();
b.printMiddle();
b.delete(0);
//------------------------//
b.append(120);
b.insertFront(789);
b.insertFront(450);
//------------------------//
b.printForward();
b.removeDuplicates();
b.printForward();
b.deleteAll();
}
}