package dsa.linkedlist;

/**
 * @author szw
 */
public class CircleSingleLinkedListTest {
    /**
     * 约瑟夫环测试，以从第一个小孩开始数，数两下出圈，总共有五个小孩
     *
     * @param args
     */
    public static void main(String[] args) {
        //第一步先创建环形链表
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.create(5);
        //circleSingleLinkedList.list();

        circleSingleLinkedList.count(1,2,5);
    }
}
