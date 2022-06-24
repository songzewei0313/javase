package dsa.fenzhi;

/**
 * @author szw
 * @date 2022/4/2 15:14
 */
public class HanoiTower {
    static int n;

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
        System.out.printf("共移动%d次", n);
    }

    /**
     * 汉诺塔 指定从A移动到C
     * 采用分治算法 总是将所有盘子看为两个盘子，即最后一个盘子和 上面的所有盘子（看做一个盘子）
     * 分治：分为以下三步
     * 1、将上面的所有盘子移动到B
     * 2、把A塔最后一个盘子移动到C
     * 3、把B塔所有盘子移动到C
     *
     * @param cnt
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int cnt, char a, char b, char c) {
        n++;
        if (cnt == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //问题1：为何要递归呢？ 只是看成一个盘子，实际不是
            //问题2：移动过程中，大盘子不能移动到小盘子上怎么保证的？  看成一个盘子，就没有大小盘子之分
            //把上面的盘子移动到B
            //cnt-1相当于上面所有盘子（看成一个） 实际第一次是要把倒数第二个盘子移动到B
            //此时将b做为c传进去，相当于移动到B塔（规则 a->c ）
            hanoiTower(cnt - 1, a, c, b);
            //这时已经剩下最后一个盘在a塔，移动到C就可以
            System.out.println("第" + cnt + "个盘从 " + a + "->" + c);
            //将B塔所有盘子移动到C，同理
            hanoiTower(cnt - 1, b, a, c);
        }
    }
}
