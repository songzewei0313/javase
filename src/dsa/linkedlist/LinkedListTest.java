package dsa.linkedlist;

/**
 * @author szw
 */
public class LinkedListTest {
    public static void main(String[] args) {
        BookNode bookNode1 = new BookNode(1,"三国演义",30.00);
        BookNode bookNode2 = new BookNode(2,"水浒传",40.00);
        BookNode bookNode3 = new BookNode(3,"红楼梦",50.00);
        BookNode bookNode4 = new BookNode(4,"西游记",33.00);
        SingleLinkedList list = new SingleLinkedList();
        list.add(bookNode1);
        list.add(bookNode2);
        list.add(bookNode3);
        list.add(bookNode4);
        list.deleteNode(1);
        list.list();
        System.out.println(list.getLength());
    }
}
