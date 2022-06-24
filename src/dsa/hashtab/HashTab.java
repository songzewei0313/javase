package dsa.hashtab;

/**
 * 哈希表实现
 *
 * @author szw
 */
public class HashTab {
    /**
     * 链表数组
     */
    private EmpLinkedList[] empLinkedListArr;
    /**
     * 成员变量size，为了遍历EmpLinkedList[] empLinkedListArr 这个数组
     */
    public int size;

    /**
     * 构造函数
     * @param size 大小
     */
    public HashTab(int size) {
        this.size = size;
        this.empLinkedListArr = new EmpLinkedList[size];
        //***注意：此时只是定义了链表数组的大小，并没有初始化链表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        //通过散列函数确定新加入的节点应该加入到哪条链表中
        int i = hashFunction(emp.getId());
        empLinkedListArr[i].add(emp);
    }

    /**
     * 遍历
     */
    public void list() {
        //遍历所有链表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list(i);
        }
    }

    public void findById(int id) {
        int i = hashFunction(id);
        Emp emp = this.empLinkedListArr[i].getById(id);
        if (emp != null) {
            System.out.printf("在第%d 条链表中找到 雇员:名字为： %s\n", (i + 1), emp.getName());
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public void delete(int id) {
        int i = hashFunction(id);
        boolean delete = this.empLinkedListArr[i].delete(id);
        if (delete) {
            System.out.printf("在第%d条链表中删除id为%d的雇员成功\n", i + 1, id);
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 散列函数，根据id判断应处在哪条链表
     * 此函数为：雇员id对size取余运算
     * @return
     */
    private int hashFunction(int id) {
        return id % size;
    }

}
