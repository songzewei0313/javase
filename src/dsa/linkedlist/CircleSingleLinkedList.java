package dsa.linkedlist;

/**
 * 环形链表
 * @author szw
 */
public class CircleSingleLinkedList {
    /**
     * 先定义第一个节点，默认为null
     */
    private Boy first = null;

    /**
     * 构建一个环形链表
     */
    public void create(int nums) {
        if (nums < 1) {
            System.out.println("nums不正确，数量至少为1");
            return;
        }
        Boy cur = null;
        //通过for循环创建节点 注意i从1开始，因为编号要>0，然后<=nums，不然创建的节点数会少
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果只有一个节点，这一个节点也要指向自己，成为一个环形
            if (i == 1) {
                first = boy;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(boy);
                //新加进来的节点，他的next永远指向第一个节点
                boy.setNext(first);
                //把当前节点指针移动到（指向）刚添加进来的节点
                cur = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void list() {
        if (first == null) {
            System.out.println("空的环形链表");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.printf("小孩的编号 %d\n", cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * @param startNo 表示从第几个小孩开始数数
     * @param cntNum  表示数到几
     * @param nums    表示最初有多少个小孩
     */
    public void count(int startNo, int cntNum, int nums) {
        //第一步，先对参数做个校验，满足合理性
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("数据不合理");
            return;
        }
        //创建一个辅助节点，指向圈中最后一个节点，帮助我们让小孩出圈
        Boy helper = first;
        while (true) {
            //这时说明helper指向了圈中最后一个节点
            // （即真正让helper指向了圈中最后一个节点，因为helper下一个节点是first，说明helper指向最后一个节点）
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //startNo从谁开始数，first和helper要移动startNo - 1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        int i = 0;
        //小孩出圈,肯定是个循环，当剩下最后一个小孩结束
        while (true) {
            //此时剩下最后一个小孩
            if (helper == first) {
                break;
            }
            //（数数）循环移动cntNum-1次，每次移动一下
            for (int j = 0; j < cntNum - 1; j++) {
                //移动一下
                first = first.getNext();
                helper = helper.getNext();
            }
            //数数就++;
            i++;
            //说明first 经过数数（移动cntNum-1）移动后指向的就是要出圈的小孩
            System.out.printf("第%d次出圈的小孩编号为 %d\n", i, first.getNo());
            //这个很好理解，小孩出圈-> first指向下一个小孩，（first.next）
            first = first.getNext();
            //把helper的下一个节点指向新的first节点，之前的first已经出圈了
            helper.setNext(first);
        }
        System.out.printf("最后在圈内的小孩编号为 %d\n", first.getNo());
    }
}
