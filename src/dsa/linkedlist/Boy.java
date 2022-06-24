package dsa.linkedlist;

/**
 * 代表环形链表的节点
 * @author songzw
 */
public class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return this.no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
