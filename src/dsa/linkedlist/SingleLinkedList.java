package dsa.linkedlist;

/**
 * 单链表
 *
 * @author songzw
 */
public class SingleLinkedList {
    /**
     * 头节点
     */
    BookNode head = new BookNode(0, "", 0.00);

    /**
     * 添加节点
     *
     * @param bookNode
     */
    public void add(BookNode bookNode) {
        BookNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = bookNode;
    }

    public void addNodeOrder(BookNode bookNode) {
        BookNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > bookNode.id) {
                flag = true;
                break;
            } else if (temp.next.id == bookNode.id) {
                throw new RuntimeException("已存在为此id的节点，不能再添加相同id的节点...");
            }
            temp = temp.next;
        }
        if (flag) {
            bookNode.next = temp.next;
        }
        temp.next = bookNode;
    }

    /**
     * 根据节点id修改目标节点
     *
     * @param bookNode
     */
    public void update(BookNode bookNode) {
        if (head.next == null) {
            System.out.println("链表为空...");
            return;
        }

        BookNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == bookNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = bookNode.name;
            temp.price = bookNode.price;
        } else {
            System.out.println("未找到目标节点...");
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    public void deleteNode(int id) {
        BookNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("未找到要删除的目标节点...");
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("空链表...");
            return;
        }
        BookNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int getLength() {
        if (head.next == null) {
            return 0;
        }
        BookNode temp = head.next;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
