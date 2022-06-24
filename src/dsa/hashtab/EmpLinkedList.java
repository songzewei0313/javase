package dsa.hashtab;

/**
 * 雇员链表类
 *
 * @author szw
 */
public class EmpLinkedList {
    private Emp head;

    /**
     * 规定，新增雇员时id是自增的（简单一点），主要是实现哈希表
     *
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getId() > emp.getId()) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(emp);
    }

    /**
     * 这个遍历，其实不需要传任何参数的，传no只是为了打印第几条链表的信息，方便看
     *
     * @param no
     */
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf(" =>emp{id=%d name=%s}", curEmp.getId(), curEmp.getName());
            if (curEmp.getNext() == null) {
                break;
            }
            curEmp = curEmp.getNext();
        }
        System.out.println();
    }

    public Emp getById(int id) {
        if (head == null) {
            System.out.println("空链表");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.getId() == id) {
                break;
            }
            if (curEmp.getNext() == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.getNext();
        }
        return curEmp;
    }

    /**
     * 根据id删除雇员
     * @param id
     * @return true说明成功删除，false删除失败
     */
    public boolean delete(int id) {
        //如果第一个节点为空，直接返回false
        if (head == null) {
            return false;
        } else if (head.getId() == id && head.getNext() == null) {
            //如果第一个雇员就是我们要删除的，并且后面再没有一个雇员，把head设置成null，并且返回true
            head = null;
            return true;
        } else if (head.getId() == id && head.getNext() != null) {
            //如果第一个雇员就是我们要删除的，并且后面还有雇员，那么head不能直接设置成null，
            //这时把head重置（即重置第一个雇员为下一个雇员），重置成下一个雇员 ==》相当于删掉了第一个雇员
            head = head.getNext();
            return true;
        } else if (head.getId() != id && head.getNext() == null) {
            //如果第一个不是要删除的，并且后面没有雇员了，那么返回false
            return false;
        } else {
            //其余情况：借助临时变量curEmp遍历去找需要删除的雇员
            Emp curEmp = head;
            boolean flag = false;
            while (true) {
                //为什么要判断当前雇员的下一个雇员？ 因为如果当前雇员是要删除的，没办法借助curEmp删除当前雇员（即没办法自己删除自己），因为这是单链表，没有前驱指针
                //如果当前雇员的下一个雇员的就是要删除的，把标记变量设成true
                if (curEmp.getNext().getId() == id) {
                    flag = true;
                    break;
                }
                if (curEmp.getNext() == null) {
                    break;
                }
                curEmp = curEmp.getNext();
            }
            if (flag) {
                //并且把当前雇员的下一个雇员重新设置成当前雇员的下一个雇员的下一个雇员（因为当前雇员的下一个雇员要被删除）
                curEmp.setNext(curEmp.getNext().getNext());
                return true;
            } else {
                System.out.printf("在链表中没有找到id为%d\n的雇员", id);
                return false;
            }
        }
    }
}
