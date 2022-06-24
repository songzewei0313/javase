package dsa.stack;

/***
 * 用数组实现栈
 * @author songzw
 */
public class ArrayStack {
    /**
     * 最大值（栈的大小）
     */
    private int maxValue;

    /**
     * 数组存储进栈元素
     */
    private int[] array;

    /**
     * 栈顶元素索引初始化为 -1 代表空栈
     */
    private int top = -1;

    /**
     * 初始化栈
     *
     * @param maxValue
     */
    public ArrayStack(int maxValue) {
        this.maxValue = maxValue;
        array = new int[maxValue];
    }

    /**
     * 判断是否是满栈
     *
     * @return
     */
    public boolean isFull() {
        return this.top == maxValue - 1;
    }

    /**
     * 判断是否空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 压栈
     *
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("栈已满，无法再添加数据");
        }
        top++;
        array[top] = val;
    }

    /**
     * 弹栈
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈，无数据");
        }
        int value = array[top];
        top--;
        return value;
    }

    /**
     * 栈的遍历
     */
    public void list() {
        if (!isEmpty()) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("array[%d]=%d\n", i, array[i]);
            }
        }
    }

    /**
     * 长度，注意是top+1，这个长度是指数据的长度，不是指栈的大小
     *
     * @return
     */
    public int length() {
        return top + 1;
    }
}
